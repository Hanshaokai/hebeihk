package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlaffiche;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rey.material.widget.ImageButton;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.AfficheActivity;
import cn.huischool.huixiao.bean.ToSendCompleteBean;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/6/6.
 */
public class TosendAfficheFragment extends BaseFragment {
    private ImageButton imagbtn_action_clude;
    private Toolbar toolbar_clude;
    private EditText tv_tosend_affiche_content;

    private EditText tv_tosend_affiche_title;
    private TextView tv_title_clude;
    private AppCompatActivity myActivity;
    private String title;
    private String content;

    @Override
    public View initView(LayoutInflater inflater) {

        View view = inflater.inflate(R.layout.fragment_tosend_affiche, null, false);
        imagbtn_action_clude = (ImageButton) view.findViewById(R.id.imagbtn_action_clude);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        tv_tosend_affiche_content = (EditText) view.findViewById(R.id.tv_tosend_affiche_content);
        tv_tosend_affiche_title = (EditText) view.findViewById(R.id.tv_tosend_affiche_title);
        myActivity =  baseFragmentActivity;
        return view;

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_clude,true,"新建公告",R.mipmap.ic_done_white_24dp,true);
        setListener();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.notifi_actions, menu);
        super.onCreateOptionsMenu(menu, inflater);
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

    private void setListener() {

        imagbtn_action_clude.setOnClickListener(this);
    }

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {

            case R.id.imagbtn_action_clude:
                toSendNotifi();

                break;
        }
    }

    private void toSendNotifi() {
        title = tv_tosend_affiche_title.getText().toString();
        content = tv_tosend_affiche_content.getText().toString();
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(content)) {

            Toast.makeText(myActivity, "请填写完整", Toast.LENGTH_SHORT).show();
            return;
        }
        showProgressDialog("正在发布...");
        DataAchieve.ToSendAffiche(new DataAchieve.SuccessCallBack() {
                                      @Override
                                      public void handle(int code, Object object) {
                                          {
                                              if (code != 1000) {


                                                  Toast.makeText(myActivity, "发布成功", Toast.LENGTH_SHORT).show();

                                                  return;
                                              } else {

                                                  dismissProgressDialog();
                                              }
                                          }
                                      }
                                  }, title, content, CustomApplication.userInfor.getSchoolId(),
                CustomApplication.userInfor.getUserId(), "是");

    }
}
