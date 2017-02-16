package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.AllLeaderBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/14.
 */
public class AllLeaderParser extends BaseParser<AllLeaderBean> {
    @Override
    public AllLeaderBean parse(String paramString) {
        AllLeaderBean result = null;
        try {
            result = JSONObject.parseObject(paramString, AllLeaderBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return result;
    }
}
