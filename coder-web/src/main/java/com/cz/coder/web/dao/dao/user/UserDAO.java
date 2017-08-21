package com.fq.dao.dao.user;

import java.util.List;
import java.util.Map;

import com.fq.dao.entity.po.TradeAppInfoPO;
import com.fq.dao.entity.po.user.UserInfoPO;
import com.fq.dao.entity.vo.OperateLog;
import com.fq.dao.entity.vo.OscarActiveBookVO;
import com.fq.dao.entity.vo.OscarActiveVO;
import com.fq.dao.entity.vo.ThirdUserInfoVO;
import com.fq.dao.entity.vo.WaterManCommentVO;
import com.fq.dao.entity.vo.pay.VipRechargeLogVO;
import com.fq.dao.entity.vo.report.UserReportVO;
import com.fq.dao.entity.vo.user.AddNewUserVO;
import com.fq.dao.entity.vo.user.NewUserVO;
import com.fq.dao.entity.vo.user.RewardUserInfoVO;
import com.fq.dao.entity.vo.user.UserBehaviorVO;
import com.fq.dao.entity.vo.user.UserInfoVO;
import com.fq.dao.entity.vo.user.UserJPointLogVO;
import com.fq.dao.entity.vo.user.UserPhotoVO;
import com.fq.entity.vo.wallet.RedPacketRangeCfgVO;
import com.fq.form.user.AddUserPhotoForm;
import com.fq.form.user.EditThirdUserInfoForm;

public interface UserDAO {


	Integer queryTotalCount(Map<String,Object> param);

	Integer queryNewUserCount(Map<String, Object> param);
	
	List<UserInfoVO> selectUserInfoForPage(Map<String,Object> param);
	
	List<Map<String , Object>> selectUserInfoList(Map<String,Object> param);
	
	Integer selectUserInfoCount(Map<String,Object> param);
	
	Integer updateUserRole(UserInfoPO user);
	
	List<UserPhotoVO> selectUserPhotoesByAccount(String account) ;
	
	int deleteUserPhotoes(String[] upId);

	void insertUserPhoto(AddUserPhotoForm form);

	void updateUserJpoint(RewardUserInfoVO rewardUserInfoVO);

	void insertNewRecord(TradeAppInfoPO tradeAppInfoPO);
	/**
	 * 
	 * @Title: queryTesterList 
	 * @Description: 查询测试人员信息列表
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return List<Map<String,Object>>    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	List<Map<String, Object>> queryTesterList(Map<String, Object> paramMap);
	/**
	 * 
	 * @Title: queryTesterTotals 
	 * @Description: 查询测试人员数量
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return Integer    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	Integer queryTesterTotals(Map<String, Object> paramMap);
	/**
	 * 
	 * @Title: updateTester 
	 * @Description: 新增/删除测试用户
	 * @param @param paramMap    设定文件  
	 * @return void    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	void updateTester(Map<String, Object> paramMap);

	void insertOperateLog(OperateLog logger);

	List<WaterManCommentVO> queryWaterMansWork(Map<String, Object> paramMap);

	Integer queryWaterMansWorkTotal(Map<String, Object> paramMap);
	
	/**
	 * 判断用户是否存在
	 */
	public boolean isExist(Map<String, Object> paramMap);

	void addNewUser(AddNewUserVO user);

	List<Map<String, Object>> queryUserFeedBackInfoList(
			Map<String, Object> paramMap);

	Integer queryUserFeedBackInfoTotal(Map<String, Object> paramMap);
	
	List<Map<String, Object>> queryUserMobileInfoList(
			Map<String, Object> paramMap);

	Integer queryUserMobileInfoListTotal(Map<String, Object> paramMap);

	void updateNavy(Map<String, Object> paramMap);

	List<Map<String, Object>> queryNavyList(Map<String, Object> paramMap);

	Integer queryNavyTotals(Map<String, Object> paramMap);

	List<Map<String, Object>> queryUserFeedBackAndNotification(String account);

	Map<String, Object> queryUserFeedBackByFId(Integer fId);

