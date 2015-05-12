package com.labweb.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.labweb.dao.IFileDao;
import com.labweb.dao.impl.FileDaoImpl;
import com.labweb.model.UploadFile;

public class FileAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private IFileDao fileDao=null;
	private UploadFile uploadFile;
	
	private List<File> uploadFiles;
	private List<String> uploadFilesFileName;
	private String[] targetFileNames;
	private String targetFileDir;
	private int filesCount;
	
	public void setUploadFile(UploadFile uploadFile){
		this.uploadFile=uploadFile;
	}
	
	public UploadFile getUploadFile(){
		return uploadFile;
	}
	
	public void setUploadFiles(List<File> uploadFiles){
		this.uploadFiles=uploadFiles;
	}
	
	public void setUploadFilesFileName(List<String> uploadFilesFileName){
		this.uploadFilesFileName=uploadFilesFileName;
	}
	
	public void setTargetFileDir(String targetFileDir){
		this.targetFileDir=targetFileDir;
	}
	
	public FileAction(){
		super(FileDaoImpl.class);
		fileDao=(FileDaoImpl)dao;
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		setResultMesg(fileDao.doSelect(null));
		return SUCCESS;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		if(uploadFiles!=null){
			String serverRealPath=ServletActionContext.getServletContext().getRealPath(targetFileDir);
			File dir=new File(serverRealPath);
			
			if(!dir.exists())
				dir.mkdir();
			filesCount=uploadFiles.size();
			targetFileNames=new String[filesCount];
			for(int i=0;i<filesCount;i++){
				List<Object> paramList=new ArrayList<Object>();
				targetFileNames[i]=uploadFilesFileName.get(i);
				paramList.add(targetFileNames[i]);
				paramList.add(targetFileDir+"/"+targetFileNames[i]);
				File targetFile=new File(serverRealPath,targetFileNames[i]);
				try {
					FileUtils.copyFile(uploadFiles.get(i), targetFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fileDao.doInsert(paramList);
			}
			addActionMessage("upload success! "+filesCount+" files in total");
		}
		else
			addActionError("upload failed,choose files");
		return SUCCESS;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(uploadFile.getFileId());
		this.setResultMesg(fileDao.doDelete(paramList), "É¾³ý");
		return SUCCESS;
	}
	
	public String download(){
		return SUCCESS;
	}
	
	public InputStream getInputStream(){
		try {
			uploadFile.setFileName(new String(uploadFile.getFileName().getBytes(), "ISO8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ServletActionContext.getServletContext().getResourceAsStream(uploadFile.getFilePath());
	}
}
