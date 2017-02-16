package cn.huischool.huixiao.framework;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.baidu.mobstat.StatService;

import cn.huischool.huixiao.common.utils.LogUtil;

/**
 * Created by ${han} on 2016/8/19.
 */
public abstract class BaseLazyLoadefragment extends Fragment implements View.OnClickListener {

    protected Context ct;
    protected BaseActivity baseFragmentActivity;
    protected View view;
    public ProgressDialog progressDialog;

    //控件是否已经初始化
    private boolean isCreateView = false;
    private Bundle bundle;
    //是否已经加载过数据
    private boolean isLoadData = false;

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
    protected void addFragment(BaseFragment fragment) {
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

    //此方法在控件初始化前调用，所以不能在此方法中直接操作控件会出现空指针
    /*视图从见到不见都会调用setUserVisobleHint*/
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtil.d("setUserVisibleHint");
        if (isVisibleToUser && isCreateView && !isLoadData) {

            //加载数据操作
            isLoadData = true;
            initData(bundle);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = initView(inflater);
        bundle = savedInstanceState;
        LogUtil.d("onCreateView");
        isCreateView = true;
        return view;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        //第一个fragment会调用
        if (getUserVisibleHint())

        {
            //加载数据操作
            isLoadData = true;
            initData(bundle);
        }
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

    //显示加载窗口
    public void showProgressDialog(String msg) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        progressDialog = new ProgressDialog(baseFragmentActivity);
        progressDialog.setMessage(msg);
        try {
            progressDialog.show();
            progressDialog.setCanceledOnTouchOutside(false);
        } catch (WindowManager.BadTokenException exception) {
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

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        isCreateView = false;
        isLoadData = false;
        LogUtil.d("onDestroyView");
    }
}
