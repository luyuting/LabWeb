package com.labweb.action;

import java.util.ArrayList;
import java.util.List;

import com.labweb.dao.ILabDao;
import com.labweb.dao.factory.DaoFactory;
import com.labweb.model.Lab;

public class LabAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private ILabDao labDao=DaoFactory.getLabDaoInstance();
	private Lab lab=new Lab();
	
	public void setLabId(String labId){
		lab.setLabId(labId);
	}
	
	public void setLabName(String labName){
		lab.setLabName(labName);
	}
	
	public void setLabContent(String labContent){
		lab.setLabContent(labContent);
	}

	@Override
	public String execute(){
		// TODO Auto-generated method stub
		resultMesg.put("result", labDao.doSelect(null));
		return SUCCESS;
	}
	
	@Override
	public String update() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(lab.getLabName());
		paramList.add(lab.getLabContent());
		paramList.add(lab.getLabId());
		setResultMesg(labDao.doUpdate(paramList), "¸üÐÂ");
		return SUCCESS;
	}
	@Override
	public String insert() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(lab.getLabName());
		paramList.add(lab.getLabContent());
		setResultMesg(labDao.doUpdate(paramList), "²åÈë");
		return SUCCESS;
	}
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(lab.getLabName());
		paramList.add(lab.getLabContent());
		setResultMesg(labDao.doUpdate(paramList), "É¾³ý");
		return SUCCESS;
	}
}