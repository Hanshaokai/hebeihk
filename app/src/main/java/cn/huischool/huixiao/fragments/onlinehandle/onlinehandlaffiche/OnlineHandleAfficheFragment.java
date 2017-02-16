package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlaffiche;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.rey.material.widget.ImageButton;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.AfficheActivity;
import cn.huischool.huixiao.adapters.homepage.OnlineViewpagerAdapter;
import cn.huischool.huixiao.common.utils.CheckeAuthorityUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseFragment;

/**
 * Created by ${han} on 2016/6/6.
 */
public class OnlineHandleAfficheFragment extends BaseFragment {

    private AppCompatActivity mActivity;
    private Toolbar online_affiche_toolbar;
    private TabLayout online_affiche_tabs;
    private ViewPager online_affiche_container;
    private ImageButton imagbtn_action_clude;
    private OnlineViewpagerAdapter adapter;

    @Override
    public View initView(LayoutInflater inflater) {

        mActivity = baseFragmentActivity;
        View view = inflater.inflate(R.layout.fragment_handle_affich, null, false);
        online_affiche_toolbar = (Toolbar) view.findViewById(R.id.online_affiche_toolbar);
        online_affiche_container = (ViewPager) view.findViewById(R.id.online_affiche_container);
        online_affiche_tabs = (TabLayout) view.findViewById(R.id.online_affiche_tabs);
        imagbtn_action_clude = (ImageButton) view.findViewById(R.id.imagbtn_action_clude);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        setOnClicListern();
        initToolBar(online_affiche_toolbar, true, "我的公告", -1, false);
        if (online_affiche_toolbar != null) {
            setupViewPager(online_affiche_container);
            online_affiche_tabs.setupWithViewPager(online_affiche_container);
        }
    }


    private void setOnClicListern() {
        imagbtn_action_clude.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager vp) {
        adapter = new OnlineViewpagerAdapter(getChildFragmentManager());
        online_affiche_tabs.setVisibility(View.GONE);
        if (CheckeAuthorityUtils.isAuthority("B00001")) {//遍历权限查找所属权限
            imagbtn_action_clude.setVisibility(View.VISIBLE);
            adapter.addFragment(new YetSendAfficheFragment(), "已发送");
            online_affiche_tabs.setVisibility(View.VISIBLE);
        }
        //adapter.addFragment(new DraftBoxFragment(), "草稿箱");

        adapter.addFragment(new ReceivAfficheFragment(), "收件箱");
        //online_notifi_container.setOffscreenPageLimit(3);
        online_affiche_container.setAdapter(adapter);
        online_affiche_container.setCurrentItem(1);
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
                /*Intent intent = new Intent(mActivity, MainActivity.class);

                intent.putExtra("type", "online");
                startActivity(intent);*/
                removeFragment();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onClickEvent(View view) {

        switch (view.getId()) {

            case R.id.imagbtn_action_clude:


                addFragment(new TosendAfficheFragment());
                LogUtil.d("点击发送通知");
                break;


        }


    }
}
