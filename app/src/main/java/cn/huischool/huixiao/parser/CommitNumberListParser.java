package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.CommitNumberListBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2017/1/9.
 */

public class CommitNumberListParser extends BaseParser<CommitNumberListBean> {
    @Override
    public CommitNumberListBean parse(String paramString) {
        CommitNumberListBean result = null;
        try {
            result = JSONObject.parseObject(paramString, CommitNumberListBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
