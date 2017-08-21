package com.fq.task.withdraw;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.dao.dao.user.UserWalletDAO;
import com.fq.entity.vo.wallet.IoBatchTransferRecipientVO;
import com.fq.task.PageInfo;
import com.fq.task.Task;
import com.fq.task.TaskDistributor;

@Service
public class AlipayWithdrawTaskDistributor extends TaskDistributor<List<IoBatchTransferRecipientVO>>{

	@Autowired
	private UserWalletDAO userWalletDAO ;
	
	@Autowired
	private Task<List<IoBatchTransferRecipientVO>> withdrawCheckTask ;
	
	@Override
	public Integer getTotalCount(Map<String, Object> params) {
		String batchNo = (String)params.get("batchNo") ;
		return userWalletDAO.queryIoBatchTransferRecipientCount(batchNo);
	}

	@Override
	public List<IoBatchTransferRecipientVO> prepareData(Map<String,Object> params , PageInfo pageInfo) {
		
		String batchNo = (String)params.get("batchNo") ;
		
		params.put("begin", pageInfo.getBegin()) ;
		params.put("pageSize", pageInfo.getPageSize()) ;
		params.put("batchNo", batchNo) ;
		
//		List<UserWithdrawAppVO> apps = userWalletDAO.queryUncheckedWithdrawAppByBatchNo(params);
		List<IoBatchTransferRecipientVO> apps = userWalletDAO.queryIoBatchTransferRecipientPage(params);
		
		return apps;
	}

	
}
