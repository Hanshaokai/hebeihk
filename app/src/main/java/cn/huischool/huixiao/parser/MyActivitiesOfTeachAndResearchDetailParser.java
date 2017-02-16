package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.MyActivitiesOfTeachAndResearchBean;
import cn.huischool.huixiao.bean.MyActivitiesOfTeachAndResearchDetailBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/8/17.
 */
public class MyActivitiesOfTeachAndResearchDetailParser extends BaseParser<MyActivitiesOfTeachAndResearchDetailBean> {


    @Override
    public MyActivitiesOfTeachAndResearchDetailBean parse(String paramString) {

        MyActivitiesOfTeachAndResearchDetailBean result = null;

        try {


            result = JSONObject.parseObject(paramString, MyActivitiesOfTeachAndResearchDetailBean
                    .class);
        } catch (JSONException e) {

            e.printStackTrace();
        }

        return result;
    }
}
