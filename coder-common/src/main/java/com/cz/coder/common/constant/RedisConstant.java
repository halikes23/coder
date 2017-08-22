package com.cz.coder.common.constant;

public class RedisConstant {
	// 用户登录计数
	public final static String KEY_USER_LOGIN_TOTAL_COUNT = "ULTC" ;
	// 三方控制台登录SessionId
	public final static String TC_SESSIONID_PREFIX = "TC:S:ID:" ;
	// 接口访问统计
	public static final String KEY_SERVLET_PATH = "SP" ;
	// 漫画浏览总数
	public static final String KEY_LIVE_CARTOON_PLAY_TOTAL_COUNT = "LCPTC" ;
	// 漫画浏览账号数
	public static final String KEY_LIVE_CARTOON_PLAY_ACCOUNT = "LCPA" ;
	// 各漫画浏览数
	public static final String KEY_LIVE_CARTOON_PLAY_EACH_COUNT = "LCPEC" ;
	// 影片播放总数
	public static final String KEY_MOVIE_PLAY_TOTAL_COUNT = "MPTC" ;
	// 影片播放账号数
	public static final String KEY_MOVIE_PLAY_ACCOUNT = "MPA" ;
	// 各影片播放数
	public static final String KEY_MOVIE_PLAY_EACH_COUNT = "MPEC" ;
	// banner
	public static final String KEY_BANNERS = "banners" ;
	// 漫画弹幕缓存刷新监听内网访问URL
	public static final String KEY_LC_BARRAGE_CACHE_FLUSH_LISTENER_INTRANET_URL = "LCBCFIU" ;
	// 影片弹幕缓存刷新监听内网访问URL
	public static final String KEY_M_BULLET_SCREEN_CACHE_FLUSH_LISTENER_INTRANET_URL = "MBSCFIU" ;
	// 漫画章节页信息(散列类型hash)  live.cartoon.chapter.page.info:lcpid 
	public static final String PREFIX_LIVE_CARTOON_CHAPTER_PAGE_LCPID = "LCCPI:" ;
	// 漫画章节-页信息关系(列表类型list) live.cartoon.chapter.and.page.map:lcid
	public static final String PREFIX_LIVE_CARTOON_CHAPTER_PAGE_MAP_LCID = "LCCAPM:" ;
	
}
