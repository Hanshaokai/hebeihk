package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;



import cn.huischool.huixiao.bean.MyCountInforBean;
import cn.huischool.huixiao.framework.BaseParser;


/**
 * Created by ${han} on 2016/6/12.
 */
public class MyCountInforParser extends BaseParser<MyCountInforBean> {
    @Override
    public MyCountInforBean parse(String paramString) {
        MyCountInforBean result = null;
        try {
            result = JSONObject.parseObject(paramString, MyCountInforBean.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }



}
