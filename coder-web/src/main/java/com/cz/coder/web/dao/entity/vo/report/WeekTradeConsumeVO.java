package com.fq.dao.entity.vo.report;

/**
 * 交易消費統計對象
 * @author zhen.cheng
 *
 */
public class WeekTradeConsumeVO {
	
	/**
	 * 创建日期
	 */
	private String createDate ;
	
	/**
	 * 报表日期
	 */
	private String reportDate ;

//	`funding_user_cnt` 		INT(11) NULL DEFAULT NULL COMMENT '凑份子人数'
	private Integer fundingUserCnt ;
	
//	`funding_jpoint_cnt` INT(11) NULL DEFAULT NULL COMMENT '凑份子剧点数'
	private Integer fundingJpointCnt ;
	
//	`funding_user_cnt_wt` INT(11) NULL DEFAULT NULL COMMENT '凑份子人数（充过值的）'
	private Integer fundingUserCntWt ;
	
//	`funding_jpoint_cnt_wt` INT(11) NULL DEFAULT NULL COMMENT '凑份子据点数（充过值的）'
	private Integer fundingJpointCntWt ;
	
//	`lvc_unlock_cnt` INT(11) NULL DEFAULT NULL COMMENT '真人漫解锁次数'
	private Integer lvcUnlockCnt ;
	
//	`lvc_unlock_user_cnt` INT(11) NULL DEFAULT NULL COMMENT '真人漫解锁人数'
	private Integer lvcUnlockUserCnt ;
	
//	`lvc_unlock_jpoint_cnt` INT(11) NOT NULL COMMENT '真人漫解锁剧点数'
	private Integer lvcUnlockJpointCnt ;
	
//	`lvc_unlock_cnt_wt` INT(11) NULL DEFAULT NULL COMMENT '真人漫解锁次数（充过值的）'
	private Integer lvcUnlockCntWt ;
	
//	`lvc_unlock_user_cnt_wt` INT(11) NULL DEFAULT NULL COMMENT '真人漫解锁人数（充过值的）'
	private Integer lvcUnlockUserCntWt ;
	
//	`lvc_unlock_jpoint_cnt_wt` INT(11) NULL DEFAULT NULL COMMENT '真人漫解锁剧点数（充过值的）'
	private Integer lvcUnlockJpointCntWt ;
	
//	`gift_giving_user_cnt` INT(11) NULL DEFAULT NULL COMMENT '送礼人数'
	private Integer giftGivingUserCnt ;
	
//	`gift_giving_jpoint_cnt` INT(11) NULL DEFAULT NULL COMMENT '送礼剧点数'\
	private Integer giftGivingJpointCnt ;

	//	`gift_giving_user_cnt_wt` INT(11) NULL DEFAULT NULL COMMENT '送礼人数（充过值的）'
	private Integer giftGivingUserCntWt ;
	
//	`gift_giving_jpoint_cnt_wt` INT(11) NULL DEFAULT NULL COMMENT '送礼剧点数（充过值的）'
	private Integer giftGivingJpointCntWt ;
	
//	`trade_user_cnt` INT(11) NULL DEFAULT NULL COMMENT '充值人数'
	private Integer tradeUserCnt ;
	
//	`trade_jpoint_cnt` INT(11) NULL DEFAULT NULL COMMENT '充值剧点数'
	private Integer tradeJpointCnt ;
	
//	`wallpaper_unlock_cnt` INT(11) NULL DEFAULT NULL COMMENT '壁纸解锁人数'
	private Integer wallpaperUnlockCnt ;
	
//	`wallpaper_unlock_jpoint_cnt` INT(11) NULL DEFAULT NULL COMMENT '壁纸解锁据点数'
	private Integer wallpaperUnlockJpointCnt ;
	
//	`wallpaper_unlock_cnt_wt` INT(11) NULL DEFAULT NULL COMMENT '壁纸解锁人数(充过值的)'
	private Integer wallpaperUnlockCntWt ;
	
//	`wallpaper_unlock_jpoint_cnt_wt` INT(11) NULL DEFAULT NULL COMMENT '壁纸解锁据点数（充过值的）'
	private Integer wallpaperUnlockJpointCntWt ;
	

	public Integer getWallpaperUnlockCntWt() {
		return wallpaperUnlockCntWt;
	}

	public void setWallpaperUnlockCntWt(Integer wallpaperUnlockCntWt) {
		this.wallpaperUnlockCntWt = wallpaperUnlockCntWt;
	}

	public Integer getWallpaperUnlockJpointCntWt() {
		return wallpaperUnlockJpointCntWt;
	}

	public void setWallpaperUnlockJpointCntWt(Integer wallpaperUnlockJpointCntWt) {
		this.wallpaperUnlockJpointCntWt = wallpaperUnlockJpointCntWt;
	}

