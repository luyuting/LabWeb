package com.labweb.dao;

import java.util.*;

import com.labweb.model.*;

public interface INewsDao extends IBaseDao<News>{
	News getNews(List<Object> paramList); 
}