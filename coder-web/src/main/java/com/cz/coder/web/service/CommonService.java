package com.fq.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.common.constant.RetCode;
import com.fq.common.spsysinfo.SpSysInfoHelper;
import com.fq.common.util.HttpHelper;
import com.fq.dao.SpSysInfoDAO;
import com.fq.dao.dao.cartoon.CartoonDAO;
import com.fq.dao.dao.common.CommonDAO;
import com.fq.dao.entity.po.ServerPO;
import com.fq.dao.entity.vo.common.ToChgIOSAuditModelFlagVO;
import com.fq.dao.entity.vo.livecartoon.LiveCartoonInfoVO;
import com.fq.entity.SpSysInfo;
import com.fq.entity.vo.SystemInfoVO;
import com.fq.properties.GlobalProperties;
import com.fq.util.DateFormatUtil;
import com.fq.util.InterfaceUtil;
import com.fq.util.page.PageInfo;
import com.fq.util.page.PageUtil;

@Service
public class CommonService {

	@Autowired
	private SpSysInfoHelper spSysInfoHelper ;
	
	@Autowired
	private SpSysInfoDAO spSysInfoDAO ;
	@Autowired
	private InterfaceUtil interfaceUtil;
	@Autowired
	private CommonDAO commonDAO ;
	
	@Autowired
	private CartoonDAO cartoonDAO ;
	
	
	private final static Logger logger = LoggerFactory.getLogger(CommonService.class) ;
	