	public Integer getWallpaperUnlockCnt() {
		return wallpaperUnlockCnt;
	}

	public void setWallpaperUnlockCnt(Integer wallpaperUnlockCnt) {
		this.wallpaperUnlockCnt = wallpaperUnlockCnt;
	}


	public Integer getWallpaperUnlockJpointCnt() {
		return wallpaperUnlockJpointCnt;
	}

	public void setWallpaperUnlockJpointCnt(Integer wallpaperUnlockJpointCnt) {
		this.wallpaperUnlockJpointCnt = wallpaperUnlockJpointCnt;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getFundingUserCnt() {
		return fundingUserCnt;
	}

	public void setFundingUserCnt(Integer fundingUserCnt) {
		this.fundingUserCnt = fundingUserCnt;
	}


	public Integer getFundingJpointCnt() {
		return fundingJpointCnt;
	}

	public void setFundingJpointCnt(Integer fundingJpointCnt) {
		this.fundingJpointCnt = fundingJpointCnt;
	}

	public Integer getFundingUserCntWt() {
		return fundingUserCntWt;
	}

	public void setFundingUserCntWt(Integer fundingUserCntWt) {
		this.fundingUserCntWt = fundingUserCntWt;
	}

	public Integer getFundingJpointCntWt() {
		return fundingJpointCntWt;
	}

	public void setFundingJpointCntWt(Integer fundingJpointCntWt) {
		this.fundingJpointCntWt = fundingJpointCntWt;
	}

	public Integer getLvcUnlockCnt() {
		return lvcUnlockCnt;
	}

	public void setLvcUnlockCnt(Integer lvcUnlockCnt) {
		this.lvcUnlockCnt = lvcUnlockCnt;
	}

	public Integer getLvcUnlockUserCnt() {
		return lvcUnlockUserCnt;
	}

	public void setLvcUnlockUserCnt(Integer lvcUnlockUserCnt) {
		this.lvcUnlockUserCnt = lvcUnlockUserCnt;
	}

	public Integer getLvcUnlockJpointCnt() {
		return lvcUnlockJpointCnt;
	}

	public void setLvcUnlockJpointCnt(Integer lvcUnlockJpointCnt) {
		this.lvcUnlockJpointCnt = lvcUnlockJpointCnt;
	}

	public Integer getLvcUnlockCntWt() {
		return lvcUnlockCntWt;
	}

	public void setLvcUnlockCntWt(Integer lvcUnlockCntWt) {
		this.lvcUnlockCntWt = lvcUnlockCntWt;
	}

	public Integer getLvcUnlockUserCntWt() {
		return lvcUnlockUserCntWt;
	}

	public void setLvcUnlockUserCntWt(Integer lvcUnlockUserCntWt) {
		this.lvcUnlockUserCntWt = lvcUnlockUserCntWt;
	}

	public Integer getLvcUnlockJpointCntWt() {
		return lvcUnlockJpointCntWt;
	}

	public void setLvcUnlockJpointCntWt(Integer lvcUnlockJpointCntWt) {
		this.lvcUnlockJpointCntWt = lvcUnlockJpointCntWt;
	}

	public Integer getGiftGivingUserCnt() {
		return giftGivingUserCnt;
	}

	public void setGiftGivingUserCnt(Integer giftGivingUserCnt) {
		this.giftGivingUserCnt = giftGivingUserCnt;
	}

	public Integer getGiftGivingJpointCnt() {
		return giftGivingJpointCnt;
	}

	public void setGiftGivingJpointCnt(Integer giftGivingJpointCnt) {
		this.giftGivingJpointCnt = giftGivingJpointCnt;
	}

	public Integer getGiftGivingUserCntWt() {
		return giftGivingUserCntWt;
	}

	public void setGiftGivingUserCntWt(Integer giftGivingUserCntWt) {
		this.giftGivingUserCntWt = giftGivingUserCntWt;
	}

	public Integer getGiftGivingJpointCntWt() {
		return giftGivingJpointCntWt;
	}

	public void setGiftGivingJpointCntWt(Integer giftGivingJpointCntWt) {
		this.giftGivingJpointCntWt = giftGivingJpointCntWt;
	}

	public Integer getTradeUserCnt() {
		return tradeUserCnt;
	}

	public void setTradeUserCnt(Integer tradeUserCnt) {
		this.tradeUserCnt = tradeUserCnt;
	}

	public Integer getTradeJpointCnt() {
		return tradeJpointCnt;
	}

	public void setTradeJpointCnt(Integer tradeJpointCnt) {
		this.tradeJpointCnt = tradeJpointCnt;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	
	
	
}
