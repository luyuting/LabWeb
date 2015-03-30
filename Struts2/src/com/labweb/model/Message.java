package com.labweb.model;

import java.util.List;

public class Message extends BaseModel{
	private static final long serialVersionUID = 1L;
	private String mesgId;
	private String mesgContent;
	private String mesgTime;
	
	public void setMesgId(String mesgId){
		this.mesgId=mesgId;
	}
	
	public String getMesgId(){
		return mesgId;
	}
	
	public void setMesgContent(String mesgContent){
		this.mesgContent=mesgContent;
	}
	
	public String getMesgContent(){
		return mesgContent;
	}
	
	public void setMesgTime(String mesgTime){
		this.mesgTime=mesgTime;
	}
	
	public String getMesgTime(){
		return mesgTime;
	}
	
	public Message(){
	}
	
	public Message(List<String> list){
		this.mesgId=list.get(0);
		this.mesgContent=list.get(1);
		this.mesgTime=list.get(2);
	}
}
