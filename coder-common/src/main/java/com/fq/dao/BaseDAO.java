package com.fq.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseDAO extends SqlMapClientDaoSupport {

	@Autowired
    @Qualifier("sqlMapClient")
    public void setSqlMapClientForAutowired(SqlMapClient sqlMapClient) {
        super.setSqlMapClient(sqlMapClient);
    }
	
}
