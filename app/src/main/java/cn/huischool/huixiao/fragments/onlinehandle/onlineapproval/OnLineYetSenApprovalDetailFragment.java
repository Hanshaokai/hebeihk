package cn.huischool.huixiao.fragments.onlinehandle.onlineapproval;


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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.ApprovalDetailBean;
import cn.huischool.huixiao.common.fragment.PreviewFragment;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;

/**
 * Created by ${han} on 2016/6/15.
 */
public class OnLineYetSenApprovalDetailFragment extends BaseFragment {


    private TextView tv_sendapproval_Deatail_Content;
    private TextView tv_sendapproval_Deatail_sendtime;
    private TextView tv_sendapproval_Deatail_attach;
    private ApprovalDetailBean.ResultsBean elements;
    private AppCompatActivity mActivity;
    private Toolbar toolbar_clude;
    private TextView tv_title_clude;
    private TextView tv_sendapproval_deatail_approvalType;
    private TextView tv_sendapproval_deatail_sender;
    String[] approvalType;
    private LinearLayout ll_sendapproval_deatail_commentContainer;
    private TextView tv_sendapproval_deatail_informer;
    private String id;
    private NestedScrollView nestscroll_yetSendApproval_deatail;

    @Override
    public View initView(LayoutInflater inflater) {
        mActivity = (AppCompatActivity) baseFragmentActivity;
        approvalType = mActivity.getResources().getStringArray(R.array.approvalType);
        //详情与列表共用一个接口 采取的是fragment之间传值
        Bundle bundle = getArguments();
        if (bundle != null) {

            id = bundle.getString("id");


        }
        View view = inflater.inflate(R.layout.fragment_online_yetsend_approvaldetail, null, false);
        tv_sendapproval_Deatail_Content = (TextView) view.findViewById(R.id.tv_sendapproval_Deatail_Content);
        tv_sendapproval_Deatail_attach = (TextView) view.findViewById(R.id.tv_sendapproval_Deatail_attach);
        tv_sendapproval_Deatail_sendtime = (TextView) view.findViewById(R.id
                .tv_sendapproval_Deatail_sendtime);//审批申请的创建提交时间
        tv_sendapproval_deatail_approvalType = (TextView) view.findViewById(R.id
                .tv_sendapproval_Deatail_approvalType);
        tv_sendapproval_deatail_sender = (TextView) view.findViewById(R.id.tv_sendapproval_Deatail_sender);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        tv_sendapproval_deatail_informer = (TextView) view.findViewById(R.id.tv_sendapproval_Deatail_informer);
        ll_sendapproval_deatail_commentContainer = (LinearLayout) view.findViewById(R.id
                .ll_sendapproval_Deatail_commentContainer);
        nestscroll_yetSendApproval_deatail =
                (NestedScrollView) view.findViewById(R.id
                        .nestscroll_yetSendApproval_Deatail);
        nestscroll_yetSendApproval_deatail.setVisibility(View.GONE);
        return view;
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_clude, true, "审批详情", -1, true);
        if (elements == null) {
            loadeApprovalDetailData();
        }

    }

    public static BaseFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putString("id", id);
        OnLineYetSenApprovalDetailFragment fragment = new OnLineYetSenApprovalDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void loadeApprovalDetailData() {

        showProgressDialog("正在加载...");
        DataAchieve.getApprovalDetail(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {

                if (code != 1000) {
                    dismissProgressDialog();
                    return;
                }
                if (object != null) {

                    elements = ((ApprovalDetailBean) object).getResults();
                    showDetailData();
                    dismissProgressDialog();
                }

            }
        }, "", id);//已发送审批 不需传userId


    }

    private void showDetailData() {
        tv_sendapproval_deatail_approvalType.setText(approvalType[Integer.parseInt(elements
                .getApprovalType
                        ())]);
        tv_sendapproval_deatail_sender.setText(elements.getCreater());
        if (elements.getApprovalFileName() != null && !TextUtils.isEmpty(elements
                .getApprovalFileName())) {
            tv_sendapproval_Deatail_attach.setText(elements.getApprovalFileName());
            tv_sendapproval_Deatail_attach.setTextColor(Color.BLUE);
            tv_sendapproval_Deatail_attach.setOnClickListener(this);
        } else {
            tv_sendapproval_Deatail_attach.setText("无附件");
            tv_sendapproval_Deatail_attach.setTextColor(Color.GRAY);
        }
        tv_sendapproval_Deatail_Content.setText(elements.getContent());

        tv_sendapproval_Deatail_sendtime.setText(elements.getCreateTime());
        tv_sendapproval_deatail_informer.setText(elements.getRecipientNames().equals("")
                ? "无" : elements.getRecipientNames());
        showCommentDetail();
    }

    private void showCommentDetail() {
        ll_sendapproval_deatail_commentContainer.removeAllViews();
        for (ApprovalDetailBean.ResultsBean.ApprovalInfoBean item : elements.getApprovalInfo()) {//知会
            // 列表ｊａｖａｂｅａｎ跟审批列表相同
            View commentView = mActivity.getLayoutInflater().inflate(R.layout
                            .item_inform_approval_comment_detail, null,
                    false);
            ImageView iv_informapproval_Detail_approversHeadPic = (ImageView) commentView.findViewById(R.id
                    .iv_informapproval_Detail_approversHeadPic);
            TextView tv_informapproval_Detail_approversNames = (TextView) commentView.findViewById(R.id
                    .tv_informapproval_Detail_approversNames);
            TextView tv_informapproval_Detail_status = (TextView) commentView.findViewById(R.id
                    .tv_informapproval_Detail_status);
            TextView tv_informapproval_Deatail_approverTime = (TextView) commentView.findViewById(R.id
                    .tv_informapproval_Deatail_approverTime);
            TextView tv_informapproval_Deatail_commentwords = (TextView) commentView.findViewById(R.id
                    .tv_informapproval_Deatail_commentwords);
            if (item != null) {
                tv_informapproval_Detail_approversNames.setText(item.getApproverName());
                if (item.getOpinion() == null) {
                    tv_informapproval_Detail_status.setText("待审批");
                } else if (item.getOpinion().equals("1")) {
                    tv_informapproval_Detail_status.setText("同意");
                } else if (item.getOpinion().equals("0")) {
                    tv_informapproval_Detail_status.setText("不同意");
                }
            }
            if (item.getApprover_imgurl() != null) {
                LoadBitmapUtils.LoadImagview(mActivity, item.getApprover_imgurl(),
                        iv_informapproval_Detail_approversHeadPic);
            }
            tv_informapproval_Deatail_approverTime.setText(item.getApprovalTime());
            tv_informapproval_Deatail_commentwords.setText(item.getComment() == null ? "无" : item
                    .getComment());
            ll_sendapproval_deatail_commentContainer.addView(commentView);
        }

        nestscroll_yetSendApproval_deatail.setVisibility(View.VISIBLE);
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
            case R.id.tv_sendapproval_Deatail_attach:
                addFragment(new PreviewFragment().newInstance(elements.getHtmlFileUrl()));
        }

    }
}
