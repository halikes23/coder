package com.fq.dao.impl.magicwindow;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.fq.dao.BaseDAO;
import com.fq.dao.dao.magicwindow.SinaPopularizeDAO;
import com.fq.dao.entity.po.sina.SinaPopularizePO1;
import com.fq.dao.entity.vo.sina.SinaAppCateVO;
import com.fq.dao.entity.vo.sina.SinaContentCateVO;
import com.fq.dao.entity.vo.sina.SinaPopularizeVO;
import com.fq.util.DateFormatUtil;

/**
 * 
 * @author zhen.cheng
 *
 */
@Repository("sinaPopularizeDAO")
public class SinaPopularizeDaoImpl extends BaseDAO implements SinaPopularizeDAO{

	@Override
	public List<Map<String, Object>> listSinaPopularizerRecord(
			Map<String, Object> para) throws Exception {
		List<Map<String, Object>> spData = getSqlMapClientTemplate().queryForList("SinaPopularizeDaoImpl.listSinaPopularizerRecord", para);
		for(Map<String, Object> map:spData){
			Long time = new Long((long) map.get("lastModifiedDate"));
			String dateString = DateFormatUtil.getTimeByMillis(time);
			map.put("lastModifiedDate",dateString);
		}
		return spData;
	}

	@Override
	public Integer getSinaPopularizerRecord(Map<String, Object> para) {
		return (Integer) getSqlMapClientTemplate().queryForObject("SinaPopularizeDaoImpl.getSinaPopularizerRecord", para);
	}
	/**
	 * 删除整条记录，其自内容也将被删除
	 */
	@Override
	public void deleteSinaPopularizerRecord(String id) {
		getSqlMapClientTemplate().delete("SinaPopularizeDaoImpl.deleteSinaPopularizerRecord", id);
	}
	/**
	 * 查询新浪推广app记录
	 */
	@Override
	public List<Map<String, Object>> querySinaPopularizerApp(
			Map<String, Object> para) {
		return getSqlMapClientTemplate().queryForList("SinaPopularizeDaoImpl.querySinaPopularizerApp", para);
	}
	
	@Override
	public Integer getSinaPopularizerAppCount(Map<String, Object> para) {
		return (Integer) getSqlMapClientTemplate().queryForObject("SinaPopularizeDaoImpl.getSinaPopularizerAppCount", para);
	}
	/**
	 * 查询新浪推广app记录总数
	 * @throws Exception 
	 */
	@Override
	public List<Map<String, Object>> querySinaPopularizerContent(
			Map<String, Object> para)  {
		 return  getSqlMapClientTemplate().queryForList("SinaPopularizeDaoImpl.querySinaPopularizerContent", para);
	}
	/**
	 * 查询新浪推广app记录总数
	 */
	@Override
	public Integer getSinaPopularizerContentCount(Map<String, Object> para) {
		return (Integer) getSqlMapClientTemplate().queryForObject("SinaPopularizeDaoImpl.getSinaPopularizerContentCount", para);
	}

	@Override
	public List<Map<String, Object>> querySinaPopularizerAppNo(
			Map<String, Object> para) {
		return getSqlMapClientTemplate().queryForList("SinaPopularizeDaoImpl.querySinaPopularizerAppNo", para);
	}

	@Override
	public List<Map<String, Object>> querySinaPopularizerContentNo(
			Map<String, Object> para) {
		return getSqlMapClientTemplate().queryForList("SinaPopularizeDaoImpl.querySinaPopularizerContentNo", para);
	}

