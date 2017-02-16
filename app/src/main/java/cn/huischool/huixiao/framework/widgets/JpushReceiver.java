package cn.huischool.huixiao.framework.widgets;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import cn.huischool.huixiao.activitys.onlinehandle.OnlineDetailFromIdActivity;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.manager.AppManager;
import cn.huischool.huixiao.framework.util.AppUtils;
import cn.jpush.android.api.JPushInterface;

/**
 * 自定义接收器
 * <p/>
 * 如果不定义这个 Receiver，则：
 * 1) 默认用户会打开主界面
 * 2) 接收不到自定义消息
 */
public class JpushReceiver extends BroadcastReceiver {
    private static final String TAG = "JPush";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
       /* Log.d(TAG, "收到的推送内容" + intent.getAction() + ", extras: " +bundle.getString(JPushInterface
                .EXTRA_EXTRA).toString());*/

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
            Log.d(TAG, "[MyReceiver] 接收Registration Id : " + regId);
            //send the Registration Id to your server...

        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            Log.d(TAG, "[MyReceiver] 接收到推送下来的自定义消息: " + bundle.getString(JPushInterface.EXTRA_MESSAGE));
            processCustomMessage(context, bundle);

        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            Log.d(TAG, "[MyReceiver] 接收到推送下来的通知");
            int notifactionId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
            Log.d(TAG, "[MyReceiver] 接收到推送下来的通知的ID: " + notifactionId);


        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            Log.d(TAG, "[MyReceiver] 用户点击打开了通知");
            JPushInterface.reportNotificationOpened(context, bundle.getString(JPushInterface
                    .EXTRA_MSG_ID));//上报点击了通知

            //打开自定义的Activity

            try {
                if (AppManager.activityStack.size() != 0) {
                    Log.d(TAG, "onReceive: size不为零");
                    //软件打开的状态
                    String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
                    com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject
                            (extras);
                    switch (jsonObject.getString("msg_type")) {
                        //通知0 公告1审批2extras.put("msg_id", notice.getId());
                        //extras.put("msg_type", "0");

                        case "0":
                           /* Intent notifi = new Intent(context, NotifiActivity.class);
                            //i.putExtras(bundle);
                            //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            notifi.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(notifi);*/

                            Intent notifi = new Intent(context, OnlineDetailFromIdActivity.class);
                            notifi.putExtra("noticeId", jsonObject.get("msg_id").toString());
                            notifi.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(notifi);
                            break;

                        case "1":
                            /*Intent affiche = new Intent(context, AfficheActivity.class);
                            //i.putExtras(bundle);
                            //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            affiche.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            context.startActivity(affiche);*/

                            Intent affiche = new Intent(context, OnlineDetailFromIdActivity.class);
                            affiche.putExtra("afficheId", jsonObject.get("msg_id").toString());
                            affiche.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(affiche);
                            break;

                        case "2":
                          /*  Intent approval = new Intent(context, ApprovalActivity.class);
                            //i.putExtras(bundle);
                            //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            // approval.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            approval.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            context.startActivity(approval);*/

                            Intent approval = new Intent(context, OnlineDetailFromIdActivity.class);
                            approval.putExtra("approvalId", jsonObject.get("msg_id").toString());
                            approval.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(approval);
                            break;
                        case "3":
                            Intent approval_inform = new Intent(context, OnlineDetailFromIdActivity
                                    .class);
                            //i.putExtras(bundle);
                            //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            // approval.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            approval_inform.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            approval_inform.putExtra("informApprovalId", jsonObject.get("msg_id")
                                    .toString());
                            context.startActivity(approval_inform);
                            break;
                        case "4":
                            Intent approval_yetsend = new Intent(context, OnlineDetailFromIdActivity.class);
                            //i.putExtras(bundle);
                            //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            // approval.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            approval_yetsend.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            approval_yetsend.putExtra("yetSendApprovalId", jsonObject.get("msg_id")
                                    .toString());
                            context.startActivity(approval_yetsend);
                            break;
                        case "5":
                            Intent grmmarYetApproval = new Intent(context,
                                    OnlineDetailFromIdActivity.class);
                            //i.putExtras(bundle);
                            //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            // approval.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            grmmarYetApproval.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            grmmarYetApproval.putExtra("grmmarYetApprovalId", jsonObject.get("msg_id")
                                    .toString());
                            context.startActivity(grmmarYetApproval);
                            break;

