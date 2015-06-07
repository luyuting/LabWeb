package com.breaktime.dao.inter;

import java.util.List;


public interface IBaseDao<T>{
	public int doSave(T obj);
	public int doUpdate(List<Object> paramList);
	public int doDelete(List<Object> paramList);
	public List<T> doSelect(List<Object> paramList);
}
