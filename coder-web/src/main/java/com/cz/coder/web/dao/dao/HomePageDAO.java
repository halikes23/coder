package com.fq.dao.dao;

import java.util.List;
import java.util.Map;

import com.fq.dao.entity.po.HomePagePO;
import com.fq.dao.entity.vo.ProjectInfoVO;
import com.fq.dao.entity.vo.StartPageVO;
import com.fq.dao.entity.vo.privilege.AdminVO;
import com.fq.dao.entity.vo.project.BoutiqueProjectVO;
import com.fq.dao.entity.vo.project.CrowdfundingVO;

public interface HomePageDAO {

	List<BoutiqueProjectVO> getBoutiqueProjectLists();

	List<CrowdfundingVO> getCrowdfundingProjectLists();

	void updateProjectInBoutique(Map<String, Object> paramMap);

	List<ProjectInfoVO> queryAllProjectInfo();

	void insertProjectIntoBoutique(Map<String, Object> paramMap);

	void updateProjectInBoutiqueToStricky(Map<String, Object> paramMap);

	Map<String, Object> queryProjectInRecommend(Map<String, Object> paramMap);

	void updateProjectInCrowdfunding(Map<String, Object> paramMap);

	List<ProjectInfoVO> queryAllProjectOutOfCrowdfunding();

	Map<String, Object> queryProjectInCrowdfunding(Map<String, Object> paramMap);

	void insertProjectIntoCrowdfunding(Map<String, Object> paramMap);

	void updateProjectToCrowdfunding(Map<String, Object> paramMap);

	void insertHomePage(HomePagePO homePage);

	List<StartPageVO> queryStartPage();

	void deleteStartPage(Map<String, Object> paramMap);

	void updateStartPage(Map<String, Object> paramMap);

	void updateCrowdfundingProjectListOrder(Map<String, Object> paramMap);

	void updateBoutiqueProjectListOrder(Map<String, Object> paramMap);

	void insertStartPage(Map<String, Object> params);

	void toUpdateStartPage(Map<String, Object> params);
	
	Map<String, Object> selectUserProductDayCount(Integer adminId);

	Map<String, Object> selectUserProductTotalCount(Integer adminId);

	Map<String, Object> selectUserNewProductInfo(Integer adminId);

	Map<String, Object> selectUserNewCartoonProductDetailInfo(
			Map<String, Object> paraMap);

	Map<String, Object> selectUserNewNovelProductDetailInfo(
			Map<String, Object> paraMap);

	Map<String, Object> selectUserNewCartoonProductCount(
			Map<String, Object> paraMap);

	Map<String, Object> selectUserNewNovelProductCount(
			Map<String, Object> paraMap);

	AdminVO selectThirdUserInfo(Integer adminId);


}
