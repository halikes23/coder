package com.cz.coder.web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cz.coder.common.dao.BaseDAO;
import com.cz.coder.common.entity.vo.InterfaceFileVO;
import com.cz.coder.web.dao.dao.FromInterfaceFileDao;

@Repository
public class FromInterfaceFileDaoImpl extends BaseDAO implements FromInterfaceFileDao{

	@Override
	public List<InterfaceFileVO> selectInterfaceFiles(String interfaceName) {
		return this.getSqlMapClientTemplate().queryForList("FromInterfaceFile.selectInterfaceFiles" , interfaceName) ;
	}

	
	
}
