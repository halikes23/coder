package com.fq.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.dao.dao.ProductCountDAO;
import com.fq.dao.entity.vo.UserProductMonthIncomeVO;
import com.fq.dao.entity.vo.privilege.AdminVO;
import com.fq.entity.vo.CartoonChannelIncomeVO;
import com.fq.util.StringUtils;
import com.fq.util.page.PageInfo;
import com.fq.util.page.PageUtil;

@Service
public class ProductCountService {
	
	@Autowired
	private  ProductCountDAO  productCountDAO ;
	
	private final static Logger logger = LoggerFactory.getLogger(ProductCountService.class);

	public String selectUserProductYesterdayIncome(Integer adminId) {
		return productCountDAO.selectUserProductYesterdayIncome(adminId);
	}

	public String selectUserProductMonthIncome(Integer adminId) {
		return productCountDAO.selectUserProductMonthIncome(adminId);
	}

	public String selectUserProductTotalIncome(Integer adminId) {
		return  productCountDAO.selectUserProductTotalIncome(adminId);
	}
	
	public PageInfo<UserProductMonthIncomeVO> selectUserProductMonthIncomeInfoList(Map<String, Object> paraMap) throws Exception {
		
		try {
			PageInfo<UserProductMonthIncomeVO> pageInfo = new PageInfo<UserProductMonthIncomeVO>();
			paraMap.putAll( PageUtil.buildPage( Integer.valueOf(paraMap.get("pageNow").toString() ) , Integer.valueOf(paraMap.get("pageSize").toString() ) ) ) ;
			
			List<UserProductMonthIncomeVO> userProductMonthIncomeVOs =  productCountDAO.selectUserProductMonthIncomeInfoList(paraMap);
			
			for (UserProductMonthIncomeVO userProductMonthIncomeVO : userProductMonthIncomeVOs) {
				
				//漫画第三方渠道月收入 
				String cartoonChannelIncome = productCountDAO.selectCartoonChannelIncomeByMonth(userProductMonthIncomeVO.getMonth() , paraMap ) ;
				//漫画保底金
				String baseMoney = productCountDAO.selectBaseMoneyByMonth(userProductMonthIncomeVO.getMonth() , paraMap ) ;
				
				userProductMonthIncomeVO.setBaseMoney(baseMoney);
				userProductMonthIncomeVO.setMonthIncome(userProductMonthIncomeVO.getMonthIncome() == null ? "0.00" : userProductMonthIncomeVO.getMonthIncome()) ;
				cartoonChannelIncome = (cartoonChannelIncome == null ? "0.00" : cartoonChannelIncome );
				userProductMonthIncomeVO.setCartoonChannelIncome(cartoonChannelIncome) ;
			}
			Integer pageCount = productCountDAO.selectUserProductMonthIncomeInfoListTotals(paraMap) ;
			
			pageInfo.setDataList( userProductMonthIncomeVOs ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paraMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paraMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	
	public PageInfo<UserProductMonthIncomeVO> selectUserMonthIncomeDetailInfoList(
			Map<String, Object> paraMap) throws Exception{
		try {
			PageInfo<UserProductMonthIncomeVO> pageInfo = new PageInfo<UserProductMonthIncomeVO>();
			paraMap.putAll( PageUtil.buildPage( Integer.valueOf(paraMap.get("pageNow").toString() ) , Integer.valueOf(paraMap.get("pageSize").toString() ) ) ) ;
			DecimalFormat df = new DecimalFormat("0.00");
			List<UserProductMonthIncomeVO> userProductMonthIncomeVOs = null ;
			Integer pageCount = 0  ;
			
			//全部渠道
			if (!paraMap.containsKey("channelName")|| paraMap.get("channelName").equals("1")) {
				userProductMonthIncomeVOs = productCountDAO.selectUserMonthIncomeAllInfoList(paraMap) ; 
				for (UserProductMonthIncomeVO vo : userProductMonthIncomeVOs) {
					if (vo.getProductType().equals("2") ) {
						String monthChannelIncome = productCountDAO.selectCartoonMonthChannelIncome(vo.getId() , vo.getMonth());
						//漫画有渠道收入信息，处理漫画收入
						if (monthChannelIncome != null ) {
							String totalIncome = productCountDAO.selectProductTotalIncome(vo.getId() , vo.getMonth()) ;
							totalIncome = totalIncome == null ? "0.00" : totalIncome ;
							String thirdIncome = String.valueOf(((Float.parseFloat(totalIncome) - Float.parseFloat(monthChannelIncome)) <= 0f ? "0.00" : Float.parseFloat(totalIncome) - Float.parseFloat(monthChannelIncome))) ;
							vo.setTotalMonthIncome(String.valueOf(Float.parseFloat(vo.getTotalMonthIncome()) +Float.parseFloat(thirdIncome ) )) ;
						}
						String str= df.format(Double.parseDouble(vo.getTotalMonthIncome()));
						vo.setTotalMonthIncome(str);
					}
				}
				pageCount = productCountDAO.selectUserMonthIncomeAllInfoListTotals(paraMap) ;
			}else {
				userProductMonthIncomeVOs = productCountDAO.selectUserMonthIncomeDetailInfoList(paraMap) ; 
				for (UserProductMonthIncomeVO vo : userProductMonthIncomeVOs) {
					if (vo.getProductType().equals("1") && vo.getChannelName().equals("三方")) {
						String monthChannelIncome = productCountDAO.selectCartoonMonthChannelIncome(vo.getId() , vo.getMonth());
						monthChannelIncome = monthChannelIncome == null ? "0.00" : monthChannelIncome ;
						//作品收入 = 总收入-三方渠道收入 
						vo.setTotalMonthIncome(String.valueOf(Float.parseFloat(vo.getTotalMonthIncome()) - Float.parseFloat(monthChannelIncome) ) ) ;
						vo.setTotalMonthIncome(Float.parseFloat(vo.getTotalMonthIncome()) <= 0f ? "0.00" : vo.getTotalMonthIncome() ) ;
						String str= df.format(Double.parseDouble(vo.getTotalMonthIncome()));
						vo.setTotalMonthIncome(str);
					}
				}
				pageCount = productCountDAO.selectUserMonthIncomeDetailInfoListTotals(paraMap) ;
			}
			
			pageInfo.setDataList( userProductMonthIncomeVOs ) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paraMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paraMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	
	public List<Map<String, Object>> selectUserProductInfoList(Integer adminId) {
		return productCountDAO.selectUserProductInfoList(adminId) ;
	}

	
}
