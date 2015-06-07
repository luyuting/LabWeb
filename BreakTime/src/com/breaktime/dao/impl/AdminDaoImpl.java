package com.breaktime.dao.impl;

import java.util.*;

import com.breaktime.dao.inter.IAdminDao;
import com.breaktime.model.Admin;

public class AdminDaoImpl extends BaseDaoImpl<Admin> implements IAdminDao{

	@Override
	public int doSave(Admin obj) {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(obj.getAdminAccount());
		paramList.add(obj.getAdminPassword());
		paramList.add(obj.getAdminName());
		String sql="insert into t_admin values(?,?,?)";
		return execute(sql, paramList);
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="update t_admin set admin_password=? where admin_account=?";
		return execute(sql, paramList);
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="delete from t_admin where admin_account=?";
		return execute(sql, paramList);
	}

	@Override
	public List<Admin> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_admin limit ?,?";
		return getQueryList(sql, paramList);
	}

	@Override
	public int doCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from t_admin";
		return getCount(sql, null);
	}

	@Override
	protected Admin getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new Admin(list);
	}

}
