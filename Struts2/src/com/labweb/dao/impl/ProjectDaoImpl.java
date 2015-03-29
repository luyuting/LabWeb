package com.labweb.dao.impl;

import java.util.*;
import java.util.Map.Entry;

import com.labweb.dao.IProjectDao;
import com.labweb.model.Project;

public class ProjectDaoImpl extends PageBaseDaoImpl implements IProjectDao{
	
	public ProjectDaoImpl(){
		doCreate(TABLE_PROJECT,PROJECT_TIME);
	}
	
	@Override
	public boolean writeProject(Project project) {
		// TODO Auto-generated method stub
		String addSql="insert into "+TABLE_PROJECT+" values(uuid(),?,?,?,now())";
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(project.getProjectPic());
		paramList.add(project.getProjectName());
		paramList.add(project.getProjectContent());
		return addRecord(addSql, paramList);
	}
	
	@Override
	public List<Project> getPageProjectList(int pageIndex, int numPerPage) {
		// TODO Auto-generated method stub
		List<Map<String, String>> pageProject=getPageMap(pageIndex, numPerPage);
		List<Project> projectList=new ArrayList<Project>();
		for(Map<String,String> projectMap:pageProject){
			Iterator<Entry<String,String>> projectEntryIt=projectMap.entrySet().iterator();
			Project project=new Project();
			while(projectEntryIt.hasNext()){
				Entry<String,String> projectEntry=projectEntryIt.next();
				String value=projectEntry.getValue();
				switch(projectEntry.getKey()){
					case PROJECT_ID:project.setProjectId(value);break;
					case PROJECT_PIC:project.setProjectPic(value);break;
					case PROJECT_NAME:project.setProjectName(value);break;
					case PROJECT_CONTENT:project.setProjectContent(value);break;
					case PROJECT_TIME:project.setProjectTime(value);break;
					default:break;
				}
			}
			projectList.add(project);
		}
		return projectList;
	}

}
