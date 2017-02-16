package cn.huischool.huixiao.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;


import cn.huischool.huixiao.bean.MyLessonNotesBean;
import cn.huischool.huixiao.framework.BaseParser;

/**
 * Created by ${han} on 2016/8/5.
 */
public class MyLessonNotesListParser extends BaseParser<MyLessonNotesBean> {
    @Override
    public MyLessonNotesBean parse(String paramString) {
        MyLessonNotesBean result=null;


        try{

            result= JSONObject.parseObject(paramString,MyLessonNotesBean.class);


        }catch ( JSONException e){


            e.printStackTrace();
        }
        return result;
    }
}
