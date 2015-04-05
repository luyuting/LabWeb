package com.labweb.action;

import java.util.*;

import com.labweb.dao.factory.DaoFactory;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	protected Object dao=null;
	
	public BaseAction(Class<?> daoClass){
		this.dao=DaoFactory.getDaoInstance(daoClass);
	}
	
	public Map<String,Object> resultMesg=new HashMap<String,Object>();
	
	public void setResultMesg(Map<String,Object> resultMesg){
		this.resultMesg=resultMesg;
	}
	
	public Map<String,Object> getResultMesg(){
		return resultMesg;
	}
	
	protected void setResultMesg(int resultNum,String type){
		boolean mesg=false;
		String result=type+"Ê§°Ü£¡";
		if(resultNum>0){
			mesg=true;
			result=type+"³É¹¦£¡";
		}
		resultMesg.clear();
		resultMesg.put("mesg", mesg);
		resultMesg.put("result", result);
	}
	
	public abstract String execute();
	public abstract String update();
	public abstract String insert();
	public abstract String delete();
}
