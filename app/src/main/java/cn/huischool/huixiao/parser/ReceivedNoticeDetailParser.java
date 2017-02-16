package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import cn.huischool.huixiao.bean.ReceivedNoticeDetailBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/8/30.
 */
public class ReceivedNoticeDetailParser extends BaseParser<ReceivedNoticeDetailBean> {
    @Override
    public ReceivedNoticeDetailBean parse(String paramString) {


        ReceivedNoticeDetailBean result = null;


        try {
            result = JSON.parseObject(paramString, ReceivedNoticeDetailBean.class);
        } catch (JSONException e) {

            e.printStackTrace();
        }


        return result;


    }
}
