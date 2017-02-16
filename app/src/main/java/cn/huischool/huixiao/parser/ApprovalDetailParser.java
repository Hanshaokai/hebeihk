package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import cn.huischool.huixiao.bean.ApprovalDetailBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/8/31.
 */
public class ApprovalDetailParser extends BaseParser<ApprovalDetailBean> {


    @Override
    public ApprovalDetailBean parse(String paramString) {
        ApprovalDetailBean result=null;


        try{

            result= JSON.parseObject(paramString,ApprovalDetailBean.class);


        }catch (JSONException e){



            e.printStackTrace();
        }



        return result;
    }
}
