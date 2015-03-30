package com.labweb.action;

import com.labweb.dao.IMesgDao;
import com.labweb.dao.factory.DaoFactory;
import com.labweb.model.Message;

public class MesgAction extends PageBaseAction<Message>{
	private static final long serialVersionUID = 1L;
	private IMesgDao mesgDao=DaoFactory.getMesgDaoInstance();

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}
}
