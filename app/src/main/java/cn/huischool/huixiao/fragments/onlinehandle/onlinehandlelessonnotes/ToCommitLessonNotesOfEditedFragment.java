package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlelessonnotes;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.rey.material.widget.Button;
import com.rey.material.widget.ImageButton;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.AllGradeBean;
import cn.huischool.huixiao.bean.AllSubjectBean;
import cn.huischool.huixiao.bean.MyLesssonNotesDeatilBean;
import cn.huischool.huixiao.bean.OfOneGradeAllClassBean;
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

public class ToCommitLessonNotesOfEditedFragment extends BaseFragment {

    @BindView(R.id.tv_title_clude)
    TextView tvTitleClude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtnActionClude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbarClude;
    @BindView(R.id.appbar_clude)
    AppBarLayout appbarClude;
    @BindView(R.id.et_tocommit_lesson_notes_lessontime)
    TextView etTocommitLessonNotesLessontime;
    @BindView(R.id.et_tocommit_lesson_notes_lessontime_part)
    EditText etTocommitLessonNotesLessontimePart;
    @BindView(R.id.et_tocommit_lesson_notes_teachername)
    EditText etTocommitLessonNotesTeachername;
    @BindView(R.id.et_tocommit_lesson_notes_lessontype)
    EditText etTocommitLessonNotesLessontype;
    @BindView(R.id.sp_tocommit_lesson_notes_lessonname)
    EditText spTocommitLessonNotesLessonname;
    @BindView(R.id.sp_tocommit_lesson_notes_lessongrade)
    Spinner spTocommitLessonNotesLessongrade;
    @BindView(R.id.sp_tocommit_lesson_notes_lessonclass)
    Spinner spTocommitLessonNotesLessonclass;
    @BindView(R.id.sp_tocommit_lesson_notes_subject)
    Spinner spTocommitLessonNotesSubject;
    @BindView(R.id.et_tocommit_lesson_notes_lessonrecord)
    EditText etTocommitLessonNotesLessonrecord;
    @BindView(R.id.et_tocommit_lesson_notes_lessonanalysis)
    EditText etTocommitLessonNotesLessonanalysis;
    @BindView(R.id.nestscroll_tocommit_lesson_notes_parent)
    NestedScrollView nestscrollTocommitLessonNotesParent;
    @BindView(R.id.btn_tocommit_lesson_notes_selectinfor)
    TextView btntocommitlessonnotesselectinfor;
    private String[] grade_string;
    private String[] subject_string;
    private String[] class_string;
    private MyLesssonNotesDeatilBean.ResultsBean result;
    private boolean first = true;

    private void showMyLessonNotesDetailData() {
        first = false;
        etTocommitLessonNotesLessontime.setText(result.getMonth() + "-" + result.getDay());
        etTocommitLessonNotesLessontimePart.setText(result.getNum());
        etTocommitLessonNotesTeachername.setText(result.getTeacherName());
        etTocommitLessonNotesLessontype.setText(result.getLessonType());
        spTocommitLessonNotesLessonname.setText(result.getLessonTitle());
        etTocommitLessonNotesLessonrecord.setText(result.getLessonContext());
        etTocommitLessonNotesLessonanalysis.setText(result.getLessonAdvice());

        spTocommitLessonNotesLessongrade.setSelection(ToolString.getSelectionPosition(grade_string, result
                .getGradeName()));
        spTocommitLessonNotesLessonclass.setSelection(ToolString.getSelectionPosition(class_string, result
                .getClassName()));
        spTocommitLessonNotesSubject.setSelection(ToolString.getSelectionPosition(subject_string, result
                .getSubjectName()
        ));
        imagbtnActionClude.setVisibility(View.VISIBLE);
        nestscrollTocommitLessonNotesParent.setVisibility(View.VISIBLE);
    }


    @BindView(R.id.coor_lesson_notes)
    CoordinatorLayout coor_lesson_notes;
    private Unbinder unbinder;
    private AppCompatActivity myActivity;
    private List<AllGradeBean.ResultsBean> result_grade;
    private List<OfOneGradeAllClassBean.ResultsBean> result_class;
    private List<AllSubjectBean.ResultsBean> result_subject;
    /*上传参数*/
    String submitStatus;
    String subjectId;
    String subjectName;
    String gradeId;
    String gradeName;
    String classId;
    String className;
    String lessonTitle;
    String lessonType;
    String lessonContext;
    String lessonAdvice;
    String teachingTime;
    String month;
    String day;

