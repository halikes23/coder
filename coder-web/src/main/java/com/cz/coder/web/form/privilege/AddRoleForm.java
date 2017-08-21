package com.cz.coder.web.form.privilege;

/**
 * 添加操作人表单
 * @author zhen.cheng
 *
 */
public class AddRoleForm {

	/**
	 * 操作人账号
	 */
	private String roleName ;

	/**
	 * 创建人编号
	 */
	private Integer creator ;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	
	
}
