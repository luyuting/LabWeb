package com.labweb.action;

import java.util.ArrayList;
import java.util.List;

import com.labweb.dao.IMesgDao;
import com.labweb.dao.factory.DaoFactory;
import com.labweb.model.Message;

public class MesgAction extends PageBaseAction<Message>{
	private static final long serialVersionUID = 1L;
	private IMesgDao mesgDao=DaoFactory.getMesgDaoInstance();
	private Message mesg=new Message();
	
	public MesgAction(){
		setNumPerPage(15);
	}
	
	public void setMesgId(String mesgId){
		this.mesg.setMesgId(mesgId);
	}
	
	public void setMesgContent(String mesgContent){
		this.mesg.setMesgContent(mesgContent);
	}
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		this.setResultMesg(mesgDao.doSelect(selectParamList()), mesgDao.doCount());
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(mesg.getMesgContent());
		paramList.add(mesg.getMesgId());
		setResultMesg(mesgDao.doUpdate(paramList), "¸üÐÂ");
		return SUCCESS;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(mesg.getMesgContent());
		setResultMesg(mesgDao.doInsert(paramList), "²åÈë");
		return SUCCESS;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(mesg.getMesgId());
		setResultMesg(mesgDao.doDelete(paramList), "É¾³ý");
		return SUCCESS;
	}
}
