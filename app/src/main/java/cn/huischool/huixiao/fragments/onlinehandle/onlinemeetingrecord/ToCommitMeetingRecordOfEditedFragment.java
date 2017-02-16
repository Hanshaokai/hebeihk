package cn.huischool.huixiao.fragments.onlinehandle.onlinemeetingrecord;

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
import cn.huischool.huixiao.bean.MyMeetingRecordNotesDetailBean;
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

public class ToCommitMeetingRecordOfEditedFragment extends BaseFragment {


    @BindView(R.id.tv_title_clude)
    TextView tvTitleClude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtnActionClude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbarClude;
    @BindView(R.id.appbar_clude)
    AppBarLayout appbarClude;
    @BindView(R.id.et_my_meetingrecord_tocommit_meetingrecordname)
    EditText etMyMeetingrecordTocommitMeetingrecordname;
    @BindView(R.id.et_meetingrecord_notes_tocommit_creattime)
    TextView etMeetingrecordNotesTocommitCreattime;
    @BindView(R.id.et_meetingrecord_notes_tocommit_creatplace)
    EditText etMeetingrecordNotesTocommitCreatplace;
    @BindView(R.id.et_meetingrecord_notes_tocommit_compere)
    EditText etMeetingrecordNotesTocommitCompere;
    @BindView(R.id.et_meetingrecord_notes_tocommit_keynotespeaker)
    EditText etMeetingrecordNotesTocommitKeynotespeaker;
    @BindView(R.id.et_meetingrecord_notes_tocommit_spokesman)
    EditText etMeetingrecordNotesTocommitSpokesman;
    @BindView(R.id.et_meetingrecord_notes_tocommit_participants)
    EditText etMeetingrecordNotesTocommitParticipants;
    @BindView(R.id.et_meetingrecord_notes_tocommit_meetingcontent)
    EditText etMeetingrecordNotesTocommitMeetingcontent;

    private void toShowRecordNotesDetailData(MyMeetingRecordNotesDetailBean.ResultsBean result) {
        etMyMeetingrecordTocommitMeetingrecordname.setText(result.getMeetTitle());
        etMeetingrecordNotesTocommitCreattime.setText(result.getMeetTime());
        etMeetingrecordNotesTocommitCreatplace.setText(result.getMeetAddress());
        etMeetingrecordNotesTocommitCompere.setText(result.getMeetHost());
        etMeetingrecordNotesTocommitKeynotespeaker.setText(result.getSpeaker());
        etMeetingrecordNotesTocommitSpokesman.setText(result.getSpokesMan());
        etMeetingrecordNotesTocommitParticipants.setText(result.getAllPerson());
        etMeetingrecordNotesTocommitMeetingcontent.setText(result.getMeetContext());
        imagbtnActionClude.setVisibility(View.VISIBLE);//显示按钮
        nestscrollMeetingrecordNotesTocommit.setVisibility(View.VISIBLE);
    }

    @BindView(R.id.nestscroll_meetingrecord_notes_tocommit)
    NestedScrollView nestscrollMeetingrecordNotesTocommit;
    @BindView(R.id.coor_commit_meetingrecord)
    CoordinatorLayout coor_commit_meetingrecord;
    private AppCompatActivity myActivity;
    private Unbinder unbinder;

    String submitStatus;
    String meetTitle;
    String meetTime;
    String meetAddress;
    String meetHost;
    String speaker;
    String spokesMan;
    String allPerson;
    String meetContext;
    private TimePickerView pvTime;
    private String meetingRecordId;
    private String name;


    @Override
    public View initView(LayoutInflater inflater) {

        myActivity = baseFragmentActivity;
        meetingRecordId = getArguments().getString("id");
        view = inflater.inflate(R.layout.fragment_handle_tocommit_meetingrecord, null, false);
        unbinder = ButterKnife.bind(this, view);
        nestscrollMeetingrecordNotesTocommit.setVisibility(View.GONE);
        return view;

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        initToolBar(toolbarClude, true, "创建会议记录",R.drawable.ic_done,true);
        setCommitMetingRecordListener();
        toLoadeMeetRecordDetailData();
    }

    public static ToCommitMeetingRecordOfEditedFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putSerializable("id", id);
        ToCommitMeetingRecordOfEditedFragment fragment = new ToCommitMeetingRecordOfEditedFragment();
        fragment.setArguments(args);
        return fragment;


    }

    private void toLoadeMeetRecordDetailData() {

        showProgressDialog("正在加载...");
        DataAchieve.toGetMyMeetingRecordNotesDetail(new DataAchieve.SuccessCallBack() {
                                                        @Override
                                                        public void handle(int code, Object object) {
                                                            if (code != 1000) {
                                                                dismissProgressDialog();
                                                                return;
                                                            }
                                                            if (object != null) {
                                                                dismissProgressDialog();
                                                                MyMeetingRecordNotesDetailBean
                                                                        .ResultsBean result = (
                                                                        (MyMeetingRecordNotesDetailBean) object).getResults();
                                                                toShowRecordNotesDetailData(result);
                                                            }
                                                        }


                                                    }, meetingRecordId, ToolString.getStringOfEncoder(CustomApplication.userInfor.getRealName()),
                CustomApplication
                        .userInfor
                        .getRemarkId());


    }


    private void setCommitMetingRecordListener() {


        imagbtnActionClude.setOnClickListener(this);
        etMeetingrecordNotesTocommitCreattime.setOnClickListener(this);

        pvTime = new TimePickerView(myActivity, TimePickerView.Type.YEAR_MONTH_DAY);
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);

        //时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                etMeetingrecordNotesTocommitCreattime.setText(ToolDateTime.getPickerViewTime(date));
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
                        toCommitMeetingRecord("1");
                    }
                });
                alert.setMessage("请选择提交还是保存草稿");
                alert.setNegativeButton("保存草稿", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toCommitMeetingRecord("0");
                    }
                });
                alert.create().show();

                break;

            case R.id.et_meetingrecord_notes_tocommit_creattime:
                pvTime.show();
                break;

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

    private void toCommitMeetingRecord(String sumitstatus) {
        meetTitle = etMyMeetingrecordTocommitMeetingrecordname.getText().toString();
        meetTime = etMeetingrecordNotesTocommitCreattime.getText().toString();
        meetAddress = etMeetingrecordNotesTocommitCreatplace.getText().toString();
        meetHost = etMeetingrecordNotesTocommitCompere.getText().toString();
        speaker = etMeetingrecordNotesTocommitKeynotespeaker.getText().toString();
        spokesMan = etMeetingrecordNotesTocommitSpokesman.getText().toString();
        allPerson = etMeetingrecordNotesTocommitParticipants.getText().toString();
        meetContext = etMeetingrecordNotesTocommitMeetingcontent.getText().toString();

        if (
                meetTitle == null ||
                        meetTime == null ||
                        meetAddress == null ||
                        meetHost == null ||
                        speaker == null ||
                        spokesMan == null ||
                        allPerson == null ||
                        meetContext == null || meetTitle.equals("") ||
                        meetTime.equals("") ||
                        meetAddress.equals("") ||
                        meetHost.equals("") ||
                        speaker.equals("") ||
                        spokesMan.equals("") ||
                        allPerson.equals("") ||
                        meetContext.equals("")) {
            TooSnackbar.showMessage(coor_commit_meetingrecord, "请填写完整");

            return;

        }

        showProgressDialog("正在提交");
        DataAchieve.toCommitMeetingRecord(new DataAchieve.SuccessCallBack() {
                                              @Override
                                              public void handle(int code, Object object) {


                                                  if (code != 1000) {

                                                      dismissProgressDialog();
                                                      return;
                                                  }
                                                  if (code == 1000) {
                                                      TooSnackbar.showMessage(coor_commit_meetingrecord,
                                                              "提交成功");
                                                      dismissProgressDialog();
                                                      final AlertDialog.Builder alert = new AlertDialog
                                                              .Builder(myActivity);

                                                      alert.setPositiveButton("留在此页面", new DialogInterface.OnClickListener() {
                                                          @Override
                                                          public void onClick(DialogInterface dialogInterface, int i) {

                                                          }
                                                      });
                                                      alert.setMessage("您的会议记录已完成提交");
                                                      alert.setNegativeButton("离开此页面", new DialogInterface.OnClickListener() {
                                                          @Override
                                                          public void onClick(DialogInterface dialogInterface, int i) {
                                                              removeFragment();
                                                          }
                                                      });
                                                      alert.create().show();
                                                  }
                                              }
                                          }, sumitstatus, meetingRecordId, meetTitle,
                meetTime,
                meetAddress, meetHost, speaker, spokesMan, allPerson, meetContext, CustomApplication
                        .userInfor.getUserId(), CustomApplication.userInfor.getSchoolId());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (pvTime.isShowing()) {
            pvTime.dismiss();
        }
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
