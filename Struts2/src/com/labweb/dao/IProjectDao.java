package com.labweb.dao;

import java.util.List;

import com.labweb.model.Project;

public interface IProjectDao extends IPageBaseDao{
	boolean writeProject(Project project);
	List<Project> getPageProjectList(int pageIndex,int numPerPage);
}
