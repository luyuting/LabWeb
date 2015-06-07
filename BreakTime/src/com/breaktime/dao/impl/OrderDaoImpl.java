package com.breaktime.dao.impl;

import java.util.*;

import com.breaktime.dao.inter.IOrderDao;
import com.breaktime.model.Details;
import com.breaktime.model.Order;

public class OrderDaoImpl extends BaseDaoImpl<Order> implements IOrderDao{

	@Override
	protected Order getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new Order(list);
	}

	@Override
	public int doSave(Order obj) {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		String uuid=UUID.randomUUID().toString();
		paramList.add(uuid);
		paramList.add(obj.getOrderUser());
		paramList.add(obj.getOrderGetTime());
		paramList.add(obj.getOrderState());
		paramList.add(obj.getOrderPrice());
		paramList.add(obj.getOrderDemand());
		String sql="insert into t_order values(?,?,?,?,?,?,now())";
		int result=this.execute(sql, paramList);
		List<Details> detailsList=obj.getDetailsList();
		String detSql="insert into t_detail values(?,?,?,?,?)";
		for(int i=0;i<detailsList.size();i++){
			Details det=detailsList.get(i);
			paramList.clear();
			paramList.add(uuid);
			paramList.add(det.getDrinkId());
			paramList.add(det.getDrinkPrice());
			paramList.add(det.getDrinkNum());
			paramList.add(det.getDrinkBargin());
			this.execute(detSql, paramList);
			paramList.clear();
			paramList.add(det.getDrinkNum());
			paramList.add(det.getDrinkId());
			String addSql="update t_drink set drink_sale_num+=?"
					+ " where drink_id=?";
			this.execute(addSql, paramList);
		}
		return result;
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		int result=0;
		String delOrderSql="delete from t_order where order_id=?";
		String delDetailsSql="delete from t_detail where detail_order=?";
		if((result=this.execute(delOrderSql, paramList))==1)
			this.execute(delDetailsSql, paramList);
		return result;
	}

	@Override
	public List<Order> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_order where order_user=? order by "
				+ "order_time desc limit ?,?";
		return this.getQueryList(sql, paramList);
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		return 0;
	}
}
