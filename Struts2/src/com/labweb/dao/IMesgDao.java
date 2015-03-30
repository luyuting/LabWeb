package com.labweb.dao;

import java.util.List;

import com.labweb.model.Message;
/*
public interface IMesgDao extends IPageBaseDao{
	boolean writeMesg(Message mesg);
	List<Message> getPageMesgList(int pageIndex,int numPerPage);
}*/
public interface IMesgDao extends IBaseDao<Message>{
	Message getMesg(List<Object> paramList);
}