	/**
	 * 
	 * @Title: getCrowdfundingRulerList 
	 * @Description: 获取众筹说明信息
	 * @param @param paramMap
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return Map<String,Object>    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public Map<String, Object> getCrowdfundingRulerList(
			Map<String, Object> paramMap) throws Exception {
		
		try {
			// 查询系统参数中众筹规则
			paramMap.put("key2", "crowdfunding" ) ;
			
			// 获取项目信息列表
			Set<SpSysInfo> level2DB = this.spSysInfoHelper.findByKey1AndKey2FromDB("sys", "crowdfunding") ;
			List<SpSysInfo> level2ListDB = new ArrayList<SpSysInfo>(level2DB);
			// TODO
			Collections.sort(level2ListDB, new SpSysInfoComparator());
			
			Map<String , Object> res = new HashMap<String, Object>() ; 
			res.put( "level2DB", level2ListDB) ;
			return  res;
			
		} catch (Exception e) {
			logger.error("错误日志", e) ;
			throw e ;
		}
	}
	/**
	 * 
	 * @Title: toChangeCrowdfundingRuler 
	 * @Description: 修改众筹说明
	 * @param @param spSysInfo
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return Map<String,Object>    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public Map<String, Object> toChangeCrowdfundingRuler(SpSysInfo spSysInfo) throws Exception {
		try {
			
			SpSysInfo level3DB = this.spSysInfoHelper.findByKeyFromDB(spSysInfo.getKey1(), spSysInfo.getKey2(),spSysInfo.getKey3()) ;
			
			//this.spSysInfoHelper.changeSpSysInfo(spSysInfo);
			Map<String , Object> res = new HashMap<String, Object>() ; 
			res.put( "level3DB", level3DB ) ;
			return  res;
			
		} catch (Exception e) {
			logger.error("错误日志", e) ;
			throw e ;
		}
		
	}
	/**
	 * 
	 * @Title: toCheckCrowdfundingRuler 
	 * @Description: 查看众筹说明详细信息
	 * @param @param spSysInfo
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return Map<String,Object>    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public Map<String, Object> toCheckCrowdfundingRuler(SpSysInfo spSysInfo) throws Exception {
		try {
			SpSysInfo level3Cache = this.spSysInfoHelper.findByKeyFromDB(spSysInfo.getKey1(), spSysInfo.getKey2(),spSysInfo.getKey3()) ;
			//this.spSysInfoHelper.changeSpSysInfo(spSysInfo);
			Map<String , Object> res = new HashMap<String, Object>() ; 
			res.put( "level3Cache", level3Cache ) ;
			return  res;
		} catch (Exception e) {
			logger.error("错误日志", e) ;
			throw e ;
		}
	}
	
	/**
	 * 
	 * @Title: changeCrowdfundingRuler 
	 * @Description: 修改众筹说明
	 * @param @param spSysInfo
	 * @param @throws Exception    设定文件  
	 * @return void    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public void changeCrowdfundingRuler(SpSysInfo spSysInfo) throws Exception {

		try {
			
			SpSysInfo spSysInfoFromDB = this.spSysInfoHelper.findByKeyFromDB(spSysInfo.getKey1(), spSysInfo.getKey2(), spSysInfo.getKey3()) ;
			if( spSysInfoFromDB != null ){
				spSysInfoFromDB.setKeyValue1(spSysInfo.getKeyValue1()) ;
				spSysInfoFromDB.setKeyValue2(spSysInfo.getKeyValue2()) ;
				this.spSysInfoHelper.changeSpSysInfo(spSysInfoFromDB) ;
			}else{
				this.spSysInfoHelper.changeSpSysInfo(spSysInfo) ;
			}
			
		} catch (Exception e) {
			logger.error("错误日志", e) ;
			throw e ;
		}
	}
	
	/**
	 * 
	 * @ClassName SpSysInfoComparator  
	 * @Description 完成排序  
	 * @author jingkun.chen cjk_jing@163.com  
	 * @date 2016-4-7
	 */
	class SpSysInfoComparator implements Comparator<SpSysInfo>{
		@Override
		public int compare(SpSysInfo compare , SpSysInfo compared) {
			if( compare.getKey1().compareTo(compared.getKey1()) == 1 ){
				return 1 ;
			}else if(compare.getKey1().compareTo(compared.getKey1()) == -1 ){
				return -1 ;
			}
			
			if( compare.getKey2().compareTo(compared.getKey2()) == 1 ){
				return 1 ;
			}else if(compare.getKey2().compareTo(compared.getKey2()) == -1 ){
				return -1 ;
			}
			
			return compare.getKey3().compareTo(compared.getKey3()) ;
			
		}

	}

	
	public void deleteSpSysInfo(String key1 , String key2 , String key3){
		SpSysInfo param = new SpSysInfo() ;
		param.setKey1(key1);
		param.setKey2(key2);
		param.setKey3(key3);
		spSysInfoDAO.deleteSpSysInfo(param);
		
	}
	public PageInfo<Map<String, Object>> queryRegisterReward(
			Map<String, Object> paramMap) {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<>();
			List<Map<String,Object>> registerRewards = spSysInfoDAO.queryRegisterReward(paramMap);
			Integer dataCount = spSysInfoDAO.queryRegisterRewardTotal(paramMap);
			pageInfo.setDataList(registerRewards);
			pageInfo.setDataCount(dataCount);
			pageInfo.setPageSize((Integer) paramMap.get("pageSize"));
			pageInfo.setCurrentlyPageNo((Integer)paramMap.get("pageNow"));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	public void updateRegisterReward(Map<String, Object> paramMap) {
		spSysInfoDAO.updateRegisterReward(paramMap);
	}
	public void addRegisterReward(Map<String, Object> paramMap) {
		spSysInfoDAO.addRegisterReward(paramMap);
	}
	/**
	 * 查询整张系统参数表
	 * @param param
	 * @return
	 */
	public PageInfo<SystemInfoVO> querySystemParam(
			Map<String, Object> param) {
		try {
			PageInfo<SystemInfoVO> pageInfo = new PageInfo<>();
			List<SystemInfoVO> systemInfoVOs =(List<SystemInfoVO>) spSysInfoDAO.querySystemParam(param);
			Integer dataCount = spSysInfoDAO.querySystemParamTotal(param);
			pageInfo.setDataList(systemInfoVOs);
			pageInfo.setDataCount(dataCount);
			pageInfo.setCurrentlyPageNo((Integer) param.get("pageNow"));
			pageInfo.setPageSize((Integer) param.get("pageSize"));
			return pageInfo;
		} catch (Exception e) {
			logger.info("错误日志", e);
			throw e;
		}
	}
	/**
	 * 修改系统参数
	 * @param systemInfoVO
	 * @return 
	 */
	public String updateSystemParam(SystemInfoVO systemInfoVO) {
		String code = RetCode.SUCCESS;
		try {
			spSysInfoDAO.updateSystemParam(systemInfoVO);
		} catch (Exception e) {
			logger.error("",e);
			code = RetCode.DATA_ERROR;
		}
		return code;
	}
	/**
	 * 删除系统参数
	 * @param spId
	 * @return
	 */
	public String deleteSystemParam(Integer spId) {
		String code = RetCode.SUCCESS;
		try {
			spSysInfoDAO.deleteSystemParam(spId);
		} catch (Exception e) {
			code=RetCode.DATA_ERROR; 
		}
		return code;
	}
	/**
	 * 增加系统参数
	 * @param systemInfoVO
	 * @return
	 */
	public String addSystemParam(SystemInfoVO systemInfoVO) {
		String code = RetCode.SUCCESS;
		try {
			spSysInfoDAO.addSystemParam(systemInfoVO);
		} catch (Exception e) {
			code = RetCode.DATA_ERROR;
		}
		return code;
	}
	public String toChangeParam(Map<String, Object> param) {
		try {
			String uri = (String) param.get("uri");
			String par = (String) param.get("param");
			if(uri!=""&&uri!=null){
				if(par!=""&&par!=null){
					Map<String , Object> paramMap = new HashMap<>();
					paramMap.put("datasourceFlag", par);
					HttpHelper.doGet("http://"+uri+"/jnwtv-client/config/chgdatasourceflag", paramMap, "UTF-8");
					return RetCode.SUCCESS;
				}
			}
			return RetCode.LOST_PARAM;
		} catch (Exception e) {
			return RetCode.DATA_ERROR;
		}
	}
	public List<ServerPO> toChooseDataSource() {
		try {
			List<ServerPO> servers = new ArrayList<ServerPO>();
			String[] server = GlobalProperties.SERVERS.split(",");
			for (int i = 0; i < server.length; i++) {
				String uri = server[i];
				String dataSourceFlag = HttpHelper.doGet("http://"+uri+"/jnwtv-client/config/" +
						"queryDataSourceFlag","UTF-8");
				ServerPO serverPO = new ServerPO(uri, uri, dataSourceFlag);
				servers.add(serverPO);
			}
			return servers;
		} catch (Exception e) {
			logger.info("",e);
			throw e;
		}
	}
	public List<ToChgIOSAuditModelFlagVO> toChgIOSAuditModelFlag() {
		List<ToChgIOSAuditModelFlagVO> servers = new ArrayList<ToChgIOSAuditModelFlagVO>();
		String[] server = GlobalProperties.SERVERS.split(",");
		for (int i = 0; i < server.length; i++) {
			String uri = server[i];
			String flag = HttpHelper.doGet("http://"+uri+"/jnwtv-client/config/queryIosAuditModelFlag","UTF-8");
			ToChgIOSAuditModelFlagVO vo = new ToChgIOSAuditModelFlagVO();
			vo.setAuditModelFlag(flag);
			vo.setServiceUrl(uri);
			servers.add(vo);
		}
		return servers;
	}
	public String chgIOSAuditModelFlag(Map<String, Object> param) {
		try {
			String uri = (String) param.get("uri");
			String flag = (String) param.get("flag");
			
			if( !StringUtils.isEmpty(uri)&&!StringUtils.isEmpty(flag)){
				Map<String , Object> paramMap = new HashMap<>();
				paramMap.put("iosAuditModelFlag", flag);
				HttpHelper.doGet("http://"+uri+"/jnwtv-client/config/chgiosauditmodelflag", paramMap, "UTF-8");
				return RetCode.SUCCESS;
			}
			return RetCode.LOST_PARAM;
		} catch (Exception e) {
			return RetCode.DATA_ERROR;
		}
	}
	

	public static void main(String[] args) {
		
		Map<String,Object> param = new HashMap<String,Object>() ;
		
		param.put("a", null) ;
		
		System.out.println(((String)param.get("a")));
		
		
		
		
	}
	public Map<String, Object> getGuideVideoInfo() {
		try {
			Map<String, Object> map = spSysInfoDAO.selectGuideVideoInfo();
			return map;
		} catch (Exception e) {
			logger.info("",e);
			throw e;
		}
	}
	public String manageGuideVideo(String flag) {
		try {
			spSysInfoDAO.updateGuideVideo(flag);
			return RetCode.SUCCESS;
		} catch (Exception e) {
			logger.info("",e);
			return RetCode.DATABASE_EXCEPTION;
		}
	}
	/**
	 * 获取活动列表
	 * @param para
	 * @return
	 */
	public PageInfo<Map<String, Object>> getActiveInfo(Map<String, Object> para) {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			Map<String, Integer> page = PageUtil.buildPage((Integer)para.get("pageNow"),(Integer)para.get("pageSize"));
			para.putAll(page);
			List<Map<String, Object>> dataList = spSysInfoDAO.getActiveInfo(para);
			//获取真实链接
			for(Map<String, Object> map:dataList){
				String recommendUrl = (String) map.get("recommendUrl");
				if(StringUtils.isNotEmpty(recommendUrl)){
					String realRecommendUrl = interfaceUtil.getUrlByQiNiuKey(recommendUrl);
					map.put("realRecommendUrl", realRecommendUrl);
				}
				String activeUrl = (String) map.get("activeUrl");
				if(StringUtils.isNotEmpty(activeUrl)){
					String realActiveUrl = interfaceUtil.getUrlByQiNiuKey(activeUrl);
					map.put("realActiveUrl", realActiveUrl);
				}
			}
			Integer dataCount = spSysInfoDAO.getActiveCount(para);
			pageInfo.setDataList(dataList);
			pageInfo.setDataCount(dataCount);
			return pageInfo;
		} catch (Exception e) {
			logger.info("",e);
			throw e;
		}
	}
	/**
	 * 获取活动详细信息
	 * @param aiId
	 * @return
	 */
	public Map<String, Object> queryActiveDetail(String aiId) {
		try {
			return spSysInfoDAO.queryActiveDetail(aiId);
		} catch (Exception e) {
			logger.info("",e);
			throw e;
		}
	}
	/**
	 * 修改活动信息
	 * @param para
	 */
	public void updateActive(Map<String, Object> para) {
		try {
			String activeDate = (String) para.get("activeDate");
			if(StringUtils.isNotEmpty(activeDate)){
				String[] date = activeDate.split(" ");
				String createDT = date[0];
				para.put("createDT", createDT);
				String createTM = date[1];
				para.put("createTM", createTM);
			}
			else{
				activeDate=DateFormatUtil.CREATE_FULL_DATE_STR_DB();
				String date[] = activeDate.split(" ");
				String createDT = date[0];
				para.put("createDT", createDT);
				String createTM = date[1];
				para.put("createTM", createTM);
			}
			spSysInfoDAO.updateActive(para);
		} catch (Exception e) {
			logger.info("",e);
			throw e;
		}
	}
	/**
	 * 修改活动是否使用
	 * @param para
	 * @return
	 */
	public String updateActiveState(Map<String, Object> para) {
		try {
			spSysInfoDAO.updateActiveState(para);
			return RetCode.SUCCESS;
		} catch (Exception e) {
			logger.info("",e);
			return RetCode.DATABASE_EXCEPTION;
		}
	}
	public void addActive(Map<String, Object> para) {
		try {
			String createDate = (String) para.get("activeDate");
			if(StringUtils.isNotEmpty(createDate)){
				String date[] = createDate.split(" ");
				String createDT = date[0];
				para.put("createDT", createDT);
				String createTM = date[1];
				para.put("createTM", createTM);
			}
			else{
				createDate=DateFormatUtil.CREATE_FULL_DATE_STR_DB();
				String date[] = createDate.split(" ");
				String createDT = date[0];
				para.put("createDT", createDT);
				String createTM = date[1];
				para.put("createTM", createTM);
			}
			spSysInfoDAO.addActive(para);
		} catch (Exception e) {
			throw e;
		}
		
	}
	/*
	 * 系统版本信息列表
	 */
	public PageInfo<Map<String, Object>> querySystemVersionInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			List<Map<String , Object>>  systemVersionInfoList = spSysInfoDAO.querySystemVersionInfoList(paramMap);
			
