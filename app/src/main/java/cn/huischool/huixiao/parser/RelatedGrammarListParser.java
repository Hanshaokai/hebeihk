package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import java.util.jar.JarException;

import cn.huischool.huixiao.bean.RelatedGrammarListBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/9/13.
 */
public class RelatedGrammarListParser extends BaseParser<RelatedGrammarListBean> {
    @Override
    public RelatedGrammarListBean parse(String paramString) {

        RelatedGrammarListBean result = null;
        try {
            result = JSON.parseObject(paramString, RelatedGrammarListBean.class);
        } catch (JSONException e) {


            e.printStackTrace();
        }

        return result;
    }
}
