package com.labweb.dao.impl;

import java.util.*;
import java.util.Map.Entry;

import com.labweb.dao.*;
import com.labweb.db.DatabaseUtil;
import com.labweb.model.*;

public class NewsDaoImpl extends PageBaseDaoImpl implements INewsDao{
	
	public NewsDaoImpl(){
		doCreate(TABLE_NEWS,NEWS_TIME);
	}
	
	@Override
	public boolean writeNews(News news) {
		// TODO Auto-generated method stub
		String addSql="insert into "+TABLE_NEWS+" values(uuid(),?,?,?,?,?,0,now())";
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(news.getNewsPic());
		paramList.add(news.getNewsPicTitle());
		paramList.add(news.getNewsTitle());
		paramList.add(news.getNewsAuthor());
		paramList.add(news.getNewsContent());
		return addRecord(addSql, paramList);
	}

	@Override
	public boolean addReadNum(String newsId) {
		// TODO Auto-generated method stub
		boolean result=false;
		String addSql="update "+TABLE_NEWS+" set "+NEWS_READ_NUM+
				"=1+"+NEWS_READ_NUM+" where "+NEWS_ID+"=?";
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(newsId);
		int insert=0;
		try {
			insert=DatabaseUtil.execute(addSql, paramList);
		} catch (Exception e) {}
		if(insert>0)
			result=true;
		return result;
	}

	@Override
	public List<News> getPageNewsList(int pageIndex,int numPerPage) {
		// TODO Auto-generated method stub
		List<Map<String, String>> pageNews=getPageMap(pageIndex, numPerPage);
		List<News> newsList=new ArrayList<News>();
		for(Map<String,String> newsMap: pageNews){
			Iterator<Entry<String,String>> newsEntryIt=newsMap.entrySet().iterator();
			News news=new News();
			while(newsEntryIt.hasNext()){
				Entry<String,String> newsEntry=newsEntryIt.next();
				String value=newsEntry.getValue();
				switch(newsEntry.getKey()){
					case NEWS_ID:news.setNewsId(value);break;
					case NEWS_PIC:news.setNewsPic(value);break;
					case NEWS_PIC_TITLE:news.setNewsPicTitle(value);break;
					case NEWS_TITLE:news.setNewsTitle(value);break;
					case NEWS_AUTHOR:news.setNewsAuthor(value);break;
					case NEWS_CONTENT:news.setNewsContent(value);break;
					case NEWS_READ_NUM:news.setNewsReadNum(Integer.parseInt(value));break;
					case NEWS_TIME:news.setNewsTime(value);break;
					default:break;
				}
			}
			newsList.add(news);
		}
		return newsList;
	}

}
