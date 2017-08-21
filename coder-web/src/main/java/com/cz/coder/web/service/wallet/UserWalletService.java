package com.fq.service.wallet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.fq.common.constant.RetCode;
import com.fq.common.constant.RetCodeEnum;
import com.fq.common.constant.third.pingpp.BatchTransferRecipientConstant;
import com.fq.common.constant.wallet.UserWithdrawAppConstant;
import com.fq.dao.dao.user.UserWalletDAO;
import com.fq.dao.entity.vo.privilege.AdminVO;
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
import com.fq.message.sender.IMessageSender;
import com.fq.task.withdrawcheck.WithdrawCheckTaskData;
import com.fq.third.pingpp.transfer.TransferFactory;
import com.fq.third.pingpp.transfer.alipaybatch.AlipayBatchTransferFactory;
import com.fq.third.pingpp.transfer.wxpub.WxPubTransferFactory;
import com.fq.util.DateFormatUtil;
import com.fq.util.page.PageInfo;
import com.fq.util.page.PageUtil;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.exception.RateLimitException;
import com.pingplusplus.model.BatchTransfer;
import com.pingplusplus.model.BatchTransferRecipient;
import com.pingplusplus.model.Transfer;

@Service
public class UserWalletService {
	
	@Autowired
	private UserWalletDAO  userWalletDAO;
	
	private final TransferFactory<UserWithdrawAppVO> wuPubTransferFactory = new WxPubTransferFactory() ;
	
	private final TransferFactory<List<IoBatchTransferRecipientVO>> alipayBatchTransferFactory = new AlipayBatchTransferFactory() ;
	
	private final static String KEY_APP = "app" ;
	
	@Autowired
	private IMessageSender<String[]> mailSender;
	
	private final static Logger logger = LoggerFactory.getLogger(UserWalletService.class);
	
