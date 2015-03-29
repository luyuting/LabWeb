package com.labweb.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL =  "jdbc:mysql://localhost:3306/db_labweb?useUnicode=true&characterEncoding=UTF8";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "lyt";
	
	public static Connection getConnection()throws Exception{
		Class.forName(DBDRIVER);
		Connection conn=DriverManager.getConnection(DBURL,DBUSER, DBPASSWORD);
		return conn;
	}
}
