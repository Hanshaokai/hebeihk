package cn.huischool.huixiao.fragments.mine;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.autoupdatesdk.AppUpdateInfo;
import com.baidu.autoupdatesdk.AppUpdateInfoForInstall;
import com.baidu.autoupdatesdk.BDAutoUpdateSDK;
import com.baidu.autoupdatesdk.CPCheckUpdateCallback;
import com.baidu.autoupdatesdk.UICheckUpdateCallback;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.mine.MineSettingActivity;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.util.AppUtils;

/**
 * Created by ${han} on 2016/7/19.
 */
public class MineSettingFragment extends BaseFragment {

    private LinearLayout ll_mine_setting_check_updates;
    private TextView tv_mine_setting_versions;
    private TextView tv_title_clude;
    private Toolbar toolbar_clude;
    private MineSettingActivity myActivity;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = (MineSettingActivity) baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_mine_setting, null, false);
        ll_mine_setting_check_updates = (LinearLayout) view.findViewById(R.id.ll_mine_setting_check_updates);
        tv_mine_setting_versions = (TextView) view.findViewById(R.id.tv_mine_setting_versions);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initToolBar(toolbar_clude, true, "设置", -1,true);
        tv_mine_setting_versions.setText(AppUtils.getAppVersion(myActivity));
        setHasOptionsMenu(true);//不设置 导致不起作用
        setLisenter();
    }
    private void setLisenter() {
        ll_mine_setting_check_updates.setOnClickListener(this);
    }
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

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.ll_mine_setting_check_updates:
                showProgressDialog("检查最新版本");
                BDAutoUpdateSDK.uiUpdateAction(myActivity, new UICheckUpdateCallback() {
                    @Override
                    public void onCheckComplete() {
                        dismissProgressDialog();
                    }
                });
                break;

        }
    }


}