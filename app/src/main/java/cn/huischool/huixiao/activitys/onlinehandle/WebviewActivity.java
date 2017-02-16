package cn.huischool.huixiao.activitys.onlinehandle;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.huischool.huixiao.common.utils.LogUtil;

/**
 * 用fragment中的控件webview不可以加载永中html  用activity可以加载 奇怪
 * Created by ${han} on 2016/11/29.
 */

public class WebviewActivity extends AppCompatActivity {

    private WebView webView;
    private String url;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = getIntent().getExtras().getString("url");


        webView = new WebView(this);
        progressDialog = new ProgressDialog(this);
        webView.setWebViewClient(new WebViewClient() {//设置在webView点击打开的新网页在当前界面显示,
            // 而不跳转到新的浏览器中
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);//设置WebView属性,运行执行js脚本
        webView.loadUrl(url);//调用loadView方法为WebView加入链接
        webView.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                LogUtil.d("网页开始加载");

                progressDialog.setMessage("正在加载");
                try {
                    progressDialog.show();
                    progressDialog.setCanceledOnTouchOutside(false);
                } catch (WindowManager.BadTokenException exception) {
                    exception.printStackTrace();
                }

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressDialog.dismiss();
                LogUtil.d("网页开始结束");

            }

        });
        setContentView(webView);


    }


}