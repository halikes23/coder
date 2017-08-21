package com.fq.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fq.dao.BaseDAO;
import com.fq.dao.dao.ProductCountDAO;
import com.fq.dao.entity.vo.UserProductMonthIncomeVO;
import com.fq.entity.vo.CartoonChannelIncomeVO;

@Repository
public class ProductCountDaoImpl extends BaseDAO implements ProductCountDAO{

	@Override
	public String selectUserProductYesterdayIncome(Integer adminId) {
		return (String) getSqlMapClientTemplate().queryForObject("ProductCountDaoImpl.selectUserProductYesterdayIncome" , adminId);
	}
	
	@Override
	public String selectUserProductMonthIncome(Integer adminId) {
		return (String) getSqlMapClientTemplate().queryForObject("ProductCountDaoImpl.selectUserProductMonthIncome" , adminId);
	}
	
	@Override
	public String selectUserProductTotalIncome(Integer adminId) {
		return (String) getSqlMapClientTemplate().queryForObject("ProductCountDaoImpl.selectUserProductTotalIncome" , adminId);
	}

	@Override
	public List<UserProductMonthIncomeVO> selectUserProductMonthIncomeInfoList(
			Map<String, Object> paraMap) {
		return getSqlMapClientTemplate().queryForList("ProductCountDaoImpl.selectUserProductMonthIncomeInfoList" ,paraMap);
	}

	@Override
	public String selectCartoonChannelIncomeByMonth(String month , Map<String, Object> paraMap ) {
		paraMap.put("month", month) ;
		return (String) getSqlMapClientTemplate().queryForObject("ProductCountDaoImpl.selectCartoonChannelIncomeByMonth" , paraMap);
	}
	
	@Override
	public List<UserProductMonthIncomeVO> selectUserMonthIncomeDetailInfoList(
			Map<String, Object> paraMap) {
		return getSqlMapClientTemplate().queryForList("ProductCountDaoImpl.selectUserMonthIncomeDetailInfoList" , paraMap);
	}

	@Override
	public Integer selectUserMonthIncomeDetailInfoListTotals(
			Map<String, Object> paraMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ProductCountDaoImpl.selectUserMonthIncomeDetailInfoListTotals" , paraMap);
	}

	@Override
	public List<CartoonChannelIncomeVO> selectCartoonChannelIncomeInfo(
			UserProductMonthIncomeVO userProductMonthIncomeVO) {
		return getSqlMapClientTemplate().queryForList("ProductCountDaoImpl.selectCartoonChannelIncomeInfo" , userProductMonthIncomeVO);
	}

	@Override
	public List<Map<String, Object>> selectUserProductInfoList(Integer adminId) {
		return getSqlMapClientTemplate().queryForList("ProductCountDaoImpl.selectUserProductInfoList" , adminId);
	}
	
	@Override
	public Integer selectUserProductMonthIncomeInfoListTotals(
			Map<String, Object> paraMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ProductCountDaoImpl.selectUserProductMonthIncomeInfoListTotals" , paraMap);
	}
	
	@Override
	public String selectBaseMoneyByMonth(String month , Map<String, Object> paraMap ) {
		paraMap.put("month", month) ;
		return (String) getSqlMapClientTemplate().queryForObject("ProductCountDaoImpl.selectBaseMoneyByMonth" , paraMap);
	}

	@Override
	public String selectCartoonMonthChannelIncome(Integer id, String month) {
		Map<String, Object> paraMap = new HashMap<>() ; 
		paraMap.put("id", id) ; 
		paraMap.put("month", month) ; 
		return (String) getSqlMapClientTemplate().queryForObject("ProductCountDaoImpl.selectCartoonMonthChannelIncome" , paraMap);
	}

	@Override
	public List<UserProductMonthIncomeVO> selectUserMonthIncomeAllInfoList(
			Map<String, Object> paraMap) {
		return getSqlMapClientTemplate().queryForList("ProductCountDaoImpl.selectUserMonthIncomeAllInfoList" , paraMap);
	}

	@Override
	public Integer selectUserMonthIncomeAllInfoListTotals(
			Map<String, Object> paraMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ProductCountDaoImpl.selectUserMonthIncomeAllInfoListTotals" , paraMap);
	}
	
	@Override
	public String selectProductTotalIncome(Integer id, String month) {
		Map<String, Object> paraMap = new HashMap<>() ; 
		paraMap.put("id", id) ; 
		paraMap.put("month", month) ;
		return (String) getSqlMapClientTemplate().queryForObject("ProductCountDaoImpl.selectProductTotalIncome" , paraMap);
	}
	
	
}
