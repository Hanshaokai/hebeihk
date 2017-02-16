package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlenotifi;


import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rey.material.widget.Button;
import com.rey.material.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.NotifiActivity;
import cn.huischool.huixiao.bean.AllGradeBean;
import cn.huischool.huixiao.bean.AllLeaderBean;
import cn.huischool.huixiao.bean.AllSubjectBean;
import cn.huischool.huixiao.bean.OfOneGradeAllClassBean;
import cn.huischool.huixiao.bean.OfOneGradeTeacherBean;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/5/20.
 */
public class TosendNotifiFragment extends BaseFragment {

    private ImageButton imagbtn_action_clude;
    private Toolbar toolbar_clude;
    private EditText tv_tosend_notifi_content;
    private Button tv_tosend_notifi_receiname;
    private EditText tv_tosend_notifi_title;
    private TextView tv_title_clude;
    private NotifiActivity myActivity;

    private LayoutInflater inflater;
    private View view;
    private NestedScrollView nsv_tosend_notifi_scroll;

    //发送通知参数userContext
    String userId = CustomApplication.userInfor.getUserId();
    String schoolId = CustomApplication.userInfor.getSchoolId();
    String remarkId;
    //发通知参数notice
    private String title;
    private String content;
    private String sendeeType;
    private String sendeeIds;
    //发通知参数
    private String gradeId1;//按年级发送 年级参数

    private String gradeId2;//按班级发送 年级参数
    private String classId1;//按班级发送 班级参数

    private String gradeId3;//按年级与学科发送 年级参数
    private String subjectId1;//按年级与学科发送 学科参数

    private String subjectId2;//按学科发送 学科参数


    private String gradeId4;//所在年级单个教师

    //年级 班级 学科 领导 教师
    private List<String> grade_list;//本校所有年级
    private List<String> class_list;//指定年级所有班级
    private List<String> subject_list;//本校所有学科
    private List<String> allLeader;//本校所有领导
    private List<String> grade_teacher;//指定年级所有教师

    private Spinner spinner_tosend_notifi_item1;
    private Spinner spinner_tosend_notifi_item2;
    private Spinner spinner_tosend_notifi_item3;
    private String[] sendeeTypeAll;
    private List<AllLeaderBean.ResultsBean> resultAllLeader;
    private List<AllGradeBean.ResultsBean> resultAllGrade;
    private List<OfOneGradeTeacherBean.ResultsBean> resultOfOneGradeTeacher;
    private List<OfOneGradeAllClassBean.ResultsBean> resultOfOneGradeClass;
    private List<AllSubjectBean.ResultsBean> resultAllSubject;


    @Override
    public View initView(LayoutInflater inflater) {
        this.inflater = inflater;
        myActivity = (NotifiActivity) ct;
        view = inflater.inflate(R.layout.fragment_tosendnotifi_notifi, null, false);
        nsv_tosend_notifi_scroll = (NestedScrollView) view.findViewById(R.id.nsv_tosend_notifi_scroll);
        imagbtn_action_clude = (ImageButton) view.findViewById(R.id.imagbtn_action_clude);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        tv_tosend_notifi_content = (EditText) view.findViewById(R.id.tv_tosend_notifi_content);
        tv_tosend_notifi_receiname = (Button) view.findViewById(R.id.tv_tosend_notifi_receiname);
        tv_tosend_notifi_title = (EditText) view.findViewById(R.id.tv_tosend_notifi_title);

        spinner_tosend_notifi_item1 = (Spinner) view.findViewById(R.id
                .spinner_tosend_notifi_item1);

        spinner_tosend_notifi_item2 = (Spinner) view.findViewById(R.id
                .spinner_tosend_notifi_item2);

        spinner_tosend_notifi_item3 = (Spinner) view.findViewById(R.id
                .spinner_tosend_notifi_item3);
        return view;


    }

