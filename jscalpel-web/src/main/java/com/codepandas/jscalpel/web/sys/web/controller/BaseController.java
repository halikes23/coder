package com.codepandas.jscalpel.web.sys.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;





public class BaseController {

	private Logger log = LoggerFactory.getLogger(BaseController.class);
	@ExceptionHandler
	public String exception (HttpServletRequest request,Exception e){
		log.debug(request.getRequestURI());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  
		e.printStackTrace(new PrintStream(baos));  
		String exception = baos.toString();  
		request.setAttribute("error", exception);
		return "error500";
	}
}
