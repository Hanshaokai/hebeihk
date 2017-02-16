package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import cn.huischool.huixiao.bean.SchoolShareCourseWareBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/21.
 */
public class SchoolShareCourseWareParser extends BaseParser<SchoolShareCourseWareBean> {
    @Override
    public SchoolShareCourseWareBean parse(String paramString) {

        SchoolShareCourseWareBean result = null;

        try {

            result = JSON.parseObject(paramString, SchoolShareCourseWareBean.class);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return result;
    }
}
