package com.codepandas.jscalpel.web.sys.dao.privilege;

import java.util.List;
import java.util.Map;

import com.codepandas.jscalpel.web.sys.entity.po.AdminPO;
import com.codepandas.jscalpel.web.sys.entity.po.RolePO;
import com.codepandas.jscalpel.web.sys.entity.vo.privilege.AdminVO;
import com.codepandas.jscalpel.web.sys.entity.vo.privilege.ListAdminPrivilegesVO;
import com.codepandas.jscalpel.web.sys.entity.vo.privilege.ListAdminRolesVO;
import com.codepandas.jscalpel.web.sys.entity.vo.privilege.ListRolePrivilegesVO;
import com.codepandas.jscalpel.web.sys.entity.vo.privilege.RoleVO;

public interface PrivilegeDAO {

	List<AdminVO> selectAdmin(Map<String, Object> param);

	void insertAdmin(AdminPO po);

	void deleteAdmin(Integer adminId);

	AdminVO selectAdminByUserName(String userName);

	void updateAdmin(AdminPO po);

	List<ListAdminRolesVO> selectRolesWithAdmin(Integer adminId);

	void deleteAdminRoles(Integer adminId);

	void insertAdminRoleRels(Map<String, Object> params);

	List<RoleVO> selectRoles(Map<String, Object> param);

	RoleVO selectRoleByRoleName(String roleName);

	void insertRole(RolePO po);

	void deleteRole(Integer roleCode);

	void deleteAdminRoleRelByRoleCode(Integer roleCode);

	List<ListRolePrivilegesVO> selectPrivilegesWithRole(Integer roleCode);

	void updateRole(RolePO po);

	void deleteRolePrivileges(Integer roleCode);

	void insertRolePriviegeRels(Map<String, Object> params);

	List<ListAdminPrivilegesVO> selectAdminPriviletes(Integer userName);

	List<Map<String, Object>> queryUserRecord(Map<String, Object> paramMap);

	Integer queryUserRecordTotals(Map<String, Object> paramMap);

	void deleteAdminProjectPrivilege(Integer adminId);

}
