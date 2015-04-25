package com.labweb.action;

import java.util.*;

import com.labweb.dao.IUserDao;
import com.labweb.dao.impl.UserDaoImpl;
import com.labweb.model.User;

public class UserAction extends PageBaseAction<User>{
	private static final long serialVersionUID = 1L;
	private IUserDao userDao=null;
	private User user=new User();

	public UserAction() {
		super(UserDaoImpl.class,20);
		userDao=(UserDaoImpl)dao;
	}
	
	public void setUserId(String userId){
		this.user.setUserId(userId);
	}
	
	public void setUserAccount(String userAccount){
		this.user.setUserAccount(userAccount);
	}
	
	public void setUserName(String userName){
		this.user.setUserName(userName);
	}
	
	public void setUserMajor(String userMajor){
		this.user.setUserMajor(userMajor);
	}
	
	public void setUserTel(String userTel){
		this.user.setUserTel(userTel);
	}
	
	public void setUserMail(String userMail){
		this.user.setUserMail(userMail);
	}
	
	public void setUserQq(String userQq){
		this.user.setUserQq(userQq);
	}
	
	public void setUserGroup(String userGroup){
		this.user.setUserGroup(userGroup);
	}
	
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		this.setResultMesg(userDao.doSelect(selectParamList()),userDao.doCount());
		return SUCCESS;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(user.getUserAccount());
		paramList.add(user.getUserName());
		paramList.add(user.getUserMajor());
		paramList.add(user.getUserTel());
		paramList.add(user.getUserMail());
		paramList.add(user.getUserQq());
		paramList.add(user.getUserGroup());
		setResultMesg(userDao.doInsert(paramList), "²åÈë");
		return SUCCESS;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(user.getUserId());
		setResultMesg(userDao.doDelete(paramList), "É¾³ý");
		return SUCCESS;
	}

	@Override
	public String getById() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(user.getUserId());
		setResultMesg(userDao.getUser(paramList));
		return SUCCESS;
	}
	
	public String getByGroup(){
		List<Object> paramList=selectParamList();
		paramList.add(0,user.getUserGroup());
		List<Object> groupParam=new ArrayList<Object>();
		groupParam.add(user.getUserGroup());
		this.setResultMesg(userDao.doSelect(paramList), userDao.doCount(groupParam));
		return SUCCESS;
	}
	
}
