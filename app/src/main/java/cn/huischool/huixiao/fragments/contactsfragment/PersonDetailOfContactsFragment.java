package cn.huischool.huixiao.fragments.contactsfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rey.material.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.contacts.ChatActivity;
import cn.huischool.huixiao.common.utils.FrameworkUtils;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseFragment;


/**
 * Created by ${han} on 2016/10/19.
 */

public class PersonDetailOfContactsFragment extends BaseFragment {
    @BindView(R.id.tv_title_clude)
    TextView tvTitleClude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtnActionClude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbarClude;
    @BindView(R.id.appbar_clude)
    AppBarLayout appbarClude;
    @BindView(R.id.iv_headimg_person_detail_contacts)
    ImageView ivHeadimgPersonDetailContacts;
    @BindView(R.id.tv_realname_person_detail_contacts)
    TextView tvRealnamePersonDetailContacts;
    @BindView(R.id.tv_tel_person_detail_contacts)
    TextView tvTelPersonDetailContacts;
    @BindView(R.id.tv_duty_txt)
    TextView tvDutyTxt;
    @BindView(R.id.tv_duty_person_detail_contacts)
    TextView tvDutyPersonDetailContacts;
    @BindView(R.id.tv_line1)
    TextView tvLine1;
    @BindView(R.id.tv_email_person_detail_contacts)
    TextView tvEmailPersonDetailContacts;
    @BindView(R.id.tv_email_txt)
    TextView tvEmailTxt;
    @BindView(R.id.btn_totel_person_detail_contacts)
    Button btnTotelPersonDetailContacts;
    @BindView(R.id.btn_short_message_person_detail_contacts)
    Button btnShortMessagePersonDetailContacts;
    @BindView(R.id.btn_send_message_person_detail_contacts)
    Button btnSendMessagePersonDetailContacts;
    private AppCompatActivity myActivity;
    private Unbinder unbinder;
    private String id;
    private String phone;
    private String duty;
    private String email;
    private String realName;
    private String imgUrl;
    private Bundle bundle;

    @Override
    public View initView(LayoutInflater inflater) {
        bundle = getArguments();
        id = bundle.getString("id");
        phone = bundle.getString("phone");
        duty = bundle.getString("duty");
        email = bundle.getString("email");
        realName = bundle.getString("realName");
        imgUrl = bundle.getString("imgUrl");
        myActivity = baseFragmentActivity;
        view = inflater.inflate(R.layout.person_detail_fragment, null, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    /*   private Object imgUrl;
                        private String id;
                        private String phone;
                        private String duty;
                        private String email;
                        private String realName;*/
    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        initToolBar(toolbarClude, true, "联系人资料",-1,true);
        if (bundle != null)
            showData();

    }

    private void showData() {
        btnSendMessagePersonDetailContacts.setOnClickListener(this);
        btnShortMessagePersonDetailContacts.setOnClickListener(this);
        btnTotelPersonDetailContacts.setOnClickListener(this);
        tvDutyPersonDetailContacts.setText(duty);
        tvEmailPersonDetailContacts.setText(email);
        tvRealnamePersonDetailContacts.setText(realName);
        tvTelPersonDetailContacts.setText(phone);
        LoadBitmapUtils.LoadHeadImagview(myActivity, imgUrl, ivHeadimgPersonDetailContacts);
    }

    public static PersonDetailOfContactsFragment newInstance(Bundle u) {


        PersonDetailOfContactsFragment fragment = new PersonDetailOfContactsFragment();
        fragment.setArguments(u);
        return fragment;
    }

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_short_message_person_detail_contacts:
                FrameworkUtils.sendSms(myActivity, phone, "");

                break;
            case R.id.btn_send_message_person_detail_contacts:
                Intent intent = new Intent(myActivity, ChatActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("userId", id);
                bundle.putString("realName", realName);
                bundle.putString("imgUrl", imgUrl);
                intent.putExtras(bundle);

                Log.d("tag", "环信对话方id" + id);
                startActivity(intent);
                break;
            case R.id.btn_totel_person_detail_contacts:
                FrameworkUtils.callPersonToPhonePage(myActivity, phone);
                break;

        }
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
