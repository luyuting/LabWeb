package com.labweb.db;

import java.sql.*;
import java.text.DateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Logger;

public class DatabaseUtil{
	private static Logger logger=Logger.getLogger("DatabaseUtil");
	
	public static int execute(String sql,List<Object> paramList) throws Exception{
		if(sql==null||sql.trim().equals("")){
			logger.info("parameter is valid!");
			return -1;
		}
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try{
			conn=DatabaseUtil.getConnection();
			pstmt=DatabaseUtil.getPreparedStatement(conn,sql);
			setPreparedStatementParam(pstmt,paramList);
			if(pstmt==null)
				return -2;
			result=pstmt.executeUpdate();
		}catch(Exception e){
			logger.info(e.getMessage());
			throw new Exception(e);
		}finally{
			closeStatement(pstmt);
			closeConn(conn);
		}
		return result;
	}
	
	public static int getRecordNum(String sql){
		if(sql==null||sql.trim().equals(""))
			return -1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try{
			conn=DatabaseUtil.getConnection();
			pstmt=DatabaseUtil.getPreparedStatement(conn,sql);
			result=0;//pstmt.executeQuery();
		}catch(Exception e){
		}finally{
			closeStatement(pstmt);
			closeConn(conn);
		}
		return result;
	}
	
	public static List<Map<String,String>> getQueryList(String sql,List<Object> paramList)throws Exception{
		if(sql==null||sql.trim().equals("")){
			logger.info("parameter is valid!");
			return null;
		}
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Map<String,String>> queryList=null;
		try{
			conn=DatabaseUtil.getConnection();
			pstmt=DatabaseUtil.getPreparedStatement(conn,sql);
			setPreparedStatementParam(pstmt,paramList);
			if(pstmt==null)
				return null;
			rs=DatabaseUtil.getResultSet(pstmt);
			queryList=DatabaseUtil.fetchQueryList(rs);	
		}catch(RuntimeException e){
			logger.info(e.getMessage());
			throw new Exception(e);
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
	
	private static List<Map<String,String>> fetchQueryList(ResultSet rs)throws Exception{
		if(rs==null)
			return null;
		ResultSetMetaData rsMetaData=rs.getMetaData();
		int columnCount=rsMetaData.getColumnCount();
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		while(rs.next()){
			Map<String,String> dataMap=new HashMap<String,String>();
			for(int i=0;i<columnCount;i++)
				dataMap.put(rsMetaData.getColumnName(i+1),rs.getString(i+1));
			dataList.add(dataMap);
		}
		return dataList;
	}
	
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
