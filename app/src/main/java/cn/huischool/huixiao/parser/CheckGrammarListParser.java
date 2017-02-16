package cn.huischool.huixiao.parser;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.CheckGrammarListBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/7/26.
 */
public class CheckGrammarListParser extends BaseParser<CheckGrammarListBean> {
    @Override
    public CheckGrammarListBean parse(String paramString) {

        CheckGrammarListBean result = null;

        try {

            result = JSONObject.parseObject(paramString, CheckGrammarListBean.class);


        } catch (JSONException e) {


            e.printStackTrace();
        }


        return result;
    }
}
