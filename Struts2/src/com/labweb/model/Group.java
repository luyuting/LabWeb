package com.labweb.model;

public class Group {
	private String groupId;
	private String groupPic;
	private String groupName;
	private String groupIntro;
	
	public void setGroupId(String groupId){
		this.groupId=groupId;
	}
	
	public String getGroupId(){
		return groupId;
	}
	
	public void setGroupPic(String groupPic){
		this.groupPic=groupPic;
	}
	
	public String getGroupPic(){
		return groupPic;
	}
	
	public void setGroupName(String groupName){
		this.groupName=groupName;
	}
	
	public String getGroupName(){
		return groupName;
	}
	
	public void setGroupIntro(String groupIntro){
		this.groupIntro=groupIntro;
	}
	
	public String getGroupIntro(){
		return groupIntro;
	}
	
	public Group(){
	}
	
	public Group(String groupId,String groupPic,String groupName,String groupIntro){
		this.groupId=groupId;
		this.groupPic=groupPic;
		this.groupName=groupName;
		this.groupIntro=groupIntro;
	}
	
}
