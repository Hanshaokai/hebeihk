package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.MyStudyNotesDetailBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/8/17.
 */
public class MyStudyNotesDetailParser extends BaseParser<MyStudyNotesDetailBean> {
    @Override
    public MyStudyNotesDetailBean parse(String paramString) {

        MyStudyNotesDetailBean result = null;

        try {

            result = JSONObject.parseObject(paramString, MyStudyNotesDetailBean.class);

        } catch (JSONException e) {


            e.printStackTrace();
        }


        return result;
    }
}
