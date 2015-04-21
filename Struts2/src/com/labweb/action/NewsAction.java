package com.labweb.action;

import java.util.*;

import com.labweb.dao.INewsDao;
import com.labweb.dao.impl.NewsDaoImpl;
import com.labweb.model.News;

public class NewsAction extends PageBaseAction<News> {
	private static final long serialVersionUID = 1L;
	private INewsDao newsDao=null;
	private News news=new News();
	
	public NewsAction(){
		super(NewsDaoImpl.class,10);
		newsDao=(NewsDaoImpl)dao;
	}
	
	public void setNewsId(String newsId){
		this.news.setNewsId(newsId);
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
	
	public String execute(){
		this.setResultMesg(newsDao.doSelect(selectParamList()), newsDao.doCount());
		return SUCCESS;	
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(news.getNewsPic());
		paramList.add(news.getNewsPicTitle());
		paramList.add(news.getNewsTitle());
		paramList.add(news.getNewsAuthor());
		paramList.add(news.getNewsContent());
		paramList.add(news.getNewsId());
		setResultMesg(newsDao.doUpdate(paramList), "¸üÐÂ");
		return SUCCESS;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(news.getNewsPic());
		paramList.add(news.getNewsPicTitle());
		paramList.add(news.getNewsTitle());
		paramList.add(news.getNewsAuthor());
		paramList.add(news.getNewsContent());
		setResultMesg(newsDao.doInsert(paramList), "²åÈë");
		return SUCCESS;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(news.getNewsId());
		setResultMesg(newsDao.doDelete(paramList), "É¾³ý");
		return SUCCESS;
	}

	@Override
	public String getById() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(news.getNewsId());
		resultMesg.clear();
		resultMesg.put("result", newsDao.getNews(paramList));
		return SUCCESS;
	}
}
