package cn.huischool.huixiao.activitys.contacts;

import android.os.Bundle;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.contactsfragment.ConversationListFragment;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/12/13.
 */

public class ConversationListActivity extends BaseActivity {
    @Override
    protected int getFragmentContentId() {
        return R.id.conversation_list_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_converation_list_container);
    }

    @Override
    public void dealLogicBeforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void dealLogicAfterInitView() {
        addFragment(new ConversationListFragment());
    }

    @Override
    public void onClickEvent(View view) {

    }
}
