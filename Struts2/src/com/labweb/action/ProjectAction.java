package com.labweb.action;

import com.labweb.dao.IProjectDao;
import com.labweb.dao.factory.DaoFactory;
import com.labweb.model.Project;

public class ProjectAction extends PageBaseAction<Project>{
	private static final long serialVersionUID = 1L;
	private IProjectDao projectDao=DaoFactory.getProjectDaoInstance();

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		this.setResultMesg(projectDao.doSelect(selectParamList()),
				projectDao.doCount());
		return SUCCESS;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		String mesg="更新失败！";
		if(projectDao.doUpdate(null)>0);
			mesg="更新成功！";
		resultMesg.put("mesg", mesg);
		return SUCCESS;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
}
