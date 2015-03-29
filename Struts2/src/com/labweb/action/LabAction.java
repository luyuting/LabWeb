package com.labweb.action;

import com.labweb.dao.factory.DaoFactory;
import com.labweb.model.Lab;
import com.opensymphony.xwork2.ActionSupport;

public class LabAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Lab labMap=null;
	
	public Lab getLabMap(){
		return labMap;
	}
	
	public String execute(){
		labMap=DaoFactory.getLabDaoInstance().getLabIntro();
		return SUCCESS;
	}
}
