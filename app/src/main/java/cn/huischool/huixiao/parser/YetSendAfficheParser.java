package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.YetSendAfficheBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/6.
 */
public class YetSendAfficheParser extends BaseParser<YetSendAfficheBean> {
    @Override
    public YetSendAfficheBean parse(String paramString) {
        YetSendAfficheBean result = null;
        try {
            result = JSONObject.parseObject(paramString, YetSendAfficheBean.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
