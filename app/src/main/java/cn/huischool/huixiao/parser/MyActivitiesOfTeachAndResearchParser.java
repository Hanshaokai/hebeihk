package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.MyActivitiesOfTeachAndResearchBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/8/17.
 */
public class MyActivitiesOfTeachAndResearchParser extends BaseParser<MyActivitiesOfTeachAndResearchBean> {
    @Override
    public MyActivitiesOfTeachAndResearchBean parse(String paramString) {

        MyActivitiesOfTeachAndResearchBean result = null;
        try {

            result = JSONObject.parseObject(paramString, MyActivitiesOfTeachAndResearchBean.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}
