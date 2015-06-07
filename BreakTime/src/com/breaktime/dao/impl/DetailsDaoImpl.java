package com.breaktime.dao.impl;

import java.util.List;

import com.breaktime.dao.inter.IDetailsDao;
import com.breaktime.model.Details;

public class DetailsDaoImpl extends BaseDaoImpl<Details> implements IDetailsDao{

	@Override
	protected Details getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new Details(list);
	}

	@Override
	public List<Details> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select detail_drink,drink_name,detail_price,detail_num,"
				+ "detail_bargin from t_detail,t_drink where detail_drink="
				+ "drink_id and detail_order=?";
		return this.getQueryList(sql, paramList);
	}

	@Override
	public int doSave(Details obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
