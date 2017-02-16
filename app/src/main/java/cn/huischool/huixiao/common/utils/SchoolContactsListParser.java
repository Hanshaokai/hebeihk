package cn.huischool.huixiao.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import cn.huischool.huixiao.bean.SchoolContactsListBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/10/11.
 */

public class SchoolContactsListParser extends BaseParser<SchoolContactsListBean> {
    @Override
    public SchoolContactsListBean parse(String paramString) {
        SchoolContactsListBean schoolContactsListBean = null;
        try {
            schoolContactsListBean = JSON.parseObject(paramString, SchoolContactsListBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return schoolContactsListBean;

    }
}
