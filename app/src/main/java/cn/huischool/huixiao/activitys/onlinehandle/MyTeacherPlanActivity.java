package cn.huischool.huixiao.activitys.onlinehandle;

import android.os.Bundle;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlemineteacherplan.OnlineHandleMineGrammarFragment;
import cn.huischool.huixiao.framework.BaseActivity;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/7/8.
 */
public class MyTeacherPlanActivity extends BaseActivity {
    @Override
    protected int getFragmentContentId() {


        return R.id.online_mineplan_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {

        setContentView(R.layout.activity_onlinehandle_mineteacherplan_container);
    }

    @Override
    public void dealLogicBeforeInitView() {


    }


    @Override
    public void initView() {
    }

    @Override
    public void dealLogicAfterInitView() {

        addFragment(OnlineHandleMineGrammarFragment.newInstance("", "", CustomApplication
                .userInfor.getUserId()));
    }

    @Override
    public void onClickEvent(View view) {


    }


}
