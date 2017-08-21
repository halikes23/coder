package com.fq.trade;

import com.fq.dao.entity.po.TradeAppInfoPO;
import com.fq.util.ContractNoBuilder;
import com.fq.util.DateFormatUtil;


/**
 * 对账信息记录
 * @author Administrator
 *
 */
public class TradeRecord {
	
	
	//充值insert
	public static TradeAppInfoPO  createTradeRecordByCdkey(String entityNo , String entityType , Integer appVol , String cdkey ,String busiCode){
		TradeAppInfoPO TradeAppInfoPO = new TradeAppInfoPO();
		TradeAppInfoPO.setEntityNo(entityNo);
		TradeAppInfoPO.setEntityType(entityType);
		TradeAppInfoPO.setAppVol(appVol);
		TradeAppInfoPO.setCdkey(cdkey);
		TradeAppInfoPO.setBusiCode(busiCode);
		TradeAppInfoPO.setAppDt(DateFormatUtil.CREATE_FULL_DATE_STR());
		TradeAppInfoPO.setAppTm(DateFormatUtil.CREATE_FULL_DATE_STR_TM());
		TradeAppInfoPO.setContractNo(ContractNoBuilder.bulidContractNo(entityNo + Long.toString(System.currentTimeMillis())));
		return TradeAppInfoPO;
	}
	
	//登录，注册 ,退款
	public static TradeAppInfoPO  createTradeRecord(String entityNo , String entityType , Integer appVol  ,String busiCode){
		TradeAppInfoPO TradeAppInfoPO = new TradeAppInfoPO();
		TradeAppInfoPO.setEntityNo(entityNo);
		TradeAppInfoPO.setEntityType(entityType);
		TradeAppInfoPO.setAppVol(appVol);
		TradeAppInfoPO.setBusiCode(busiCode);
		TradeAppInfoPO.setAppDt(DateFormatUtil.CREATE_FULL_DATE_STR());
		TradeAppInfoPO.setAppTm(DateFormatUtil.CREATE_FULL_DATE_STR_TM());
		TradeAppInfoPO.setContractNo(ContractNoBuilder.bulidContractNo(entityNo + Long.toString(System.currentTimeMillis())));
		return TradeAppInfoPO;
	}
	
	
	//打赏，项目加血
	public static TradeAppInfoPO  createTradeRecordForProject(String entityNo , String entityType , Integer appVol  ,String busiCode ,String ContractNo){
		TradeAppInfoPO TradeAppInfoPO = new TradeAppInfoPO();
		TradeAppInfoPO.setEntityNo(entityNo);
		TradeAppInfoPO.setEntityType(entityType);
		TradeAppInfoPO.setAppVol(appVol);
		TradeAppInfoPO.setBusiCode(busiCode);
		TradeAppInfoPO.setAppDt(DateFormatUtil.CREATE_FULL_DATE_STR());
		TradeAppInfoPO.setAppTm(DateFormatUtil.CREATE_FULL_DATE_STR_TM());
		TradeAppInfoPO.setContractNo(ContractNo);
		return TradeAppInfoPO;
	}
	
	
	public static void main(String[] args) {
		System.out.println(ContractNoBuilder.bulidContractNo(Long.toString(System.currentTimeMillis())+"N"));
	}
}
