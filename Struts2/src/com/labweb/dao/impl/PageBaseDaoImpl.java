package com.labweb.dao.impl;

import java.util.*;

import com.labweb.dao.*;
import com.labweb.db.DatabaseUtil;
public class PageBaseDaoImpl extends BaseDaoImpl implements IPageBaseDao{
	protected String tableName=null;
	protected String timeColumn=null;
	protected String keyColumn="count";
	protected String countSql=null;
	protected String pageSql=null;
	
	@Override
	public void doCreate(String tableName,String timeColumn) {
		// TODO Auto-generated method stub
		this.tableName=tableName;
		this.timeColumn=timeColumn;
		countSql="select count(*) "+this.keyColumn+" from "+this.tableName;
		pageSql="select * from "+this.tableName+" order by "+this.timeColumn+" desc limit ?,?";
	}
	
	@Override
	public int getAcount(){
		// TODO Auto-generated method stub
		Map<String,String> countMap=new HashMap<String, String>();
		try{
			countMap=DatabaseUtil.getQueryList(countSql, null).get(0);
		}catch(Exception e){}
		return Integer.parseInt(countMap.get(keyColumn));
	}
	
	@Override
	public List<Map<String,String>> getPageMap(int pageIndex,int numPerPage){
		// TODO Auto-generated method stub
		int start=numPerPage*(pageIndex-1);
		int end=numPerPage;
		List<Object> pageList=new ArrayList<Object>();
		pageList.add(start);
		pageList.add(end);
		List<Map<String,String>> pageMap=new ArrayList<Map<String,String>>();
		try{
			pageMap=DatabaseUtil.getQueryList(pageSql,pageList);
		}catch(Exception e){}
		return pageMap;
		
	}

	@Override
	public boolean addRecord(String addSql, List<Object> paramList) {
		// TODO Auto-generated method stub
		boolean result=false;
		int insert=0;
		try{
			insert=DatabaseUtil.execute(addSql, paramList);
		}catch(Exception e){}
		if(insert>0)
			result=true;
		return result;
	}
}
