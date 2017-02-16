package cn.huischool.huixiao.activitys.onlinehandle;

import android.os.Bundle;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlecheckcourseware.CheckCourseWareFragment;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/7/26.
 */
public class CheckCourseWareActivity extends BaseActivity {
    @Override
    protected int getFragmentContentId() {

        return R.id.fl_online_checkcourseware_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {

        setContentView(R.layout.activity_onlinehandle_checkcourseware_container);
    }

    @Override
    public void dealLogicBeforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void dealLogicAfterInitView() {
        addFragment(new CheckCourseWareFragment());
    }

    @Override
    public void onClickEvent(View view) {

    }
}
