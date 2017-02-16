package cn.huischool.huixiao.fragments.onlinehandle.onlineapproval;

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
import cn.huischool.huixiao.activitys.onlinehandle.ApprovalActivity;
import cn.huischool.huixiao.adapters.homepage.OnlineViewpagerAdapter;
import cn.huischool.huixiao.common.utils.CheckeAuthorityUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.OpinionCallBackUtil;
import cn.huischool.huixiao.framework.BaseFragment;

/**
 * Created by ${han} on 2016/6/15.
 */
public class OnlineHandleApprovalFragment extends BaseFragment {

    private ApprovalActivity mActivity;
    private Toolbar online_approval_toolbar;
    private TabLayout online_approval_tabs;
    private ViewPager online_approval_container;
    private ImageButton imagbtn_online_addapproval;
    private OnlineViewpagerAdapter adapter;

    @Override
    public View initView(LayoutInflater inflater) {
        mActivity = (ApprovalActivity) baseFragmentActivity;
        View view = inflater.inflate(R.layout.fragment_handle_approval, null, false);
        online_approval_toolbar = (Toolbar) view.findViewById(R.id.online_approval_toolbar);
        online_approval_container = (ViewPager) view.findViewById(R.id.online_approval_container);
        online_approval_tabs = (TabLayout) view.findViewById(R.id.online_approval_tabs);
        imagbtn_online_addapproval = (ImageButton) view.findViewById(R.id.imagbtn_online_addapproval);
        return view;

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        setOnClicListern();
        initToolBar(online_approval_toolbar,true,"我的审批",-1,true);
        if (online_approval_toolbar != null) {
            setupViewPager(online_approval_container);
            online_approval_tabs.setupWithViewPager(online_approval_container);
        }
    }

    private void setOnClicListern() {
        imagbtn_online_addapproval.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager vp) {
        adapter = new OnlineViewpagerAdapter(getChildFragmentManager());
        imagbtn_online_addapproval.setVisibility(View.VISIBLE);
        adapter.addFragment(new YetSendApprovalFragment(), "我发起的");
        online_approval_tabs.setVisibility(View.GONE);
        if (CheckeAuthorityUtils.isAuthority("B00004")) {//遍历权限查找所属权限
            adapter.addFragment(new ReceivApprovalFragment(), "我审批的");
            adapter.addFragment(new InformMeOfApprovalFragment(), "知会我的");
            online_approval_tabs.setVisibility(View.VISIBLE);
        }
        //adapter.addFragment(new DraftBoxFragment(), "草稿箱");


        //online_notifi_container.setOffscreenPageLimit(3);
        online_approval_container.setAdapter(adapter);
        online_approval_container.setCurrentItem(1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                LogUtil.d("点击了返回");
               /* Intent intent = new Intent(mActivity, MainActivity.class);

                intent.putExtra("type", "online");
                startActivity(intent);*/
                // mActivity.finish();
                OpinionCallBackUtil.getIntence().clear();
                removeFragment();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {

            case R.id.imagbtn_online_addapproval:


                addFragment(new TosendApprovalFragment());
                LogUtil.d("点击发送申请");
                break;
        }
    }
}
