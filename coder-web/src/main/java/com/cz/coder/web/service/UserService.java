package com.fq.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.domain.Paragraph;
import com.fq.common.constant.RetCode;
import com.fq.common.constant.UNotificationConstant;
import com.fq.dao.dao.notification.NotificationDAO;
import com.fq.dao.dao.user.UserDAO;
import com.fq.dao.entity.po.user.UserInfoPO;
import com.fq.dao.entity.vo.OperateLog;
import com.fq.dao.entity.vo.OscarActiveBookVO;
import com.fq.dao.entity.vo.OscarActiveVO;
import com.fq.dao.entity.vo.ThirdUserInfoVO;
import com.fq.dao.entity.vo.WaterManCommentVO;
import com.fq.dao.entity.vo.privilege.AdminVO;
import com.fq.dao.entity.vo.user.AddNewUserVO;
import com.fq.dao.entity.vo.user.NewUserVO;
import com.fq.dao.entity.vo.user.UserBehaviorVO;
import com.fq.dao.entity.vo.user.UserInfoVO;
import com.fq.dao.entity.vo.user.UserJPointLogVO;
import com.fq.dao.entity.vo.user.UserPhotoVO;
import com.fq.entity.po.UNotificationPO;
import com.fq.form.user.AddUserPhotoForm;
import com.fq.form.user.ChangeUserRoleForm;
import com.fq.form.user.EditThirdUserInfoForm;
import com.fq.form.user.ToListUserInfoForm;
import com.fq.form.user.ToUserPhotoManagerForm;
import com.fq.properties.GlobalProperties;
import com.fq.util.BeanUtil;
import com.fq.util.DateFormatUtil;
import com.fq.util.InterfaceUtil;
import com.fq.util.MD5Util;
import com.fq.util.StringUtils;
import com.fq.util.img.ImgUtil;
import com.fq.util.page.PageInfo;
import com.fq.util.page.PageUtil;

@Service
public class UserService {
		
	@Autowired
	private UserDAO  userDAO;

	@Autowired
	private NotificationDAO notificationDao ;
	
	@Autowired
	private InterfaceUtil interfaceUtil ;
	
	private final static Logger logger = LoggerFactory.getLogger(UserService.class);

