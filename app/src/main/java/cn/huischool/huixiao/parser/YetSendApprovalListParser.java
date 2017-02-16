package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.YetSendApprovalListBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/6/15.
 */
public class YetSendApprovalListParser extends BaseParser<YetSendApprovalListBean> {
    @Override
    public YetSendApprovalListBean parse(String paramString) {

        YetSendApprovalListBean result=null;

        try{

            result= JSONObject.parseObject(paramString,YetSendApprovalListBean.class);

        }catch (JSONException e){

            e.printStackTrace();
        }



        return result;
    }
}
