package com.labweb.model;

import java.util.List;

public class UploadFile extends BaseModel{
	private static final long serialVersionUID = 1L;
	private String fileId;
	private String fileName;
	private String filePath;
	private String fileTime;
	
	public void setFileId(String fileId){
		this.fileId=fileId;
	}
	
	public String getFileId(){
		return fileId;
	}

	public void setFileName(String fileName){
		this.fileName=fileName;
	}
	
	public String getFileName(){
		return fileName;
	}
	
	public void setFilePath(String filePath){
		this.filePath=filePath;
	}
	
	public String getFilePath(){
		return filePath;
	}
	
	public void setFileTime(String fileTime){
		this.fileTime=fileTime;
	}
	
	public String getFileTime(){
		return fileTime;
	}
	
	public UploadFile(){
		
	}
	
	public UploadFile(List<String> list){
		this.fileId=list.get(0);
		this.fileName=list.get(1);
		this.filePath=list.get(2);
		this.fileTime=list.get(3);
	}
	
}
