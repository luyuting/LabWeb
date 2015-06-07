package com.breaktime.dao.factory;

import com.breaktime.dao.impl.*;
import com.breaktime.dao.inter.*;

public class DaoFactory {
	public static IDrinkDao getDrinkDaoInstance(){
		return new DrinkDaoImpl();
	}
	
	public static IDetailsDao getDetailsDaoInstance(){
		return new DetailsDaoImpl();
	}
	
	public static IOrderDao getOrderDaoInstance(){
		return new OrderDaoImpl();
	}
	
	public static ITypeDao getTypeDaoInstance(){
		return new TypeDaoImpl();
	}
	
	public static IAdminDao getAdminDaoInstance(){
		return new AdminDaoImpl();
	}
}
