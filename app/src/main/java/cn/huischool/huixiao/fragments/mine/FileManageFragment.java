package cn.huischool.huixiao.fragments.mine;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.adapters.homepage.OnlineViewpagerAdapter;
import cn.huischool.huixiao.fragments.mine.filemanage.DownloadeDuringFragment;
import cn.huischool.huixiao.fragments.mine.filemanage.FileLoadCompletedFragment;
import cn.huischool.huixiao.framework.BaseFragment;

/**
 * Created by ${han} on 2016/9/6.
 */
public class FileManageFragment extends BaseFragment {

    @BindView(R.id.tv_title_clude)
    TextView tv_title_clude;
    @BindView(R.id.toolbar_file_manage)
    Toolbar toolbarFileManage;
    @BindView(R.id.tab_file_manage)
    TabLayout tabFileManage;
    @BindView(R.id.appbar_file_manage)
    AppBarLayout appbarFileManage;
    @BindView(R.id.vpager_file_manage)
    ViewPager vpagerFileManage;
    @BindView(R.id.coor_file_manage)
    CoordinatorLayout coorFileManage;
    private Unbinder unbinder;
    private AppCompatActivity myActivity;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_file_manage, null, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbarFileManage, true, "我的下载",-1,true);
        setupViewPager();
        tabFileManage.setupWithViewPager(vpagerFileManage);

    }

    private void setupViewPager() {
        OnlineViewpagerAdapter adapter = new OnlineViewpagerAdapter(getChildFragmentManager());
        adapter.addFragment(new FileLoadCompletedFragment(), "下载完成");
      adapter.addFragment(new DownloadeDuringFragment(), "正在下载");
        vpagerFileManage.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                removeFragment();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected void onClickEvent(View view) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
