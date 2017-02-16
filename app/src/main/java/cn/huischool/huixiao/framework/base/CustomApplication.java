package cn.huischool.huixiao.framework.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.multidex.MultiDex;
import android.util.Log;


import com.hyphenate.chat.EMChatConfig;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.chat.adapter.EMAChatClient;
import com.hyphenate.easeui.controller.EaseUI;
import com.hyphenate.easeui.domain.EaseUser;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cache.CacheMode;
import com.lzy.okhttputils.model.HttpHeaders;
import com.pgyersdk.Pgy;
import com.pgyersdk.crash.PgyCrashManager;
import com.rey.material.app.ThemeManager;


import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.huischool.huixiao.BuildConfig;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.LoginBean;
import cn.huischool.huixiao.framework.helper.SharedPrefHelper;
import cn.huischool.huixiao.framework.manager.AppManager;
import cn.huischool.huixiao.framework.network.HttpRequestAsyncTask;
import cn.huischool.huixiao.framework.network.HttpRequestAsyncTask.OnCompleteListener;
import cn.huischool.huixiao.framework.network.Request;
import cn.jpush.android.api.JPushInterface;


public class CustomApplication extends Application {
    /**
     * 这里定义全局变量 和方法
     * 存放活动状态的(未被销毁)的Activity列表
     */
    public static List<Activity> unDestroyActivities = new ArrayList<Activity>();
    public static CustomApplication customApplication;
    public static SharedPrefHelper sharedPrefHelper;
    public static LoginBean.ResultsBean userInfor;
    public static boolean isLogin;
    public static AppManager appManager;
    public static String contacts;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        MultiDex.install(this);//
        customApplication = this;
        //第三方数据库初始化、
        LitePal.initialize(this);
        sharedPrefHelper = SharedPrefHelper.getInstance();
        super.onCreate();
        if (!getResources().getString(R.string.app_name).equals("慧校test"))

        {
            //-----------------蒲公英内测-------------
            PgyCrashManager.register(this);// pgy  注册Crash接口
            Pgy.setDebug(BuildConfig.LOG);
        }
        //--------------极光推送--------------


        JPushInterface.setDebugMode(BuildConfig.LOG);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);

        appManager = AppManager.getAppManager();

        // -------------初始化 第三方 okhttp 放置公共参数
        OkHttpUtils.init(this);
        ThemeManager.init(this, 2, 0, null);//rey5137初始化材料布局控件
        HttpHeaders headers = new HttpHeaders();
        headers.put("token", BuildConfig.TOKEN);    //header不支持中文
        try {
            OkHttpUtils.getInstance().setCacheMode(CacheMode.NO_CACHE).addCommonHeaders(headers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //-----------初始化环信即时通讯-------------
        EMOptions options = new EMOptions();


        //默认添加好友时，是不需要验证的改成需要验证。
        options.setAcceptInvitationAlways(false);
        //options.setAutoLogin(false);
        //初始化 EaseUI


        EaseUI.getInstance().init(getApplicationContext(), options);


        /*注：如果你的 APP 中有第三方的服务启动，请在初始化 SDK（EMClient.
        getInstance().init(applicationContext, options)）
        方法的前面添加以下相关代码（相应代码也可参考 Demo 的 application），
        使用 EaseUI 库的就不用理会这个。 */

      /*  int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);
        // 如果APP启用了远程的service，此application:onCreate会被调用2次
        // 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
        // 默认的APP会在以包名为默认的process name下运行，如果查到的process name不是APP的process name就立即返回

        if (processAppName == null ||!processAppName.equalsIgnoreCase(this.getPackageName())) {
            Log.e(TAG, "enter the service process!");

            // 则此application::onCreate 是被service 调用的，直接返回
            return;
        }*/

        //初始化
        EMClient.getInstance().init(getApplicationContext(), options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);

    }

    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;
    }

    /**
     * 得到系统的版本号
     *
     * @return
     */
    public String getOSVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 得到应用的版本号
     *
     * @return
     */
    public int getAppVersionCode() {
        PackageManager packageManager = getPackageManager();

        PackageInfo packInfo;
        int versionCode = 0;
        try {
            //getPackageName()是你当前类的包名，0代表是获取版本信息
            packInfo = packageManager.getPackageInfo(getPackageName(), 0);
            versionCode = packInfo.versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    public static <T> void requestNetWork(Request request, OnCompleteListener<T> onCompleteListener) {
        // TODO Auto-generated method stub
        HttpRequestAsyncTask httpRequestAsyncTask = new HttpRequestAsyncTask();
        httpRequestAsyncTask.setOnCompleteListener(onCompleteListener);
        httpRequestAsyncTask.execute(request);
    }


}
