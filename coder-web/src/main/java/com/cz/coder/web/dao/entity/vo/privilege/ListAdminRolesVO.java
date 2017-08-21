package com.cz.coder.web.dao.entity.vo.privilege;

/**
 * 操作员角色列表VO
 * @author zhen.cheng
 *
 */
public class ListAdminRolesVO {

	private Integer roleCode ;
	
	private String roleName ;
	
	private boolean checked ;
	
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
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
	
}
