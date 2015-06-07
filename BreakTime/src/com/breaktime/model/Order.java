package com.breaktime.model;

import java.util.List;

public class Order extends BaseModel{
	private static final long serialVersionUID = 1L;
	private String orderId;
	private String orderUser;
	private String orderGetTime;
	private String orderState;
	private float orderPrice;
	private String orderDemand;
	private String orderTime;
	private List<Details> detailsList;
	
	public void setOrderId(String orderId){
		this.orderId=orderId;
	}
	
	public String getOrderId(){
		return orderId;
	}
	
	public void setOrderUser(String orderUser){
		this.orderUser=orderUser;
	}
	
	public String getOrderUser(){
		return orderUser;
	}
	
	public void setOrderGetTime(String orderGetTime){
		this.orderGetTime=orderGetTime;
	}
	
	public String getOrderGetTime(){
		return orderGetTime;
	}
	
	public void setOrderState(String orderState){
		this.orderState=orderState;
	}
	
	public String getOrderState(){
		return orderState;
	}
	
	public void setOrderPrice(float orderPrice){
		this.orderPrice=orderPrice;
	}
	
	public float getOrderPrice(){
		return orderPrice;
	}
	
	public void setOrderDemand(String orderDemand){
		this.orderDemand=orderDemand;
	}
	
	public String getOrderDemand(){
		return orderDemand;
	}
	
	public void setOrderTime(String orderTime){
		this.orderTime=orderTime;
	}
	
	public String getOrderTime(){
		return orderTime;
	}
	
	public void setDetailsList(List<Details> detailsList){
		this.detailsList=detailsList;
	}
	
	public List<Details> getDetailsList(){
		return detailsList;
	}
	
	public Order(){
		
	}
	
	public Order(List<String> list){
		this.orderId=list.get(0);
		this.orderUser=list.get(1);
		this.orderGetTime=list.get(2);
		this.orderState=list.get(3);
		this.orderPrice=Float.parseFloat(list.get(4));
		this.orderDemand=list.get(5);
		this.orderTime=list.get(6);
	}
}
