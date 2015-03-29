package com.labweb.model;

public class Project {
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
	
	public Project(String projectId,String projectPic,String projectName,String projectContent,String projectTime){
		this.projectId=projectId;
		this.projectPic=projectPic;
		this.projectName=projectName;
		this.projectContent=projectContent;
		this.projectTime=projectTime;
	}
}
