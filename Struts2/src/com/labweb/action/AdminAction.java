package com.labweb.action;

public class AdminAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private String adminAccount;
	
	public void setAdminAccount(String adminAccount){
		this.adminAccount=adminAccount;
	}
	
	public String getAdminAccount(){
		return adminAccount;
	}
}
