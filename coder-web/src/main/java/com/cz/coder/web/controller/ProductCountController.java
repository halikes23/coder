package com.fq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fq.dao.entity.vo.UserProductMonthIncomeVO;
import com.fq.dao.entity.vo.privilege.AdminVO;
import com.fq.service.ProductCountService;
import com.fq.util.BeanUtil;
import com.fq.util.page.PageInfo;

@Controller
public class ProductCountController {
	
	@Autowired 
	private   ProductCountService  productCountService ;
	
	private static  final Logger logger = LoggerFactory.getLogger(ProductCountController.class) ;
	/**
	 * 
	 * @Title: toIncomeSurvey 
	 * @author chen.zhao 
	 * @Description: 查询收入概况
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return ModelAndView    返回类型
	 */
	@RequestMapping(value="toIncomeSurvey")
	public ModelAndView toIncomeSurvey(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			request.setCharacterEncoding("utf-8");
			Map<String, Object> paraMap = BeanUtil.getOrderModel(request);
			Map<String , Object> model = new HashMap<String, Object>();
			Map<String , Object> incomeMap = new HashMap<String, Object>();
			AdminVO loginUser = (AdminVO)request.getSession().getAttribute("loginUser") ;
			Integer adminId = loginUser.getAdminId();
			Integer pageNow = (request.getParameter("pageNow") == null || request.getParameter("pageNow").equals( "0" )  ) ? 1 : Integer.valueOf(request.getParameter("pageNow"));
			Integer pageSize = (request.getParameter("pageSize") == null ) ? 10 : Integer.valueOf(request.getParameter("pageSize").toString() ) ;
			paraMap.put("pageNow", pageNow);
			paraMap.put("pageSize", pageSize);
			paraMap.put("adminId", adminId) ;
			//昨日收入
			String  yesterdayIncome = productCountService.selectUserProductYesterdayIncome(adminId);
			//本月收入
			String monthIncome = productCountService.selectUserProductMonthIncome(adminId);
			//总收入
			String totalIncome = productCountService.selectUserProductTotalIncome(adminId);
			
			//用户作品月收入统计
			PageInfo<UserProductMonthIncomeVO>  pageInfo =  productCountService.selectUserProductMonthIncomeInfoList(paraMap);
			
			incomeMap.put("yesterdayIncome", yesterdayIncome) ;
			incomeMap.put("monthIncome", monthIncome) ;
			incomeMap.put("totalIncome", totalIncome) ;
			
			model.put("incomeMap", incomeMap) ;
			model.put("pageInfo", pageInfo) ;
			model.putAll(paraMap);
			
			return new ModelAndView("/third-console/incomeSurvey" , model);
		} catch (Exception e) {
			logger.error("查询用户收入概况失败：", e);
			return new ModelAndView("/error/error404");
		}
		
	}
	/**
	 * 
	 * @Title: toProductIncome 
	 * @author chen.zhao 
	 * @Description: 查询作品收入
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return ModelAndView    返回类型
	 */
	@RequestMapping(value="toProductIncome")
	public ModelAndView toProductIncome(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			request.setCharacterEncoding("utf-8");
			Map<String, Object> paraMap = BeanUtil.getOrderModel(request);
			Map<String , Object> model = new HashMap<String, Object>();
			AdminVO loginUser = (AdminVO)request.getSession().getAttribute("loginUser") ;
			Integer adminId = loginUser.getAdminId();
			Integer pageNow = (request.getParameter("pageNow") == null || request.getParameter("pageNow").equals( "0" )  ) ? 1 : Integer.valueOf(request.getParameter("pageNow"));
			Integer pageSize = (request.getParameter("pageSize") == null ) ? 10 : Integer.valueOf(request.getParameter("pageSize").toString() ) ;
			paraMap.put("pageNow", pageNow);
			paraMap.put("pageSize", pageSize);
			paraMap.put("adminId", adminId) ;
			//用户作品月收入统计
			PageInfo<UserProductMonthIncomeVO> pageInfo  = productCountService.selectUserMonthIncomeDetailInfoList(paraMap);
			//查询用户作品集合
			List<Map<String, Object> > userProductInfoList = productCountService.selectUserProductInfoList(adminId) ;
			
			model.put("pageInfo", pageInfo) ;
			model.put("userProductInfoList", userProductInfoList) ;
			model.putAll(paraMap);
			
			return new ModelAndView("/third-console/productIncome" , model);
		} catch (Exception e) {
			logger.error("查询用户作品收入失败：", e);
			return new ModelAndView("/error/error404");
		}
		
	}
	
	
	
}
