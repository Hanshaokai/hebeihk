package cn.huischool.huixiao.parser;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.AfficheschBean;
import cn.huischool.huixiao.framework.BaseParser;

public class AfficheschParser extends BaseParser<AfficheschBean>{

	@Override
	public AfficheschBean parse(String paramString) {
		AfficheschBean result = null;
		try {
			result = JSONObject.parseObject(paramString, AfficheschBean.class);

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}
		

}
