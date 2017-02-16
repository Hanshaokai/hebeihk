package cn.huischool.huixiao.activitys.onlinehandle;

import android.os.Bundle;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlecheckgrammar.CheckGrammarFragment;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/7/26.
 */
public class CheckGrammarActivity extends BaseActivity {
    @Override
    protected int getFragmentContentId() {

        return R.id.fl_online_checkgrammar_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {

        setContentView(R.layout.activity_onlinehandle_checkgrammar_container);
    }

    @Override
    public void dealLogicBeforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void dealLogicAfterInitView() {
        addFragment(new CheckGrammarFragment());
    }

    @Override
    public void onClickEvent(View view) {

    }
}
