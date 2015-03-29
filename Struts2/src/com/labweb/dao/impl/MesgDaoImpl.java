package com.labweb.dao.impl;

import java.util.*;
import java.util.Map.Entry;

import com.labweb.dao.IMesgDao;
import com.labweb.model.Message;

public class MesgDaoImpl extends PageBaseDaoImpl implements IMesgDao{
	
	public MesgDaoImpl(){
		doCreate(TABLE_MESG,MESG_TIME);
	}
	
	@Override
	public boolean writeMesg(Message mesg) {
		// TODO Auto-generated method stub
		String addSql="insert into "+TABLE_MESG+" values(uuid(),?,now())";
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(mesg.getMesgContent());
		return addRecord(addSql, paramList);
	}
	
	@Override
	public List<Message> getPageMesgList(int pageIndex, int numPerPage) {
		// TODO Auto-generated method stub
		List<Map<String, String>> pageMesg=getPageMap(pageIndex, numPerPage);
		List<Message> mesgList=new ArrayList<Message>();
		for(Map<String,String> mesgMap:pageMesg){
			Iterator<Entry<String,String>> mesgEntryIt=mesgMap.entrySet().iterator();
			Message mesg=new Message();
			while(mesgEntryIt.hasNext()){
				Entry<String,String> mesgEntry=mesgEntryIt.next();
				String value=mesgEntry.getValue();
				switch(mesgEntry.getKey()){
					case MESG_ID:mesg.setMesgId(value);break;
					case MESG_CONTENT:mesg.setMesgContent(value);break;
					case MESG_TIME:mesg.setMesgTime(value);break;
					default:break;
				}
			}
			mesgList.add(mesg);
		}
		return mesgList;
	}

}
