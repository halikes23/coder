package com.fq.dao.dao.user;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fq.dao.entity.po.user.ClientInfoPO;
import com.fq.dao.entity.po.user.CopyUserPO;
import com.fq.dao.entity.po.user.UserInfoPO;
import com.fq.dao.entity.po.user.UserJPointLogPO;
import com.fq.dao.entity.vo.user.CopyUserNickVO;
import com.fq.dao.entity.vo.user.UserInfoVO;


public interface UserBehaviorDAO {

	void batchAddNewUser(UserInfoPO user);

	void addUserClientInfo(ClientInfoPO infoPO);

	void insertIntoUserJpointLog(UserJPointLogPO userJpointLogPO);

	List<UserInfoVO> queryUserInfoByTimes(String date);

	List<UserInfoVO> queryNpcList();

	List<UserInfoVO> queryUserList();

	void batchAddCopyUserPO(List<CopyUserPO> copyUserPOs);

	void copyMoviePlayRecord(Map<String, String> paramMap);

	void copyMovieCollectionRecord(Map<String, String> paramMap);

	void copyShareMovieRecord(Map<String, String> paramMap);

	void copyChaseProjectRecord(Map<String, String> paramMap);

	void copyCartoonPlayRecord(Map<String, String> paramMap);

	void copyShareCartoonRecord(Map<String, String> paramMap);

	void copyChaseCartoonRecord(Map<String, String> paramMap);

	void copyPariseLogRecord(Map<String, String> paramMap);

	void copyPariseProjectCommentRecord(Map<String, String> paramMap);

	List<CopyUserPO> queryCopyUserList();

	void insertUserPlayLog();

	void insertBtUserPlayLog(String date);

	void truncateBtUserPlayLog();

	void truncateBtCollectionInfo();

	void insertBtCollectionInfo(String date);

	void insertCollectionInfo();

	void truncateBtUserShareLog();

	void insertBtUserShareLog(String date);

	void insertUserShareLog();

	void truncateBtChaseProject();

	void insertBtChaseProject(String date);

	void insertChaseProject();

	void truncateBtCartoonPlay();

	void insertBtCartoonPlay(String date);

	void insertCartoonPlay();

	void truncateBtShareCartoon();

	void insertBtShareCartoon(String date);

	void insertShareCartoon();

	void truncateBtChaseCartoon();

	void insertBtChaseCartoon(String date);

	void insertChaseCartoon();

	void truncateBtPariseLog();

	void insertBtPariseLog(String date);

	void insertPariseLog();

	void truncateBtPariseProjectComment();

	void insertBtPariseProjectComment(String date);

	void insertPariseProjectComment();

	void truncateBtJpointLog();

	void insertBtJpointLog(String date);

	void insertJpointLog();

	void truncateBtTrade();

	void insertBtTrade(String date);

	void insertTrade();

	void truncateBtHeal();

	void insertBtHeal(String date);

	void insertHeal();

	void truncateBtGift();

	void insertBtGift(String date);

	void insertGift();

	void truncateBtVipRecharge();

	void insertBtVipRecharge(String date);

	void insertVipRecharge();

	void truncateBtVipExpired();

	void insertBtVipExpired(String date);

	void insertVipExpired();

	void truncateBtUnlockCartoon();

	void insertBtUnlockCartoon(String date);

	void insertUnlockCartoon();

	void updateVipInfo();

	void updateTradeInfo(String date);

	void updateUserRewardInfo();

	void insertCopyUserNick(List<String> userNickSet);

	List<UserInfoVO> queryNpcVipList();

	List<CopyUserNickVO> queryCopyUserNickVOs(int size);

	void updateUserNickBatch(List< UserInfoVO > userInfoVOs );

	void deleteCopyUserNickById(List<CopyUserNickVO> userNickVOs);
	void updateUserNickByAccount(UserInfoVO userInfo);

	List<String> queryNpcVipAccountListByHead();

	List<String> queryNpcHeadVipList();

	void updateUserHeadUrlByAccount(String account, String headImgUrl);


}
