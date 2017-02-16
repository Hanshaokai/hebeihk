package cn.huischool.huixiao.common.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by ${han} on 2016/8/3.
 */
public class TooSnackbar {


    public static void showMessage(View v, String s) {


        Snackbar snackbar = Snackbar.make(v, s, Snackbar.LENGTH_SHORT);


        snackbar.show();

    }


}
