package cn.huischool.huixiao.fragments.onlinehandle.onlineapproval;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.ApprovalDetailBean;
import cn.huischool.huixiao.bean.ReceivApprovalBean;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.OpinionCallBackUtil;
import cn.huischool.huixiao.common.utils.ToolDateTime;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/6/22.
 */
public class ApprovalDialogFragment extends DialogFragment implements RadioGroup
        .OnCheckedChangeListener, View.OnClickListener {
    private ApprovalDetailBean.ResultsBean elements;
    String opinion = "";
    int position;
    private AlertDialog alertDialog;
    private RadioGroup group_approval_dialog;
    private RadioButton group_approval_agree;
    private RadioButton group_approval_disagree;
    private Button btn_approval_dialog_sure;
    private Button btn_approval_dialog_cancel;
    private EditText et_doApproval_comment_dialog;
    private String comment;
    private String approvalTime;

    public ApprovalDialogFragment() {
    }

    public static ApprovalDialogFragment newInstance(Object ments, int po) {

        ApprovalDialogFragment fragment = new ApprovalDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("elements", (ApprovalDetailBean.ResultsBean) ments);
        bundle.putInt("position", po);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        elements = (ApprovalDetailBean.ResultsBean) getArguments().getSerializable("elements");
        position = getArguments().getInt("position");
        View diagView = LayoutInflater.from(getActivity()).inflate(R.layout
                        .diag_item_receapproval_fragment,
                null, false);
        group_approval_dialog = (RadioGroup) diagView.findViewById(R.id.group_approval_dialog);
        group_approval_agree = (RadioButton) diagView.findViewById(R.id.group_approval_agree);
        group_approval_disagree = (RadioButton) diagView.findViewById(R.id.group_approval_disagree);
        btn_approval_dialog_sure = (Button) diagView.findViewById(R.id
                .btn_approval_dialog_sure);
        btn_approval_dialog_cancel = (Button) diagView.findViewById(R.id
                .btn_approval_dialog_cancel);
        et_doApproval_comment_dialog = (EditText) diagView.findViewById(R.id
                .et_doApproval_comment_dialog);
        group_approval_dialog.setOnCheckedChangeListener(this);
        btn_approval_dialog_sure.setOnClickListener(this);
        btn_approval_dialog_cancel.setOnClickListener(this);
        alertDialog = new AlertDialog.Builder(getActivity()).setView
                (diagView)
                .create();

        //alertDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);//不加 则shape不作用
        alertDialog.setCanceledOnTouchOutside(false);
        return alertDialog;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (group.getId() == R.id.group_approval_dialog) {
            switch (checkedId) {
                case R.id.group_approval_agree:
                    opinion = "1";
                    LogUtil.d(opinion);
                    break;

                case R.id.group_approval_disagree:
                    opinion = "0";
                    LogUtil.d(opinion);
                    break;
            }


        }
    }

    private void toDecideApproval() {
        approvalTime = ToolDateTime.formatDateTime(System.currentTimeMillis());

        LogUtil.d("做出审批的当前时间为" + approvalTime);
        DataAchieve.toDecideApproval(new DataAchieve.SuccessCallBack() {
                                         @Override
                                         public void handle(int code, Object object) {
                                             if (code != 1000) {
                                                 return;
                                             }
                                             if (opinion.equals("1")) {

                                                 doresult();
                                                 Toast.makeText(getActivity(), "您选择了同意", Toast
                                                         .LENGTH_SHORT).show();
                                                 alertDialog.cancel();
                                             } else {

                                                 doresult();
                                                 Toast.makeText(getActivity(), "您选择了不同意", Toast
                                                         .LENGTH_SHORT).show();
                                                 alertDialog.cancel();
                                             }

                                         }
                                     }, elements.getApprovalInfo().get(Integer.parseInt(elements.getApproversIdsNum()) - 1)
                        .getId(),
                opinion, comment,
                CustomApplication.userInfor
                        .getUserId(), CustomApplication.userInfor.getSchoolId(), approvalTime);


    }

    public void doresult() {

        if (!CollectionUtils.isListNull(OpinionCallBackUtil.getIntence())) {
            List<OpinionCallBackUtil.OpinionCllaBack> list = OpinionCallBackUtil
                    .getIntence();
            for (OpinionCallBackUtil.OpinionCllaBack item : list) {

                item.opinionBack(opinion, position, comment, approvalTime);
            }


        }


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btn_approval_dialog_sure:
                comment = et_doApproval_comment_dialog.getText().toString();
                if (opinion.equals("")) {
                    Toast.makeText(getActivity(),"请选择同意不同意",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(comment)) {


                }
                toDecideApproval();

                break;

            case R.id.btn_approval_dialog_cancel:
                alertDialog.cancel();
                break;


        }

    }

}
