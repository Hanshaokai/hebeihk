package cn.huischool.huixiao.framework;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.view.inputmethod.InputMethodManager;


import com.baidu.mobstat.StatService;

import cn.huischool.huixiao.framework.base.CustomApplication;
import cn.huischool.huixiao.framework.manager.AppManager;
import cn.jpush.android.api.JPushInterface;


/**
 * activity 的基类添加共用的 方法 和变量
 *
 * @author han
 *         <p/>
 *         2016-4-15
 */

public abstract class BaseActivity extends AppCompatActivity implements OnClickListener {
    protected CustomApplication customApplication;
    protected Activity mContext;
    public boolean isAllowFullScreen;//是否允许全屏
    public String activityTag;//每个activity的标记
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub



       /* if (isAllowFullScreen) {
            setFullScreen(true);
        } else {
            setFullScreen(false);
        }
*/
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        mContext = this;
        customApplication = (CustomApplication) getApplicationContext();


  /*沉浸式处理布局android:fitsSystemWindows=”true”不会让系统导航栏和我们app的UI重叠，导致交互问题。*/
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        ViewGroup contentFrameLayout = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        View parentView = contentFrameLayout.getChildAt(0);
        if (parentView != null && Build.VERSION.SDK_INT >= 14) {
            parentView.setFitsSystemWindows(true);
        }


        //避免重复添加 Fragment

        /* if (null == getSupportFragmentManager().getFragments()) {
        BaseFragment firstFragment = getFirstFragment();
        if (null != firstFragment) {
            addFragment(firstFragment);
        }
    }*/
        setContentLayout(savedInstanceState);
        dealLogicBeforeInitView();
        initView();
        dealLogicAfterInitView();

    }

    //添加fragment
    protected void addFragment(Fragment fragment) {
        if (fragment != null) {

            getSupportFragmentManager().beginTransaction().
                    replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();

        }


    }

    // 移除fragment
    protected void removeFragemt() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {

            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }


    }


    //返回键 返回事件


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {

                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    //布局中Fragment的ID
    protected abstract int getFragmentContentId();

    /**
     * 设置布局文件
     */
    public abstract void setContentLayout(Bundle savedInstanceState);

    /**
     * 在实例化布局之前处理的逻辑
     */
    public abstract void dealLogicBeforeInitView();

    /**
     * 实例化布局文件/组件
     */
    public abstract void initView();

    /**
     * 在实例化布局之后处理的逻辑
     */
    public abstract void dealLogicAfterInitView();

    abstract public void onClickEvent(View view);

    @Override
    public void onClick(View v) {
        onClickEvent(v);
    }

    /**
     * 是否全屏和显示标题，true为全屏和无标题，false为无标题，请在setContentView()方法前调用
     *
     * @param fullScreen
     */
    public void setFullScreen(boolean fullScreen) {
        if (fullScreen) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

    }

    public void showProgressDialog(String msg) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        progressDialog = new ProgressDialog(BaseActivity.this);
        progressDialog.setMessage(msg);

        try {
            progressDialog.show();
        } catch (BadTokenException exception) {
            exception.printStackTrace();
        }
    }

    public void dismissProgressDialog() {
        if (null != progressDialog && progressDialog.isShowing() == true) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*极光推送*/
        JPushInterface.onResume(this);
        /**
         * 页面起始（注意： 每个Activity中都需要添加，如果有继承的父Activity中已经添加了该调用，那么子Activity中务必不能添加）
         * 如果该FragmentActivity包含了几个全页面的fragment，那么可以在fragment里面加入就可以了，这里可以不加入。如果不加入将不会记录该Activity页面。
         */
        StatService.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        /*极光推送*/
        JPushInterface.onPause(this);
        /**
         * 页面结束（注意： 每个Activity中都需要添加，如果有继承的父Activity中已经添加了该调用，那么子Activity中务必不能添加）
         * 如果该FragmentActivity包含了几个全页面的fragment，那么可以在fragment里面加入就可以了，这里可以不加入。如果不加入将不会记录该Activity页面。
         */
        StatService.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }


    /**
     * 处理弹出的输入法
     */
    public void dismissSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManage = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManage.hideSoftInputFromWindow(activity
                            .getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}