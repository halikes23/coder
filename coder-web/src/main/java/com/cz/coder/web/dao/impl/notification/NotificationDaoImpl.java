package com.fq.dao.impl.notification;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Repository;

import com.fq.common.constant.CommonConstant;
import com.fq.dao.BaseDAO;
import com.fq.dao.dao.notification.NotificationDAO;
import com.fq.dao.entity.po.UserNotificationPO;
import com.fq.dao.entity.vo.ProjectInfoVO;
import com.fq.dao.entity.vo.notification.SysNotificationVO;
import com.fq.dao.entity.vo.notification.UserNotificationVO;
import com.fq.entity.po.UNotificationPO;
import com.fq.properties.GlobalProperties;
import com.fq.util.DateFormatUtil;
import com.ibatis.sqlmap.client.SqlMapExecutor;
@Repository
public class NotificationDaoImpl extends BaseDAO implements NotificationDAO {

	@Override
	public List<Map<String, Object>> queryNotificationList(Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("Notification.queryNotificationList" , paramMap );
	}

	@Override
	public Integer querysysNotificationTotals() {
		return (Integer) getSqlMapClientTemplate().queryForObject("Notification.querysysNotificationTotals");
	}

	@Override
	public SysNotificationVO queryNotificationDetail(
			Map<String, Object> paramMap) {
		return (SysNotificationVO) getSqlMapClientTemplate().queryForObject( "Notification.queryNotificationDetail", paramMap );
	}

	@Override
	public void updateNotification(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("Notification.updateNotification", paramMap ) ;
	}

	@Override
	public void deleteNotification(Map<String, Object> paramMap) {
		// getSqlMapClientTemplate().delete("Notification.deleteNotification", paramMap ) ;
		getSqlMapClientTemplate().update("Notification.deleteNotification" , paramMap ) ;
	}

	@Override
	public Integer uploadNotification(Map<String, Object> paramMap) {
		return  (Integer) getSqlMapClientTemplate().insert("Notification.uploadNotification", paramMap ) ;
	}

	@Override
	public void doNotificationQuartz() {
		getSqlMapClientTemplate().update("Notification.doNotificationQuartz" ) ;
 	}

	@Override
	public void deleteUserNotification(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().delete("Notification.deleteUserNotification", paramMap ) ;
	}