    String num;
    String lessonTeacher;
    private TimePickerView pvTime;
    private String lessonNotesId;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        lessonNotesId = getArguments().getString("id");
        view = inflater.inflate(R.layout.fragment_handle_tocommit_lessonnotes, null, false);
        unbinder = ButterKnife.bind(this, view);
        nestscrollTocommitLessonNotesParent.setVisibility(View.GONE);
        return view;
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        initToolBar(toolbarClude, true, "创建听课记录",R.drawable.ic_done,true);
        setSpinnerLisener();
        loadeData();
    }

    public static BaseFragment newInstance(String id) {

        Bundle args = new Bundle();
        args.putSerializable("id", id);
        ToCommitLessonNotesOfEditedFragment fragment = new ToCommitLessonNotesOfEditedFragment();
        fragment.setArguments(args);
        return fragment;

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

    private void loadeData() {
        showProgressDialog("正在加载本校年级科目列表...");
        DataAchieve.getAllGradeList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                if (code != 1000) {
                    dismissProgressDialog();
                    return;
                }
                if (object != null) {
                    dismissProgressDialog();
                    result_grade = ((AllGradeBean
                            ) object).getResults();
                    int i = 0;
                    grade_string = new String[result_grade.size()];
                    for (AllGradeBean.ResultsBean item : result_grade) {
                        grade_string[i++] = item.getName();
                    }
                    ArrayAdapter gradeAdapter = new ArrayAdapter(myActivity, R.layout.row_spn_dropdown,
                            grade_string);
                    spTocommitLessonNotesLessongrade.setAdapter(gradeAdapter);
                    spTocommitLessonNotesLessongrade.setVisibility(View.VISIBLE);
                    gradeId = result_grade.get(0).getId();
                    gradeName = result_grade.get(0).getName();

                }
            }
        }, CustomApplication.userInfor.getSchoolId());


    }

    private void setSpinnerLisener() {
        imagbtnActionClude.setOnClickListener(this);

        etTocommitLessonNotesLessontime.setOnClickListener(this);
        spTocommitLessonNotesLessongrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gradeName = result_grade.get(i).getName();
                gradeId = result_grade.get(i).getId();

                loadeClassData(gradeId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
        spTocommitLessonNotesLessonclass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                className = result_class.get(i).getName();
                classId = result_class.get(i).getId();
                loadeSubjectData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
        spTocommitLessonNotesSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                subjectName = result_subject.get(i).getName();
                subjectId = result_subject.get(i).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        pvTime = new TimePickerView(myActivity, TimePickerView.Type.YEAR_MONTH_DAY);
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);

        //时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date) {
                etTocommitLessonNotesLessontime.setText(ToolDateTime.getPickerViewTime(date)
                        .substring(ToolDateTime.getPickerViewTime(date).indexOf("-") + 1));
            }
        });
    }

    private void loadeSubjectData() {
        DataAchieve.getAllSubjectList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                if (code != 1000) {
                    return;
                }
                if (object != null) {
                    result_subject = ((AllSubjectBean
                            ) object).getResults();
                    int i = 0;
                    subject_string = new String[result_subject.size()];
                    for (AllSubjectBean
                            .ResultsBean item : result_subject) {
                        subject_string[i++] = item.getName();
                    }
                    ArrayAdapter classAdapter = new ArrayAdapter(myActivity, R.layout.row_spn_dropdown, subject_string);
                    spTocommitLessonNotesSubject.setAdapter(classAdapter);
                    spTocommitLessonNotesSubject.setVisibility(View.VISIBLE);
                    subjectId = result_subject.get(0).getId();
                    subjectName = result_subject.get(0).getName();
                    if (first)
                        toLoadeDetailData();

                }
            }
        }, CustomApplication.userInfor.getSchoolId());
    }

    private void toLoadeDetailData() {

        showProgressDialog("正在加载...");
        DataAchieve.toGetMyLesssonNotesDeatil(new DataAchieve.SuccessCallBack() {


                                                  @Override
                                                  public void handle(int code, Object object) {
                                                      if (code != 1000) {
                                                          dismissProgressDialog();
                                                          return;
                                                      } else {
                                                          result = ((MyLesssonNotesDeatilBean)
                                                                  object).getResults();
                                                          if (result != null) {
                                                              showMyLessonNotesDetailData();
                                                          }
                                                          dismissProgressDialog();
                                                      }
                                                  }
                                              }, lessonNotesId, ToolString.getStringOfEncoder(CustomApplication.userInfor.getRealName()),
                CustomApplication
                        .userInfor
                        .getRemarkId());
    }

    private void loadeClassData(String gradeId) {
        DataAchieve.getOfOneGradeClassList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                if (code != 1000) {
                    return;
                }
                if (object != null) {
                    result_class = ((OfOneGradeAllClassBean
                            ) object).getResults();
                    int i = 0;
                    class_string = new String[result_class.size()];
                    for (OfOneGradeAllClassBean
                            .ResultsBean item : result_class) {
                        class_string[i++] = item.getName();
                    }
                    ArrayAdapter classAdapter = new ArrayAdapter(myActivity, R.layout
                            .row_spn_dropdown, class_string);
                    spTocommitLessonNotesLessonclass.setAdapter(classAdapter);
                    spTocommitLessonNotesLessonclass.setVisibility(View.VISIBLE);
                    className = result_class.get(0).getName();
                    classId = result_class.get(0).getId();
                }
            }
        }, gradeId);
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
                        toCommitAction("1");
                    }
                });
                alert.setMessage("请选择提交还是保存草稿");
                alert.setNegativeButton("保存草稿", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toCommitAction("0");
                    }
                });
                alert.create().show();

                break;
            case R.id.et_tocommit_lesson_notes_lessontime:
                pvTime.show();
        }
    }

    private void toCommitAction(String submitus) {
        lessonTitle = spTocommitLessonNotesLessonname.getText().toString();
        lessonType = etTocommitLessonNotesLessontype.getText().toString();
        lessonContext = etTocommitLessonNotesLessonrecord.getText().toString();
        lessonAdvice = etTocommitLessonNotesLessonanalysis.getText().toString();
        teachingTime = etTocommitLessonNotesLessontime.getText().toString();
        if (teachingTime != null && !teachingTime.equals("")) {
            String[] date = teachingTime.split("-");
            month = date[0];
            day = date[1];

        }
        num = etTocommitLessonNotesLessontimePart.getText().toString();
        lessonTeacher = etTocommitLessonNotesTeachername.getText().toString();
        if ((subjectId == null
                || lessonTeacher == null
                || subjectName == null
                || lessonTitle == null
                || lessonType == null
                || gradeId == null
                || gradeName == null
                || classId == null
                || className == null
                || lessonContext == null
                || lessonAdvice == null
                || month == null
                || day == null
                || num == null) || (subjectId.equals("")
                || subjectName.equals("")
                || lessonTitle.equals("")
                || lessonType.equals("")
                || gradeId.equals("")
                || gradeName.equals("")
                || classId.equals("")
                || className.equals("")
                || lessonContext.equals("")
                || lessonAdvice.equals("")
                || month.equals("")
                || day.equals("")
                || lessonTeacher.equals("")
                || num.equals(""))) {
            TooSnackbar.showMessage(coor_lesson_notes, "请填写完整");
            return;
        }

        showProgressDialog("正在提交");
        DataAchieve.toCommitLessonNotes(new DataAchieve.SuccessCallBack() {
                                            @Override
                                            public void handle(int code, Object object) {
                                                if (code != 1000) {

                                                    dismissProgressDialog();
                                                    return;
                                                }
                                                if (code == 1000) {
                                                    TooSnackbar.showMessage(coor_lesson_notes,
                                                            "提交成功");
                                                    dismissProgressDialog();
                                                    final AlertDialog.Builder alert = new AlertDialog
                                                            .Builder(myActivity);

                                                    alert.setPositiveButton("留在此页面", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialogInterface, int i) {

                                                        }
                                                    });
                                                    alert.setMessage("您的听课记录已完成提交");
                                                    alert.setNegativeButton("离开此页面", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialogInterface, int i) {
                                                            removeFragment();
                                                        }
                                                    });
                                                    alert.create().show();
                                                }
                                            }

                                        }, submitus, lessonNotesId, subjectId, subjectName, lessonTitle,
                lessonType, gradeId, gradeName, classId, className,
                lessonContext, lessonAdvice, month, day, num, lessonTeacher, CustomApplication
                        .userInfor
                        .getSchoolId
                                (), CustomApplication.userInfor.getUserId());
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
