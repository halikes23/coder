package com.fq.entity.vo.novel;

public class NovelInfoVO {
	
	private Integer niId ;
	private String  novelName ;
	private String  novelDesc ;
	private String  novelAuthor ;
	private String  novelType ;
	private Integer currentChapterNum ;
	private String  updateState ; // 小说更新状态：1：连载中；2：已完结
	private String  novelCoverImg ;
	private Integer ntId; 
	private Integer freeChapterNum ; 
	private Integer readingNum ; 
	private Integer shareNum ; 
	private Integer unlockNum ; 
	private String  addState ; // 小说上架状态：1:上架；2:待审核;3:其他原因下架
	private String  hotFlag ; 
	private String  createDt ; 
	private String  createTm ;
	private String 	isChased ; // 是否已追：Y:已追；N:未追
	private String 	historyChapterNo ; // 历史阅读章节号若无则前端展示开始阅读
	private String 	ncId ; // 历史阅读章节id
	private Integer bId ; // 小说ID
	private Integer unitPrice ; //千字价格
	private Integer voteNum ; // 选票数量
	private Integer addVoteNum ; // 选票补数量
	private Integer commentNum ; // 评论数量
	private Integer commentFloor ; // 评论数量
	private String projectGroupCode ; // 分组码
	private String claimAccount ; //认领人账号
	private Integer rankNo ; //小说总榜排行编号
	private Integer claimRankNo ; //小说认领榜单排行标号
	private String supportRate ; // 支持率（百分比）
	private String  haveUpdate ; // 小说是否已更新 Y:有更新；N:无更新
	private String bookSource ; //小说来源 1 ：趣阅 2 寒武 3 阅明
	private String bookOrigin ; 
	private String haveUpdateTips ; // 是否有更新提示Y：有提示标签；N:无提示标签
	private String appSplitRatio ; 
	
	public Integer getNiId() {
		return niId;
	}

	public void setNiId(Integer niId) {
		this.niId = niId;
	}

	public String getNovelName() {
		return novelName;
	}

	public void setNovelName(String novelName) {
		this.novelName = novelName;
	}

	public String getNovelDesc() {
		return novelDesc;
	}

	public void setNovelDesc(String novelDesc) {
		this.novelDesc = novelDesc;
	}

	public String getNovelAuthor() {
		return novelAuthor;
	}

	public void setNovelAuthor(String novelAuthor) {
		this.novelAuthor = novelAuthor;
	}

	public String getNovelType() {
		return novelType;
	}

	public void setNovelType(String novelType) {
		this.novelType = novelType;
	}

	public Integer getCurrentChapterNum() {
		return currentChapterNum;
	}

	public void setCurrentChapterNum(Integer currentChapterNum) {
		this.currentChapterNum = currentChapterNum;
	}

	public String getUpdateState() {
		return updateState;
	}

	public void setUpdateState(String updateState) {
		this.updateState = updateState;
	}

	public String getNovelCoverImg() {
		return novelCoverImg;
	}

	public void setNovelCoverImg(String novelCoverImg) {
		this.novelCoverImg = novelCoverImg;
	}

	public Integer getNtId() {
		return ntId;
	}

	public void setNtId(Integer ntId) {
		this.ntId = ntId;
	}

	public Integer getFreeChapterNum() {
		return freeChapterNum;
	}

	public void setFreeChapterNum(Integer freeChapterNum) {
		this.freeChapterNum = freeChapterNum;
	}

	public Integer getReadingNum() {
		return readingNum;
	}

	public void setReadingNum(Integer readingNum) {
		this.readingNum = readingNum;
	}

	public Integer getShareNum() {
		return shareNum;
	}

	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}

	public Integer getUnlockNum() {
		return unlockNum;
	}

	public void setUnlockNum(Integer unlockNum) {
		this.unlockNum = unlockNum;
	}

	public String getAddState() {
		return addState;
	}

	public void setAddState(String addState) {
		this.addState = addState;
	}

	public String getHotFlag() {
		return hotFlag;
	}

	public void setHotFlag(String hotFlag) {
		this.hotFlag = hotFlag;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public String getCreateTm() {
		return createTm;
	}

	public void setCreateTm(String createTm) {
		this.createTm = createTm;
	}

	public String getIsChased() {
		return isChased;
	}

	public void setIsChased(String isChased) {
		this.isChased = isChased;
	}

	public String getHistoryChapterNo() {
		return historyChapterNo;
	}

	public void setHistoryChapterNo(String historyChapterNo) {
		this.historyChapterNo = historyChapterNo;
	}

	public String getNcId() {
		return ncId;
	}

	public void setNcId(String ncId) {
		this.ncId = ncId;
	}

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getVoteNum() {
		return voteNum;
	}

	public void setVoteNum(Integer voteNum) {
		this.voteNum = voteNum;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public String getProjectGroupCode() {
		return projectGroupCode;
	}

	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}

	public String getClaimAccount() {
		return claimAccount;
	}

	public void setClaimAccount(String claimAccount) {
		this.claimAccount = claimAccount;
	}

	public Integer getRankNo() {
		return rankNo;
	}

	public void setRankNo(Integer rankNo) {
		this.rankNo = rankNo;
	}

	public Integer getClaimRankNo() {
		return claimRankNo;
	}

	public void setClaimRankNo(Integer claimRankNo) {
		this.claimRankNo = claimRankNo;
	}

	public String getHaveUpdate() {
		return haveUpdate;
	}

	public void setHaveUpdate(String haveUpdate) {
		this.haveUpdate = haveUpdate;
	}

	public Integer getAddVoteNum() {
		return addVoteNum;
	}

	public void setAddVoteNum(Integer addVoteNum) {
		this.addVoteNum = addVoteNum;
	}

	public Integer getCommentFloor() {
		return commentFloor;
	}

	public void setCommentFloor(Integer commentFloor) {
		this.commentFloor = commentFloor;
	}

	public String getSupportRate() {
		return supportRate;
	}

	public void setSupportRate(String supportRate) {
		this.supportRate = supportRate;
	}

	public String getBookSource() {
		return bookSource;
	}

	public void setBookSource(String bookSource) {
		this.bookSource = bookSource;
	}

	public String getBookOrigin() {
		return bookOrigin;
	}

	public void setBookOrigin(String bookOrigin) {
		this.bookOrigin = bookOrigin;
	}

	public String getHaveUpdateTips() {
		return haveUpdateTips;
	}

	public void setHaveUpdateTips(String haveUpdateTips) {
		this.haveUpdateTips = haveUpdateTips;
	}

	public String getAppSplitRatio() {
		return appSplitRatio;
	}

	public void setAppSplitRatio(String appSplitRatio) {
		this.appSplitRatio = appSplitRatio;
	}

	
}
