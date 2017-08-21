package com.fq.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fq.common.constant.RetCode;
import com.fq.dao.dao.user.UserDAO;
import com.fq.dao.entity.vo.ThirdUserInfoVO;
import com.fq.dao.entity.vo.privilege.AdminVO;
import com.fq.filter.HtmlFilter;
import com.fq.form.user.EditThirdUserInfoForm;
import com.fq.service.UserService;
import com.fq.util.BeanUtil;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService ;
	
	private static  final Logger logger = LoggerFactory.getLogger(UserController.class) ;
	
	
	/**
	 * 
	 * @Title: toUserInfo 
	 * @author chen.zhao 
	 * @Description: 三方用户账号信息列表
	 * @param @param request
	 * @param @param response
	 * @param @return    设定文件  
	 * @return ModelAndView    返回类型
	 */
	@RequestMapping(value="touserInfo")
	public	ModelAndView toUserInfo(HttpServletRequest request, HttpServletResponse response)throws Exception{
		try {
			
			Map<String, Object> model = new HashMap<String, Object>();
			AdminVO loginUser = (AdminVO)request.getSession().getAttribute("loginUser") ;
			//用户信息
			ThirdUserInfoVO thirdUserInfoVO =  userService.selectThirdUserInfo(loginUser.getAdminId());
			model.put("thirdUserInfo", thirdUserInfoVO) ; 
			return new ModelAndView("/third-console/userInfo"  , model);
		} catch (Exception e) {
			logger.error("三方用户账号信息查询异常：", e);
			return new ModelAndView("/error/error404");
		}
		
	}
	/**
	 * 
	 * @Title: toUserInfoEdit 
	 * @author chen.zhao 
	 * @Description: 跳转到用户信息编辑界面
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return ModelAndView    返回类型
	 */
	@RequestMapping(value="toUserInfoEdit")
	public	ModelAndView toUserInfoEdit(HttpServletRequest request, HttpServletResponse response)throws Exception{
		try {
			
			Map<String, Object> model = new HashMap<String, Object>();
			AdminVO loginUser = (AdminVO)request.getSession().getAttribute("loginUser") ;
			//用户信息
			ThirdUserInfoVO thirdUserInfoVO =  userService.selectThirdUserInfo(loginUser.getAdminId());
			model.put("thirdUserInfo", thirdUserInfoVO) ; 
			return new ModelAndView("/third-console/userInfoEdit"  , model);
		} catch (Exception e) {
			logger.error("跳转到用户信息编辑界面异常：", e);
			return new ModelAndView("/error/error404");
		}
		
	}
	
	/**
	 * 
	 * @Title: editUserInfo 
	 * @author chen.zhao 
	 * @Description: 编辑用户信息
	 * @param @param request
	 * @param @param response
	 * @param @param form
	 * @param @return
	 * @      param @throws Exception    设定文件  
	 * @return Map<String,Object>    返回类型
	 */
	@ResponseBody
	@RequestMapping(value="editUserInfo")
	public Map<String , Object> editUserInfo(HttpServletRequest request , HttpServletResponse response  , EditThirdUserInfoForm form   ) throws Exception{
		try {
			AdminVO loginUser = (AdminVO)request.getSession().getAttribute("loginUser") ;
			form.setaId(loginUser.getAdminId()) ;
			
			Map<String, Object> model = userService.editUserInfo(form ,request); 
			return model;
		} catch (Exception e) {
			logger.error("编辑用户信息失败", e);
			return RetCode.buildRetCodeResult(RetCode.SYSTEM_ERROR);
		}
    }
	
	
	
	
	
}
