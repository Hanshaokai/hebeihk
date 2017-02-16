package cn.huischool.huixiao.fragments.contactsfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.contacts.ContactsPersonDetailActivity;
import cn.huischool.huixiao.bean.SchoolContactsListBean;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview.AbstractAdapterItem;
import cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview.BaseExpandableAdapter;
import cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview.bean_item.LeaderListItem;
import cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview.bean_item.TeacherByLeaderItem;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.DividerItemDecoration;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/10/14.
 */

public class ContactsDivideByLeaderFragment extends BaseFragment {
    private RecyclerView recycler_contacts_divided;
    private AppCompatActivity myActivity;
    private BaseExpandableAdapter baseExpandableAdapter;
    private SchoolContactsListBean.ResultsBean resultsBean;
    private ArrayList list;

    public static ContactsDivideByLeaderFragment newInstance() {
        ContactsDivideByLeaderFragment fragment = new ContactsDivideByLeaderFragment();
        return fragment;
    }

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        view = inflater.inflate(R.layout.childfragment_contacts_divided, null, false);
        recycler_contacts_divided = (RecyclerView) view.findViewById(R.id
                .recycler_contacts_divided);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if (CustomApplication.contacts != null) {
            showProgressDialog("加载联系人");
            resultsBean = JSON.parseObject(CustomApplication.contacts, SchoolContactsListBean
                    .ResultsBean.class);
            list = (ArrayList) resultsBean.getLeaderList();
            showCotatcsData();
            dismissProgressDialog();
            return;
        }
        loadContactsData();
    }

    private void loadContactsData() {
        showProgressDialog("加载联系人");
        DataAchieve.getSchoolContactsList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                if (code != 1000) {
                    dismissProgressDialog();
                    return;

                }
                resultsBean = ((SchoolContactsListBean) object).getResults();
                list = (ArrayList) resultsBean.getLeaderList();
                showCotatcsData();
                dismissProgressDialog();
            }
        }, CustomApplication.userInfor.getSchoolId());

    }

    private void showCotatcsData() {
        if (resultsBean == null)
            return;
        baseExpandableAdapter = new BaseExpandableAdapter(list) {
            @NonNull
            @Override
            public AbstractAdapterItem<Object> getItemView(Object type) {
                int itemType = (int) type;
                switch (itemType) {
                    case 1:
                        return new LeaderListItem();
                    case 2:
                        return new TeacherByLeaderItem();

                }

                return null;
            }

            @Override
            public Object getItemViewType(Object t) {

                if (t instanceof SchoolContactsListBean.ResultsBean.LeaderListBean) {
                    return 1;
                } else if (t instanceof SchoolContactsListBean.ResultsBean.LeaderListBean.TeacherListBean) {
                    return 2;
                }
                return -1;
            }
        };
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recycler_contacts_divided.setLayoutManager(linearLayoutManager);
       /* recycler_contacts_divided.setLayoutManager(new GridLayoutManager(getActivity(),2));*/
        recycler_contacts_divided.addItemDecoration(new DividerItemDecoration(myActivity, linearLayoutManager
                .getOrientation()));
        recycler_contacts_divided.setAdapter(baseExpandableAdapter);
        baseExpandableAdapter.setExpandCollapseListener(new BaseExpandableAdapter.ExpandCollapseListener() {
            @Override
            public void onListItemExpanded(int position) {
                if (list.get(position) instanceof SchoolContactsListBean
                        .ResultsBean.LeaderListBean.TeacherListBean) {

                    LogUtil.d(((SchoolContactsListBean
                            .ResultsBean.LeaderListBean.TeacherListBean)
                            (list.get(position))).getRealName() + "点击的教师名字");


                       /*   private Object imgUrl;
                        private String id;
                        private String phone;
                        private String duty;
                        private String email;
                        private String realName;*/
                    SchoolContactsListBean
                            .ResultsBean.LeaderListBean.TeacherListBean
                            bean = ((SchoolContactsListBean
                            .ResultsBean.LeaderListBean.TeacherListBean)
                            (list.get(position)));
                    Bundle bundle = new Bundle();
                    bundle.putString("imgUrl", (String) bean.getImgUrl());
                    bundle.putString("id", bean.getId());
                    Log.d("tag", "对话方id"+bean.getId());
                    bundle.putString("phone", bean.getPhone());
                    bundle.putString("duty", bean.getDuty());
                    bundle.putString("email", bean.getEmail());
                    bundle.putString("realName", bean.getRealName());
                    Intent intent = new Intent(myActivity, ContactsPersonDetailActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);


                }
                LogUtil.d("点击了" + position);
            }

            @Override
            public void onListItemCollapsed(int position) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    protected void onClickEvent(View view) {

    }
}
