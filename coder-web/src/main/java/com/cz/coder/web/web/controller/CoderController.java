package com.cz.coder.web.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cz.coder.common.constant.RetCode;
import com.cz.coder.web.service.CoderService;

@Controller
public class CoderController {
	
	private final static Logger logger = LoggerFactory.getLogger(CoderController.class) ;
	
	@Autowired
	private CoderService coderService ;
	
	@RequestMapping(value="index")
	public ModelAndView index() {
		
		Map<String,Object> model = new HashMap<String,Object>() ;
		
		boolean flag = coderService.checkHasInit();
		
		if( flag == false ){
			try {
				coderService.init();
				model.putAll(RetCode.buildRetCodeResult(RetCode.SUCCESS)) ;
			} catch (IOException e) {
				logger.error("",e);
				model.putAll(RetCode.buildRetCodeResult(RetCode.SYSTEM_ERROR));
			}
		}
		
		return new ModelAndView ("/index/index" , model);
		
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
