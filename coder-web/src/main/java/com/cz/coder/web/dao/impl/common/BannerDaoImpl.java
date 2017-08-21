package com.fq.dao.impl.common;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fq.dao.BaseDAO;
import com.fq.dao.dao.BannerDAO;
import com.fq.entity.po.CBannerInfo;
@Repository
public class BannerDaoImpl extends BaseDAO implements BannerDAO {

	@Override
	public void insertBanner(CBannerInfo banner) {

		this.getSqlMapClientTemplate().insert("BannerDaoImpl.insertBanner" , banner) ;
		
	}

	@Override
	public List<CBannerInfo> queryBanners(String isEnabled) {

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isEnabled", isEnabled) ;
		
		return this.getSqlMapClientTemplate().queryForList("BannerDaoImpl.queryBanners",params) ;
		
	}

	@Override
	public void deleteBanner(Integer bId) throws SQLException {
		this.getSqlMapClient().delete("BannerDaoImpl.deleteBanner",bId);
		
	}

	@Override
	public void updateBannerEnabled(CBannerInfo form) {
		this.getSqlMapClientTemplate().update("BannerDaoImpl.updateBannerEnabled",form) ;
		
	}
	
	@Override
	public Map<String, Object> queryBannerinfo(
			Map<String, Object> paramMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("BannerDaoImpl.selectBannerInfo", paramMap );
	}
	
	@Override
	public void updateBannerInfo(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().update("BannerDaoImpl.updateBannerInfo",paramMap) ;
		
	}
	
	@Override
	public void updateOrderIndex(Map<String, Object> paramMap){
		this.getSqlMapClientTemplate().update("BannerDaoImpl.updateOrderIndex",paramMap);
	}

}
