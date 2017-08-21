package com.fq.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.dao.dao.HomePageDAO;
import com.fq.dao.entity.vo.privilege.AdminVO;

@Service
public class HomePageService {
	
	@Autowired
	private HomePageDAO   homePageDAO ;
	private final static Logger logger = LoggerFactory.getLogger(HomePageService.class);
	
	public Map<String, Object> selectUserProductDayCount(Integer adminId) {
		return homePageDAO.selectUserProductDayCount(adminId);
	}
	
	public Map<String, Object> selectUserProductTotalCount(Integer adminId) {
		return homePageDAO.selectUserProductTotalCount(adminId);
	}

	public Map<String, Object> selectUserNewProductInfo(Integer adminId) {
		return homePageDAO.selectUserNewProductInfo(adminId);
	}

	public Map<String, Object> selectUserNewCartoonProductDetailInfo(
			Map<String, Object> paraMap) {
		return homePageDAO.selectUserNewCartoonProductDetailInfo(paraMap);
	}
	
	public Map<String, Object> selectUserNewNovelProductDetailInfo(
			Map<String, Object> paraMap) {
		return homePageDAO.selectUserNewNovelProductDetailInfo(paraMap);
	}

	public Map<String, Object> selectUserNewCartoonProductCount(
			Map<String, Object> paraMap) {
		return homePageDAO.selectUserNewCartoonProductCount(paraMap);
	}

	public Map<String, Object> selectUserNewNovelProductCount(
			Map<String, Object> paraMap) {
		return homePageDAO.selectUserNewNovelProductCount(paraMap);
	}

	public AdminVO selectThirdUserInfo(Integer adminId) {
		return homePageDAO.selectThirdUserInfo(adminId);
	}

	
	
}
