package com.breaktime.dao.impl;

import java.util.*;

import com.breaktime.dao.inter.IDrinkDao;
import com.breaktime.model.Drink;

public class DrinkDaoImpl extends BaseDaoImpl<Drink> implements IDrinkDao{

	@Override
	protected Drink getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new Drink(list);
	}

	@Override
	public int doSave(Drink obj) {
		// TODO Auto-generated method stub
		List<Object> paramList=new ArrayList<Object>();
		paramList.add(obj.getDrinkName());
		paramList.add(obj.getDrinkPic());
		paramList.add(obj.getDrinkOriPrice());
		paramList.add(obj.getDrinkNewPrice());
		paramList.add(obj.getDrinkState());
		paramList.add(obj.getDrinkSaleNum());
		paramList.add(obj.getDrinkIntro());
		paramList.add(obj.getDrinkType());
		String sql="insert into t_drink values(uuid(),?,?,?,?,?,?,?,(select "
				+ " type_id from t_type where type_name=?))";
		return this.execute(sql, paramList);
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="update t_drink set drink_new_price=? where"
				+ " drink_id=?";
		return this.execute(sql, paramList);
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="update t_drink set drink_state='Õ£ €' where"
				+ " drink_id=?";
		return this.execute(sql, paramList);
	}

	@Override
	public List<Drink> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select drink_id,drink_name,drink_pic,drink_ori_price,"
				+ "drink_new_price,drink_state,drink_sale_num,drink_intro,"
				+ "type_name from t_drink,t_type where type_id=drink_type "
				+ "and drink_state<>'Õ£ €' and type_name=? order by "
				+ "drink_sale_num limit ?,?";
		return this.getQueryList(sql, paramList);
	}

}
