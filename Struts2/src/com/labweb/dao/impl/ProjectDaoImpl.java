package com.labweb.dao.impl;

import java.util.*;

import com.labweb.dao.IProjectDao;
import com.labweb.model.Project;

public class ProjectDaoImpl extends BaseDaoImpl<Project> implements IProjectDao{

	@Override
	public int doInsert(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="insert into t_projintro values(uuid(),?,?,?,now())";
		return execute(sql, paramList);
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="update t_projintro set proj_pic=?,proj_name=?,"
				+ "proj_content proj_time=now() where proj_id=?";
		return execute(sql, paramList);
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="delete from t_projintro where proj_id=?";
		return execute(sql, paramList);
	}

	@Override
	public List<Project> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_projintro order by proj_time "
				+ "desc limit ?,?";
		return getQueryList(sql, paramList);
	}

	@Override
	public int doCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from t_projintro";
		return getCount(sql, null);
	}

	@Override
	public Project getProject(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_projintro where proj_id=?";
		return getQueryList(sql, paramList).get(0);
	}

	@Override
	protected Project getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new Project(list);
	}
	
}