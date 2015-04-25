package com.labweb.dao.impl;

import java.util.List;

import com.labweb.dao.IFileDao;
import com.labweb.model.UploadFile;

public class FileDaoImpl extends BaseDaoImpl<UploadFile> implements IFileDao{

	@Override
	public int doInsert(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="insert into t_file values(uuid(),?,?,now())";
		return execute(sql, paramList);
	}

	@Override
	public int doUpdate(List<Object> paramList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="delete from t_file where file_id=?";
		return execute(sql, paramList);
	}

	@Override
	public List<UploadFile> doSelect(List<Object> paramList) {
		// TODO Auto-generated method stub
		String sql="select * from t_file order by file_time desc";
		return getQueryList(sql, paramList);
	}

	@Override
	public int doCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from t_file";
		return getCount(sql, null);
	}

	@Override
	protected UploadFile getModel(List<String> list) {
		// TODO Auto-generated method stub
		return new UploadFile(list);
	}

}
