package com.fq.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fq.dao.BaseDAO;
import com.fq.dao.dao.LoginDAO;
import com.fq.dao.entity.po.MobileCodePO;
import com.fq.dao.entity.vo.MobileCodeVO;
import com.fq.form.login.LoginCheckForm;

/**
 * 
 * @ClassName LoginDaoImpl  
 * @Description 登录实现类  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-2-26
 */
@Repository
public class LoginDaoImpl  extends BaseDAO  implements LoginDAO {

	public MobileCodeVO doQueryMobileCodePO(Map<String, Object> paramMap) {
		// 查询有效期内验证码是否已经发送
		return (MobileCodeVO) getSqlMapClientTemplate().queryForObject( "LoginDaoImpl.selectMobileCodePo" , paramMap );
	}

	public void doInsertMobileCode(MobileCodePO mobileCodePO) {
		// 插入新的短信验证码
		getSqlMapClientTemplate().insert("LoginDaoImpl.insertMobileCode", mobileCodePO) ; 
	}

	@Override
	public void shake() {
		this.getSqlMapClientTemplate().queryForObject("LoginDaoImpl.shake") ;
	}
	

}
