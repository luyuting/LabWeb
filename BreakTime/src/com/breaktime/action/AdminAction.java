package com.breaktime.action;

import java.util.*;

import com.breaktime.dao.factory.DaoFactory;
import com.breaktime.dao.inter.IAdminDao;
import com.breaktime.model.Admin;

public class AdminAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private IAdminDao adminDao=DaoFactory.getAdminDaoInstance();
	private Admin admin;
	
	public AdminAction(){
	}
	
	public void setAdmin(Admin admin){
		this.admin=admin;
	}
	
	public Admin getAdmin(){
		return admin;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		boolean mesg=false;
		if(adminDao.doSave(admin)==1)
			mesg=true;
		this.setResultMesg(mesg, "²åÈë");
		return SUCCESS;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(admin.getAdminAccount());
		boolean mesg=false;
		if(adminDao.doDelete(paramList)==1)
			mesg=true;
		this.setResultMesg(mesg, "É¾³ý");
		return SUCCESS;
	}

	@Override
	public String select() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(numPerPage*(pageIndex-1));
		paramList.add(numPerPage);
		this.setResultMesg(adminDao.doCount(), adminDao.doSelect(paramList));
		return SUCCESS;
	}
	
	
}
