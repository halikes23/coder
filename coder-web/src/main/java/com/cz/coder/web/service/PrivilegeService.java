package com.fq.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.common.constant.RetCode;
import com.fq.dao.dao.privilege.PrivilegeDAO;
import com.fq.dao.entity.po.AdminPO;
import com.fq.dao.entity.po.RolePO;
import com.fq.dao.entity.vo.OperateLog;
import com.fq.dao.entity.vo.privilege.AdminVO;
import com.fq.dao.entity.vo.privilege.ListAdminPrivilegesVO;
import com.fq.dao.entity.vo.privilege.ListAdminRolesVO;
import com.fq.dao.entity.vo.privilege.ListRolePrivilegesVO;
import com.fq.dao.entity.vo.privilege.RoleVO;
import com.fq.dao.entity.vo.project.PurviewProjectInfo;
import com.fq.form.privilege.AddAdminForm;
import com.fq.form.privilege.AddRoleForm;
import com.fq.form.privilege.SaveAdminForm;
import com.fq.form.privilege.SaveAdminProjectPrivilegeForm;
import com.fq.form.privilege.SaveAdminRolesForm;
import com.fq.form.privilege.SaveRoleForm;
import com.fq.form.privilege.SaveRolePrivilegesForm;
import com.fq.util.JnwtvStringUtils;
import com.fq.util.MD5Util;
import com.fq.util.page.PageInfo;
import com.fq.util.page.PageUtil;


/**
 * 权限service
 * @author zhen.cheng
 *
 */

@Service
public class PrivilegeService {

	private final static Logger logger = LoggerFactory.getLogger(PrivilegeService.class) ;

	private final static String DEFAULT_PASSWORD = MD5Util.encrypt("1") ;
	
	@Autowired
	private PrivilegeDAO privilegeDAO ;
	
	/**
	 * 查询所有操作员
	 * @param param
	 * @return
	 */
	public List<AdminVO> queryAllAdmin(Map<String,Object> param) {
		
		List<AdminVO> admins = privilegeDAO.selectAdmin(param);
		
		return admins ;
		
	}

	/**
	 * 添加操作员
	 * @param form
	 * @return
	 */
	public String addAdmin(AddAdminForm form) {
		
		
		
		try{
			
			AdminVO admin = privilegeDAO.selectAdminByUserName(form.getUserName());
			
			if( admin != null ){
				return RetCode.ADMIN_HAS_EXISTS ;
			}
			
			AdminPO po = new AdminPO() ;
			
			po.setAdminName(form.getUserName());
			po.setRealName(form.getRealName());
			po.setAdminPhone(form.getPhone());
			
			//新增
			po.setMail(form.getMail());
			
			po.setPwd(DEFAULT_PASSWORD);
			privilegeDAO.insertAdmin(po);
			
			return RetCode.SUCCESS ;
			
		}catch(Exception e){
			logger.error("",e);
			return RetCode.SYSTEM_ERROR ;
		}
		
		
	}

	/**
	 * 删除操作员
	 * @param adminId
	 * @return
	 */
	public String removeAdmin(Integer adminId) {
		try{
			this.privilegeDAO.deleteAdmin(adminId);
			return RetCode.SUCCESS ;
		}catch(Exception e){
			logger.error("",e);
			return RetCode.DATABASE_EXCEPTION ;
		}
	}

	public String saveAdmin(SaveAdminForm form) {

		try{
			AdminPO po = new AdminPO() ;
			po.setaId(form.getAdminId());
			po.setRealName(form.getRealName() == null ? "" : form.getRealName());
			po.setAdminPhone(form.getAdminPhone());
			po.setMail(form.getMail());
			
			this.privilegeDAO.updateAdmin(po);
			return RetCode.SUCCESS ;
		}catch(Exception e){
			logger.error("",e);
			return RetCode.DATABASE_EXCEPTION ;
		}
	}

	public List<ListAdminRolesVO> listAdminRoles(Integer adminId) {
		return this.privilegeDAO.selectRolesWithAdmin(adminId);
	}

	public String doSaveAdminRoles(SaveAdminRolesForm form) {
		try{
			this.privilegeDAO.deleteAdminRoles(form.getAdminId());
			Map<String,Object> params = new HashMap<String,Object>() ;
			params.put("creator", form.getCreator());
			params.put("adminId", form.getAdminId()) ;
			params.put("rolesCodes", form.getRolesCodes()) ;
			this.privilegeDAO.insertAdminRoleRels( params);
			return RetCode.SUCCESS ;
		}catch(Exception e){
			logger.error("",e);
			return RetCode.DATABASE_EXCEPTION ;
		}
	}

	public List<RoleVO> queryAllRoles(Map<String, Object> param) {
		return this.privilegeDAO.selectRoles(param);
	}

	public String addRole(AddRoleForm form) {
		try{
			
			RoleVO role = privilegeDAO.selectRoleByRoleName(form.getRoleName());
			
			if( role != null ){
				return RetCode.ROLE_HAS_EXISTS ;
			}
			
			RolePO po = new RolePO() ;
			
			po.setRoleName(form.getRoleName());
			po.setCreator(form.getCreator());
			privilegeDAO.insertRole(po);
			
			return RetCode.SUCCESS ;
			
		}catch(Exception e){
			logger.error("",e);
			return RetCode.SYSTEM_ERROR ;
		}
	}

