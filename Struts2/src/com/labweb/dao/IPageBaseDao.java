package com.labweb.dao;

import java.util.*;

public interface IPageBaseDao extends IBaseDao{
	void doCreate(String tableName,String timeColumn); 		//设置对应表相关信息
	int getAcount(); 								 		 //获取总条数
	List<Map<String,String>> getPageMap(int pageIndex,int numPerPage);		 //分页获取相应记录
	boolean addRecord(String addSql,List<Object> paramList);									//增加记录
}
