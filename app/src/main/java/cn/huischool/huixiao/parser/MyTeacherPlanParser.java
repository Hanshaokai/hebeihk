package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.MyTeacherPlanBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/7/13.
 */
public class MyTeacherPlanParser extends BaseParser<MyTeacherPlanBean> {
    @Override
    public MyTeacherPlanBean parse(String paramString) {


        MyTeacherPlanBean result = null;

        try {

            result = JSONObject.parseObject(paramString, MyTeacherPlanBean.class);


        } catch (JSONException e) {

            e.printStackTrace();

        }


        return result;
    }
}
