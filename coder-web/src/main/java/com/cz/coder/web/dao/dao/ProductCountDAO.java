package com.fq.dao.dao;

import java.util.List;
import java.util.Map;

import com.fq.dao.entity.vo.UserProductMonthIncomeVO;
import com.fq.entity.vo.CartoonChannelIncomeVO;

public interface ProductCountDAO {

	String selectUserProductYesterdayIncome(Integer adminId);

	String selectUserProductMonthIncome(Integer adminId);

	String selectUserProductTotalIncome(Integer adminId);

	List<UserProductMonthIncomeVO> selectUserProductMonthIncomeInfoList(
			Map<String, Object> paraMap);

	String selectCartoonChannelIncomeByMonth(String month, Map<String, Object> paraMap);

	List<UserProductMonthIncomeVO> selectUserMonthIncomeDetailInfoList(
			Map<String, Object> paraMap);

	Integer selectUserMonthIncomeDetailInfoListTotals(
			Map<String, Object> paraMap);

	List<CartoonChannelIncomeVO> selectCartoonChannelIncomeInfo(
			UserProductMonthIncomeVO userProductMonthIncomeVO);

	List<Map<String, Object>> selectUserProductInfoList(Integer adminId);
	
	Integer selectUserProductMonthIncomeInfoListTotals(
			Map<String, Object> paraMap);

	String selectBaseMoneyByMonth(String month, Map<String, Object> paraMap);

	String selectCartoonMonthChannelIncome(Integer id, String month);

	List<UserProductMonthIncomeVO> selectUserMonthIncomeAllInfoList(
			Map<String, Object> paraMap);

	String selectProductTotalIncome(Integer id, String month);

	Integer selectUserMonthIncomeAllInfoListTotals(Map<String, Object> paraMap);
	
}
