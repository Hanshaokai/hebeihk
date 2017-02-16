package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;


import cn.huischool.huixiao.bean.LoginBean;
import cn.huischool.huixiao.framework.BaseParser;
/**
 * 所有的 返回json字符串 解析获得结果的方法都写这里
 * @author han
 *
 * 2016-4-15
 */

//登录返回解析
	public class LoginParser extends BaseParser<LoginBean> {

		@Override
		public LoginBean parse(String paramString) {
			LoginBean result = null;
			try {
				result = JSONObject.parseObject(paramString,LoginBean.class);
				
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return result;
		}

		
		

	}



