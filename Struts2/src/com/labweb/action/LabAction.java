package com.labweb.action;

import java.util.ArrayList;
import java.util.List;

import com.labweb.dao.ILabDao;
import com.labweb.dao.impl.LabDaoImpl;
import com.labweb.model.Lab;

public class LabAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private ILabDao labDao=null;
	private Lab lab;
	
	public LabAction(){
		super(LabDaoImpl.class);
		labDao=(LabDaoImpl)dao;
	}
	
	public void setLab(Lab lab){
		this.lab=lab;
	}
	
	public Lab getLab(){
		return lab;
	}

	@Override
	public String execute(){
		// TODO Auto-generated method stub
		setResultMesg(labDao.doSelect(null));
		return SUCCESS;
	}
	
	@Override
	public String update() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(lab.getLabName());
		paramList.add(lab.getLabContent());
		paramList.add(lab.getLabId());
		setResultMesg(labDao.doUpdate(paramList), "����");
		return SUCCESS;
	}
	@Override
	public String insert() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(lab.getLabName());
		paramList.add(lab.getLabContent());
		setResultMesg(labDao.doInsert(paramList), "����");
		return SUCCESS;
	}
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(lab.getLabName());
		paramList.add(lab.getLabContent());
		setResultMesg(labDao.doDelete(paramList), "ɾ��");
		return SUCCESS;
	}
}