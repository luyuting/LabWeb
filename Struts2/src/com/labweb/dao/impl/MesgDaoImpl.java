package com.labweb.dao.impl;

import java.util.*;

import com.labweb.dao.IMesgDao;
import com.labweb.model.Message;

public class MesgDaoImpl extends BaseDaoImpl<Message> implements IMesgDao{

	@Override
	public int doInsert(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="insert into t_mesg values(uuid(),?,now())";
		return execute(sql, paramList);
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="update t_mesg mesg_content=?,mesg_time=now() "
				+ "where mesg_id=?";			
		return execute(sql, paramList);
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="delete from t_mesg where mesg_id=?";
		return execute(sql, paramList);
	}

	@Override
	public List<Message> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_mesg order by mesg_time desc "
				+ "limit ?,?";
		return getQueryList(sql, paramList);
	}

	@Override
	public int doCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from t_mesg";
		return getCount(sql, null);
	}

	@Override
	public Message getMesg(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_mesg where mesg_id=?";
		return getQueryList(sql, paramList).get(0);
	}

	@Override
	protected Message getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new Message(list);
	}
	
}