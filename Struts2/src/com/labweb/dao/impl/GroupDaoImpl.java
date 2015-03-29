package com.labweb.dao.impl;

import java.util.*;
import java.util.Map.Entry;

import com.labweb.dao.IGroupDao;
import com.labweb.model.Group;

public class GroupDaoImpl extends TotalBaseDaoImpl implements IGroupDao{
	
	public GroupDaoImpl(){
		doCreate(TABLE_GROUP);
	}
	
	@Override
	public List<Group> getGroupIntro() {
		// TODO Auto-generated method stub
		List<Map<String,String>> totalGroup=getTotalList();
		List<Group> groupList=new ArrayList<Group>();
		for(Map<String,String> groupMap: totalGroup){
			Iterator<Entry<String,String>> groupEntryIt=groupMap.entrySet().iterator();
			Group group=new Group();
			while(groupEntryIt.hasNext()){
				Entry<String,String> groupEntry=groupEntryIt.next();
				String value=groupEntry.getValue();
				switch(groupEntry.getKey()){
					case GROUP_ID:group.setGroupId(value);break;
					case GROUP_PIC:group.setGroupPic(value);break;
					case GROUP_NAME:group.setGroupName(value);break;
					case GROUP_INTRO:group.setGroupIntro(value);break;
					default:break;
				}
			}
			groupList.add(group);
		}
		return groupList;
	}

}
