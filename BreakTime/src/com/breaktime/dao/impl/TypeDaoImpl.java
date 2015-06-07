package com.breaktime.dao.impl;

import java.util.*;

import com.breaktime.dao.inter.ITypeDao;
import com.breaktime.model.Type;

public class TypeDaoImpl extends BaseDaoImpl<Type> implements ITypeDao{

	@Override
	public int doSave(Type obj) {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(obj.getTypeName());
		paramList.add(obj.getTypePic());
		String sql="insert into t_type values(uuid(),?,?)";
		return this.execute(sql, paramList);
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="update t_type set type_name=? and "
				+ "type_pic=? where type_id=?";
		return this.execute(sql, paramList);
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="delete from t_type where type_id=?";
		return this.execute(sql, paramList);
	}

	@Override
	public List<Type> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_type";
		return this.getQueryList(sql, paramList);
	}

	@Override
	protected Type getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new Type(list);
	}

}
