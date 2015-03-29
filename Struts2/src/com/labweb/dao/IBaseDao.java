package com.labweb.dao;

public interface IBaseDao{
	/**
	 * t_new 表
	 */
	String TABLE_NEWS="t_news";
	
	String NEWS_ID="news_id";
	String NEWS_PIC="news_pic";
	String NEWS_PIC_TITLE="news_pic_title";
	String NEWS_TITLE="news_title";
	String NEWS_AUTHOR="news_author";
	String NEWS_CONTENT="news_content";
	String NEWS_READ_NUM="news_read_num";
	String NEWS_TIME="news_time";
	
	/**
	 * t_mesg表
	 */
	String TABLE_MESG="t_mesg";
	
	String MESG_ID="mesg_id";
	String MESG_CONTENT="mesg_content";
	String MESG_TIME="mesg_time";
	
	/**
	 * t_projintro表
	 */
	String TABLE_PROJECT="t_projintro";
	
	String PROJECT_ID="proj_id";
	String PROJECT_PIC="proj_pic";
	String PROJECT_NAME="proj_name";
	String PROJECT_CONTENT="proj_content";
	String PROJECT_TIME="proj_time";
	
	/**
	 * t_labintro表
	 */
	String TABLE_LAB="t_labintro";
	
	String LAB_ID="lab_id";
	String LAB_NAME="lab_name";
	String LAB_CONTENT="lab_intro_content";
	
	/**
	 * t_group表 
	 */
	String TABLE_GROUP="t_group";
	
	String GROUP_ID="gro_id";
	String GROUP_PIC="gro_pic";
	String GROUP_NAME="gro_name";
	String GROUP_INTRO="gro_intro";
	
	/**
	 * t_admin表
	 */
	String TABLE_ADMIN="t_admin";
	
	String ADMIN_ACCOUNT="ad_account";
	String ADMIN_PASSWORD="ad_password";
	String ADMIN_NAME="ad_name";
}