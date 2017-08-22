package com.cz.coder.web.dao.dao;

import java.util.List;

import com.cz.coder.common.entity.vo.ColumnVO;

public interface CoderDao {

	List<String> selectAllDatabases() ;

	List<String> selectTablesBySchema(String schema);

	List<ColumnVO> selectColumnsByTable(String schema ,String table);
	
}
