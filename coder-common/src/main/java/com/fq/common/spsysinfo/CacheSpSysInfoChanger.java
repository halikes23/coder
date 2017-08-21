package com.fq.common.spsysinfo;

import com.fq.entity.SpSysInfo;

/**
 * 系统参数缓存修改器
 * @author zhen.cheng
 *
 */
public class CacheSpSysInfoChanger implements SpSysInfoChanger{

	public void change(SpSysInfo spSysInfo) {
		
		Level3SpSysInfoKey key = Level3SpSysInfoKey.build(spSysInfo.getKey1(), spSysInfo.getKey2(), spSysInfo.getKey3()) ;
		
		SpSysInfoCache.put(key, spSysInfo) ;
		
	}
	
	
	
}
