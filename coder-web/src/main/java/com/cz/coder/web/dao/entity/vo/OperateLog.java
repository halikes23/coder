package com.fq.dao.entity.vo;

import com.fq.dao.entity.vo.privilege.AdminVO;

/**
 * 操作员操作记录日志实体类
 * @author Administrator
 *
 */
public class OperateLog {
	private String servletPath;
	private AdminVO loginUser;
	private String resStatus;
	private String params ;
	
	public String getServletPath() {
		return servletPath;
	}
	public void setServletPath(String servletPath) {
		this.servletPath = servletPath;
	}
	public String getResStatus() {
		return resStatus;
	}
	public void setResStatus(String resStatus) {
		this.resStatus = resStatus;
	}
	public AdminVO getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(AdminVO loginUser) {
		this.loginUser = loginUser;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	
	
}
