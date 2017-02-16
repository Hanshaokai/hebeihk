package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.AllSubjectBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/14.
 */
public class AllSubjectParser extends BaseParser<AllSubjectBean> {
    @Override
    public AllSubjectBean parse(String paramString) {

        AllSubjectBean result=null;
        try {
           result= JSONObject.parseObject(paramString,AllSubjectBean.class);
        }catch (JSONException e){

            e.printStackTrace();
        }
        return result;
    }
}
