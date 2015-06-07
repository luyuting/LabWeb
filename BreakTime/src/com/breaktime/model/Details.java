package com.breaktime.model;

import java.util.List;

public class Details extends BaseModel{
	private static final long serialVersionUID = 1L;
	private String drinkId;
	private String drinkName;
	private float drinkPrice;
	private int drinkNum;
	private boolean drinkBargin;
	
	public void setDrinkId(String drinkId){
		this.drinkId=drinkId;
	}
	
	public String getDrinkId(){
		return drinkId;
	}
	
	public void setDrinkName(String drinkName){
		this.drinkName=drinkName;
	}
	
	public String getDrinkName(){
		return drinkName;
	}
	
	public void setDrinkPrice(float drinkPrice){
		this.drinkPrice=drinkPrice;
	}
	
	public float getDrinkPrice(){
		return drinkPrice;
	}
	
	public void setDrinkNum(int drinkNum){
		this.drinkNum=drinkNum;
	}
	
	public int getDrinkNum(){
		return drinkNum;
	}
	
	public void isDrinkBargin(boolean drinkBargin){
		this.drinkBargin=drinkBargin;
	}
	
	public boolean getDrinkBargin(){
		return drinkBargin;
	}
	
	public Details(){
		
	}
	
	public Details(List<String> list){
		this.drinkId=list.get(0);
		this.drinkName=list.get(1);
		this.drinkPrice=Float.parseFloat(list.get(2));
		this.drinkNum=Integer.parseInt(list.get(3));
		this.drinkBargin=Boolean.parseBoolean(list.get(4));
	}
		
}
