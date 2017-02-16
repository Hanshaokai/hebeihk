package cn.huischool.huixiao.common.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/9/14.
 */
public class TooIntent {

    public static void openWordFile(File file) {

        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Uri uri = Uri.fromFile(file);

            intent.setDataAndType(uri, "application/msword");
            CustomApplication.customApplication.startActivity(intent);
        } catch (ActivityNotFoundException e) {

            ToolToast.showShortTimeMsg("无法打开，请安装相应的软件");

        }

    }

    public static void openPPtFile(File file) {


        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Uri uri = Uri.fromFile(file);
            intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
            CustomApplication.customApplication.startActivity(intent);
        } catch (ActivityNotFoundException e) {

            ToolToast.showShortTimeMsg("无法打开，请安装相应的软件");

        }
    }
}
