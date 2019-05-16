package com.yijiupi.bi.constant;
/*********************************************
 * ClassName: WebConstants Description: 常量类
 * @author wangran Date 2016年3月04日
 *********************************************/
public class WebConstants {

	public static final String DEPARTMENT_CITY_PREFIX = "jiupicity_";
	/**
	 * 程序返还常量
	 */
	// 返还成功
	public static final String RESULT_SUCCESS = "success";
	// 返还异常-业务异常
	public static final String RESULT_FAILED = "fail";
	// 返还失败-系统异常
	public static final String RESULT_ERROR = "error";
	/**
	 * 
	 */
	public static final Integer ZERO = 0;
	/* Session */
	public static final String Session_CurrentUser = "CurrentUser";
	public static final String Session_CurrentUserId = "CurrentUserId";
	/* Cookie */
	public static final String Cookie_User = "YJP_OP_User";
	public static final String Cookie_UserId = "YJP_OP_UserId";
	public static final String Cookie_CityId = "YJP_OP_CityId";
	public static final String Cookie_Province = "YJP_OP_Province";
	public static final String Cookie_City = "YJP_OP_City";
	public static final String Cookie_Area = "YJP_OP_Area";
	public static final String Cookie_OrgName = "YJP_OP_OrgName";
	public static final String Cookie_UserRole = "YJP_OP_UserRole";
	public static final String Cookie_UserInfo = "YJP_OP_UserInfo";
	public static final Integer PAGE_UNIT = 20;
	// 模信息
	public static final String RES_MODULES = "";
	// 公钥
	public static final String RES_PUBLICKEY = "MIGdMA0GCSqGSIb3DQEBAQUAA4GLADCBhwKBgQCjxtzIKvgVNGdhDxfmQPPiLdvQyt6tPfoGQ03T/4xZ05gK/hr2hJMWBzSB8erfRu3a2YVhUkPokSU0y1Z5HDRw/s+mNAiBdzDLySwqYnOMxkaq2EHEK+69GXmaWIpEyZgWp+CiXH1IS7oE45b+xbdl0j0wMh5juJmcNID7baIiMwIBAw==";
	// 私钥
	public static final String RES_PRIVATEKEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKPG3Mgq+BU0Z2EPF+ZA8+It29DK3q09+gZDTdP/jFnTmAr+GvaEkxYHNIHx6t9G7drZhWFSQ+iRJTTLVnkcNHD+z6Y0CIF3MMvJLCpic4zGRqrYQcQr7r0ZeZpYikTJmBan4KJcfUhLugTjlv7Ft2XSPTAyHmO4mZw0gPttoiIzAgEDAoGAbS892sdQDiLvlgoP7tX37B6SizHpyNP8BCzejVUIO+JlXKlnTwMMuVojAUvx6i9JPJEDljbX8GDDeIeO+2gi9O4RkPyjvrT0uM8WidL6Y6RTOzZUNP3yxgtnsefaPpSrgjDtjqj5FfccoTziu6HuDmPDjNxGkoR+mNB7O8NzFisCQQDTC8oPZiZlsA3W6GDrIi87jSWXSb07RcWeszUPAnI+nrH3qwAtrlcoiz+V7vWrcAthKEkJ4paIsyLUWObK+Q+hAkEAxqmCqay9AhGou6H6utnIFDysb3m3c7zOaarabcB0q/ghZtFMMVlQMIPTclPvp2JE22+T3dHxaSiUJ286/XxxUwJBAIyyhrTuxEPKs+Sa60dsH30Iw7oxKNIug78iI19W9tRpy/pyAB50OhsHf7lJ+Rz1XOtwMLFBubB3bI2QmdymCmsCQQCEcQHGcyisC8XSa/x8kTANfchKUST30zRGcebz1aMdUBZEi4gg5jV1rTehjUpvltiSSmKT4UubcGLE9NH+UvY3AkEAlXHPyhYS9WfPCUYbgTAVFNRADa0/IctIl8AUPbA1fqotOpHpMfyxOeg3HU0o3AmGGpN1qEKgLIpL4IzDPeoCcw==";
	public static final String USER_TOKEN = "userToken";
	public static final String SOURCE_CLIENT = "source";
	public static final String SOURCE_SUPPLY = "supply";
	public static final String SOURCE_DIS = "dis";
	public static final Integer USER_OP_OVERTIME = 120;
	// Token验证成功(Token验证成功，可能业务逻辑执行失败，但不影响此Code)
	public static final Integer SUCCESS_CODE = 1;
	// Token验证失败,用户验证异常
	public static final Integer AUTH_VALIDTE_FAILED = -1;
	public static final String NON_VALIDATEVERSION = "0";
	public static final String VALIDATEUSERINFO_FAILED = "验证用户身份失败。";
	public static final String CITYPRINTTITLE_YIJIUPI = "易酒批订单";
	public static final String CITYPRINTTITLE_SHOP = "[经销商名称]配送单";
	public static final String CITYDECLARATION = "商品名称和数量请当面结清,如有质量问题,外箱包装开封后不予退货,敬请谅解！全国客服电话:[电话]特别提示：请大家在转帐付款时按规定转至公司指定的帐户，严禁向业务员私卡转帐付款，否则视为未付款。";
	public static final String CITYPRINTAGENCYDES = "[公司名称]为易酒批[城市]区域特约（指定）入驻业务推广和代理服务商，为商品供销提供品控和代收款服务。";
	public static final String CITYPRINTSUBSCRIPTIONS = "微信中搜'店老板经营参考'或'yijiupi',关注微信公众号,获取赚钱生意经,大家都在看哟!";
	// 库存服务-仓库库存
	public static final Integer INVENTROY_STORE_TYPE_WAREHOUSE = 1;
	public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final Integer JIUPIORDERTPYE_AWARDORDER = 100;


	/**
	 * Cookie中，用户信息关键字
	 */
	public static final String COOKIE_USERINFO = "YJP_OP_UserInfo";
	/**
	 * Cookie中，错误信息关键字
	 */
	public static final String COOKIE_ERROR_KEY = "error";
	public static final String RESULT_AUTH_FAIL = "failure";
	/**
	 * cookie 中存放自定义会话信息的标识名
	 */
	public final static String YJP_COOKIE_ID = "YJPID";
	/**
	 * 活动复制到当前月
	 */
	public static final int NOW_MONTH = 0;
	/**
	 * 活动复制到下个月
	 */
	public static final int NEXT_MONTH = 1;
}
