package cn.huischool.huixiao.activitys.onlinehandle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.onlinehandle.schoolresource.OnlineHandleSchoolResourceFragment;
import cn.huischool.huixiao.framework.BaseActivity;

public class SchoolResourceActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_resource);
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.online_schoolResource_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {

    }

    @Override
    public void dealLogicBeforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void dealLogicAfterInitView() {
addFragment(new OnlineHandleSchoolResourceFragment());
    }

    @Override
    public void onClickEvent(View view) {

    }
}
