package com.labweb.dao.impl;

import java.util.*;

import com.labweb.dao.IGroupDao;
import com.labweb.model.Group;

public class GroupDaoImpl extends BaseDaoImpl<Group> implements IGroupDao{

	@Override
	public int doInsert(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="insert into t_group values(uuid(),?,?,?)";
		return execute(sql, paramList);
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="update t_group set gro_pic=?,gro_name=?,gro_intro=?"
				+ " where gro_id=?";
		return execute(sql, paramList);
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="delete from t_group where gro_id=?";
		return execute(sql, paramList);
	}

	@Override
	public List<Group> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_group";
		return getQueryList(sql, paramList);
	}

	@Override
	public int doCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Group getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new Group(list);
	}
	
}
