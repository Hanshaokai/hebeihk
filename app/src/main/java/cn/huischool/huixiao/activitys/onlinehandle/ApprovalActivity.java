package cn.huischool.huixiao.activitys.onlinehandle;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.onlinehandle.onlineapproval.OnlineHandleApprovalFragment;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/6/15.
 */
public class ApprovalActivity extends BaseActivity {


    private FrameLayout online_approval_container_above;

    @Override
    protected int getFragmentContentId() {
        return R.id.online_approval_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_approval_container);
    }

    @Override
    public void dealLogicBeforeInitView() {

    }

    @Override
    public void initView() {
        online_approval_container_above = (FrameLayout) findViewById(R.id.online_approval_container_above);
    }

    @Override
    public void dealLogicAfterInitView() {
    addFragment(new OnlineHandleApprovalFragment());
    }

    @Override
    public void onClickEvent(View view) {

    }
}
