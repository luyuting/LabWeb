package com.labweb.action;

import java.util.List;

import com.labweb.dao.IGroupDao;
import com.labweb.dao.factory.DaoFactory;
import com.labweb.model.Group;

public class GroupAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private IGroupDao groupDao=DaoFactory.getGroupDaoInstance();
	
	public String execute(){
		List<Group> groupList=groupDao.doSelect(null);
		resultMesg.clear();
		resultMesg.put("result", groupList);
		return SUCCESS;
	}
	
}