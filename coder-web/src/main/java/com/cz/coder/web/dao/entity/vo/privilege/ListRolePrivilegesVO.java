package com.fq.dao.entity.vo.privilege;

import java.util.List;

public class ListRolePrivilegesVO {
	
	private String privCode ;
	
	private String privName ;
	
	private String parentPrivCode ;
	
	private List<ListRolePrivilegesVO> children ;
	
	private boolean checked ;

	public String getPrivCode() {
		return privCode;
	}

	public void setPrivCode(String privCode) {
		this.privCode = privCode;
	}

	public String getPrivName() {
		return privName;
	}

	public void setPrivName(String privName) {
		this.privName = privName;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<ListRolePrivilegesVO> getChildren() {
		return children;
	}

	public void setChildren(List<ListRolePrivilegesVO> children) {
		this.children = children;
	}

	public String getParentPrivCode() {
		return parentPrivCode;
	}

	public void setParentPrivCode(String parentPrivCode) {
		this.parentPrivCode = parentPrivCode;
	}
	
	
	
}
