package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import cn.huischool.huixiao.bean.SchoolShareLessonPlansBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/21.
 */
public class SchoolShareLessonPlansParser extends BaseParser<SchoolShareLessonPlansBean> {
    @Override
    public SchoolShareLessonPlansBean parse(String paramString) {
        SchoolShareLessonPlansBean result = null;

        try {

            result = JSON.parseObject(paramString, SchoolShareLessonPlansBean.class);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return result;
    }
}
