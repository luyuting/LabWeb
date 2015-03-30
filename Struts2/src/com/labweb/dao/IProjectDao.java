package com.labweb.dao;

import java.util.List;

import com.labweb.model.Project;

public interface IProjectDao extends IBaseDao<Project>{
	Project getProject(List<Object> paramList);
}