package com.cz.coder.web.dao.entity.vo.privilege;

/**
 * 角色VO
 * @author zhen.cheng
 *
 */
public class RoleVO {

	/**
	 * 角色编号
	 */
	private Integer roleCode ;
	
	/**
	 * 角色名称
	 */
	private String roleName ;
	
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
	
	
	
}
