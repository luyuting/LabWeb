package com.labweb.action;

import java.util.*;

import com.labweb.dao.factory.DaoFactory;
import com.labweb.model.Group;
import com.opensymphony.xwork2.ActionSupport;

public class GroupAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private List<Group> groupList=null;
	
	public List<Group> getGroupList(){
		return groupList;
	}
	
	public String execute(){
		groupList=DaoFactory.getGroupDaoInstance().getGroupIntro();
		return SUCCESS;
	}
}
