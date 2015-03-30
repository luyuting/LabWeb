package com.labweb.model;

import java.util.List;

public class News extends BaseModel{
	private static final long serialVersionUID = 1L;
	private String newsId;
	private String newsPic;
	private String newsPicTitle;
	private String newsTitle;
	private String newsAuthor;
	private String newsContent;
	private int newsReadNum;
	private String newsTime;
	
	public void setNewsId(String newsId){
		this.newsId=newsId;
	}
	
	public String getNewsId(){
		return newsId;
	}
	
	public void setNewsPic(String newsPic){
		this.newsPic=newsPic;
	}
	
	public String getNewsPic(){
		return newsPic;
	}
	
	public void setNewsPicTitle(String newsPicTitle){
		this.newsPicTitle=newsPicTitle;
	}
	
	public String getNewsPicTitle(){
		return newsPicTitle;
	}
	
	public void setNewsTitle(String newsTitle){
		this.newsTitle=newsTitle;
	}
	
	public String getNewsTitle(){
		return newsTitle;
	}
	
	public void setNewsAuthor(String newsAuthor){
		this.newsAuthor=newsAuthor;
	}
	
	public String getNewsAuthor(){
		return newsAuthor;
	}
	
	public void setNewsContent(String newsContent){
		this.newsContent=newsContent;
	}
	
	public String getNewsContent(){
		return newsContent;
	}
	
	public void setNewsReadNum(int newsReadNum){
		this.newsReadNum=newsReadNum;
	}
	
	public int getNewsReadNum(){
		return newsReadNum;
	}
	public void setNewsTime(String newsTime){
		this.newsTime=newsTime;
	}
	
	public String getNewsTime(){
		return newsTime;
	}
	
	public News(){
	}
	
	public News(List<String> list){
		this.newsId=list.get(0);
		this.newsPic=list.get(1);
		this.newsPicTitle=list.get(2);
		this.newsTitle=list.get(3);
		this.newsAuthor=list.get(4);
		this.newsContent=list.get(5);
		this.newsReadNum=Integer.parseInt(list.get(6));
		this.newsTime=list.get(7);	
	}
}
