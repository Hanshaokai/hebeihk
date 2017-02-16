package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import cn.huischool.huixiao.bean.CountOfScheduleBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/8/29.
 */
public class CountOfScheduleParser extends BaseParser<CountOfScheduleBean> {
    @Override
    public CountOfScheduleBean parse(String paramString) {


        CountOfScheduleBean result=null;

        try {

            result= JSON.parseObject(paramString,CountOfScheduleBean.class);
        }catch (JSONException e){

            e.printStackTrace();
        }









        return result;
    }
}
