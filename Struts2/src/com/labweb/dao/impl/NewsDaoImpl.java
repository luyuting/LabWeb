package com.labweb.dao.impl;

import java.util.*;

import com.labweb.dao.INewsDao;
import com.labweb.model.*;

public class NewsDaoImpl extends BaseDaoImpl<News> implements INewsDao{

	@Override
	public int doInsert(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="insert into t_news values(uuid,?,?,?,?,?,0,now())";
		return execute(sql, paramList);
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="update t_news set news_pic=?,news_pic=?,"
				+ "news_pic_title,news_title=?,news_author=?,"
				+ "news_content=? news_time=now() where news_id=?";
		return execute(sql, paramList);
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="delete from t_news where news_id=?";
		return execute(sql, paramList);
	}

	@Override
	public List<News> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_news order by news_time desc limit ?,?";
		return getQueryList(sql, paramList);
	}

	@Override
	public int doCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from t_news";
		return getCount(sql, null);
	}

	@Override
	public News getNews(List<Object> paramList) {
		// TODO Auto-generated method stub
		String numSql="update t_news set news_read_num=news_read_num+1"
				+ " where news_id=?";
		execute(numSql, paramList);
		String sql="select * from t_news where news_id=?";
		return getQueryList(sql, paramList).get(0);
	}

	@Override
	protected News getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new News(list);
	}
}