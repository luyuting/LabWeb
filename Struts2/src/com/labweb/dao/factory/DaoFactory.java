package com.labweb.dao.factory;

import com.labweb.dao.*;
import com.labweb.dao.impl.*;


public class DaoFactory {
	 public static INewsDao getNewsDaoInstance(){
		 return new NewsDaoImpl();
	 }
	 
	 public static IMesgDao getMesgDaoInstance(){
		 return new MesgDaoImpl();
	 }
	 
	 public static IProjectDao getProjectDaoInstance(){
		 return new ProjectDaoImpl();
	 }
	 
	 public static ILabDao getLabDaoInstance(){
		 return new LabDaoImpl();
	 }
	 
	 public static IGroupDao getGroupDaoInstance(){
		 return new GroupDaoImpl();
	 }
	 
	 public static IAdminDao getAdminDaoInstance(){
		 return new AdminDaoImpl();
	 }
}
