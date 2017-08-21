package com.fq.common.constant;

import java.util.HashMap;
import java.util.Map;


/**
 * 返回结果
 * @author zhen.cheng
 *
 */
public class RetCode {
	
	public final static String KEY_RET_CODE = "code" ;
	public final static String KEY_CODE_MSG = "codeMsg";
//	public final static String KEY_RET_CODE = "Result" ;
//	public final static String KEY_CODE_MSG = "Desc";
	
	
	
	public final static String SUCCESS = "0" ;//成功
	
	public final static String NOT_POST = "01" ;//访问方式为POST
	
	public final static String LOST_PARAM = "03" ;//请求数据缺失
	
	public final static String PARAMS_PARAM = "06" ;//请求参数错误
	
	public final static String WRONG_PASSWORD = "05" ;//账户不存在或密码错误或者格式不对
	
	public final static String WRONG_DATE_FORMAT = "06" ;//时间格式不正确
	
	public final static String LOSE_TOKEN = "08" ;//TOKEN失效
	
	public final static String TOO_MORE_MOBLE_CODE_REQUEST = "09" ;//国语频繁的手机验证码请求
	
	public final static String SEND_CREATE_MOBLE_CODE_FAIL = "10" ;//发送短息验证码失败
	
	public final static String UPLOAD_FILE_FAILED = "11" ;//上传文件失败
	
	public final static String DATABASE_EXCEPTION = "12" ;//数据库异常
	
	public final static String MOBILE_CODE_CHECK_WRONG = "21" ;//验证码错误
	
	public final static String MOBILE_CODE_CREATE_ERROR = "22" ;//手机验证码生成失败
	
	public final static String MOBILE_EXISTS = "04" ;//注册用户已存在
	
	public final static String UNSUPPORT_FILE_SUFFIX = "13" ;//不支持的图片格式格式
	
	public final static String CREATE_QINIU_TOKEN_ERROR = "14" ;//获取七牛TOKEN失败
	
	public final static String ACCESS_MAGICWINDOW_API_ERROR = "15" ;// 访问魔窗接口失败
	
	public final static String GET_PLAY_URL_ERROR = "15" ;//获取播放地址失败
	
	public final static String RONGCLOUD_ACCESS_ERROR = "40" ;//融云服务器请求失败
	
	public final static String RONGCLOUD_GET_TOKEN_FAIL = "41" ;//获取融云TOKEN失败
	
	public final static String GET_IMG_URL_ERROR="42";// 获取图片Url地址失败
	
	public static final String ADMIN_HAS_EXISTS = "50";// 账号已经存在
	
	public final static String HAS_BEAN_FRIEND = "51" ;//发送好友请求失败-已经为好友
	
	public static final String ROLE_HAS_EXISTS = "51";// 角色已经存在
	
	public final static String MOBILE_IS_NONE = "53" ;//手机号码不存在
	
	public final static String WRONG_MOBILENUM="60";//验证用户手机号格式是否正确
	
	public final static String WRONG_SEX="61";//验证用户性别是否合法
	
	public final static String WRONG_PARAM="62";// 验证参数是否为空
	
	public final static String CANNOT_NULL = "97";
	
	public final static String DATA_ERROR = "98" ;//数据异常
	
	public final static String 	SYSTEM_ERROR = "99" ;//系统异常
	
	public final static String REDIS_ACCESS_ALL_SERVER_ERR = "9900" ;

	public final static String REDIS_LIMIT_ACCESS_PREMISSION = "9901";	// 
	
	public final static String REDIS_IS_READONLY = "9902";
	
	public final static String REDIS_CANNOT_OPEN_CONNECTION = "9903" ;
	
	public final static String REDIS_ACCESS_REDIS_SERVER_ERROR = "9904" ;
	
	public final static String REDIS_UNSUPPORT_COMMAND = "9905" ;
	
	private static Map<String,String> msgs = new HashMap<String,String>() ;
	
	private final static Map<String,String> unmodifiableMsgs ;
	
	public final static String IMGS_NUM = "101" ;//数据异常
	
	public final static String ACCT_NULL = "102" ;//查询结果为空
	
	public final static String TOPIC_IS_NOT_VISIBLE = "110" ;// 话题已被删除
	
	/*
	 * USER
	 */
	public final static String USER_IS_NOT_VISIBLE = "120" ;// 用户不存在
	
	public final static String USER_DOES_NOT_HAVE_PERMISSIONS = "121" ;// 用户没有权限
	
	public final static String USER_IS_ALREADY_EXISTS = "122";// 用户已经在 
	
	public final static String USER_NICK_IS_ALREADY_EXISTS = "123";// 用户已经在 
	
	public final static String USER_IS_NOT_IN_CREW = "124";// 用户不在演員表中 
	
	public final static String USER_INVITE_CODE_IS_INVALID = "125";//  兑换码无效
	
	public final static String USER_INVITE_CODE_IS_BEYOND = "126";//  兑换码已达今日使用上限
	
