package com.labweb.action;

import java.util.*;

import com.labweb.dao.factory.DaoFactory;
import com.labweb.model.Message;
import com.opensymphony.xwork2.ActionSupport;

public class MesgAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int pageIndex;
	private int numPerPage=15;
	private Map<String,Object> mesgMap=new HashMap<String,Object>();
	
	public void setPageIndex(int pageIndex){
		this.pageIndex=pageIndex;
	}
	
	public int getPageIndex(){
		return pageIndex;
	}
	
	public Map<String,Object> getMesgMap(){
		return mesgMap;
	}
	
	public String execute(){
		List<Message> mesgList=DaoFactory.getMesgDaoInstance().getPageMesgList(pageIndex,numPerPage);
		int mesgCount=DaoFactory.getMesgDaoInstance().getAcount();
		int mesgPage=mesgCount/numPerPage;
		if(mesgCount%numPerPage!=0)
			mesgPage++;
		mesgMap.put("mesgList", mesgList);
		mesgMap.put("mesgCount", mesgCount);
		mesgMap.put("mesgPage", mesgPage);
		mesgMap.put("mesgPageIndex", pageIndex);
		return SUCCESS;
	}
}
