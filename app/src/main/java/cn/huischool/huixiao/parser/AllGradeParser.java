package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.AllGradeBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/14.
 */
public class AllGradeParser extends BaseParser<AllGradeBean> {
    @Override
    public AllGradeBean parse(String paramString) {


        AllGradeBean result = null;
        try {
            result = JSONObject.parseObject(paramString, AllGradeBean.class);

        } catch (
                JSONException e
                ) {
            e.printStackTrace();
        }

        return result;
    }
}
