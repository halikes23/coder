package com.fq.dao.impl.cartoon;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Repository;

import com.fq.dao.BaseDAO;
import com.fq.dao.dao.cartoon.CartoonDAO;
import com.fq.dao.entity.po.LiveCartoonRankPO;
import com.fq.dao.entity.vo.livecartoon.LiveCartoonChapterVO;
import com.fq.dao.entity.vo.livecartoon.LiveCartoonInfoVO;
import com.fq.dao.entity.vo.livecartoon.LiveCartoonPageVO;
import com.fq.form.report.QueryCartoonProjectForm;
import com.ibatis.sqlmap.client.SqlMapExecutor;

@Repository
public class CartoonDaoImpl extends BaseDAO implements CartoonDAO {

	
	private static final int Integer = 0;

	@Override
	public List<Map<String, Object>> selectLiveCartoonChaptersByPlcId(
			Integer plcId) {
		return this.getSqlMapClientTemplate().queryForList("CartoonDaoImpl.selectLiveCartoonChaptersByPlcId",plcId) ;
	}

	@Override
	public List<Map<String, Object>> selectLiveCartoon(Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("CartoonDaoImpl.selectLiveCartoon", paramMap) ;
	}
	
	@Override
	public Integer selectLiveCartoonTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("CartoonDaoImpl.selectLiveCartoonTotals", paramMap);
	}
	
	@Override
	public Map<String, Object> selectLiveCartoonByPlcId(Integer plcId) {
		return (Map<String, Object>)this.getSqlMapClientTemplate().queryForObject("CartoonDaoImpl.selectLiveCartoonByPlcId",plcId);
				
	}

	@Override
	public void updateLiveCartoon(Map<String, Object> params) {
		this.getSqlMapClientTemplate().update("CartoonDaoImpl.updateLiveCartoon",params) ;
	}

	@Override
	public void insertLiveCartoonChapter(Map<String, Object> params) {
		this.getSqlMapClientTemplate().insert("CartoonDaoImpl.insertLiveCartoonChapter",params);
		
	}

	@Override
	public void updateLiveCartoonChapter(Map<String, Object> params) {
		this.getSqlMapClientTemplate().update("CartoonDaoImpl.updateLiveCartoonChapter",params) ;
	}
	@Override
	public List<LiveCartoonPageVO> queryLiveCartoonPagesByLcId(
			Integer lcId) {
		return getSqlMapClientTemplate().queryForList("CartoonDaoImpl.queryLiveCartoonPages", lcId );
	}

	@Override 
	public List<LiveCartoonPageVO> queryListCartoonPageByLcId(Integer lcId) {
		return this.getSqlMapClientTemplate().queryForList("CartoonDaoImpl.queryListCartoonPageByLcId",lcId) ;
		
	}

	@Override
	public void updateLiveCartoonPage(Map<String, Object> params) {
		this.getSqlMapClientTemplate().update("CartoonDaoImpl.updateLiveCartoonPage",params) ;
	}

	@Override
	public void insertLiveCartoonPage(Map<String, Object> params) {
		this.getSqlMapClientTemplate().insert("CartoonDaoImpl.insertLiveCartoonPage",params) ;
	}

	@Override
	public void addLiveCartoon(Map<String, Object> params) {
		this.getSqlMapClientTemplate().insert("CartoonDaoImpl.addLiveCartoon" , params) ;
	}

	@Override
	public void deleteLiveCartoonPage(Integer lcpId) {
		this.getSqlMapClientTemplate().update("CartoonDaoImpl.deleteLiveCartoonPage" , lcpId) ;
	}

	@Override
	public LiveCartoonChapterVO selectLiveCartoonChapterCoverUrl(
			Map<String, Object> params) {
		return (LiveCartoonChapterVO) getSqlMapClientTemplate().queryForObject("CartoonDaoImpl.selectLiveCartoonChapterCoverUrl", params );
	}

	@Override
	public void updateLiveCartoonChapterCoverUrl(Map<String, Object> params) {
		getSqlMapClientTemplate().update( "CartoonDaoImpl.updateLiveCartoonChapterCoverUrl", params) ;
	}

	@Override
	public void updateLiveCartoonOrderIndex(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("CartoonDaoImpl.updateLiveCartoonOrderIndex", paramMap ) ;
	}

	@Override
	public List<Map<String, Object>> queryCartoonProjectIdAndName() {
		return getSqlMapClientTemplate().queryForList("CartoonDaoImpl.queryCartoonProjectIdAndName");
	}

	@Override
	public List<Map<String, Object>> queryLiveCartoon(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("CartoonDaoImpl.queryLiveCartoon", paramMap );
	}

	@Override
	public void updateLiveCartoonChapterUpdatedState_Y(
			Map<String, Object> params) {
		getSqlMapClientTemplate().update("CartoonDaoImpl.updateLiveCartoonChapterUpdatedState_Y", params ) ;
	}

	@Override
	public void updateLiveCartoonChapterUpdatedState_N(
			Map<String, Object> params) {
		getSqlMapClientTemplate().update("CartoonDaoImpl.updateLiveCartoonChapterUpdatedState_N", params ) ;
	}
	
	@Override
	public void changeHaveProjectMovie(Map<String, Object> para) {
		getSqlMapClientTemplate().update("CartoonDaoImpl.changeHaveProjectMovie", para);
	}
	
	@Override
	public void insertCoverUrl(Map<String, Object> params) {
		getSqlMapClientTemplate().insert("CartoonDaoImpl.insertCoverUrl", params ) ;
	}
	

	@Override
	public Map<String, Object> queryLivecartoonConfig(Map<String, Object> params) {
		return   (Map<String, Object>) getSqlMapClientTemplate().queryForObject("CartoonDaoImpl.selectLivecartoonConfig", params) ;
	}
	

	@Override
	public void updateLiveCartoonConfig(
			Map<String, Object> params) {
		getSqlMapClientTemplate().update("CartoonDaoImpl.updateLiveCartoonConfig", params ) ;
	}
	
	@Override
	public List<Map<String, Object>> selectLiveCartoonUnlockNum(Map<String, Object> paramMap) {
		return this.getSqlMapClientTemplate().queryForList("CartoonDaoImpl.selectLiveCartoonUnlockNum",paramMap);
	}

	@Override
	public void doUpdateLiveCartoonCurrentEpisode() {
		getSqlMapClientTemplate().execute(new SqlMapClientCallback<Integer>(){
			public Integer doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch() ;
				Map<String, Object> map = new HashMap<String, Object>();
					//查询更新状态下的最大更新集数和漫画ID
					List<LiveCartoonChapterVO> chapterInfoList = executor.queryForList( "CartoonDaoImpl.queryLiveCartoonChapterList") ;
					for(LiveCartoonChapterVO chapterVO : chapterInfoList ){
						map.put("plcId", chapterVO.getPlcId());
						map.put("maxEpisodeNo", chapterVO.getMaxEpisodeNo());
						//更新真人漫最新更新集数
						executor.update("CartoonDaoImpl.updateLiveCartoonCurrentEpisode" ,map);
					}
				executor.executeBatch() ;
				return null;
			}
		});
	}
	
	
	
	@Override
	public void updateLiveCartoonCurrentEpisode( ) {
		getSqlMapClientTemplate().update("CartoonDaoImpl.updateLiveCartoonCurrentEpisode") ;
	}

	@Override
	public LiveCartoonInfoVO queryLiveCartoonInfoByPlcId(
			Map<String, Object> paramMap) {
		return (LiveCartoonInfoVO) getSqlMapClientTemplate().queryForObject("CartoonDaoImpl.queryLiveCartoonInfoByPlcId", paramMap );
	}

	@Override
	public List<LiveCartoonChapterVO> queryLiveCartoonChapterByPlcId(
			Integer plcId) {
		return getSqlMapClientTemplate().queryForList("CartoonDaoImpl.queryLiveCartoonChapterByPlcId", plcId );
	}

	@Override
	public void updateLiveCartoonPromoteStatic(Map<String, Object> paramMap) {
		getSqlMapClientTemplate().update("CartoonDaoImpl.updateLiveCartoonPromoteStatic", paramMap ) ;
	}
	
	@Override
	public void insertCartoonPageCoverUrl(Map<String, Object> params) {
		this.getSqlMapClientTemplate().insert("CartoonDaoImpl.insertCartoonPageCoverUrl",params);
		
	}

	@Override
	public List<LiveCartoonPageVO> queryAllLiveCartoonPages() {
		return this.getSqlMapClientTemplate().queryForList("CartoonDaoImpl.queryAllLiveCartoonPages");
	}
	
	@Override
	public List<Map<String, Object>> queryLiveCartoonChapterBarrage(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("CartoonDaoImpl.queryLiveCartoonChapterBarrage",paramMap);
	}

	@Override
	public Integer queryLiveCartoonChapterBarrageTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("CartoonDaoImpl.queryLiveCartoonChapterBarrageTotals", paramMap);
	}
	
	@Override
	public void deleteLiveCartoonChapterBarrage(Map<String, Object> paramMap) {
		 this.getSqlMapClientTemplate().delete("CartoonDaoImpl.deleteLiveCartoonChapterBarrage" , paramMap) ;
	}
	
	
	@Override
	public void deleteLiveCartoonPageDubbing(Map<String, Object> paramMap) {
		 this.getSqlMapClientTemplate().delete("CartoonDaoImpl.deleteLiveCartoonPageDubbing" , paramMap) ;
	}
	
	@Override
	public void deleteSingleLiveCartoonPage(String lcpId) {
		this.getSqlMapClientTemplate().update("CartoonDaoImpl.deleteSingleLiveCartoonPage" , lcpId) ;
	}
	
	@Override
	public void changeCartoonChapterCoverUrl(Map<String, Object> params) {
		getSqlMapClientTemplate().update("CartoonDaoImpl.changeCartoonChapterCoverUrl", params ) ;
	}
	
	@Override
	public List<Map<String, Object>> queryLiveCartoonPageDubbing(
			Map<String, Object> paramMap) {
		return getSqlMapClientTemplate().queryForList("CartoonDaoImpl.queryLiveCartoonPageDubbing",paramMap);
	}

	@Override
	public Integer queryLiveCartoonPageDubbingTotals(Map<String, Object> paramMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("CartoonDaoImpl.queryLiveCartoonPageDubbingTotals", paramMap);
	}
	
	@Override
	public void deleteLiveCartoon(Integer plcId){
		this.getSqlMapClientTemplate().update("CartoonDaoImpl.deleteLiveCartoon" , plcId);
		
	}
	
	@Override
	public void deleteLiveCartoonChapter(Map<String, Object> paramMap){
		this.getSqlMapClientTemplate().update("CartoonDaoImpl.deleteLiveCartoonChapter" , paramMap);
		
	}
	
	@Override
	public Integer selectEpisodeNoByPlcId(Integer plcId) {
		return (Integer) getSqlMapClientTemplate().queryForObject("CartoonDaoImpl.selectEpisodeNoByPlcId", plcId);
	}
	
	@Override
	public void updateLiveCartoonCurrentEpisodeByPlcId(Map<String, Object> paramMap) {
		  getSqlMapClientTemplate().update("CartoonDaoImpl.updateLiveCartoonCurrentEpisodeByPlcId", paramMap);
	}
	
	@Override
	public void insertDeletedLiveCartoonChapter(Map<String, Object> paramMap) {
		this.getSqlMapClientTemplate().insert("CartoonDaoImpl.insertDeletedLiveCartoonChapter",paramMap);
		
	}
	
	@Override
	public List<LiveCartoonInfoVO> queryAllLiveCartoonInfo() {
		return this.getSqlMapClientTemplate().queryForList("CartoonDaoImpl.queryAllLiveCartoonInfo");
	}

	@Override
	public List<LiveCartoonInfoVO> queryLiveCartoonReport(
			QueryCartoonProjectForm form) {
		return this.getSqlMapClientTemplate().queryForList("CartoonDaoImpl.queryLiveCartoonReport" , form);
	}
	
	public void updateLiveCartoonRank() {
		getSqlMapClientTemplate().execute( new SqlMapClientCallback<Integer>() {
			public Integer doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				
				executor.startBatch() ;
				// 获取最近七天漫画播放量排行前五位的信息
				@SuppressWarnings("unchecked")
				List<LiveCartoonRankPO> rencentLiveCartoonRankPO = executor.queryForList( "CartoonDaoImpl.selectRecentLiveCartoonRankList" ) ; 
				if ( null ==  rencentLiveCartoonRankPO  || rencentLiveCartoonRankPO.isEmpty() ) {
					return null ;
				}
				// 删除 七日榜中的历史漫画排行记录
				executor.delete("CartoonDaoImpl.deleteRankLiveCartoon");
				// 遍历榜单列表
				int i = 1 ;
				for (LiveCartoonRankPO liveCartoonRankPO : rencentLiveCartoonRankPO) {
					liveCartoonRankPO.setBusiType("2");
					liveCartoonRankPO.setRankNo(i);
					i++ ;
					// 插入新的漫画票房排行榜单
					executor.insert( "CartoonDaoImpl.insertRankLiveCartoon" , liveCartoonRankPO );
				}
				executor.executeBatch() ;
				return null;
			}
		}) ;
	}
	
	@Override
	public void updateToMovieSwitch(Map<String, Object> paraMap) {
		  getSqlMapClientTemplate().update("CartoonDaoImpl.updateToMovieSwitch", paraMap);
	}
	
	@Override
	public void updateLiveCartoonVisitNo() {
		  getSqlMapClientTemplate().update("CartoonDaoImpl.updateLiveCartoonVisitNo" );
	}
	
	@Override
	public LiveCartoonInfoVO selectLiveCartoonParamByPlcId(Object plcId) {
		return (LiveCartoonInfoVO) getSqlMapClientTemplate().queryForObject("CartoonDaoImpl.selectLiveCartoonParamByPlcId",plcId);
	}
	
	@Override
	public void updateLiveCartoonChapterVisitNo() {
		  getSqlMapClientTemplate().update("CartoonDaoImpl.updateLiveCartoonChapterVisitNo" );
	}
	
	@Override
	public List<Map<String, Object>> selectFreeEpisodeNoByPlcId(Integer plcId) {
		return  getSqlMapClientTemplate().queryForList("CartoonDaoImpl.selectFreeEpisodeNoByPlcId",plcId);
	}
	
	@Override
	public Integer selectSysCartoonShareKeyInt() {
		return (Integer) getSqlMapClientTemplate().queryForObject("CartoonDaoImpl.selectSysCartoonShareKeyInt");
	}
	
}


