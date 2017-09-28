package com.codepandas.jscalpel.web.sys.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.codepandas.jscalpel.web.sys.entity.vo.privilege.AdminVO;
import com.codepandas.jscalpel.web.sys.entity.vo.privilege.ListAdminPrivilegesVO;
import com.codepandas.jscalpel.web.sys.exception.BusinessException;
import com.codepandas.jscalpel.web.sys.properties.GlobalProperties;
import com.codepandas.jscalpel.web.sys.service.LoginService;
import com.codepandas.jscalpel.web.sys.service.PrivilegeService;
import com.codepandas.jscalpel.web.sys.web.form.login.ChgPsdForm;
import com.codepandas.jscalpel.web.sys.web.form.login.LoginCheckForm;
import com.codepandas.jscalpel.web.util.BeanUtil;
import com.cz.coder.common.constant.RetCode;
import com.cz.coder.common.util.JnwtvStringUtils;
import com.cz.coder.common.util.MD5Util;

@Controller
public class LoginController extends BaseController {
	
	@Autowired
	private LoginService loginService ;
	
	@Autowired
	private PrivilegeService privilegeService ;
	
	private  static  final Logger logger = LoggerFactory.getLogger(LoginController.class) ;
	
	/**
	 * 
	 * @Title: shake 
	 * @author chen.zhao 
	 * @Description: 数据库唤醒
	 * @param @param request
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return Map<String,Object>    返回类型
	 */
	@ResponseBody
	@RequestMapping(value = "shake")
	public Map<String , Object> shake(HttpServletRequest request ) throws Exception{
		try {
			
			this.loginService.shake() ;
			logger.info("third-console.shake is called ");
			return RetCode.buildRetCodeResult(RetCode.SUCCESS) ;
		} catch (Exception e) {
			logger.error("logerror：" , e );
			return RetCode.buildRetCodeResult( RetCode.DATABASE_EXCEPTION ) ;
		}
		
	}
	/**
	 * 
	 * @Title: toLog 
	 * @Description: 登录界面
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	@RequestMapping("/")
	public ModelAndView toLog(HttpServletRequest request) {
		Map<String,Object> model = new HashMap<String,Object>() ;
		AdminVO loginUser = (AdminVO)request.getSession().getAttribute("loginUser") ;
		if( loginUser != null ){
			
			List<ListAdminPrivilegesVO> privileges = this.privilegeService.calAdminPriviletes(loginUser.getAdminId());
			
			for(ListAdminPrivilegesVO vo : privileges){
				model.put(vo.getPrivCode(), vo.isHas()) ;
			}
			return new ModelAndView("/index/index",model);
		}
		return new ModelAndView("/login/login");
	}
	
	/**
	 * 
	 * @Title: toLog 
	 * @Description: 登录界面
	 * @param @return    设定文件  
	 * @return String    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	@RequestMapping("loginOut")
	public ModelAndView loginOut(HttpServletRequest request) {
		request.getSession().removeAttribute("loginUser");
		
		return new ModelAndView("/login/login");
	}
	
	/**
	 * 
	 * @Title: createMobileCode 
	 * @Description: 获取验证码
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return ModelAndView    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	@RequestMapping("createMobileCode")
	public ModelAndView createMobileCode(HttpServletRequest request , HttpServletResponse response ) throws Exception{
		request.setCharacterEncoding("utf-8");
		try {
			Map<String, Object> paramMap = BeanUtil.getOrderModel(request) ;
			Map<String , Object> model = new HashMap<String, Object>() ;
			model.putAll(paramMap);
			ModelAndView mav = new ModelAndView() ;
			MappingJacksonJsonView view = new MappingJacksonJsonView() ;
			// 验证用户名是否为空
			if ( paramMap.isEmpty() || paramMap.equals( null ) || StringUtils.isEmpty(paramMap.get("userName")+"") ) {
				model.put("message", "登录名不能为空");
				model.put("succ", false ) ;
				view.setAttributesMap( model ) ;
				mav.setView(view);
				return mav;
			}
			if (null != paramMap.get("pwd")) {
				paramMap.put("pwd", MD5Util.encrypt(paramMap.get("pwd").toString()));
			}
			
			//验证用户名和密码
			AdminVO admin = loginService.checkAdmin(paramMap);
			
			if ( null == admin ) {
				model.put("message", "账号或密码有误");
				model.put("succ", false ) ;
				view.setAttributesMap( model ) ;
				mav.setView(view);
				return mav;
			}
			
			return loginService.createMobileCode(paramMap);
			
		} catch (Exception e) {
			logger.error("错误日志：", e);
			return new ModelAndView("/error/error404");
		}
		
	}
	
	/**
	 * 
	 * @Title: logincheck 
	 * @Description: TODO 
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return ModelAndView    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	@RequestMapping("toLogin")
	public ModelAndView toLogin(HttpServletRequest request , HttpServletResponse response , LoginCheckForm form) throws Exception{
//		Map<String, Object> paramMap = BeanUtil.getOrderModel(request) ;
		return new ModelAndView("/login/login");
		
	}
	
	/**
	 * 
	 * @Title: logincheck 
	 * @Description: TODO 
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return ModelAndView    返回类型 
	 * @author jingkun.chen cjk_jing@163.com 
	 * @throws
	 */
	@RequestMapping("login")
	public ModelAndView logincheck(HttpServletRequest request , HttpServletResponse response , LoginCheckForm form) throws Exception{
		request.setCharacterEncoding("utf-8");
		Map<String, Object> paramMap = BeanUtil.getOrderModel(request) ;
		Map<String,Object> model = new HashMap<String,Object>() ;
		model.putAll(paramMap);
		try {
			// 验证用户名是否为空
			if ( JnwtvStringUtils.isEmpty( form.getUserName() ) 
					||JnwtvStringUtils.isEmpty(form.getPwd()) ) {
				model.put("loginError", "用户信息不完整");
				return new ModelAndView("/login/login",model);
			}
			form.setPwd(MD5Util.encrypt(form.getPwd() ) ); 
			
			//验证用户名，密码
 			AdminVO adminVO = loginService.loginCheckUserNameAndPwd(form);
			
			if (adminVO ==null ) {
				model.put("loginError", "账号或密码错误");
				model.remove("pwd");
 				return new ModelAndView("/login/login",model);
			}
						
			//验证码验证
			if(StringUtils.equals("0", GlobalProperties.IS_DEBUG) && (JnwtvStringUtils.isEmpty(form.getMobileCode() ) ) ){
				if((JnwtvStringUtils.isEmpty(form.getMobileCode() ) ) ){
					model.put("loginError", "请输入验证码");
					logger.info(model.toString());
					return new ModelAndView("/login/login",model);
				}
			}
			
			
			try{
				AdminVO admin = loginService.doLoginChcek(form) ;
				
				request.getSession().setAttribute("loginUser", admin);
				
				List<ListAdminPrivilegesVO> privileges = this.privilegeService.calAdminPriviletes(admin.getAdminId());
				
				for(ListAdminPrivilegesVO vo : privileges){
					model.put(vo.getPrivCode(), vo.isHas()) ;
				}
				
				return new ModelAndView("/index/index",model);
				
			}catch(BusinessException e){
				model.put("loginError", RetCode.buildRetCodeResult(e.getCode())) ;
				return new ModelAndView("forward:/",model);
			}catch(Exception e){ 
				logger.error("",e);
				model.put("loginError", "系统异常");
				return new ModelAndView("forward:/",model);
			}
			
		} catch (Exception e) {
			logger.error("错误日志：" , e );
			model.put("loginError", "服务器异常");
			return new ModelAndView("forward:/",model);
		}
		
	}
	
