package com.fq.dao.impl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fq.common.constant.CommonConstant;
import com.fq.dao.BaseDAO;
import com.fq.dao.dao.user.UserWalletDAO;
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

@Repository
public class UserWalletDaoImpl extends BaseDAO implements  UserWalletDAO {
	
	@Override
	public List<UserWalletChangeVO> queryUserWalletChangeInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectUserWalletChangeInfoList" ,paramMap);
	}
	
	@Override
	public Integer queryUserWalletChangeInfoListTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectUserWalletChangeInfoListTotals", paramMap);
	}


	@Override
	public List<UserWithdrawAppVO> queryUserWithdrawApplyInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectUserWithdrawApplyInfoList" ,paramMap);
	}

	@Override
	public Integer queryUserWithdrawApplyInfoListTotals(
			Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectUserWithdrawApplyInfoListTotals", paramMap);
	}

	@Override
	public List<UserWithdrawBatchVO> queryUserWithdrawBatchInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectUserWithdrawBatchInfoList" ,paramMap);
	}

	@Override
	public Integer queryUserWithdrawBatchInfoListTotals(
			Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectUserWithdrawBatchInfoListTotals", paramMap);
	}

	@Override
	public Integer queryUncheckedWithdrawAppCountByBatchNo(String batchNo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.queryUncheckedWithdrawAppCountByBatchNo",batchNo);
	}

	@Override
	public List<UserWithdrawAppVO> queryWithdrawBatchUserInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectWithdrawBatchUserInfoList" ,paramMap);
	}

	@Override
	public Integer queryWithdrawBatchUserInfoListTotals(
			Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectWithdrawBatchUserInfoListTotals", paramMap);
	}

	@Override
	public List<Map<String, Object>> queryWithdrawUserRedPacketInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectWithdrawUserRedPacketInfoList" ,paramMap);
	}

	@Override
	public Integer queryWithdrawUserRedPacketInfoListTotals(
			Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectWithdrawUserRedPacketInfoListTotals", paramMap);
	}
	
	@Override
	public List<UserWithdrawAppVO> queryUncheckedWithdrawAppByBatchNo(Map<String, Object> params) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.queryUncheckedWithdrawAppByBatchNo",params);
	}
	
	@Override
	public List<UserWithdrawAppVO> queryUntransferWxPubWithdrawAppByBatchNo(Map<String, Object> params) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.queryUntransferWxPubWithdrawAppByBatchNo",params);
	}

	@Override
	public List<UserRedPacketVO> queryRedPackets4Chk(Map<String, Object> params) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.queryRedPackets4Chk",params);
	}

	@Override
	public List<UserRedPacketInviteRelVO> queryRedPacketInviteRel4Chk(Map<String, Object> params) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.queryRedPacketInviteRel4Chk",params);
	}

	@Override
	public Integer queryUntransferWxPubWithdrawAppCountByBatchNo(String batchNo) {
		
		return (Integer)getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.queryUntransferWxPubWithdrawAppCountByBatchNo",batchNo);
	}

	@Override
	public List<UserWithdrawChannelVO> queryUserWithdrawChannelInfoList(
			Map<String, Object> paramMap) {
		 return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectUserWithdrawChannnelInfolist" , paramMap);
	}

	@Override
	public Integer queryUserWithdrawChannelInfoListTotals(
			Map<String, Object> paramMap) {
		return (Integer)getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectUserWithdrawChannelInfoListTotals" , paramMap);
	}

	@Override
	public List<UserWithdrawChannelHistoryVO> queryUserWithdrawChannelHistoryInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectUserWithdrawChannelHistoryInfoList" , paramMap);
	}
	
	@Override
	public Integer queryUserWithdrawChannelHistoryInfoListTotals(
			Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectUserWithdrawChannelHistoryInfoListTotals" , paramMap);
	}

	@Override
	public void updateWithdrawAppTradeState(UserWithdrawAppVO app) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateWithdrawAppTradeState",app) ;
		
	}

	@Override
	public UserWithdrawBatchVO queryWithdrawbatchByBatchNo(String batchNo) {
		return (UserWithdrawBatchVO)this.getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.queryWithdrawbatchByBatchNo",batchNo);
	}

	@Override
	public void updateWithdrawBatchState(UserWithdrawBatchVO withdrawBatch) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateWithdrawBatchState", withdrawBatch);
	}

	@Override
	public UserWithdrawBatchVO queryWithdrawBatchResult(String batchNo) {
		return (UserWithdrawBatchVO)getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.queryWithdrawBatchResult",batchNo);
	}
	
	@Override
    public List<UserWalletVO> queryUserWalletInfoList(
            Map<String, Object> paramMap) {
        return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectUserWalletInfoList" , paramMap);
    }
    
    @Override
    public Integer queryUserWalletInfoListTotals(
            Map<String, Object> paramMap) {
        return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectUserWalletInfoListTotals" , paramMap);
    }
    @Override
    public List<UserRedPacketVO> queryUserRedPacketInfoList(
            Map<String, Object> paramMap) {
        return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectUserRedPacketInfoList" , paramMap);
    }
    @Override
    public Integer queryUserRedPacketInfoListTotals(Map<String, Object> paramMap) {
        return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectUserRedPacketInfoListTotals", paramMap);
    }
    @Override
    public List<UserRedPacketInviteRelVO> queryRedPacketInviteUserRelByUreId(
            Map<String, Object> paramMap) {
        return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectRedPacketInviteUserRelByUreId" , paramMap);
    }
    @Override
    public Integer queryRedPacketInviteUserRelByUreIdTotals(
            Map<String, Object> paramMap) {
        return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectRedPacketInviteUserRelByUreIdTotals" ,paramMap);
    }

	@Override
	public void updateCheckSummary(String batchNo) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateCheckSummary",batchNo) ;
	}

	@Override
	public void updateWithdrawAppState(UserWithdrawAppVO app) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateWithdrawAppChkState",app) ;
	}

	@Override
	public void updateWithdrawAppChkState2OriginalByBatchNo(UserWithdrawAppVO app) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateWithdrawAppChkState2OriginalByBatchNo",app) ;
	}

	@Override
	public void updateWithdrawAppChkFailedByAmtLimit(String batchNo, int amt) {
		Map<String,Object> params = new HashMap<String,Object>() ;
		params.put("batchNo", batchNo) ;
		params.put("withdrawAmt", amt) ;
		params.put("chkFailMsg", "超出提现额度限制") ;
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateWithdrawAppChkFailedByAmtLimit",params) ;
	}

	@Override
	public void updateUncheckedWithdrawAppChkStateSuccess(String batchNo) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateUncheckedWithdrawAppChkStateSuccess",batchNo) ;
	}

	@Override
	public void deleteIoBatchTransferRecipientByBatchNo(String batchNo) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.deleteIoBatchTransferRecipientByBatchNo",batchNo);
	}

	@Override
	public void createIoBatchTransferRecipient(String batchNo) {
		this.getSqlMapClientTemplate().insert("UserWalletDaoImpl.createIoBatchTransferRecipient",batchNo) ;
	}

	@Override
	public Integer queryIoBatchTransferRecipientCount(String batchNo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.queryIoBatchTransferRecipientCount",batchNo);
	}

	@Override
	public List<IoBatchTransferRecipientVO> queryIoBatchTransferRecipientPage(Map<String, Object> params) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.queryIoBatchTransferRecipientPage",params);
	}

	@Override
	public void updateTradeStateByChannelInfo(UserWithdrawAppVO app) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateTradeStateByChannelInfo",app) ;
	}

	@Override
	public void updateIoBatchTransferRecipient(IoBatchTransferRecipientVO app) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateIoBatchTransferRecipient",app);
	}
	
	@Override
	public List<IoBatchTransferRecipientVO> queryWithdrawBatchTransferRecipientInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectWithdrawBatchTransferRecipientInfoList" , paramMap);
	}

	@Override
	public Integer queryWithdrawBatchTransferRecipientInfoListTotals(
			Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectWithdrawBatchTransferRecipientInfoListTotals" , paramMap);
	}
	
	@Override
	public Map<String, Object> queryWithdrawBatchNoInfo(
			Map<String, Object> paramMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectWithdrawBatchNoInfo", paramMap );
	}
	
	@Override
	public void updateWithdrawBatchNoInfo(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateWithdrawBatchNoInfo" , paramMap);
		
	}
	
	@Override
	public void addWithdrawBatchNoInfo(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().insert("UserWalletDaoImpl.addWithdrawBatchNoInfo" , paramMap);
	}

	
	@Override
	public void insertAlipayBatchTransferOrder(AlipayBatchTransferOrderPO order) {
		this.getSqlMapClientTemplate().insert("UserWalletDaoImpl.insertAlipayBatchTransferOrder",order);
	}
	
	
	@Override
	public UserWithdrawBatchVO queryWithDrawBatchByState(String inUse) {
		return (UserWithdrawBatchVO) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectWithDrawBatchByState" , inUse) ;
	}
	
	@Override
	public void refleshUserRedPacketUsedStateToNoUse() {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateUserRedPacketUsedStateToNoUse" );
		
	}
	
	@Override
	public void updateUserRedPacketUsedState(String nowState, String nextState) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("nowState", nowState);
		paramMap.put("nextState", nextState);
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateUserRedPacketUsedState" ,paramMap );
		
	}
	
	@Override
	public void refleshUserWithdrawApplyTradeState(String applying, String widthdrawing , String batchNo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("applying", applying);
		paramMap.put("widthdrawing", widthdrawing);
		paramMap.put("batchNo", batchNo);
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateUserWithdrawApplyTradeState" ,paramMap);
		
	}

	@Override
	public UserWithdrawAppVO queryUserWithdrawAppByUwaId(Integer uwaId) {
		return (UserWithdrawAppVO)this.getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.queryUserWithdrawAppByUwaId",uwaId);
	}
	
	@Override
	public List<RedPacketRangeCfgDtlVO> selectRedPacketRangeConfigureDetailInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectRedPacketRangeConfigureDetailInfoList" , paramMap);
	}

	@Override
	public Integer selectRedPacketRangeConfigureDetailInfoListTotals(
			Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectRedPacketRangeConfigureDetailInfoListTotals" , paramMap);
	}

	@Override
	public void deleteRedPacketRangeConfigureDetailInfo(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.deleteRedPacketRangeConfigureDetailInfo" , paramMap);
	}
	
	@Override
	public void insertRedPacketRangeConfigureDetailInfo(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().insert("UserWalletDaoImpl.insertRedPacketRangeConfigureDetailInfo" , paramMap);
	}
	
	@Override
	public List<RedPacketRangeCfgVO> selectRedPacketRangeConfigureInfoList(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectRedPacketRangeConfigureInfoList" , paramMap);
	}
	
	@Override
	public Integer selectRedPacketRangeConfigureInfoListTotals(
			Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectRedPacketRangeConfigureInfoListTotals" , paramMap);
	}
	
	@Override
	public void updatePercent(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updatePercent" , paramMap);
	}

	@Override
	public List<Map<String, Object>> selectRprIdInfoList() {
		
		return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectRprIdInfoList");
	}
	
	@Override
	public void insertRedPacketRangeConfigureInfo(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().insert("UserWalletDaoImpl.insertRedPacketRangeConfigureInfo" , paramMap);
	}
	
	@Override
	public void deleteRedPacketRangeConfigureInfo(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.deleteRedPacketRangeConfigureInfo" , paramMap);
	}

	@Override
	public void updateCheckFailedWithdrawApp2Fail(String batchNo) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateCheckFailedWithdrawApp2Fail" , batchNo) ;
	}

	@Override
	public void updateCheckFailedWithdrawAppFrozen2Zero(String batchNo) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateCheckFailedWithdrawAppFrozen2Zero" , batchNo) ;
	}
	

    @Override
    public List<AlipayBatchTransferOrderVO> selectAlipayBatchTransferOrderInfoInfoList(
            Map<String, Object> paramMap) {
        return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectAlipayBatchTransferOrderInfoInfoList" , paramMap);
    }
    
    @Override
    public Integer selectAlipayBatchTransferOrderInfoInfoListTotals(
            Map<String, Object> paramMap) {
        return (Integer) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectAlipayBatchTransferOrderInfoInfoListTotals" , paramMap);
    }
    
    @Override
    public List<UserRedPacketVO> selectRedPacketLuckyUserInfoList(
    		 String startDate , String endDate) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("startDate", startDate);
    	map.put("endDate", endDate);
        return getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectRedPacketLuckyUserInfoList" ,map);
    }
    
    @Override
    public void deleteRedPacketLucky() {
        this.getSqlMapClientTemplate().update("UserWalletDaoImpl.deleteRedPacketLucky" );
    }
    
    @Override
    public void insertUserRedPacketLucky(UserRedPacketVO userRedPacket) {
        this.getSqlMapClientTemplate().insert("UserWalletDaoImpl.insertUserRedPacketLucky" , userRedPacket);
    }
    
    @Override
	public void updateWithdrawBatchStateToUsing(String batchNo) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateWithdrawBatchStateToUsing" , batchNo) ;
	}
    
    @Override
    public List<UserWithdrawBatchVO> selectWithdrawBatchByNotUse(String notUse ,String batchNo) {
    	Map<String, Object> paramMap = new HashMap<>();
    	paramMap.put("notUse", notUse);
    	paramMap.put("batchNo", batchNo);
        return  getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectWithdrawBatchByNotUse",paramMap) ;
    }
    
    @Override
    public RedPacketRangeCfgVO selectTotalCnt(String rprId) {
        return (RedPacketRangeCfgVO) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectTotalCnt" , rprId) ;
    }
	

	@Override
	public void updateRedPacketBatchNo2Null4Fail(String batchNo) {
		Map<String,Object> params = new HashMap<String,Object>() ;
		params.put("batchNo", batchNo) ;
		params.put("newBatchNo", CommonConstant.RED_PACKET_BATCH_NO_DEFAULT) ;
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateRedPacketBatchNo2Null4Fail",params) ;
	}

	@Override
	public UserWalletVO queryUserWalletByAccount(String account) {
		return (UserWalletVO)this.getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.queryUserWalletByAccount",account);
	}

	@Override
	public void updateUserWalletAmt(UserWalletVO wallet) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateUserWalletAmt",wallet) ;
	}
	
	@Override
	public void updateRedPacketGroupToRedFace(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateRedPacketGroupToRedFace" , paramMap) ;
	}
    
    @Override
	public void updateRedPacketGroupToBlackFace(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateRedPacketGroupToBlackFace" , paramMap) ;
	}
    
    @Override
	public void updateRedPacketGroupToDefault( Map<String, Object> paramMap ) {
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateRedPacketGroupToDefault" , paramMap ) ;
	}
    
    @Override
   	public void updateWithdrawBatchNoState(Map<String, Object> paramMap) {
   		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateWithdrawBatchNoState" ,paramMap) ;
   	}
    
    @Override
    public UserWithdrawBatchVO queryPreWithDrawBatch(String usingWithdrawBatchStartDate) {
        return (UserWithdrawBatchVO) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectPreWithDrawBatch" , usingWithdrawBatchStartDate) ;
    }
    
    @Override
	public UserWithdrawBatchVO selelctNextWithdrawBatch(String now  ,String notUse) {
    	Map<String, Object> paramMap = new HashMap<>();
    	paramMap.put("now", now);
    	paramMap.put("notUse", notUse);
		return (UserWithdrawBatchVO) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selelctNextWithdrawBatch" , paramMap) ;
	}
    
    @Override
    public List<UserWithdrawBatchVO> selectBatchByNotUse(String notUse) {
        return  getSqlMapClientTemplate().queryForList("UserWalletDaoImpl.selectBatchByNotUse",notUse) ;
    }
    
    @Override
    public UserWithdrawBatchVO queryWithDrawBatchByStateNotUse(String notUse) {
        return (UserWithdrawBatchVO) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectWithDrawBatchByStateNotUse" , notUse) ;
    }
    
    @Override
    public UserWithdrawBatchVO selectLastInsertBatchNo() {
        return (UserWithdrawBatchVO) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectLastInsertBatchNo" ) ;
    }
    
    @Override
    public UserWithdrawBatchVO selectBatchNoTime(String batchNo) {
        return (UserWithdrawBatchVO) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectBatchNoTime" , batchNo) ;
    }
    
    @Override
    public UserWithdrawBatchVO selectNextBatchInfo(String batchNo) {
        return (UserWithdrawBatchVO) getSqlMapClientTemplate().queryForObject("UserWalletDaoImpl.selectNextBatchInfo" , batchNo) ;
    }
    
    @Override
	public void updateNextBatchNoStartDt(String withdrawEndDt, String withdrawEndTm , String batchNo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("withdrawEndDt", withdrawEndDt);
		paramMap.put("withdrawEndTm", withdrawEndTm);
		paramMap.put("batchNo", batchNo);
		this.getSqlMapClientTemplate().update("UserWalletDaoImpl.updateNextBatchNoStartDt" ,paramMap);
		
	}
}
