package cn.huischool.huixiao.framework.helper;


import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.base.CustomApplication;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class SharedPrefHelper {
	private static final String SP_FILE_NAME = "HXSETING";
	public static SharedPrefHelper sharedPrefHelper = null;
	public static SharedPreferences sharedPreferences=null;
	public static  synchronized SharedPrefHelper getInstance() {
		if (null == sharedPrefHelper) {
			sharedPrefHelper = new SharedPrefHelper();
		}
		return sharedPrefHelper;
	}
	private  SharedPrefHelper() {
		sharedPreferences = CustomApplication.customApplication
				.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
	}
	
	/**
	 * 获取是否登录
	 */
	public static void setIsLogin(boolean result){
		sharedPreferences.edit().putBoolean("HUIXIAO", result).commit();
	}
	
	/**
	 * 设置是否登录
	 */
	public static boolean getIsLogin(){
		return sharedPreferences.getBoolean("HUIXIAO", false);
	}
	/**
	 * 往SettingSharedPreference中添加String
	 * 
	 * @param key
	 * @param value
	 */
	public static void setString(String key, String value) {
		sharedPreferences.edit().putString(key, value).commit();
	}
	public static String getString(String key) {
		LogUtil.d(SharedPrefHelper.class, sharedPreferences.getString(key, ""));
		
		return sharedPreferences.getString(key, "");
	}

}
