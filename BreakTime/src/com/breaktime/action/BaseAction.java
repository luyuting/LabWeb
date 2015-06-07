package com.breaktime.action;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	public Map<String,Object> resultMesg=new HashMap<String,Object>();
	protected int numPerPage=15;
	protected int pageIndex;
	
	public void setPageIndex(int pageIndex){
		this.pageIndex=pageIndex;
	}
	
	public void setNumPerPage(int numPerPage){
		this.numPerPage=numPerPage;
	}
	
	public Map<String,Object> getResultMesg(){
		return resultMesg;
	}
	
	protected void setResultMesg(Object obj){
		this.resultMesg.clear();
		this.resultMesg.put("result", obj);
	}
	
	protected void setResultMesg(int totalCount,Object obj){
		int pageCount=totalCount/numPerPage;
		if(totalCount%numPerPage!=0)
			pageCount++;
		this.resultMesg.clear();
		this.resultMesg.put("totalCount", totalCount);
		this.resultMesg.put("pageCount",pageCount);
		this.resultMesg.put("pageIndex", pageIndex);
		this.resultMesg.put("result", obj);
	}
	
	protected void setResultMesg(boolean mesg,String type){
		this.resultMesg.clear();
		String result="Ê§°Ü";
		this.resultMesg.put("mesg", mesg);
		if(mesg)
			result="³É¹¦";
		this.resultMesg.put("result", type+result);
	}
	
	public abstract String insert();
	public abstract String update();
	public abstract String delete();
	public abstract String select();
}
