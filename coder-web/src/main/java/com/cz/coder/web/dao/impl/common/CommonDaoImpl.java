package com.fq.dao.impl.common;

import org.springframework.stereotype.Repository;

import com.fq.dao.BaseDAO;
import com.fq.dao.dao.common.CommonDAO;
@Repository
public class CommonDaoImpl extends BaseDAO implements CommonDAO {

	@Override
	public void createResourceAccessData() {
		this.getSqlMapClientTemplate().update("createMovieAccessData");
		this.getSqlMapClientTemplate().update("createProjectAccessData") ;
	}

}
