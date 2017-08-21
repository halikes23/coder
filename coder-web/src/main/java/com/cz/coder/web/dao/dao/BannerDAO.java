package com.fq.dao.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fq.entity.po.CBannerInfo;

public interface BannerDAO {

	void insertBanner( CBannerInfo banner ) ;

	List<CBannerInfo> queryBanners(String isEnabled);

	void deleteBanner(Integer bId) throws SQLException;

	void updateBannerEnabled(CBannerInfo form);

	Map<String, Object> queryBannerinfo(Map<String, Object> paramMap);

	void updateBannerInfo(Map<String, Object> paramMap);

	void updateOrderIndex(Map<String, Object> paramMap);

	
	
	
}
