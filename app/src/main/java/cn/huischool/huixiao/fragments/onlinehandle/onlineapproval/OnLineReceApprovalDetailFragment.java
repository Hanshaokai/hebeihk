package cn.huischool.huixiao.fragments.onlinehandle.onlineapproval;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.ApprovalDetailBean;
import cn.huischool.huixiao.common.fragment.PreviewFragment;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.OpinionCallBackUtil;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/6/16.
 */

public class OnLineReceApprovalDetailFragment extends BaseFragment implements OpinionCallBackUtil.OpinionCllaBack {
    private AppCompatActivity mActivity;
    private ApprovalDetailBean.ResultsBean elements;
    private View view;
    private Toolbar toolbar_clude;
    private TextView tv_title_clude;
    private TextView tv_receiapproval_Deatail_Content;
    private TextView tv_receiapproval_Deatail_sendtime;
    private TextView tv_receiapproval_Deatail_attach;
    private TextView tv_receiapproval_deatail_approvalType;
    private TextView tv_receiapproval_deatail_sender;
    private Button btn_receiapproval_Detail_toApproval;
    private int position;
    public String[] approvalType;
    private LinearLayout ll_receiapproval_detail_commentContainer;
    private TextView tv_receiapproval_detail_who_inform;
    private String id;
    private NestedScrollView nestscroll_receiapproval_deatail;

    @Override
    public View initView(LayoutInflater inflater) {
        OpinionCallBackUtil.getIntence().add(this);//加入评论后 回调
        mActivity = (AppCompatActivity) baseFragmentActivity;
        Bundle bundle = getArguments();
        approvalType = mActivity.getResources().getStringArray(R.array.approvalType);

        if (bundle != null) {
            id = bundle.getString("id");
            position = bundle.getInt("position");
        }

        view = inflater.inflate(R.layout.fragment_online_acce_approval_detail, null, false);
        tv_receiapproval_Deatail_Content = (TextView) view.findViewById(R.id.tv_receiapproval_Deatail_Content);
        btn_receiapproval_Detail_toApproval = (Button) view.findViewById(R.id
                .btn_receiapproval_Detail_toApproval);//审批动作按钮
        tv_receiapproval_Deatail_attach = (TextView) view.findViewById(R.id
                .tv_receiapproval_Deatail_attach);//申批项携带的附件
        tv_receiapproval_Deatail_sendtime = (TextView) view.findViewById(R.id
                .tv_receiapproval_Deatail_sendtime);//审批申请的创建提交时间
        tv_receiapproval_deatail_approvalType = (TextView) view.findViewById(R.id
                .tv_receiapproval_Deatail_approvalType);//审批申请类型
        tv_receiapproval_deatail_sender = (TextView) view.findViewById(R.id
                .tv_receiapproval_Deatail_sender);//审批发送人
        ll_receiapproval_detail_commentContainer = (LinearLayout) view.findViewById(R.id
                .ll_receiapproval_Detail_commentContainer);
        tv_receiapproval_detail_who_inform =
                (TextView) view.findViewById(R.id
                        .tv_receiapproval_Detail_who_inform);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.
                findViewById(R.id.tv_title_clude);
        nestscroll_receiapproval_deatail = (NestedScrollView) view.findViewById(R.id
                .nestscroll_receiapproval_Deatail);
        nestscroll_receiapproval_deatail.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        btn_receiapproval_Detail_toApproval.setOnClickListener(this);
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_clude,true,"审批详情",-1,true);
        tv_receiapproval_Deatail_attach.setOnClickListener(this);
        if (elements == null) {
            loadeApprovalDetailData();
        }
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
        }, CustomApplication.userInfor.getUserId(), id);
    }

    public static BaseFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putString("id", id);
        OnLineReceApprovalDetailFragment fragment = new OnLineReceApprovalDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void showDetailData() {
        tv_receiapproval_deatail_approvalType.setText(approvalType[Integer.parseInt(elements
                .getApprovalType
                        ())]);
        tv_receiapproval_deatail_sender.setText(elements.getCreater());
        if (elements.getApprovalFileName() != null && !TextUtils.isEmpty(elements
                .getApprovalFileName())) {
            tv_receiapproval_Deatail_attach.setText(elements.getApprovalFileName());
        } else {
            tv_receiapproval_Deatail_attach.setText("无附件");
            tv_receiapproval_Deatail_attach.setTextColor(Color.GRAY);
            tv_receiapproval_Deatail_attach.setClickable(false);
        }
        tv_receiapproval_Deatail_Content.setText(elements.getContent());
        tv_receiapproval_Deatail_sendtime.setText(elements.getCreateTime());
        tv_receiapproval_detail_who_inform.setText(elements.getRecipientNames().equals("")
                ? "无" : elements.getRecipientNames());
        showCommentDetail();
    }

    private void showCommentDetail() {
        ll_receiapproval_detail_commentContainer.removeAllViews();
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
            ll_receiapproval_detail_commentContainer.addView(commentView);


        }
        nestscroll_receiapproval_deatail.setVisibility(View.VISIBLE);
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
            case R.id.btn_receiapproval_Detail_toApproval:

                if (elements.getOpinion() != null) {
                    Toast.makeText(getActivity(), "您已审批过", Toast.LENGTH_SHORT).show();
                    return;
                }

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                ApprovalDialogFragment.newInstance(elements, position).show(transaction,
                        "ApprovalDialogFragment");
                break;
            case R.id.tv_receiapproval_Deatail_attach:
                addFragment(new PreviewFragment().newInstance(elements.getHtmlFileUrl()));
        }
    }


    @Override
    public void opinionBack(String op, int position, String comment, String approvalTime) {
        elements.getApprovalInfo().get(Integer.parseInt(elements.getApproversIdsNum()) - 1).setOpinion(op);
        elements.getApprovalInfo().get(Integer.parseInt(elements.getApproversIdsNum()) - 1)
                .setApprovalTime(approvalTime);
        elements.getApprovalInfo().get(Integer.parseInt(elements.getApproversIdsNum()) - 1)
                .setComment(comment);
        showCommentDetail();
    }


}
