package com.labweb.dao;

import java.util.*;

import com.labweb.model.*;

public interface INewsDao extends IPageBaseDao{
	boolean writeNews(News news);
	boolean addReadNum(String newsId);
	List<News> getPageNewsList(int pageIndex,int numPerPage);
}
