package com.fq.third.pingpp.transfer;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fq.common.constant.RetCode;
import com.fq.exception.JnwtvException;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.exception.RateLimitException;
import com.pingplusplus.model.Transfer;

public final class TransferExecuter {

	private final static Logger logger = LoggerFactory.getLogger(TransferExecuter.class) ;
	
	public final static Transfer execute(Map<String,Object> transferMap){
		Transfer transfer;
		try {
			transfer = Transfer.create(transferMap);
			logger.info(transfer.toString());
			System.out.println(transfer);
		} catch (AuthenticationException | InvalidRequestException | APIConnectionException | APIException
				| ChannelException | RateLimitException e) {
			logger.error("create ping++ transfer error , transfer params : " + transferMap,e);
			throw new JnwtvException(RetCode.ACCESS_MAGICWINDOW_API_ERROR , e ) ;
		}
		
		return transfer;
	}
	
}
