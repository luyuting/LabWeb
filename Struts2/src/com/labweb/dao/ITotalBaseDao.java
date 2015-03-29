package com.labweb.dao;

import java.util.*;

public interface ITotalBaseDao extends IBaseDao{
	void doCreate(String tableName);
	List<Map<String,String>> getTotalList();
}
