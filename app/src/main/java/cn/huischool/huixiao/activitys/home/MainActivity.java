package cn.huischool.huixiao.activitys.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.baidu.autoupdatesdk.BDAutoUpdateSDK;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.controller.EaseUI;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.OnlineDetailFromIdActivity;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.widget.widgetofbindbadgeview.BadgeView;
import cn.huischool.huixiao.fragments.ContactsFragment;
import cn.huischool.huixiao.fragments.HomePageFragment;
import cn.huischool.huixiao.fragments.MineFragment;
import cn.huischool.huixiao.fragments.OnlineHandleFragment;
import cn.huischool.huixiao.framework.BaseActivity;
import cn.huischool.huixiao.framework.base.CustomApplication;
import cn.huischool.huixiao.framework.manager.AppManager;


public class MainActivity extends BaseActivity implements EMMessageListener {

    public LinearLayout group_tab_bar;
    public RadioButton rbt_tab_contacts;
    public RadioButton rbt_tab_edresources;
    public RadioButton rbt_tab_homepage;
    public RadioButton rbt_tab_onhandle;
    public RadioButton rbt_tab_mine;
    public FragmentManager supportFragmentManager;
    public Fragment homePageFragment;
    public Fragment contactsFragment;
    public Fragment onlineHandleFragment;
    public Fragment mineFragment;
    private String type = "0";
    private long exitTime = 0;
    private FragmentTransaction tran;
    private List<Fragment> listFragment = new ArrayList<Fragment>();
    private String extras;
    private BadgeView msgcount;
    private MesgCallBack mesgCallBack;
    public void setMesgCallBack(MesgCallBack mesgCallBack) {
        this.mesgCallBack = mesgCallBack;
    }
    /**
     * 回调消息数量显示消息数
     */
    public interface MesgCallBack {
        public void receptMsgCount(int num);
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
/* onCreate方法中增加以下启动调用：百度性能服务接口只有一句 ：性能服务*/
        //UAQ.withApplicationToken(null).start(getApplication());
        /**/
        setContentView(R.layout.activity_main);
        BDAutoUpdateSDK.silenceUpdateAction(this);//百度静默更新
        supportFragmentManager = getSupportFragmentManager();
        /*同级式Fragment 在内存不足导致的异常情况下，会出现重叠现想*/
        if (savedInstanceState != null) {
            homePageFragment = (HomePageFragment) supportFragmentManager.findFragmentByTag
                    ("HomePageFragment");
            contactsFragment = (ContactsFragment) supportFragmentManager.findFragmentByTag
                    ("ContactsFragment");
            onlineHandleFragment = (OnlineHandleFragment) supportFragmentManager.findFragmentByTag
                    ("OnlineHandleFragment");
            mineFragment = (MineFragment) supportFragmentManager.findFragmentByTag
                    ("MineFragment");
            listFragment.add(homePageFragment);
            listFragment.add(contactsFragment);
            listFragment.add(onlineHandleFragment);
            listFragment.add(mineFragment);
        }
    }


    @Override
    public void dealLogicBeforeInitView() {

    }




    @Override
    public void initView() {
        group_tab_bar = (LinearLayout) findViewById(R.id.group_tab_bar);
        rbt_tab_contacts = (RadioButton) findViewById(R.id.rbt_tab_contacts);
        rbt_tab_edresources = (RadioButton) findViewById(R.id.rbt_tab_edresources);
        rbt_tab_homepage = (RadioButton) findViewById(R.id.rbt_tab_homepage);
        rbt_tab_onhandle = (RadioButton) findViewById(R.id.rbt_tab_onhandle);
        rbt_tab_mine = (RadioButton) findViewById(R.id.rbt_tab_mine);
        rbt_tab_contacts.setOnClickListener(this);
        rbt_tab_edresources.setOnClickListener(this);
        rbt_tab_homepage.setOnClickListener(this);
        rbt_tab_onhandle.setOnClickListener(this);
        rbt_tab_mine.setOnClickListener(this);
        if (msgcount == null) {
            msgcount = new BadgeView(this);

            msgcount.setTargetView(rbt_tab_contacts);
            msgcount.setBadgeMargin(-1, -1, 20, -1);
        }
    }

