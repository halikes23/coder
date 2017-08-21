package com.fq.third.pingpp.transfer;

import java.util.Map;

import com.fq.entity.vo.wallet.UserWithdrawAppVO;

public interface TransferFactory<T> {

	Map<String,Object> build(T app) ;
	
}
