package cn.huischool.huixiao;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.exceptions.HyphenateException;

import java.util.HashSet;
import java.util.Set;

import cn.huischool.huixiao.activitys.home.MainActivity;
import cn.huischool.huixiao.bean.LoginBean;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.ToolRegex;
import cn.huischool.huixiao.framework.BaseActivity;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.achieve.DataAchieve.SuccessCallBack;
import cn.huischool.huixiao.framework.base.CustomApplication;
import cn.huischool.huixiao.framework.helper.SharedPrefHelper;
import cn.huischool.huixiao.framework.util.AppUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * @author han
 *         <p/>
 *         2016-4-15
 */
public class LoginActivity extends BaseActivity {
    EditText edt_password;
    EditText edt_username;

    Button btn_login;

    String password;
    String userName;
    private String extras;
    private Toolbar toolbar_clude;
    private TextView tv_title_clude;


    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
    }


    @Override
    public void dealLogicBeforeInitView() {
        // TODO Auto-generated method stub

    }


    @Override
    public void initView() {

        edt_password = (EditText) findViewById(R.id.edt_password);
        edt_username = (EditText) findViewById(R.id.edt_username);

        toolbar_clude = (Toolbar) findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) findViewById(R.id.tv_title_clude);
        edt_password.setInputType(EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);


        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);


    }


    @Override
    public void dealLogicAfterInitView() {
        toolbar_clude.setTitle("");
        tv_title_clude.setText("登录到慧校");
        setSupportActionBar(toolbar_clude);

        extras = getIntent().getStringExtra("extras");

        String passwordsh = SharedPrefHelper.getString("password");
        String userNamesh = SharedPrefHelper.getString("userName");
        if ((!TextUtils.isEmpty(passwordsh)) && (!TextUtils.isEmpty(userNamesh))) {
            edt_password.setText(passwordsh);
            edt_username.setText(userNamesh);
            edt_username.setSelection(userNamesh.length());

        }


        if (SharedPrefHelper.getIsLogin() && (SharedPrefHelper.getString("build") != null) &&
                (SharedPrefHelper.getString("build").equals(AppUtils
                        .getAppVersion(CustomApplication.customApplication))
                ))


        {
            String user = SharedPrefHelper.getString("userInfor");


            CustomApplication.userInfor = JSON.parseObject(user, LoginBean.ResultsBean.class);
            //如果登陆过 就从缓存中拿去登录返回信息
            //退出后已经关闭推送 不必考虑重新登录情况
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            if (extras != null && !TextUtils.isEmpty(extras)) {
                intent.putExtra("extras", extras);
                LogUtil.d(extras);
            } else {
                LogUtil.d("空的值通知");

            }


            startActivity(intent);
            finish();


            return;
        }
    }


    @Override
    public void onClickEvent(View view) {
        // TODO Auto-generated method stub
        switch (view.getId()) {
            case R.id.btn_login:
                beforelogin();

                break;

            default:
                break;
        }

    }

    private void beforelogin() {


        password = edt_password.getText().toString().trim();
        userName = edt_username.getText().toString().trim();
        if (TextUtils.isEmpty(password) || TextUtils.isEmpty(userName)) {
            Toast.makeText(mContext, "输入不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (ToolRegex.checkBlankSpace(password) || ToolRegex.checkBlankSpace(userName)) {
            Toast.makeText(mContext, "输入不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        tologin();

    }

    private void logUpHuanXinEm() {

        EMClient.getInstance().login(CustomApplication.userInfor.getUserId(), "123", new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                //update current user's display name for APNs ？
                boolean updatenick = EMClient.getInstance().updateCurrentUserNick
                        (CustomApplication.userInfor.getRealName());
                if (updatenick) {
                    //获得当前登录的用户名EMClient.getInstance().getCurrentUser(); 通过参数 asyncGetCurrentUserInfo
                    //获得EaseUser 对象 asyncGetUserInfo方法中对 EaseUser 中nick username 赋值
                    LogUtil.d("LoginActivity", "更新当前用户昵称失败");
                }
                //这个方法设置用户信息 从服务器中获得或者第三方服务 此app已经在登录返回信息中获得
              /*  // get user's info (this should be get from App's server or 3rd party service)
                DemoHelper.getInstance().getUserProfileManager().asyncGetCurrentUserInfo();*/

                runOnUiThread(new Runnable() {
                    public void run() {

                        Toast.makeText(getApplicationContext(), "登陆聊天服务器成功",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                Log.d("main", "登录聊天服务器成功！");


            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.d("main", "登录聊天服务器失败！");
                logInHuanXinEm();
            }
        });


    }

    private void logInHuanXinEm() {
        //注册失败会抛出HyphenateException
        try {
            EMClient.getInstance().createAccount(CustomApplication.userInfor.getUserId(), "123");//同步方法
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(getApplicationContext(), "注册环信成功", Toast.LENGTH_SHORT).show();
                }
            });
            Log.d("main", "注册环信成功！");
        } catch (HyphenateException e) {
            e.printStackTrace();
            Toast.makeText(this, "注册环信失败", Toast.LENGTH_SHORT).show();
            Log.d("main", "注册环信失败！");
        }

    }

    private void tologin() {
        showProgressDialog("正在登陆....");


        //设置极光标签和别名


        DataAchieve.login(
                new SuccessCallBack() {

                    @Override
                    public void handle(int code, Object object) {
                        if (code != 1000) {
                            dismissProgressDialog();

                        } else {
                            CustomApplication.userInfor = ((LoginBean) object).getResults();
                            if (CustomApplication.userInfor != null) {
                                Log.d("tag", "user" + CustomApplication.userInfor.getUserId());
                            } else {
                                Log.d("tag", "user是空值" + ((LoginBean.ResultsBean) object).getUserId());
                            }
                            setALAndTa();//极光注册别名和标签
                            SharedPrefHelper.setIsLogin(true);

                            //登录环信

                            logUpHuanXinEm();
                            SharedPrefHelper.setString("userInfor", JSON.toJSONString(CustomApplication.userInfor));
                            SharedPrefHelper.setString("build", AppUtils.getAppVersion(CustomApplication.customApplication));


                            SharedPrefHelper.setString("password", password);
                            SharedPrefHelper.setString("userName", userName);

                            dismissProgressDialog();

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//防止重复activity
                            startActivity(intent);
                            finish();

                        }

                    }
                }, userName, password);
    }


    public void setALAndTa() {
        Set<String> tags = new HashSet<>();
        tags.add(CustomApplication.userInfor.getSchoolId());

        if (JPushInterface.isPushStopped(CustomApplication.customApplication)) {//判断推送是否停止

            JPushInterface.resumePush(CustomApplication.customApplication);//恢复推送

        }
        JPushInterface.setAliasAndTags(this, CustomApplication.userInfor.getUserId(),
                tags, new TagAliasCallback() {
                    @Override
                    public void gotResult(int i, String s, Set<String> set) {
                        if (i == 0) {
                            LogUtil.d("登录极光推送注册别名和标签");

                        }
                        LogUtil.d(s + " " + set.toString());
                    }
                });


    }


}
