package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.OfOneGradeTeacherBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/14.
 */
public class OfOneGradeTeacherParser extends BaseParser<OfOneGradeTeacherBean> {
    @Override
    public OfOneGradeTeacherBean parse(String paramString) {

        OfOneGradeTeacherBean result = null;
        try {
            result = JSONObject.parseObject(paramString, OfOneGradeTeacherBean.class);

        } catch (JSONException e) {

            e.printStackTrace();
        }


        return result;
    }
}
