package com.fq.dao.entity.po;


/**
 * 对账信息
 * @author Administrator
 *
 */
public class TradeAppInfoPO {
		private Integer taId;   //对账主键
		private String entityNo;  //实体编号
		private String  entityType;  //实体类型（1：个人，2：项目）
		private Integer appVol;      //据点量
		private String  appDt;		//YYYYMMDD
		private String  appTm;		//HHMMSS
		private String  cdkey;		//cdkey
		private String  busiCode;	//类型 1:个人打赏给个人  ,2 , 个人被打赏   3,个人打赏项目 ， 4，项目被打赏   5:每日登录奖励 , 6:注册 , 7:充值据点
		private String  contractNo;	//合同号
		
		public Integer getTaId() {
			return taId;
		}
		public void setTaId(Integer taId) {
			this.taId = taId;
		}
		public String getEntityNo() {
			return entityNo;
		}
		public void setEntityNo(String entityNo) {
			this.entityNo = entityNo;
		}
		public String getEntityType() {
			return entityType;
		}
		public void setEntityType(String entityType) {
			this.entityType = entityType;
		}
		public Integer getAppVol() {
			return appVol;
		}
		public void setAppVol(Integer appVol) {
			this.appVol = appVol;
		}
		public String getAppDt() {
			return appDt;
		}
		public void setAppDt(String appDt) {
			this.appDt = appDt;
		}
		public String getAppTm() {
			return appTm;
		}
		public void setAppTm(String appTm) {
			this.appTm = appTm;
		}
		public String getCdkey() {
			return cdkey;
		}
		public void setCdkey(String cdkey) {
			this.cdkey = cdkey;
		}
		public String getBusiCode() {
			return busiCode;
		}
		public void setBusiCode(String busiCode) {
			this.busiCode = busiCode;
		}
		public String getContractNo() {
			return contractNo;
		}
		public void setContractNo(String contractNo) {
			this.contractNo = contractNo;
		}
}
