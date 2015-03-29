package com.labweb.dao;

import java.util.List;

import com.labweb.model.Group;

public interface IGroupDao extends ITotalBaseDao{
	List<Group> getGroupIntro();
}
