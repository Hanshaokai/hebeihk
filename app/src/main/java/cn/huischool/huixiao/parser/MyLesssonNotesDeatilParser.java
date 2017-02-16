package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import cn.huischool.huixiao.bean.MyLesssonNotesDeatilBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/8/10.
 */
public class MyLesssonNotesDeatilParser extends BaseParser<MyLesssonNotesDeatilBean> {
    @Override
    public MyLesssonNotesDeatilBean parse(String paramString) {

        MyLesssonNotesDeatilBean result = null;

        try {
            result = JSONObject.parseObject(paramString, MyLesssonNotesDeatilBean.class);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return result;
    }
}
