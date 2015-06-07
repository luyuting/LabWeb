package com.breaktime.action;

import java.util.*;

import com.breaktime.dao.factory.DaoFactory;
import com.breaktime.dao.inter.IOrderDao;
import com.breaktime.model.*;

public class OrderAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private IOrderDao orderDao=DaoFactory.getOrderDaoInstance();
	private Order order=new Order();
	
	private int numPerPage=10;
	private int pageIndex;
	
	public void setPageIndex(int pageIndex){
		this.pageIndex=pageIndex;
	}
	
	public void setOrderId(String orderId){
		order.setOrderId(orderId);
	}
	
	public void setOrderUser(String orderUser){
		order.setOrderUser(orderUser);
	}
	
	public void setOrderGetTime(String orderGetTime){
		order.setOrderGetTime(orderGetTime);
	}
	
	public void setOrderState(String orderState){
		order.setOrderState(orderState);
	}

	public void setOrderPrice(float orderPrice){
		order.setOrderPrice(orderPrice);
	}
	
	public void setOrderDemand(String orderDemand){
		order.setOrderDemand(orderDemand);
		
	}

	public void setOrderTime(String orderTime){
		order.setOrderTime(orderTime);
	}
	
	public void setDetailsList(List<Details> detailsList){
		order.setDetailsList(detailsList);
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		boolean mesg=false;
		if(orderDao.doSave(order)>0)
			mesg=true;
		this.setResultMesg(mesg,"²åÈë");
		return SUCCESS;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		boolean mesg=false;
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(order.getOrderId());
		if(orderDao.doDelete(paramList)>0)
			mesg=true;
		this.setResultMesg(mesg, "É¾³ý");
		return SUCCESS;
	}

	@Override
	public String select() {
		// TODO Auto-generated method stub
		List<Order> orderList=new ArrayList<Order>();
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(order.getOrderUser());
		paramList.add(pageIndex*(numPerPage-1));
		paramList.add(numPerPage);
		orderList=orderDao.doSelect(paramList);
		for(int i=0;i<orderList.size();i++){
			paramList.clear();
			paramList.add(orderList.get(i).getOrderId());
			orderList.get(i).setDetailsList(DaoFactory.getDetailsDaoInstance().doSelect(paramList));
		}
		this.setResultMesg(orderList);
		return SUCCESS;
	}
	

	
}