	public final static String USER_INVITE_CODE_SAME_EQUIPMENT = "127";//  相同设备 
	
	public final static String USER_INVITE_CODE_IS_INVITED = "128";// 
	
	public final static String USER_INVITE_CODE_THEMSELF = "129";//  用户不能使用自己的兑换码哦
	
	public final static String USER_IS_REFUSE = "130" ;// 用户已被禁言
	
	public final static String USER_IS_GAG = "131" ;// 用户已被禁言
	public final static String USER_HAD_SHARED = "132" ;// 用户今天已经分享过了
	public final static String USER_REWARD_NOT_ENOUGH = "133" ; // 用户赏金余额不足
	/*
	 * QINIU
	 */
	public final static String QINIU_RESOURCE_SUFFIX_WRONG = "141" ;
	
	public final static String QINIU_RESOURCE_TYPE_WRONG = "142";//未选择资源分类
	
	public final static String ORDER_ERROR = "150";// 生成订单信息有误
	
	public final static String ORDER_NOT_EXISTS = "151"; // 订单信息不存在
	public final static String ORDER_SUPPLEMENT_FAILED = "152"; // 补单失败
	public final static String ORDER_ALREADY_FINISHED = "153"; // 订单已经结束
	public final static String ORDER_PINGPP_PAID_FAILED = "154"; // pingpp订单未支付
	public final static String ORDER_IOS_FAILED= "155"; // ios订单暂时不能支付
	/*
	 * Active
	 */
	public final static String ACTIVE_DEVICE_IS_USED = "160"; // 该设备已经领取过（只对新用户有效）
	public final static String ACTIVE_MOBILE_IS_USED = "161"; // 该手机号码已被使用
	public final static String ACTIVE_ACCOUNT_IS_USED = "162"; // 该帐号已经领取过了
	public final static String ACTIVE_IS_NOT_VISIABLE = "163"; // 活动信息不存在
	public final static String ACTIVE_ONLY_NEW_REGISTER = "164"; // 活动信息不存在
	
	/**
	 * JNWTV 
	 */
	public final static String MOVIE_IS_NOT_EXISTS = "3090";// 影片不存在
	
	public final static String MOVIE_NODE_IS_NOT_EXISTS = "3091";// 影片片段不存在
	
	public final static String MOVIE_IS_COLLECTED = "4001";// 影片已经收藏
	
	public final static String MOVIE_IS_NOT_COLLECTED = "4002";// 未收藏该影片
	
	public final static String MOVIE_IS_LIKED = "4003";// 已经点赞
	
	public final static String MOVIE_IS_NOT_LIKED = "4004";// 未点赞
	
	public final static String CAN_NOT_REATTENTION ="4005";// 不能重复关注
	
	public final static String IS_NOT_ATTENTION ="4006";// 未关注

	public final static String CAN_NOT_REWARD_USERSELF = "4007";	// 用户不可以打赏自己
	
	public final static String USER_HEAD_IS_NULL = "4008";// 用户头像为空
	
	public final static String USER_JPOINT_IS_NOT_FULL = "4009";// 余额不足
	
	public final static String COMMENT_MISS = "4010";// 余额不足
	
	public final static String IS_PRAISE = "4011";// 已点赞
	
	public final static String IS_NOT_PRAISE = "4012";// 未点赞
	
	public final static String USER_PRAISE_ERROR = "4013";// 点赞/取消赞失败
	
	public final static String BULLET_SCREEN_CAN_NOT_REPEAT_SEND = "4014";// 同一弹幕30s内不可重复发送
	
	public final static String CAN_NOT_ATTENTION_YOURSELF = "4015" ;  //不能关注自己
	
	public final static String NOTIFICATION_REPLY_MSG_OUT_OF_RANG = "4051" ;  //用户消息回复内容太长
	public final static String NOTIFICATION_IS_NOT_VISIABLE = "4052" ;  //用户消息不存在
	public final static String NOTIFICATION_HAVE_REPLIED = "4053" ;  // 该条消息已经被回复过
	
	/**
	 * 项目状态码
	 */
	public final static String CAN_NOT_REPLY_USERSELF="4021";// 回复评论失败
	
	public final static String PROJECT_IS_NULL="4032";// 项目不存在
		
	public final static String COMMENT_IS_NULL="4040";// 评论不存在
	
	public final static String HOT_COMMENT_IS_NULL="4041";// 热门评论不存在
	
	public final static String PROJECT_IS_HEAL_FULL = "4051";// 项目已经完成加血
	
	public final static String HEAL_AMOUNT_ERROR = "4052";// 加血数量有误
	
	public final static String CAN_NOT_RECOMMENT = "4053" ; //10秒不能重复评论
	
	public final static String USER_CHASE_PROJECT_ERROR = "4055" ; //项目追剧或者取消追剧失败
	/*
	 * 日志
	 */

	public final static String PROJECT_LOG_DOSE_NOT_EXISTS = "4060"; // 项目日志不存在
	