                        case "6":
                            Intent courseWareYetApproval = new Intent(context,
                                    OnlineDetailFromIdActivity.class);
                            courseWareYetApproval.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            courseWareYetApproval.putExtra("courseWareYetApprovalId", jsonObject.get("msg_id")
                                    .toString());
                            context.startActivity(courseWareYetApproval);
                            break;
                    }


                } else {

                    if (AppUtils.appIsRunning(context, "cn.huischool.huixiao")) {//接到推送判断应用是否在运行
                        // 没运行则启动app

                        Log.d(TAG, "onReceive:size==0");
                        //当双击退出 application类 还存在
                        Intent intentapp = new Intent(Intent.ACTION_MAIN);
                        intentapp.addCategory(Intent.CATEGORY_LAUNCHER);


                        ComponentName cn = new ComponentName("cn.huischool.huixiao", "cn.huischool.huixiao.LoginActivity");
                        intentapp.setComponent(cn);

                        intentapp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intentapp.putExtra("extras", bundle.getString(JPushInterface.EXTRA_EXTRA));
                        LogUtil.d("推送获得" + bundle.getString(JPushInterface.EXTRA_EXTRA));
                        context.startActivity(intentapp);

                    }


                }
            } catch (NullPointerException e) {
                Log.d(TAG, "onReceive:异常 只有一个服务");
                //当手机手势划掉残存栈信息 运行此处
                Intent intentapp = new Intent(Intent.ACTION_MAIN);
                intentapp.addCategory(Intent.CATEGORY_LAUNCHER);


                ComponentName cn = new ComponentName("cn.huischool.huixiao", "cn.huischool.huixiao.LoginActivity");
                intentapp.setComponent(cn);

                intentapp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentapp.putExtra("extras", bundle.getString(JPushInterface.EXTRA_EXTRA));
                LogUtil.d("推送获得" + bundle.getString(JPushInterface.EXTRA_EXTRA));
                context.startActivity(intentapp);

            }

        } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
            Log.d(TAG, "[MyReceiver] 用户收到到RICH PUSH CALLBACK: " + bundle.getString(JPushInterface.EXTRA_EXTRA));
            //在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity， 打开一个网页等..

        } else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
            boolean connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
            Log.w(TAG, "[MyReceiver]" + intent.getAction() + "极光推送连接状态变为 " + connected);
        } else {
            Log.d(TAG, "[MyReceiver] Unhandled intent - " + intent.getAction());
        }
    }

    // 打印所有的 intent extra 数据
    private static String printBundle(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        for (String key : bundle.keySet()) {
            if (key.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getInt(key));
            } else if (key.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getBoolean(key));
            } else if (key.equals(JPushInterface.EXTRA_EXTRA)) {
                if (bundle.getString(JPushInterface.EXTRA_EXTRA).isEmpty()) {
                    Log.i(TAG, "This message has no Extra data");
                    continue;
                }

                try {
                    JSONObject json = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                    Iterator<String> it = json.keys();

                    while (it.hasNext()) {
                        String myKey = it.next().toString();
                        sb.append("\nkey:" + key + ", value: [" +
                                myKey + " - " + json.optString(myKey) + "]");
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "Get message extra JSON error!");
                }

            } else {
                sb.append("\nkey:" + key + ", value:" + bundle.getString(key));
            }
        }
        return sb.toString();
    }

    //send msg to MainActivity
    private void processCustomMessage(Context context, Bundle bundle) {

        // String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
        String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
        Intent msgIntent = new Intent("MESSAGE_RECEIVED_ACTION");

        if (!TextUtils.isEmpty(extras)) {
            try {
                JSONObject extraJson = new JSONObject(extras);
                if (null != extraJson && extraJson.length() > 0) {
                    msgIntent.putExtra("extras", extras);
                }
            } catch (JSONException e) {

            }

        }
        context.sendBroadcast(msgIntent);

    }
}