	/**
	 * 
	 * @param paramMap
	 * @return
	 */
	public PageInfo<NewUserVO> queryNewUserInfo(Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<NewUserVO> pageInfo = new PageInfo<NewUserVO>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			Format f = new SimpleDateFormat("yyyy-MM-dd");
		    Calendar c = Calendar.getInstance();
		    String today = f.format(c.getTime());
		    c.add(Calendar.DAY_OF_MONTH, -1);
		    paramMap.put("today", today);
		    List<NewUserVO> newUserVOs =userDAO.selectNewUserCountInfoList(paramMap);
		    for(NewUserVO vo : newUserVOs){
		    	Integer userTotalCount = userDAO.selectUserTotalCount(vo.getWriteDate());
		    	Integer vipTotalCount = userDAO.selectUserVipTotalCount(vo.getWriteDate());
		    	vo.setUserTotalCount(userTotalCount);
		    	vo.setVipTotalCount(vipTotalCount);
		    }
		    Integer pageCount = userDAO.selectNewUserCountInfoListTotals(paramMap);
		    pageInfo.setDataList( newUserVOs ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	
	
	/**
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public PageInfo<UserInfoVO> queryUserInfo(ToListUserInfoForm form) throws Exception{
		try {
			Map<String,Object> param = BeanUtil.toMapWithSuperClass(form);
			
			PageInfo<UserInfoVO> pageInfo = new PageInfo<UserInfoVO>() ;
			BeanUtils.copyProperties(pageInfo, form);
			
			List<UserInfoVO> data = userDAO.selectUserInfoForPage(param) ;
			
			pageInfo.setDataList(data);
			
			Integer dataCount = userDAO.selectUserInfoCount(param) ;
			pageInfo.setDataCount(dataCount);
			
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	
	/**
	 * 修改用户角色
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doChangeUserRole(ChangeUserRoleForm form) throws Exception{
		try {
			UserInfoPO userInfoPO = new UserInfoPO() ;
			BeanUtils.copyProperties(userInfoPO, form);
			//1 如果修改为普通用户，则置空演员类型 2 如果修改为演职人员 ，设置默认的演员类型为普通演员 
			if(("1").equals(userInfoPO.getUserRole())){
				userInfoPO.setUserSubRole(" ");
			}else {
				userInfoPO.setUserSubRole("1");
			}
			this.userDAO.updateUserRole(userInfoPO) ;
			return RetCode.buildRetCodeResult(RetCode.SUCCESS) ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			return RetCode.buildRetCodeResult(RetCode.SYSTEM_ERROR);
		}
	}
	
	/**
	 * 查询用户相册
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public List<UserPhotoVO> queryUserPhoto(ToUserPhotoManagerForm form) throws Exception{
		List<UserPhotoVO> photoes = this.userDAO.selectUserPhotoesByAccount(form.getAccount());
		for(UserPhotoVO photo : photoes){
			//将数据库中的imgQiniuKey转换成qiniuUrl
			photo.setImgQiniuUrl(interfaceUtil.getUrlByQiNiuKey(photo.getImgQiniuKey()));
		}
		return photoes;
	}
	
	/**
	 * 删除用户相册
	 * @param upIds
	 * @return
	 */
	public String removeUserPhotoes(String[] upIds){
		try{
			userDAO.deleteUserPhotoes(upIds);
			return RetCode.SUCCESS ;
		}catch(Exception e){
			logger.error("",e);
			return RetCode.DATABASE_EXCEPTION ; 
		}
	}

	/**
	 * 添加用户照片
	 * @param form
	 * @return
	 */
	public String addUserPhoto(AddUserPhotoForm form) {
		try {
			userDAO.insertUserPhoto(form);
			return RetCode.SUCCESS;
		} catch (Exception e) {
			logger.error("",e);
			return RetCode.DATABASE_EXCEPTION;
		}
	}

	/**
	 * 
	 * @Title: queryTesterList 
	 * @Description: 查询测试用户信息
	 * @param @param paramMap
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return PageInfo<Map<String,Object>>    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public PageInfo<Map<String, Object>> queryTesterList(
			Map<String, Object> paramMap) throws Exception {
		try {
			
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			
			// 获取视频信息列表
			List<Map<String , Object>> testerInfoList = userDAO.queryTesterList(paramMap);
			
			Integer pageCount = userDAO.queryTesterTotals(paramMap) ;
			pageInfo.setDataList( testerInfoList ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("",e);
			throw e ;
		}
	}
	
	public PageInfo<Map<String, Object>> queryNavyList(
			Map<String, Object> paramMap) throws Exception {
		try {
			
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			
			// 获取视频信息列表
			List<Map<String , Object>> navyInfoList = userDAO.queryNavyList(paramMap);
			
			Integer pageCount = userDAO.queryNavyTotals(paramMap) ;
			pageInfo.setDataList( navyInfoList ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("",e);
			throw e ;
		}
	}
	/**
	 * 
	 * @Title: updateTester 
	 * @Description: 删除测试用户
	 * @param @param paramMap
	 * @param @throws Exception    设定文件  
	 * @return void    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public void updateTester(Map<String, Object> paramMap) throws Exception{
		try {
			userDAO.updateTester(paramMap) ;
			
		} catch (Exception e) {
			logger.error("",e);
			throw e ;
		}
	}

	public void updateNavy(Map<String, Object> paramMap) throws Exception{
		try {
			userDAO.updateNavy(paramMap) ;
			
		} catch (Exception e) {
			logger.error("",e);
			throw e ;
		}
	}
	
	/**
	 * 
	 * @Title: changeTester 
	 * @Description:  修改测试用户信息
	 * @param @param paramMap
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return Map<? extends String,? extends Object>    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public Map<? extends String, ? extends Object> changeTester(
			Map<String, Object> paramMap) throws Exception{
		try {
			this.userDAO.updateTester(paramMap) ;
			return  RetCode.buildRetCodeResult(RetCode.SUCCESS);
		} catch (Exception e) {
			logger.error("",e);
			return RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION);
		}
		
	}
	
	public Map<? extends String, ? extends Object> changeNavy(
			Map<String, Object> paramMap) throws Exception{
		try {
			this.userDAO.updateNavy(paramMap) ;
			return  RetCode.buildRetCodeResult(RetCode.SUCCESS);
		} catch (Exception e) {
			logger.error("",e);
			return RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION);
		}
		
	}
	
	/**
	 * 记录操作员操作日志
	 * @param jsonPostParams
	 */
	public void insertOperateLog(JSONObject obj) {
		try {
			
			String servletPath = obj.get("servletPath").toString();
			String loginUser = obj.get("loginUser").toString() ;
			String params = obj.get("params") == null ? null : obj.getString("params").toString() ;
			String resStatus = obj.getString("resStatus").toString();
			OperateLog logger = new OperateLog();
			logger.setServletPath(servletPath);
			logger.setLoginUser( (AdminVO)JSONObject.toBean( JSONObject.fromObject(loginUser),AdminVO.class )) ;
			logger.setResStatus(resStatus);
			logger.setParams(params);
			userDAO.insertOperateLog(logger);
			
		} catch (Exception e) {
			logger.error("错误日志", e);
		}
	}

	/**
	 * 查询水军们的工作
	 * @param paramMap
	 * @return
	 */
	public PageInfo<WaterManCommentVO> queryWaterManList(Map<String, Object> paramMap) {
		try {
			
			PageInfo<WaterManCommentVO> pageInfo = new PageInfo<WaterManCommentVO>();
			
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			
			List<WaterManCommentVO> waterManCommentVOs = userDAO.queryWaterMansWork(paramMap);
			
			Integer pageCount = userDAO.queryWaterMansWorkTotal(paramMap) ;
			
			pageInfo.setDataList( waterManCommentVOs ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("",e);
			throw e ;
		}
	}
	/**
	 * 判断是否存在
	 */
	public boolean isExist(Map<String, Object> paramMap){
		return userDAO.isExist(paramMap);
	}
	/**
	 * 添加新用户
	 * @param paramMap
	 * @return
	 */
	public void addNewUser(AddNewUserVO user) {
		try {
			userDAO.addNewUser(user);
		} catch (Exception e) {
			logger.error("",e);
			throw e ;
		}
	}
	/**
	 * 查询用户反馈信息
	 * @param paramMap
	 * @return
	 */
	public PageInfo<Map<String, Object>> queryUserFeedBackInfoList(
			Map<String, Object> paramMap) {
		try {
			
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			
			List<Map<String, Object>> userFeedBackInfoList = userDAO.queryUserFeedBackInfoList(paramMap);
			
			Integer pageCount = userDAO.queryUserFeedBackInfoTotal(paramMap) ;
			
			pageInfo.setDataList(userFeedBackInfoList ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("",e);
			throw e ;
		}
	}
	/**
	 * 查询用户手机信息
	 * @param paramMap
	 * @return
	 */
	public PageInfo<Map<String, Object>> queryUserMobileInfoList(
			Map<String, Object> paramMap) {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>();
			List<Map<String, Object>> userMobileInfos = userDAO.queryUserMobileInfoList(paramMap);
			Integer dataCount = userDAO.queryUserMobileInfoListTotal(paramMap);
			pageInfo.setDataList(userMobileInfos);
			pageInfo.setDataCount(dataCount);
			pageInfo.setCurrentlyPageNo((Integer) paramMap.get("pageNow"));
			pageInfo.setPageSize((Integer) paramMap.get("pageSize"));
			return pageInfo;
		} catch (Exception e) {
			logger.info("错误日志", e);
			throw e;
		}
	}

	public List<Map<String, Object>> toUserFeedBackAndNotificationList(
			String account) {
		List<Map<String, Object>> list = this.userDAO.queryUserFeedBackAndNotification(account);
		
		List<Map<String,Object>> feedbacks = new ArrayList<Map<String,Object>>() ;
		for( Map<String,Object> obj : list){
			if( StringUtils.equals((String)obj.get("otype"), "F") ){
				obj.put("notifications", new ArrayList<Map<String,Object>>()) ;
				feedbacks.add(obj) ;
			}
		}
		
		for( Map<String,Object> feedback : feedbacks ){
			for(Map<String,Object> obj : list){
				if( StringUtils.equals((String)obj.get("otype"), "F") ){
					continue ;
				}else{
					if( obj.get("fId").equals(feedback.get("fId")) ){
						((List<Map<String,Object>>)feedback.get("notifications")).add(obj)  ;
					}
				}
			}
		}
		
		return feedbacks;
	}

	public void replyFeedBack(Integer fId, String content,String creator) {

		Map<String,Object> feedback = this.userDAO.queryUserFeedBackByFId(fId);
		
		feedback.put("hasReplied", "Y") ;
		
		this.userDAO.updateUserFeedbackReplyState(feedback);
		
		String oprAccount = GlobalProperties.SYSTEM_FEEDBACK_REPLIER ;
		UNotificationPO notification = new UNotificationPO() ;
		notification.setClientType(UNotificationConstant.ClientType.BOTH);
		notification.setContent(content);
		notification.setCreator(creator);
		notification.setfId(fId);
		notification.setNotifyAccount((String)feedback.get("account"));
		notification.setNotifyModuleId(null);
		notification.setNotifyType(UNotificationConstant.NotifyType.SYS_NOTIFICATION);
		notification.setOprAccount(oprAccount);
		notification.setPiId(null);
		this.notificationDao.insertNotification(notification);
		
	}

	public void deleteFeedBackReply(Integer mnId , Integer fId) {

		this.notificationDao.deleteNotificationByMNId(mnId);
		Map<String,Object> feedback = new HashMap<String,Object>() ;
		
		feedback.put("fId", fId) ;
		feedback.put("hasReplied", "N") ;
		
		this.userDAO.updateUserFeedbackReplyState(feedback);
		
	}
	
	/*
	 * 问卷信息列表
	 */
	public PageInfo<Map<String, Object>> queryQuestionnaireInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			
			
			// 获取问卷信息列表
			List<Map<String , Object>>  questionnaireInfoList = userDAO.queryQuestionnaireInfoList(paramMap);
			Integer pageCount = userDAO.queryQuestionnaireInfoListTotals(paramMap) ;
			pageInfo.setDataList( questionnaireInfoList ) ;
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
	 * (伪)删除问卷信息
	 */
	public void deleteQuestionnaireInfoList(Map<String, Object> paramMap) {
		try {
			// 删除问卷信息
			userDAO.deleteQuestionnaireInfoList(paramMap) ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}	
	/*
	 * 上传问卷信息
	 */
	public Map<String, Object> upQuestionnaireinfo(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			if((StringUtils.isNull(paramMap.get("questionTitle").toString()))){
				res.put("message", "请填写问卷名称！");
				res.put("succ", false);
				return res;
			}
			if(StringUtils.isNull(paramMap.get("endDt").toString())){
				paramMap.put("endDt", "");
				paramMap.put("timeLimit", "N");
			}
			paramMap.put("createDt", DateFormatUtil.buildCreateDt());
			paramMap.put("createTm", DateFormatUtil.CREATE_FULL_DATE_STR_TM());
			userDAO.insertQuestionnaireInfoList(paramMap) ;
			res.put("message", "提交成功！");
			res.put("succ", true ) ;
			return res;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
	}
	/*
	 * 查询问卷信息
	 */
	
	public Map<String, Object> queryQuestionnaireinfo(
			Map<String, Object> paramMap) {
		try{
			Map<String, Object> questionnaireInfoDetail = userDAO.queryQuestionnaireinfo(paramMap);
			return questionnaireInfoDetail;
		}catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 更新问卷调查信息
	 */
	public Map<String, Object> updateQuestionnaireInfo(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			if(StringUtils.isNull(paramMap.get("questionTitle").toString())){
				res.put("message", "请输入问卷名称！");
				res.put("succ", false);
				return res;
			}
			//更新问卷信息 ,如果设置题目为不限时，则置空有效时间
			if(("N").equals(paramMap.get("timeLimit"))){
				paramMap.put("endDt", " ");
			}
			userDAO.updateQuestionnaireInfo(paramMap);
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
	 * @Title: queryVoteInfoList 
	 * @author chen.zhao 
	 * @Description: 查询投票信息列表
	 * @param @param paramMap
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return PageInfo<Map<String,Object>>    返回类型 
	 * @throws
	 */
	public PageInfo<Map<String, Object>> queryVoteInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			
			// 获取投票信息列表
			List<Map<String , Object>>  voteInfoList = userDAO.queryVoteInfoList(paramMap);
			Integer pageCount = userDAO.queryVoteInfoListTotals(paramMap) ;
			pageInfo.setDataList( voteInfoList ) ;
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
	 * 查询题目信息 
	 */
	public PageInfo<Map<String, Object>> querySubjectInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			// 获取问卷题目信息列表
			List<Map<String , Object>>  subjectInfoList = userDAO.querySubjectInfoList(paramMap);
			Integer pageCount = userDAO.querySubjectInfoListTotals(paramMap) ;
			pageInfo.setDataList( subjectInfoList ) ;
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
	 * 上传投票
	 */
	public void upVoteInfo(Map<String, Object> paramMap)throws Exception {
		try {
			// 添加问卷信息
			if(StringUtils.isNull(paramMap.get("endDt").toString())){
				paramMap.put("endDt", " ");
				paramMap.put("timeLimit", "N");
			}
			paramMap.put("createDt", DateFormatUtil.buildCreateDt());
			paramMap.put("createTm", DateFormatUtil.CREATE_FULL_DATE_STR_TM());
			userDAO.insertVoteInfoList(paramMap) ;
		}catch (Exception e) {
		logger.error("错误日志：", e );
		throw e ;
		}
		
	}
	/**
	 * 
	 * @Title: queryVoteInfo 
	 * @author chen.zhao 
	 * @Description:查询投票信息
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return Map<String,Object>    返回类型 
	 * @throws
	 */
	public Map<String, Object> queryVoteInfo(Map<String, Object> paramMap) {
		try{
			Map<String, Object> voteInfoDetail = userDAO.queryVoteInfo(paramMap);
			return voteInfoDetail;
		}catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 更新投票信息
	 */
	public void updateVoteInfo(Map<String, Object> paramMap) {
		try {
			//更新投票信息
			if(("N").equals(paramMap.get("timeLimit"))){
				paramMap.put("endDt", " ");
			}
			userDAO.updateVoteInfo(paramMap);
		} catch (Exception e) {
			logger.error("错误日志：", e);
			throw e;
		}
	}
	/*
	 * 删除投票信息
	 */
	public void deleteVoteInfoList(Map<String, Object> paramMap) {
		try {
			// 删除投票信息
			userDAO.deleteVoteInfoList(paramMap) ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/**
	 * 
	 * @Title: upSubjectInfo 
	 * @author chen.zhao 
	 * @Description: 上传问卷题目
	 * @param @param paramMap    设定文件  
	 * @return void    返回类型 
	 * @throws
	 */
	public void upSubjectInfo(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			// 添加问卷题目信息
			//如果用户输入的字符下限为空：若题目类型是问答题(subjectType=3),则将字符下限设置为'0',否则为'1'
			if (com.fq.common.util.StringUtils.isNull( paramMap.get("limitDown").toString() ))  {
				if ( StringUtils.equals(paramMap.get("subjectType").toString(), "3")) {
					paramMap.put("limitDown", 0);
				}else {
					paramMap.put("limitDown", 1);
				}
			}
			paramMap.put("createDt", DateFormatUtil.buildCreateDt());
			paramMap.put("createTm", DateFormatUtil.CREATE_FULL_DATE_STR_TM());
			userDAO.insertSubjectInfoList(paramMap) ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	/**
	 * 
	 * @Title: deleteSubjectInfoList 
	 * @author chen.zhao 
	 * @Description: 删除问卷题目
	 * @param @param paramMap    设定文件  
	 * @return void    返回类型 
	 * @throws
	 */
	public void deleteSubjectInfoList(Map<String, Object> paramMap) {
		try {
			// 删除问卷信息
			userDAO.deleteSubjectInfoList(paramMap) ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	/*
	 * 查询问卷题目信息
	 */
	public Map<String, Object> querySubjectInfo(Map<String, Object> paramMap) {
		try{
			Map<String, Object> querySubjectInfoDetail = userDAO.querySubjectInfo(paramMap);
			return querySubjectInfoDetail;
		}catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}	
	/*
	 * 编辑更新问卷题目信息	
	 */
	public void updateSubjectInfo(Map<String, Object> paramMap) {
		try {
			userDAO.updateSubjectInfo(paramMap);
		} catch (Exception e) {
			logger.error("错误日志：", e);
			throw e;
		}
		
	}
	/*
	 * 编辑更新投票题目信息
	 */
	public void updateVoteSubjectInfo(Map<String, Object> paramMap) {
		try {
			userDAO.updateVoteSubjectInfo(paramMap);
		} catch (Exception e) {
			logger.error("错误日志：", e);
			throw e;
		}
		
	}
	/**
	 * 
	 * @Title: querySubject 
	 * @author chen.zhao 
	 * @Description: （增加前）查询问卷题目信息
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return Map<String,Object>    返回类型 
	 * @throws
	 */
	public Map<String, Object> querySubject(Map<String, Object> paramMap) {
		try {
			Map<String , Object> res = new HashMap<String, Object>();
			// 获取问卷调查题目信息列表
			List<Map<String , Object>> subjectList = userDAO.querySubject(paramMap);
			res.put("qId", paramMap.get("qId")) ;
			res.put("subjectList", subjectList);
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("subjectListInfo", res) ;
			return resMap ; 
		} catch (Exception e) {
			logger.error( "数据库异常" , e ) ;
			throw e ;
		}
	}
	/**
	 * 
	 * @Title: querySubjectOptionInfo 
	 * @author chen.zhao 
	 * @Description: TODO
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return PageInfo<Map<String,Object>>    返回类型 
	 * @throws
	 */
	public PageInfo<Map<String, Object>> querySubjectOptionInfo(
			Map<String, Object> paramMap) {
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
		try {
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			// 获取问卷题目选项信息列表
			List< Map<String , Object>> subjectOptionInfoList = userDAO.querySubjectOptionInfo(paramMap);
			// 获取问卷题目选项总数量
			Integer pageCount = userDAO.querySubjectOptionTotals(paramMap) ;
			pageInfo.setDataList( subjectOptionInfoList ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
			
		} catch (Exception e) {
			logger.error( "数据库异常" , e ) ;
			throw e ;
		}
	}
	/**
	 * 
	 * @Title: doToAddSubjectOption 
	 * @author chen.zhao 
	 * @Description: 查询题目信息
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return Map<String,Object>    返回类型 
	 * @throws
	 */
	public Map<String, Object> doToAddSubjectOption(Map<String, Object> paramMap) {
		try {
			Map<String , Object> res = new HashMap<String, Object>();
			// 查询该问卷调查题目的信息列表
			List<Map<String, Object>> subjectOptionList = userDAO.querySubjectOptionList(paramMap);
			res.put("sId", paramMap.get("sId")) ;
			res.put("subjectOptionList", subjectOptionList ) ;
			Map<String , Object> resMap = new HashMap<String, Object>();
			resMap.put("subjectOption", res) ;
			return resMap ; 
		} catch (Exception e) {
			logger.error("数据库异常"  , e ) ;
			throw e ;
		}
		
	}
	/*
	 * 上传题目选项
	 */
	public void upSubjectOption(Map<String, Object> paramMap) {
		try {
			//时间和日期默认设置为系统当前时间和日期
			paramMap.put("createDt", DateFormatUtil.buildCreateDt());
			paramMap.put("createTm", DateFormatUtil.CREATE_FULL_DATE_STR_TM());
			userDAO.upSubjectOption(paramMap);
		} catch (Exception e) {
			logger.error("数据库异常"  , e ) ;
			throw e ;
		}
	}
	/*
	 * 删除问卷调查题目
	 */
	public void deleteSubjectOption(Map<String, Object> paramMap) {
		try {
			// 删除问卷调查题目
			userDAO.deleteSubjectOption(paramMap) ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 查询问题选项信息
	 */
	public Map<String, Object> subjectOptionDetail(Map<String, Object> paramMap) {
		try{
			Map<String, Object> querySubjectOptionDetail = userDAO.subjectOptionDetail(paramMap);
			return querySubjectOptionDetail;
		}catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 更新问卷题目选项内容
	 */
	public void updateSubjectOptionInfo(Map<String, Object> paramMap) {
		try{
			userDAO.updateSubjectOptionInfo(paramMap);
		}catch (Exception e)
		{
			logger.error("错误日志"  , e);
		}		
	}
	/*
	 * 上传题目后更新问卷题目数量
	 */
	public void updateQuestionNum(Map<String, Object> paramMap) {
		try{
			userDAO.updateQuestionNum(paramMap);
		}catch (Exception e)
		{
			logger.error("错误日志"  , e);
		}		
	}
	/*
	 * 上传投票题目后更新投票题目数量
	 */
	public void updateVoteNum(Map<String, Object> paramMap) {
		try{
			userDAO.updateVoteNum(paramMap);
		}catch (Exception e)
		{
			logger.error("错误日志"  , e);
		}		
	}
	/*
	 * 批量上传新用户
	 */
	public void uploadNewUser(Map<String, Object> paramMap) {
		try {
			//用户密码默认为“123456”(MD5加密)
			paramMap.put("pwd", MD5Util.encrypt4Small("123456"));
			userDAO.insertBatchNewUser(paramMap);
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 修改用户是否禁言状态
	 */
	public Map<? extends String, ? extends Object> changeGag(
			Map<String, Object> paramMap) {
		try {
			this.userDAO.updateGag(paramMap) ;
			return  RetCode.buildRetCodeResult(RetCode.SUCCESS);
		} catch (Exception e) {
			logger.error("",e);
			return RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION);
		}
	}
	/*
	 * 查询用户信息
	 */
	public Map<String, Object> queryUserInfoList(Map<String, Object> paramMap) {
		try{
			Map<String , Object> useInfoMap = userDAO.queryUserInfoList(paramMap);
			return useInfoMap;
		}catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 更新用户信息
	 */
	public void updateUserInfo(Map<String, Object> paramMap) {
		try{
			userDAO.updateUserInfo(paramMap);
		}catch (Exception e)
		{
			logger.error("错误日志"  , e);
		}		
	}
	
	/*
	 * 查询用户领取奖励信息列表
	 */
	public PageInfo<Map<String, Object>> queryActiveAwardInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			// 获取用户领取奖励信息列表
			List<Map<String , Object>>  activeAwardInfoList = userDAO.queryActiveAwardInfoList(paramMap);
			Integer pageCount = userDAO.queryActiveAwardInfoListTotals(paramMap) ;
			pageInfo.setDataList( activeAwardInfoList ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	/**
	 * 
	 * @Title: queryActiveInfoList 
	 * @author chen.zhao 
	 * @Description: 查询活动推广列表
	 * @param @param paramMap
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return PageInfo<Map<String,Object>>    返回类型 
	 * @throws
	 */
	public PageInfo<Map<String, Object>> queryActiveInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			// 获取用户领取奖励信息列表
			List<Map<String , Object>>  activeInfoList = userDAO.queryActiveInfoList(paramMap);
			Integer pageCount = userDAO.queryActiveInfoListTotals(paramMap) ;
			pageInfo.setDataList( activeInfoList ) ;
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
	 * 查询活动推广信息
	 */
	public Map<String, Object> queryActiveInfo(
			Map<String, Object> paramMap) {
		try{
			Map<String, Object> activeInfoDetail = userDAO.queryActiveInfo(paramMap);
			String activeUrl =(String) activeInfoDetail.get("activeUrl");
			String succUrl = (String)activeInfoDetail.get("succUrl");
			if(!StringUtils.isNull(activeUrl)){
				String qiniuKey=interfaceUtil.getUrlByQiNiuKey(activeUrl);
				activeInfoDetail.put("activeUrl", qiniuKey);
			}
			if(!StringUtils.isNull(succUrl)){
				String qiNiuKey=interfaceUtil.getUrlByQiNiuKey(succUrl);
				activeInfoDetail.put("succUrl", qiNiuKey);
			}
			return activeInfoDetail;
		}catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 删除活动推广信息
	 */
	public void deleteActiveInfoList(Map<String, Object> paramMap) {
		try {
			userDAO.deleteActiveInfoList(paramMap) ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}

	public void updateActiveInfo(Map<String, Object> param) {
		try {
			userDAO.updateActiveInfo(param) ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	/*
	 * 上传安卓推广活动信息
	 */
	public void addActiveInfo(Map<String, Object> param) {
		try {
			userDAO.addActiveInfo(param) ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}	
	
	public PageInfo<Map<String, Object>> queryActiveUserInfo(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			List<Map<String , Object>>  activeUserInfoList = userDAO.queryActiveUserInfo(paramMap);
			Integer pageCount = userDAO.queryActiveUserInfoTotals(paramMap) ;
			pageInfo.setDataList( activeUserInfoList ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	
	public Map<? extends String, ? extends Object> changeUserSubRole(
			Map<String, Object> paramMap) throws Exception{
		try {
			this.userDAO.changeUserSubRole(paramMap) ;
			return  RetCode.buildRetCodeResult(RetCode.SUCCESS);
		} catch (Exception e) {
			logger.error("",e);
			return RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION);
		}
		
	}

	/*
	 * 查询水区帖子评论，可回复账号的信息
	 */
	public List<Map<String , Object>> queryIsReplyUserInfo() {
		Map<String,Object> paramMap = new HashMap<String,Object>() ;
		paramMap.put("account", GlobalProperties.SYSTEM_FEEDBACK_REPLIER);
		List<Map<String , Object>> userInfoList = userDAO.selectIsReplyUserInfo(paramMap);
		 if ( userInfoList != null && !userInfoList.isEmpty() ) {
			 for (Map<String, Object> user : userInfoList) {
				 user.put("userInfo", user.get("userNick")+"("+user.get("account")+")") ; 
				}
		}
		 return userInfoList ; 
	}
	/*
	 * 查询演员活动列表信息
	 */
	public PageInfo<OscarActiveVO> queryOscarActiveInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<OscarActiveVO> pageInfo = new PageInfo<OscarActiveVO>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			
			List<OscarActiveVO>  oscarActiveInfoList = userDAO.queryOscarActiveInfoList(paramMap);
			for(OscarActiveVO map : oscarActiveInfoList ){
				if(ImgUtil.checkStringIsQiniukey(map.getActiveImgUrl().toString())){
					map.setTrueUrl(ImgUtil.getUrlByQiNiuKey(map.getActiveImgUrl().toString(), null));
				}
			}
			Integer pageCount = userDAO.queryOscarActiveInfoListTotals(paramMap) ;
			pageInfo.setDataList( oscarActiveInfoList ) ;
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
	 * 上传演员活动信息
	 */
	public Map<String, Object> uploadOscarActiveInfo(Map<String, Object> paramMap) {
			Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			
			if(StringUtils.isNull(paramMap.get("activeTitle").toString())){
				res.put("message", "请填写活动标题！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("activeRule").toString())) {
				res.put("message", "请填写活动的相关细则！");
				res.put("succ", false);
				return res;
			}
			if(StringUtils.isNull(paramMap.get("startDt").toString())){
				paramMap.put("startDt",DateFormatUtil.buildCreateDt() );
			}
			if(StringUtils.isNull(paramMap.get("endDt").toString())){
				paramMap.put("endDt",DateFormatUtil.buildCreateDt() );
			}
			paramMap.put("createDt", DateFormatUtil.buildCreateDt());
			paramMap.put("createTm", DateFormatUtil.CREATE_FULL_DATE_STR_TM());
			
			
			userDAO.insertOscarActiveInfo(paramMap) ;
			res.put("message", "提交成功！");
			res.put("succ", true ) ;
			return res;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
	}

	/*
	 * 查询演员活动详细信息
	 */
	public Map<String, Object> queryOscarActiveDetail(Map<String, Object> paramMap) {
		try{
			Map<String, Object> oscarActiveInfoDetail = userDAO.queryOscarActiveDetail(paramMap);
			
			return oscarActiveInfoDetail;
		}catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 编辑演员活动信息
	 */
	public Map<String, Object> updateOscarActiveInfo(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			if(StringUtils.isNull(paramMap.get("activeTitle").toString())){
				res.put("message", "请填写活动标题！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("activeRule").toString())) {
				res.put("message", "请填写活动的相关细则！");
				res.put("succ", false);
				return res;
			}
			if(StringUtils.isNull(paramMap.get("startDt").toString())){
				paramMap.put("startDt",DateFormatUtil.buildCreateDt() );
			}
			if(StringUtils.isNull(paramMap.get("endDt").toString())){
				paramMap.put("endDt",DateFormatUtil.buildCreateDt());
			}
			userDAO.updateOscarActiveInfo(paramMap) ;
			res.put("message", "提交成功！");
			res.put("succ", true ) ;
			return res;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
	}
	/*
	 * 查询演员评奖活动信息列表
	 */
	public PageInfo<Map<String, Object>> queryOscarActiveActorInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			List<Map<String , Object>>  oscarActiveActorInfoList = userDAO.queryOscarActiveActorInfoList(paramMap);
			Integer pageCount = userDAO.queryOscarActiveActorInfoListTotals(paramMap) ;
			pageInfo.setDataList( oscarActiveActorInfoList ) ;
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
	 * 查询活动候选人信息
	 */
	public Map<String, Object> queryActiveActor(Map<String, Object> paramMap) {
		try {
			Map<String , Object> res = new HashMap<String, Object>();
			List<Map<String , Object>> actorList = userDAO.queryActiveActor(paramMap);
			res.put("oaId", paramMap.get("oaId")) ;
			res.put("actorList", actorList);
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("actorListInfo", res) ;
			return resMap ; 
		} catch (Exception e) {
			logger.error( "数据库异常" , e ) ;
			throw e ;
		}
	}
	/*
	 * 新增演员活动信息
	 */
	public Map<String, Object> uploadOscarActiveActorInfo(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			if(StringUtils.isNull(paramMap.get("account").toString())){
				res.put("message", "请填写演员账号！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("awardWords").toString())) {
				res.put("message", "请填写演员颁奖词！");
				res.put("succ", false);
				return res;
			}
			userDAO.insertOscarActiveActorInfo(paramMap) ;
			res.put("message", "提交成功！");
			res.put("succ", true ) ;
			return res;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
	}
	/*
	 * 查询编辑候选人信息
	 */
	public Map<String, Object> queryOscarActiveActorDetail(Map<String, Object> paramMap) {
		try{
			Map<String, Object> oscarActiveActorInfoDetail = userDAO.queryOscarActiveActorDetail(paramMap);
			
			return oscarActiveActorInfoDetail;
		}catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 编辑候选人信息
	 */
	public Map<String, Object> updateOscarActiveActorInfo(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			if(StringUtils.isNull(paramMap.get("account").toString())){
				res.put("message", "请填写演员账号！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("awardWords").toString())) {
				res.put("message", "请填写演员颁奖词！");
				res.put("succ", false);
				return res;
			}
			userDAO.updateOscarActiveActorInfo(paramMap) ;
			res.put("message", "提交成功！");
			res.put("succ", true ) ;
			return res;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
	}
	/*
	 * 演员活动选票列表信息
	 */
	public PageInfo<Map<String, Object>> queryOscarActiveVoteInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			List<Map<String , Object>>  oscarActiveVoteInfoList = userDAO.queryOscarActiveVoteInfoList(paramMap);
			
			for(Map<String , Object> map : oscarActiveVoteInfoList ){
				if(ImgUtil.checkStringIsQiniukey(map.get("voteImg").toString())){
					map.put("trueUrl", ImgUtil.getUrlByQiNiuKey(map.get("voteImg").toString(), null));
				}
			}
			Integer pageCount = userDAO.queryOscarActiveVoteInfoListTotals(paramMap) ;
			pageInfo.setDataList( oscarActiveVoteInfoList ) ;
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
	 * 编辑演员活动选票界面
	 */
	public Map<String, Object> queryOscarActiveVoteDetail(Map<String, Object> paramMap) {
		try{
			Map<String, Object> oscarActiveVoteInfoDetail = userDAO.queryOscarActiveVoteDetail(paramMap);
			
			String oscarActiveVoteImgUrl =(String) oscarActiveVoteInfoDetail.get("voteImg");
			
			if(!StringUtils.isNull(oscarActiveVoteImgUrl)){
				
				String qiniuKey=interfaceUtil.getUrlByQiNiuKey(oscarActiveVoteImgUrl);
				oscarActiveVoteInfoDetail.put("voteImgUrl", qiniuKey);
			}
			return oscarActiveVoteInfoDetail;
		}catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 编辑更新活动选票信息
	 */
	public Map<String, Object> updateOscarActiveVoteInfo(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			if(StringUtils.isNull(paramMap.get("voteName").toString())){
				res.put("message", "请填写选票名称！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("voteDesc").toString())) {
				res.put("message", "请填写选票描述！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("votePrice").toString())) {
				res.put("message", "请填写选票价格！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("voteJpoint").toString())) {
				res.put("message", "请填写选票据点！");
				res.put("succ", false);
				return res;
			}
			userDAO.updateOscarActiveVoteInfo(paramMap) ;
			res.put("message", "提交成功！");
			res.put("succ", true ) ;
			return res;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
	}
	/*
	 * 新增演员活动选票信息
	 */
	public Map<String, Object> uploadOscarActiveVoteInfo(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			if(StringUtils.isNull(paramMap.get("voteName").toString())){
				res.put("message", "请填写选票名称！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("voteDesc").toString())) {
				res.put("message", "请填写选票描述！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("votePrice").toString())) {
				res.put("message", "请填写选票价格！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("voteJpoint").toString())) {
				res.put("message", "请填写选票据点！");
				res.put("succ", false);
				return res;
			}
			//维护上传的选票信息，如果上传的选票类型已存在且在使用中，则将之前的选票状态修改为已删除
			List<String> voteType = userDAO.selectActiveVoteType();
//			if(voteType.contains(paramMap.get("voteType"))){
//				res.put("message", "该选票类型已存在，请检查完重新选择！");
//				res.put("succ", false);
//				return res;
//			}
			for (String vt : voteType) {
				if (StringUtils.equals(vt, paramMap.get("voteType").toString())  ) {
					
					userDAO.updateVoteTypeState(vt);
				}
			}
			paramMap.put("orderIndex", "0");
			userDAO.insertOscarActiveVoteInfo(paramMap) ;
			res.put("message", "提交成功！");
			res.put("succ", true ) ;
			return res;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
	}

	/*
	 * 删除演员活动选票信息
	 */
	public void deletedOscarActiveVoteInfoList(Map<String, Object> paramMap) {
		try {
			userDAO.deletedOscarActiveVoteInfoList(paramMap) ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 演员活动选票排序修改
	 */
	public void updateActiveVoteOrderIndex(Map<String, Object> paramMap) throws Exception {
		try{
			if(StringUtils.isNull(paramMap.get("orderIndex").toString()) ){
				paramMap.put("orderIndex", 0);
			}
			userDAO.updateActiveVoteOrderIndex(paramMap);
		} catch (Exception e) {
			logger.error("数据库异常" + e ) ;
			throw e ;
		}
	}
	
	public void updateActiveActorOrderIndex(Map<String, Object> paramMap) throws Exception {
		try{
			if(StringUtils.isNull(paramMap.get("orderIndex").toString()) ){
				paramMap.put("orderIndex", 0);
			}
			userDAO.updateActiveActorOrderIndex(paramMap);
		} catch (Exception e) {
			logger.error("数据库异常" + e ) ;
			throw e ;
		}
	}
	
	public Map<? extends String, ? extends Object> changeManager(
			Map<String, Object> paramMap) throws Exception{
		try {
			this.userDAO.updateManager(paramMap) ;
			return  RetCode.buildRetCodeResult(RetCode.SUCCESS);
		} catch (Exception e) {
			logger.error("",e);
			return RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION);
		}
		
	}


	public List<UserBehaviorVO> toListUserBehaviors(String account) {
		return this.userDAO.queryUserBehaviors(account);
	}
	
	/*
     * 查询用户详情
     */
    public UserInfoVO queryUserDetailInfo(Map<String, Object> paramMap)throws Exception  {
        try {
            UserInfoVO userDetail = userDAO.selectUserDetailInfo(paramMap);
            return userDetail ;
        } catch (Exception e) {
            logger.error("数据库异常" + e ) ;
            throw e ;
        }
    }
    /*
     * 查询用户消费明细
     */
    public PageInfo<UserJPointLogVO> queryUserJpointLog(
            Map<String, Object> paramMap)throws Exception {
        try {
            PageInfo<UserJPointLogVO> pageInfo = new PageInfo<UserJPointLogVO>();
            paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
            List<UserJPointLogVO>  userJpointLogInfoList = userDAO.queryUserJpointLogInfoList(paramMap);
            Integer pageCount = userDAO.queryUserWalletChangeInfoListTotals(paramMap) ;
            pageInfo.setDataList( userJpointLogInfoList ) ;
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
     * 查询用户充值记录
     */
    public UserJPointLogVO queryUserRechargeRecord(Map<String, Object> paramMap)throws Exception  {
        try {
        	UserJPointLogVO userRechargeRecord = userDAO.selectUserRechargeRecord(paramMap);
            return userRechargeRecord ;
        } catch (Exception e) {
            logger.error("数据库异常" + e ) ;
            throw e ;
        }
    }
    /*
     * 用户行为统计
     */
    public List<UserBehaviorVO> toListUserBehaviorsCount(String account) {
		return this.userDAO.selectUserBehaviorsCount(account);
	}
    
    /*
	 * 查询选书祈愿活动，候选书籍信息
	 */
	public PageInfo<OscarActiveBookVO> queryOscarActiveBookInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<OscarActiveBookVO> pageInfo = new PageInfo<OscarActiveBookVO>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			
			List<OscarActiveBookVO>  oscarActiveBookVOs = userDAO.queryOscarActiveBookInfoList(paramMap);
			for(OscarActiveBookVO osActiveBookVO : oscarActiveBookVOs ){
				if(ImgUtil.checkStringIsQiniukey(osActiveBookVO.getBookCoverUrl())){
					osActiveBookVO.setQiniuUrl(ImgUtil.getUrlByQiNiuKey(osActiveBookVO.getBookCoverUrl(), null));
				}
			}
			Integer pageCount = userDAO.queryOscarActiveBookInfoListTotal(paramMap) ;
			pageInfo.setDataList( oscarActiveBookVOs ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	/**
	 * 
	 * @Title: uploadOscarActiveBookInfo 
	 * @author chen.zhao 
	 * @Description: 新增选书信息
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return Map<String,Object>    返回类型
	 */
	public Map<String, Object> uploadOscarActiveBookInfo(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			if(StringUtils.isNull(paramMap.get("bookName").toString())){
				res.put("message", "请填写图书名称！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("bookAuthor").toString())) {
				res.put("message", "请填写图书作者！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("bookWords").toString())) {
				res.put("message", "请填写图书简介！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("bookDetail").toString())) {
				res.put("message", "请填写图书概述！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("bookType").toString())) {
				res.put("message", "请填写图书类型！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("bookTags").toString())) {
				res.put("message", "请填写图书标签！");
				res.put("succ", false);
				return res;
			}
			StringBuilder trueBookName = new StringBuilder();
			trueBookName.append("《").append(paramMap.get("bookName")).append("》");
			paramMap.put("trueBookName", trueBookName.toString());
			userDAO.insertOscarActiveBookInfo(paramMap) ;
			res.put("message", "提交成功！");
			res.put("succ", true ) ;
			return res;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
	}
	
	public Map<String, Object> queryOscarActiveBookDetail(Map<String, Object> paramMap) {
		try{
			Map<String, Object> bookDetailInfo = userDAO.queryOscarActiveBookDetail(paramMap);
			return bookDetailInfo;
		}catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/**
	 * 
	 * @Title: updateOscarActiveBookInfo 
	 * @author chen.zhao 
	 * @Description: TODO
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return Map<String,Object>    返回类型
	 */
	public Map<String, Object> updateOscarActiveBookInfo(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			if(StringUtils.isNull(paramMap.get("bookName").toString())){
				res.put("message", "请填写图书名称！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("bookAuthor").toString())) {
				res.put("message", "请填写图书作者！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("bookWords").toString())) {
				res.put("message", "请填写图书简介！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("bookDetail").toString())) {
				res.put("message", "请填写图书概述！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("bookType").toString())) {
				res.put("message", "请填写图书类型！");
				res.put("succ", false);
				return res;
			}
			if (StringUtils.isNull(paramMap.get("bookTags").toString())) {
				res.put("message", "请填写图书标签！");
				res.put("succ", false);
				return res;
			}
			userDAO.updateOscarActiveBookInfo(paramMap) ;
			res.put("message", "提交成功！");
			res.put("succ", true ) ;
			return res;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
	}
	
	public void updateActiveBookOrderIndex(Map<String, Object> paramMap) throws Exception {
		try{
			if(StringUtils.isNull(paramMap.get("orderIndex").toString()) ){
				paramMap.put("orderIndex", 0);
			}
			userDAO.updateActiveBookOrderIndex(paramMap);
		} catch (Exception e) {
			logger.error("数据库异常" + e ) ;
			throw e ;
		}
	}
	/**
	 * 
	 * @Title: updateIsExpired 
	 * @author chen.zhao 
	 * @Description: TODO
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return Map<String,Object>    返回类型
	 */
	public Map<String, Object> updateIsExpired(Map<String, Object> paramMap) {
		Map<String , Object > res = new HashMap<String, Object>() ;
		try {
			//查询当前是否有正在开始的活动
			Integer count = userDAO.selectIsActiveExist();
			
			if (count > 0 && paramMap.get("toChangeIsExpired").equals("N")) {
				res.put("message", "当前已存在使用的选票活动，请等待活动结束！");
				res.put("succ", false);
				return res;
			}
			userDAO.updateIsExpired(paramMap) ;
			res.put("message", "提交成功！");
			res.put("succ", true ) ;
			return res;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
	}


	public ThirdUserInfoVO selectThirdUserInfo(Integer adminId) {
		return userDAO.selectThirdUserInfo(adminId);
	}

	
	public Map<String, Object> editUserInfo(EditThirdUserInfoForm form, HttpServletRequest request)throws Exception {
		try {
			//删除用户账号信息
			userDAO.delThirdUserInfo(form.getaId());
			Map<String, Object> data = new HashMap<>();
			Map<String, Object> paraMap = BeanUtil.getOrderModel(request);
			
			for (Map.Entry<String, Object> entry : paraMap.entrySet()) {
				String value = request.getParameter((String) entry.getKey());
				entry.setValue(value);
			}
			paraMap.put("aId", form.getaId());
			//信息验证
			if (StringUtils.isNull(form.getPartnerName()) || StringUtils.isNull(form.getCorporateName()) ||StringUtils.isNull(form.getContractName()) || 
					StringUtils.isNull(form.getIdName()) ||StringUtils.isNull(form.getPhone()) ||StringUtils.isNull(form.getOpeningBank()) ||
					StringUtils.isNull(form.getCardName()) ||StringUtils.isNull(form.getAccountName()) ) {
				data.putAll(RetCode.buildRetCodeResult(RetCode.ACCOUNT_INFO_EMPTY)) ;
				return data ;
			}
			//插入三方用户账号信息
			userDAO.insertThirdUserInfo(paraMap);
			data.putAll(RetCode.buildRetCodeResult(RetCode.SUCCESS)) ;
			return data ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			return RetCode.buildRetCodeResult(RetCode.SYSTEM_ERROR); 
		}
	}
	
	
	
	
}

