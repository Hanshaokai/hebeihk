package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import cn.huischool.huixiao.bean.MyMeetingRecordNotesDetailBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/8/15.
 */
public class MyMeetingRecordNotesDetailParser extends BaseParser<MyMeetingRecordNotesDetailBean> {
    @Override
    public MyMeetingRecordNotesDetailBean parse(String paramString) {

        MyMeetingRecordNotesDetailBean result = null;

        try {
            result = JSON.parseObject(paramString, MyMeetingRecordNotesDetailBean.class);

        } catch (JSONException e) {


            e.printStackTrace();

        }

        return result;
    }
}
