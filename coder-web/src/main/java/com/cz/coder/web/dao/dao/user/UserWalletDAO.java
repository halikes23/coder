package com.fq.dao.dao.user;

import java.util.List;
import java.util.Map;

import com.fq.entity.po.pingpp.AlipayBatchTransferOrderPO;
import com.fq.entity.vo.pingpp.AlipayBatchTransferOrderVO;
import com.fq.entity.vo.wallet.IoBatchTransferRecipientVO;
import com.fq.entity.vo.wallet.RedPacketRangeCfgDtlVO;
import com.fq.entity.vo.wallet.RedPacketRangeCfgVO;
import com.fq.entity.vo.wallet.UserRedPacketInviteRelVO;
import com.fq.entity.vo.wallet.UserRedPacketVO;
import com.fq.entity.vo.wallet.UserWalletChangeVO;
import com.fq.entity.vo.wallet.UserWalletVO;
import com.fq.entity.vo.wallet.UserWithdrawAppVO;
import com.fq.entity.vo.wallet.UserWithdrawBatchVO;
import com.fq.entity.vo.wallet.UserWithdrawChannelHistoryVO;
import com.fq.entity.vo.wallet.UserWithdrawChannelVO;

public interface UserWalletDAO {

	List<UserWalletChangeVO> queryUserWalletChangeInfoList(
			Map<String, Object> paramMap);

	Integer queryUserWalletChangeInfoListTotals(Map<String, Object> paramMap);


	List<UserWithdrawAppVO> queryUserWithdrawApplyInfoList(
			Map<String, Object> paramMap);

	Integer queryUserWithdrawApplyInfoListTotals(Map<String, Object> paramMap);
	
	List<UserWithdrawBatchVO> queryUserWithdrawBatchInfoList(Map<String, Object> paramMap);

	Integer queryUserWithdrawBatchInfoListTotals(Map<String, Object> paramMap);

	Integer queryUncheckedWithdrawAppCountByBatchNo(String batchNo);

	List<UserWithdrawAppVO> queryWithdrawBatchUserInfoList(
			Map<String, Object> paramMap);

	Integer queryWithdrawBatchUserInfoListTotals(Map<String, Object> paramMap);

	List<Map<String, Object>> queryWithdrawUserRedPacketInfoList(
			Map<String, Object> paramMap);

	Integer queryWithdrawUserRedPacketInfoListTotals(
			Map<String, Object> paramMap);
	

	List<UserWithdrawAppVO> queryUncheckedWithdrawAppByBatchNo(Map<String, Object> params);

	List<UserRedPacketVO> queryRedPackets4Chk(Map<String, Object> params);

	List<UserRedPacketInviteRelVO> queryRedPacketInviteRel4Chk(Map<String, Object> params);

	Integer queryUntransferWxPubWithdrawAppCountByBatchNo(String batchNo);

	List<UserWithdrawChannelVO> queryUserWithdrawChannelInfoList(
			Map<String, Object> paramMap);

	Integer queryUserWithdrawChannelInfoListTotals(Map<String, Object> paramMap);

	List<UserWithdrawChannelHistoryVO> queryUserWithdrawChannelHistoryInfoList(
			Map<String, Object> paramMap);

	Integer queryUserWithdrawChannelHistoryInfoListTotals(
			Map<String, Object> paramMap);

	void updateWithdrawAppTradeState(UserWithdrawAppVO app);

	UserWithdrawBatchVO queryWithdrawbatchByBatchNo(String batchNo);

	void updateWithdrawBatchState(UserWithdrawBatchVO withdrawBatch);

	UserWithdrawBatchVO queryWithdrawBatchResult(String batchNo);
	
	 List<UserWalletVO> queryUserWalletInfoList(Map<String, Object> paramMap);
	    
    Integer queryUserWalletInfoListTotals(Map<String, Object> paramMap);
    
    List<UserRedPacketVO> queryUserRedPacketInfoList(
            Map<String, Object> paramMap);
    
    Integer queryUserRedPacketInfoListTotals(Map<String, Object> paramMap);
    
    List<UserRedPacketInviteRelVO> queryRedPacketInviteUserRelByUreId(
            Map<String, Object> paramMap);
    
    Integer queryRedPacketInviteUserRelByUreIdTotals(
            Map<String, Object> paramMap);

	void updateCheckSummary(String batchNo);

	void updateWithdrawAppState(UserWithdrawAppVO app);

	void updateWithdrawAppChkState2OriginalByBatchNo(UserWithdrawAppVO app);

	void updateWithdrawAppChkFailedByAmtLimit(String batchNo, int i);

	void updateUncheckedWithdrawAppChkStateSuccess(String batchNo);

