package com.cz.coder.web.dao.dao;

import java.util.List;

import com.cz.coder.common.entity.vo.InterfaceFileVO;

public interface FromInterfaceFileDao {

	List<InterfaceFileVO> selectInterfaceFiles(String interfaceName);

}
