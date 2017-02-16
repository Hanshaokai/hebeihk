package cn.huischool.huixiao.activitys.contacts;

import android.os.Bundle;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.contactsfragment.PersonDetailOfContactsFragment;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/10/18.
 */

public class ContactsPersonDetailActivity extends BaseActivity {

    private Bundle bundle;

    @Override
    protected int getFragmentContentId() {
        return R.id.contacts_detail_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_contacts_detail_container);
    }

    @Override
    public void dealLogicBeforeInitView() {
        bundle = getIntent().getExtras();
    }

    @Override
    public void initView() {

    }

    @Override
    public void dealLogicAfterInitView() {
        addFragment(PersonDetailOfContactsFragment.newInstance(bundle));
    }

    @Override
    public void onClickEvent(View view) {

    }
}
