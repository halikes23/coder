package com.cz.coder.web.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.cz.coder.common.constant.RetCode;
import com.cz.coder.common.util.DateFormatUtil;
import com.cz.coder.common.util.JnwtvStringUtils;
import com.cz.coder.web.common.constant.CoderWebConstant;
import com.cz.coder.web.common.exception.BusinessException;
import com.cz.coder.web.common.properties.GlobalProperties;
import com.cz.coder.web.dao.dao.AdminDAO;
import com.cz.coder.web.dao.dao.LoginDAO;
import com.cz.coder.web.dao.entity.po.MobileCodePO;
import com.cz.coder.web.dao.entity.vo.LoginVO;
import com.cz.coder.web.dao.entity.vo.MobileCodeVO;
import com.cz.coder.web.dao.entity.vo.privilege.AdminVO;
import com.cz.coder.web.web.form.login.ChgPsdForm;
import com.cz.coder.web.web.form.login.LoginCheckForm;
import com.fq.message.sender.CLSmsSender;
import com.fq.message.sender.IMessageSender;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO ; 
	@Autowired
	private AdminDAO adminDAO ;
	@Autowired
	private CLSmsSender cLSmsSender;
	
	@Autowired
	private IMessageSender<String[]> mailSender ;
	
	private static final Logger logger = LoggerFactory.getLogger( LoginService.class ) ;
	/**
	 * 
	 * @Title: createMobileCode 
	 * @Description: 发送短信验证码
	 * @param @param paramMap
	 * @param @return    设定文件  
	 * @return ModelAndView    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public ModelAndView createMobileCode(Map<String, Object> paramMap) throws Exception {
		Map<String , Object> model = new HashMap<String, Object>() ;
		ModelAndView mav = new ModelAndView() ;
		MappingJacksonJsonView view = new MappingJacksonJsonView() ; 
		
		try{
			//验证管理员身份是否存在
			final AdminVO adminVO = adminDAO.checkAdminInfo( paramMap ) ; 
			if ( null == adminVO ) {
				// 管理员不存在
				model.put("message", "用户不存在");
				model.put("succ", false ) ;
				view.setAttributesMap( model ) ;
				mav.setView(view);
				return mav;
			}
			
			// 验证有效期内是否有有效的短信验证码
			Integer validityOfCode =  CoderWebConstant.VALIDITY_OF_MOBILE_CODE ; 
			paramMap.put("validityOfMobileCode",  validityOfCode );
			MobileCodeVO mobileCodeVO = loginDAO.doQueryMobileCodePO(paramMap) ;
			String mobileCode = null ;
			if ( mobileCodeVO != null && null != mobileCodeVO.getMobileCode() ) { // 若存在发送旧的短信验证码
				mobileCode =  mobileCodeVO.getMobileCode() ;
			}else { // 若不存在发送新的短息验证码，并把新的短信验证码存入数据库
				mobileCode =  String.format("%04d" , Math.round( Math.random() * 9999 ) ) ;
				MobileCodePO mobileCodePO = new MobileCodePO();
				// 先把验证码存储到数据库
				mobileCodePO.setMobileCode(mobileCode);
				mobileCodePO.setUserMobile(adminVO.getAdminPhone()) ;
				mobileCodePO.setSendDate(DateFormatUtil.CREATE_FULL_DATE_STR_DB()) ;
				mobileCodePO.setUserName(paramMap.get("userName").toString()) ;
				loginDAO.doInsertMobileCode(mobileCodePO);
//				loginDAO.doDeleteMobileCode(mobileCodePO);
				
			}
			
			
			cLSmsSender.send(StringUtils.EMPTY, mobileCode+GlobalProperties.SMS_MSG_CONSOLE, adminVO.getAdminPhone());
			logger.info(   adminVO.getAdminPhone() + "验证码：" + mobileCode);
			model.put("message", "验证码已发送至:"+ adminVO.getAdminPhone() );
			
			model.put("succ", true ) ;
			view.setAttributesMap( model ) ;
			mav.setView(view);
			return mav;
		}catch(Exception e){
			logger.error("发送验证码失败" , e) ;
			throw e ;
		}
		
	}
	
	/**
	 * @param request 
	 * @param model 
	 * 
	 * @Title: doLoginChcek 
	 * @Description: 登录验证
	 * @param @param paramMap
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return ModelAndView    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	public AdminVO doLoginChcek(LoginCheckForm form) throws BusinessException {
		
		try {
			
			// 检查登陆密码是否正确
			AdminVO admin = adminDAO.loginCheck(form);
			
			/*if (admin == null) {
				throw new BusinessException(RetCode.WRONG_PASSWORD ) ;
			}*/
			if(StringUtils.equals(GlobalProperties.IS_DEBUG, "0") ){
				Map<String,Object> param = new HashMap<String,Object>() ;
				param.put("adminName", form.getUserName()) ;
				param.put("mobileCode", form.getMobileCode()) ;
				
				Integer validityOfCode =  CoderWebConstant.VALIDITY_OF_MOBILE_CODE ; 
				param.put("validityOfMobileCode",  validityOfCode );
				DateFormatUtil.CREATE_FULL_DATE_STR_DB();
				param.put("now",  DateFormatUtil.CREATE_FULL_DATE_STR_DB());
				// 检查验证码是否正确
				LoginVO loginVO = adminDAO.doMobileCodeCheck(param);
				if (loginVO ==  null ) {
					// TODO
//					throw new BusinessException(RetCode.MOBILE_CODE_CHECK_WRONG ) ;
				}
			}
				
			//验证完成之后删除当前验证码,验证码失效
			adminDAO.doDeleteMobileCode(form);
			return admin ;
			
		} catch(BusinessException e){
			throw e ;
		}catch (Exception e) {
			logger.error("登录失败", e ) ;
			throw e ;
			
		}
		
	}
	
	public String doChangePsd(ChgPsdForm chgPsdForm){
		
		if( JnwtvStringUtils.isEmpty(chgPsdForm.getAdminName() ) ||
			JnwtvStringUtils.isEmpty(chgPsdForm.getNewPsd()) ||
			JnwtvStringUtils.isEmpty(chgPsdForm.getNewPsd())){
			return RetCode.CANNOT_NULL ;
		}
		
		Map<String,Object> param = new HashMap<String,Object>() ;
		param.put("adminName", chgPsdForm.getAdminName()) ;
		param.put("oldPsd", chgPsdForm.getOldPsd()) ;
		param.put("newPsd", chgPsdForm.getNewPsd()) ;
		
		try{
			Integer cnt = this.adminDAO.updateAdminPsd(param) ;
			if( cnt == 1 ){
				return RetCode.SUCCESS ;
			}else if(cnt == 0){
				return RetCode.WRONG_MOBILENUM ;
			}else{
				return RetCode.DATA_ERROR ;
			}
		}catch(Exception e){
			logger.error("",e);
			return RetCode.DATABASE_EXCEPTION;
		}
		
	}
	
	public AdminVO queryAdminById(Integer adminId){
		return this.adminDAO.selectAdminById(adminId);
	}

	public IMessageSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(IMessageSender mailSender) {
		this.mailSender = mailSender;
	}

	public void shake() {
		this.loginDAO.shake();
	}

	public AdminVO loginCheckUserNameAndPwd(LoginCheckForm form) {
		return adminDAO.loginCheck(form);
	}

	public AdminVO checkAdmin(Map<String, Object> paramMap) {
		return adminDAO.checkAdmin(paramMap);
	}

	
}
