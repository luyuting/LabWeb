package com.labweb.action;

import java.util.*;

import com.labweb.dao.factory.DaoFactory;
import com.labweb.model.Project;
import com.opensymphony.xwork2.ActionSupport;

public class ProjectAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int pageIndex;
	private int numPerPage=10;
	private Map<String,Object> projectMap=new HashMap<String,Object>();
	
	public void setPageIndex(int pageIndex){
		this.pageIndex=pageIndex;
	}
	
	public int getPageIndex(){
		return pageIndex;
	}
	
	public Map<String,Object> getProjectMap(){
		return projectMap;
	}
	
	public String execute(){
		List<Project> projectList=DaoFactory.getProjectDaoInstance().getPageProjectList(pageIndex,numPerPage);
		int projectCount=DaoFactory.getProjectDaoInstance().getAcount();
		int projectPage=projectCount/numPerPage;
		if(projectCount%numPerPage!=0)
			projectPage++;
		projectMap.put("projectList", projectList);
		projectMap.put("projectCount", projectCount);
		projectMap.put("projectPage", projectPage);
		projectMap.put("projectPageIndex", pageIndex);
		return SUCCESS;
	}
}
