package cn.huischool.huixiao.fragments.onlinehandle.onlineapproval;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rey.material.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.ApprovalActivity;
import cn.huischool.huixiao.bean.ApprovalDetailBean;
import cn.huischool.huixiao.bean.ReceivApprovalBean;
import cn.huischool.huixiao.common.fragment.PreviewFragment;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/8/23.
 */
public class OnLineInformApprovalDetailFragment extends BaseFragment {
    @BindView(R.id.tv_title_clude)
    TextView tvTitleClude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtnActionClude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbarClude;
    @BindView(R.id.appbar_clude)
    AppBarLayout appbarClude;
    @BindView(R.id.tv_informapproval_Deatail_sender)
    TextView tvInformapprovalDeatailSender;
    @BindView(R.id.tv_informapproval_Deatail_approvalType)
    TextView tvInformapprovalDeatailApprovalType;
    @BindView(R.id.tv_informapproval_Deatail_sendtime)
    TextView tvInformapprovalDeatailSendtime;
    @BindView(R.id.tv_informapproval_Deatail_Content)
    TextView tvInformapprovalDeatailContent;
    @BindView(R.id.tv_informapproval_Deatail_attach)
    TextView tvInformapprovalDeatailAttach;
    @BindView(R.id.tv_informapproval_Detail_who_inform)
    TextView tvInformapprovalDetailWhoInform;
    @BindView(R.id.ll_informapproval_detail_commentainer)
    LinearLayout llInformapprovalDetailCommentainer;
    private AppCompatActivity mActivity;
    private ApprovalDetailBean.ResultsBean elements;
    public String[] approvalType;
    private Unbinder unbinder;
    private NestedScrollView scrool_informApproval_Detail;
    private String id;

    @Override
    public View initView(LayoutInflater inflater) {

        Bundle bundle = getArguments();
        mActivity =  baseFragmentActivity;

        approvalType = ct.getResources().getStringArray(R.array.approvalType);
        if (bundle != null) {
            id = bundle.getString("id");
        }

        view = inflater.inflate(R.layout.fragment_online_inform_approval_detail
                , null, false);
        scrool_informApproval_Detail = (NestedScrollView) view.findViewById(R.id.scrool_informApproval_Detail);

        unbinder = ButterKnife.bind(this, view);
        scrool_informApproval_Detail.setVisibility(View.GONE);
        return view;

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbarClude,true,"知会详情",-1,true);
        tvInformapprovalDeatailAttach.setOnClickListener(this);
        LoadInfromApprovalDetrail();
        if (elements == null)
            LoadInfromApprovalDetrail();
    }

    private void LoadInfromApprovalDetrail() {

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
        }, CustomApplication.userInfor.getUserId(), id);

    }

    private void showDetailData() {
        try {
            tvInformapprovalDeatailApprovalType.setText(approvalType[Integer.parseInt(elements
                    .getApprovalType
                            ())]);
        } catch (NumberFormatException e) {
        }
        tvInformapprovalDetailWhoInform.setText(elements.getRecipientNames().equals("")
                ? "无" : elements.getRecipientNames());
        tvInformapprovalDeatailSender.setText(elements.getCreater());
        if (elements.getApprovalFileName() != null && !TextUtils.isEmpty(elements
                .getApprovalFileName())) {
            tvInformapprovalDeatailAttach.setText(elements.getApprovalFileName());
        } else {
            tvInformapprovalDeatailAttach.setText("无附件");
            tvInformapprovalDeatailAttach.setTextColor(Color.GRAY);
            tvInformapprovalDeatailAttach.setClickable(false);
        }
        tvInformapprovalDeatailContent.setText(elements.getContent());
        tvInformapprovalDeatailSendtime.setText(elements.getCreateTime());
        showCommentDetail();

    }

    private void showCommentDetail() {
        for (ApprovalDetailBean.ResultsBean.ApprovalInfoBean item : elements.getApprovalInfo()) {
            llInformapprovalDetailCommentainer.removeAllViews();
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


                tv_informapproval_Deatail_commentwords.setText(item.getComment() == null
                        ? "无" : item.getComment());
            }
            if (item.getApprover_imgurl() != null) {
                LoadBitmapUtils.LoadImagview(mActivity, item.getApprover_imgurl(),
                        iv_informapproval_Detail_approversHeadPic);
            }
            tv_informapproval_Deatail_approverTime.setText(item.getApprovalTime());

            llInformapprovalDetailCommentainer.addView(commentView);
        }
        scrool_informApproval_Detail.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.tv_informapproval_Deatail_attach:
                addFragment(new PreviewFragment().newInstance(elements.getHtmlFileUrl()));
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

    public static OnLineInformApprovalDetailFragment newInstance(String id) {
        OnLineInformApprovalDetailFragment fragment = new OnLineInformApprovalDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
