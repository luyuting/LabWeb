package com.labweb.action;

import java.util.*;

import com.labweb.dao.factory.DaoFactory;
import com.labweb.model.News;
import com.opensymphony.xwork2.ActionSupport;

public class NewsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private int pageIndex;
	private int numPerPage=5;
	
	private News news=new News();
			
	private Map<String,Object> newsMap=new HashMap<String,Object>();
	
	public void setPageIndex(int pageIndex){
		this.pageIndex=pageIndex;
	}
	
	public int getPageIndex(){
		return pageIndex;
	}
	
	
	public void setNewsPic(String newsPic){
		this.news.setNewsPic(newsPic);
	}
	
	public void setNewsPicTitle(String newsPicTitle){
		this.news.setNewsPicTitle(newsPicTitle);
	}
	
	public void setNewsTitle(String newsTitle){
		this.news.setNewsTitle(newsTitle);
	}
	
	
	public void setNewsAuthor(String newsAuthor){
		this.news.setNewsAuthor(newsAuthor);
	}
	
	public void setNewsContent(String newsContent){
		this.news.setNewsContent(newsContent);
	}
	
	public Map<String,Object> getNewsMap(){
		return newsMap;
	}
	public String execute(){
		List<News> newsList=DaoFactory.getNewsDaoInstance().getPageNewsList(pageIndex,numPerPage);
		int newsCount=DaoFactory.getNewsDaoInstance().getAcount();
		int newsPage=newsCount/numPerPage;
		if(newsCount%numPerPage!=0)
			newsPage++;
		newsMap.put("newsList", newsList);
		newsMap.put("newsCount", newsCount);
		newsMap.put("newsPage", newsPage);
		newsMap.put("newsPageIndex", pageIndex);
		return SUCCESS;
	}
	
	public String write(){
		DaoFactory.getNewsDaoInstance().writeNews(news);
		return SUCCESS;
	}
	
	public String read(){
		DaoFactory.getNewsDaoInstance().addReadNum(news.getNewsId());
		return SUCCESS;
	}
}
