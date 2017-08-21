package com.fq.dao.entity.vo.project;


/**
 * 剧组信息列表
 * @author Administrator
 *
 */
public class ProjectCrewInfoVO {
		private Integer cId;   //剧组id
		private Integer piId;   //项目id
		private String actorAccount;  //演员账号
		private String userNick;	//用户昵称
		private String rachelRole;  //饰演角色
		private Integer actorOrder;   //演员顺序
		private String  havePrivilege;  //Y：有权限发送剧圈 N：没有权限发送剧圈
		
		public Integer getCId() {
			return cId;
		}
		public void setCId(Integer cId) {
			this.cId = cId;
		}
		public Integer getPiId() {
			return piId;
		}
		public void setPiId(Integer piId) {
			this.piId = piId;
		}
		public String getActorAccount() {
			return actorAccount;
		}
		public void setActorAccount(String actorAccount) {
			this.actorAccount = actorAccount;
		}
		public String getUserNick() {
			return userNick;
		}
		public void setUserNick(String userNick) {
			this.userNick = userNick;
		}
		public String getRachelRole() {
			return rachelRole;
		}
		public void setRachelRole(String rachelRole) {
			this.rachelRole = rachelRole;
		}
		public Integer getcId() {
			return cId;
		}
		public void setcId(Integer cId) {
			this.cId = cId;
		}
		public Integer getActorOrder() {
			return actorOrder;
		}
		public void setActorOrder(Integer actorOrder) {
			this.actorOrder = actorOrder;
		}
		public String getHavePrivilege() {
			return havePrivilege;
		}
		public void setHavePrivilege(String havePrivilege) {
			this.havePrivilege = havePrivilege;
		}
		
		
		
}
