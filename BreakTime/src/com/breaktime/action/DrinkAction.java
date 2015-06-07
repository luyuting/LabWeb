package com.breaktime.action;

import java.util.*;

import com.breaktime.dao.factory.DaoFactory;
import com.breaktime.dao.inter.IDrinkDao;
import com.breaktime.model.Drink;

public class DrinkAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private IDrinkDao drinkDao=DaoFactory.getDrinkDaoInstance();
	private Drink drink=new Drink();

	
	public void setDrinkId(String drinkId){
		this.drink.setDrinkId(drinkId);
	}
	
	public void setDrinkName(String drinkName){
		this.drink.setDrinkName(drinkName);
	}
	
	public void setDrinkPic(String drinkPic){
		this.drink.setDrinkPic(drinkPic);
	}
	
	public void setDrinkOriPrice(float drinkOriPrice){
		this.drink.setDrinkOriPrice(drinkOriPrice);
	}
	
	public void setDrinkNewPrice(float drinkNewPrice){
		this.drink.setDrinkNewPrice(drinkNewPrice);
	}
	
	public void setDrinkState(String drinkState){
		this.drink.setDrinkState(drinkState);
	}

	public void setDrinkSaleNum(int drinkSaleNum){
		this.drink.setDrinkSaleNum(drinkSaleNum);
	}
	
	public void setDrinkIntro(String drinkIntro){
		this.drink.setDrinkIntro(drinkIntro);
	}
	
	public void setDrinkType(String drinkType){
		this.drink.setDrinkType(drinkType);
	}
	@Override
	public String insert() {
		// TODO Auto-generated method stub
		boolean mesg=false;
		if(drinkDao.doSave(drink)>0)
			mesg=true;
		this.setResultMesg(mesg, "插入");
		return SUCCESS;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		boolean mesg=false;
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(drink.getDrinkNewPrice());
		paramList.add(drink.getDrinkId());
		if(drinkDao.doUpdate(paramList)==1)
			mesg=true;
		this.setResultMesg(mesg, "更新");
		return SUCCESS;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		boolean mesg=false;
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(drink.getDrinkId());
		if(drinkDao.doDelete(paramList)==1)
			mesg=true;
		this.setResultMesg(mesg, "删除");
		return SUCCESS;
	}

	//下拉，不用显示页数，管理员需要显示页数。
	@Override
	public String select() {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(drink.getDrinkType());
		paramList.add(pageIndex*(numPerPage-1));
		paramList.add(numPerPage);
		this.setResultMesg(drinkDao.doSelect(paramList));
		return SUCCESS;
	}
	
}