	@Override
	public SinaPopularizePO1 querySinaPopularizerRecord(Map<String, Object> para) throws Exception {
		SinaPopularizeVO spData = (SinaPopularizeVO) getSqlMapClientTemplate().queryForObject("SinaPopularizeDaoImpl.querySinaPopularizerRecord", para);
		Long time = new Long( spData.getLastModifiedDate());
		String dateString = DateFormatUtil.getTimeByMillis(time);
		SinaPopularizePO1 sinaPopularize = new SinaPopularizePO1();
		sinaPopularize.setSpId(spData.getSpId());
		sinaPopularize.setId(spData.getId());
		sinaPopularize.setClickBehavior(spData.getClickBehavior());
		sinaPopularize.setContent(spData.getContent());
		sinaPopularize.setContentFormat(spData.getContentFormat());
		sinaPopularize.setContentImageUri(spData.getContentImageUri());
		sinaPopularize.setCount(spData.getCount());
		sinaPopularize.setImageUri(spData.getImageUri());
		sinaPopularize.setLastModifiedDate(dateString);
		sinaPopularize.setProductKey(spData.getProductKey());
		sinaPopularize.setShortUri(spData.getShortUri());
		sinaPopularize.setSummary(spData.getSummary());
		sinaPopularize.setTest(spData.getTest());
		sinaPopularize.setTitle(spData.getTitle());
		sinaPopularize.setContentUri(spData.getContentUri());
		return sinaPopularize;
	}

	@Override
	public void changeSinaApp(Map<String, Object> para) {
		getSqlMapClientTemplate().update("SinaPopularizeDaoImpl.changeSinaApp", para);
	}

	@Override
	public void changeSinaContent(Map<String, Object> para) {
		getSqlMapClientTemplate().update("SinaPopularizeDaoImpl.changeSinaContent", para);
	}

	@Override
	public void updateSinaPopularizerInfo(SinaPopularizeVO sinaPopularizeVO) {
		getSqlMapClientTemplate().update("SinaPopularizeDaoImpl.updateSinaPopularizerInfo", sinaPopularizeVO);
	}

	@Override
	public void deleteSinaPopularizerContent(Integer spId) {
		getSqlMapClientTemplate().delete("SinaPopularizeDaoImpl.deleteSinaPopularizerContent", spId);
	}

	@Override
	public void deleteSinaPopularizerApp(Integer spId) {
		getSqlMapClientTemplate().delete("SinaPopularizeDaoImpl.deleteSinaPopularizerApp", spId);
	}

	@Override
	public SinaContentCateVO getSinaPopularizeContentBySccId(String sccId) {
		 return (SinaContentCateVO) getSqlMapClientTemplate().queryForObject("SinaPopularizeDaoImpl.getSinaPopularizeContentBySccId", sccId);
	}

	@Override
	public SinaAppCateVO getSinaPopularizeAppBySacId(String sacId) {
		return (SinaAppCateVO) getSqlMapClientTemplate().queryForObject("SinaPopularizeDaoImpl.getSinaPopularizeAppBySacId", sacId);
	}

	@Override
	public void addSinaPopularizerContent(SinaContentCateVO sinaContentCateVO) {
		getSqlMapClientTemplate().insert("SinaPopularizeDaoImpl.addSinaPopularizerContent", sinaContentCateVO);
	}

	@Override
	public void addSinaPopularizerApp(SinaAppCateVO sinaAppCateVO) {
		getSqlMapClientTemplate().insert("SinaPopularizeDaoImpl.addSinaPopularizerApp", sinaAppCateVO);
	}

	@Override
	public void deleteSinaPopularizerContentBySccId(String sccId) {
		getSqlMapClientTemplate().delete("SinaPopularizeDaoImpl.deleteSinaPopularizerContentBySccId", sccId);
	}

	@Override
	public void deleteSinaPopularizerAppBySacId(String sacId) {
		getSqlMapClientTemplate().delete("SinaPopularizeDaoImpl.deleteSinaPopularizerAppBySacId", sacId);
	}

	@Override
	public void insertSinaPopularizerInfo(SinaPopularizeVO sinaPopularizeVO) {
		getSqlMapClientTemplate().insert("SinaPopularizeDaoImpl.insertSinaPopularizerInfo", sinaPopularizeVO);
	}

	@Override
	public Integer getSinaPopularizerById(String id) {
		return (Integer) getSqlMapClientTemplate().queryForObject("SinaPopularizeDaoImpl.getSinaPopularizerById", id);
	}

}
