package cn.huischool.huixiao.fragments.onlinehandle.onlinehandleactivitiesofteachandresearch;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.rey.material.widget.ImageButton;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.MyActivitiesOfTeachAndResearchDetailBean;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.TooSnackbar;
import cn.huischool.huixiao.common.utils.ToolDateTime;
import cn.huischool.huixiao.common.utils.ToolString;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/9/21.
 */

public class ToCommitActivityOfEditedFragment extends BaseFragment {

    @BindView(R.id.tv_title_clude)
    TextView tvTitleClude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtnActionClude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbarClude;
    @BindView(R.id.appbar_clude)
    AppBarLayout appbarClude;
    @BindView(R.id.tv_my_activitiesofteachandresearch_tocommit_name)
    TextView tvMyActivitiesofteachandresearchTocommitName;
    @BindView(R.id.et_activitiesofteachandresearch_tocommit_group)
    EditText etActivitiesofteachandresearchTocommitGroup;
    @BindView(R.id.et_activitiesofteachandresearch_tocommit_creattime)
    TextView etActivitiesofteachandresearchTocommitCreattime;
    @BindView(R.id.et_activitiesofteachandresearch_tocommit_creatplace)
    TextView etActivitiesofteachandresearchTocommitCreatplace;
    @BindView(R.id.et_activitiesofteachandresearch_tocommit_participants)
    EditText etActivitiesofteachandresearchTocommitParticipants;
    @BindView(R.id.et_activitiesofteachandresearch_tocommit_central_issue)
    EditText etActivitiesofteachandresearchTocommitCentralIssue;
    @BindView(R.id.et_activitiesofteachandresearch_tocommit_minutes)
    EditText etActivitiesofteachandresearchTocommitMinutes;
    @BindView(R.id.et_activitiesofteachandresearch_tocommit_simplereview)
    EditText etActivitiesofteachandresearchTocommitSimplereview;
    @BindView(R.id.nestscroll_activitiesofteachandresearch_tocommit)
    NestedScrollView nestscrollActivitiesofteachandresearchTocommit;
    private AppCompatActivity myActivity;
    private Unbinder unbinder;

    public void toShowActivitiesOfTeachAndResearchIdDetailData
            (MyActivitiesOfTeachAndResearchDetailBean.ResultsBean result) {

        etActivitiesofteachandresearchTocommitGroup.setText(result.getRgroup());
        etActivitiesofteachandresearchTocommitCreattime.setText(result.getRtime());
        etActivitiesofteachandresearchTocommitCreatplace.setText(result.getAddress());
        etActivitiesofteachandresearchTocommitParticipants.setText(result.getAllPerson());
        etActivitiesofteachandresearchTocommitCentralIssue.setText(result.getCenterTitle());
        etActivitiesofteachandresearchTocommitMinutes.setText(result.getActivityContent());
        etActivitiesofteachandresearchTocommitSimplereview.setText(result.getSimpleReview());
        imagbtnActionClude.setVisibility(View.VISIBLE);//显示提交按钮
        nestscrollActivitiesofteachandresearchTocommit.setVisibility(View.VISIBLE);
    }

