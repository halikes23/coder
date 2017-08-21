package com.fq.task.withdraw;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.dao.dao.user.UserWalletDAO;
import com.fq.entity.vo.wallet.UserWithdrawAppVO;
import com.fq.task.PageInfo;
import com.fq.task.Task;
import com.fq.task.TaskDistributor;

@Service
public class WxPubWithdrawTaskDistributor extends TaskDistributor<List<UserWithdrawAppVO>>{

	@Autowired
	private UserWalletDAO userWalletDAO ;
	
	@Autowired
	private Task<List<UserWithdrawAppVO>> withdrawCheckTask ;
	
	@Override
	public Integer getTotalCount(Map<String, Object> params) {
		String batchNo = (String)params.get("batchNo");
		return userWalletDAO.queryUntransferWxPubWithdrawAppCountByBatchNo(batchNo);
	}

	@Override
	public List<UserWithdrawAppVO> prepareData(Map<String,Object> params , PageInfo pageInfo) {
		
		String batchNo = (String)params.get("batchNo") ;
		
		params.put("begin", pageInfo.getBegin()) ;
		params.put("pageSize", pageInfo.getPageSize()) ;
		params.put("batchNo", batchNo) ;
		
//		List<UserWithdrawAppVO> apps = userWalletDAO.queryUncheckedWithdrawAppByBatchNo(params);
		List<UserWithdrawAppVO> apps = userWalletDAO.queryUntransferWxPubWithdrawAppByBatchNo(params);
		
		return apps;
	}

	
}
