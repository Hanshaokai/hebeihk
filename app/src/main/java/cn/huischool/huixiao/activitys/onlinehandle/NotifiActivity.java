package cn.huischool.huixiao.activitys.onlinehandle;


import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlenotifi.OnlineHandleNotifiFragment;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/5/17.
 */
public class NotifiActivity extends BaseActivity {

    private FrameLayout online_notifi_container_above;

    @Override
    protected int getFragmentContentId() {
        return R.id.online_notifi_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_notifi_container);

    }

    @Override
    public void dealLogicBeforeInitView() {

    }

    @Override
    public void initView() {

        online_notifi_container_above = (FrameLayout) findViewById(R.id.online_notifi_container_above);
    }

    @Override
    public void dealLogicAfterInitView() {
        addFragment(new OnlineHandleNotifiFragment());
    }

    @Override
    public void onClickEvent(View view) {
    }


}
