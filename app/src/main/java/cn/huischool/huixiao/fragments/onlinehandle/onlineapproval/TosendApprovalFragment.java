package cn.huischool.huixiao.fragments.onlinehandle.onlineapproval;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rey.material.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.ApprovalActivity;
import cn.huischool.huixiao.bean.ApprovalReceiversOfTheRoleBean;
import cn.huischool.huixiao.bean.ApprovalSelectRoleListBean;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/6/15.
 */
public class TosendApprovalFragment extends BaseFragment {

    private Toolbar toolbar_clude;
    private TextView tv_title_clude;
    private ImageButton imagbtn_action_clude;
    private ApprovalActivity myActivity;
    private String approvalContent = "";//内容
    private String approversIds1 = "";//第一审批人id
    private String approversIds2 = "";//第二审批人id
    private String approversIds3 = "";//第三审批人id

    // private String approverAmount;//审批环节总数量
    private String recipientIds = "";//抄送人 id
    private String recipientNames = "";//抄送人姓名
    private String approvalType;//申请类型


    private EditText et_tosend_approval_content;

    private TextView tv_tosend_approval_target1;//第一批接收人
    private TextView tv_tosend_approval_target2;
    private TextView tv_tosend_approval_target3;

    private LinearLayout ll_tosend_approval_item1;//第一批容器
    private LinearLayout ll_tosend_approval_item2;
    private LinearLayout ll_tosend_approval_item3;

    private LinearLayout ll_tosend_approval_action;

    private TextView tv_tosend_approval_deletet1;//第一批容器 删除
    private TextView tv_tosend_approval_deletet2;
    private TextView tv_tosend_approval_deletet3;
    private Spinner spinner_tosend_approvalType;
    private Spinner spinner_tosend_approval_role;
    private Spinner spinner_tosend_approval_receivers;
    private List<ApprovalSelectRoleListBean.ResultsBean> roleList;
    private List<ApprovalReceiversOfTheRoleBean.ResultsBean> receivers_list;
    String[] role_string;
    String[] receivers_string;
    private int approvalNum = 1;

    @Override
    public View initView(LayoutInflater inflater) {


        myActivity = (ApprovalActivity) baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_tosend_approval, null, false);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        imagbtn_action_clude = (ImageButton) view.findViewById(R.id.imagbtn_action_clude);


        et_tosend_approval_content = (EditText) view.findViewById(R.id.et_tosend_approval_content);
        tv_tosend_approval_target1 = (TextView) view.findViewById(R.id.tv_tosend_approval_target1);
        tv_tosend_approval_target2 = (TextView) view.findViewById(R.id
                .tv_tosend_approval_target2);
        tv_tosend_approval_target3 = (TextView) view.findViewById(R.id
                .tv_tosend_approval_target3);
        ll_tosend_approval_item1 = (LinearLayout) view.findViewById(R.id.ll_tosend_approval_item1);
        ll_tosend_approval_item2 = (LinearLayout) view.findViewById(R.id
                .ll_tosend_approval_item2);
        ll_tosend_approval_item3 = (LinearLayout) view.findViewById(R.id
                .ll_tosend_approval_item3);
        ll_tosend_approval_action = (LinearLayout) view.findViewById(R.id.ll_tosend_approval_action);

