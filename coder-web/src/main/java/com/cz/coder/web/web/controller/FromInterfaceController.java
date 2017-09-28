package com.cz.coder.web.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cz.coder.common.entity.vo.InterfaceFileVO;
import com.cz.coder.web.service.FromInterfaceFileService;

@Controller
public class FromInterfaceController {

	@Autowired
	private FromInterfaceFileService fromInterfaceFileService ;
	
	@RequestMapping("fromInterfaceFile/toListInterfaceFiles")
	public ModelAndView toListInterfaceFiles(String interfaceName){
		
		List<InterfaceFileVO> interfaceFiles = this.fromInterfaceFileService.queryInterfaceFiles(interfaceName) ;
		
		return new ModelAndView("/coder/frominterfacefile/listInterfaceFiles");
		
	}
	
	@RequestMapping("fromInterfaceFile/toAddInterfaceFile")
	public ModelAndView buildCode(String interfaceName){
		
		List<InterfaceFileVO> interfaceFiles = this.fromInterfaceFileService.queryInterfaceFiles(interfaceName) ;
		
		return new ModelAndView("/coder/frominterfacefile/addInterfaceFile");
		
	}
	
	
	
}
