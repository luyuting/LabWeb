package com.labweb.dao.impl;

import java.util.List;

import com.labweb.dao.IUserDao;
import com.labweb.model.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{

	@Override
	public int doInsert(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="insert into t_join values(uuid(),?,?,?,?,?,?,?)";
		return execute(sql, paramList);
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		return 0;
		
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="delete from t_join where join_id=?";
		return execute(sql, paramList);
	}

	@Override
	public List<User> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_join";
		if(paramList.size()==3)
			sql+=" where join_group=?";
		sql+=" order by join_id desc limit ?,?";
		return getQueryList(sql, paramList);
	}

	@Override
	public int doCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from t_join";
		return getCount(sql, null);
	}

	@Override
	protected User getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new User(list);
	}

	@Override
	public User getUser(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_join where join_id=?";
		return getQueryList(sql, paramList).get(0);
	}
	
	public int doCount(List<Object> paramList){
		String sql="select count(*) from t_join where join_group=?";
		return execute(sql, paramList);
	}
}
