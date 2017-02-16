package cn.huischool.huixiao.parser;

import cn.huischool.huixiao.bean.AcceNotifiBean;
import cn.huischool.huixiao.framework.BaseParser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class AcceNotifiParser extends BaseParser<AcceNotifiBean> {

	@Override
	public AcceNotifiBean parse(String paramString) {
		AcceNotifiBean result = null;
		try {
			result = JSONObject.parseObject(paramString, AcceNotifiBean.class);

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}

}