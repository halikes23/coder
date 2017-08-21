package com.fq.task.withdrawcheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.common.constant.RetCode;
import com.fq.dao.dao.user.UserWalletDAO;
import com.fq.entity.vo.wallet.UserRedPacketInviteRelVO;
import com.fq.entity.vo.wallet.UserRedPacketVO;
import com.fq.entity.vo.wallet.UserWithdrawAppVO;
import com.fq.exception.JnwtvException;
import com.fq.task.PageInfo;
import com.fq.task.TaskDistributor;

@Service
public class WithdrawCheckTaskDistributor extends TaskDistributor<WithdrawCheckTaskData>{

	@Autowired
	private UserWalletDAO userWalletDAO ;
	
	private final static Logger logger = LoggerFactory.getLogger(WithdrawCheckTaskDistributor.class) ;
	
	@Override
	public Integer getTotalCount(Map<String, Object> params) {
		String batchNo = (String)params.get("batchNo");
		return userWalletDAO.queryUncheckedWithdrawAppCountByBatchNo(batchNo);
	}

	@Override
	public WithdrawCheckTaskData prepareData(Map<String,Object> params , PageInfo pageInfo) {
		
		WithdrawCheckTaskData data = new WithdrawCheckTaskData() ;
		
		String batchNo = (String)params.get("batchNo") ;
		
		params.put("begin", pageInfo.getBegin()) ;
		params.put("pageSize", pageInfo.getPageSize()) ;
		
		// 获取提现申请数据
		List<UserWithdrawAppVO> apps = userWalletDAO.queryUncheckedWithdrawAppByBatchNo(params);
		data.setApps(apps);
		
		// 获取红包数据
		String minAccount ;
		String maxAccount ;
		
		if(CollectionUtils.isEmpty(apps)){
			throw new JnwtvException(RetCode.BATCHTASK_DATA_EXCEPTION , 
				new StringBuilder().append("对应批次分页申请数据未空").toString());
		}else{
			minAccount = apps.get(0).getAccount();
			maxAccount = apps.get(apps.size() - 1 ).getAccount() ;
		}
		
		params.put("minAccount", minAccount ) ;
		params.put("maxAccount", maxAccount ) ;
		
		logger.info("任务任务开始执行，批次mimAccount:{},maxAccount:{}"  , new String[]{minAccount , maxAccount});
		
		List<UserRedPacketVO> redPackets = userWalletDAO.queryRedPackets4Chk(params);
		
		for(UserWithdrawAppVO app : apps){
			data.getRedPackets().put( app,new ArrayList<UserRedPacketVO>() ) ;
			data.getRels().put( app,new ArrayList<UserRedPacketInviteRelVO>() ) ;
		}
		
		for(UserRedPacketVO redPacket : redPackets){
			
			UserWithdrawAppVO app = new UserWithdrawAppVO();
			app.setBatchNo(batchNo);
			app.setAccount(redPacket.getAccount());
			data.getRedPackets().get(app).add(redPacket) ;
			
		}
		
		// 获取邀请数据
		List<UserRedPacketInviteRelVO> rels = userWalletDAO.queryRedPacketInviteRel4Chk(params) ;
		
		for(UserRedPacketInviteRelVO rel : rels){
			
			UserWithdrawAppVO app = new UserWithdrawAppVO();
			app.setBatchNo(batchNo);
			app.setAccount(rel.getOprAccount());
			data.getRels().get(app).add(rel) ;
			
		}
		
		return data;
	}

	
}
