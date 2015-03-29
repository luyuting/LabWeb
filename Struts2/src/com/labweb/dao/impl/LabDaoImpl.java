package com.labweb.dao.impl;

import java.util.*;
import java.util.Map.Entry;

import com.labweb.dao.ILabDao;
import com.labweb.model.Lab;

public class LabDaoImpl extends TotalBaseDaoImpl implements ILabDao{

	public LabDaoImpl(){
		doCreate(TABLE_LAB);
	}
	
	@Override
	public Lab getLabIntro() {
		// TODO Auto-generated method stub
		Map<String,String> labMap=null;
		try{
			labMap=getTotalList().get(0);
		}catch(Exception e){
			return null;
		}
		Iterator<Entry<String,String>> labEntryIt=labMap.entrySet().iterator();
		Lab lab=new Lab();
		while(labEntryIt.hasNext()){
			Entry<String,String> labEntry=labEntryIt.next();
			String value=labEntry.getValue();
			switch(labEntry.getKey()){
				case LAB_ID:lab.setLabId(value);break;
				case LAB_NAME:lab.setLabName(value);break;
				case LAB_CONTENT:lab.setLabContent(value);break;
				default:break;
			}
		}
		return lab;
	}

}
