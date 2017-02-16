package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;


import cn.huischool.huixiao.bean.YetSendNotifiBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/5/20.
 */
public class YetSendNotifiParser extends BaseParser<YetSendNotifiBean> {
    @Override
    public YetSendNotifiBean parse(String paramString) {
        YetSendNotifiBean result = null;
        try {
            result = JSONObject.parseObject(paramString, YetSendNotifiBean.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
    }

