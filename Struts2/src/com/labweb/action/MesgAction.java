package com.labweb.action;

import java.util.ArrayList;
import java.util.List;

import com.labweb.dao.IMesgDao;
import com.labweb.dao.impl.MesgDaoImpl;
import com.labweb.model.Message;

public class MesgAction extends PageBaseAction<Message>{
	private static final long serialVersionUID = 1L;
	private IMesgDao mesgDao=null;
	private Message mesg;
	
	public MesgAction(){
		super(MesgDaoImpl.class,15);
		mesgDao=(MesgDaoImpl)dao;
	}
	
	public void setMesg(Message mesg){
		this.mesg=mesg;
	}
	
	public Message getMesg(){
		return mesg;
	}
	
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		this.setResultMesg(mesgDao.doSelect(selectParamList()), mesgDao.doCount());
		return SUCCESS;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(mesg.getMesgContent());
		paramList.add(mesg.getMesgId());
		setResultMesg(mesgDao.doUpdate(paramList), "����");
		return SUCCESS;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(mesg.getMesgContent());
		setResultMesg(mesgDao.doInsert(paramList), "����");
		return SUCCESS;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(mesg.getMesgId());
		setResultMesg(mesgDao.doDelete(paramList), "ɾ��");
		return SUCCESS;
	}

	@Override
	public String getById() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(mesg.getMesgId());
		setResultMesg(mesgDao.getMesg(paramList));
		return SUCCESS;
	}
}
