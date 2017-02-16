package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.CheckCourseWareListBean;
import cn.huischool.huixiao.bean.CheckGrammarListBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/7/28.
 */
public class CheckCourseWareListParser extends BaseParser<CheckCourseWareListBean> {

    @Override
    public CheckCourseWareListBean parse(String paramString) {

        CheckCourseWareListBean result = null;

        try {

            result = JSONObject.parseObject(paramString, CheckCourseWareListBean.class);


        } catch (JSONException e) {


            e.printStackTrace();
        }


        return result;
    }
}
