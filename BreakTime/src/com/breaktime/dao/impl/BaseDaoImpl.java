package com.breaktime.dao.impl;

import java.sql.*;
import java.text.DateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Logger;

import com.breaktime.db.DBConnection;

public abstract class BaseDaoImpl<T>{
	protected static Logger logger=Logger.getLogger("BaseDaoImpl");
	
	protected Connection conn=null;
	protected PreparedStatement pstmt=null;
	protected ResultSet rs=null;
	
	protected int execute(String sql,List<Object> paramList){
		if(sql==null||sql.trim().equals("")){
			logger.info("parameter is valid!");
			return -1;
		}
		int result=0;
		try{
			conn=getConnection();
			pstmt=getPreparedStatement(conn,sql);
			setPreparedStatementParam(pstmt,paramList);
			if(pstmt==null)
				return -2;
			result=pstmt.executeUpdate();
		}catch(Exception e){
			logger.info(e.getMessage());
			//throw new Exception(e);
		}finally{
			closeStatement(pstmt);
			closeConn(conn);
		}
		return result;
	}
	
	protected int getCount(String sql,List<Object> paramList){
		if(sql==null||sql.trim().equals("")){
			logger.info("parameter is valid!");
			return -1;
		}
		int result=0;
		try{
			conn=getConnection();
			pstmt=getPreparedStatement(conn,sql);
			setPreparedStatementParam(pstmt,paramList);
			if(pstmt==null)
				return -2;
			rs=BaseDaoImpl.getResultSet(pstmt);
			if(rs.next())
				result=rs.getInt(1);
		}catch(Exception e){
			logger.info(e.getMessage());
		}finally{
			closeStatement(pstmt);
			closeConn(conn);
			closeResultSet(rs);
		}
		return result;
	}
	
	protected List<T> getQueryList(String sql,List<Object> paramList){
		if(sql==null||sql.trim().equals("")){
			logger.info("parameter is valid!");
			return null;
		}
		List<T> queryList=null;
		try{
			conn=getConnection();
			pstmt=getPreparedStatement(conn,sql);
			setPreparedStatementParam(pstmt,paramList);
			if(pstmt==null)
				return null;
			rs=BaseDaoImpl.getResultSet(pstmt);
			queryList=fetchQueryList(rs);	
		}catch(Exception e){
			logger.info(e.getMessage());
		}finally{
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConn(conn);
		}
		return queryList;
	}
	
	private static void setPreparedStatementParam(PreparedStatement pstmt,List<Object> paramList)throws Exception{
		if(pstmt==null||paramList==null||paramList.isEmpty())
			return;
		DateFormat df=DateFormat.getDateTimeInstance();
		for(int i=0;i<paramList.size();i++){
			if(paramList.get(i) instanceof Integer){
				int paramValue=((Integer)paramList.get(i)).intValue();
				pstmt.setInt(i+1,paramValue);
			}
			else if(paramList.get(i) instanceof Float){
				float paramValue=((Float)paramList.get(i)).floatValue();
				pstmt.setFloat(i+1,paramValue);
			}
			else if(paramList.get(i) instanceof Double){
				double paramValue=((Double)paramList.get(i)).doubleValue();
				pstmt.setDouble(i+1,paramValue);
			}
			else if(paramList.get(i) instanceof Date){
				pstmt.setString(i+1,df.format((Date)paramList.get(i)));
			}
			else if(paramList.get(i) instanceof Long){
				long paramValue=((Long)paramList.get(i)).longValue();
				pstmt.setLong(i+1,paramValue);
			}
			else if(paramList.get(i) instanceof String){
				pstmt.setString(i+1,(String)paramList.get(i));
			}
		}
	}
	
	private static Connection getConnection()throws Exception{
		return DBConnection.getConnection();
	}
	
	private static PreparedStatement getPreparedStatement(Connection conn,String sql)throws Exception{
		if(conn==null||sql==null||sql.trim().equals(""))
			return null;
		PreparedStatement pstmt=conn.prepareStatement(sql.trim());
		return pstmt;
	}
	
	private static ResultSet getResultSet(PreparedStatement pstmt)throws Exception{
		if(pstmt==null)
			return null;
		ResultSet rs=pstmt.executeQuery();
		return rs;
	} 
	
	protected List<T> fetchQueryList(ResultSet rs)throws Exception{
		if(rs==null)
			return null;
		ResultSetMetaData rsMetaData=rs.getMetaData();
		int columnCount=rsMetaData.getColumnCount();
		List<T> objList=new ArrayList<T>();
		while(rs.next()){
			List<String> list=new ArrayList<String>();
			for(int i=0;i<columnCount;i++)
				list.add(rs.getString(i+1));
			objList.add(getModel(list));
		}
		return objList;
	}
	
	protected abstract T getModel(List<String>list);
	
	private static void closeConn(Connection conn){
		if(conn==null)
			return;
		try{
			conn.close();
		}catch(SQLException e){
			logger.info(e.getMessage());
		}
	}
	
	private static void closeStatement(Statement stmt){
		if(stmt==null)
			return;
		try{
			stmt.close();
		}catch(SQLException e){
			logger.info(e.getMessage());
		}
	}
	
	private static void closeResultSet(ResultSet rs){
		if(rs==null)
			return;
		try{
			rs.close();
		}catch(SQLException e){
			logger.info(e.getMessage());
		}
	}
}
