package com.fq.dao.dao;

import java.util.Map;

import com.fq.dao.entity.po.MobileCodePO;
import com.fq.dao.entity.vo.MobileCodeVO;
import com.fq.form.login.LoginCheckForm;

/**
 * 
 * @ClassName LoginDAO  
 * @Description 用户登陆DAO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-2-26
 */
public interface LoginDAO {
	/**
	 * 
	 * @Title: doQueryMobileCodePO 
	 * @Description: 查询短信验证码是否有效
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return MobileCodeVO    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	MobileCodeVO doQueryMobileCodePO(Map<String, Object> paramMap);
	/**
	 * 
	 * @Title: doInsertMobileCode 
	 * @Description: 插入新的短信验证码
	 * @param @param mobileCodePO    设定文件  
	 * @return void    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	void doInsertMobileCode(MobileCodePO mobileCodePO);
	
	void shake();
	
	

}
