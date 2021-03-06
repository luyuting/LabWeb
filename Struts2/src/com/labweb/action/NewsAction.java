package com.labweb.action;

import java.util.*;

import com.labweb.dao.INewsDao;
import com.labweb.dao.impl.NewsDaoImpl;
import com.labweb.model.News;

public class NewsAction extends PageBaseAction<News> {
	private static final long serialVersionUID = 1L;
	private INewsDao newsDao=null;
	private News news;
	
	public NewsAction(){
		super(NewsDaoImpl.class,10);
		newsDao=(NewsDaoImpl)dao;
	}
	public void setNews(News news){
		this.news=news;
	}
	
	public News getNews(){
		return news;
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
		setResultMesg(newsDao.doUpdate(paramList), "����");
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
		setResultMesg(newsDao.doInsert(paramList), "����");
		return SUCCESS;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(news.getNewsId());
		setResultMesg(newsDao.doDelete(paramList), "ɾ��");
		return SUCCESS;
	}

	@Override
	public String getById() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(news.getNewsId());
		setResultMesg(newsDao.getNews(paramList));
		return SUCCESS;
	}
}
