package com.labweb.action;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String adminAccount;
	
	public void setAdminAccount(String adminAccount){
		this.adminAccount=adminAccount;
	}
	
	public String getAdminAccount(){
		return adminAccount;
	}
}
