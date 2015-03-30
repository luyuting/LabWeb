package com.labweb.model;

import java.util.List;

public class Project extends BaseModel{
	private static final long serialVersionUID = 1L;
	private String projectId;
	private String projectPic;
	private String projectName;
	private String projectContent;
	private String projectTime;
	
	public void setProjectId(String projectId){
		this.projectId=projectId;
	}
	
	public String getProjectId(){
		return projectId;
	}
	
	public void setProjectPic(String projectPic){
		this.projectPic=projectPic;
	}
	
	public String getProjectPic(){
		return projectPic;
	}
	
	public void setProjectName(String projectName){
		this.projectName=projectName;
	}
	
	public String getProjectName(){
		return projectName;
	}
	
	public void setProjectContent(String projectContent){
		this.projectContent=projectContent;
	}
	
	public String getProjectContent(){
		return projectContent;
	}
	
	public void setProjectTime(String projectTime){
		this.projectTime=projectTime;
	}
	
	public String getProjectTime(){
		return projectTime;
	}
	
	public Project(){
	}
	
	public Project(List<String> list){
		this.projectId=list.get(0);
		this.projectPic=list.get(1);
		this.projectName=list.get(2);
		this.projectContent=list.get(3);
		this.projectTime=list.get(4);
	}
}
