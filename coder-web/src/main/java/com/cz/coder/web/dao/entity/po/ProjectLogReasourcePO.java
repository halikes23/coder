package com.fq.dao.entity.po;
/*
 * 项目日志资源帖，资源实体类封装
 */
public class ProjectLogReasourcePO {
	
		private Integer pliId ;//日志Id
		private String resLink ; //资源链接
		private String createDt ;//上传日期
		
		
		public Integer getPliId() {
			return pliId;
		}
		public void setPliId(Integer pliId) {
			this.pliId = pliId;
		}
		public String getResLink() {
			return resLink;
		}
		public void setResLink(String resLink) {
			this.resLink = resLink;
		}
		public String getCreateDt() {
			return createDt;
		}
		public void setCreateDt(String createDt) {
			this.createDt = createDt;
		}
}
