package com.cz.coder.web.dao.dao;

import java.util.Map;

import com.cz.coder.web.dao.entity.vo.LoginVO;
import com.cz.coder.web.dao.entity.vo.privilege.AdminVO;
import com.cz.coder.web.form.login.LoginCheckForm;

/**
 * 
 * @ClassName AdminDAO  
 * @Description   
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-1-31
 */
public interface AdminDAO { 

    /**
     * 判断用户名和密码
     */
	public AdminVO loginCheck(LoginCheckForm form);
	/**
	 * 
	 * @Title: checkAdminInfo 
	 * @Description: 检查管理员信息
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return AdminVO    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public AdminVO checkAdminInfo(Map<String, Object> paramMap);
	/**
	 * 
	 * @Title: doMobileCodeCheck 
	 * @Description: 验证短信验证码是否有效
	 * @param @param loginPO
	 * @param @return    设定文件  
	 * @return LoginVO    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public LoginVO doMobileCodeCheck(Map<String,Object> param);
	
	public Integer updateAdminPsd(Map<String,Object> param) ;
	
	public void doDeleteMobileCode(LoginCheckForm form);
	
	public AdminVO selectAdminById(Integer adminId);
	
	public AdminVO checkAdmin(Map<String, Object> paramMap);
}