	void updateUserFeedbackReplyState(Map<String, Object> feedback);

	UserInfoVO queryUserByAccount(String entityNo);

	void updateUserJPoint(UserInfoPO user);

	List<Map<String, Object>> queryQuestionnaireInfoList(
			Map<String, Object> paramMap);

	Integer queryQuestionnaireInfoListTotals(Map<String, Object> paramMap);

	void deleteQuestionnaireInfoList(Map<String, Object> paramMap);

	void insertQuestionnaireInfoList(Map<String, Object> paramMap);

	Map<String, Object> queryQuestionnaireinfo(Map<String, Object> paramMap);

	void updateQuestionnaireInfo(Map<String, Object> paramMap);

	List<Map<String, Object>> querySubjectInfoList(Map<String, Object> paramMap);

	Integer querySubjectInfoListTotals(Map<String, Object> paramMap);

	List<Map<String, Object>> queryVoteInfoList(Map<String, Object> paramMap);

	Integer queryVoteInfoListTotals(Map<String, Object> paramMap);

	void insertVoteInfoList(Map<String, Object> paramMap);


	Map<String, Object> queryVoteInfo(Map<String, Object> paramMap);

	void updateVoteInfo(Map<String, Object> paramMap);

	void deleteVoteInfoList(Map<String, Object> paramMap);

	void insertSubjectInfoList(Map<String, Object> paramMap);

	void deleteSubjectInfoList(Map<String, Object> paramMap);

	Map<String, Object> querySubjectInfo(Map<String, Object> paramMap);

	void updateSubjectInfo(Map<String, Object> paramMap);

	List<Map<String, Object>> querySubject(Map<String, Object> paramMap);

	List<Map<String, Object>> querySubjectOptionInfo(
			Map<String, Object> paramMap);

	Integer querySubjectOptionTotals(Map<String, Object> paramMap);

	List<Map<String, Object>> querySubjectOptionList(
			Map<String, Object> paramMap);

	void upSubjectOption(Map<String, Object> paramMap);

	void deleteSubjectOption(Map<String, Object> paramMap);

	Map<String, Object> subjectOptionDetail(Map<String, Object> paramMap);

	void updateSubjectOptionInfo(Map<String, Object> paramMap);

	void updateVoteSubjectInfo(Map<String, Object> paramMap);

	void updateQuestionNum(Map<String, Object> paramMap);

	void updateVoteNum(Map<String, Object> paramMap);

	void insertBatchNewUser(Map<String, Object> paramMap);

	void updateGag(Map<String, Object> paramMap);

	Map<String, Object> queryUserInfoList(Map<String, Object> paramMap);

	void updateUserInfo(Map<String, Object> paramMap);

	List<Map<String, Object>> queryActiveAwardInfoList(Map<String, Object> paramMap);

	Integer queryActiveAwardInfoListTotals(Map<String, Object> paramMap);

	List<Map<String, Object>> queryActiveInfoList(Map<String, Object> paramMap);

	Integer queryActiveInfoListTotals(Map<String, Object> paramMap);

	Map<String, Object> queryActiveInfo(Map<String, Object> paramMap);

	void deleteActiveInfoList(Map<String, Object> paramMap);

	void updateActiveInfo(Map<String, Object> param);

	void addActiveInfo(Map<String, Object> param);

	List<Map<String, Object>> queryActiveUserInfo(Map<String, Object> paramMap);

	Integer queryActiveUserInfoTotals(Map<String, Object> paramMap);

	void changeUserSubRole(Map<String, Object> paramMap);

	void vipFlush();

	void refleshActorActivitie(Integer oaId);

	void refleshChestExpired();

	List<Map<String, Object>> selectIsReplyUserInfo(Map<String, Object> paramMap);

	List<OscarActiveVO> selectExpiredActivitie();

	void deleteProjectLogInfoByOaId( Integer oaId );

	List<OscarActiveVO> queryOscarActiveInfoList(
			Map<String, Object> paramMap);

	Integer queryOscarActiveInfoListTotals(Map<String, Object> paramMap);

	void insertOscarActiveInfo(Map<String, Object> paramMap);