    public void setClicked(View v) {


        rbt_tab_onhandle.setChecked(false);
        rbt_tab_contacts.setChecked(false);
        rbt_tab_edresources.setChecked(false);
        rbt_tab_homepage.setChecked(false);
        rbt_tab_mine.setChecked(false);
        ((RadioButton) v).setChecked(true);

    }


    @Override
    public void dealLogicAfterInitView() {


        extras = getIntent().getStringExtra("extras");

        if (extras != null && !TextUtils.isEmpty(extras)) {
            com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject
                    (extras);

            LogUtil.d(extras);
            switch (jsonObject.getString("msg_type")) {
                //通知0 公告1审批2extras.put("msg_id", notice.getId());
                //extras.put("msg_type", "0");

                case "0":
                    Intent notifi = new Intent(this, OnlineDetailFromIdActivity.class);
                    notifi.putExtra("noticeId", jsonObject.get("msg_id").toString());

                    startActivity(notifi);

                    break;
                case "1":
                    Intent affiche = new Intent(this, OnlineDetailFromIdActivity.class);
                    affiche.putExtra("afficheId", jsonObject.get("msg_id").toString());

                    startActivity(affiche);
                    break;
                case "2":
                    Intent approval = new Intent(this, OnlineDetailFromIdActivity.class);
                    approval.putExtra("approvalId", jsonObject.get("msg_id").toString());
                    startActivity(approval);
                    break;
                case "3":
                    Intent informapproval = new Intent(this, OnlineDetailFromIdActivity.class);
                    informapproval.putExtra("informApprovalId", jsonObject.get("msg_id").toString
                            ());
                    startActivity(informapproval);
                    break;

                case "4":
                    Intent yetSendapproval = new Intent(this, OnlineDetailFromIdActivity.class);
                    yetSendapproval.putExtra("yetSendApprovalId", jsonObject.get("msg_id").toString());
                    startActivity(yetSendapproval);
                    break;
                case "5":
                    Intent grammar = new Intent(this, OnlineDetailFromIdActivity.class);
                    grammar.putExtra("grmmarYetApprovalId", jsonObject.get("msg_id").toString());
                    startActivity(grammar);
                    break;
                case "6":
                    Intent coureseWare = new Intent(this, OnlineDetailFromIdActivity.class);
                    coureseWare.putExtra("courseWareYetApprovalId", jsonObject.get("msg_id").toString());
                    startActivity(coureseWare);
                    break;

            }


            setClicked(rbt_tab_onhandle);
            changeMianFragment(rbt_tab_onhandle.getId());
        } else {

            setClicked(rbt_tab_homepage);

            changeMianFragment(rbt_tab_homepage.getId());
        }


    }

   /* public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction("MESSAGE_RECEIVED_ACTION");
        registerReceiver(mMessageReceiver, filter);
    }
*/
  /*  public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if ("MESSAGE_RECEIVED_ACTION".equals(intent.getAction())) {

                String extras = intent.getStringExtra("extras");





            }
        }
    }*/

    @Override
    public void onClickEvent(View view) {
        // TODO Auto-generated method stub
        setClicked(view);
      /*  if (((LinearLayout) view.getParent()).getId() == R.id.group_tab_bar) {
            changeMianFragment(view.getId());
            BagedView 中加了framelayout
            java.lang.ClassCastException: android.widget.FrameLayout cannot be cast to andr.oid
            .widget.LinearLayout
        }*/
        changeMianFragment(view.getId());
        LogUtil.d("maiactivity", view.getId());
    }


