package com.cz.coder.web.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cz.coder.common.entity.vo.ColumnVO;
import com.cz.coder.web.service.CoderService;
import com.cz.coder.web.web.form.BuildCodeForm;
import com.cz.coder.web.web.form.ToiTableDetailForm;
import com.google.common.collect.Maps;

@Controller
public class CoderController {

	private final static Logger logger = LoggerFactory.getLogger(CoderController.class) ;
	
	@Autowired
	private CoderService coderService ;
	
	@RequestMapping("toListDatabases")
	public ModelAndView toListDatabases(){
		
		List<String> databases = this.coderService.queryAllDatabases() ;
		
		Map<String,Object> model = Maps.newHashMap() ;
		model.put("databases", databases) ;
		
		return new ModelAndView("/coder/listDatabases",model);
		
		
	}
	
	@RequestMapping("toListTables")
	public ModelAndView toListTables(String schema){
		
		List<String> tables = this.coderService.queryTablesBySchema(schema) ;
		
		Map<String,Object> model = Maps.newHashMap() ;
		model.put("tables", tables) ;
		model.put("schema", schema) ;
		return new ModelAndView("/coder/listTables",model);
		
		
	}
	
	@RequestMapping("toTableDetail")
	public ModelAndView toTableDetail(ToiTableDetailForm form){
		
		List<ColumnVO> columns = this.coderService.queryColumnsByTable(form.getSchema(),form.getTable()) ;
		
		Map<String,Object> model = Maps.newHashMap() ;
		model.put("columns", columns) ;
		model.put("schema", form.getSchema()) ;
		model.put("table",form.getTable()) ;
		
		return new ModelAndView("/coder/tableDetail",model);
		
		
	}
	
	@RequestMapping("buildCode")
	public ModelAndView buildCode(BuildCodeForm form){
		
		try{
			Map<String,Object> model = new HashMap<String,Object>() ;
			Map<String,Object> result = this.coderService.buildCode(form.getPkg() , form.getSchema() , form.getTable()) ;
			model.putAll(result);
			return new ModelAndView("/coder/script",model);
		}catch(Exception e){
			logger.error("",e);
			return null ;
		}
		
		
		
		
	}
	
}
