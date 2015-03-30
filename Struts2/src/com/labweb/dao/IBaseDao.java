package com.labweb.dao;

import java.util.List;

public interface IBaseDao<T>{
	int doInsert(List<Object> paramList);			
	int doUpdate(List<Object> paramList);
	int doDelete(List<Object> paramList);
	List<T> doSelect(List<Object> paramList);//整体查询，即不包含id
	
	int doCount(); //获取记录总数
}