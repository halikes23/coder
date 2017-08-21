package com.fq.dao.impl.oscar;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.fq.dao.BaseDAO;
import com.fq.dao.dao.oscar.OscarActiveDAO;

@Repository
public class OscarActiveDaoImpl extends BaseDAO implements OscarActiveDAO{

	@Override
	public void updateOscarActiveActorVoteCount(Integer oaId) {

		this.getSqlMapClientTemplate().update("OscarActive.updateOscarActiveActorVoteCount",oaId) ;
		
	}
	
	@Override
	public void updateOscarActiveBookVoteCount(Integer oaId) {

		this.getSqlMapClientTemplate().update("OscarActive.updateOscarActiveBookVoteCount",oaId) ;
		
	}

}
