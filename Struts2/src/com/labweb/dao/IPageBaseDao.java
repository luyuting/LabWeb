package com.labweb.dao;

import java.util.*;

public interface IPageBaseDao extends IBaseDao{
	void doCreate(String tableName,String timeColumn); 		//���ö�Ӧ�������Ϣ
	int getAcount(); 								 		 //��ȡ������
	List<Map<String,String>> getPageMap(int pageIndex,int numPerPage);		 //��ҳ��ȡ��Ӧ��¼
	boolean addRecord(String addSql,List<Object> paramList);									//���Ӽ�¼
}
