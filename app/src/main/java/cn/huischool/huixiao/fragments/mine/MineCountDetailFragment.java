package cn.huischool.huixiao.fragments.mine;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;


import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import cn.huischool.huixiao.LoginActivity;
import cn.huischool.huixiao.R;

import cn.huischool.huixiao.activitys.home.MainActivity;
import cn.huischool.huixiao.activitys.mine.changeinforacticitys.ChangeCountInforActivity;
import cn.huischool.huixiao.activitys.mine.MineCountDetailActivity;
import cn.huischool.huixiao.bean.MyCountInforBean;
import cn.huischool.huixiao.common.utils.LogUtil;

import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;
import cn.huischool.huixiao.framework.helper.SharedPrefHelper;
import cn.huischool.huixiao.framework.manager.AppManager;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by ${han} on 2016/7/12.
 */
public class MineCountDetailFragment extends BaseFragment {


    @BindView(R.id.appbar_clude)
    AppBarLayout appbar_clude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtn_action_clude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbar_clude;
    @BindView(R.id.tv_title_clude)
    android.widget.TextView tv_title_clude;

    @BindView(R.id.tv_qq_mine)
    TextView tv_qq_mine;
    @BindView(R.id.tv_job_mine)
    TextView tv_job_mine;

    @BindView(R.id.tv_mail_mine)
    TextView tv_mail_mine;
    @BindView(R.id.tv_number_mine)
    TextView tv_number_mine;
    @BindView(R.id.tv_partjob_mine)
    TextView tv_partjob_mine;
    @BindView(R.id.tv_sex_mine)
    TextView tv_sex_mine;

    @BindView(R.id.tv_sub_mine)
    TextView tv_sub_mine;
    @BindView(R.id.tv_tel_mine)
    TextView tv_tel_mine;


    @BindView(R.id.tv_realName_mine)
    TextView tv_realName_mine;

    @BindView(R.id.tv_chaninfo_mine)
    TextView btn_chaninfo_mine;

    @BindView(R.id.tv_chanpas_mine)
    TextView btn_chanpas_mine;
    @BindView(R.id.btn_quit_mine)
    Button btn_quit_mine;
    private Unbinder unbinder;
    private MineCountDetailActivity myActivity;
    private MyCountInforBean.ResultsBean result = null;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = (MineCountDetailActivity) baseFragmentActivity;
        View view = inflater.inflate(R.layout.fragment_mine_infor, null, false);
        unbinder = ButterKnife.bind(MineCountDetailFragment.this, view);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_clude,true,"我的资料",-1,true);
        setMineLisenter();
        showCountInfor();
    }

    private void setMineLisenter() {
        btn_chaninfo_mine.setOnClickListener(this);
        btn_chanpas_mine.setOnClickListener(this);
        btn_quit_mine.setOnClickListener(this);
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

    private void showCountInfor() {
        DataAchieve.myCouInfo(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                if (code != 1000) {
                    return;
                } else {

                    result = ((MyCountInforBean) object).getResults();
                    if (result != null) {
                        myCountInforSet();

                    }
                }
            }
        }, CustomApplication.userInfor.getSchoolId(), CustomApplication.userInfor.getUserId());


    }

    private void myCountInforSet() {
        tv_realName_mine.setText(result.getRealName());
        tv_qq_mine.setText(result.getQq());
        tv_job_mine.setText(result.getPosition());
        tv_mail_mine.setText(result.getEmail());
        tv_number_mine.setText(result.getUserName());
        tv_sex_mine.setText(result.getGender());
        tv_partjob_mine.setText((String) (result.getDuty()));
        tv_tel_mine.setText(result.getPhone());
    }

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.tv_chaninfo_mine:
                Intent intent = new Intent(myActivity, ChangeCountInforActivity.class);
                intent.putExtra("changetype", "infor");
                Bundle bundle = new Bundle();
                bundle.putSerializable("ResultsBean", result);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.tv_chanpas_mine:
                Intent intent2 = new Intent(myActivity, ChangeCountInforActivity.class);
                intent2.putExtra("changetype", "password");
                startActivity(intent2);

                break;
            case R.id.btn_quit_mine:


                //环信退出
                EMClient.getInstance().logout(true, new EMCallBack() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(int i, String s) {

                    }

                    @Override
                    public void onProgress(int i, String s) {

                    }
                });
                JPushInterface.stopPush(CustomApplication.customApplication);//退出账号关闭极光推送
                SharedPrefHelper.setIsLogin(false);
                Toast.makeText(CustomApplication.customApplication, "账号已退出", Toast.LENGTH_SHORT)
                        .show();
                AppManager.getAppManager().finishAllActivity();
             /*   Intent intentToLogin = new Intent(myActivity, LoginActivity.class);
                startActivity(intentToLogin);*/
                //  myActivity.finish();

                Intent intentapp = new Intent(Intent.ACTION_MAIN);
                intentapp.addCategory(Intent.CATEGORY_LAUNCHER);
                ComponentName cn = new ComponentName("cn.huischool.huixiao", "cn.huischool.huixiao.LoginActivity");
                intentapp.setComponent(cn);

                intentapp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                CustomApplication.customApplication.startActivity(intentapp);


        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
