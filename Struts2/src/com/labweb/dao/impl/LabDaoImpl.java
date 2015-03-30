package com.labweb.dao.impl;

import java.util.*;

import com.labweb.dao.ILabDao;
import com.labweb.model.Lab;

public class LabDaoImpl extends BaseDaoImpl<Lab> implements ILabDao{

	@Override
	public int doInsert(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="insert into t_labintro values(uuid(),?,?)";
		return execute(sql, paramList);
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="update t_labintro set lab_name=?,lab_intro_content=?"
				+ "where lab_id=?";
		return execute(sql, paramList);
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="delete from t_labintro where lab_id=?";
		return execute(sql, paramList);
	}

	@Override
	public List<Lab> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_labintro";
		return getQueryList(sql, paramList);
	}

	@Override
	public int doCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Lab getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new Lab(list);
	}
	
}