	public final static String PROJECT_LOG_POST_COMMENT_ERROR = "4061"; // 项目日志评论发表失败
	
	public final static String PROJECT_LOG_COMMENT_DOES_NOT_EXISTS = "4062"; // 项目日志评论不存在
	
	public final static String PROJECT_LOG_RESOURCE_TITLE_TOO_LONG = "4071"; // 资源帖标题太长
	/*
	 * 项目漫画异常码
	 */
	public final static String PROJECT_LIVE_CARTOON_IS_NULL = "4101" ; // 项目漫画还在制作中
	public final static String LIVE_CARTOON_IS_NULL = "4102" ; // 该话还在制作中
	public final static String LIVE_CARTOON_HAVE_CHASED = "4103" ; // 不能重复追漫画
	public final static String LIVE_CARTOON_HAVE_NOT_CHASED = "4104" ; // 还没有追过该漫画
	public final static String LIVE_CARTOON_HAVE_PERMISION = "4105" ; // 该用户不需要支付费用
	public final static String LIVE_CARTOON_HAVE_NO_PERMISION = "4106" ; // 用户没有权限
	public final static String LIVE_CARTOON_DUBBING_HAVE_NO_PERMISION = "4107" ; // 用户没修改权限
	public final static String LIVE_CARTOON_DUBBING_IS_NULL = "4108" ; // 漫画配音不存在
	public final static String LIVE_CARTOON_LOCATION_IS_USELESS = "4109" ; // 位置不正确
	
	public final static String PROJECT_WALLPAPER_NOT_EXISTS = "4110" ; // 壁纸不存在 
	public final static String LIVE_CARTOON_LOCATION_IS_SHARED = "4111" ; // 已经分享过了
	
	public final static String LIVE_CARTOON_SHARED_TOO_OFTEN = "4120" ; // 分享太频繁了
	
	
	/**
	 * 支付状态码
	 */
	public final static String CDKEY_IS_NULL="5001";  //输入的key值不存在
	
	public final static String LOST_CDKEY="5002";   //输入的cdkey已经无效了
	
	public final static String CDKEY_NOT_YET_STARTED ="5003";   // 还未到兑换时间
	
	public final static String CDKEY_OUT_OF_DATE ="5004";   //输入的cdkey已经过期了
	
	public final static String CDKEY_BEYOND_LIMIT ="5005";   // 超出使用限制
	
	public final static String ERROR_MORE_THAN_TEN="5010"; //输入错误次数超过10次
	
	public final static String HEAL_CANNOT_UNDER_LIMIT = "5104"; // 加血量不能低于10 
	
	/*
	 * 钱包相关异常码
	 */
	public final static String WALLET_IS_NOT_ENOUGH = "5110"; // 用户钱包余额不足
	public final static String WALLET_WITHDRAW_CHANNEL_IS_UNBIND = "5111"; // 用户提现渠道未绑定
	public final static String WALLET_WITHDRAW_BATCH_EXCEPTION = "5112"; // 用户提现渠道未绑定
	public final static String WALLET_WITHDRAW_APP_ORDER_ERROR = "5113" ; // 用户提现渠道
	public final static String WALLET_WITHDRAW_NOT_EXPIRED = "5114" ; // 未到提现时间
	
	public final static String WALLET_CHANNEL_BIND_TOO_MANY = "5115"; // 渠道绑定超过上限
	
	public final static String RED_PACKET_NOT_NOT_EXPIRED = "5120"; // 红包要在周末才能开启哦
	public final static String RED_PACKET_INVALID= "5121"; // 红包信息无效
	public final static String RED_PACKET_ACTIVE_CLOSED = "5122";//  来晚了宝宝，红包活动咔嚓结束了
	
	// 七牛资源服务器错误
	public final static String QINIU_SERVER_ERROR = "140" ;
	
	public final static String QINIU_SERVER_ERROR_URL = "145";
	/**
	 * 第三方登陆失败状态码
	 */
	public final static String LOGIN_BY_QQ_ERROR = "1001" ;
	
	public final static String LOGIN_BY_WEIXIN_ERROR = "1002" ;
	
	public final static String LOGIN_BY_WEIBO_ERROR = "1003" ;
	
	public final static String PIC_URL_ERROR = "1004";
	
	/*
	 * 礼物系统状态码
	 */
	public final static String GIFT_IS_NOT_EXISTS = "2001" ; // 该礼品已下架
	
	public final static String GIFT_GIVING_NOT_EXISTS = "2002" ; // 礼单不存在
	
	public final static String LIKING_REL_NOT_EXITS = "2003" ; // 好感关系不存在
	
	/**
	 * 苹果内购
	 */
	public final static String TRADE_CHECK_ERROR = "1109" ; 
	
	public final static String PRODUCT_IS_NOT_EXIST = "1111";
	
	/**
	 * common  启动页异常
	 */
	public final static String COMMON_START_PAGE_NULL = "6001" ;// 启动页无更新 
	
