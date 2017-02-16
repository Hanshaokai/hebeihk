package cn.huischool.huixiao.common.fragment;


import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rey.material.widget.ProgressView;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseFragment;


/**
 * Created by ${han} on 2016/7/4.
 * 文件预览界面 用云中转换
 */
public class PreviewFragment extends BaseFragment {

    private ProgressView pv_linear_preview;
    private Toolbar toolbar_clude;
    private TextView tv_title_clude;
    private AppCompatActivity myActivity;
    private WebView wv_preview_fragment;
    private WebSettings settings;
    private String url;
    private LinearLayout ll_preview_fragment;

    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        url = (String) getArguments().getSerializable("url");

        view = inflater.inflate(R.layout.fragement_preview, null, false);
        pv_linear_preview = (ProgressView) view.findViewById(R.id.pv_linear_preview);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        wv_preview_fragment = (WebView) view.findViewById(R.id.wv_preview_fragment);
        ll_preview_fragment = (LinearLayout) view.findViewById(R.id.ll_preview_fragment);
        ll_preview_fragment.setVisibility(View.GONE);
        return view;
    }

    public static PreviewFragment newInstance(String u) {

        Bundle args = new Bundle();
        args.putSerializable("url", u);
        PreviewFragment fragment = new PreviewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_clude, true, "预览", -1,true);
        settings = wv_preview_fragment.getSettings();
        settings.setJavaScriptEnabled(true);// 表示支持js即网页的阅读全文
        settings.setLoadsImagesAutomatically(true);
        // settings.setBuiltInZoomControls(true);//显示放大缩小按钮
        //settings.setUseWideViewPort(true);//支持双击缩放
        // settings.setDefaultTextEncodingName("UTF-8");
        // settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
/*NORMAL：正常显示，没有渲染变化。
SINGLE_COLUMN：把所有内容放到WebView组件等宽的一列中。
NARROW_COLUMNS：可能的话，使所有列的宽度不超过屏幕宽度。*/
        settings.setUseWideViewPort(true);//设定支持viewport
        settings.setLoadWithOverviewMode(true);   //自适应屏幕
        // settings.setBuiltInZoomControls(true);
        // settings.setDisplayZoomControls(false);
        //  wv_preview_fragment.setHorizontalScrollBarEnabled(false);//水平不显示(false);
        settings.setSupportZoom(true);//设定支持缩放
        //settings.setDisplayZoomControls(false);//把缩放控件给隐藏掉

        //wv_preview_fragment.setInitialScale(200);
        //wv_preview_fragment.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);//滚动条在WebView外侧显示
       /* settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);*/
        //settings.setLoadWithOverviewMode(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        String appCachePath = myActivity.getApplicationContext().getCacheDir().getAbsolutePath();
        settings.setAppCachePath(appCachePath);
        showPreviewData();
    }

    private void showPreviewData() {

        wv_preview_fragment.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                LogUtil.d("网页开始加载");
                pv_linear_preview.setProgress(0f);

                pv_linear_preview.start();

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                LogUtil.d("网页开始结束");
                ll_preview_fragment.setVisibility(View.VISIBLE);
                pv_linear_preview.stop();
            }

        });

        wv_preview_fragment.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                LogUtil.d("=========" + newProgress + "加载进度");
                super.onProgressChanged(view, newProgress);
                float f = (float) newProgress / 100;
                pv_linear_preview.setProgress(f);
                LogUtil.d("=========" + newProgress + "加载进度");
            }


            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                tv_title_clude.setText("预览");
              /*  if (TextUtils.isEmpty(title)) {

                    return;
                }
                tv_title_clude.setText(title);*/
            }
        });


        wv_preview_fragment.loadUrl(url);

        LogUtil.d("附件地址：" + url);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                LogUtil.d("点击了返回");
                wv_preview_fragment.clearCache(true);//防止泄露

                removeFragment();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDestroyView() {
        wv_preview_fragment.clearCache(true);

        super.onDestroyView();
    }

    @Override
    protected void onClickEvent(View view) {

    }
}
