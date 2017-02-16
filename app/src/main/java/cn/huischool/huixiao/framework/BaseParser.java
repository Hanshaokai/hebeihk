package cn.huischool.huixiao.framework;




public abstract class BaseParser<T extends BaseResponse> {
	
	public static final String ERROR_CODE = "code";
	public static final String RESULT = "message";
	
	// paramString json字符串
	public abstract T parse(String paramString); 
	

}
