package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.ReceivApprovalBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/16.
 */
public class ReceivApprovalParser extends BaseParser<ReceivApprovalBean> {
    @Override
    public ReceivApprovalBean parse(String paramString) {

        ReceivApprovalBean result = null;
        try {
            result = JSONObject.parseObject(paramString, ReceivApprovalBean.class);


        } catch (JSONException e) {
            e.printStackTrace();


        }


        return result;
    }
}
