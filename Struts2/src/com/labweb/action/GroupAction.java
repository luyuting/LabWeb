package com.labweb.action;

import java.util.ArrayList;
import java.util.List;

import com.labweb.dao.IGroupDao;
import com.labweb.dao.impl.GroupDaoImpl;
import com.labweb.model.Group;

public class GroupAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private IGroupDao groupDao=null;
	private Group group=new Group();
	
	public GroupAction(){
		super(GroupDaoImpl.class);
		groupDao=(GroupDaoImpl)dao;
	}
	
	public void setGroupId(String groupId){
		this.group.setGroupId(groupId);
	}
	
	public void setGroupPic(String groupPic){
		this.group.setGroupPic(groupPic);
	}
	
	public void setGroupName(String groupName){
		this.group.setGroupName(groupName);
	}
	
	public void setGroupIntro(String groupIntro){
		this.group.setGroupIntro(groupIntro);
	}
	
	@Override
	public String execute(){
		// TODO Auto-generated method stub
		resultMesg.clear();
		resultMesg.put("result", groupDao.doSelect(null));
		return SUCCESS;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(group.getGroupPic());
		paramList.add(group.getGroupName());
		paramList.add(group.getGroupIntro());
		paramList.add(group.getGroupId());
		setResultMesg(groupDao.doUpdate(paramList), "¸üÐÂ");
		return SUCCESS;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(group.getGroupPic());
		paramList.add(group.getGroupName());
		paramList.add(group.getGroupIntro());
		setResultMesg(groupDao.doInsert(paramList), "²åÈë");
		return SUCCESS;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(group.getGroupId());
		setResultMesg(groupDao.doDelete(paramList), "É¾³ý");
		return SUCCESS;
	}
	
}