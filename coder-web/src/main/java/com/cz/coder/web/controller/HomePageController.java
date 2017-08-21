package com.cz.coder.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cz.coder.web.dao.entity.vo.privilege.AdminVO;

@Controller
public class HomePageController {
	
	private static  final Logger logger = LoggerFactory.getLogger(HomePageController.class) ;
	
	/**
	 * 
	 * @Title: toMyHomePage 
	 * @author chen.zhao 
	 * @Description: 三方用户首页列表
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return ModelAndView    返回类型
	 */
	@RequestMapping(value="toMyHomePage")
	public ModelAndView toMyHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			request.setCharacterEncoding("utf-8");
			Map<String , Object> model = new HashMap<String, Object>();
			AdminVO loginUser = (AdminVO)request.getSession().getAttribute("loginUser") ;
			
			model.put("userInfo", loginUser) ;
			
			return new ModelAndView("/third-console/myHomePage" , model);
		} catch (Exception e) {
			logger.error("三方用户首页信息查询异常：", e);
			return new ModelAndView("/error/error404");
		}
		
	}
	
	
	
	
}
