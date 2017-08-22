package com.cz.coder.web.dao.impl.privilege;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Repository;

import com.cz.coder.common.dao.BaseDAO;
import com.cz.coder.common.util.JnwtvStringUtils;
import com.cz.coder.web.dao.dao.privilege.PrivilegeDAO;
import com.cz.coder.web.dao.entity.po.AdminPO;
import com.cz.coder.web.dao.entity.po.RolePO;
import com.cz.coder.web.dao.entity.vo.privilege.AdminVO;
import com.cz.coder.web.dao.entity.vo.privilege.ListAdminPrivilegesVO;
import com.cz.coder.web.dao.entity.vo.privilege.ListAdminRolesVO;
import com.cz.coder.web.dao.entity.vo.privilege.ListRolePrivilegesVO;
import com.cz.coder.web.dao.entity.vo.privilege.RoleVO;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * 权限Dao
 * @author zhen.cheng
 *
 */
@Repository
public class PrivilegeDaoImpl extends BaseDAO implements PrivilegeDAO {

	@Override
	public List<AdminVO> selectAdmin(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("PrivilegeDaoImpl.selectAdmin",param);
	}

	public void insertAdmin(AdminPO po){
		getSqlMapClientTemplate().insert("PrivilegeDaoImpl.insertAdmin" , po) ;
	}

	@Override
	public void deleteAdmin(Integer adminId) {
		this.getSqlMapClientTemplate().update("PrivilegeDaoImpl.deleteAdmin",adminId) ;
	}

	@Override
	public AdminVO selectAdminByUserName(String userName) {
		return (AdminVO)this.getSqlMapClientTemplate().queryForObject("PrivilegeDaoImpl.selectAdminByUserName",userName) ;
	}

	@Override
	public void updateAdmin(AdminPO po) {
		this.getSqlMapClientTemplate().update("PrivilegeDaoImpl.updateAdmin",po) ;
		
	}

	@Override
	public List<ListAdminRolesVO> selectRolesWithAdmin(Integer adminId) {
		return this.getSqlMapClientTemplate().queryForList("PrivilegeDaoImpl.selectRolesWithAdmin",adminId);
	}

	@Override
	public void deleteAdminRoles(Integer adminId) {
		this.getSqlMapClientTemplate().delete("PrivilegeDaoImpl.deleteAdminRoles",adminId) ;
	}

	@Override
	public void insertAdminRoleRels(final Map<String, Object> params) {

		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Map<String, Object>>() {

			@Override
			public Map<String, Object> doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				
				String[] rolesCodes = params.get("rolesCodes").toString().split("," , -1) ;
				Integer adminId =  Integer.parseInt( params.get("adminId").toString() ) ;
				Integer creator = Integer.parseInt(params.get("creator").toString()) ;
				executor.startBatch(); 
				for( String roleCode : rolesCodes ){
					if(JnwtvStringUtils.isEmpty(roleCode)){
						continue ;
					}
					Map<String,Object> adminRoleRel = new HashMap<String,Object>() ;
					adminRoleRel.put("adminId",adminId);
					adminRoleRel.put("roleCode", Integer.parseInt(roleCode)) ;
					adminRoleRel.put("creator", creator) ;
					executor.insert("PrivilegeDaoImpl.insertAdminRoleRels",adminRoleRel) ;
					
				}
				
				executor.executeBatch() ;
				
				return null;
			}
			
			
		}) ;
		
	}

	@Override
	public List<RoleVO> selectRoles(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("PrivilegeDaoImpl.selectRoles",param);
	}

	@Override
	public RoleVO selectRoleByRoleName(String roleName) {
		return (RoleVO)this.getSqlMapClientTemplate().queryForObject("PrivilegeDaoImpl.selectRoleByRoleName",roleName);
	}

	@Override
	public void insertRole(RolePO po) {
		this.getSqlMapClientTemplate().insert("PrivilegeDaoImpl.insertRole",po) ;
		
	}

	@Override
	public void deleteRole(Integer roleCode) {
		this.getSqlMapClientTemplate().update("PrivilegeDaoImpl.deleteRole",roleCode);
		
	}

	@Override
	public void deleteAdminRoleRelByRoleCode(Integer roleCode) {
		this.getSqlMapClientTemplate().delete("PrivilegeDaoImpl.deleteAdminRoleRelByRoleCode",roleCode) ;
	}

	@Override
	public List<ListRolePrivilegesVO> selectPrivilegesWithRole(Integer roleCode) {
		return this.getSqlMapClientTemplate().queryForList("PrivilegeDaoImpl.selectPrivilegesWithRole",roleCode);
	}

	@Override
	public void updateRole(RolePO po) {
		this.getSqlMapClientTemplate().update("PrivilegeDaoImpl.updateRole" , po);
	}

	@Override
	public void deleteRolePrivileges(Integer roleCode) {
		this.getSqlMapClientTemplate().delete("PrivilegeDaoImpl.deleteRolePrivileges" , roleCode) ;
		
	}

	@Override
	public void insertRolePriviegeRels(final Map<String, Object> params) {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Map<String, Object>>() {

			@Override
			public Map<String, Object> doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				
				String[] privilegesCodes = params.get("privilegesCodes").toString().split("," , -1) ;
				Integer roleCode =  Integer.parseInt( params.get("roleCode").toString() ) ;
				Integer creator = Integer.parseInt(params.get("creator").toString()) ;
				executor.startBatch(); 
				for( String privCode : privilegesCodes ){
					if(JnwtvStringUtils.isEmpty(privCode)){
						continue ;
					}
					Map<String,Object> rolePrivilegeRel = new HashMap<String,Object>() ;
					rolePrivilegeRel.put("privCode",privCode);
					rolePrivilegeRel.put("roleCode", roleCode) ;
					rolePrivilegeRel.put("creator", creator) ;
					executor.insert("PrivilegeDaoImpl.insertRolePriviegeRels",rolePrivilegeRel) ;
					
				}
				
				executor.executeBatch() ;
				
				return null;
			}
			
			
		}) ;
		
	}

	@Override
	public List<ListAdminPrivilegesVO> selectAdminPriviletes(Integer adminId) {
		
		return this.getSqlMapClientTemplate().queryForList("PrivilegeDaoImpl.selectAdminPriviletes",adminId);
	}

	@Override
	public List<Map<String, Object>> queryUserRecord(Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("PrivilegeDaoImpl.selectUserRecord",paramMap);
	}

	@Override
	public Integer queryUserRecordTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("PrivilegeDaoImpl.selectUserRecordTotals",paramMap);
	}


	@Override
	public void deleteAdminProjectPrivilege(Integer adminId) {
		getSqlMapClientTemplate().delete("PrivilegeDaoImpl.deleteAdminProjectPrivilege",adminId);
	}

}
