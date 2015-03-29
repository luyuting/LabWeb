package com.labweb.dao;

import java.util.Map;

import com.labweb.model.Admin;

public interface IAdminDao extends IBaseDao{
	Admin getAdminInfo(String adminAccount);
	Map<String,String> getAdminMap(String adminAccount);
}
