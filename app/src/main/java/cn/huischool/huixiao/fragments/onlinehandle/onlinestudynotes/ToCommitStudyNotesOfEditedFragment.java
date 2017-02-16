package cn.huischool.huixiao.fragments.onlinehandle.onlinestudynotes;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
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
import cn.huischool.huixiao.bean.MyStudyNotesDetailBean;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.TooSnackbar;
import cn.huischool.huixiao.common.utils.ToolDateTime;
import cn.huischool.huixiao.common.utils.ToolString;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/9/22.
 */

public class ToCommitStudyNotesOfEditedFragment extends BaseFragment {

    @BindView(R.id.tv_title_clude)
    TextView tvTitleClude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtnActionClude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbarClude;
    @BindView(R.id.appbar_clude)
    AppBarLayout appbarClude;
    @BindView(R.id.et_study_notes_tocommit_creattime)
    TextView etStudyNotesTocommitCreattime;
    @BindView(R.id.et_study_notes_tocommit_creatplace)
    EditText etStudyNotesTocommitCreatplace;
    @BindView(R.id.et_study_notes_tocommit_theme)
    EditText etStudyNotesTocommitTheme;
    @BindView(R.id.et_study_notes_tocommit_contentsource)
    EditText etStudyNotesTocommitContentsource;
    @BindView(R.id.et_study_notes_tocommit_content)
    EditText etStudyNotesTocommitContent;
    @BindView(R.id.et_study_notes_tocommit_comprehensive_income)
    EditText etStudyNotesTocommitComprehensiveIncome;

    private void toShowStudyNotesDetailData(MyStudyNotesDetailBean.ResultsBean result) {
        etStudyNotesTocommitCreattime.setText(result.getStudyTime());
        etStudyNotesTocommitCreatplace.setText(result.getStudyAddress());
        etStudyNotesTocommitTheme.setText(result.getStudyTitle());
        etStudyNotesTocommitContentsource.setText(result.getStudySource());
        etStudyNotesTocommitContent.setText(result.getLearnNotes());
        etStudyNotesTocommitComprehensiveIncome.setText(result.getLearnLesson());
        nestscrollMeetingrecordNotesTocommit.setVisibility(View.VISIBLE);
    }

    @BindView(R.id.nestscroll_study_notes_tocommit)
    NestedScrollView nestscrollMeetingrecordNotesTocommit;
    private AppCompatActivity myActivity;
    private Unbinder unbinder;
    private CoordinatorLayout coor_commit_studynotes;
    String studyTitle;
    String studyTime;
    String studyAddress;
    String studySource;
    String learnNotes;
    String learnLesson;
    private TimePickerView pvTime;
    private String studyRecordId;
    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        studyRecordId = getArguments().getString("id");
        view = inflater.inflate(R.layout.fragment_handle_tocommit_studynotes, null, false);
        coor_commit_studynotes = (CoordinatorLayout) view.findViewById(R.id.coor_commit_studynotes);
        unbinder = ButterKnife.bind(this, view);
        nestscrollMeetingrecordNotesTocommit.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        initToolBar(toolbarClude, true, "创建学习笔记", R.drawable.ic_done,true);
        setCommitStudyNotesListener();
        toLoadeStudyNotesDetailData();

    }

    private void toLoadeStudyNotesDetailData() {
        showProgressDialog("正在加载...");
        DataAchieve.toGetMyStudyNotesDetail(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                if (code != 1000) {
                    dismissProgressDialog();
                    return;
                }
                if (object != null) {
                    dismissProgressDialog();
                    MyStudyNotesDetailBean.ResultsBean result = ((MyStudyNotesDetailBean) object).getResults();
                    toShowStudyNotesDetailData(result);
                }
            }
        }, studyRecordId, ToolString.getStringOfEncoder(CustomApplication.userInfor
                .getRealName()), CustomApplication.userInfor.getRemarkId());
    }


    public static BaseFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putSerializable("id", id);
        ToCommitStudyNotesOfEditedFragment fragment = new ToCommitStudyNotesOfEditedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void setCommitStudyNotesListener() {
        imagbtnActionClude.setOnClickListener(this);
        etStudyNotesTocommitCreattime.setOnClickListener(this);
        pvTime = new TimePickerView(myActivity, TimePickerView.Type.YEAR_MONTH_DAY);
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);
        //时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date) {
                etStudyNotesTocommitCreattime.setText(ToolDateTime.getPickerViewTime(date));
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
                        toCommitStudyNotes("1");
                    }
                });
                alert.setMessage("请选择提交还是保存草稿");
                alert.setNegativeButton("保存草稿", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toCommitStudyNotes("0");
                    }
                });
                alert.create().show();
                break;
            case R.id.et_study_notes_tocommit_creattime:
                pvTime.show();
                break;
        }
    }

    private void toCommitStudyNotes(String status) {
        studyTitle = etStudyNotesTocommitTheme.getText().toString();
        studyTime = etStudyNotesTocommitCreattime.getText().toString();
        studyAddress = etStudyNotesTocommitCreatplace.getText().toString();
        studySource = etStudyNotesTocommitContentsource.getText().toString();
        learnNotes = etStudyNotesTocommitContent.getText().toString();
        learnLesson = etStudyNotesTocommitComprehensiveIncome.getText().toString();
        if (
                studyTitle == null ||
                        studyTime == null ||
                        studyAddress == null ||
                        studySource == null ||
                        learnNotes == null ||
                        learnLesson == null ||
                        studyTime.equals("") ||
                        studyAddress.equals("") ||
                        studySource.equals("") ||
                        learnNotes.equals("") ||
                        learnLesson.equals("")
                ) {
            TooSnackbar.showMessage(coor_commit_studynotes, "请填写完整");
            return;
        }
        showProgressDialog("正在提交...");
        DataAchieve.toCommitStudyNotes(new DataAchieve.SuccessCallBack() {
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
                                                   alert.setMessage("您的学习笔记已完成提交");
                                                   alert.setNegativeButton("离开此页面", new DialogInterface.OnClickListener() {
                                                       @Override
                                                       public void onClick(DialogInterface dialogInterface, int i) {
                                                           removeFragment();
                                                       }
                                                   });
                                                   alert.create().show();
                                               }

                                           }

                                       }, status, studyRecordId, studyTitle, CustomApplication.userInfor
                        .getUserId(), studyTime, studyAddress,
                studySource, learnNotes, learnLesson, CustomApplication.userInfor.getSchoolId(),
                CustomApplication.userInfor.getSchoolName(), CustomApplication.userInfor.getRealName());
    }

    @Override
    public void onDestroyView() {
        if (pvTime.isShowing()) {
            pvTime.dismiss();
        }
        unbinder.unbind();
        super.onDestroyView();
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
}
