package cn.huischool.huixiao.common.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import cn.huischool.huixiao.R;

/**
 * Created by ${han} on 2016/6/7.
 */
public class LoadBitmapUtils {

    public static void LoadImagview(Context context,
                                    String uri,
                                    ImageView view) {
        Picasso.with(context).load(uri).placeholder(R.drawable.zhan).into(view);
    }

    public static void LoadHeadImagview(Context context,
                                        String uri,
                                        ImageView view) {

        Picasso.with(context).load(uri).resize(90, 90).placeholder(R.drawable.mine).into(view);

    }
    public static void LoadContactHeadImagview(Context context,
                                        String uri,
                                        ImageView view) {

        Picasso.with(context).load(uri).resize(90, 90).placeholder(R.drawable.contacts_headimg)
                .into(view);

    }
}
