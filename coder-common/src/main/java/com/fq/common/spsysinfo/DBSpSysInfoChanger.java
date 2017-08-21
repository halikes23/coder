package com.fq.common.spsysinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.dao.SpSysInfoDAO;
import com.fq.entity.SpSysInfo;


/**
 * 系统参数数据库修改器
 * @author zhen.cheng
 *
 */
@Service
public class DBSpSysInfoChanger implements SpSysInfoChanger {

	@Autowired
	private SpSysInfoDAO spSysInfoDAO ;
	
	public void change(SpSysInfo spSysInfo) {

		SpSysInfo rst = spSysInfoDAO.selectLevel3SpSysInfo(Level3SpSysInfoKey.build(spSysInfo.getKey1(), spSysInfo.getKey2(), spSysInfo.getKey3()));
		
		if(rst == null){
			spSysInfoDAO.insertSpSysInfo(spSysInfo) ;
		}else{
			spSysInfoDAO.updateSpSysInfo(spSysInfo) ;
		}
		
	}

	public SpSysInfoDAO getSpSysInfoDAO() {
		return spSysInfoDAO;
	}

	public void setSpSysInfoDAO(SpSysInfoDAO spSysInfoDAO) {
		this.spSysInfoDAO = spSysInfoDAO;
	}
	
	

}
