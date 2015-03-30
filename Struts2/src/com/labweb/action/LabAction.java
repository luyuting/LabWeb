package com.labweb.action;

import com.labweb.dao.ILabDao;
import com.labweb.dao.factory.DaoFactory;

public class LabAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private ILabDao labDao=DaoFactory.getLabDaoInstance();
	public String execute(){
		resultMesg.put("result", labDao.doSelect(null));
		return SUCCESS;
	}
}