package com.labweb.action;

import java.util.ArrayList;
import java.util.List;

import com.labweb.dao.IProjectDao;
import com.labweb.dao.impl.ProjectDaoImpl;
import com.labweb.model.Project;

public class ProjectAction extends PageBaseAction<Project>{
	private static final long serialVersionUID = 1L;
	private IProjectDao projectDao=null;
	private Project project;
	
	public ProjectAction(){
		super(ProjectDaoImpl.class,10);
		projectDao=(ProjectDaoImpl)dao;
	}
	
	public void setProject(Project project){
		this.project=project;
	}
	
	public Project getProject(){
		return project;
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

	@Override
	public String getById() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(project.getProjectId());
		setResultMesg(projectDao.getProject(paramList));
		return SUCCESS;
	}
}
