package com.labweb.model;

import java.util.List;

public class Lab extends BaseModel{
	private static final long serialVersionUID = 1L;
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
	
	public Lab(List<String> list){
		this.labId=list.get(0);
		this.labName=list.get(1);
		this.labContent=list.get(2);
	}
	
}
