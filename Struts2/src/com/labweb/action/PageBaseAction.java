package com.labweb.action;

import java.util.*;

public abstract class PageBaseAction<T> extends BaseAction{
	private static final long serialVersionUID = 1L;
	protected int pageIndex;
	protected int numPerPage;
	
	public PageBaseAction(){
		setNumPerPage(10);
	}
	
	public void setPageIndex(int pageIndex){
		this.pageIndex=pageIndex;
	}
	
	protected void setNumPerPage(int numPerPage){
		this.numPerPage=numPerPage;
	}
	
	protected List<Object> selectParamList(){
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(numPerPage*(pageIndex-1));
		paramList.add(numPerPage);
		return paramList;
	}
	
	public void setResultMesg(List<T> list,int Count){
		int pageCount=Count/pageIndex;
		if(Count%pageIndex!=0)
			pageCount++;
		resultMesg.clear();
		resultMesg.put("resultList", list);
		resultMesg.put("totalCount", Count);
		resultMesg.put("pageIndex", pageIndex);
		resultMesg.put("pageCount", pageCount);
	}
	
	public abstract String execute();
	public abstract String update();
	public abstract String insert();
	public abstract String delete();
}