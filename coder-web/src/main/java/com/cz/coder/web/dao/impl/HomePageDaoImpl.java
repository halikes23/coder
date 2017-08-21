package com.fq.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fq.dao.BaseDAO;
import com.fq.dao.dao.HomePageDAO;
import com.fq.dao.entity.po.HomePagePO;
import com.fq.dao.entity.vo.ProjectInfoVO;
import com.fq.dao.entity.vo.StartPageVO;
import com.fq.dao.entity.vo.privilege.AdminVO;
import com.fq.dao.entity.vo.project.BoutiqueProjectVO;
import com.fq.dao.entity.vo.project.CrowdfundingVO;

@Repository
public class HomePageDaoImpl extends BaseDAO implements HomePageDAO{

	@Override
	public List<BoutiqueProjectVO> getBoutiqueProjectLists() {
		return getSqlMapClientTemplate().queryForList("HomePageDaoImpl.selectBoutiqueProjectLists");
	}

	@Override
	public List<CrowdfundingVO> getCrowdfundingProjectLists() {
		return getSqlMapClientTemplate().queryForList("HomePageDaoImpl.selectCrowdfundingProjectLists");
	}

	@Override
	public void updateProjectInBoutique(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("HomePageDaoImpl.updateProjectInBoutique", paramMap);
	}

	@Override
	public List<ProjectInfoVO> queryAllProjectInfo() {
		return getSqlMapClientTemplate().queryForList("HomePageDaoImpl.selectAllProjectInfo");
	}

	@Override
	public void insertProjectIntoBoutique(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("HomePageDaoImpl.insertProjectIntoBoutique", paramMap);
	}

	@Override
	public void updateProjectInBoutiqueToStricky(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("HomePageDaoImpl.updateProjectInBoutiqueToStricky", paramMap);
	}

	@Override
	public Map<String, Object> queryProjectInRecommend(Map<String, Object> paramMap) {
		return  (Map<String, Object>) getSqlMapClientTemplate().queryForObject("HomePageDaoImpl.selectProjectInRecommend", paramMap);
	}

	@Override
	public void updateProjectInCrowdfunding(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("HomePageDaoImpl.updateProjectInCrowdfunding", paramMap);
	}

	@Override
	public List<ProjectInfoVO> queryAllProjectOutOfCrowdfunding() {
		return getSqlMapClientTemplate().queryForList("HomePageDaoImpl.queryAllProjectOutOfCrowdfunding");
	}

	@Override
	public Map<String, Object> queryProjectInCrowdfunding(Map<String, Object> paramMap) {
		return  (Map<String, Object>) getSqlMapClientTemplate().queryForObject("HomePageDaoImpl.selectProjectInCrowdfunding", paramMap);
	}

	@Override
	public void insertProjectIntoCrowdfunding(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().insert("HomePageDaoImpl.insertProjectIntoCrowdfunding", paramMap);
	}

	@Override
	public void updateProjectToCrowdfunding(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("HomePageDaoImpl.updateProjectToCrowdfunding", paramMap);
	}

	@Override
	public void insertHomePage(HomePagePO homePage) {
		this.getSqlMapClientTemplate().insert("HomePageDaoImpl.insertHomePage",homePage) ;
	}

	@Override
	public List<StartPageVO> queryStartPage() {
		return getSqlMapClientTemplate().queryForList("HomePageDaoImpl.selectStartPage");
	}


	@Override
	public void deleteStartPage(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().delete("HomePageDaoImpl.deleteStartPage", paramMap);
	}

	@Override
	public void updateStartPage(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("HomePageDaoImpl.updateStartPage", paramMap);
	}

	@Override
	public void updateCrowdfundingProjectListOrder(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("HomePageDaoImpl.updateCrowdfundingProjectListOrder", paramMap);
	}

	@Override
	public void updateBoutiqueProjectListOrder(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("HomePageDaoImpl.updateBoutiqueProjectListOrder", paramMap);
	}
	
	@Override
	public void insertStartPage(Map<String, Object> params) {
		getSqlMapClientTemplate().insert("HomePageDaoImpl.insertStartPage", params);
	}
	
	@Override
	public void toUpdateStartPage(Map<String, Object> params) {
		getSqlMapClientTemplate().update("HomePageDaoImpl.toUpdateStartPage", params);
	}

	@Override
	public Map<String, Object> selectUserProductDayCount(Integer adminId) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("HomePageDaoImpl.selectUserProductDayCount" , adminId);
	}
	
	@Override
	public Map<String, Object> selectUserProductTotalCount(Integer adminId) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("HomePageDaoImpl.selectUserProductTotalCount" , adminId);
	}
	
	@Override
	public Map<String, Object> selectUserNewProductInfo(Integer adminId) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("HomePageDaoImpl.selectUserNewProductInfo" , adminId);
	}

	@Override
	public Map<String, Object> selectUserNewCartoonProductDetailInfo(
			Map<String, Object> paraMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("HomePageDaoImpl.selectUserNewCartoonProductDetailInfo" , paraMap);
	}
	
	@Override
	public Map<String, Object> selectUserNewNovelProductDetailInfo(
			Map<String, Object> paraMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("HomePageDaoImpl.selectUserNewNovelProductDetailInfo" , paraMap);
	}
	
	@Override
	public Map<String, Object> selectUserNewCartoonProductCount(
			Map<String, Object> paraMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("HomePageDaoImpl.selectUserNewCartoonProductCount" , paraMap);
	}

	@Override
	public Map<String, Object> selectUserNewNovelProductCount(
			Map<String, Object> paraMap) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("HomePageDaoImpl.selectUserNewNovelProductCount" , paraMap);
	}

	@Override
	public AdminVO selectThirdUserInfo(Integer adminId) {
		return (AdminVO) getSqlMapClientTemplate().queryForObject("HomePageDaoImpl.selectThirdUserInfo" ,adminId);
	}

	
}
