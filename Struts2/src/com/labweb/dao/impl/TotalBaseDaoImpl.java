package com.labweb.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.labweb.dao.ITotalBaseDao;
import com.labweb.db.DatabaseUtil;

public class TotalBaseDaoImpl extends BaseDaoImpl implements ITotalBaseDao{
	protected String tableName=null;
	protected String totalSql=null;

	@Override
	public void doCreate(String tableName) {
		// TODO Auto-generated method stub
		this.tableName=tableName;
		this.totalSql="select * from "+tableName;
	}

	@Override
	public List<Map<String, String>> getTotalList() {
		// TODO Auto-generated method stub
		List<Map<String,String>> totalMap=new ArrayList<Map<String,String>>();
		try{
			totalMap=DatabaseUtil.getQueryList(totalSql,null);
		}catch(Exception e){}
		return totalMap;
	}

}
