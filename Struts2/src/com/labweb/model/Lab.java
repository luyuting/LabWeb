package com.labweb.model;

public class Lab {
	private String labId;
	private String labName;
	private String labContent;
	
	public void setLabId(String labId){
		this.labId=labId;
	}
	
	public String getLabId(){
		return labId;
	}
	
	public void setLabName(String labName){
		this.labName=labName;
	}
	
	public String getLabName(){
		return labName;
	}
	
	public void setLabContent(String labContent){
		this.labContent=labContent;
	}
	
	public String getLabContent(){
		return labContent;
	}
	
	public Lab(){
	}
	
	public Lab(String labId,String labName,String labContent){
		this.labId=labId;
		this.labName=labName;
		this.labContent=labContent;
	}
	
}
