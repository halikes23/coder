package com.codepandas.jscalpel.web.sys.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codepandas.jscalpel.web.sys.dao.AdminDAO;
import com.codepandas.jscalpel.web.sys.entity.vo.LoginVO;
import com.codepandas.jscalpel.web.sys.entity.vo.privilege.AdminVO;
import com.codepandas.jscalpel.web.sys.web.form.login.LoginCheckForm;
import com.cz.coder.common.dao.BaseDAO;

/**
 * 
 * @ClassName AdminDaoImpl  
 * @Description 管理员登录验证  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-2-26
 */
@Repository
public class AdminDaoImpl extends BaseDAO  implements AdminDAO  {

	public AdminVO loginCheck(LoginCheckForm form) {
		return (AdminVO) getSqlMapClientTemplate().queryForObject("AdminDaoImpl.checkLogin",form);
	}

	public AdminVO checkAdminInfo(Map<String, Object> paramMap) {
		return (AdminVO) getSqlMapClientTemplate().queryForObject("AdminDaoImpl.checkAdminInfo" , paramMap);
	}

	public LoginVO doMobileCodeCheck(Map<String,Object> param) {
		return (LoginVO) getSqlMapClientTemplate().queryForObject("AdminDaoImpl.mobileCodeCheck", param);
	}

	@Override
	public Integer updateAdminPsd(Map<String, Object> param) {
		return getSqlMapClientTemplate().update("AdminDaoImpl.updateAdminPsd", param);
	}

	@Override
	public void doDeleteMobileCode(LoginCheckForm form) {
		getSqlMapClientTemplate().delete("AdminDaoImpl.deleteMobileCode" , form) ;
		
	}

	@Override
	public AdminVO selectAdminById(Integer adminId) {
		return (AdminVO)getSqlMapClientTemplate().queryForObject("AdminDaoImpl.selectAdminById",adminId);
	}

	@Override
	public AdminVO checkAdmin(Map<String, Object> paramMap) {
		return (AdminVO) getSqlMapClientTemplate().queryForObject("AdminDaoImpl.checkAdmin" , paramMap);
	}

}