    private void changeMianFragment(int checkedId) {
        tran = supportFragmentManager.beginTransaction();
        for (int i = 0; i < listFragment.size(); i++) {
            if (listFragment.get(i) != null) {
                tran.hide(listFragment.get(i));
                LogUtil.d(i + "");
            }
        }
        //判斷選中時那個tab
        switch (checkedId) {
            case R.id.rbt_tab_homepage:
                if (homePageFragment == null) {
                    homePageFragment = new HomePageFragment();

                    listFragment.add(homePageFragment);


                    tran.add(R.id.main_container, homePageFragment, "HomePageFragment");

                } else {
                    tran.show(homePageFragment);
                }
                LogUtil.d("maiactivity", checkedId);
                break;
            case R.id.rbt_tab_contacts:

                if (contactsFragment == null) {
                    contactsFragment = new ContactsFragment();

                    listFragment.add(contactsFragment);

                    tran.add(R.id.main_container, contactsFragment, "contactsFragment");

                } else {
                    tran.show(contactsFragment);
                }
                LogUtil.d("maiactivity", checkedId);
                break;
            case R.id.rbt_tab_onhandle:
                if (onlineHandleFragment == null) {
                    onlineHandleFragment = new OnlineHandleFragment();

                    listFragment.add(onlineHandleFragment);

                    tran.add(R.id.main_container, onlineHandleFragment, "OnlineHandleFragment");
                } else {
                    tran.show(onlineHandleFragment);
                }
                LogUtil.d("maiactivity", checkedId);
                break;
            case R.id.rbt_tab_mine:

                if (mineFragment == null) {
                    mineFragment = new MineFragment();

                    listFragment.add(mineFragment);

                    tran.add(R.id.main_container, mineFragment, "MineFragment");

                } else {
                    tran.show(mineFragment);
                }
                LogUtil.d("maiactivity", checkedId);
                break;
            default:
                break;
        }
        //fragment.setUserVisibleHint(true);

        tran.commit();

    }

    // 返回键 监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        //			if (keyCode==KeyEvent.KEYCODE_BACK) {
        //
        //				 AlertDialogUtils.createAlerDialog(this, "系统提示","是否退出程序").create().show();
        //			}
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(customApplication, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {

                AppManager.getAppManager().finishAllActivity();
                //  AppManager.getAppManager().AppExit(CustomApplication.customApplication);
            }
            return true;
        }
        return true;
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    protected void onStop() {

        super.onStop();
        LogUtil.d("MainActivity", "onStop");
        EMClient.getInstance().chatManager().removeMessageListener(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d("MainActivity", "onpause");

    }
    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d("MainActivity", "onResume");
        EMClient.getInstance().groupManager().loadAllGroups();
        EMClient.getInstance().chatManager().loadAllConversations();
        //监听消息
        EMClient.getInstance().chatManager().addMessageListener(this);
        if (
                EMClient.getInstance().chatManager().getUnreadMsgsCount() > 0) {

            LogUtil.d("MainActivity", "有消息来");
            msgcount.setVisibility(View.VISIBLE);
            msgcount.setBadgeCount(EMClient.getInstance().chatManager().getUnreadMsgsCount());
        } else {
            if (msgcount != null)
                msgcount.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onMessageReceived(List<EMMessage> list) {
        if (
                EMClient.getInstance().chatManager().getUnreadMsgsCount() > 0) {


            LogUtil.d("MainActivity", "有消息来");
            msgcount.setVisibility(View.VISIBLE);
            msgcount.setBadgeCount(EMClient.getInstance().chatManager().getUnreadMsgsCount());
        } else {
            if (msgcount != null)
            msgcount.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onCmdMessageReceived(List<EMMessage> list) {

    }

    @Override
    public void onMessageReadAckReceived(List<EMMessage> list) {

    }


    @Override
    public void onMessageDeliveryAckReceived(List<EMMessage> list) {

    }

    @Override
    public void onMessageChanged(EMMessage emMessage, Object o) {

    }

}
