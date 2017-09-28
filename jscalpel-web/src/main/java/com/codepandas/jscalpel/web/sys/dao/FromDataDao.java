package com.codepandas.jscalpel.web.sys.dao;

import java.util.List;

import com.cz.coder.common.entity.vo.ColumnVO;

public interface FromDataDao {

	List<String> selectAllDatabases() ;

	List<String> selectTablesBySchema(String schema);

	List<ColumnVO> selectColumnsByTable(String schema ,String table);
	
}