	public String doRemoveRole(Integer roleCode) {
		try{
			this.privilegeDAO.deleteRole(roleCode);
			this.privilegeDAO.deleteAdminRoleRelByRoleCode(roleCode);
			return RetCode.SUCCESS ;
		}catch(Exception e){
			logger.error("",e);
			return RetCode.DATABASE_EXCEPTION ;
		}
	}

	public List<ListRolePrivilegesVO> queryRolePrivileges(Integer roleCode) {
		
		List<ListRolePrivilegesVO> privileges = privilegeDAO.selectPrivilegesWithRole(roleCode) ;
		
		List<ListRolePrivilegesVO> topPrivileges = new ArrayList<ListRolePrivilegesVO>() ;
		
		for(ListRolePrivilegesVO priv : privileges){
			if( StringUtils.isEmpty(priv.getParentPrivCode()) ){
				priv.setChildren(new ArrayList<ListRolePrivilegesVO>());
				topPrivileges.add(priv) ;
			}
		}
		
		for(ListRolePrivilegesVO top : topPrivileges){
			for(ListRolePrivilegesVO priv : privileges){
				if(!StringUtils.isEmpty(priv.getParentPrivCode())){
					if( StringUtils.equals(top.getPrivCode(), priv.getParentPrivCode()) ){
						top.getChildren().add(priv) ;
					}
				}
			}
		}
		
		
		return topPrivileges;
	}

	public String doSaveRole(SaveRoleForm form) {
		RolePO po = new RolePO() ;
		po.setRoleCode(form.getRoleCode());
		po.setRoleName(form.getRoleName());
		po.setModifier(form.getModifier());
		
		try{
			this.privilegeDAO.updateRole(po);
			return RetCode.SUCCESS ;
		}catch(Exception e){
			logger.error("",e);
			return RetCode.DATABASE_EXCEPTION ;
		}
		
	}

	public String doSaveRolePrivileges(SaveRolePrivilegesForm form) {
		try{
			this.privilegeDAO.deleteRolePrivileges(form.getRoleCode()) ;
			if(JnwtvStringUtils.isEmpty(form.getPrivilegesCodes())){
				return RetCode.SUCCESS ;
			}
			Map<String,Object> params = new HashMap<String,Object>() ;
			params.put("creator", form.getCreator()) ;
			params.put("privilegesCodes", form.getPrivilegesCodes());
			params.put("roleCode", form.getRoleCode());
			this.privilegeDAO.insertRolePriviegeRels(params);
			return RetCode.SUCCESS ;
		}catch(Exception e){
			logger.error("",e);
			return RetCode.DATABASE_EXCEPTION ;
		}
	}

	public List<ListAdminPrivilegesVO> calAdminPriviletes(Integer userName) {
		return this.privilegeDAO.selectAdminPriviletes(userName);
	}

	public PageInfo<Map<String, Object>> queryUserOperateLogger(Map<String, Object> paramMap) {
		try {
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>();
			
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			
			// 获取操作人操作记录
			List<Map<String , Object>> userRecordings = privilegeDAO.queryUserRecord(paramMap);
			
			Integer pageCount = privilegeDAO.queryUserRecordTotals(paramMap) ;
			pageInfo.setDataList( userRecordings ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志" , e);
			throw e ; 
		}
	}

	/**
	 * 查询所有项目信息
	 * @return
	 */
	public List<PurviewProjectInfo> queryAllPurviewProjectInfo(Integer adminId) throws Exception {
		try {
			//查出具有该用户具有的项目权限
			List<PurviewProjectInfo> purviewProjectList =  privilegeDAO.queryAllPurviewProjectInfo(adminId);
			
			//查出所有项目
			List<PurviewProjectInfo> projectList = privilegeDAO.queryAllProjectInfo();
			
			if( purviewProjectList == null || purviewProjectList.size() == 0 ){
				for(PurviewProjectInfo projectInfoVO : projectList){
					projectInfoVO.setChecked(false);
				}
				return projectList;
			}

			A:for (PurviewProjectInfo projectInfo : projectList) {
				for (PurviewProjectInfo purviewProjectInfo : purviewProjectList) {
					if( purviewProjectInfo.getPiId().equals(projectInfo.getPiId()) ){
						projectInfo.setChecked(true);
						continue A;
					}else{
						projectInfo.setChecked(false);
					}
				}
			}
			
			return projectList;
		} catch (Exception e) {
			logger.error("错误日志:", e);
			throw e ;
		}
	}

	/**
	 * 保存用户查看项目权限
	 * @param form
	 * @return
	 */
	public String doSaveAdminProjectPrivilege(SaveAdminProjectPrivilegeForm form) {
		try {
			
			privilegeDAO.deleteAdminProjectPrivilege(form.getAdminId());
			
			if( "".equals(form.getPiIds()) ){
				return RetCode.SUCCESS;
			}
			privilegeDAO.insertAdminProjectPrivilege(form);
			
			return RetCode.SUCCESS;
		} catch (Exception e) {
			logger.error("错误日志:", e);
			throw e ;
		}
	}

	public OperateLog getLogParams(Integer logId) {
		return this.privilegeDAO.queryLogInfoByLogId(logId);
	}

}
