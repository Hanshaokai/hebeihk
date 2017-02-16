package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.ApprovalReceiversOfTheRoleBean;

import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/24.
 */
public class ApprovalReceiversOfTheRoleParser extends BaseParser<ApprovalReceiversOfTheRoleBean> {
    @Override
    public ApprovalReceiversOfTheRoleBean parse(String paramString) {

        ApprovalReceiversOfTheRoleBean result = null;

        try {

            result = JSONObject.parseObject(paramString, ApprovalReceiversOfTheRoleBean.class);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return result;
    }
}
