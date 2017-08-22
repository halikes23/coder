package com.cz.coder.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cz.coder.common.entity.SpSysInfo;
import com.cz.coder.common.entity.po.SystemInfoVO;
import com.cz.coder.common.spsysinfo.Level2SpSysInfoKey;
import com.cz.coder.common.spsysinfo.Level3SpSysInfoKey;

@Repository
public class SpSysInfoDAO extends BaseDAO{
	
	/**
	 * 新增数据库系统参数
	 * @param spSysInfo
	 */
	public void insertSpSysInfo(SpSysInfo spSysInfo){
		this.getSqlMapClientTemplate().insert("SpSysInfoDAO.insertSpSysInfo", spSysInfo) ;
	}
	
	/**
	 * 新增数据库系统参数
	 * @param spSysInfo
	 */
	public void deleteSpSysInfo(SpSysInfo spSysInfo){
		this.getSqlMapClientTemplate().delete("SpSysInfoDAO.deleteSpSysInfo", spSysInfo) ;
	}
	
	/**
	 * 修改数据库系统参数
	 * @param spSysInfo
	 */
	public void updateSpSysInfo(SpSysInfo spSysInfo){
		this.getSqlMapClientTemplate().update("SpSysInfoDAO.updateSpSysInfo", spSysInfo) ;
	}
	
	/**
	 * 根据KEY1获取系统参数
	 * @param key1
	 * @return
	 */
	public List<SpSysInfo> selectLevel1SpSysInfo(String key1){
		return this.getSqlMapClientTemplate().queryForList("SpSysInfoDAO.selectLevel1SpSysInfo", key1) ;
	}
	
	/**
	 * 根据KEY1、KEY2获取系统参数
	 * @param spSysInfo
	 * @return
	 */
	public List<SpSysInfo> selectLevel2SpSysInfo(Level2SpSysInfoKey key){
		return this.getSqlMapClientTemplate().queryForList("SpSysInfoDAO.selectLevel2SpSysInfo", key) ;
	}
	
	/**
	 * 根据KEY1、KEY2、KEY3获取系统参数
	 * @param spSysInfo
	 * @return
	 */
	public SpSysInfo selectLevel3SpSysInfo(Level3SpSysInfoKey key){
		return (SpSysInfo)this.getSqlMapClientTemplate().queryForObject("SpSysInfoDAO.selectLevel3SpSysInfo", key) ;
	}
	
	
	/**
	 * 查询所有系统参数
	 * @param spSysInfo
	 * @return
	 */
	public List<SpSysInfo> selectAllSpSysInfo(){
		return this.getSqlMapClientTemplate().queryForList("SpSysInfoDAO.selectAllSpSysInfo") ;
	}
	/**
	 * 查询注册奖励列表
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> queryRegisterReward(
			Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("SpSysInfoDAO.queryRegisterReward",paramMap) ;
	}
	/**
	 * 查询注册奖励总数目
	 * @param paramMap
	 * @return
	 */
	public Integer queryRegisterRewardTotal(Map<String, Object> paramMap) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("SpSysInfoDAO.queryRegisterRewardTotal",paramMap);
	}
	/**
	 * 修改注册奖励
	 * @param paramMap
	 */
	public void updateRegisterReward(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().update("SpSysInfoDAO.updateRegisterReward", paramMap);
	}
	/**
	 * 增加注册奖励
	 * @param paramMap
	 */
	public void addRegisterReward(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().update("SpSysInfoDAO.addRegisterReward", paramMap);
	}
	/**
	 * 查询系统参数表
	 * @param param
	 * @return
	 */
	public List<SystemInfoVO> querySystemParam(Map<String, Object> param) {
		return getSqlMapClientTemplate().queryForList("SpSysInfoDAO.querySystemParam", param);
	}

	public Integer querySystemParamTotal(Map<String, Object> param) {
		return (Integer) getSqlMapClientTemplate().queryForObject("SpSysInfoDAO.querySystemParamTotal", param);
	}
	/**
	 * 修改系统参数表
	 * @param systemInfoVO
	 */
	public void updateSystemParam(SystemInfoVO systemInfoVO) {
		getSqlMapClientTemplate().update("SpSysInfoDAO.updateSystemParam", systemInfoVO);
	}
	/**
	 * 删除系统参数
	 * @param spId
	 */
	public void deleteSystemParam(Integer spId) {
		getSqlMapClientTemplate().update("SpSysInfoDAO.deleteSystemParam", spId);
	}
	/**
	 * 添加系统参数
	 * @param systemInfoVO
	 */
	public void addSystemParam(SystemInfoVO systemInfoVO) {
		getSqlMapClientTemplate().update("SpSysInfoDAO.addSystemParam", systemInfoVO);
	}

	public Map<String, Object> selectGuideVideoInfo() {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("SpSysInfoDAO.selectGuideVideoInfo");
	}

	public void updateGuideVideo(String flag) {
		getSqlMapClientTemplate().update("SpSysInfoDAO.updateGuideVideo", flag);
	}

	public List<Map<String, Object>> getActiveInfo(Map<String, Object> para) {
		return getSqlMapClientTemplate().queryForList("SpSysInfoDAO.getActiveInfo", para);
	}

	public Integer getActiveCount(Map<String, Object> para) {
		return (Integer) getSqlMapClientTemplate().queryForObject("SpSysInfoDAO.getActiveCount", para);
	}

	public Map<String, Object> queryActiveDetail(String aiId) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("SpSysInfoDAO.queryActiveDetail", aiId);
	}

	public void updateActive(Map<String, Object> para) {
		getSqlMapClientTemplate().update("SpSysInfoDAO.updateActive",para);
	}

	public void updateActiveState(Map<String, Object> para) {
		getSqlMapClientTemplate().update("SpSysInfoDAO.updateActiveState",para);
	}

	public void addActive(Map<String, Object> para) {
		getSqlMapClientTemplate().insert("SpSysInfoDAO.addActive", para);
	}

	public List<Map<String, Object>> querySystemVersionInfoList(
			Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("SpSysInfoDAO.selectSystemVersionInfoList", paramMap);
	}

	public Integer querySystemVersionInfoListTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("SpSysInfoDAO.selectSystemVeresionInfoListTotals", paramMap);
	}

	public Map<String, Object> querySystemVersionInfo(
			Map<String, Object> paramMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("SpSysInfoDAO.seletSystemVersionInfo", paramMap);
	}

	public void updateSystemVersionInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("SpSysInfoDAO.updateSystemVersionInfo",paramMap);
	}
	
	public void uploadSystemVersionInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("SpSysInfoDAO.addSystemVersionInfo", paramMap);
	}
	
	public void updateSystemVersionIsLast(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("SpSysInfoDAO.updateSystemVersionIsLast",paramMap);
	}

	public List<SpSysInfo> selectLevel21SpSysInfo(Level2SpSysInfoKey key) {
		return this.getSqlMapClientTemplate().queryForList("SpSysInfoDAO.selectLevel21SpSysInfo", key) ;
	}

	
	
}
