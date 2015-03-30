package com.labweb.dao;

import java.util.List;

public interface IBaseDao<T>{
	int doInsert(List<Object> paramList);			
	int doUpdate(List<Object> paramList);
	int doDelete(List<Object> paramList);
	List<T> doSelect(List<Object> paramList);//�����ѯ����������id
	
	int doCount(); //��ȡ��¼����
}