package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import cn.huischool.huixiao.bean.ReceivedAfficheDetailBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/8/30.
 */
public class ReceivedAfficheDetailParser extends BaseParser<ReceivedAfficheDetailBean> {
    @Override
    public ReceivedAfficheDetailBean parse(String paramString) {

        ReceivedAfficheDetailBean result=null;
        try {


            result= JSON.parseObject(paramString,ReceivedAfficheDetailBean.class);


        }catch (JSONException e){

            e.printStackTrace();
        }



        return result;
    }
}
