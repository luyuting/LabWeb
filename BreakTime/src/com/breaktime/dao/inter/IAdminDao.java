package com.breaktime.dao.inter;

import com.breaktime.model.Admin;

public interface IAdminDao extends IBaseDao<Admin>{
	int doCount();
}