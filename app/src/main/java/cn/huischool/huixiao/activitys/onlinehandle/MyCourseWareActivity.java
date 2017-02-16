package cn.huischool.huixiao.activitys.onlinehandle;

import android.os.Bundle;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlemycourseware.OnlineHandleMineCourseWareFragment;
import cn.huischool.huixiao.framework.BaseActivity;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/7/14.
 */

public class MyCourseWareActivity extends BaseActivity {
    @Override
    protected int getFragmentContentId() {


        return R.id.online_minecourseware_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {

        setContentView(R.layout.activity_onlinehandle_minecourseware_container);

    }

    @Override
    public void dealLogicBeforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void dealLogicAfterInitView() {
        addFragment(OnlineHandleMineCourseWareFragment.newInstance("", "", CustomApplication
                .userInfor.getUserId()));
    }

    @Override
    public void onClickEvent(View view) {

    }
}
