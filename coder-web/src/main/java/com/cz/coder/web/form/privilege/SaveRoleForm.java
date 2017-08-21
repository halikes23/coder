package com.fq.form.privilege;

/**
 * 修改角色
 * @author zhen.cheng
 *
 */
public class SaveRoleForm {

	/**
	 * 角色代码
	 */
	private Integer roleCode ;
	
	/**
	 * 角色名称
	 */
	private String roleName ;
	
	/**
	 * 修改人编号
	 */
	private Integer modifier ;

	public Integer getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(Integer roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getModifier() {
		return modifier;
	}

	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}

	
	
}
