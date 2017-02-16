package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlenotifi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.rey.material.widget.ImageButton;


import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.NotifiActivity;
import cn.huischool.huixiao.adapters.homepage.OnlineViewpagerAdapter;
import cn.huischool.huixiao.common.utils.CheckeAuthorityUtils;
import cn.huischool.huixiao.common.utils.LogUtil;

import cn.huischool.huixiao.framework.BaseFragment;

/**
 * Created by ${han} on 2016/5/21.
 */
public class OnlineHandleNotifiFragment extends BaseFragment {
    private Toolbar online_notifi_toolbar;
    private TabLayout online_notifi_tabs;
    private TextView send_notifi;
    private ViewPager online_notifi_container;
    private OnlineViewpagerAdapter adapter;
    private NotifiActivity mActivity;
    private ImageButton imagbtn_action_clude;

    @Override
    public View initView(LayoutInflater inflater) {
        mActivity = (NotifiActivity) baseFragmentActivity;
        View view = inflater.inflate(R.layout.fragment_handle_notifi, null, false);
        online_notifi_toolbar = (Toolbar) view.findViewById(R.id.online_notifi_toolbar);
        online_notifi_container = (ViewPager) view.findViewById(R.id.online_notifi_container);
        online_notifi_tabs = (TabLayout) view.findViewById(R.id.online_notifi_tabs);
        imagbtn_action_clude = (ImageButton) view.findViewById(R.id.imagbtn_action_clude);
       /* send_notifi = (TextView) view.findViewById(R.id.send_notifi);*/
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(online_notifi_toolbar,true,"我的通知",-1,false);
        setOnClicListern();
        if (online_notifi_container != null) {
            setupViewPager(online_notifi_container);
            online_notifi_tabs.setupWithViewPager(online_notifi_container);
        }
    }

    private void setOnClicListern() {
        imagbtn_action_clude.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager vp) {
        adapter = new OnlineViewpagerAdapter(getChildFragmentManager());
        online_notifi_tabs.setVisibility(View.GONE);

        if (CheckeAuthorityUtils.isAuthority("B00001")) {//遍历权限查找所属权限

            imagbtn_action_clude.setVisibility(View.VISIBLE);
            adapter.addFragment(new YetSendNotifiFragment(), "已发送");
            online_notifi_tabs.setVisibility(View.VISIBLE);


        }
        //adapter.addFragment(new DraftBoxFragment(), "草稿箱");

        adapter.addFragment(new ReceivNotifiFragment(), "收件箱");

        //online_notifi_container.setOffscreenPageLimit(3);
        online_notifi_container.setAdapter(adapter);
        online_notifi_container.setCurrentItem(1);

        //第二个被选中
    }


    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {

            case R.id.imagbtn_action_clude:

                addFragment(new TosendNotifiFragment());

                LogUtil.d("点击发送通知");
                break;


        }

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


}
