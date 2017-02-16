package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.ApprovalSelectRoleListBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/24.
 */
public class ApprovalSelectRoleListParser extends BaseParser<ApprovalSelectRoleListBean> {
    @Override
    public ApprovalSelectRoleListBean parse(String paramString) {

        ApprovalSelectRoleListBean result = null;
        try {
            result = JSONObject.parseObject(paramString, ApprovalSelectRoleListBean.class);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return result;
    }
}
