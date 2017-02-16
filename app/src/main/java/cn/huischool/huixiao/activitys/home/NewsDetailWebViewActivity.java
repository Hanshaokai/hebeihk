package cn.huischool.huixiao.activitys.home;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.rey.material.widget.ImageButton;
import com.rey.material.widget.ProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/10/24.
 */

public class NewsDetailWebViewActivity extends BaseActivity {
    @BindView(R.id.tv_title_clude)
    TextView tvTitleClude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtnActionClude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbarClude;
    @BindView(R.id.appbar_clude)
    AppBarLayout appbarClude;
    @BindView(R.id.home_news_detail)
    WebView webhomeNewsDetail;
    @BindView(R.id.pv_linear_news_detail)
    ProgressView pvLinearNewsDetail;
    private Unbinder unbinder;
    private String content;
    private String title;

    /**
     * content : <img src="http://www.huischool.cn/temporaryHtml/image/20160810/20160810112010_713.jpg" alt="" />
     * id : 57aa9d6c0cf26d8718dea2ec
     * title : 0810测试新闻
     * mainImgUrl : http://img-app-index.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/57aa9d6c0cf26d8718dea2eb
     */
    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home_news_detail);
    }

    @Override
    public void dealLogicBeforeInitView() {
        Bundle bundle = getIntent().getExtras();
        content = bundle.getString("content");
        String id = bundle.getString("id");
        title = bundle.getString("title");
        String mainImgUrl = bundle.getString("mainImgUrl");

    }

    @Override
    public void initView() {
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbarClude);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
        tvTitleClude.setText(title);
        webhomeNewsDetail.getSettings().setDefaultTextEncodingName("utf-8");

        WebSettings webSettings = webhomeNewsDetail.getSettings();
        webSettings.setUseWideViewPort(true);//设定支持viewport
        webSettings.setJavaScriptEnabled(true);// 表示支持js即网页的阅读全文
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webhomeNewsDetail.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                LogUtil.d("网页开始加载");
                pvLinearNewsDetail.setProgress(0f);

                pvLinearNewsDetail.start();
                pvLinearNewsDetail.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                LogUtil.d("网页开始结束");
                pvLinearNewsDetail.setVisibility(View.GONE);
                pvLinearNewsDetail.stop();
            }

        });
        webhomeNewsDetail.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                LogUtil.d("=========" + newProgress + "加载进度");
                super.onProgressChanged(view, newProgress);
                float f = (float) newProgress / 100;
                pvLinearNewsDetail.setProgress(f);
                LogUtil.d("=========" + newProgress + "加载进度");
            }


            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void dealLogicAfterInitView() {
        if (content != null) {

            if (!content.contains("&lt;body&gt;")) {

                StringBuilder sb = new StringBuilder();
                sb.append("<html>");
                sb.append("<head>");
                sb.append("<meta http-equiv=Content-Type content=text/html; charset=utf-8>");
                sb.append("<meta name=viewport content=width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0>");
                sb.append("<style>img{ width:100% !important;max-width:600px !important;}</style>");
                sb.append("</head>");
                sb.append("<body>");
                sb.append(content);
                sb.append("</body>");
                sb.append("</html>");
                content = new String(sb);
                LogUtil.d(content);
            }
            //content = Html.fromHtml(content).toString();
            Log.d("content", content);

            webhomeNewsDetail.loadDataWithBaseURL("", content, "text/html", "utf-8",
                    null);
            LogUtil.d(content);
        }
    }

    @Override
    public void onClickEvent(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
