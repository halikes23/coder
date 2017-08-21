package com.fq.dao.dao.cartoon;

import java.util.List;
import java.util.Map;

import com.fq.dao.entity.vo.livecartoon.LiveCartoonChapterVO;
import com.fq.dao.entity.vo.livecartoon.LiveCartoonInfoVO;
import com.fq.dao.entity.vo.livecartoon.LiveCartoonPageVO;
import com.fq.form.report.QueryCartoonProjectForm;

/**
 * 真人漫Dao
 * @author zhen.cheng
 *
 */
public interface CartoonDAO {

	List<Map<String, Object>> selectLiveCartoonChaptersByPlcId(Integer piId);

	//List<Map<String, Object>> selectLiveCartoon(Map<String, Object> paramMap);
	
	Integer selectLiveCartoonTotals(Map<String, Object> paramMap);

	Map<String, Object> selectLiveCartoonByPlcId(Integer plcId);

	void updateLiveCartoon(Map<String, Object> params);

	void insertLiveCartoonChapter(Map<String, Object> paramMap);

	void updateLiveCartoonChapter(Map<String, Object> params);
	
	List<LiveCartoonPageVO> queryListCartoonPageByLcId(Integer lcId);
	
	List<LiveCartoonPageVO> queryLiveCartoonPagesByLcId(Integer lcId);

	void updateLiveCartoonPage(Map<String, Object> params);

	void insertLiveCartoonPage(Map<String, Object> params);
	
	void addLiveCartoon(Map<String, Object> params);

	void deleteLiveCartoonPage(Integer lcpId);

	LiveCartoonChapterVO selectLiveCartoonChapterCoverUrl(
			Map<String, Object> params);

	void updateLiveCartoonChapterCoverUrl(Map<String, Object> params);

	void updateLiveCartoonOrderIndex(Map<String, Object> paramMap);

	List<Map<String, Object>> queryCartoonProjectIdAndName();


	List<Map<String, Object>> queryLiveCartoon(Map<String, Object> paramMap);

	List<Map<String, Object>> selectLiveCartoon(Map<String, Object> paramMap);

	void updateLiveCartoonChapterUpdatedState_Y(Map<String, Object> params);

	void updateLiveCartoonChapterUpdatedState_N(Map<String, Object> params);

	void changeHaveProjectMovie(Map<String, Object> para);

	void insertCoverUrl(Map<String, Object> params);

	Map<String, Object> queryLivecartoonConfig(Map<String, Object> params);

	void updateLiveCartoonConfig(Map<String, Object> params);

	List<Map<String, Object>> selectLiveCartoonUnlockNum(Map<String, Object> paramMap);

	void updateLiveCartoonCurrentEpisode();

	LiveCartoonInfoVO queryLiveCartoonInfoByPlcId(Map<String, Object> paramMap);

	List<LiveCartoonChapterVO> queryLiveCartoonChapterByPlcId(
			Integer plcId);
	
	void updateLiveCartoonPromoteStatic(Map<String, Object> paramMap);

	List<LiveCartoonPageVO> queryAllLiveCartoonPages();

	void insertCartoonPageCoverUrl(Map<String, Object> params);

	List<Map<String, Object>> queryLiveCartoonChapterBarrage(
			Map<String, Object> paramMap);

	Integer queryLiveCartoonChapterBarrageTotals(Map<String, Object> paramMap);

	void deleteLiveCartoonChapterBarrage(Map<String, Object> paramMap);

	void deleteLiveCartoonPageDubbing(Map<String, Object> paramMap);

	void deleteSingleLiveCartoonPage(String lcpId);

	void changeCartoonChapterCoverUrl(Map<String, Object> params);

	List<Map<String, Object>> queryLiveCartoonPageDubbing(Map<String, Object> paramMap);

	Integer queryLiveCartoonPageDubbingTotals(Map<String, Object> paramMap);


	void doUpdateLiveCartoonCurrentEpisode();

	void deleteLiveCartoon(Integer plcId);

	void deleteLiveCartoonChapter(Map<String, Object> paramMap);
	
	Integer selectEpisodeNoByPlcId(Integer plcId);

	void updateLiveCartoonCurrentEpisodeByPlcId(Map<String, Object> paramMap);
	
	void insertDeletedLiveCartoonChapter(Map<String, Object> paramMap);

	List<LiveCartoonInfoVO> queryAllLiveCartoonInfo();

	List<LiveCartoonInfoVO> queryLiveCartoonReport(QueryCartoonProjectForm form);
	
	void updateLiveCartoonRank();
	
	void updateToMovieSwitch(Map<String, Object> paraMap);
	
	void updateLiveCartoonVisitNo();

	LiveCartoonInfoVO selectLiveCartoonParamByPlcId(Object plcId);

	void updateLiveCartoonChapterVisitNo();
	
	List<Map<String, Object>> selectFreeEpisodeNoByPlcId(Integer plcId);

	Integer selectSysCartoonShareKeyInt();
	
	

}