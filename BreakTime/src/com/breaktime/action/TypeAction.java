package com.breaktime.action;

import java.util.*;

import com.breaktime.dao.factory.DaoFactory;
import com.breaktime.dao.inter.ITypeDao;
import com.breaktime.model.Type;

public class TypeAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private Type type;
	private ITypeDao typeDao=DaoFactory.getTypeDaoInstance();
	
	public void setType(Type type){
		this.type=type;
	}
	
	public Type getType(){
		return type;
	}
	
	@Override
	public String insert() {
		// TODO Auto-generated method stub
		boolean mesg=false;
		if(this.typeDao.doSave(type)==1)
			mesg=true;
		this.setResultMesg(mesg, "²åÈë");
		return SUCCESS;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		boolean mesg=false;
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(type.getTypeName());
		paramList.add(type.getTypePic());
		paramList.add(type.getTypeId());
		if(this.typeDao.doUpdate(paramList)==1)
			mesg=true;
		this.setResultMesg(mesg, "¸üÐÂ");
		return SUCCESS;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		boolean mesg=false;
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(type.getTypeId());
		if(this.typeDao.doDelete(paramList)==1)
			mesg=true;
		this.setResultMesg(mesg, "É¾³ý");
		return SUCCESS;
	}

	@Override
	public String select() {
		// TODO Auto-generated method stub
		this.setResultMesg(this.typeDao.doSelect(null));
		return SUCCESS;
	}

}
