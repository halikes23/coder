package com.fq.dao.impl.user;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fq.dao.BaseDAO;
import com.fq.dao.dao.user.UserDAO;
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
import com.fq.util.DateFormatUtil;

@Repository
public class UserDaoImpl extends BaseDAO implements UserDAO{

	@Override
	public Integer queryTotalCount(Map<String, Object> param) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectTotalCount", param);
	}

	@Override
	public Integer queryNewUserCount(Map<String, Object> param) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectNewUserCount", param);
	}

	@Override
	public List<UserInfoVO> selectUserInfoForPage(Map<String, Object> param) {
		return (List<UserInfoVO> ) getSqlMapClientTemplate().queryForList("UserDaoImpl.selectUserInfoForPage", param);
	}

	@Override
	public Integer selectUserInfoCount(Map<String, Object> param) {
		return (Integer)getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectUserInfoCount", param);
	}

	@Override
	public Integer updateUserRole(UserInfoPO user) {
		return getSqlMapClientTemplate().update("UserDaoImpl.updateUserRole",user) ;
	}

	@Override
	public List<Map<String , Object>> selectUserInfoList(Map<String, Object> param) {
		return (List<Map<String , Object>> ) getSqlMapClientTemplate().queryForList("UserDaoImpl.selectUserInfoList", param);
	}

	@Override
	public List<UserPhotoVO> selectUserPhotoesByAccount(String account) {
		return this.getSqlMapClientTemplate().queryForList("UserDaoImpl.selectUserPhotoesByAccount", account);
	}

	@Override
	public int deleteUserPhotoes(String[] upIds) {
		return this.getSqlMapClientTemplate().update("UserDaoImpl.deleteUserPhotoes", Arrays.asList(upIds));
	}

	@Override
	public void insertUserPhoto(AddUserPhotoForm form) {
		this.getSqlMapClientTemplate().insert("UserDaoImpl.insertUserPhoto", form);
	}

	@Override
	public void updateUserJpoint(RewardUserInfoVO rewardUserInfoVO) {
		this.getSqlMapClientTemplate().update("UserDaoImpl.updateUserJpoint", rewardUserInfoVO);
	}

	@Override
	public void insertNewRecord(TradeAppInfoPO tradeAppInfoPO) {
		getSqlMapClientTemplate().insert("UserDaoImpl.insertNewRecord", tradeAppInfoPO);
	}

	@Override
	public List<Map<String, Object>> queryTesterList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.queryTesterList", paramMap );
	}

	@Override
	public Integer queryTesterTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject( "UserDaoImpl.queryTesterTotals" ,  paramMap );
	}

	@Override
	public void updateTester(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("UserDaoImpl.updateTester", paramMap ) ;
	}
	
	@Override
	public void insertOperateLog(OperateLog logger) {
		getSqlMapClientTemplate().insert("UserDaoImpl.insertOperateLog", logger);
	}

	@Override
	public List<WaterManCommentVO> queryWaterMansWork(Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.selectWaterMansWork", paramMap);
	}

	@Override
	public Integer queryWaterMansWorkTotal(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectWaterMansWorkTotal", paramMap);
	}

	@Override
	public boolean isExist(Map<String, Object> paramMap) {
		Integer num = (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.queryAccountIsExist", paramMap);
		return num>0?true:false;
	}
	
	@Override
	public void addNewUser(AddNewUserVO user) {
		getSqlMapClientTemplate().update("UserDaoImpl.addNewUser", user);
	}

	@Override
	public List<Map<String, Object>> queryUserFeedBackInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.queryUserFeedBackInfoList", paramMap);
	}

	@Override
	public Integer queryUserFeedBackInfoTotal(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.queryUserFeedBackInfoTotal", paramMap);
	}
	/**
	 * 查询用户手机信息
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryUserMobileInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.queryUserMobileInfoList", paramMap);
	}
	/**
	 * 查询手机用户的总数量
	 */
	@Override
	public Integer queryUserMobileInfoListTotal(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.queryUserMobileInfoListTotal", paramMap);
	}

	@Override
	public void updateNavy(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("UserDaoImpl.updateNavy", paramMap ) ;
		
	}

	@Override
	public List<Map<String, Object>> queryNavyList(Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.queryNavyList", paramMap );
	}

	@Override
	public Integer queryNavyTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject( "UserDaoImpl.queryNavyTotals" ,  paramMap );
	}

	@Override
	public List<Map<String, Object>> queryUserFeedBackAndNotification(
			String account) {
		List<Map<String, Object>> list ;
		try{
			list = getSqlMapClientTemplate().queryForList( "UserDaoImpl.queryUserFeedBackAndNotification" ,  account );
		}catch(Exception e){
			logger.error("",e);
			throw e ;
		}
		
		return list;
	}

	@Override
	public Map<String, Object> queryUserFeedBackByFId(Integer fId) {
		Map<String,Object> rst = (Map<String,Object>)this.getSqlMapClientTemplate().queryForObject("UserDaoImpl.queryUserFeedBackByFId",fId);
		return rst;
	}

	@Override
	public void updateUserFeedbackReplyState(Map<String, Object> feedback) {

		this.getSqlMapClientTemplate().update("UserDaoImpl.updateUserFeedbackReplyState" , feedback) ;
		
	}

	@Override
	public UserInfoVO queryUserByAccount(String account) {
		return (UserInfoVO)this.getSqlMapClientTemplate().queryForObject("UserDaoImpl.queryUserByAccount" , account);
	}

	@Override
	public void updateUserJPoint(UserInfoPO user) {
		this.getSqlMapClientTemplate().update("UserDaoImpl.updateUserJPoint",user) ;
		
	}

	@Override
	public List<Map<String, Object>> queryQuestionnaireInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.queryQuestionnaireInfoList",paramMap);
	}

	@Override
	public Integer queryQuestionnaireInfoListTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.queryQuestionnaireInfoListTotals", paramMap);
	}
	
	public void deleteQuestionnaireInfoList(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().delete("UserDaoImpl.deleteQuestionnaireInfoList", paramMap) ;
	}
	
	@Override
	public void insertQuestionnaireInfoList(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("UserDaoImpl.insertQuestionnaireInfoList", paramMap);
	}
	
	public Map<String, Object> queryQuestionnaireinfo(
			Map<String, Object> paramMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectQuestionnaireInfo", paramMap );
	}
	
	public void updateQuestionnaireInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateQuestionnaireInfo" , paramMap ) ;
	}
	
	@Override
	public List<Map<String, Object>> querySubjectInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.querySubjectInfoList",paramMap);
	}
	
	@Override
	public Integer querySubjectInfoListTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.querySubjectInfoListTotals", paramMap);
	}
	
	@Override
	public List<Map<String, Object>> queryVoteInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.queryVoteInfoList",paramMap);
	}

	@Override
	public Integer queryVoteInfoListTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.queryVoteInfoListTotals", paramMap);
	}
	
	@Override
	public void insertVoteInfoList(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("UserDaoImpl.insertVoteInfoList", paramMap);
	}
	
	public Map<String, Object> queryVoteInfo(
			Map<String, Object> paramMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectVoteInfo", paramMap );
	}
	
	public void updateVoteInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateVoteInfo" , paramMap ) ;
	}
	

	public void deleteVoteInfoList(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().delete("UserDaoImpl.deleteVoteInfoList", paramMap) ;
	}
	
	@Override
	public void insertSubjectInfoList(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("UserDaoImpl.insertSubjectInfoList", paramMap);
	}
	
	public void deleteSubjectInfoList(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().delete("UserDaoImpl.deleteSubjectInfoList", paramMap) ;
	}
	
	public Map<String, Object> querySubjectInfo(
			Map<String, Object> paramMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectSubjectInfo", paramMap );
	}
	
	public void updateSubjectInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateSubjectInfo" , paramMap ) ;
	}
	
	public void updateVoteSubjectInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateVoteSubjectInfo" , paramMap ) ;
	}
	
	@Override
	public List<Map<String, Object>> querySubject(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.querySubject",paramMap);
	}
	
	@Override
	public List<Map<String, Object>> querySubjectOptionInfo(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.querySubjectOptionInfo",paramMap);
	}
	
	@Override
	public Integer querySubjectOptionTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.querySubjectOptionTotals", paramMap);
	}
	
	@Override
	public List<Map<String, Object>> querySubjectOptionList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.querySubjectOptionList",paramMap);
	}
	
	public void upSubjectOption(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert( "UserDaoImpl.upSubjectOption" , paramMap ) ;
	}
	
	public void deleteSubjectOption(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().delete("UserDaoImpl.deleteSubjectOption", paramMap) ;
	}
	
	public Map<String, Object> subjectOptionDetail(
			Map<String, Object> paramMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("UserDaoImpl.subjectOptionDetail", paramMap );
	}
	
	public void updateSubjectOptionInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateSubjectOptionInfo" , paramMap ) ;
	}
	
	public void updateQuestionNum(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateQuestionNum" , paramMap ) ;
	}
	
	public void updateVoteNum(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateVoteNum" , paramMap ) ;
	}
	
	@Override
	public void insertBatchNewUser(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("UserDaoImpl.insertBatchNewUser", paramMap);
	}
	
	public void updateGag(Map<String , Object> paramMap){
		getSqlMapClientTemplate().update("UserDaoImpl.updateGag",paramMap );
	}
	
	public Map<String, Object> queryUserInfoList(Map<String, Object> paraMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectUserInfo",paraMap);
	}
	
	public void updateUserInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateUserInfo" , paramMap ) ;
	}

	@Override
	public List<Map<String, Object>> queryActiveAwardInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.queryActiveAwardInfoList" ,paramMap);
	}

	@Override
	public Integer queryActiveAwardInfoListTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.queryActiveAwardInfoListTotals", paramMap);
	}
	
	@Override
	public List<Map<String, Object>> queryActiveInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.queryActiveInfoList" ,paramMap);
	}

	@Override
	public Integer queryActiveInfoListTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.queryActiveInfoListTotals", paramMap);
	}
	
	@Override
	public Map<String, Object> queryActiveInfo(
			Map<String, Object> paramMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("UserDaoImpl.queryActiveInfo", paramMap );
	}
	
	public void deleteActiveInfoList(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().delete("UserDaoImpl.deleteActiveInfoList", paramMap) ;
	}
	
	public void updateActiveInfo(Map<String, Object> param) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateActiveInfo" , param ) ;
	}
	
	@Override
	public void addActiveInfo(Map<String, Object> param) {
		getSqlMapClientTemplate().insert("UserDaoImpl.addActiveInfo", param);
	}
	
	@Override
	public List<Map<String, Object>> queryActiveUserInfo(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.queryActiveUserInfo" ,paramMap);
	}

	@Override
	public Integer queryActiveUserInfoTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.queryActiveUserInfoTotals", paramMap);
	}
	
	public void changeUserSubRole(Map<String, Object> param) {
		getSqlMapClientTemplate().update( "UserDaoImpl.changeUserSubRole" , param ) ;
	}

	@Override
	public void vipFlush() {
		String now = DateFormatUtil.CREATE_FULL_DATE_FORMATIN_STR() ; 
		getSqlMapClientTemplate().update("UserDaoImpl.vipFlush" , now ) ;
	}
	
	@Override
	public void refleshActorActivitie(Integer oaId) {
		getSqlMapClientTemplate().update("UserDaoImpl.updateActorActivitie" , oaId ) ;
	}
	
	@Override
	public void refleshChestExpired() {
		String now = DateFormatUtil.CREATE_FULL_DATE_FORMATIN_STR() ; 
		getSqlMapClientTemplate().update("UserDaoImpl.updateChestExpired" , now ) ;
	}
	
	@Override
	public List<Map<String, Object>> selectIsReplyUserInfo(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.selectIsReplyUserInfo" ,paramMap);
	}
	
	@Override
	public List<OscarActiveVO>  selectExpiredActivitie() {
		String now = DateFormatUtil.CREATE_FULL_DATE_FORMATIN_STR() ; 
		return (List<OscarActiveVO>)	getSqlMapClientTemplate().queryForList("UserDaoImpl.selectExpiredActivitie" , now ) ;
	}
	
	public void deleteProjectLogInfoByOaId(Integer oaId) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateProjectLogInfoByOaId" , oaId) ;
	}
	
	@Override
	public List<OscarActiveVO> queryOscarActiveInfoList(
			Map<String, Object> paramMap) {
		return (List<OscarActiveVO>) getSqlMapClientTemplate().queryForList("UserDaoImpl.selectOscarActiveInfo" ,paramMap);
	}

	@Override
	public Integer queryOscarActiveInfoListTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectOscarActiveInfoTotals", paramMap);
	}
	
	public void insertOscarActiveInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert( "UserDaoImpl.insertOscarActiveInfo" , paramMap ) ;
	}
	
	@Override
	public Map<String, Object> queryOscarActiveDetail(
			Map<String, Object> paramMap) {
		return (Map<String , Object>) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectOscarActiveDetail" ,paramMap);
	}
	
	public void updateOscarActiveInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateOscarActiveInfo" , paramMap ) ;
	}
	
	@Override
	public List<Map<String, Object>> queryOscarActiveActorInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.selectOscarActiveActorInfo" ,paramMap);
	}

	@Override
	public Integer queryOscarActiveActorInfoListTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectOscarActiveActorInfoTotals", paramMap);
	}
	
	public void insertOscarActiveActorInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert( "UserDaoImpl.insertOscarActiveActorInfo" , paramMap ) ;
	}
	
	@Override
	public List<Map<String, Object>> queryActiveActor(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.selectActiveActor" ,paramMap);
	}
	
	@Override
	public Map<String, Object> queryOscarActiveActorDetail(
			Map<String, Object> paramMap) {
		return (Map<String , Object>) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectOscarActiveActorDetail" ,paramMap);
	}

	public void updateOscarActiveActorInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateOscarActiveActorInfo" , paramMap ) ;
	}
	
	@Override
	public List<Map<String, Object>> queryOscarActiveVoteInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.selectOscarActiveVoteInfo" ,paramMap);
	}

	@Override
	public Integer queryOscarActiveVoteInfoListTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectOscarActiveVoteInfoTotals", paramMap);
	}
	
	@Override
	public Map<String, Object> queryOscarActiveVoteDetail(
			Map<String, Object> paramMap) {
		return (Map<String , Object>) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectOscarActiveVoteDetail" ,paramMap);
	}
	
	public void updateOscarActiveVoteInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateOscarActiveVoteInfo" , paramMap ) ;
	}
	
	public void insertOscarActiveVoteInfo(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert( "UserDaoImpl.insertOscarActiveVoteInfo" , paramMap ) ;
	}
	
	public void deletedOscarActiveVoteInfoList(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().delete( "UserDaoImpl.deletedOscarActiveVoteInfoList" , paramMap ) ;
	}
	
	public void updateActiveVoteOrderIndex(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateActiveVoteOrderIndex" , paramMap ) ;
	}
	
	public void updateActiveActorOrderIndex(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update( "UserDaoImpl.updateActiveActorOrderIndex" , paramMap ) ;
	}
	
	@Override
	public List<String>  selectActiveVoteType() {
		return (List<String>) getSqlMapClientTemplate().queryForList("UserDaoImpl.selectActiveVoteType");
		
	}
	
	@Override
	public List<Map<String, Object>>  selectExpireVipAccount() {
		String now = DateFormatUtil.CREATE_FULL_DATE_FORMATIN_STR();
		return (List<Map<String, Object>>) getSqlMapClientTemplate().queryForList("UserDaoImpl.selectExpireVipAccount",now);
	}
	
	public void insertExpireVipAccountInfo(Map<String, Object> expireVipAccountInfo) {
		getSqlMapClientTemplate().insert( "UserDaoImpl.insertExpireVipAccountInfo" , expireVipAccountInfo ) ;
	}

	@Override
	public List<String> selectInWeekExpiredVipAccountInfoList(String nowDt) {
		return (List<String>) getSqlMapClientTemplate().queryForList("UserDaoImpl.selectInWeekExpiredVipAccountInfoList" , nowDt);
	}
	
	public void insertInWeekExpiredVipAccountInfo(String account) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String nowDt = DateFormatUtil.CREATE_FULL_DATE_FORMATIN_STR();
		paramMap.put("nowDt", nowDt);
		paramMap.put("account", account);
		getSqlMapClientTemplate().insert( "UserDaoImpl.insertInWeekExpiredVipAccountInfo" , paramMap ) ;
	}

	@Override
	public void truncateVipWeekDaysLog() {
		getSqlMapClientTemplate().delete("UserDaoImpl.truncateVipWeekDaysLog");
	}

	@Override
	public void updateManager(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("UserDaoImpl.updateManager",paramMap);
	}

	@Override
	public List<UserBehaviorVO> queryUserBehaviors(String account) {
		return this.getSqlMapClientTemplate().queryForList("UserDaoImpl.queryUserBehaviors",account);
	}
	
	@Override
    public UserInfoVO selectUserDetailInfo(Map<String, Object> paramMap) {
        return (UserInfoVO) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectUserDetailInfo" , paramMap);
    }
 
    @Override
    public List<UserJPointLogVO> queryUserJpointLogInfoList(
            Map<String, Object> paramMap) {
        return (List<UserJPointLogVO>) getSqlMapClientTemplate().queryForList("UserDaoImpl.selectUserJpointLogInfoList" , paramMap);
    }
    
    @Override
    public Integer queryUserWalletChangeInfoListTotals(
            Map<String, Object> paramMap) {
        return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectUserJpointLogInfoListTotals",paramMap); 
    }
    
    @Override
    public UserJPointLogVO selectUserRechargeRecord(Map<String, Object> paramMap) {
        return (UserJPointLogVO) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectUserRechargeRecord" , paramMap);
    }
    
    @Override
	public List<UserBehaviorVO> selectUserBehaviorsCount(String account) {
		return this.getSqlMapClientTemplate().queryForList("UserDaoImpl.selectUserBehaviorsCount",account);
	}
    
    @Override
    public List<NewUserVO> selectNewUserCountInfoList(
            Map<String, Object> paramMap) {
        return (List<NewUserVO>) getSqlMapClientTemplate().queryForList("UserDaoImpl.selectNewUserCountInfoList" , paramMap);
    }
    
    @Override
    public Integer selectNewUserCountInfoListTotals(
            Map<String, Object> paramMap) {
        return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectNewUserCountInfoListTotals",paramMap); 
    }
    
    @Override
	public Integer selectUserTotalCount(
			String writeDate) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectUserTotalCount", writeDate );
	}
    
    @Override
   	public Integer selectUserVipTotalCount(
   			String writeDate) {
   		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectUserVipTotalCount", writeDate );
   	}
    
    @Override
    public List<UserReportVO> queryUserReportInfoList(
            Map<String, Object> paramMap) {
        return (List<UserReportVO>) getSqlMapClientTemplate().queryForList("UserDaoImpl.queryUserReportInfoList" , paramMap);
    }

	@Override
	public void updateVipStateAndOutDate(String account, String vipOutDate) {
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("account", account);
		paraMap.put("vipOutDate", vipOutDate);
		this.getSqlMapClientTemplate().update("UserDaoImpl.updateVipStateAndOutDate" ,paraMap);
	}

	@Override
	public void insertVipRechargeLog(VipRechargeLogVO vipRechargeLogVO) {
		this.getSqlMapClientTemplate().insert("UserDaoImpl.insertVipRechargeLog",vipRechargeLogVO);
	}
	
	@Override
    public List<RedPacketRangeCfgVO> selectRedPacketGroupCreatorAccount() {
        return (List<RedPacketRangeCfgVO>) getSqlMapClientTemplate().queryForList("UserDaoImpl.selectRedPacketGroupCreatorAccount" );
    }
	
	@Override
	public List<OscarActiveBookVO> queryOscarActiveBookInfoList(
			Map<String, Object> paramMap) {
		return (List<OscarActiveBookVO>) getSqlMapClientTemplate().queryForList("UserDaoImpl.selectOscarActiveBookInfoList" ,paramMap);
	}

	@Override
	public Integer queryOscarActiveBookInfoListTotal(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectOscarActiveBookInfoListTotal", paramMap);
	}
	
	@Override
	public void insertOscarActiveBookInfo(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().insert("UserDaoImpl.insertOscarActiveBookInfo",paramMap);
	}
	
	@Override
	public Map<String, Object> queryOscarActiveBookDetail(
			Map<String, Object> paramMap) {
		return (Map<String , Object>) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectOscarActiveBookDetail" ,paramMap);
	}
	
	@Override
	public void updateOscarActiveBookInfo(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().update("UserDaoImpl.updateOscarActiveBookInfo",paramMap);
	}
	
	@Override
	public void updateActiveBookOrderIndex(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().update("UserDaoImpl.updateActiveBookOrderIndex",paramMap);
	}
	
	@Override
	public Integer selectIsActiveExist() {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectIsActiveExist");
	}
	
	@Override
	public void updateIsExpired(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().update("UserDaoImpl.updateIsExpired",paramMap);
	}
	
	@Override
	public void updateVoteTypeState(String vt) {
		this.getSqlMapClientTemplate().update("UserDaoImpl.updateVoteTypeState",vt);
	}
	
	@Override
	public void updateRewardMount() {
		this.getSqlMapClientTemplate().update("UserDaoImpl.updateRewardMount");
	}
	
	@Override
	public void selectOne(){
		this.getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectOne");
	}

	@Override
	public List<UserInfoVO> selectRandRealUser(int count) {
		return (List<UserInfoVO>)this.getSqlMapClientTemplate().queryForList("UserDaoImpl.selectRandRealUser",count)  ;
	}

	@Override
	public void updateUserToken(String account, String token) {
		Map<String,Object> user = new HashMap<String,Object>() ;
		user.put("account", account) ;
		user.put("token", token) ;
		this.getSqlMapClientTemplate().update("UserDaoImpl.updateUserToken" , user) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectExistsExpireVipAccount() {
		return getSqlMapClientTemplate().queryForList("UserDaoImpl.selectExistsExpireVipAccount");
	}

	@Override
	public ThirdUserInfoVO selectThirdUserInfo(Integer adminId) {
		return (ThirdUserInfoVO) getSqlMapClientTemplate().queryForObject("UserDaoImpl.selectThirdUserInfo" , adminId);
	}

	@Override
	public void insertThirdUserInfo(Map<String, Object> paraMap) {
		this.getSqlMapClientTemplate().insert("UserDaoImpl.insertThirdUserInfo" , paraMap);
	}

	@Override
	public void delThirdUserInfo(Integer aId) {
		this.getSqlMapClientTemplate().delete("UserDaoImpl.delThirdUserInfo" , aId);
	}
	
}