	/**
	 * 剧点任务异常状态码
	 */
	public final static String TASK_INFO_IS_NULL = "7001" ;
	
	public final static String EXCHANGE_ERROR = "7002" ;
	
	public final static String EXCHANGE_ERROR_REPEAT_RECEIVE = "7003" ;
	
	/**
	 * 活动相关异常状态码
	 */
	public final static String ACTIVITY_IS_NOT_VISIBLE = "8001" ;
	/**
	 * 演员活动
	 */
	public final static String OSCAR_ACTIVE_IS_NOT_VISIBLE = "8200" ; // 活动信息不存在
	public final static String OSCAR_ACTIVE_IS_OUT_OF_DATE = "8201" ; // 活动信息已过期
	public final static String OSCAR_ACTIVE_VOTE_IS_NOT_VISIBLE = "8210" ; // 选票信息不存在
	public final static String OSCAR_ACTIVE_ACTOR_IS_NOT_VISIBLE = "8220" ; // 演员信息不存在
	public final static String OSCAR_ACTIVE_ACTOR_CANNOT_SEND_VOTE_TO_OTHERS = "8221" ; // 候选演员不能送选票给其他候选人员
	/**
	 * 问卷相关异常码
	 */
	public final static String QUESTION_IS_NOT_VISIBLE = "9001" ; // 问卷信心不存在
	public final static String QUESTION_IS_OUT_OF_DATE = "9002" ; // 问卷信息已过时
	public final static String QUESTION_CAN_NOT_CHANGE = "9003" ; // 不允许修改 
	public final static String QUESTION_ANSWER_LENGTH_TOO_LONG = "9004" ; //答案太长
	public final static String QUESTION_ANSWER_LENGTH_TOO_SHOT = "9005" ; //答案太短
	public final static String QUESTION_ANSWER_SIZE_NOT_ENOUGH = "9006" ; //用户答案信息不完善
	
	/**
	 * 批处理任务处理相关异常码
	 */
	public final static String BATCHTASK_DATA_EXCEPTION = "10001" ; // 数据异常
	public final static String BATCHTASK_STATE_WRONG = "10002" ; // 状态不正确
	
	/**
	 * 验证用户赏金提现信息异常码
	 */
	public final static String REWARD_AMT_NOT_ZERO = "10003" ; // 提现赏金数量不能为0
	public final static String REWARD_AMT_UNDER_BOUNTY = "10004" ; // 用户可用赏金数不足

	/*
	 * 小说
	 */
	public final static String NOVEL_TYPE_ALREADY_EXISTS = "11005" ; // 小说类型名称已经存在
	public final static String NOVEL_TYPE_ALREADY_EXISTS_THREE = "11006" ; // 我的书架类型标记已经存在
	public final static String NOVEL_TYPE_ALREADY_EXISTS_TWO = "11007" ; // 全部类型标记已经存在
	public final static String NOVEL_TYPE_NOT_EMPTY = "11008" ; // 小说类型名称不能为空
	public final static String NOVEL_TYPE_NOT_EXISTS = "11001" ;  // 小说类型不存在
	public final static String NOVEL_INFO_NOT_EXISTS = "11002" ;  // 小说不存在
	public final static String NOVEL_CHAPTER_NOT_EXISTS = "11003" ;  // 小说章节不存在
	public final static String NOVEL_CHAPTER_HAVE_NO_PERMISSION = "11005" ;  // 小说章节没有阅读权限
	public final static String NOVEL_IS_NOT_GROUP = "11009" ;  // 小说没有绑定分组
	public final static String QUERY_NOVEL_VOTE_EXCPTION = "11010" ;  // 小说选票信息查询异常
	public final static String NOVEL_VOTE_INITIATE_EXCPTION = "11011" ;  // 小说投票数量不能小于0
	public final static String NOVEL_UPDATE_TIPSDT_IS_EMPTY = "11012" ;//小说更新提示到期日期为空
	public final static String NOVEL_BOOK_SOURCE_IS_EMPTY = "11013" ;
	
	/*
	 * 项目分组绑定关系
	 */
	public final static String GROUP_DESC_IS_EMPTY = "12000" ;  // 项目分组描述为空
	public final static String PROJECT_IS_EMPTY = "12001" ;  // 所选绑定项目集合为空
	public final static String CARTOON_IS_EMPTY = "12002" ;  // 所选绑定漫画集合为空
	public final static String NOVEL_IS_EMPTY = "12003" ;  // 所选绑定小说集合为空
	public final static String GROUP_IS_EXISTS_NOVEL = "12004" ;  // 分组存在绑定小说
	
	
	public final static String NAVY_INFO_IS_EMPTY = "13000" ;  //水军信息为空
	
	
	/**
	 * 漫画渠道信息
	 */
	public final static String CHANNEL_IS_EXISTS_CARTOON = "14000" ;  // 渠道存在漫画
	public final static String CHANNEL_NAME_IS_EXISTS = "14001" ;  // 渠道名已经存在
	public final static String CARTOON_LIST_IS_EMPTY = "14002" ;  // 未选择漫画
	public final static String INCOME_IS_EMPTY = "14003" ;  // 收入为空
	