        tv_tosend_approval_deletet1 = (TextView) view.findViewById(R.id.tv_tosend_approval_deletet1);
        tv_tosend_approval_deletet2 = (TextView) view.findViewById(R.id
                .tv_tosend_approval_deletet2);
        tv_tosend_approval_deletet3 = (TextView) view.findViewById(R.id
                .tv_tosend_approval_deletet3);
        spinner_tosend_approvalType = (Spinner) view.findViewById(R.id.spinner_tosend_approvalType);
        spinner_tosend_approval_role = (Spinner) view.findViewById(R.id.spinner_tosend_approval_role);
        spinner_tosend_approval_receivers = (Spinner) view.findViewById(R.id.spinner_tosend_approval_receivers);


        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initToolBar(toolbar_clude,true,"新建审批",R.mipmap.ic_done_white_24dp,true);
        setHasOptionsMenu(true);//不设置 导致不起作用
        setLisenner();
    }

    private void setLisenner() {
        ll_tosend_approval_item1.setOnClickListener(this);
        ll_tosend_approval_item2.setOnClickListener(this);
        ll_tosend_approval_item3.setOnClickListener(this);

        tv_tosend_approval_deletet1.setOnClickListener(this);
        tv_tosend_approval_deletet2.setOnClickListener(this);
        tv_tosend_approval_deletet3.setOnClickListener(this);
        ll_tosend_approval_action.setOnClickListener(this);
        imagbtn_action_clude.setOnClickListener(this);
        spinner_tosend_approvalType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    approvalType = "";
                    return;
                }
                approvalType = (position - 1) + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_tosend_approval_role.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0)
                    return;

                DataAchieve.getApprovalReceiversOfTheRole(new DataAchieve.SuccessCallBack() {
                    @Override
                    public void handle(int code, Object object) {
                        if (code != 1000)
                            return;
                        receivers_list = ((ApprovalReceiversOfTheRoleBean) object).getResults();
                        if (receivers_list != null) {
                            int i = 0;
                            receivers_string = new String[receivers_list.size() + 1];
                            receivers_string[0] = "请选择接受人";
                            for (ApprovalReceiversOfTheRoleBean.ResultsBean item : receivers_list) {
                                receivers_string[++i] = item.getRealName();
                            }

                            ArrayAdapter receiverAdapter = new ArrayAdapter(myActivity, android.R.layout
                                    .simple_spinner_item, receivers_string);
                            spinner_tosend_approval_receivers.setAdapter(receiverAdapter);
                            spinner_tosend_approval_receivers.setVisibility(View.VISIBLE);
                        }
                    }
                }, CustomApplication.userInfor.getUserId(), roleList.get(position - 1).getId());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
        spinner_tosend_approval_receivers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                    return;
                switch (approvalNum) {

                    case 1:

                        tv_tosend_approval_target1.setText(receivers_list.get(position - 1).getRealName());
                        approversIds1 = receivers_list.get(position - 1).getId();
                        tv_tosend_approval_deletet1.setVisibility(View.VISIBLE);
                        ll_tosend_approval_item1.setVisibility(View.VISIBLE);
                        spinner_tosend_approval_receivers.setVisibility(View.GONE);
                        spinner_tosend_approval_role.setVisibility(View.GONE);
                        break;
                    case 2:

                        tv_tosend_approval_target2.setText(receivers_list.get(position - 1)
                                .getRealName());
                        approversIds2 = receivers_list.get(position - 1).getId();

                        ll_tosend_approval_item2.setVisibility(View.VISIBLE);
                        tv_tosend_approval_deletet1.setVisibility(View.INVISIBLE);
                        tv_tosend_approval_deletet2.setVisibility(View.VISIBLE);


                        spinner_tosend_approval_receivers.setVisibility(View.GONE);
                        spinner_tosend_approval_role.setVisibility(View.GONE);
                        break;
                    case 3:

                        tv_tosend_approval_target3.setText(receivers_list.get(position - 1)
                                .getRealName());
                        approversIds3 = receivers_list.get(position - 1).getId();
                        ll_tosend_approval_item3.setVisibility(View.VISIBLE);


                        tv_tosend_approval_deletet2.setVisibility(View.INVISIBLE);
                        tv_tosend_approval_deletet3.setVisibility(View.VISIBLE);

                        spinner_tosend_approval_receivers.setVisibility(View.GONE);
                        spinner_tosend_approval_role.setVisibility(View.GONE);
                        break;
                }
                approvalNum++;


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

            case R.id.tv_tosend_approval_deletet1:
                approversIds1 = "";
                ll_tosend_approval_item1.setVisibility(View.INVISIBLE);
                approvalNum--;
                tv_tosend_approval_deletet1.setVisibility(View.INVISIBLE);
                break;

            case R.id.tv_tosend_approval_deletet2:
                approversIds2 = "";
                ll_tosend_approval_item2.setVisibility(View.INVISIBLE);
                approvalNum--;
                tv_tosend_approval_deletet1.setVisibility(View.VISIBLE);
                tv_tosend_approval_deletet2.setVisibility(View.INVISIBLE);
                break;

            case R.id.tv_tosend_approval_deletet3:
                approversIds3 = "";
                ll_tosend_approval_item3.setVisibility(View.INVISIBLE);
                approvalNum--;
                tv_tosend_approval_deletet2.setVisibility(View.VISIBLE);
                tv_tosend_approval_deletet3.setVisibility(View.INVISIBLE);
                break;
            case R.id.ll_tosend_approval_action:
                if (approvalNum > 3) {

                    Toast.makeText(myActivity,"最多三级审批人",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (role_string == null) {
                    toAddApprovaler();
                } else {
                    spinner_tosend_approval_role.setVisibility(View.VISIBLE);
                }


                break;
            case R.id.imagbtn_action_clude:

                toSendApproval();

        }

    }

    private void toSendApproval() {
        approvalContent = et_tosend_approval_content.getText().toString();
        if (approversIds1.equals("") && approversIds2.equals("") && approversIds3.equals("")) {
            Toast.makeText(myActivity,"请添加审批人",Toast.LENGTH_SHORT).show();
            return;
        }
        if (approvalContent.equals("")) {
            Toast.makeText(myActivity,"请添加审批内容",Toast.LENGTH_SHORT).show();
            return;
        }
        if (approvalType.equals("")) {
            Toast.makeText(myActivity,"请添加审批类型",Toast.LENGTH_SHORT).show();
            return;
        }
        showProgressDialog("正在发送");
        DataAchieve.toCreateApproval(new DataAchieve.SuccessCallBack() {
                                         @Override
                                         public void handle(int code, Object object) {

                                             if (code != 1000) {
                                                 return;
                                             }
                                             Toast.makeText(myActivity,"发送成功",Toast.LENGTH_SHORT).show();
                                             dismissProgressDialog();
                                         }
                                     }, CustomApplication.userInfor.getUserId(), CustomApplication.userInfor.getSchoolId(),
                approvalContent, approversIds1, approversIds2, approversIds3, approvalNum - 1 + "", recipientIds, recipientNames, approvalType);

    }


    private void toAddApprovaler() {

        DataAchieve.getApprovalSelectRoleList(new DataAchieve.SuccessCallBack() {


                                                  @Override
                                                  public void handle(int code, Object object) {
                                                      roleList = ((
                                                              ApprovalSelectRoleListBean) object).getResults();
                                                      if (code != 1000)
                                                          return;
                                                      if (roleList != null) {
                                                          int i = 0;
                                                          role_string = new String[roleList.size
                                                                  () + 1];
                                                          role_string[0] = "请选择角色";
                                                          for (ApprovalSelectRoleListBean.ResultsBean item : roleList) {
                                                              role_string[++i] = item.getName();
                                                          }
                                                          ArrayAdapter roleAdapter = new ArrayAdapter(myActivity, android.R.layout
                                                                  .simple_spinner_item, role_string);
                                                          spinner_tosend_approval_role.setAdapter(roleAdapter);
                                                          spinner_tosend_approval_role.setVisibility(View.VISIBLE);
                                                      }
                                                  }
                                              }, CustomApplication.userInfor.getSchoolId(), CustomApplication.userInfor.getRemarkId(),
                CustomApplication
                        .userInfor.getRole()
                        .getId());


    }


}