	List<UserWithdrawAppVO> queryUntransferWxPubWithdrawAppByBatchNo(Map<String, Object> params);

	void deleteIoBatchTransferRecipientByBatchNo(String batchNo);

	void createIoBatchTransferRecipient(String batchNo);
	Integer queryIoBatchTransferRecipientCount(String batchNo);

	List<IoBatchTransferRecipientVO> queryIoBatchTransferRecipientPage(Map<String, Object> params);

	void updateTradeStateByChannelInfo(UserWithdrawAppVO app);

	void updateIoBatchTransferRecipient(IoBatchTransferRecipientVO app);

	List<IoBatchTransferRecipientVO> queryWithdrawBatchTransferRecipientInfoList(
			Map<String, Object> paramMap);
	
	Integer queryWithdrawBatchTransferRecipientInfoListTotals(
			Map<String, Object> paramMap);
	
	Map<String, Object> queryWithdrawBatchNoInfo(Map<String, Object> paramMap);
	
	void updateWithdrawBatchNoInfo(Map<String, Object> paramMap);

	void addWithdrawBatchNoInfo(Map<String, Object> paramMap);

	void refleshUserRedPacketUsedStateToNoUse();

	UserWithdrawBatchVO queryWithDrawBatchByState(String inUse);

	void insertAlipayBatchTransferOrder(AlipayBatchTransferOrderPO order);

	void updateUserRedPacketUsedState(String nowState, String nextState);

	UserWithdrawAppVO queryUserWithdrawAppByUwaId(Integer uwaId);
	
	List<RedPacketRangeCfgDtlVO> selectRedPacketRangeConfigureDetailInfoList(
			Map<String, Object> paramMap);

	Integer selectRedPacketRangeConfigureDetailInfoListTotals(
			Map<String, Object> paramMap);

	void deleteRedPacketRangeConfigureDetailInfo(Map<String, Object> paramMap);

	void insertRedPacketRangeConfigureDetailInfo(Map<String, Object> paramMap);

	List<RedPacketRangeCfgVO> selectRedPacketRangeConfigureInfoList(
			Map<String, Object> paramMap);

	Integer selectRedPacketRangeConfigureInfoListTotals(
			Map<String, Object> paramMap);

	void updatePercent(Map<String, Object> paramMap);

	List<Map<String, Object>> selectRprIdInfoList();
	
	void insertRedPacketRangeConfigureInfo(Map<String, Object> paramMap);

	void deleteRedPacketRangeConfigureInfo(Map<String, Object> paramMap);

	void updateCheckFailedWithdrawApp2Fail(String batchNo);

	void updateCheckFailedWithdrawAppFrozen2Zero(String batchNo);
	
	List<AlipayBatchTransferOrderVO> selectAlipayBatchTransferOrderInfoInfoList(
            Map<String, Object> paramMap);
	
    Integer selectAlipayBatchTransferOrderInfoInfoListTotals(
            Map<String, Object> paramMap);
    
    List<UserRedPacketVO> selectRedPacketLuckyUserInfoList(
            String startDate , String endDate);
    
    void deleteRedPacketLucky();
    
    void insertUserRedPacketLucky(UserRedPacketVO userRedPacket);

	void updateWithdrawBatchStateToUsing(String batchNo);

	List<UserWithdrawBatchVO> selectWithdrawBatchByNotUse(String notUse, String batchNo);

	RedPacketRangeCfgVO selectTotalCnt(String rprId);

	void updateRedPacketBatchNo2Null4Fail(String batchNo);

	UserWalletVO queryUserWalletByAccount(String account);

	void updateUserWalletAmt(UserWalletVO wallet);
	
	void updateRedPacketGroupToRedFace(Map<String, Object> paramMap);

	void updateRedPacketGroupToBlackFace(Map<String, Object> paramMap);

	void updateRedPacketGroupToDefault( Map<String , Object > paraMap );

	void updateWithdrawBatchNoState(Map<String, Object> paramMap);

	UserWithdrawBatchVO queryPreWithDrawBatch(String usingWithdrawBatchStartDate);

	void refleshUserWithdrawApplyTradeState(String applying,
			String widthdrawing, String batchNo);

	UserWithdrawBatchVO selelctNextWithdrawBatch(String now , String notUse);

	List<UserWithdrawBatchVO> selectBatchByNotUse(String notUse);

	UserWithdrawBatchVO queryWithDrawBatchByStateNotUse(String notUse);

	UserWithdrawBatchVO selectLastInsertBatchNo();

	UserWithdrawBatchVO selectBatchNoTime(String batchNo);

	UserWithdrawBatchVO selectNextBatchInfo(String batchNo);

	void updateNextBatchNoStartDt(String withdrawEndDt, String withdrawEndTm , String batchNo);
	
}