	@Override
	public void doUploadNotifyForChasing(final Map<String, Object> paramMap) {
		getSqlMapClientTemplate().execute( new SqlMapClientCallback<Integer>() {

			@Override
			public Integer doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				//开始执行
				executor.startBatch();
				try{
				Integer piId = Integer.parseInt(paramMap.get("piId").toString());
				//先根据项目id查询出所有追它的用户
				@SuppressWarnings("unchecked")
				List<String> accountList = executor.queryForList("Notification.selectAllUserByPiId", paramMap );
				Integer msnId = Integer.parseInt(paramMap.get("msnId").toString());
				if( null == accountList || accountList.isEmpty() ){
					return null ;
				}
				
				addUserNotification(paramMap, executor, accountList, piId , "5" , msnId );
				
				// 执行批处理  
	            executor.executeBatch(); 
				}catch (Exception e) {
					e.printStackTrace() ;
					// TODO: handle exception
				}
	            
	            return null;
			}
			/**
			 * 添加记录
			 */
			private void addUserNotification(
					final Map<String, Object> paramMap,
					SqlMapExecutor executor, List<String> accountList,
					Integer piId , String notifyType , Integer msnId ) throws SQLException {
				for (String account : accountList) {
					UserNotificationPO userNotificationPO = new UserNotificationPO();
					userNotificationPO.setNotifyAccount(account);
					userNotificationPO.setOprAccount(GlobalProperties.SYSTEM_HELPER); //系统小助手账号
					userNotificationPO.setPiId(piId);
					userNotificationPO.setIsReaded("N");
					userNotificationPO.setNotifyType(notifyType);  
					userNotificationPO.setContent(paramMap.get("content").toString());
					userNotificationPO.setCreateDate(DateFormatUtil.CREATE_FULL_DATE_STR_DB());
					userNotificationPO.setNotifyModuleId(piId);
					userNotificationPO.setMsnId(msnId) ;
					executor.insert("Notification.insertIntoNotification", userNotificationPO );
				}
			}
			
		} );
	}

	@Override
	public void doSendUpdateNotification( final Map<String, Object> paramMap) {
		getSqlMapClientTemplate().execute(new SqlMapClientCallback<Integer>() {

			@Override
			public Integer doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch() ;
				Integer piId = Integer.parseInt(paramMap.get("piId").toString());
				Integer msnId = Integer.parseInt(paramMap.get("msnId").toString());
				
				// 查询追该漫画的所有用户
				@SuppressWarnings("unchecked")
				List<String> accountList = executor.queryForList("Notification.selectAllChaseUserByPlcId", paramMap );
				if( null == accountList || accountList.isEmpty() ){
					return null ;
				}
				// 分别为追漫画用户添加更新消息
				addUserNotification(paramMap, executor, accountList,  piId , "9" , msnId);
				executor.executeBatch() ; 
				return null;
			}
			/**
			 * 添加记录
			 */
			private void addUserNotification(
					final Map<String, Object> paramMap,
					SqlMapExecutor executor, List<String> accountList,
					Integer piId , String notifyType  ,  Integer msnId) throws SQLException {
				for (String account : accountList) {
					UserNotificationPO userNotificationPO = new UserNotificationPO();
					userNotificationPO.setNotifyAccount(account);
					userNotificationPO.setOprAccount(GlobalProperties.SYSTEM_HELPER); //系统小助手账号
					userNotificationPO.setPiId(piId);
					userNotificationPO.setIsReaded("N");
					userNotificationPO.setNotifyType(notifyType);  
					userNotificationPO.setContent(paramMap.get("content").toString());
					userNotificationPO.setCreateDate(DateFormatUtil.CREATE_FULL_DATE_STR_DB());
					userNotificationPO.setNotifyModuleId(piId);
					userNotificationPO.setMsnId(msnId) ;
					executor.insert("Notification.insertIntoNotification", userNotificationPO );
				}
			}
			
			
		}) ;
	}

	@Override
	public void insertNotification(UNotificationPO notification) {
		
		this.getSqlMapClientTemplate().insert("Notification.insertNotification" , notification) ;
		
	}

	@Override
	public void deleteNotificationByMNId(Integer mnId) {
		getSqlMapClientTemplate().delete("Notification.deleteNotificationByMNId",mnId) ;
	}

	@Override
	public ProjectInfoVO queryProjectInfoByPlcId(Map<String, Object> paramMap) {
		return (ProjectInfoVO) getSqlMapClientTemplate().queryForObject("ProjectDaoImpl.queryProjectInfoByPlcId", paramMap );
	}

	@Override
	public void sendCartoonUpdateNotification(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("Notification.sendCartoonUpdateNotification", paramMap ) ;
	}

	@Override
	public void sendMovieUpdateNotification(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("Notification.sendMovieUpdateNotification" , paramMap ) ;
	}

	@Override
	public void uploadUserNotification(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("Notification.insertUserNotification" , paramMap ) ;
	}
	
	@Override
	public void uploadQuestionNotification(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("Notification.insertQuestionNotification" , paramMap ) ;
	}
	
	@Override
	public void doSendLiveCartoonNotification() {
		getSqlMapClientTemplate().update("Notification.doSendLiveCartoonNotification") ;
	}

	@Override
	public void insertHisFromNotification(String date) {
		this.getSqlMapClientTemplate().insert("Notification.insertHisFromNotification",date) ;
		
	}
	
	@Override
	public void insertHisFromSysNotification(String date) {
		this.getSqlMapClientTemplate().insert("Notification.insertHisFromSysNotification",date) ;
		
	}

	@Override
	public void deleteHisNotification(String date) {
		this.getSqlMapClientTemplate().delete("Notification.deleteHisNotification",date) ;
	}

	@Override
	public void deleteHisSysNotification(String date) {
		this.getSqlMapClientTemplate().delete("Notification.deleteHisSysNotification",date) ;
	}

	@Override
	public void deleteUserNotificationByTypeAndModuleId(String notifyType,
			Integer notifyModuleId) {
		Map<String,Object> params = new HashMap<String,Object>() ;
		params.put("notifyType",notifyType) ;
		params.put("notifyModuleId", notifyModuleId) ;
		this.getSqlMapClientTemplate().delete("Notification.deleteUserNotificationByTypeAndModuleId") ;
	}

	@Override
	public void deleteUserNotificationByTypeAndOaId(
			String notifyType, Integer oaId) {
		Map<String,Object> params = new HashMap<String,Object>() ;
		params.put("notifyType",notifyType) ;
		params.put("oaId", oaId) ;
		this.getSqlMapClientTemplate().delete("Notification.deleteUserNotificationByTypeAndOaId",params) ;
	}
	
	@Override
	public void sendProjectLogUpdateNotification(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("Notification.sendProjectLogUpdateNotification", paramMap ) ;
	}
	
	@Override
	public void sendProjectLogReplyCommentNotification(Map<String, Object> paraMap) {
		getSqlMapClientTemplate().insert("Notification.sendProjectLogReplyCommentNotification", paraMap ) ;
	}

	@Override
	public List<Map<String, Object>> queryUserReplyNotificationList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("Notification.selectUserReplyNotificationList" , paramMap );
	}

	@Override
	public Integer queryUserReplyNotificationTotals() {
		return (Integer) getSqlMapClientTemplate().queryForObject("Notification.selectUserReplyNotificationTotals");
	}
	
	@Override
	public void uploadReplyUserReplyNotificationInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("Notification.uploadReplyUserReplyNotificationInfo", paramMap ) ;
	}
	
	@Override
	public void insertProjectLogPraiseNotification(UserNotificationVO userNotificationVO) {
		getSqlMapClientTemplate().insert("Notification.insertProjectLogPraiseNotification", userNotificationVO ) ;
	}
}
