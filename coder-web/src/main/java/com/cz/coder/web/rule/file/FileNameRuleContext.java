package com.fq.rule.file;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * 文件命名规则容器
 * @author MaiBenBen
 *
 */
public class FileNameRuleContext {

	private final static Map<FileNameRuleEnum,IFileNameRule<?>> RULES ;
	
	static{
		
		Map<FileNameRuleEnum,IFileNameRule<?>> rules = new HashMap<FileNameRuleEnum,IFileNameRule<?>>() ;
		
		rules.put( FileNameRuleEnum.ACTOR_REPORT , new ActorReportFileNameRule()) ;
		
		rules.put( FileNameRuleEnum.PROJECT_REPORT , new ProjectReportFileNameRule()) ;
		
		rules.put(FileNameRuleEnum.MOVIE_REPORT , new MovieReportFileNameRule());
		
		rules.put(FileNameRuleEnum.ADD_HEAL_REPORT, new AddHealReportFileNameRule());
		
		rules.put(FileNameRuleEnum.GIFT_PICTURE, new GiftPictureFileNameRule());
		
		rules.put(FileNameRuleEnum.LOG_PICTURE,new LogPictureFileNameRule());
		
		rules.put(FileNameRuleEnum.LOG_MOVIE, new LogMovieFileNameRule());
		
		rules.put(FileNameRuleEnum.MOVIE, new MovieFileNameRule());
		
		rules.put(FileNameRuleEnum.MOVIE_COVER, new MovieCoverFileNameRule());
		
		rules.put(FileNameRuleEnum.PROJECT_COVER, new ProjectCoverFileNameRule());
		
		rules.put(FileNameRuleEnum.PROJECT_CREW_COVER, new ProjectCrewCoverFileNameRule());
		
		rules.put(FileNameRuleEnum.ALBUM, new AlbumFileNameRule());
		
		rules.put(FileNameRuleEnum.START_PAGE, new StartPageFileNameRule());
		
		rules.put(FileNameRuleEnum.ALL_PROJECT_REPORT, new AllProjectFileNameRule());
		
		rules.put(FileNameRuleEnum.PROJECT_ORIGINAL_COVER, new ProjectOriginalCoverFileNameRule());
		
		rules.put(FileNameRuleEnum.LIVE_CARTOON_PICTURE, new LiveCartoonCoverFileNameRule());
		
		rules.put(FileNameRuleEnum.MOVIE_PAPA_REPORT, new MoviePapaReportFileNameRule());
		
		rules.put(FileNameRuleEnum.WEEK_TRADE_CONSUME_REPORT, new WeekTradeConsumeReportFileNameRule());
		
		rules.put(FileNameRuleEnum.TRADE_CONSUME_REPORT, new TradeConsumeReportFileNameRule());
		
		rules.put(FileNameRuleEnum.TRADE_INFO_REPORT, new TradeInfoReportFileNameRule());
		
		rules.put(FileNameRuleEnum.HIS_TRADE_INFO_REPORT, new HistroyTradeInfoReportFileNameRule());
		
		rules.put(FileNameRuleEnum.ACTIVE_AWARD_REPORT, new ActiveAwardReportFileNameRule());
		
		rules.put(FileNameRuleEnum.ACTIVE_URL, new ActiveUrlFileNameRule());
		
		rules.put(FileNameRuleEnum.ACTIVE_SUCC_URL, new ActiveSuccUrlFileNameRule());
		
		rules.put(FileNameRuleEnum.UNLOCK_LIVE_CARTOON , new UnlockLiveCartoonFileNameRule() );
		
		rules.put(FileNameRuleEnum.OSCAR_ACTIVE_URL, new OscarActiveUrlFileNameRule());
		
		rules.put(FileNameRuleEnum.OSCAR_ACTIVE_VOTE_URL, new OscarActiveVoteUrlFileNameRule());
		
		rules.put(FileNameRuleEnum.ACTIVE_BGI_TWO, new OscarActiveUrlTwoFileNameRule());
		
		rules.put(FileNameRuleEnum.ACTIVE_BGI_THREE, new OscarActiveUrlThreeFileNameRule());
		
		rules.put(FileNameRuleEnum.BUY_VOTE_REPORT, new BuyVoteFileNameRule());
		
		rules.put(FileNameRuleEnum.VOTE_LOG_REPORT, new VoteLogFileNameRule());
		
		rules.put(FileNameRuleEnum.GIVE_VOTE_REPORT, new GiveVoteFileNameRule());
		
		rules.put(FileNameRuleEnum.USER_INFO, new UserInfoNameRule());
		
		rules.put(FileNameRuleEnum.CARTOON_REPORT, new CartoonReportNameRule());
		
		rules.put(FileNameRuleEnum.BULLET_SCREEN,  new BulletScreenNameRule());
		
		rules.put(FileNameRuleEnum.NEW_USER,  new NewUserNameRule());
		
		rules.put(FileNameRuleEnum.USER_MOBILE,  new UserMobileNameRule());
		
		rules.put(FileNameRuleEnum.NOVEL_REPORT,  new NovelReportNameRule());
		
		rules.put(FileNameRuleEnum.NOVEL_MONTH_REPORT,  new NovelMonthReportNameRule());
		
		rules.put(FileNameRuleEnum.NOVEL_DAY_REPORT,  new NovelDayReportNameRule());
		
		
		RULES = Collections.unmodifiableMap(rules) ;
		
	}
	
	@SuppressWarnings("rawtypes")
	public static IFileNameRule get( FileNameRuleEnum rule ){
		return RULES.get(rule) ;
	}
	
	
	
}