    String rgroup;
    String rtime;
    String address;
    String allPerson;
    String centerTitle;
    String activityContent;
    String simpleReview;
    private CoordinatorLayout coor_commit_activitiesofteachandresearch;
    private TimePickerView pvTime;
    private String activitiesOfTeachAndResearchId;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        activitiesOfTeachAndResearchId = getArguments().getString("id");
        view = inflater.inflate(R.layout.fragment_handle_tocommit_activitiesofteachandresearch, null, false);
        coor_commit_activitiesofteachandresearch =
                (CoordinatorLayout) view.findViewById(R.id
                        .coor_commit_activitiesofteachandresearch);
        unbinder = ButterKnife.bind(this, view);
        nestscrollActivitiesofteachandresearchTocommit.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        imagbtnActionClude.setImageResource(R.drawable.ic_done);
        tvTitleClude.setText("创建教研活动");
        initToolBar(toolbarClude, true, "创建教研活动",-1,true);
        setCommitActivitiesofTeachAndResearchListener();
        toLoadeActivitiesOfTeachAndResearchDetailData();
    }

    private void toLoadeActivitiesOfTeachAndResearchDetailData() {
        showProgressDialog("正在加载...");
        DataAchieve.toGetMyActivitiesOfTeachAndResearchDetail(new DataAchieve.SuccessCallBack() {

                                                                  @Override
                                                                  public void handle(int code, Object object) {
                                                                      if (code != 1000) {
                                                                          dismissProgressDialog();
                                                                          return;
                                                                      }
                                                                      if (object != null) {
                                                                          dismissProgressDialog();
                                                                          MyActivitiesOfTeachAndResearchDetailBean.ResultsBean result = ((MyActivitiesOfTeachAndResearchDetailBean) object).getResults();
                                                                          toShowActivitiesOfTeachAndResearchIdDetailData
                                                                                  (result);
                                                                      }
                                                                  }
                                                              }, activitiesOfTeachAndResearchId, ToolString.getStringOfEncoder(CustomApplication
                        .userInfor.getRealName()),
                CustomApplication
                        .userInfor.getRemarkId());
    }


    public static BaseFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putSerializable("id", id);
        ToCommitActivityOfEditedFragment fragment = new ToCommitActivityOfEditedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void setCommitActivitiesofTeachAndResearchListener() {
        imagbtnActionClude.setOnClickListener(this);
        etActivitiesofteachandresearchTocommitCreattime.setOnClickListener(this);
         /*时间选择器*/
        pvTime = new TimePickerView(myActivity, TimePickerView.Type.YEAR_MONTH_DAY);
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);

        //时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                etActivitiesofteachandresearchTocommitCreattime.setText(ToolDateTime.getPickerViewTime(date));
            }
        });
    }

    @Override
    protected void onClickEvent(View view) {

        switch (view.getId()) {

            case R.id.imagbtn_action_clude:

                AlertDialog.Builder alert = new AlertDialog
                        .Builder(myActivity);

                alert.setPositiveButton("正式提交", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toCommit("1");
                    }
                });
                alert.setMessage("请选择提交还是保存草稿");
                alert.setNegativeButton("保存草稿", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toCommit("0");
                    }
                });
                alert.create().show();
                break;

            case R.id.et_activitiesofteachandresearch_tocommit_creattime:

                pvTime.show();/*弹出时间选择器*/
                break;
        }
    }

    private void toCommit(String sumitstatus) {

        rgroup = etActivitiesofteachandresearchTocommitGroup.getText().toString();
        rtime = etActivitiesofteachandresearchTocommitCreattime.getText().toString();
        address = etActivitiesofteachandresearchTocommitCreatplace.getText().toString();
        allPerson = etActivitiesofteachandresearchTocommitParticipants.getText().toString();
        centerTitle = etActivitiesofteachandresearchTocommitCentralIssue.getText().toString();
        activityContent = etActivitiesofteachandresearchTocommitMinutes.getText().toString();
        simpleReview = etActivitiesofteachandresearchTocommitSimplereview.getText().toString
                ();

        if (
                rgroup == null ||
                        rtime == null ||
                        address == null ||
                        allPerson == null ||
                        centerTitle == null ||
                        activityContent == null ||
                        simpleReview == null ||
                        simpleReview.equals("") ||
                        activityContent.equals("") ||
                        centerTitle.equals("") ||
                        allPerson.equals("") ||
                        address.equals("") ||
                        rtime.equals("")
                ) {
            TooSnackbar.showMessage(coor_commit_activitiesofteachandresearch, "请填写完整");
            return;
        }

        showProgressDialog("正在提交...");
        DataAchieve.toCommitActivitiesofTeachAndResearch(new DataAchieve.SuccessCallBack() {
                                                             @Override
                                                             public void handle(int code, Object object) {


                                                                 if (code != 1000) {

                                                                     dismissProgressDialog();
                                                                     return;
                                                                 }
                                                                 if (code == 1000) {

                                                                     dismissProgressDialog();
                                                                     final AlertDialog.Builder alert = new AlertDialog
                                                                             .Builder(myActivity);

                                                                     alert.setPositiveButton("留在此页面", new DialogInterface.OnClickListener() {
                                                                         @Override
                                                                         public void onClick(DialogInterface dialogInterface, int i) {

                                                                         }
                                                                     });
                                                                     alert.setMessage("您的教研活动已完成提交");
                                                                     alert.setNegativeButton("离开此页面", new DialogInterface.OnClickListener() {
                                                                         @Override
                                                                         public void onClick(DialogInterface dialogInterface, int i) {
                                                                             removeFragment();
                                                                         }
                                                                     });
                                                                     alert.create().show();
                                                                 }

                                                             }

                                                         }, "", sumitstatus, CustomApplication
                        .userInfor.getUserId(), rgroup, rtime, address,
                allPerson, centerTitle, activityContent, simpleReview, CustomApplication.userInfor
                        .getSchoolId(),
                CustomApplication.userInfor.getSchoolName(), CustomApplication.userInfor.getRealName());


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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (pvTime.isShowing()) {
            pvTime.dismiss();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
