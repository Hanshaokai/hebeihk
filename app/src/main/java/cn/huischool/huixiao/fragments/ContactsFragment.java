package cn.huischool.huixiao.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.rey.material.widget.ImageButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.contacts.ConversationListActivity;
import cn.huischool.huixiao.activitys.home.MainActivity;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.widget.widgetofbindbadgeview.BadgeView;
import cn.huischool.huixiao.fragments.contactsfragment.ContactsDivideByLeaderFragment;
import cn.huischool.huixiao.fragments.contactsfragment.ContactsDividedBySubjectFragment;
import cn.huischool.huixiao.fragments.contactsfragment.ContactsDividedBygradeFragment;
import cn.huischool.huixiao.framework.BaseFragment;

public class ContactsFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, MainActivity.MesgCallBack {


    @BindView(R.id.tv_title_clude)
    TextView tvTitleClude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtnActionClude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbarClude;
    @BindView(R.id.appbar_clude)
    AppBarLayout appbarClude;
    @BindView(R.id.rbt_contacts_divide_bygrade)
    RadioButton rbtContactsDivideBygrade;
    @BindView(R.id.rbt_contacts_divide_bysubject)
    RadioButton rbtContactsDivideBysubject;
    @BindView(R.id.fr_contacts_fragcontainer)
    FrameLayout flContactsFragcontainer;
    @BindView(R.id.rgp_contacts_divide_container)
    RadioGroup rgpContactsDivideContainer;
    private Unbinder unbinder;
    private AppCompatActivity myActivity;
    private FragmentManager fragmentManager;
    private FragmentTransaction transition;
    private BadgeView msgcoun;
    private Fragment fragment_grade;
    private Fragment fragment_subject;
    private Fragment fragment_leader;


    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        fragmentManager = this.getChildFragmentManager();
        view = inflater.inflate(R.layout.fragment_contacts, null, false);
        unbinder = ButterKnife.bind(this, view);
        imagbtnActionClude.setImageResource(R.drawable.em_conversation_list);
        imagbtnActionClude.setOnClickListener(this);
        imagbtnActionClude.setVisibility(View.VISIBLE);
        ((MainActivity) (myActivity)).setMesgCallBack(this);
        if (msgcoun == null) {
            msgcoun = new BadgeView(myActivity);

            msgcoun.setTargetView(imagbtnActionClude);
            msgcoun.setBadgeMargin(35, -1, 20, -1);
        }
        return view;
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        initToolBar(toolbarClude, false, "我的联系人",-1,true);
        rgpContactsDivideContainer.setOnCheckedChangeListener(this);
        rbtContactsDivideBygrade.setChecked(true);

    }


    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.imagbtn_action_clude:

                startActivity(new Intent(myActivity, ConversationListActivity.class));

        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((MainActivity) (myActivity)).setMesgCallBack(this);
        unbinder.unbind();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        LogUtil.d("加载分组");
        transition = fragmentManager.beginTransaction();
        switch (i) {
            case R.id.rbt_contacts_divide_bygrade:
                if (fragment_grade == null)
                    fragment_grade = ContactsDividedBygradeFragment.newInstance();
                transition.replace(R.id.fr_contacts_fragcontainer,
                        fragment_grade);
                break;
            case R.id.rbt_contacts_divide_bysubject:
                if (fragment_subject == null)
                    fragment_subject = ContactsDividedBySubjectFragment.newInstance();
                transition.replace(R.id.fr_contacts_fragcontainer,
                        fragment_subject);
                break;
            case R.id.rbt_contacts_divide_byleader:
                if (fragment_leader == null)
                    fragment_leader = ContactsDivideByLeaderFragment.newInstance();
                transition.replace(R.id.fr_contacts_fragcontainer, fragment_leader);
                break;
        }
        transition.commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (EMClient.getInstance().chatManager().getUnreadMsgsCount() > 0) {
            if (msgcoun == null) {
                msgcoun = new BadgeView(myActivity);

                msgcoun.setTargetView(imagbtnActionClude);
                msgcoun.setBadgeMargin(35, -1, 20, -1);
            }
            msgcoun.setVisibility(View.VISIBLE);
            msgcoun.setBadgeCount(EMClient.getInstance().chatManager().getUnreadMsgsCount());
        } else {
            if (msgcoun != null)
                msgcoun.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public void receptMsgCount(int num) {

        if (EMClient.getInstance().chatManager().getUnreadMsgsCount() > 0) {

            LogUtil.d("contactsFragment", "有消息来");
            msgcoun.setVisibility(View.VISIBLE);
            msgcoun.setBadgeCount(num);
        } else {
            if (msgcoun != null)
                msgcoun.setVisibility(View.INVISIBLE);
        }
    }

}
