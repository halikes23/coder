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
import org.springframework.web.servlet.ModelAndView;

import com.fq.dao.entity.vo.privilege.AdminVO;
import com.fq.service.HomePageService;
import com.fq.service.ProductCountService;
import com.fq.util.StringUtils;
import com.fq.util.img.ImgUtil;

@Controller
public class HomePageController {
	
	@Autowired 
	private  HomePageService homePageService ;
	
	@Autowired 
	private  ProductCountService productCountService ;
	
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
			Map<String , Object> paraMap = new HashMap<String, Object>();
			AdminVO loginUser = (AdminVO)request.getSession().getAttribute("loginUser") ;
			//用户信息
			AdminVO userInfo = homePageService.selectThirdUserInfo(loginUser.getAdminId());
			if (userInfo.getImgUrl() != null   ) {
				userInfo.setHeadImg( ImgUtil.getUrlByQiNiuKey(userInfo.getImgUrl(), null ) );
			}
			
			//用户作品昨日数据统计
			Map<String, Object> userProductDayCount = homePageService.selectUserProductDayCount(loginUser.getAdminId());
			
			
			//用户作品总数据统计
			Map<String, Object> userProjectTotalCount = homePageService.selectUserProductTotalCount(loginUser.getAdminId());
			
			String totalIncome = productCountService.selectUserProductTotalIncome(loginUser.getAdminId());
			userProjectTotalCount.put("totalIncome", totalIncome) ;
			//最新作品数据统计
			Map<String, Object> userNewProductInfo = homePageService.selectUserNewProductInfo(loginUser.getAdminId());
			
			if (null != userNewProductInfo) {
				if ( null != userNewProductInfo.get("coverImg") ) {
					userNewProductInfo.put("coverImg", ImgUtil.getUrlByQiNiuKey( userNewProductInfo.get("coverImg").toString() , null ));
				}
				paraMap.put("id", Integer.parseInt(userNewProductInfo.get("id").toString())) ;
				paraMap.put("type", userNewProductInfo.get("subType"));
				Map<String, Object> userNewProductInfoDetail  = null ;
				Map<String, Object> userNewProductCount  = null ;
				
				if (StringUtils.equals(paraMap.get("type").toString(), "cartoon")) {
					//查询最新作品为漫画的详细信息
					userNewProductInfoDetail = homePageService. selectUserNewCartoonProductDetailInfo(paraMap);
					//用户最新漫画作品数据统计
					userNewProductCount = homePageService.selectUserNewCartoonProductCount(paraMap);
				}else {
					//查询最新作品为小说的详细信息
					 userNewProductInfoDetail = homePageService. selectUserNewNovelProductDetailInfo(paraMap);
					//用户最新漫画作品数据统计
					userNewProductCount = homePageService.selectUserNewNovelProductCount(paraMap);
				}
				model.put("userNewProductInfoDetail", userNewProductInfoDetail) ; 
				model.put("userNewProductCount", userNewProductCount) ; 
				model.put("userNewProductInfo", userNewProductInfo) ; 
			}
			
			model.put("userProductDayCount", userProductDayCount) ; 
			model.put("userProjectTotalCount", userProjectTotalCount) ; 
			model.put("userInfo", userInfo) ;
			
			return new ModelAndView("/third-console/myHomePage" , model);
		} catch (Exception e) {
			logger.error("三方用户首页信息查询异常：", e);
			return new ModelAndView("/error/error404");
		}
		
	}
	
	
	
	
}
