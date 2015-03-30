package com.labweb.dao.impl;

import java.util.*;

import com.labweb.dao.IAdminDao;
import com.labweb.model.Admin;

public class AdminDaoImpl extends BaseDaoImpl<Admin> implements IAdminDao{

	@Override
	public int doInsert(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="insert into t_admin values(?,?,?)";
		return execute(sql, paramList);
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="update t_admin set ad_password=? where ad_account=?";
		return execute(sql, paramList);
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="delete from t_admin where ad_account=?";
		return execute(sql, paramList);
	}

	@Override
	public List<Admin> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_admin";
		return getQueryList(sql, paramList);
	}

	@Override
	public int doCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Admin getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new Admin(list);
	}
}
