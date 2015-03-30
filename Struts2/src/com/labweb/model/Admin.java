package com.labweb.model;

import java.util.List;

public class Admin extends BaseModel{
	private static final long serialVersionUID = 1L;
	private String adminAccount;
	private String adminPassword;
	private String adminName;
	
	public void setAdminAccount(String adminAccount){
		this.adminAccount=adminAccount;
	}
	
	public String getAdminAccount(){
		return adminAccount;
	}
	
	public void setAdminPassword(String adminPassword){
		this.adminPassword=adminPassword;
	}
	
	public String getAdminPassword(){
		return adminPassword;
	}
	
	public void setAdminName(String adminName){
		this.adminName=adminName;
	}
	
	public String getAdminName(){
		return adminName;
	}
	
	public Admin(){
	}
	
	public Admin(List<String> list){
		this.adminAccount=list.get(0);
		this.adminPassword=list.get(1);
		this.adminName=list.get(2);
	}
}
