package cn.huischool.huixiao.parser;



import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.ChangeImageBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/8.
 */
public class ChangeImageParser extends BaseParser<ChangeImageBean> {
    @Override
    public ChangeImageBean parse(String paramString) {

        ChangeImageBean result=null;
        try {
            result=   JSONObject.parseObject(paramString,ChangeImageBean.class);
        }catch (JSONException e){
            e.printStackTrace();
        }


        return result;
    }
}
