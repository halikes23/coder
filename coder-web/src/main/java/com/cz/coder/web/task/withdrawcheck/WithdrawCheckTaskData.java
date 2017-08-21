package com.fq.task.withdrawcheck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fq.entity.vo.wallet.UserRedPacketInviteRelVO;
import com.fq.entity.vo.wallet.UserRedPacketVO;
import com.fq.entity.vo.wallet.UserWithdrawAppVO;

public class WithdrawCheckTaskData {

	/**
	 * 用户提现申请数据
	 */
	private List<UserWithdrawAppVO> apps ;
	
	/**
	 * 用户红包数据
	 */
	private final Map<UserWithdrawAppVO , List<UserRedPacketVO>> redPackets = new HashMap<UserWithdrawAppVO , List<UserRedPacketVO>>() ;
	
	/**
	 * 用户红包来源数据
	 */
	private final Map<UserWithdrawAppVO , List<UserRedPacketInviteRelVO>> rels = new HashMap<UserWithdrawAppVO , List<UserRedPacketInviteRelVO>>() ;

	public List<UserWithdrawAppVO> getApps() {
		return apps;
	}

	public void setApps(List<UserWithdrawAppVO> apps) {
		this.apps = apps;
	}

	public Map<UserWithdrawAppVO , List<UserRedPacketVO>> getRedPackets() {
		return redPackets;
	}

	public Map<UserWithdrawAppVO, List<UserRedPacketInviteRelVO>> getRels() {
		return rels;
	}

	
	
}
