package cn.huischool.huixiao.activitys.onlinehandle;

import android.os.Bundle;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandleactivitiesofteachandresearch.ActivitiesOfTeachAndresearchFragment;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/8/17.
 */
public class ActivitiesOfTeachAndresearchActivity extends BaseActivity {
    @Override
    protected int getFragmentContentId() {

        return R.id.fl_online_activitiesofteachandresearch_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_onlinehandle_activitiesofteachandresearch_container);
    }

    @Override
    public void dealLogicBeforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void dealLogicAfterInitView() {
        addFragment(new ActivitiesOfTeachAndresearchFragment());
    }

    @Override
    public void onClickEvent(View view) {

    }
}
