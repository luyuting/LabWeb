package com.breaktime.model;

import java.util.List;

public class Type extends BaseModel{
	private static final long serialVersionUID = 1L;
	private String typeId;
	private String typeName;
	private String typePic;
	
	public void setTypeId(String typeId){
		this.typeId=typeId;
	}
	
	public String getTypeId(){
		return typeId;
	}
	
	public void setTypeName(String typeName){
		this.typeName=typeName;
	}
	
	public String getTypeName(){
		return typeName;
	}
	
	public void setTypePic(String typePic){
		this.typePic=typePic;
	}
	
	public String getTypePic(){
		return typePic;
	}
	
	public Type(){
	}
	
	public Type(List<String> list){
		this.typeId=list.get(0);
		this.typeName=list.get(1);
		this.typePic=list.get(2);
	}
}
