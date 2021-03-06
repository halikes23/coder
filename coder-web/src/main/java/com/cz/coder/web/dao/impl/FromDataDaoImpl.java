package com.cz.coder.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cz.coder.common.dao.BaseDAO;
import com.cz.coder.common.entity.vo.ColumnVO;
import com.cz.coder.web.dao.dao.FromDataDao;

/**
 * 
 * @ClassName LoginDaoImpl  
 * @Description 登录实现类  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-2-26
 */
@Repository
public class FromDataDaoImpl extends BaseDAO implements FromDataDao {

	@Override
	public List<String> selectAllDatabases() {
		return (List<String>)this.getSqlMapClientTemplate().queryForList("FromData.selectAllDatabases");
	}

	@Override
	public List<String> selectTablesBySchema(String schema) {
		return (List<String>)this.getSqlMapClientTemplate().queryForList("FromData.selectTablesByDatabase",schema);
	}

	@Override
	public List<ColumnVO> selectColumnsByTable(String schema , String table) {
		Map<String,Object> params = new HashMap<String,Object>() ;
		params.put("schema", schema) ;
		params.put("table", table) ;
		return (List<ColumnVO>)this.getSqlMapClientTemplate().queryForList("FromData.selectColumnsByTable",params);
	}


}
