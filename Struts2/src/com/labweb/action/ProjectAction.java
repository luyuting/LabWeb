package com.labweb.action;

import java.util.ArrayList;
import java.util.List;

import com.labweb.dao.IProjectDao;
import com.labweb.dao.factory.DaoFactory;
import com.labweb.model.Project;

public class ProjectAction extends PageBaseAction<Project>{
	private static final long serialVersionUID = 1L;
	private IProjectDao projectDao=DaoFactory.getProjectDaoInstance();
	private Project project=new Project();
	
	public ProjectAction(){
		setNumPerPage(10);
	}
	
	public void setProjcetId(String projectId){
		this.project.setProjectId(projectId);
	}
	
	public void setProjcetPic(String projectPic){
		this.project.setProjectPic(projectPic);
	}
	
	public void setProjcetName(String projectName){
		this.project.setProjectName(projectName);
	}

	public void setProjcetContent(String projectContent){
		this.project.setProjectContent(projectContent);
	}
	
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		this.setResultMesg(projectDao.doSelect(selectParamList()),
				projectDao.doCount());
		return SUCCESS;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(project.getProjectPic());
		paramList.add(project.getProjectName());
		paramList.add(project.getProjectContent());
		paramList.add(project.getProjectId());
		setResultMesg(projectDao.doUpdate(paramList), "¸üÐÂ");
		return SUCCESS;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(project.getProjectPic());
		paramList.add(project.getProjectName());
		paramList.add(project.getProjectContent());
		setResultMesg(projectDao.doInsert(paramList), "²åÈë");
		return SUCCESS;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(project.getProjectId());
		setResultMesg(projectDao.doDelete(paramList), "É¾³ý");
		return SUCCESS;
	}
}
