package cn.huischool.huixiao.activitys.onlinehandle;

import android.os.Bundle;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.onlinehandle.onlineresearchtable.OnLineResearchTableFragment;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/12/21.
 */

public class ResearchTableActivity extends BaseActivity {
    @Override
    protected int getFragmentContentId() {
        return R.id.online_research_table_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_onlinehandle_reasearch_table_container);
    }

    @Override
    public void dealLogicBeforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void dealLogicAfterInitView() {
        addFragment(new OnLineResearchTableFragment());
    }

    @Override
    public void onClickEvent(View view) {

    }
}
