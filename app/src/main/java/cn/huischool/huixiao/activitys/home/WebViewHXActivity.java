package cn.huischool.huixiao.activitys.home;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.common.fragment.PreviewFragment;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/8/24.
 */
public class WebViewHXActivity extends BaseActivity {
    private FrameLayout online_webview_container_above;
    private String url;
    @Override
    protected int getFragmentContentId() {
        return R.id.online_webview_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_webview_container);
    }

    @Override
    public void dealLogicBeforeInitView() {

    }

    @Override
    public void initView() {
        online_webview_container_above =

                (FrameLayout) findViewById(R.id
                        .online_webview_container_above);
        url = getIntent().getStringExtra("url");

        LogUtil.d(url.equals("") ? "未获得url" + url : "获得url" + url);
    }

    @Override
    public void dealLogicAfterInitView() {
        addFragment(new PreviewFragment().newInstance(url));
    }

    @Override
    public void onClickEvent(View view) {

    }
}