	Map<String, Object> queryOscarActiveDetail(Map<String, Object> paramMap);

	void updateOscarActiveInfo(Map<String, Object> paramMap);

	List<Map<String, Object>> queryOscarActiveActorInfoList(
			Map<String, Object> paramMap);

	Integer queryOscarActiveActorInfoListTotals(Map<String, Object> paramMap);
	
	List<Map<String, Object>> queryActiveActor(Map<String, Object> paramMap);

	void insertOscarActiveActorInfo(Map<String, Object> paramMap);

	Map<String, Object> queryOscarActiveActorDetail(Map<String, Object> paramMap);

	void updateOscarActiveActorInfo(Map<String, Object> paramMap);

	List<Map<String, Object>> queryOscarActiveVoteInfoList(
			Map<String, Object> paramMap);

	Integer queryOscarActiveVoteInfoListTotals(Map<String, Object> paramMap);

	Map<String, Object> queryOscarActiveVoteDetail(Map<String, Object> paramMap);

	void updateOscarActiveVoteInfo(Map<String, Object> paramMap);

	void insertOscarActiveVoteInfo(Map<String, Object> paramMap);

	void deletedOscarActiveVoteInfoList(Map<String, Object> paramMap);

	void updateActiveVoteOrderIndex(Map<String, Object> paramMap);

	void updateActiveActorOrderIndex(Map<String, Object> paramMap);

	List<String> selectActiveVoteType();

	List<Map<String, Object>> selectExpireVipAccount();

	void insertExpireVipAccountInfo(Map<String, Object> expireVipAccountInfo);

	List<String> selectInWeekExpiredVipAccountInfoList(String nowDt);

	void insertInWeekExpiredVipAccountInfo(String account);

	void truncateVipWeekDaysLog();

	void updateManager(Map<String, Object> paramMap);

	List<UserBehaviorVO> queryUserBehaviors(String account);
	
	UserInfoVO selectUserDetailInfo(Map<String, Object> paramMap);
	
	List<UserJPointLogVO> queryUserJpointLogInfoList(
	            Map<String, Object> paramMap);
	
    Integer queryUserWalletChangeInfoListTotals(Map<String, Object> paramMap);

	UserJPointLogVO selectUserRechargeRecord(Map<String, Object> paramMap);

	List<UserBehaviorVO> selectUserBehaviorsCount(String account);
	
	List<NewUserVO> selectNewUserCountInfoList(Map<String, Object> paramMap);

	Integer selectNewUserCountInfoListTotals(Map<String, Object> paramMap);

	Integer selectUserTotalCount(String writeDate);

	Integer selectUserVipTotalCount(String writeDate);

	List<UserReportVO> queryUserReportInfoList(Map<String, Object> paramMap);

	void updateVipStateAndOutDate(String account, String vipOutDate);

	void insertVipRechargeLog(VipRechargeLogVO vipRechargeLogVO);

	List<RedPacketRangeCfgVO> selectRedPacketGroupCreatorAccount();

	List<OscarActiveBookVO> queryOscarActiveBookInfoList(
			Map<String, Object> paramMap);

	Integer queryOscarActiveBookInfoListTotal(Map<String, Object> paramMap);

	void insertOscarActiveBookInfo(Map<String, Object> paramMap);

	Map<String, Object> queryOscarActiveBookDetail(Map<String, Object> paramMap);

	void updateOscarActiveBookInfo(Map<String, Object> paramMap);

	void updateActiveBookOrderIndex(Map<String, Object> paramMap);

	Integer selectIsActiveExist();

	void updateIsExpired(Map<String, Object> paramMap);

	void updateVoteTypeState(String vt );

	void updateRewardMount();

	void selectOne();

	List<UserInfoVO> selectRandRealUser(int size);

	void updateUserToken(String account, String token);

	List<String> selectExistsExpireVipAccount();

	ThirdUserInfoVO selectThirdUserInfo(Integer adminId);

	void insertThirdUserInfo(Map<String, Object> paraMap);

	void delThirdUserInfo(Integer aId);
	

}
