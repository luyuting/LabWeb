package com.labweb.dao;

import java.util.List;

import com.labweb.model.User;

public interface IUserDao extends IBaseDao<User>{
	User getUser(List<Object> paramList);
	int doCount(List<Object> paramList);
}