	/*
	 * 查询用户余额明细
	 */
	public PageInfo<UserWalletChangeVO> toQueryUserWalletChangeInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<UserWalletChangeVO> pageInfo = new PageInfo<UserWalletChangeVO>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			List<UserWalletChangeVO>  userWalletChangeInfoList = userWalletDAO.queryUserWalletChangeInfoList(paramMap);
			Integer pageCount = userWalletDAO.queryUserWalletChangeInfoListTotals(paramMap) ;
			pageInfo.setDataList( userWalletChangeInfoList ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	
	/*
	 * 查询用户钱包提现申请信息列表
	 */
	public PageInfo<UserWithdrawAppVO> toQueryUserWithdrawApplyInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<UserWithdrawAppVO> pageInfo = new PageInfo<UserWithdrawAppVO>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			List<UserWithdrawAppVO>  userWithdrawApplyInfoList = userWalletDAO.queryUserWithdrawApplyInfoList(paramMap);
			Integer pageCount = userWalletDAO.queryUserWithdrawApplyInfoListTotals(paramMap) ;
			pageInfo.setDataList( userWithdrawApplyInfoList ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	
	/*
	 * 查询用户提现批次信息
	 */
	public PageInfo<UserWithdrawBatchVO> queryUserWithdrawBatchInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<UserWithdrawBatchVO> pageInfo = new PageInfo<UserWithdrawBatchVO>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			List<UserWithdrawBatchVO> userWithdrawInfoList = userWalletDAO.queryUserWithdrawBatchInfoList(paramMap);
			Integer pageCount = userWalletDAO.queryUserWithdrawBatchInfoListTotals(paramMap) ;
			pageInfo.setDataList( userWithdrawInfoList ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	/*
	 * 查询某一批次下的用户提现申请信息
	 */
	public PageInfo<UserWithdrawAppVO> queryWithdrawBatchUserInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<UserWithdrawAppVO> pageInfo = new PageInfo<UserWithdrawAppVO>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			List<UserWithdrawAppVO> withdrawBatchUserInfoList = userWalletDAO.queryWithdrawBatchUserInfoList(paramMap);
			Integer pageCount = userWalletDAO.queryWithdrawBatchUserInfoListTotals(paramMap) ;
			pageInfo.setDataList( withdrawBatchUserInfoList ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	/*
	 * 查询申请提现用户的红包信息
	 */
	public PageInfo<Map<String, Object>> queryWithdrawUserRedPacketInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			List<Map<String, Object>> withdrawUserRedPacketInfoList = userWalletDAO.queryWithdrawUserRedPacketInfoList(paramMap);
			Integer pageCount = userWalletDAO.queryWithdrawUserRedPacketInfoListTotals(paramMap) ;
			pageInfo.setDataList( withdrawUserRedPacketInfoList ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	
	/**
	 * 提现审核
	 * @param app
	 * @param data
	 * @return
	 */
	public RetCodeEnum check(UserWithdrawAppVO app, WithdrawCheckTaskData data) {
//		List<UserRedPacketVO> redPackets = data.getRedPackets().get(app) ;
//		List<UserRedPacketInviteRelVO> rels = data.getRels().get(app) ;
		
		//app.setChkState(UserWalletConstant.CHK_STATE.CHK_SUCCESS);
		//this.userWalletDAO.updateWithdrawAppCheckState(app);
		
		return RetCodeEnum.SUCCESS ;
	}
	
	/**
	 * 提现 威信支付
	 * @param app
	 * @param data
	 * @return
	 */
	public final RetCodeEnum withdrawByPubWx(UserWithdrawAppVO app) {
		
		// 生成TpTradeApp记录
//		TradeAppPO tradeApp = new TradeAppPO() ;
		
		Map<String,Object> transferMap = wuPubTransferFactory.build(app) ;
		try{
			Transfer transfer = Transfer.create(transferMap);
			logger.info(transfer.toString());
			this.doWithdrawSendSuccess(app);
		}catch( AuthenticationException | InvalidRequestException | APIConnectionException | APIException
				| ChannelException | RateLimitException e){
			
			logger.error("create ping++ transfer error , transfer params : " + transferMap,e);
			this.doWithdrawFail(app,e.getMessage());
			
		}
		
		return RetCodeEnum.SUCCESS ;
		
	}
	
	/**
	 * 提现 阿里批量支付
	 * @param aliRecipients
	 */
	public void withdrawByAliPayBatch(List<IoBatchTransferRecipientVO> apps) {

		Map<String,Object> transferMap = alipayBatchTransferFactory.build(apps) ;
		
		Map<String,IoBatchTransferRecipientVO> appsMap = new HashMap<String,IoBatchTransferRecipientVO>();
		
		for(IoBatchTransferRecipientVO app : apps){
			appsMap.put((new StringBuilder().append(app.getAccount()).append("_").append(app.getName())).toString(), app) ;
		}
		
		try{
			logger.info(transferMap.toString());
			BatchTransfer transfer = BatchTransfer.create(transferMap);
			logger.info("transfer : "+transfer.toString());
			
			AlipayBatchTransferOrderPO order = new AlipayBatchTransferOrderPO();
			order.setPingppOrderNo((String)transferMap.get(AlipayBatchTransferFactory.KEY_BATCH_NO));
			order.setUrl(transfer.getFailureMsg());
			order.setStatus(transfer.getStatus());
			userWalletDAO.insertAlipayBatchTransferOrder(order);
			
			UserWithdrawAppVO param = new UserWithdrawAppVO() ;
			
			
			for( BatchTransferRecipient recipient : transfer.getRecipients()){
				
				String key = (new StringBuilder().append(recipient.getAccount()).append("_").append(recipient.getName())).toString() ;
				IoBatchTransferRecipientVO app = appsMap.get(key) ;
				// 修改PingPP订单信息
				app.setTransfer(recipient.getTransfer());
				app.setStatus(recipient.getStatus());
				
				param.setBatchNo(app.getBatchNo());
				param.setChannelAccount(app.getAccount());
				param.setChannelName(app.getName());
				param.setTransfer(recipient.getTransfer());
				
				// 修改提现订单信息
				if(StringUtils.equals(recipient.getStatus(), BatchTransferRecipientConstant.STATUS.PENDING)){
					param.setTradeState(UserWithdrawAppConstant.TRADE_STATE.WIDTHDRAWING);
					param.setSendState(UserWithdrawAppConstant.SEND_STATE.SEND_SUCCESS);
					param.setTradeFailMsg(null);
					
				}else{
					param.setSendState(UserWithdrawAppConstant.SEND_STATE.SEND_FAILED);
					param.setTradeState(UserWithdrawAppConstant.TRADE_STATE.WIDTHDRAW_FAIL);
					param.setTradeFailMsg(transfer.getFailureMsg());
					
				}
				
				
				
				userWalletDAO.updateTradeStateByChannelInfo(param);
				
				userWalletDAO.updateIoBatchTransferRecipient(app);
			}
			
		}catch(AuthenticationException | InvalidRequestException | APIConnectionException | APIException | ChannelException | RateLimitException e){
			logger.error("",e);
			UserWithdrawAppVO param = new UserWithdrawAppVO() ;
			param.setTradeState(UserWithdrawAppConstant.TRADE_STATE.WIDTHDRAW_FAIL);
			param.setTradeFailMsg(e.getMessage());
			param.setSendState(UserWithdrawAppConstant.SEND_STATE.SEND_FAILED);
			for(IoBatchTransferRecipientVO app : apps){
				param.setBatchNo(app.getBatchNo());
				param.setChannelAccount(app.getAccount());
				param.setChannelName(app.getName());
				logger.info(param.toString());
				userWalletDAO.updateTradeStateByChannelInfo(param);
			}
			
		}
		
	}
	
	/*
	 * 查询用户提现渠道信息
	 */
	public PageInfo<UserWithdrawChannelVO> queryUserWithdrawChannelInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<UserWithdrawChannelVO> pageInfo = new PageInfo<UserWithdrawChannelVO>();
			paramMap.putAll(PageUtil.buildPage(Integer.valueOf(paramMap.get("pageNow").toString()), Integer.valueOf(paramMap.get("pageSize").toString())));
			List<UserWithdrawChannelVO> userWithdrawChannelList = userWalletDAO.queryUserWithdrawChannelInfoList(paramMap);
			Integer pageCount = userWalletDAO.queryUserWithdrawChannelInfoListTotals(paramMap);
			pageInfo.setDataList(userWithdrawChannelList);
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf(paramMap.get("pageNow").toString()));
			pageInfo.setPageSize(Integer.valueOf(paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志 ：" ,e);
			throw e ;
		}
	}
	/*
	 * 查询用户提现渠道历史信息
	 */
	public PageInfo<UserWithdrawChannelHistoryVO> queryUserWithdrawChannelHistoryInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<UserWithdrawChannelHistoryVO> pageInfo = new PageInfo<UserWithdrawChannelHistoryVO>();
			paramMap.putAll(PageUtil.buildPage(Integer.valueOf(paramMap.get("pageNow").toString()), Integer.valueOf(paramMap.get("pageSize").toString())));
			List<UserWithdrawChannelHistoryVO> userWithdrawChannelHistoryList = userWalletDAO.queryUserWithdrawChannelHistoryInfoList(paramMap);
			Integer pageCount = userWalletDAO.queryUserWithdrawChannelHistoryInfoListTotals(paramMap);
			pageInfo.setDataList(userWithdrawChannelHistoryList);
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf(paramMap.get("pageNow").toString()));
			pageInfo.setPageSize(Integer.valueOf(paramMap.get("pageSize").toString()));
			return pageInfo ;
		} catch (Exception e) {
			logger.error("错误日志 ：" , e );
			throw e ;
		}
	}

	public UserWithdrawBatchVO queryWithdrawBatchResult(String batchNo) {
		return this.userWalletDAO.queryWithdrawBatchResult(batchNo);
	}
	
	 /*
     * 查询用户钱包信息
     */
    public PageInfo<UserWalletVO> queryUserWalletInfoList(
            Map<String, Object> paramMap)throws Exception {
        try {
            PageInfo<UserWalletVO> pageInfo = new PageInfo<UserWalletVO>();
        	paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
            List<UserWalletVO> userWalletInfoList = userWalletDAO.queryUserWalletInfoList(paramMap);
            Integer pageCount = userWalletDAO.queryUserWalletInfoListTotals(paramMap);
            pageInfo.setDataList(userWalletInfoList);
            pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
            return pageInfo;
        }  catch (Exception e) {
            logger.error("错误日志 ：" , e );
            throw e ;
        }
    }
    /*
     * 查询用户红包信息
     */
    public PageInfo<UserRedPacketVO> queryUserRedPacketInfoList(
            Map<String, Object> paramMap)throws Exception {
        try {
            PageInfo<UserRedPacketVO> pageInfo = new PageInfo<UserRedPacketVO>();
            paramMap.putAll(PageUtil.buildPage(Integer.valueOf(paramMap.get("pageNow").toString()), Integer.valueOf(paramMap.get("pageSize").toString())));
            List<UserRedPacketVO> userRedPacketInfoList = userWalletDAO.queryUserRedPacketInfoList(paramMap);
            Integer pageCount = userWalletDAO.queryUserRedPacketInfoListTotals(paramMap);
            pageInfo.setDataList(userRedPacketInfoList);
            pageInfo.setDataCount(pageCount);
            pageInfo.setCurrentlyPageNo(Integer.valueOf(paramMap.get("pageNow").toString()));
            pageInfo.setPageSize(Integer.valueOf(paramMap.get("pageSize").toString()));
            return pageInfo;
        } catch (Exception e) {
            logger.error("错误日志：" , e );
            throw e ;
        }
    }
    /*
     * 查询红包对应被邀请用户关系
     */
    public PageInfo<UserRedPacketInviteRelVO> queryRedPacketInviteUserRelByUreId(
            Map<String, Object> paramMap)throws Exception {
        try {
            PageInfo<UserRedPacketInviteRelVO> pageInfo = new PageInfo<UserRedPacketInviteRelVO>();
            paramMap.putAll(PageUtil.buildPage(Integer.valueOf(paramMap.get("pageNow").toString()), Integer.valueOf(paramMap.get("pageSize").toString())));
            List<UserRedPacketInviteRelVO> redPacketInviteUserRelInfoList = userWalletDAO.queryRedPacketInviteUserRelByUreId(paramMap);
            Integer pageCount = userWalletDAO.queryRedPacketInviteUserRelByUreIdTotals(paramMap);
            pageInfo.setDataList(redPacketInviteUserRelInfoList);
            pageInfo.setDataCount(pageCount);
            pageInfo.setCurrentlyPageNo(Integer.valueOf(paramMap.get("pageNow").toString()));
            pageInfo.setPageSize(Integer.valueOf(paramMap.get("pageSize").toString()));
            return pageInfo;
        } catch (Exception e) {
            logger.error("错误日志：" , e );
            throw e ;
        }
    }
    
    /*
     * 批量支付订单查询 
     */
	public PageInfo<IoBatchTransferRecipientVO> queryWithdrawBatchTransferRecipientInfo(
			Map<String, Object> paramMap) throws Exception{
		try {
			PageInfo<IoBatchTransferRecipientVO> pageInfo = new PageInfo<IoBatchTransferRecipientVO>();
			paramMap.putAll(PageUtil.buildPage(Integer.valueOf(paramMap.get("pageNow").toString()), Integer.valueOf(paramMap.get("pageSize").toString())));
			List<IoBatchTransferRecipientVO> withdrawBatchTransferRecipientInfoList = userWalletDAO.queryWithdrawBatchTransferRecipientInfoList(paramMap);
			Integer pageCount = userWalletDAO.queryWithdrawBatchTransferRecipientInfoListTotals(paramMap);
			pageInfo.setDataList(withdrawBatchTransferRecipientInfoList);
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf(paramMap.get("pageNow").toString()));
			pageInfo.setPageSize(Integer.valueOf(paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志 ："  , e );
			throw e ;
		}
	}
	/*
	 * 查询提现批次号详细信息
	 */
	public Map<String, Object> queryWithdrawBatchNoInfo(Map<String, Object> paramMap) {
		try{
			Map<String, Object> WithdrawBatchNoDetail = userWalletDAO.queryWithdrawBatchNoInfo(paramMap);
			return WithdrawBatchNoDetail;
		}catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}

	/*
	 * 修改提现批次号信息
	 */
	public ModelAndView updateWithdrawBatchNoInfo(Map<String, Object> paramMap) throws Exception {
		try {
			Map<String , Object > res = new HashMap<String, Object>() ;
			ModelAndView mav = new ModelAndView() ;
			MappingJacksonJsonView view = new MappingJacksonJsonView() ;
			
			for(Entry<String, Object> entry : paramMap.entrySet()){
				if (StringUtils.isEmpty( entry.getValue().toString())) {
					res.put("message","日期(时间)不能为空" );
					res.put("succ", false);
					view.setAttributesMap( res ) ;
					mav.setView(view);
					return mav;
				}
			}
			
			//查询当前批次的时间信息
			UserWithdrawBatchVO withdrawBatchVO = userWalletDAO.selectBatchNoTime(paramMap.get("batchNo").toString());
			
			//当前批次的开始时间
			long usingWithdrawBatchEndDt   = DateFormatUtil.dateAndTime2TimeStamp(withdrawBatchVO.getStartDt(), withdrawBatchVO.getStartTm(),  DateFormatUtil.DATA_FORMAT_Y_M_D); 
			
			//修改后的批次抢红包开始时间
			long redPacketStartDt = DateFormatUtil.dateAndTime2TimeStamp(paramMap.get("redPacketStartDt").toString(), paramMap.get("redPacketStartTm").toString(),  DateFormatUtil.DATA_FORMAT_Y_M_D);
			//修改后的批次抢红包结束时间
			long redPacketEndDt = DateFormatUtil.dateAndTime2TimeStamp(paramMap.get("redPacketEndDt").toString(), paramMap.get("redPacketStartTm").toString(),  DateFormatUtil.DATA_FORMAT_Y_M_D);
			
			//抢红包开始，结束时间维护
				if (redPacketStartDt < usingWithdrawBatchEndDt) {
					res.put("message","请设置该批次抢红包开始时间为当前批次的开始时间之后" );
					res.put("succ", false);
					view.setAttributesMap( res ) ;
					mav.setView(view);
					return mav;
				}
			//修改后的批次提现开始时间
			long withdrawStartDt = DateFormatUtil.dateAndTime2TimeStamp(paramMap.get("withdrawStartDt").toString(), paramMap.get("withdrawStartTm").toString(),  DateFormatUtil.DATA_FORMAT_Y_M_D);
			//修改后的批次提现结束时间
			long withdrawEndDt = DateFormatUtil.dateAndTime2TimeStamp(paramMap.get("withdrawEndDt").toString(), paramMap.get("withdrawEndTm").toString(),  DateFormatUtil.DATA_FORMAT_Y_M_D);
			
			//提现开始,结束时间维护
				if (withdrawStartDt < redPacketEndDt) {
					res.put("message","提现开始时间必须设置为抢红包时间结束之后" );
					res.put("succ", false);
					view.setAttributesMap( res ) ;
					mav.setView(view);
					return mav;
				}
				userWalletDAO.updateWithdrawBatchNoInfo(paramMap);
				
				//查询下个批次的信息
				UserWithdrawBatchVO nextBatchNoVO = userWalletDAO.selectNextBatchInfo(paramMap.get("batchNo").toString());
				if (nextBatchNoVO != null ) {
					// 修改下个批次号的开始时间
					userWalletDAO.updateNextBatchNoStartDt(paramMap.get("withdrawEndDt").toString() , paramMap.get("withdrawEndTm").toString() , nextBatchNoVO.getBatchNo());
					
					//下一批次结束时间
					long nextEndDate = DateFormatUtil.dateAndTime2TimeStamp(nextBatchNoVO.getEndDt(), nextBatchNoVO.getEndTm(),  DateFormatUtil.DATA_FORMAT_Y_M_D);
					if (withdrawEndDt >= nextEndDate) {
						res.put("message", "修改成功 ！警告：本次修改对后续批次有影响,请核实！");
						res.put("succ", true ) ;
						view.setAttributesMap( res ) ;
						mav.setView(view);
						return mav;
					}
				}
				
			res.put("message", "批次号信息修改成功！");
			res.put("succ", true ) ;
			view.setAttributesMap( res ) ;
			mav.setView(view);
			return mav;
			
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 创建新的批次
	 */
	@SuppressWarnings("unused")
	public ModelAndView addWithdrawBatchNoInfo(Map<String, Object> paramMap) throws Exception {
		try {
			Map<String , Object > res = new HashMap<String, Object>() ;
			ModelAndView mav = new ModelAndView() ;
			MappingJacksonJsonView view = new MappingJacksonJsonView() ;
			
			for(Entry<String, Object> entry : paramMap.entrySet()){
				if (StringUtils.isEmpty( entry.getValue().toString())) {
					res.put("message","日期(时间)不能为空" );
					res.put("succ", false);
					view.setAttributesMap( res ) ;
					mav.setView(view);
					return mav;
				}
			}
			//查询最近生成的一条批次号信息
			UserWithdrawBatchVO batchNoVO = userWalletDAO.selectLastInsertBatchNo();
			
			//创建的批次抢红包开始时间
			long redPacketStartDt = DateFormatUtil.dateAndTime2TimeStamp(paramMap.get("redPacketStartDt").toString(), paramMap.get("redPacketStartTm").toString(),  DateFormatUtil.DATA_FORMAT_Y_M_D);
			//创建的批次抢红包结束时间
			long redPacketEndDt = DateFormatUtil.dateAndTime2TimeStamp(paramMap.get("redPacketEndDt").toString(), paramMap.get("redPacketStartTm").toString(),  DateFormatUtil.DATA_FORMAT_Y_M_D);
			
			//创建的批次提现开始时间
			long withdrawStartDt = DateFormatUtil.dateAndTime2TimeStamp(paramMap.get("withdrawStartDt").toString(), paramMap.get("withdrawStartTm").toString(),  DateFormatUtil.DATA_FORMAT_Y_M_D);
			//创建的批次提现结束时间
			long withdrawEndDt = DateFormatUtil.dateAndTime2TimeStamp(paramMap.get("withdrawEndDt").toString(), paramMap.get("withdrawEndTm").toString(),  DateFormatUtil.DATA_FORMAT_Y_M_D);
			
			if (batchNoVO == null) {
					if (redPacketStartDt < redPacketEndDt || 
						withdrawStartDt < redPacketEndDt || withdrawEndDt < withdrawStartDt) {
						res.put("message","抢红包（提现）开始时间必须小于抢红包（提现）结束时间" );
						res.put("succ", false);
						view.setAttributesMap( res ) ;
						mav.setView(view);
						return mav;
					}
					if (withdrawStartDt < redPacketEndDt) {
						res.put("message","提现开始时间必须设置为抢红包时间结束之后" );
						res.put("succ", false);
						view.setAttributesMap( res ) ;
						mav.setView(view);
						return mav;
					}
					paramMap.put("startDt", paramMap.get("redPacketStartDt"));
					paramMap.put("startTm", paramMap.get("redPacketStartTm"));
					
			}else {
				//上一批次的结束时间， 即当前批次的开始时间
				long endDate = DateFormatUtil.dateAndTime2TimeStamp(batchNoVO.getWithdrawEndDt(), batchNoVO.getWithdrawEndTm(),  DateFormatUtil.DATA_FORMAT_Y_M_D);
				if (redPacketStartDt <= endDate ||redPacketStartDt > redPacketEndDt || 
						withdrawStartDt < redPacketEndDt || withdrawEndDt < withdrawStartDt ) {
					res.put("message","抢红包（提现）开始时间必须小于抢红包（提现）结束时间" );
					res.put("succ", false);
					view.setAttributesMap( res ) ;
					mav.setView(view);
					return mav;
				}	
					paramMap.put("startDt", batchNoVO.getWithdrawEndDt());
					paramMap.put("startTm", batchNoVO.getWithdrawEndTm());
			}
			
			Integer subBatchNo = Integer.parseInt(StringUtils.substring(batchNoVO.getBatchNo() , 20, 26)) + 1;
			String num = String.format("%06d", subBatchNo);
			
			String startDt = paramMap.get("startDt").toString();
			String endDt = paramMap.get("withdrawEndDt").toString();
			//根据批次开始，结束时间 ， 生成批次号 yymmddhhyymmddhh+000001
			StringBuilder batchNo = new StringBuilder();
			batchNo.append(StringUtils.substring(startDt , 0, 4)).append(StringUtils.substring(startDt , 5, 7)).append(StringUtils.substring(startDt , 8, 10));
			batchNo.append(StringUtils.substring(paramMap.get("startTm").toString(), 0, 2)  );
			batchNo.append(StringUtils.substring(endDt , 0, 4)).append(StringUtils.substring(endDt , 5, 7)).append(StringUtils.substring(endDt , 8, 10));
			batchNo.append(StringUtils.substring(paramMap.get("withdrawEndTm").toString(), 0, 2)  );
			batchNo.append(num);
			
			paramMap.put("batchNo", batchNo.toString());
			
			userWalletDAO.addWithdrawBatchNoInfo(paramMap);
			
			res.put("message", "提现批次创建成功！");
			res.put("succ", true ) ;
			view.setAttributesMap( res ) ;
			mav.setView(view);
			return mav;
			
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	
	
	public void chgChkState2Succ4Fail(final AdminVO operator , final Integer uwaId) {
		
		try {
			UserWalletService.this.mailSender.send(
					"手动修改审核状态",String.format("提现申请 %s 状态被操作员%s【%s】手动修改为成功" , uwaId ,operator.getRealName() , operator.getUserName() ) , 
					new String[]{"chengzhen000000@163.com"});
		} catch (Exception e) {
			logger.error("",e);
			throw new RuntimeException(e);
		}
		
		UserWithdrawAppVO app = this.userWalletDAO.queryUserWithdrawAppByUwaId(uwaId);
		
		app.setUwaId(uwaId);
		app.setChkState(UserWithdrawAppConstant.CHK_STATE.CHK_SUCCESS);
		app.setTradeState(UserWithdrawAppConstant.TRADE_STATE.WIDTHDRAWING);
		app.setSendState(UserWithdrawAppConstant.SEND_STATE.UNSEND);
		this.userWalletDAO.updateWithdrawAppState(app);
		
		this.userWalletDAO.updateCheckSummary(app.getBatchNo());
		
	}
	
	public void chgChkState2Fail4Succ(final AdminVO operator , final Integer uwaId) {
		
		try {
			UserWalletService.this.mailSender.send(
					"手动修改审核状态",String.format("提现申请 %s 状态被操作员%s【%s】手动修改为失败" , uwaId ,operator.getRealName() , operator.getUserName() ) , 
					new String[]{"chengzhen000000@163.com"});
		} catch (Exception e) {
			logger.error("",e);
			throw new RuntimeException(e);
		}
		
		UserWithdrawAppVO app = this.userWalletDAO.queryUserWithdrawAppByUwaId(uwaId);
		
		app.setUwaId(uwaId);
		app.setChkState(UserWithdrawAppConstant.CHK_STATE.CHK_FAILED);
		app.setTradeState(UserWithdrawAppConstant.TRADE_STATE.WIDTHDRAWING);
		app.setSendState(UserWithdrawAppConstant.SEND_STATE.DONOT_SEND);
		this.userWalletDAO.updateWithdrawAppState(app);
		
		this.userWalletDAO.updateCheckSummary(app.getBatchNo());
		
	}
	
	/*
	 * 查询红包范围配置信息
	 */
	public PageInfo<RedPacketRangeCfgDtlVO> toQueryRedPacketRangeConfigureDetailInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<RedPacketRangeCfgDtlVO> pageInfo = new PageInfo<>();
			paramMap.putAll(PageUtil.buildPage(Integer.valueOf(paramMap.get("pageNow").toString()), Integer.valueOf(paramMap.get("pageSize").toString())));
			paramMap.put( "isDeleted" ,( paramMap.get("isDeleted") == null) ? "N" : paramMap.get("isDeleted") );
			List<RedPacketRangeCfgDtlVO> redPacketRangeConfigureDetailInfoList = userWalletDAO.selectRedPacketRangeConfigureDetailInfoList(paramMap);
			Integer pageCount = userWalletDAO.selectRedPacketRangeConfigureDetailInfoListTotals(paramMap);
			pageInfo.setDataList(redPacketRangeConfigureDetailInfoList);
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf(paramMap.get("pageNow").toString()));
			pageInfo.setPageSize(Integer.valueOf(paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志 ： " , e ) ;
			throw e;
		}
	}
	/*
	 * 伪删除红包范围配置信息
	 */
	public void deleteRedPacketRangeConfigureDetailInfo(Map<String, Object> paramMap) throws Exception {
		try {
			userWalletDAO.deleteRedPacketRangeConfigureDetailInfo(paramMap) ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 创建红包范围配置信息
	 */
	public ModelAndView addRedPacketRangeConfigureDetailInfo(Map<String, Object> paramMap) throws Exception {
		try {
			Map<String , Object > res = new HashMap<String, Object>() ;
			ModelAndView mav = new ModelAndView() ;
			MappingJacksonJsonView view = new MappingJacksonJsonView() ;
			AdminVO loginUser = (AdminVO) paramMap.get("loginUser");
			paramMap.put("userName", loginUser.getUserName()) ;
			
			if (StringUtils.isEmpty(paramMap.get("minAmt").toString())
					||StringUtils.isEmpty(paramMap.get("maxAmt").toString())) {
				res.put("message","金额范围最大或最小值不能为空！" );
				res.put("succ", false);
				view.setAttributesMap( res ) ;
				mav.setView(view);
				return mav;
			}
			if (StringUtils.isEmpty(paramMap.get("percent").toString())) {
				res.put("message","已用次数占比不能为空！" );
				res.put("succ", false);
				view.setAttributesMap( res ) ;
				mav.setView(view);
				return mav;
			}
			paramMap.put("createDt", DateFormatUtil.CREATE_FULL_DATE_STR_DB());
			RedPacketRangeCfgVO redPacketRangeCfgVO = userWalletDAO.selectTotalCnt (paramMap.get("rprId").toString());
			//维护当前已用次数
			paramMap.put("totalCnt", Integer.parseInt(redPacketRangeCfgVO.getTotalCnt().toString())*Integer.parseInt(paramMap.get("percent").toString())/1000);
			
			userWalletDAO.insertRedPacketRangeConfigureDetailInfo(paramMap);
			
			res.put("message", "红包范围配置创建成功！");
			res.put("succ", true ) ;
			view.setAttributesMap( res ) ;
			mav.setView(view);
			return mav;
			
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 查询红包范围码
	 */
	public PageInfo<RedPacketRangeCfgVO> toQueryRedPacketRangeConfigureInfoList(
			Map<String, Object> paramMap)throws Exception {
		try {
			PageInfo<RedPacketRangeCfgVO> pageInfo = new PageInfo<>();
			paramMap.putAll(PageUtil.buildPage(Integer.valueOf(paramMap.get("pageNow").toString()), Integer.valueOf(paramMap.get("pageSize").toString())));
			paramMap.put( "isDeleted" ,( paramMap.get("isDeleted") == null) ? "N" : paramMap.get("isDeleted") );
			List<RedPacketRangeCfgVO> redPacketRangeConfigureInfoList = userWalletDAO.selectRedPacketRangeConfigureInfoList(paramMap);
			Integer pageCount = userWalletDAO.selectRedPacketRangeConfigureInfoListTotals(paramMap);
			pageInfo.setDataList(redPacketRangeConfigureInfoList);
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf(paramMap.get("pageNow").toString()));
			pageInfo.setPageSize(Integer.valueOf(paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志 ： " , e ) ;
			throw e;
		}
	}
	/*
	 * 修改已用人数占比
	 */
	public void updatePercent(Map<String, Object> paramMap) {
		try{
			if (null == paramMap.get("percent")) {
				paramMap.put("percent", '0');
			}
			RedPacketRangeCfgVO redPacketRangeCfgVO = userWalletDAO.selectTotalCnt (paramMap.get("rprId").toString());
			//维护当前已用次数
			paramMap.put("totalCnt", Integer.parseInt(redPacketRangeCfgVO.getTotalCnt().toString())*Integer.parseInt(paramMap.get("percent").toString())/1000);
			userWalletDAO.updatePercent(paramMap);
		} catch (Exception e) {
			logger.error("数据库异常" + e ) ;
			throw e ;
		}
	}
	/*
	 * 查询可选备用的rprId
	 */
	public Map<String, Object> selectRprIdInfoList() throws Exception {
		Map<String , Object> res = new HashMap<String, Object>();
		try {
			List<Map<String , Object>> rprIdInfoList = userWalletDAO.selectRprIdInfoList();
			res.put("rprIdInfoList", rprIdInfoList);
			return res ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			res.putAll(RetCode.buildRetCodeResult(RetCode.DATABASE_EXCEPTION));
			throw e ;
		}
		
	}
	/*
	 * 创建红包范围码
	 */
	public ModelAndView addRedPacketRangeConfigureInfo(Map<String, Object> paramMap) throws Exception {
		try {
			Map<String , Object > res = new HashMap<String, Object>() ;
			ModelAndView mav = new ModelAndView() ;
			MappingJacksonJsonView view = new MappingJacksonJsonView() ;
			AdminVO loginUser = (AdminVO) paramMap.get("loginUser");
			paramMap.put("userName", loginUser.getUserName()) ;
			
			paramMap.put("createDt", DateFormatUtil.CREATE_FULL_DATE_STR_DB());
		
			if (StringUtils.isEmpty(paramMap.get("totalCnt").toString())) {
				res.put("message","总次数不能为空！" );
				res.put("succ", false);
				view.setAttributesMap( res ) ;
				mav.setView(view);
				return mav;
			}
			if (StringUtils.isEmpty(paramMap.get("bkRprId").toString())) {
				paramMap.put("bkRprId", null);
			}
			userWalletDAO.insertRedPacketRangeConfigureInfo(paramMap);
			
			res.put("message", "红包范围码创建成功！");
			res.put("succ", true ) ;
			view.setAttributesMap( res ) ;
			mav.setView(view);
			return mav;
			
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	/*
	 * 删除红包范围码
	 */
	public void deleteRedPacketRangeConfigureInfo(Map<String, Object> paramMap) throws Exception {
		try {
			userWalletDAO.deleteRedPacketRangeConfigureInfo(paramMap) ;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	
	/*
     * 查询支付宝批量支付信息
     */
    public PageInfo<AlipayBatchTransferOrderVO> queryAlipayBatchTransferOrderInfo(
            Map<String, Object> paramMap) throws Exception{
        try {
            PageInfo<AlipayBatchTransferOrderVO> pageInfo = new PageInfo<AlipayBatchTransferOrderVO>();
            paramMap.putAll(PageUtil.buildPage(Integer.valueOf(paramMap.get("pageNow").toString()), Integer.valueOf(paramMap.get("pageSize").toString())));
            List<AlipayBatchTransferOrderVO> alipayBatchTransferOrderInfoList = userWalletDAO.selectAlipayBatchTransferOrderInfoInfoList(paramMap);
            Integer pageCount = userWalletDAO.selectAlipayBatchTransferOrderInfoInfoListTotals(paramMap);
            pageInfo.setDataList(alipayBatchTransferOrderInfoList);
            pageInfo.setDataCount(pageCount);
            pageInfo.setCurrentlyPageNo(Integer.valueOf(paramMap.get("pageNow").toString()));
            pageInfo.setPageSize(Integer.valueOf(paramMap.get("pageSize").toString()));
            return pageInfo;
        } catch (Exception e) {
            logger.error("错误日志 ："  , e );
            throw e ;
        }
    }
	
    /**
     * 提现申请发送成功
     * @param app
     */
   public void doWithdrawSendSuccess(UserWithdrawAppVO app){
	   
	   app.setSendState(UserWithdrawAppConstant.SEND_STATE.SEND_SUCCESS);
		app.setTradeState(UserWithdrawAppConstant.TRADE_STATE.WIDTHDRAWING);
		
		userWalletDAO.updateWithdrawAppTradeState(app) ;
		
    }
   
   /**
     * 提现失败
    * @param app
    */
   public void doWithdrawFail(UserWithdrawAppVO app,String failMsg){
	   UserWalletVO wallet = userWalletDAO.queryUserWalletByAccount(app.getAccount());
		wallet.setFrozenAmt(wallet.getFrozenAmt() - app.getWithdrawAmt());
		userWalletDAO.updateUserWalletAmt(wallet);
		
		app.setSendState(UserWithdrawAppConstant.SEND_STATE.SEND_FAILED);
		app.setTradeState(UserWithdrawAppConstant.TRADE_STATE.WIDTHDRAW_FAIL);
		app.setTradeFailMsg( failMsg );
		userWalletDAO.updateWithdrawAppTradeState(app);
    }


}
