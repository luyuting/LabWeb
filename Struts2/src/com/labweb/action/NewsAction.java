package com.labweb.action;

import java.util.*;

import com.labweb.dao.INewsDao;
import com.labweb.dao.factory.DaoFactory;
import com.labweb.model.News;

public class NewsAction extends PageBaseAction<News> {
	private static final long serialVersionUID = 1L;
	private INewsDao newsDao=DaoFactory.getNewsDaoInstance();
	
	private News news=new News();
	
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
	
	public String execute(){
		
		return SUCCESS;	
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}
}
