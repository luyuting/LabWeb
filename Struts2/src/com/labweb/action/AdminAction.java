package com.labweb.action;

import com.labweb.dao.IAdminDao;
import com.labweb.dao.impl.AdminDaoImpl;
import com.labweb.model.Admin;

public class AdminAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private IAdminDao adminDao=null;
	private Admin admin;
	
	public AdminAction(){
		super(AdminDaoImpl.class);
		adminDao=(AdminDaoImpl)dao;
	}
	
	public void setAdmin(Admin admin){
		this.admin=admin;
	}
	
	public Admin getAdmin(){
		return admin;
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
