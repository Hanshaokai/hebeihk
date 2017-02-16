package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.OfOneGradeAllClassBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/14.
 */
public class OfOneGradeAllClassParser extends BaseParser<OfOneGradeAllClassBean> {
    @Override
    public OfOneGradeAllClassBean parse(String paramString) {

        OfOneGradeAllClassBean result = null;

        try {
            result = JSONObject.parseObject(paramString, OfOneGradeAllClassBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return result;
    }
}
