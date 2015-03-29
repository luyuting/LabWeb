package com.labweb.model;

public class Admin {
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
	
	public Admin(String adminAccount,String adminPassword,String adminName){
		this.adminAccount=adminAccount;
		this.adminPassword=adminPassword;
		this.adminName=adminName;
	}
}
