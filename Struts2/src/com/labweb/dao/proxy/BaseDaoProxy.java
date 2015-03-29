package com.labweb.dao.proxy;

import com.labweb.dao.impl.BaseDaoImpl;

public class BaseDaoProxy {
	protected BaseDaoImpl dao = null;
	BaseDaoProxy(Class<? extends BaseDaoImpl> daoClass){
		try {
			dao = daoClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
