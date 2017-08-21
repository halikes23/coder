package com.fq.common.spsysinfo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.dao.SpSysInfoDAO;
import com.fq.entity.SpSysInfo;

/**
 * 系统参数获取
 * @author zhen.cheng
 *
 */
@Service
public class SpSysInfoHelper {
	
	private final static Logger logger = LoggerFactory.getLogger(SpSysInfoHelper.class) ;

	@Autowired
	private List<SpSysInfoChanger> spSysInfoChangers ;
	
	@Autowired
	private SpSysInfoDAO spSysInfoDAO ;
	
	/**
	 * 根据key1,key2,key3从数据库获取参数
	 * @param key1
	 * @param key2
	 * @param key3
	 * @return
	 */
	public SpSysInfo findByKeyFromDB( String key1 , String key2 , String key3 ){
		return this.spSysInfoDAO.selectLevel3SpSysInfo(Level3SpSysInfoKey.build(key1, key2, key3)) ;
	}
	
	/**
	 * 根据key1,key3从数据库获取参数
	 * @param key1
	 * @param key2
	 * @return
	 */
	public Set<SpSysInfo> findByKey1AndKey2FromDB( String key1 , String key2 ){
		List<SpSysInfo> list = this.spSysInfoDAO.selectLevel2SpSysInfo(Level2SpSysInfoKey.build(key1, key2)) ;
		Set<SpSysInfo> set = new HashSet<SpSysInfo>() ;
		set.addAll(list) ;
		return set ;
	}
	/**
	 * 
	 * @Title: findByKey1AndKey2OrderByKey3FromDB 
	 * @author jingkun.chen cjk_jing@163.com
	 * @Description: 根据key1，key2查询key3排序
	 * @param @param key1
	 * @param @param key2
	 * @param @return    设定文件  
	 * @return Set<SpSysInfo>    返回类型
	 */
	public List<SpSysInfo> findListByKey1AndKey2FromDB( String key1 , String key2 ){
	 
		return this.spSysInfoDAO.selectLevel2SpSysInfo(Level2SpSysInfoKey.build(key1, key2)) ;
	}
	
	/**
	 * 根据key1从数据库获取参数
	 * @param key1
	 * @return
	 */
	public Set<SpSysInfo> findByKey1FromDB( String key1 ){
		List<SpSysInfo> list = spSysInfoDAO.selectLevel1SpSysInfo(key1) ;
		Set<SpSysInfo> set = new HashSet<SpSysInfo>() ;
		set.addAll(list) ;
		return set ;
		
	}
	
	/**
	 * 修改系统参数信息
	 * @param spSysInfo
	 */
	public void changeSpSysInfo( SpSysInfo spSysInfo ){
		
		for( SpSysInfoChanger changer : spSysInfoChangers ){
			changer.change(spSysInfo);
		}
		
	}
	
	public List<SpSysInfoChanger> getSpSysInfoChangers() {
		return spSysInfoChangers;
	}

	public void setSpSysInfoChangers(List<SpSysInfoChanger> spSysInfoChangers) {
		this.spSysInfoChangers = spSysInfoChangers;
	}
	
}
