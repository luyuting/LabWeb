package com.labweb.model;

public class Message {
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
	
	public Message(String mesgId,String mesgContent,String mesgTime){
		this.mesgId=mesgId;
		this.mesgContent=mesgContent;
		this.mesgTime=mesgTime;
	}
}
