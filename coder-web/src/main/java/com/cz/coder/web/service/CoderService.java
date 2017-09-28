package com.cz.coder.web.service;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class CoderService {

	private final static Logger logger = LoggerFactory.getLogger(CoderService.class) ;

	public boolean checkHasInit() {
		
		File file = new File("/usr/local/coder/conf/coder.conf");
		
		if(!file.exists()){
			logger.info("系统没有初始化！");
			return true ;
		}
		
		return false;
	}


	public void init() throws IOException {
		File interfaceDir = new File("/usr/local/coder/data/interfaceDir");
		if(!interfaceDir.exists()){
			interfaceDir.mkdirs() ;
		}
		File confDir = new File("/usr/local/coder/conf");
		if(!confDir.exists()){
			confDir.mkdirs() ;
		}
		File conf = new File("/usr/local/coder/conf/coder.conf");
		if(!conf.exists()){
			conf.createNewFile() ;
		}
	}

}
