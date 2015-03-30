package com.labweb.action;

import java.util.*;


import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> resultMesg=new HashMap<String,Object>();
	
	public Map<String,Object> getResultMesg(){
		return resultMesg;
	}
}
