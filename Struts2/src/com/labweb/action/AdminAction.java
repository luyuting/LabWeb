package com.labweb.action;

import com.labweb.dao.IAdminDao;
import com.labweb.dao.impl.AdminDaoImpl;

public class AdminAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private IAdminDao adminDao=null;
	private String adminAccount;
	
	public AdminAction(){
		super(AdminDaoImpl.class);
		adminDao=(AdminDaoImpl)dao;
	}
	
	public void setAdminAccount(String adminAccount){
		this.adminAccount=adminAccount;
	}
	
	public String getAdminAccount(){
		return adminAccount;
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		adminDao.doSelect(null);
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}
}
