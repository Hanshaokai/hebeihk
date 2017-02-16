package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.MyTeacherPlanDetailBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/7/13.
 */
public class MyTeacherPlanDetailParser extends BaseParser<MyTeacherPlanDetailBean> {
    @Override
    public MyTeacherPlanDetailBean parse(String paramString) {

        MyTeacherPlanDetailBean result = null;

        try {
            result = JSONObject.parseObject(paramString, MyTeacherPlanDetailBean.class);

        } catch
                (JSONException e) {

            e.printStackTrace();
        }


        return result;
    }
}
