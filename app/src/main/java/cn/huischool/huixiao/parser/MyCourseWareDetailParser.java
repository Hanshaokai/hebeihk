package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.MyCourseWareDetailBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/7/15.
 */


public class MyCourseWareDetailParser extends BaseParser<MyCourseWareDetailBean> {
    @Override
    public MyCourseWareDetailBean parse(String paramString) {

        MyCourseWareDetailBean result = null;

        try {
            result = JSONObject.parseObject(paramString, MyCourseWareDetailBean.class);

        } catch
                (JSONException e) {

            e.printStackTrace();
        }


        return result;
    }
}


