package com.fq.dao.dao.magicwindow;

import java.util.List;
import java.util.Map;

import com.fq.dao.entity.po.sina.SinaPopularizePO1;
import com.fq.dao.entity.vo.sina.SinaAppCateVO;
import com.fq.dao.entity.vo.sina.SinaContentCateVO;
import com.fq.dao.entity.vo.sina.SinaPopularizeVO;

public interface SinaPopularizeDAO {

	List<Map<String, Object>> listSinaPopularizerRecord(Map<String, Object> para) throws Exception;

	Integer getSinaPopularizerRecord(Map<String, Object> para);

	void deleteSinaPopularizerRecord(String id);

	List<Map<String, Object>> querySinaPopularizerApp(Map<String, Object> para);

	Integer getSinaPopularizerAppCount(Map<String, Object> para);

	List<Map<String, Object>> querySinaPopularizerContent(
			Map<String, Object> para) ;

	Integer getSinaPopularizerContentCount(Map<String, Object> para);

	List<Map<String, Object>> querySinaPopularizerAppNo(Map<String, Object> para);

	List<Map<String, Object>> querySinaPopularizerContentNo(
			Map<String, Object> para);

	SinaPopularizePO1 querySinaPopularizerRecord(Map<String, Object> para) throws Exception;

	void changeSinaApp(Map<String, Object> para);

	void changeSinaContent(Map<String, Object> para);

	void updateSinaPopularizerInfo(SinaPopularizeVO sinaPopularizeVO);

	void deleteSinaPopularizerContent(Integer spId);

	void deleteSinaPopularizerApp(Integer spId);

	SinaContentCateVO getSinaPopularizeContentBySccId(String sccId);

	SinaAppCateVO getSinaPopularizeAppBySacId(String sacId);

	void addSinaPopularizerContent(SinaContentCateVO sinaContentCateVO);

	void addSinaPopularizerApp(SinaAppCateVO sinaAppCateVO);

	void deleteSinaPopularizerContentBySccId(String sccId);

	void deleteSinaPopularizerAppBySacId(String sacId);

	void insertSinaPopularizerInfo(SinaPopularizeVO sinaPopularizeVO);

	Integer getSinaPopularizerById(String id);


}