	/**
	 * 
	* 函数功能说明  管理员登录
	* jingkun.chen 2015-11-3 
	* @参数：@param username
	* @参数：@param psd
	* @参数：@param model
	* @参数：@param request
	* @参数：@param session
	* @参数：@return
	* @参数：@throws Exception 
	* @return String
	 */
//	@RequestMapping("login")
//	public String log(String adminName, String pwd,  String  mobileCode ,  Model model,
//			HttpServletRequest request, HttpSession session) throws Exception {
//		
//		try {
//			AdminPO adminPO = new AdminPO();
//			adminPO.setAdminName(adminName);
//			adminPO.setPwd(pwd);
//			adminPO.setIsUse("1");
//			// 检查登陆密码是否正确
//			AdminVO userVO = adminDAO.loginCheck(adminPO);
//			if (userVO != null) {
//				request.getSession().setAttribute("loginUser", adminPO);
//				return "/index/index" ;
//			} else {
//				model.addAttribute("loginError", "用户名或者密码错误");
//				return "forward:/";
//			}
//		} catch (Exception e) {
//			logger.error("错误日志：" , e );
//			model.addAttribute("loginError", "服务器异常");
//			return "forward:/";
//		}
//		
//	}

	
	/**
	 * 
	* 函数功能说明  管理员退出登录
	* jingkun.chen 2015-11-3 
	* @参数：@param session
	* @参数：@return 
	* @return String
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			session.removeAttribute("loginUser");
		}
		if (session.getAttribute("RATE") != null) {
			session.removeAttribute("RATE");
		}
		if (session.getAttribute("AUTH") != null) {
			session.removeAttribute("AUTH");
		}
		return "/login/login.jsp";
	}
	/**
	 * 
	* 函数功能说明  跳转到修改密码界面
	* jingkun.chen 2015-11-4 
	* @参数：@param request
	* @参数：@return 
	* @return ModelAndView
	 */
	@RequestMapping("toChangePsdView")
	public ModelAndView toChangePsdView(HttpServletRequest request){
		Map<String , Object> paramMap = BeanUtil.getOrderModel(request);
		
		return new ModelAndView("/login/changePsd" , paramMap);
		
	}
	
	/**
	 * 
	* 函数功能说明 修改管理员密码
	* jingkun.chen 2015-11-3 
	* @参数：@param request
	* @参数：@param log
	* @参数：@return 
	* @return ModelAndView
	 */
	@ResponseBody
	@RequestMapping("changePsd")
	public ModelAndView changePsd(HttpServletRequest request , ChgPsdForm chgPsdForm ) throws Exception{
		Map<String,Object> model = new HashMap<String,Object>() ;
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		
		chgPsdForm.setNewPsd( MD5Util.encrypt(chgPsdForm.getNewPsd()) );
		chgPsdForm.setOldPsd( MD5Util.encrypt(chgPsdForm.getOldPsd()) );
		
		String retCode =  loginService.doChangePsd(chgPsdForm) ;
		
		model.putAll(RetCode.buildRetCodeResult(retCode)) ;
		
		view.setAttributesMap(model);
		mav.setView(view);
		return  mav;
			
	}

}
