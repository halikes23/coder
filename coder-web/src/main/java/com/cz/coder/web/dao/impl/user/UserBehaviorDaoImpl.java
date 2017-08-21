package com.fq.dao.impl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fq.dao.BaseDAO;
import com.fq.dao.dao.user.UserBehaviorDAO;
import com.fq.dao.entity.po.user.ClientInfoPO;
import com.fq.dao.entity.po.user.CopyUserPO;
import com.fq.dao.entity.po.user.UserInfoPO;
import com.fq.dao.entity.po.user.UserJPointLogPO;
import com.fq.dao.entity.vo.user.CopyUserNickVO;
import com.fq.dao.entity.vo.user.UserInfoVO;
@Repository
public class UserBehaviorDaoImpl extends BaseDAO implements UserBehaviorDAO {

	@Override
	public void batchAddNewUser( UserInfoPO userList ) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.batchAddNewUser", userList ) ; 
	}

	@Override
	public void addUserClientInfo(ClientInfoPO infoPO) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.addUserClientInfo", infoPO ) ; 
	}

	@Override
	public void insertIntoUserJpointLog(UserJPointLogPO userJpointLogPO) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertIntoUserJpointLog", userJpointLogPO ) ; 
	}

	@Override
	public List<UserInfoVO> queryUserInfoByTimes( String date ) {
		return getSqlMapClientTemplate().queryForList("UserBehaviorDaoImpl.queryUserInfoByTimes" , date ) ;
	}

	@Override
	public void batchAddCopyUserPO(List<CopyUserPO> copyUserPOs) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.batchInsertCopyUserPO", copyUserPOs ) ; 
	}

	@Override
	public List<UserInfoVO> queryNpcList() {
		return getSqlMapClientTemplate().queryForList("UserBehaviorDaoImpl.queryNpcList" );
	}

	@Override
	public List<UserInfoVO> queryUserList() {
		return getSqlMapClientTemplate().queryForList("UserBehaviorDaoImpl.queryUserList" );
	}
