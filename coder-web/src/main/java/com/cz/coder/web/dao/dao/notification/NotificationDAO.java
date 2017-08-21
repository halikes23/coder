package com.fq.dao.dao.notification;

import java.util.List;
import java.util.Map;

import com.fq.dao.entity.vo.ProjectInfoVO;
import com.fq.dao.entity.vo.notification.SysNotificationVO;
import com.fq.dao.entity.vo.notification.UserNotificationVO;
import com.fq.entity.po.UNotificationPO;


public interface NotificationDAO {

	/**
	 * 
	 * @Title: querysysNotificationTotals 
	 * @Description: 查询系统消息总数量
	 * @param @return    设定文件  
	 * @return Integer    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	Integer querysysNotificationTotals();
	/**
	 * 
	 * @Title: queryNotificationList 
	 * @Description: 查询系统消息列表
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return List<Map<String,Object>>    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	List<Map<String, Object>> queryNotificationList(Map<String, Object> paramMap);
	/**
	 * 
	 * @Title: queryNotificationDetail 
	 * @Description: 查询系统消息详情
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return SysNotificationVO    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	SysNotificationVO queryNotificationDetail(Map<String, Object> paramMap);
	/**
	 * 
	 * @Title: updateNotification 
	 * @Description: 修改系统消息
	 * @param @param paramMap    设定文件  
	 * @return void    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	void updateNotification(Map<String, Object> paramMap);
	/**
	 * 
	 * @Title: deleteNotification 
	 * @Description: 删除系统消息信息
	 * @param @param paramMap    设定文件  
	 * @return void    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	void deleteNotification(Map<String, Object> paramMap);
	/**
	 * @return 
	 * 
	 * @Title: uploadNotification 
	 * @Description: 新建系统信息
	 * @param @param paramMap    设定文件  
	 * @return void    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	Integer uploadNotification(Map<String, Object> paramMap);
	/**
	 * 
	 * @Title: doNotificationQuartz 
	 * @Description: 定时更新系统消息状态
	 * @param     设定文件  
	 * @return void    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	void doNotificationQuartz();
	/**
	 * 
	 * @Title: deleteUserNotification 
	 * @Description: 删除用户系统消息列表
	 * @param @param paramMap    设定文件  
	 * @return void    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	void deleteUserNotification(Map<String, Object> paramMap);
	
	/**
	 * 给所有追项目的用户发送更新消息
	 * @param paramMap
	 */
	void doUploadNotifyForChasing(Map<String, Object> paramMap);
	
	/**
	 * 发送漫画追剧消息
	 */
	void doSendUpdateNotification(Map<String, Object> paramMap);
	
	/**
	 * 发送消息
	 * @param notification
	 */
	void insertNotification(UNotificationPO notification);
	
	/**
	 * 根据fId编号删除消息
	 * @param fId
	 */
	void deleteNotificationByMNId(Integer mnId);
	ProjectInfoVO queryProjectInfoByPlcId(Map<String, Object> paramMap);
	
	void sendCartoonUpdateNotification(Map<String, Object> paramMap);
	
	void sendMovieUpdateNotification(Map<String, Object> paramMap);
	
	void uploadUserNotification(Map<String, Object> paramMap);
	
	void uploadQuestionNotification(Map<String, Object> paramMap);
	
	void doSendLiveCartoonNotification();
	
	void insertHisFromNotification(String date);

	void insertHisFromSysNotification(String date);
	
	void deleteHisNotification(String date);

	void deleteHisSysNotification(String date);
	
	void deleteUserNotificationByTypeAndModuleId(String notifyType , Integer notifyModuleId);
	
	void deleteUserNotificationByTypeAndOaId(String notifyType, Integer oaId);
	
	void sendProjectLogUpdateNotification(Map<String, Object> paramMap);
	
	void sendProjectLogReplyCommentNotification(Map<String, Object> paramMap);
	
	List<Map<String, Object>> queryUserReplyNotificationList(
			Map<String, Object> paramMap);
	
	Integer queryUserReplyNotificationTotals();
	
	void uploadReplyUserReplyNotificationInfo(Map<String, Object> paramMap);
	
	void insertProjectLogPraiseNotification(
			UserNotificationVO userNotificationVO);
	
	
}
