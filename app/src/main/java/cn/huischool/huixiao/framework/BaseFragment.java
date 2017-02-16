package cn.huischool.huixiao.framework;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.WindowManager.BadTokenException;
import android.widget.TextView;

import com.baidu.mobstat.StatService;
import com.rey.material.widget.ImageButton;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.common.utils.LogUtil;

public abstract class BaseFragment extends Fragment implements OnClickListener {
    protected Context ct;
    protected BaseActivity baseFragmentActivity;
    protected View view;
    public ProgressDialog progressDialog;
    public boolean isLoadSuccessData = false;

    @Override
    public void onResume() {
        super.onResume();
        /**
         * Fragment页面起始 (注意： 如果有继承的父Fragment中已经添加了该调用，那么子Fragment中务必不能添加）
         */
        StatService.onResume(this);
    }

    public void onPause() {
        super.onPause();

        /**
         *Fragment 页面结束（注意：如果有继承的父Fragment中已经添加了该调用，那么子Fragment中务必不能添加）
         */
        StatService.onPause(this);
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        ct = getActivity();//容易出现 空指针
        this.baseFragmentActivity = (BaseActivity) activity;
        LogUtil.d("onAttach");
    }

    //添加fragment
    protected void addFragment(Fragment fragment) {
        if (null != fragment) {
            baseFragmentActivity.addFragment(fragment);
        }
    }

    //移除fragment
    protected void removeFragment() {
        baseFragmentActivity.removeFragemt();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = initView(inflater);
        if (view != null)
            initData(savedInstanceState);
        LogUtil.d("onCreateView");
        return view;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        LogUtil.d("onActivityCreated");


    }

    @Override
    public void onClick(View v) {
        onClickEvent(v);
    }

    //定义抽象方法 由继承来实现
    public abstract View initView(LayoutInflater inflater);

    public abstract void initData(Bundle savedInstanceState);

    protected abstract void onClickEvent(View view);

    //初始toolbar
    public void initToolBar(Toolbar toolbar, boolean isBack, String title, int imageResourseId,
                            boolean isShow) {

        baseFragmentActivity.setSupportActionBar(toolbar);
        ActionBar actionBar = baseFragmentActivity.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(isBack);
        ((TextView) toolbar.findViewById(R.id.tv_title_clude)).setText(title);
        if (imageResourseId != -1) {
            ((ImageButton) toolbar.findViewById(R.id.imagbtn_action_clude)).setImageResource(imageResourseId);
            if (isShow){
                (toolbar.findViewById(R.id.imagbtn_action_clude)).setVisibility(View.VISIBLE);
            }else {(toolbar.findViewById(R.id.imagbtn_action_clude)).setVisibility(View.GONE);}

        }
        actionBar.setTitle("");


    }

    //显示加载窗口
    public void showProgressDialog(String msg) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        progressDialog = new ProgressDialog(ct);
        progressDialog.setMessage(msg);
        try {
            progressDialog.show();
            progressDialog.setCanceledOnTouchOutside(false);
        } catch (BadTokenException exception) {
            exception.printStackTrace();
        }
    }

    //加载窗口消失
    public void dismissProgressDialog() {
        if (null != progressDialog && progressDialog.isShowing() == true) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }


    /**
     * 得到屏幕宽度
     *
     * @return 宽度
     */
    public int getScreenWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        baseFragmentActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        return screenWidth;
    }

    /**
     * 得到屏幕高度
     *
     * @return 高度
     */
    public int getScreenHeight() {
        DisplayMetrics dm = new DisplayMetrics();
        baseFragmentActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenHeight = dm.heightPixels;
        return screenHeight;
    }

}
