package com.cz.coder.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cz.coder.common.entity.vo.InterfaceFileVO;
import com.cz.coder.web.dao.dao.FromInterfaceFileDao;

@Service
public class FromInterfaceFileService {

	@Autowired
	private FromInterfaceFileDao fromInterfaceFileDao ;
	
	public List<InterfaceFileVO> queryInterfaceFiles(String interfaceName) {
		return this.fromInterfaceFileDao.selectInterfaceFiles(interfaceName);
	}

}
