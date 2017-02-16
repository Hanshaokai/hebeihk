package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.MyMeetingRecordNotesBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/8/12.
 */
public class MyMyMeetingRecordListParser extends BaseParser<MyMeetingRecordNotesBean> {
    @Override
    public MyMeetingRecordNotesBean parse(String paramString) {

        MyMeetingRecordNotesBean result = null;

        try {


            result = JSONObject.parseObject(paramString, MyMeetingRecordNotesBean.class);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return result;
    }
}
