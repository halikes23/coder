package com.fq.common.spsysinfo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import com.fq.entity.SpSysInfo;

/**
 * 系统参数缓存
 * @author zhen.cheng
 *
 */
public class SpSysInfoCache {

	/**
	 * key1,key2,key3缓存
	 */
	private final static Map<Level3SpSysInfoKey,SpSysInfo> level3Cache = new HashMap<Level3SpSysInfoKey,SpSysInfo>();
	/**
	 * key1,key2缓存
	 */
	private final static Map<Level2SpSysInfoKey,Set<SpSysInfo>> level2Cache = new HashMap<Level2SpSysInfoKey,Set<SpSysInfo>>() ;
	/**
	 * key1缓存
	 */
	private final static Map<String,Set<SpSysInfo>> level1Cache = new HashMap<String,Set<SpSysInfo>>() ;
	
	/**
	 * 缓存清理
	 */
	final static void clear(){
		level3Cache.clear() ;
		level2Cache.clear() ;
		level1Cache.clear() ;
	}
	
	/**
	 * 新增或修改系统参数缓存
	 * @param key
	 * @param info
	 */
	final static synchronized void put(Level3SpSysInfoKey key ,SpSysInfo info ){
		// 向key1,key2,key3缓存中插入系统参数信息
		level3Cache.put(key, info) ;
		// 向key1,key2缓存中插入系统参数信息
		Level2SpSysInfoKey level2Key = Level2SpSysInfoKey.build(info.getKey1(), info.getKey2()) ;
		
		Set<SpSysInfo> level2SpSysInfo = level2Cache.get(level2Key);
		if( CollectionUtils.isEmpty(level2SpSysInfo) ){
			Set<SpSysInfo> temp = new HashSet<SpSysInfo>();
			temp.add(info) ;
			
			level2Cache.put(level2Key, temp) ;
		}else{
			if(level2SpSysInfo.contains(info)){
				level2SpSysInfo.remove(info);
			}
			level2SpSysInfo.add(info) ;
		}
		// 向key1缓存中插入系统参数信息
		Set<SpSysInfo> level1SpSysInfo = level1Cache.get(info.getKey1());
		
		if( CollectionUtils.isEmpty(level1SpSysInfo) ){
			Set<SpSysInfo> temp = new HashSet<SpSysInfo>();
			temp.add(info) ;
			
			level1Cache.put(info.getKey1(), temp) ;
		}else{
			if(level1SpSysInfo.contains(info)){
				level1SpSysInfo.remove(info);
			}
			level1SpSysInfo.add(info) ;
		}
		
	}
	
	/**
	 * 根据KEY1，KEY2，KEY3获取系统参数对象
	 * @param key
	 * @return
	 */
	final static SpSysInfo get(Level3SpSysInfoKey key){
		return level3Cache.get(key) ;
	}
	
	/**
	 * 根据KEY1，KEY2获取系统参数集合
	 * @param key
	 * @return
	 */
	final static Set<SpSysInfo> get(Level2SpSysInfoKey key){
		return level2Cache.get(key) ;
	}
	
	/**
	 * 根据KEY1获取系统参数集合
	 * @param key
	 * @return
	 */
	final static Set<SpSysInfo> get(String key){
		return level1Cache.get(key) ;
	}

	/**
	 * 打印缓存信息
	 * @return
	 */
	final static String showCache() {
		return "SpSysInfoCache level3Cache:" + level3Cache + "\r\nlevel2Cache:" + level2Cache + "\r\nlevel1Cache:" + level1Cache;
	}
	
}
