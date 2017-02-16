package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.ToSendCompleteBean;
import cn.huischool.huixiao.bean.YetSendAfficheBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/7.
 */
public class ToSendCompleteParser extends BaseParser<ToSendCompleteBean> {
    @Override
    public ToSendCompleteBean parse(String paramString) {

        ToSendCompleteBean result = null;
        try {
            result = JSONObject.parseObject(paramString, ToSendCompleteBean.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return result;
    }
}
