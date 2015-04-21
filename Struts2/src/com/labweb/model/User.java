package com.labweb.model;

import java.util.List;

public class User extends BaseModel{
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userAccount;
	private String userName;
	private String userMajor;
	private String userTel;
	private String userMail;
	private String userQq;
	private String userGroup;
	
	public void setUserId(String userId){
		this.userId=userId;
	}
	
	public String getUserId(){
		return userId;
	}
	
	public void setUserAccount(String userAccount){
		this.userAccount=userAccount;
	}
	
	public String getUserAccount(){
		return userAccount;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserMajor(String userMajor){
		this.userMajor=userMajor;
	}
	
	public String getUserMajor(){
		return userMajor;
	}
	
	public void setUserTel(String userTel){
		this.userTel=userTel;
	}
	
	public String getUserTel(){
		return userTel;
	}
	
	public void setUserMail(String userMail){
		this.userMail=userMail;
	}
	
	public String getUserMail(){
		return userMail;
	}
	
	public void setUserQq(String userQq){
		this.userQq=userQq;
	}
	
	public String getUserQq(){
		return userQq;
	}
	
	public void setUserGroup(String userGroup){
		this.userGroup=userGroup;
	}
	
	public String getUserGroup(){
		return userGroup;
	}
	
	public User(){
		
	}
	
	public User(List<String> list){
		this.userId=list.get(0);
		this.userAccount=list.get(1);
		this.userName=list.get(2);
		this.userMajor=list.get(3);
		this.userTel=list.get(4);
		this.userMail=list.get(5);
		this.userQq=list.get(6);
		this.userGroup=list.get(7);
	}
}
