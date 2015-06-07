package com.breaktime.model;

import java.util.List;

public class Drink extends BaseModel{
	private static final long serialVersionUID = 1L;
	
	private String drinkId;
	private String drinkName;
	private String drinkPic;
	private float drinkOriPrice;
	private float drinkNewPrice;
	private String drinkState;
	private int drinkSaleNum;
	private String drinkIntro;
	private String drinkType;
	
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
	
	public void setDrinkPic(String drinkPic){
		this.drinkPic=drinkPic;
	}
	
	public String getDrinkPic(){
		return drinkPic;
	}
	
	public void setDrinkOriPrice(float drinkOriPrice){
		this.drinkOriPrice=drinkOriPrice;
	}
	
	public float getDrinkOriPrice(){
		return drinkOriPrice;
	}
	
	public void setDrinkNewPrice(float drinkNewPrice){
		this.drinkNewPrice=drinkNewPrice;
	}
	
	public float getDrinkNewPrice(){
		return drinkNewPrice;
	}
	
	public void setDrinkState(String drinkState){
		this.drinkState=drinkState;
	}
	
	public String getDrinkState(){
		return drinkState;
	}
	
	public void setDrinkSaleNum(int drinkSaleNum){
		this.drinkSaleNum=drinkSaleNum;
	}
	
	public int getDrinkSaleNum(){
		return drinkSaleNum;
	}
	
	public void setDrinkIntro(String drinkIntro){
		this.drinkIntro=drinkIntro;
	}
	
	public String getDrinkIntro(){
		return drinkIntro;
	}
	
	public void setDrinkType(String drinkType){
		this.drinkType=drinkType;
	}
	
	public String getDrinkType(){
		return drinkType;
	}
	
	public Drink(){
		
	}
	
	public Drink(List<String> list) {
		this.drinkId=list.get(0);
		this.drinkName=list.get(1);
		this.drinkPic=list.get(2);
		this.drinkOriPrice=Float.parseFloat(list.get(3));
		this.drinkNewPrice=Float.parseFloat(list.get(4));
		this.drinkState=list.get(5);
		this.drinkSaleNum=Integer.parseInt(list.get(6));
		this.drinkIntro=list.get(7);
		this.drinkType=list.get(8);
	}
}
