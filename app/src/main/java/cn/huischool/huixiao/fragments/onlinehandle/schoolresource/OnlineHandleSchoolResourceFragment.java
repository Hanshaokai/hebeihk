package cn.huischool.huixiao.fragments.onlinehandle.schoolresource;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.rey.material.widget.ImageButton;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.SchoolResourceActivity;
import cn.huischool.huixiao.adapters.homepage.OnlineViewpagerAdapter;

import cn.huischool.huixiao.common.utils.LogUtil;

import cn.huischool.huixiao.framework.BaseFragment;

/**
 * Created by ${han} on 2016/6/21.
 */
public class OnlineHandleSchoolResourceFragment extends BaseFragment {
// 这个包 下界面未应用和展示
    private SchoolResourceActivity myActivity;
    private Toolbar online_schoolResource_toolbar;
    private TabLayout online_schoolResource_tabs;

    private ViewPager online_schoolResource_container;


    private ImageButton imagbtn_schoolResource_addaffiche;
    private OnlineViewpagerAdapter adapter;

    @Override
    public View initView(LayoutInflater inflater) {

        myActivity = (SchoolResourceActivity) baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_handle_school_resource, null, false);
        online_schoolResource_toolbar = (Toolbar) view.findViewById(R.id.online_schoolResource_toolbar);
        online_schoolResource_container = (ViewPager) view.findViewById(R.id.online_schoolResource_container);
        online_schoolResource_tabs = (TabLayout) view.findViewById(R.id.online_schoolResource_tabs);
        imagbtn_schoolResource_addaffiche = (ImageButton) view.findViewById(R.id.imagbtn_schoolResource_addaffiche);


        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        setOnClicListner();
        initToolBar(online_schoolResource_toolbar,true,"校内共享",-1,true);

        if (online_schoolResource_toolbar != null) {
            setupViewPager(online_schoolResource_container);
            online_schoolResource_tabs.setupWithViewPager(online_schoolResource_container);
        }
    }

    private void setupViewPager(ViewPager online_schoolResource_container) {

        adapter = new OnlineViewpagerAdapter(getChildFragmentManager());
        adapter.addFragment(new SchoolTeacherPlansFragment(), "教案");
        adapter.addFragment(new SchoolCoursewareFragment(), "课件");
        //online_notifi_container.setOffscreenPageLimit(3);
        online_schoolResource_container.setAdapter(adapter);
    }

    /* @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.notifi_actions, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                LogUtil.d("点击了返回");

                removeFragment();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setOnClicListner() {


    }

    @Override
    protected void onClickEvent(View view) {

    }


}
