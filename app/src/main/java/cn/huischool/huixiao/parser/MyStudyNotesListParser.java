package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.MyStudyNotesBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/8/12.
 */
public class MyStudyNotesListParser extends BaseParser<MyStudyNotesBean> {
    @Override
    public MyStudyNotesBean parse(String paramString) {

        MyStudyNotesBean result = null;

        try {

            result = JSONObject.parseObject(paramString, MyStudyNotesBean.class
            );


        } catch (JSONException e) {

            e.printStackTrace();
        }


        return result;
    }
}