/**
 * s
 */
	@Override
	public void copyMoviePlayRecord(Map<String, String> paramMap) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.copyMoviePlayRecord", paramMap ) ; 
	}

	@Override
	public void copyMovieCollectionRecord(Map<String, String> paramMap) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.copyMovieCollectionRecord", paramMap ) ; 		
	}

	@Override
	public void copyShareMovieRecord(Map<String, String> paramMap) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.copyShareMovieRecord", paramMap ) ; 		
	}

	@Override
	public void copyChaseProjectRecord(Map<String, String> paramMap) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.copyChaseProjectRecord", paramMap ) ; 		
	}

	@Override
	public void copyCartoonPlayRecord(Map<String, String> paramMap) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.copyCartoonPlayRecord", paramMap ) ; 		
	}

	@Override
	public void copyShareCartoonRecord(Map<String, String> paramMap) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.copyShareCartoonRecord", paramMap ) ; 		
	}

	@Override
	public void copyChaseCartoonRecord(Map<String, String> paramMap) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.copyChaseCartoonRecord", paramMap ) ; 		
	}

	@Override
	public void copyPariseLogRecord(Map<String, String> paramMap) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.copyPariseLogRecord", paramMap ) ; 		
	}

	@Override
	public void copyPariseProjectCommentRecord(Map<String, String> paramMap) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.copyPariseProjectCommentRecord", paramMap ) ; 		
	}

	@Override
	public List<CopyUserPO> queryCopyUserList() {
		return getSqlMapClientTemplate().queryForList("UserBehaviorDaoImpl.queryCopyUserList");
	}

	@Override
	public void insertUserPlayLog() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertUserPlayLog") ; 
	}

	@Override
	public void insertBtUserPlayLog(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtUserPlayLog", date ) ; 
	}

	@Override
	public void truncateBtUserPlayLog() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtUserPlayLog") ; 
	}

	@Override
	public void truncateBtCollectionInfo() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtCollectionInfo") ; 
	}

	@Override
	public void insertBtCollectionInfo(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtCollectionInfo", date ) ; 
		
	}

	@Override
	public void insertCollectionInfo() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertCollectionInfo" ) ; 		
	}

	@Override
	public void truncateBtUserShareLog() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtUserShareLog") ; 
	}

	@Override
	public void insertBtUserShareLog(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtUserShareLog", date ) ; 
		
	}

	@Override
	public void insertUserShareLog() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertUserShareLog" ) ; 	
		
	}

	@Override
	public void truncateBtChaseProject() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtChaseProject") ; 
	}

	@Override
	public void insertBtChaseProject(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtChaseProject", date ) ; 
		
	}

	@Override
	public void insertChaseProject() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertChaseProject" ) ; 	
		
	}

	@Override
	public void truncateBtCartoonPlay() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtCartoonPlay") ; 
	}

	@Override
	public void insertBtCartoonPlay(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtCartoonPlay", date ) ; 
	}

	@Override
	public void insertCartoonPlay() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertCartoonPlay" ) ; 	
	}

	@Override
	public void truncateBtShareCartoon() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtShareCartoon") ; 
	}

	@Override
	public void insertBtShareCartoon(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtShareCartoon", date ) ; 
	}

	@Override
	public void insertShareCartoon() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertShareCartoon" ) ; 
	}

	@Override
	public void truncateBtChaseCartoon() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtChaseCartoon") ; 
	}

	@Override
	public void insertBtChaseCartoon(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtChaseCartoon", date ) ; 
	}

	@Override
	public void insertChaseCartoon() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertChaseCartoon" ) ; 
	}

	@Override
	public void truncateBtPariseLog() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtPariseLog") ; 
	}

	@Override
	public void insertBtPariseLog(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtPariseLog", date ) ; 
	}

	@Override
	public void insertPariseLog() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertPariseLog" ) ; 
	}

	@Override
	public void truncateBtPariseProjectComment() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtPariseProjectComment") ; 		
	}

	@Override
	public void insertBtPariseProjectComment(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtPariseProjectComment", date ) ; 		
	}

	@Override
	public void insertPariseProjectComment() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertPariseProjectComment" ) ; 
	}

	@Override
	public void truncateBtJpointLog() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtJpointLog") ; 		
	}

	@Override
	public void insertBtJpointLog(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtJpointLog", date ) ; 
	}

	@Override
	public void insertJpointLog() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertJpointLog" ) ; 
	}

	@Override
	public void truncateBtTrade() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtTrade") ; 	
	}

	@Override
	public void insertBtTrade(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtTrade", date ) ; 
		
	}

	@Override
	public void insertTrade() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertTrade" ) ; 
		
	}

	@Override
	public void truncateBtHeal() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtHeal") ; 	
	}

	@Override
	public void insertBtHeal(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtHeal", date ) ; 
	}

	@Override
	public void insertHeal() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertHeal" ) ; 
	}

	@Override
	public void truncateBtGift() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtGift") ; 			
	}

	@Override
	public void insertBtGift(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtGift", date ) ; 		
	}

	@Override
	public void insertGift() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertGift" ) ; 		
	}

	@Override
	public void truncateBtVipRecharge() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtVipRecharge") ; 				
	}

	@Override
	public void insertBtVipRecharge(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtVipRecharge", date ) ; 			
	}

	@Override
	public void insertVipRecharge() {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertVipRecharge" ) ; 				
	}

	@Override
	public void truncateBtVipExpired() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtVipExpired") ; 	
	}

	@Override
	public void insertBtVipExpired(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtVipExpired", date ) ; 			
	}

	@Override
	public void insertVipExpired() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.insertVipExpired") ; 			
	}

	@Override
	public void truncateBtUnlockCartoon() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.truncateBtUnlockCartoon") ; 			
	}

	@Override
	public void insertBtUnlockCartoon(String date) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertBtUnlockCartoon", date ) ; 		
	}

	@Override
	public void insertUnlockCartoon() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.insertUnlockCartoon") ; 				
	}

	@Override
	public void updateVipInfo() {
		getSqlMapClientTemplate().update( "UserBehaviorDaoImpl.updateVipInfo" ) ; 
	}

	@Override
	public void updateTradeInfo(String date) {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.updateTradeInfo", date ) ; 
	}

	@Override
	public void updateUserRewardInfo() {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.updateUserRewardInfo") ; 
	}

	@Override
	public void insertCopyUserNick(List<String> userNickList) {
		getSqlMapClientTemplate().insert("UserBehaviorDaoImpl.insertCopyUserNick", userNickList ) ; 
	}

	@Override
	public List<UserInfoVO> queryNpcVipList() {
		return getSqlMapClientTemplate().queryForList("UserBehaviorDaoImpl.queryNpcVipList" );
	}

	@Override
	public List<CopyUserNickVO> queryCopyUserNickVOs(int size) {
		return getSqlMapClientTemplate().queryForList("UserBehaviorDaoImpl.queryCopyUserNickVOs", size ); 
	}

	@Override
	public void updateUserNickBatch(List< UserInfoVO > userInfoVOs ) {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.updateUserNickBatch", userInfoVOs ) ; 
	}

	@Override
	public void deleteCopyUserNickById(List<CopyUserNickVO> userNickVOs) {
		getSqlMapClientTemplate().delete("UserBehaviorDaoImpl.deleteCopyUserNickById" , userNickVOs ) ; 
	}

	@Override
	public void updateUserNickByAccount(UserInfoVO userInfo) {
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.updateUserNickByAccount", userInfo ) ; 
	}


	@Override
	public List<String> queryNpcHeadVipList() {
		return getSqlMapClientTemplate().queryForList("UserBehaviorDaoImpl.queryNpcHeadVipList");
	}

	@Override
	public void updateUserHeadUrlByAccount(String account, String headImgUrl) {
		Map<String , Object> paraMap = new HashMap<String, Object>() ; 
		paraMap.put("account", account) ; 
		paraMap.put("headImgUrl", headImgUrl) ; 
		getSqlMapClientTemplate().update("UserBehaviorDaoImpl.updateUserHeadUrlByAccount", paraMap ) ; 
	}

	@Override
	public List<String> queryNpcVipAccountListByHead() {
		return getSqlMapClientTemplate().queryForList("UserBehaviorDaoImpl.queryNpcVipAccountListByHead");
	}


}