	public final static String RATIO_FORMAT_ERROR = "15000" ;  //收入分配比格式错误
	
	/**
	 * 三方用户账号信息
	 */
	public final static String ACCOUNT_INFO_EMPTY = "16000" ;  //账号信息不完整
	
	static{
		
		msgs.put( SUCCESS , "成功" ) ;
		msgs.put( NOT_POST , "访问方式必须为POST" );
		msgs.put( WRONG_MOBILENUM , "账户不存在或密码错误" ) ;
		msgs.put( WRONG_PASSWORD , "账户或密码错误" ) ;
		msgs.put( LOSE_TOKEN , "TOKEN失效" ) ;
		msgs.put( TOO_MORE_MOBLE_CODE_REQUEST , "过于频繁的手机验证码请求" ) ;
		msgs.put( SEND_CREATE_MOBLE_CODE_FAIL , "发送短息验证码失败" ) ;
		msgs.put( UPLOAD_FILE_FAILED , "上传文件失败" ) ;
		msgs.put( DATABASE_EXCEPTION , "数据库异常" ) ;
		msgs.put( MOBILE_CODE_CHECK_WRONG , "验证码错误" ) ;
		msgs.put( MOBILE_CODE_CREATE_ERROR , "手机验证码生成失败" ) ;
		msgs.put( MOBILE_EXISTS , "注册用户已存在" ) ;
		msgs.put( UNSUPPORT_FILE_SUFFIX , "不支持的图片格式格式" ) ;
		msgs.put( RONGCLOUD_ACCESS_ERROR , "融云服务器请求失败" ) ;
		msgs.put( RONGCLOUD_GET_TOKEN_FAIL , "获取融云TOKEN失败" ) ;
		msgs.put( LOST_PARAM , "请求数据缺失" ) ;
		msgs.put( PARAMS_PARAM , "请求参数错误" ) ;
		msgs.put( GET_PLAY_URL_ERROR , "获取播放地址失败") ;
		msgs.put( DATA_ERROR , "数据异常" ) ;
		msgs.put( MOBILE_IS_NONE , "无匹配的结果" ) ;
		msgs.put( IMGS_NUM , "图片数量过多" ) ;
		msgs.put( WRONG_SEX , "性别输入有误" ) ;
		msgs.put( SYSTEM_ERROR , "系统异常" ) ;
		msgs.put( REDIS_LIMIT_ACCESS_PREMISSION, "redis 没有访问权限");
		msgs.put( ACCT_NULL , "查询结果为空" ) ;
		msgs.put( WRONG_PARAM , "参数无效"); 
		msgs.put( GET_IMG_URL_ERROR , "获取图片URL失败");
		msgs.put( TOPIC_IS_NOT_VISIBLE , "该话题已被删除");
		msgs.put( USER_IS_NOT_VISIBLE , "该用户不存在");
		msgs.put( USER_DOES_NOT_HAVE_PERMISSIONS , "用户没有相关权限");
		msgs.put( USER_IS_ALREADY_EXISTS , "该用户已存在");
		msgs.put( MOVIE_IS_NOT_EXISTS  , "该影片已被作者删除");
		msgs.put( MOVIE_IS_COLLECTED  , "该影片已收藏");
		msgs.put( MOVIE_IS_NOT_COLLECTED  , "该影片未收藏");
		msgs.put( MOVIE_IS_LIKED  , "该影片已点赞");
		msgs.put( MOVIE_IS_NOT_LIKED  , "该影片未点赞");
		msgs.put( CAN_NOT_REATTENTION  , "不能重复关注");
		msgs.put( IS_NOT_ATTENTION  , "未关注该用户");
		msgs.put( CAN_NOT_REWARD_USERSELF  , "用户不能打赏自己");
		msgs.put( USER_HEAD_IS_NULL  , "用户上传头像为空");
		msgs.put( USER_JPOINT_IS_NOT_FULL  , "用户余额不足");
		msgs.put(CAN_NOT_REPLY_USERSELF, "用户不能回复自己");
		msgs.put(PROJECT_IS_NULL, "项目不存在");
		msgs.put(COMMENT_IS_NULL, "评论不存在");
		msgs.put(HOT_COMMENT_IS_NULL, "暂无热门评论");
		msgs.put(COMMENT_MISS, "评论失败");
		msgs.put(IS_PRAISE, "不能重复点赞");
		msgs.put(IS_NOT_PRAISE, "该用户还没有点赞");
		msgs.put(USER_PRAISE_ERROR, "操作无效");
		msgs.put(PROJECT_LOG_DOSE_NOT_EXISTS, "该帖子已被删除");
		msgs.put(PROJECT_LOG_POST_COMMENT_ERROR, "项目日志评论发表失败");
		msgs.put(PROJECT_LOG_COMMENT_DOES_NOT_EXISTS, "项目日志评论不存在");
		msgs.put(PROJECT_IS_HEAL_FULL, "项目加血已经结束");
		msgs.put(HEAL_AMOUNT_ERROR, "加血量不能小于0");
		msgs.put(BULLET_SCREEN_CAN_NOT_REPEAT_SEND, "30s内弹幕不可重复发送");
		msgs.put(CDKEY_IS_NULL, "该兑换码不存在");
		msgs.put(LOST_CDKEY, "该兑换码已领取过");
		msgs.put(ERROR_MORE_THAN_TEN, "输入错误次数超过10次 。 请明天再试");
		msgs.put(HEAL_CANNOT_UNDER_LIMIT ,  "加血量不能低于下限" ) ;
		msgs.put(CAN_NOT_ATTENTION_YOURSELF , "你这个自恋狂，关注自己干嘛!!!!");
		msgs.put(USER_NICK_IS_ALREADY_EXISTS , "该用户名已被使用了哦，再换一个吧");
		msgs.put(CAN_NOT_RECOMMENT , "宝宝反应慢稍等一下啦~十秒之内请勿多次点击，谢谢啦~~~");
		msgs.put(QINIU_SERVER_ERROR, "七牛服务异常");
		msgs.put(QINIU_RESOURCE_SUFFIX_WRONG, "资源类型错误");
		msgs.put(CANNOT_NULL, "不能为空");
		msgs.put(ADMIN_HAS_EXISTS, "账号已经存在") ;
		msgs.put(ROLE_HAS_EXISTS, "角色已经存在");
		msgs.put(LOGIN_BY_QQ_ERROR , "qq登陆失败");
		msgs.put(LOGIN_BY_WEIXIN_ERROR , "微信登陆失败");
		msgs.put(LOGIN_BY_WEIBO_ERROR, "微博登陆失败");
		msgs.put(PIC_URL_ERROR, "无效头像链接！！");
		msgs.put(REDIS_IS_READONLY, "访问REDIS是只读的");
		msgs.put(REDIS_CANNOT_OPEN_CONNECTION, "无法连接到指定的redis") ;
		msgs.put(REDIS_ACCESS_REDIS_SERVER_ERROR, "访问redis服务器失败") ;
		msgs.put(REDIS_UNSUPPORT_COMMAND, "不支持的命令") ;
		msgs.put(PRODUCT_IS_NOT_EXIST, "商品不存在");
		msgs.put(REDIS_ACCESS_ALL_SERVER_ERR, "所有redis服务访问异常");
		msgs.put(USER_CHASE_PROJECT_ERROR,"操作无效");
		msgs.put(GIFT_IS_NOT_EXISTS,"该礼品已下架");
		msgs.put(USER_IS_NOT_IN_CREW,"用户不在剧组成员中");
		msgs.put(GIFT_GIVING_NOT_EXISTS,"礼单不存在");
		msgs.put(LIKING_REL_NOT_EXITS,"好感关系不存在");
		msgs.put(WRONG_DATE_FORMAT, "时间格式不正确") ;
		msgs.put(COMMON_START_PAGE_NULL, "启动页无更新") ;
		msgs.put(QINIU_RESOURCE_TYPE_WRONG, "未选择资源分类");
		msgs.put(QINIU_SERVER_ERROR_URL, "该图片路径地址不靠谱,请用本地文件上传！");
		msgs.put(CREATE_QINIU_TOKEN_ERROR, "获取七牛TOKEN失败！");
		msgs.put(ACCESS_MAGICWINDOW_API_ERROR, "访问魔窗接口失败！");
		msgs.put(TASK_INFO_IS_NULL, "暂时没有新的任务");
		msgs.put(EXCHANGE_ERROR, "剧点兑换失败");
		msgs.put(EXCHANGE_ERROR_REPEAT_RECEIVE, "已经领取过了哦~");
		msgs.put(ACTIVITY_IS_NOT_VISIBLE, "活动已过期");
		msgs.put(CDKEY_NOT_YET_STARTED, "还未到兑换日期");
		msgs.put(CDKEY_OUT_OF_DATE, "兑换已经结束");
		msgs.put(PROJECT_LIVE_CARTOON_IS_NULL, "真人漫画还在制作中");
		msgs.put(LIVE_CARTOON_IS_NULL, "该集还在制作中");
		msgs.put(LIVE_CARTOON_HAVE_CHASED, "用户已经追过了");
		msgs.put(LIVE_CARTOON_HAVE_NOT_CHASED, "用户还没有追呢");
		msgs.put(LIVE_CARTOON_HAVE_PERMISION, "解锁啦！磕头咚咚");
		msgs.put(LIVE_CARTOON_HAVE_NO_PERMISION, "您还没有解锁哦");
		msgs.put(LIVE_CARTOON_DUBBING_IS_NULL, "配音信息不存在");
		msgs.put(LIVE_CARTOON_DUBBING_HAVE_NO_PERMISION, "您不能修改别人的配音信息哦");
		msgs.put(LIVE_CARTOON_LOCATION_IS_USELESS, "亲，配音错位了呢~赶快放到正确的位置吧");
		msgs.put(LIVE_CARTOON_LOCATION_IS_SHARED, "您已分享过了");
		msgs.put(LIVE_CARTOON_SHARED_TOO_OFTEN, "操作太频繁了，稍后再试试吧");
		
		msgs.put(CDKEY_BEYOND_LIMIT, "不能重复使用哦");
		
		msgs.put(ORDER_NOT_EXISTS, "订单信息不存在，请核实订单信息");
		msgs.put(ORDER_SUPPLEMENT_FAILED, "补单申请失败，点击申诉，宝宝别急48小时内肯定处理哟！");
		msgs.put(ORDER_ALREADY_FINISHED, "订单已完成" ); 
		msgs.put(ORDER_PINGPP_PAID_FAILED, "pingpp订单未支付" ); 
		msgs.put(ORDER_IOS_FAILED, "IOS订单暂时不能对账" ); 
		msgs.put(PROJECT_WALLPAPER_NOT_EXISTS, "壁纸信息不存在" ); 
		msgs.put(MOVIE_NODE_IS_NOT_EXISTS, "影片节点信息不存在" ); 
		msgs.put(USER_INVITE_CODE_IS_INVALID, "此兑换码已失效" ); 
		msgs.put(USER_INVITE_CODE_IS_BEYOND, "此兑换码今天用不了呢明天来试试吧" ); 
		msgs.put(USER_INVITE_CODE_SAME_EQUIPMENT, "同一台手机不能多次操作哦" ); 
		msgs.put(USER_INVITE_CODE_IS_INVITED, "亲你已经被邀请过了" ); 
		msgs.put(USER_INVITE_CODE_THEMSELF, "不能使用自己的兑换码哦" ); 
		msgs.put(USER_IS_REFUSE, "该账户已被封号，请不要散发垃圾信息" ); 
		msgs.put(USER_IS_GAG, "该账户已被禁言，请不要散发垃圾信息" ); 
		msgs.put(USER_HAD_SHARED, "分享成功" ); 
		msgs.put(USER_REWARD_NOT_ENOUGH, "您的赏金不足" ); 
		
		
		msgs.put(NOTIFICATION_IS_NOT_VISIABLE, "该消息已不存在" ); 
		msgs.put(NOTIFICATION_REPLY_MSG_OUT_OF_RANG, "该消息内容太长" ); 
		msgs.put(NOTIFICATION_HAVE_REPLIED, "该消息已回复过" ); 
		
		msgs.put(QUESTION_IS_NOT_VISIBLE, "问卷信息不存在" ); 
		msgs.put(QUESTION_IS_OUT_OF_DATE, "本页面超时已过期" ); 
		msgs.put(QUESTION_CAN_NOT_CHANGE, "答案不许修改哦" ); 
		msgs.put(QUESTION_ANSWER_LENGTH_TOO_LONG, "答案字数太长" );
		msgs.put(QUESTION_ANSWER_LENGTH_TOO_SHOT, "答案字数太短" );
		msgs.put(QUESTION_ANSWER_SIZE_NOT_ENOUGH, "答案不完整呢，再想想~~" );
		
		msgs.put(OSCAR_ACTIVE_IS_NOT_VISIBLE, "活动信息不存在" );
		msgs.put(OSCAR_ACTIVE_IS_OUT_OF_DATE, "活动已截至" );
		msgs.put(OSCAR_ACTIVE_ACTOR_IS_NOT_VISIBLE, "候选人信息不存在" );
		msgs.put(OSCAR_ACTIVE_VOTE_IS_NOT_VISIBLE , "选票无效") ; 
		msgs.put(OSCAR_ACTIVE_ACTOR_CANNOT_SEND_VOTE_TO_OTHERS, "候选人员之间不能互相赠送选票" );
		
		msgs.put(ACTIVE_DEVICE_IS_USED, "同一个手机设备只能领取一次" );
		msgs.put(ACTIVE_MOBILE_IS_USED, "同一个手机号只能领取一次" );
		msgs.put(ACTIVE_ACCOUNT_IS_USED, "同一个用户账号只能领取一次" );
		msgs.put(ACTIVE_IS_NOT_VISIABLE, "活动信息不存在" );
		msgs.put(ACTIVE_ONLY_NEW_REGISTER, "此活动只针对新注册用户哦！" );
		
		msgs.put(PROJECT_LOG_RESOURCE_TITLE_TOO_LONG, "资源帖标题过长" );
		msgs.put(WALLET_IS_NOT_ENOUGH, "用户钱包余额不足" );
		msgs.put(WALLET_WITHDRAW_CHANNEL_IS_UNBIND, "提现渠道未绑定" );
		msgs.put(WALLET_WITHDRAW_BATCH_EXCEPTION, "提现批次异常" );
		msgs.put(WALLET_WITHDRAW_APP_ORDER_ERROR, "提现订单信息有误" );
		msgs.put(WALLET_WITHDRAW_NOT_EXPIRED, "系统未到提现时间" );
		msgs.put(WALLET_CHANNEL_BIND_TOO_MANY, "该帐号已超过绑定限制" );
		
		msgs.put(RED_PACKET_NOT_NOT_EXPIRED, "时间到了才能打开红包" );
		msgs.put(RED_PACKET_INVALID, "这是一个无效的红包" );
		msgs.put(RED_PACKET_ACTIVE_CLOSED, "来晚了宝宝，红包活动咔嚓结束了" );
		
		
		msgs.put(BATCHTASK_DATA_EXCEPTION, "数据异常") ;
		msgs.put(BATCHTASK_STATE_WRONG, "状态不正确");
		
		msgs.put(REWARD_AMT_NOT_ZERO, "提现赏金数量不能为空或小于0!!!") ;
		msgs.put(REWARD_AMT_UNDER_BOUNTY, "用户可用赏金数不足!!!");
		
		msgs.put(NOVEL_TYPE_ALREADY_EXISTS, "小说类型名称已经存在,请重填！") ;
		msgs.put(NOVEL_TYPE_ALREADY_EXISTS_THREE, "“我的书架”标记已经存在,请重填!");
		msgs.put(NOVEL_TYPE_ALREADY_EXISTS_TWO, "“全部类型”标记已经存在,请重填！") ;
		msgs.put(NOVEL_TYPE_NOT_EMPTY, "小说类型名称不能为空!");
		msgs.put(NOVEL_TYPE_NOT_EXISTS, "该类型不存在");
		msgs.put(NOVEL_INFO_NOT_EXISTS, "该小说已下架");
		msgs.put(NOVEL_CHAPTER_NOT_EXISTS, "该章节已屏蔽");
		msgs.put(NOVEL_CHAPTER_HAVE_NO_PERMISSION, "该章节已锁(需解锁)");
		msgs.put(NOVEL_IS_NOT_GROUP		, "该小说没有绑定分组，暂不能上架！请先确认绑定分组！");
		msgs.put(QUERY_NOVEL_VOTE_EXCPTION, "当前投票用户太多了，请稍后再试");
		msgs.put(NOVEL_VOTE_INITIATE_EXCPTION, "投票数量不能小于1");
		
		msgs.put(GROUP_DESC_IS_EMPTY	, "项目分组描述为空 , 请重填！");
		msgs.put(PROJECT_IS_EMPTY		, "所选绑定项目列表为空 , 请重选！");
		msgs.put(CARTOON_IS_EMPTY		, "所选绑定漫画列表为空 , 请重填！");
		msgs.put(NOVEL_IS_EMPTY			, "所选绑定小说列表为空 , 请重选！");
		msgs.put(GROUP_IS_EXISTS_NOVEL	, "该分组存在小说信息,不能删除！");
		msgs.put(NAVY_INFO_IS_EMPTY		, "水军手机号或昵称不能为空！");
		
		msgs.put(NOVEL_UPDATE_TIPSDT_IS_EMPTY	, "小说更新提示到期日期不能为空！");
		msgs.put(NOVEL_BOOK_SOURCE_IS_EMPTY	, "小说来源不能为空！");
		
		msgs.put(CHANNEL_IS_EXISTS_CARTOON	, "该渠道存在漫画，删除前请先删除该渠道漫画！");
		msgs.put(CHANNEL_NAME_IS_EXISTS		, "该渠道已经存在，请确认重新添加！");
		msgs.put(CARTOON_LIST_IS_EMPTY		, "未选择漫画，请确认重新选择！");
		msgs.put(INCOME_IS_EMPTY		, "数据重复，请确认重填！");
		
		msgs.put(RATIO_FORMAT_ERROR , "所填数据请最多保留2位小数！") ;
		
		msgs.put(ACCOUNT_INFO_EMPTY , "星号标记的信息内容不能为空，请确认重填！") ;
		
		unmodifiableMsgs = java.util.Collections.unmodifiableMap( msgs ) ;
		
	}
	
	/**
	 * 根据code 返回对应描述
	 * @param code
	 * @return
	 */
	public final static String RET_CODE_MSG( String code ){
		
		return unmodifiableMsgs.get( code ) ;
		
	}
	
	/**
	 * 生成结果返回MAP
	 * @param code
	 * @return
	 */
	public static Map<String,Object> buildRetCodeResult( String code ){
		Map<String,Object> rst = new HashMap<String,Object>() ;
		rst.put( KEY_RET_CODE , code ) ;
		rst.put( KEY_CODE_MSG , RET_CODE_MSG( code )) ;
		return rst ;
	}
	
}
