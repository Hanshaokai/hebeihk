package cn.huischool.huixiao.common.utils;

import android.widget.Toast;

import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/9/13.
 */
public class ToolToast {

    public static void showShortTimeMsg(String s) {


        Toast.makeText(CustomApplication.customApplication, s, Toast.LENGTH_SHORT).show();

    }

    public static void showLongTimeMsg(String s) {


        Toast.makeText(CustomApplication.customApplication, s, Toast.LENGTH_LONG).show();

    }

}
