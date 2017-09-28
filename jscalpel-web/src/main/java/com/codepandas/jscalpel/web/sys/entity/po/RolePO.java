package com.codepandas.jscalpel.web.sys.entity.po;

/**
 * 角色PO
 * @author zhen.cheng
 *
 */
public class RolePO {
	/**
	 * 角色编号
	 */
	private Integer roleCode ;
	/**
	 * 角色名称
	 */
	private String roleName  ;
	/**
	 * 创建人
	 */
	private Integer creator ;
	/**
	 * 修改人
	 */
	private Integer modifier ;
	
	private String modDt ;
	
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
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public Integer getModifier() {
		return modifier;
	}
	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}
	public String getModDt() {
		return modDt;
	}
	public void setModDt(String modDt) {
		this.modDt = modDt;
	}
	
	
}
