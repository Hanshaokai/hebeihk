package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlenotifi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.common.widget.widgetofbindtagview.TagAdapter;
import cn.huischool.huixiao.bean.ReceivedNoticeDetailBean;
import cn.huischool.huixiao.common.utils.FrameworkUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.fragment.PreviewFragment;
import cn.huischool.huixiao.common.widget.widgetofbindtagview.TagFlowLayout;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;

/**
 * Created by ${han} on 2016/6/3.
 */
public class OnLineAcceNotifiDetailFragment extends BaseFragment {

    private AppCompatActivity mActivity;
    private ReceivedNoticeDetailBean.ResultsBean elements;
    private View view;
    private Toolbar toolbar_acceNootifiDeatail;
    private TextView tv_acceNootifiDeatail_attach;
    private TextView tv__AcceNootifiDeatail_sendername;
    private TextView tv__acceNootifiDeatail_receitime;
    private TextView tv_acceNootifiDeatail_content;
    private TextView tv_acceNootifiDeatail_title;
    private String id;
    private NestedScrollView nestscroll_received_notices;
    private TagFlowLayout tag_accenotifi_deatail_personofphone;
    private String[] personListOfHasNoteRead = null;
    private String[] phoneListOfHasNoteRead = null;

    @Override
    public View initView(LayoutInflater inflater) {

        mActivity = (AppCompatActivity) baseFragmentActivity;
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getString("id");

        }
        view = inflater.inflate(R.layout.fragment_online_acce_notifi_detail, null, false);
        toolbar_acceNootifiDeatail = (Toolbar) view.findViewById(R.id.toolbar_AcceNootifiDeatail);
        tv_acceNootifiDeatail_attach = (TextView) view.findViewById(R.id
                .tv_AcceNootifiDeatail_attach);
        tv__AcceNootifiDeatail_sendername = (TextView) view.findViewById(R.id
                .tv__AcceNootifiDeatail_sendername);
        tv__acceNootifiDeatail_receitime = (TextView) view.findViewById(R.id.tv__AcceNootifiDeatail_receitime);
        tv_acceNootifiDeatail_content = (TextView) view.findViewById(R.id.tv_AcceNootifiDeatail_Content);
        tv_acceNootifiDeatail_title = (TextView) view.findViewById(R.id.tv_AcceNootifiDeatail_title);
        nestscroll_received_notices = (NestedScrollView) view.findViewById(R.id.nestscroll_received_notices);
        nestscroll_received_notices.setVisibility(View.GONE);

        tag_accenotifi_deatail_personofphone = (TagFlowLayout) view.findViewById(R.id.tag_accenotifi_deatail_personofphone);

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_acceNootifiDeatail,true,"通知详情",-1,true);
        tv_acceNootifiDeatail_attach.setOnClickListener(this);
        if (elements == null) {
            LoadDeatailData();
        } else {
            showDetailData();
        }

    }

    private void LoadDeatailData() {

        showProgressDialog("正在加载...");
        DataAchieve.ReceivedNoticeDetail(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {

                if (code != 1000) {
                    dismissProgressDialog();
                    return;
                }

                elements =( (ReceivedNoticeDetailBean) object).getResults();


                showDetailData();
                dismissProgressDialog();

            }
        }, id);


    }

    public static BaseFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putSerializable("id", id);
        OnLineAcceNotifiDetailFragment fragment = new OnLineAcceNotifiDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void showDetailData() {
        if (elements.getNoticeFileName() != null && !TextUtils.isEmpty(elements.getNoticeFileName
                ())
                ) {
            tv_acceNootifiDeatail_attach.setText(elements.getNoticeFileName());
        } else {
            tv_acceNootifiDeatail_attach.setText("无附件");
            tv_acceNootifiDeatail_attach.setTextColor(Color.GRAY);
            tv_acceNootifiDeatail_attach.setClickable(false);
        }

        tv_acceNootifiDeatail_content.setText(elements.getContent());
        tv_acceNootifiDeatail_title.setText(elements.getTitle());
        tv__AcceNootifiDeatail_sendername.setText(elements.getSenderName());
        tv__acceNootifiDeatail_receitime.setText(elements.getCreateTime());
        int count = elements.getWeiduList().size();
        personListOfHasNoteRead = new String[count];
        phoneListOfHasNoteRead = new String[count];
        for (int i = 0; i < count; i++) {
            personListOfHasNoteRead[i] = elements.getWeiduList().get(i).getRealName();
            phoneListOfHasNoteRead[i] = elements.getWeiduList().get(i).getPhone();
        }


        setAdapter();

        nestscroll_received_notices.setVisibility(View.VISIBLE);
    }

    private void setAdapter() {
        tag_accenotifi_deatail_personofphone.setAdapter(new TagAdapter(personListOfHasNoteRead) {
            @Override
            public View getView(ViewGroup parent, int position, Object o) {

                int point = 0;
                TextView tv = (TextView)
                        mActivity.getLayoutInflater().inflate
                                (R.layout.tag_item_tv,
                                        parent, false);
                LogUtil.d((String) o);
                tv.setText((String) o);
                tv.setTextColor(Color.GRAY);

                return tv;
            }


            @Override
            public void onUnSelect(ViewGroup parent, View view, int position) {
                super.onUnSelect(parent, view, position);
                view.setBackgroundColor(Color.GRAY);
            }

            @Override
            public void onSelect(ViewGroup parent, View view, int position) {
                super.onSelect(parent, view, position);
                view.setBackgroundColor(Color.GREEN);

                FrameworkUtils.callPersonToPhonePage(mActivity, phoneListOfHasNoteRead[position]);
            }
        });


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

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {

            case R.id.tv_AcceNootifiDeatail_attach:

                addFragment(new PreviewFragment().newInstance( "http://139.196.234" +
                        ".4:8080/dcsUserCenter/checkUrl.do?k=39661455&url="+elements.getHtmlFileUrl()));

                break;
        }

    }
}
