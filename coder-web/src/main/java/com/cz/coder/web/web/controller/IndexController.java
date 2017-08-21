package com.cz.coder.web.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cz.coder.web.common.properties.GlobalProperties;


/**
 * 首页controller
 * @author P
 * @date d2015-4-24
 */
@Controller
public class IndexController {
	
	@RequestMapping(value="index")
	public ModelAndView index () {
		
		Map<String,Object> model = new HashMap<String,Object>() ;
		
		ModelAndView mv = new ModelAndView ("/index/index" , model);
		
		
		
		return mv;
	}
	
	@RequestMapping(value="left")
	public ModelAndView left() {
		
		Map<String,Object> model = new HashMap<String,Object>() ;
		model.put("aaa", "ccc") ;
		
		ModelAndView mv = new ModelAndView ("/index/left" , model);
		
		return mv;
	}
	@RequestMapping(value="homepage")
	public ModelAndView homePage(){
		Map<String, Object> model = new HashMap<String, Object>();
		
		return new ModelAndView( "/index/homePage",model);
	}
	
	
	
}
