package com.labweb.dao.impl;

import java.util.*;
import java.util.Map.Entry;

import com.labweb.dao.IAdminDao;
import com.labweb.db.DatabaseUtil;
import com.labweb.model.Admin;

public class AdminDaoImpl extends BaseDaoImpl implements IAdminDao{
	
	private String adminSql="select * from "+TABLE_ADMIN+" where "+ADMIN_ACCOUNT+" =?";
	
	public AdminDaoImpl(){
	}

	@Override
	public Admin getAdminInfo(String adminAccount) {
		// TODO Auto-generated method stub
		Map<String,String> adminMap=getAdminMap(adminAccount);
		if(adminMap==null)
			return null;
		Admin admin=new Admin();
		Iterator<Entry<String,String>>	adminEntryIt=adminMap.entrySet().iterator();
		while(adminEntryIt.hasNext()){
			Entry<String,String> adminEntry=adminEntryIt.next();
			String value=adminEntry.getValue();
			switch(adminEntry.getKey()){
				case ADMIN_ACCOUNT:admin.setAdminAccount(value);break;
				case ADMIN_PASSWORD:admin.setAdminPassword(value);break;
				case ADMIN_NAME:admin.setAdminName(value);break;
			}
		}
		return admin;
	}
	
	public Map<String,String> getAdminMap(String adminAccount){
		Map<String,String> adminMap=null;
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(adminAccount);
		try{
			adminMap=DatabaseUtil.getQueryList(adminSql, paramList).get(0);
		}catch(Exception e){
			return null;
		}
		return adminMap;
	}
}