    @Override
    public void initData(Bundle savedInstanceState) {
        List<String> sendeeType1list = new ArrayList<String>();
        sendeeTypeAll = new String[]{"", "all", "allLeader",
                "allTeacher", "oneLeader", "oneTeacher", "grade", "gradeAndclass", "subject", "gradeAndsubject"};
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_clude,true,"新建通知",R.mipmap.ic_done_white_24dp,true);
        setListener();
    }

    private void setListener() {
        tv_tosend_notifi_receiname.setOnClickListener(this);
        imagbtn_action_clude.setOnClickListener(this);

        spinner_tosend_notifi_item1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:
                        sendeeType = sendeeTypeAll[position];
                        spinner_tosend_notifi_item2.setVisibility(View.GONE);
                        spinner_tosend_notifi_item3.setVisibility(View.GONE);
                        break;
                    case 1:
                        sendeeType = sendeeTypeAll[position];
                        spinner_tosend_notifi_item2.setVisibility(View.GONE);
                        spinner_tosend_notifi_item3.setVisibility(View.GONE);
                        break;
                    case 2:
                        sendeeType = sendeeTypeAll[position];
                        spinner_tosend_notifi_item2.setVisibility(View.GONE);
                        spinner_tosend_notifi_item3.setVisibility(View.GONE);
                        break;
                    case 3:
                        sendeeType = sendeeTypeAll[position];
                        spinner_tosend_notifi_item2.setVisibility(View.GONE);
                        spinner_tosend_notifi_item3.setVisibility(View.GONE);
                        break;
                    case 4:
                        sendeeType = sendeeTypeAll[position];
                        spinner_tosend_notifi_item2.setVisibility(View.GONE);
                        spinner_tosend_notifi_item3.setVisibility(View.GONE);
                        sendeeIds = "";
                        DataAchieve.getAllLeaderList(new DataAchieve.SuccessCallBack() {
                            @Override
                            public void handle(int code, Object object) {
                                if (code != 1000) {
                                    return;
                                }

                                resultAllLeader = ((AllLeaderBean
                                        )
                                        object).getResults();

                                if (resultAllLeader != null) {
                                    int leaderCount = resultAllLeader.size();
                                    spinner_tosend_notifi_item2.setVisibility(View.VISIBLE);
                                    String[] leaderString = new String[leaderCount + 1];
                                    leaderString[0] = "领导";
                                    for (int i = 0; i < leaderCount; i++) {
                                        leaderString[i + 1] = resultAllLeader.get(i).getRealName();
                                    }
                                    ArrayAdapter<String> adapterLeader = new ArrayAdapter<String>
                                            (myActivity, android.R.layout.simple_spinner_item, leaderString);
                                    spinner_tosend_notifi_item2.setAdapter(adapterLeader);
                                }


                            }
                        }, userId, schoolId);


                        break;
                    case 5:
                        sendeeType = sendeeTypeAll[position];
                        LogUtil.d(sendeeType);
                        sendeeIds = "";
                        try {
                            spinner_tosend_notifi_item2.setVisibility(View.GONE);
                            spinner_tosend_notifi_item3.setVisibility(View.GONE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        DataAchieve.getAllGradeList(new DataAchieve.SuccessCallBack() {
                            @Override
                            public void handle(int code, Object object) {

                                if (code != 1000) {
                                    return;
                                }

                                try {
                                    resultAllGrade = ((AllGradeBean
                                            )
                                            object).getResults();

                                    if (resultAllGrade != null) {
                                        int gradeCount = resultAllGrade.size();
                                        spinner_tosend_notifi_item2.setVisibility(View.VISIBLE);
                                        String[] allGradeString = new String[gradeCount + 1];
                                        allGradeString[0] = "教师所在年级";
                                        for (int i = 0; i < gradeCount; i++) {
                                            allGradeString[i + 1] = resultAllGrade.get(i).getName();
                                        }
                                        ArrayAdapter<String> adapterAllGrade = new ArrayAdapter<String>
                                                (myActivity, android.R.layout.simple_spinner_item, allGradeString);
                                        spinner_tosend_notifi_item2.setAdapter(adapterAllGrade);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        }, schoolId);
                        break;

                    case 6:
                        sendeeType = sendeeTypeAll[position];

                        spinner_tosend_notifi_item2.setVisibility(View.GONE);
                        spinner_tosend_notifi_item3.setVisibility(View.GONE);
                        DataAchieve.getAllGradeList(new DataAchieve.SuccessCallBack() {
                            @Override
                            public void handle(int code, Object object) {

                                if (code != 1000) {
                                    return;
                                }

                                resultAllGrade = (List<AllGradeBean
                                        .ResultsBean>)
                                        object;

                                if (resultAllGrade != null) {
                                    int gradeCount = resultAllGrade.size();
                                    spinner_tosend_notifi_item2.setVisibility(View.VISIBLE);
                                    String[] allGradeString = new String[gradeCount + 1];
                                    allGradeString[0] = "年级";
                                    for (int i = 0; i < gradeCount; i++) {
                                        allGradeString[i + 1] = resultAllGrade.get(i).getName();
                                    }
                                    ArrayAdapter<String> adapterAllGrade = new ArrayAdapter<String>
                                            (myActivity, android.R.layout.simple_spinner_item, allGradeString);
                                    spinner_tosend_notifi_item2.setAdapter(adapterAllGrade);
                                }

                            }
                        }, schoolId);
                        break;


                    case 7:
                        sendeeType = sendeeTypeAll[position];

                        spinner_tosend_notifi_item2.setVisibility(View.GONE);
                        spinner_tosend_notifi_item3.setVisibility(View.GONE);
                        DataAchieve.getAllGradeList(new DataAchieve.SuccessCallBack() {
                            @Override
                            public void handle(int code, Object object) {

                                if (code != 1000) {
                                    return;
                                }

                                resultAllGrade = (List<AllGradeBean
                                        .ResultsBean>)
                                        object;

                                if (resultAllGrade != null) {
                                    int gradeCount = resultAllGrade.size();
                                    spinner_tosend_notifi_item2.setVisibility(View.VISIBLE);
                                    String[] allGradeString = new String[gradeCount + 1];
                                    allGradeString[0] = "班级所在年级";
                                    for (int i = 0; i < gradeCount; i++) {
                                        allGradeString[i + 1] = resultAllGrade.get(i).getName();
                                    }
                                    ArrayAdapter<String> adapterAllGrade = new ArrayAdapter<String>
                                            (myActivity, android.R.layout.simple_spinner_item, allGradeString);
                                    spinner_tosend_notifi_item2.setAdapter(adapterAllGrade);
                                }

                            }
                        }, schoolId);
                        break;

                    case 8:
                        sendeeType = sendeeTypeAll[position];

                        spinner_tosend_notifi_item2.setVisibility(View.GONE);
                        spinner_tosend_notifi_item3.setVisibility(View.GONE);
                        DataAchieve.getAllSubjectList(new DataAchieve.SuccessCallBack() {
                            @Override
                            public void handle(int code, Object object) {

                                if (code != 1000) {
                                    return;
                                }

                                resultAllSubject = ((AllSubjectBean
                                        )
                                        object).getResults();

                                if (resultAllSubject != null) {
                                    int SubjectCount = resultAllSubject.size();
                                    spinner_tosend_notifi_item2.setVisibility(View.VISIBLE);
                                    String[] allSubjectString = new String[SubjectCount + 1];
                                    allSubjectString[0] = "学科";
                                    for (int i = 0; i < SubjectCount; i++) {
                                        allSubjectString[i + 1] = resultAllSubject.get(i).getName();
                                    }
                                    ArrayAdapter<String> adapterAllSubject = new
                                            ArrayAdapter<String>
                                            (myActivity, android.R.layout.simple_spinner_item, allSubjectString);
                                    spinner_tosend_notifi_item2.setAdapter(adapterAllSubject);
                                }

                            }
                        }, schoolId);
                        break;

                    case 9:
                        sendeeType = sendeeTypeAll[position];

                        spinner_tosend_notifi_item2.setVisibility(View.GONE);
                        spinner_tosend_notifi_item3.setVisibility(View.GONE);
                        DataAchieve.getAllGradeList(new DataAchieve.SuccessCallBack() {
                            @Override
                            public void handle(int code, Object object) {

                                if (code != 1000) {
                                    return;
                                }

                                resultAllGrade = (List<AllGradeBean
                                        .ResultsBean>)
                                        object;

                                if (resultAllGrade != null) {
                                    int gradeCount = resultAllGrade.size();
                                    spinner_tosend_notifi_item2.setVisibility(View.VISIBLE);
                                    String[] allGradeString = new String[gradeCount + 1];
                                    allGradeString[0] = "学科所在年级";
                                    for (int i = 0; i < gradeCount; i++) {
                                        allGradeString[i + 1] = resultAllGrade.get(i).getName();
                                    }
                                    ArrayAdapter<String> adapterAllGrade = new ArrayAdapter<String>
                                            (myActivity, android.R.layout.simple_spinner_item, allGradeString);
                                    spinner_tosend_notifi_item2.setAdapter(adapterAllGrade);
                                }

                            }
                        }, schoolId);
                        break;

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_tosend_notifi_item2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                    return;
                }

                switch (parent.getItemAtPosition(0).toString()) {
                    case "领导":

                        if (position != 0) {
                            sendeeIds = resultAllLeader.get(position - 1).getId();
                        }

                        break;
                    case "教师所在年级":

                        if (position != 0) {
                            gradeId4 = resultAllGrade.get(position).getId();
                        }


                        DataAchieve.getOfOneGradeTeacherList(new DataAchieve.SuccessCallBack() {
                            @Override
                            public void handle(int code, Object object) {

                                resultOfOneGradeTeacher =( (OfOneGradeTeacherBean
                                        )
                                        object).getResults();

                                if (resultOfOneGradeTeacher != null) {
                                    spinner_tosend_notifi_item3.setVisibility(View.VISIBLE);
                                    int OfOneGradeTeacherCount = resultOfOneGradeTeacher.size();

                                    String[] OfOneGradeTeacherString = new String[OfOneGradeTeacherCount + 1];
                                    OfOneGradeTeacherString[0] = "教师";
                                    for (int i = 0; i < OfOneGradeTeacherCount; i++) {
                                        OfOneGradeTeacherString[i + 1] = resultOfOneGradeTeacher.get(i).getRealName();
                                    }
                                    ArrayAdapter<String> OfOneGradeTeacher = new ArrayAdapter<String>
                                            (myActivity, android.R.layout.simple_spinner_item, OfOneGradeTeacherString);

                                    spinner_tosend_notifi_item3.setAdapter(OfOneGradeTeacher);
                                }


                            }
                        }, gradeId4);
                        break;
                    case "年级":
                       /* if (position == 0) {
                            sendeeIds = "";
                        }*/

                        if (position != 0) {
                            gradeId1 = resultAllGrade.get(position - 1).getId();
                        }

                        break;


                    case "班级所在年级":
                       /* if (position == 0) {
                            sendeeIds = "";
                        }*/

                        if (position != 0) {
                            gradeId2 = resultAllGrade.get(position - 1).getId();
                        }
                        DataAchieve.getOfOneGradeClassList(new DataAchieve.SuccessCallBack() {
                            @Override
                            public void handle(int code, Object object) {

                                resultOfOneGradeClass = ((OfOneGradeAllClassBean
                                        )
                                        object).getResults();

                                if (resultOfOneGradeClass != null) {
                                    spinner_tosend_notifi_item3.setVisibility(View.VISIBLE);
                                    int OfOneGradeClassCount = resultOfOneGradeClass.size();

                                    String[] OfOneGradeClassString = new
                                            String[OfOneGradeClassCount + 1];
                                    OfOneGradeClassString[0] = "班级";
                                    for (int i = 0; i < OfOneGradeClassCount; i++) {
                                        OfOneGradeClassString[i + 1] = resultOfOneGradeClass.get
                                                (i).getName();
                                    }
                                    ArrayAdapter<String> OfOneGradeClass = new ArrayAdapter<String>
                                            (myActivity, android.R.layout.simple_spinner_item, OfOneGradeClassString);

                                    spinner_tosend_notifi_item3.setAdapter(OfOneGradeClass);
                                }


                            }
                        }, gradeId4);
                        break;

                    case "学科":
                       /* if (position == 0) {
                            sendeeIds = "";
                        }*/

                        if (position != 0) {
                            subjectId1 = resultAllSubject.get(position - 1).getId();
                        }

                        break;

                    case "学科所在年级":

                        if (position != 0) {
                            gradeId3 = resultAllGrade.get(position).getId();
                        }


                        DataAchieve.getAllSubjectList(new DataAchieve.SuccessCallBack() {
                            @Override
                            public void handle(int code, Object object) {

                                if (code != 1000) {
                                    return;
                                }

                                resultAllSubject = ((AllSubjectBean
                                        )
                                        object).getResults();

                                if (resultAllSubject != null) {
                                    int SubjectCount = resultAllSubject.size();
                                    spinner_tosend_notifi_item3.setVisibility(View.VISIBLE);
                                    String[] allSubjectString = new String[SubjectCount + 1];
                                    allSubjectString[0] = "学科";
                                    for (int i = 0; i < SubjectCount; i++) {
                                        allSubjectString[i + 1] = resultAllSubject.get(i).getName();
                                    }
                                    ArrayAdapter<String> adapterAllSubject = new
                                            ArrayAdapter<String>
                                            (myActivity, android.R.layout.simple_spinner_item, allSubjectString);
                                    spinner_tosend_notifi_item3.setAdapter(adapterAllSubject);
                                }

                            }
                        }, schoolId);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner_tosend_notifi_item3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                    return;
                }
                switch (parent.getItemAtPosition(0).toString()) {

                    case "教师":

                        if (position != 0) {
                            sendeeIds = resultOfOneGradeTeacher.get(position - 1).getId();
                        }
                        break;

                    case "班级":

                        if (position != 0) {
                            classId1 = resultOfOneGradeClass.get(position - 1).getId();
                        }
                        break;
                    case "学科":

                        if (position != 0) {
                            subjectId2 = resultAllSubject.get(position - 1).getId();
                        }
                        break;


                }


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
            case R.id.tv_tosend_notifi_receiname:
              /* FragmentChangeHelper helper = new FragmentChangeHelper(new SpinnerFragment());

                ChangeFragmentUtils.changeFragment(helper, myActivity.getSupportFragmentManager
                        (), R.id
                        .online_notifi_container_above);
*/

                break;
            case R.id.imagbtn_action_clude:


                toSendNotifi();


                break;
        }
    }


    private void toSendNotifi() {
        title = tv_tosend_notifi_title.getText().toString();
        content = tv_tosend_notifi_content.getText().toString();
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(content)) {
            Toast.makeText(myActivity, "请填写完整", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(sendeeType)) {

            Toast.makeText(myActivity, "请选择发送人", Toast.LENGTH_SHORT).show();
            return;
        }


        showProgressDialog("正在发布");
        DataAchieve.toSendNotifi(new DataAchieve.SuccessCallBack() {
                                     @Override
                                     public void handle(int code, Object object) {
                                         if (code != 1000) {
                                             return;
                                         }
                                         Toast.makeText(myActivity, "发布成功", Toast.LENGTH_SHORT).show();
                                         dismissProgressDialog();
                                     }
                                 }, userId, schoolId, title, content, sendeeType, sendeeIds, gradeId1, gradeId2, classId1,
                gradeId3, subjectId2, subjectId1, gradeId4, "1");


    }


}