			Integer pageCount = spSysInfoDAO.querySystemVersionInfoListTotals(paramMap) ;
			pageInfo.setDataList( systemVersionInfoList ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	/*
	 * 系统信息查询
	 */
	public Map<String, Object> querySystemVersionInfo(Map<String, Object> paramMap) {
		try{
			Map<String, Object> systemVersionDetail = spSysInfoDAO.querySystemVersionInfo(paramMap);
			return systemVersionDetail;
		}catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 修改系统版本信息
	 */
	public Map<String, Object> updateSystemVersionInfo(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			if((StringUtils.isEmpty(paramMap.get("vNo").toString()))){
				res.put("message", "请填写系统版本号！");
				res.put("succ", false);
				return res;
			}
			if ((StringUtils.isEmpty(paramMap.get("vUrl").toString()))&&(("A").equals(paramMap.get("vType")))) {
				res.put("message", "请填写系统版本路径！");
				res.put("succ", false);
				return res;
			}
			if(StringUtils.isEmpty(paramMap.get("vDesc").toString())){
				res.put("message", "请填写系统版本描述！");
				res.put("succ", false);
				return res;
			}
			if(StringUtils.isEmpty(paramMap.get("minNo").toString())){
				res.put("message", "请填写当前版本支持的最低版本号！");
				res.put("succ", false);
				return res;
			}
			if(StringUtils.isEmpty(paramMap.get("minNo").toString())){
				res.put("message", "请填写系统版本大小！");
				res.put("succ", false);
				return res;
			}
			
			spSysInfoDAO.updateSystemVersionInfo(paramMap) ;
			res.put("message", "提交成功！");
			res.put("succ", true ) ;
			return res;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
	}
	
	
	public Map<String, Object> uploadSystemVersionInfo(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			if((StringUtils.isEmpty(paramMap.get("vNo").toString()))){
				res.put("message", "请填写系统版本号！");
				res.put("succ", false);
				return res;
			}
			if ((StringUtils.isEmpty(paramMap.get("vUrl").toString()))&&(("A").equals(paramMap.get("vType")))) {
				res.put("message", "请填写系统版本路径！");
				res.put("succ", false);
				return res;
			}
			if(StringUtils.isEmpty(paramMap.get("vDesc").toString())){
				res.put("message", "请填写系统版本描述！");
				res.put("succ", false);
				return res;
			}
			if(StringUtils.isEmpty(paramMap.get("minNo").toString())){
				res.put("message", "请填写当前版本支持的最低版本号！");
				res.put("succ", false);
				return res;
			}
			if(StringUtils.isEmpty(paramMap.get("minNo").toString())){
				res.put("message", "请填写系统版本大小！");
				res.put("succ", false);
				return res;
			}
			if (("Y").equals( paramMap.get("isLast"))) {
				spSysInfoDAO.updateSystemVersionIsLast(paramMap);
			}
			
			spSysInfoDAO.uploadSystemVersionInfo(paramMap) ;
			
			res.put("message", "提交成功！");
			res.put("succ", true ) ;
			return res;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
	}
	/**
	 * 
	 * @Title: updateLiveCartoonShareSysParams 
	 * @author chen.zhao 
	 * @Description: TODO
	 * @param @param paramMap
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return String    返回类型
	 */
	public String updateLiveCartoonShareSysParams(Map<String, Object> paramMap) throws Exception {
		try {
			
			LiveCartoonInfoVO liveCartoonInfoVO = cartoonDAO.selectLiveCartoonParamByPlcId(paramMap.get("plcId"));
			SpSysInfo spSysInfo = new SpSysInfo();
			
			spSysInfo.setKey1("user");
			spSysInfo.setKey2("login");
			spSysInfo.setKey3("share");
			spSysInfo.setKeyInt(liveCartoonInfoVO.getLcId());
			spSysInfo.setKeyValue1(liveCartoonInfoVO.getCartoonTitle());
			spSysInfo.setKeyValue2(liveCartoonInfoVO.getCartoonDesc());
			spSysInfo.setKeyValue3(liveCartoonInfoVO.getCartoonCoverUrl());
			spSysInfo.setKeyFloat(null);
			
			spSysInfoDAO.updateSpSysInfo(spSysInfo) ;
			return "{\"result\":\"0\"}"; 
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	
	public void createResourceAccessData() {
		this.commonDAO.createResourceAccessData() ;
	}
	
}
