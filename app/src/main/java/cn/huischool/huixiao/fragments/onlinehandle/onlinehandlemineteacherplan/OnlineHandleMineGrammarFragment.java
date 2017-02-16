package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlemineteacherplan;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.AbsCallback;
import com.lzy.okhttputils.model.HttpParams;
import com.lzy.okhttputils.request.BaseRequest;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.ProgressView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.BuildConfig;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.adapters.onlinehandle.MyGrammerAdapter;
import cn.huischool.huixiao.bean.MyTeacherPlanBean;
import cn.huischool.huixiao.bean.ToSendCompleteBean;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.TooSnackbar;
import cn.huischool.huixiao.common.utils.ToolFile;
import cn.huischool.huixiao.common.utils.ToolToast;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.DividerItemDecoration;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.LoadeMoreRecyclerOnScrollListener;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;
import cn.huischool.huixiao.framework.network.ServerInterfaceDefinition;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by ${han} on 2016/7/8.
 */
public class OnlineHandleMineGrammarFragment extends BaseFragment {
    AppCompatActivity myActivity;
    private RecyclerView recycler_my_teacher_plan_online;
    private SwipeRefreshLayout swip_my_teacher_plan_online;
    private TextView tv_title_clude;
    private Toolbar toolbar_clude;
    private LinearLayoutManager layoutManager;
    private List<MyTeacherPlanBean.ResultsBean.ElementsBean> myGrammerElementsList = new
            ArrayList<MyTeacherPlanBean.ResultsBean.ElementsBean>();
    private MyGrammerAdapter adapter;
    private CoordinatorLayout coor_my_teacher_plan_online;
    private LoadeMoreRecyclerOnScrollListener loadeMore;
    private int currentPageOfLoade;
    private ImageView imagbtn_action_clude;
    String subjectType;
    private String fileName;
    private File grmmarfile;
    private int gradePosition;
    private int subjectPosition;
    private String gradeId;
    private String subjectId;
    private EditText etThemenameGrammarItem;
    private TextView tvChoosefileNameGrammarItem;
    private TextView tv_progresspercent_grammar_item;
    private ProgressView pv_progress_grammmar_item;
    private BottomSheetDialog chooseFileDialog;
    private Spinner radioSubjectcontainerGrammraItem;
    private String ischecked = "";
    private String userId;
    //是否已批阅（0未批阅1已批阅“”全部）
    private String lessonType = "";//根据 权限 查看 提交的 或全部
    //是否已提交（0未提交 1提交 "" 全部）
    public static OnlineHandleMineGrammarFragment newInstance(String lessonType, String whose,
                                                              String userId) {
        Bundle args = new Bundle();
        args.putSerializable("lessonType", lessonType);
        args.putSerializable("whose", whose);
        args.putSerializable("userId", userId);
        OnlineHandleMineGrammarFragment fragment = new OnlineHandleMineGrammarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_handle_grammar, null, false);
        myActivity = baseFragmentActivity;
        recycler_my_teacher_plan_online = (RecyclerView) view.findViewById(R.id.recycler_my_teacher_plan_online);
        swip_my_teacher_plan_online = (SwipeRefreshLayout) view.findViewById(R.id.swip_my_teacher_plan_online);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        imagbtn_action_clude = (ImageView) view.findViewById(R.id.imagbtn_action_clude);
        coor_my_teacher_plan_online = (CoordinatorLayout) view.findViewById(R.id
                .coor_my_teacher_plan_online);
        return view;
    }
    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        lessonType = getArguments().getString("lessonType", "");
        String who=getArguments().getString("whose", "");
         userId=getArguments().getString("userId");
        if (who.equals("")) {
            initToolBar(toolbar_clude, true, "我的教案", R.mipmap.fab_add, true);
        } else {
            initToolBar(toolbar_clude, true, who+"的教案", -1, false);
        }
        setSwip();
        recyclGrammerSetAdpater();
        if (myGrammerElementsList.size() == 0) {
            showProgressDialog("正在加载");
            MyGrammarLoad("1");
        }
        setOnGrammarClickLisner();
    }
    private void setSwip() {
        swip_my_teacher_plan_online.setSize(SwipeRefreshLayout.DEFAULT);
        swip_my_teacher_plan_online.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        swip_my_teacher_plan_online.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                LogUtil.d("刷新操作" + currentPageOfLoade);
                MyGrammarLoad("1");
            }
        });
    }
    private void MyGrammarLoad(final String page) {
        LogUtil.d("加载页数加载前" + page);
        DataAchieve.togetMyTeacherPlanList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                {
                    if (code != 1000) {
                        dismissProgressDialog();
                        if (swip_my_teacher_plan_online.isRefreshing()) {

                            swip_my_teacher_plan_online.setRefreshing(false);
                        }
                        return;
                    } else {
                        MyTeacherPlanBean.ResultsBean ments = ((MyTeacherPlanBean)
                                object).getResults();
                        if (ments != null) {
                            LogUtil.d("加载页数完成后" + page);
                            if (page.equals("1")) {
                                loadeMore.setCurrentPage(1);
                                currentPageOfLoade = 1;
                                if (CollectionUtils.isListNull(ments.getElements())) {
                                    TooSnackbar.showMessage(coor_my_teacher_plan_online, "还未上传教案");
                                } else {
                                    loadeMore.setCurrentPage(++currentPageOfLoade);
                                }
                                myGrammerElementsList.clear();
                                myGrammerElementsList.addAll(ments.getElements
                                        ());
                                adapter.addList(myGrammerElementsList);
                                if (swip_my_teacher_plan_online.isRefreshing()) {
                                    swip_my_teacher_plan_online.setRefreshing(false);
                                }
                            } else {
                                if (CollectionUtils.isListNull(ments.getElements())) {
                                    TooSnackbar.showMessage(coor_my_teacher_plan_online,
                                            "没有更多的教案啦");
                                } else {
                                    loadeMore.setCurrentPage(++currentPageOfLoade);
                                }
                                myGrammerElementsList.addAll(ments.getElements
                                        ());
                                adapter.addList(myGrammerElementsList);
                            }
                            if (swip_my_teacher_plan_online.isRefreshing()) {

                                swip_my_teacher_plan_online.setRefreshing(false);
                            }
                        }
                        dismissProgressDialog();
                        if (swip_my_teacher_plan_online.isRefreshing()) {
                            swip_my_teacher_plan_online.setRefreshing(false);
                        }
                    }
                }
            }
        }, page, "8", userId, "", ischecked, lessonType);
    }

    private void setOnGrammarClickLisner() {
        imagbtn_action_clude.setOnClickListener(this);
        loadeMore = new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                currentPageOfLoade = currentPage;
                LogUtil.d("加载了更多");
                showProgressDialog("正在加载");
                MyGrammarLoad(currentPage + "");
            }
        };
        recycler_my_teacher_plan_online.addOnScrollListener(loadeMore);

        recycler_my_teacher_plan_online.addOnItemTouchListener(new OnRecyclerItemClickListener(recycler_my_teacher_plan_online,
                recycler_my_teacher_plan_online.getContext()) {//封装了为rescyler 封装了监听
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                addFragment(MineGrammarDetailFragment.newInstance(myGrammerElementsList.get(vh
                        .getAdapterPosition()).getId()));
            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {
            }
        });
    }

    private void recyclGrammerSetAdpater() {
        layoutManager = new LinearLayoutManager(myActivity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_my_teacher_plan_online.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        recycler_my_teacher_plan_online.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyGrammerAdapter(myActivity, myGrammerElementsList);
        recycler_my_teacher_plan_online.addItemDecoration(new DividerItemDecoration(ct, layoutManager
                .getOrientation()));
        recycler_my_teacher_plan_online.setAdapter(adapter);
    }

    /* @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            inflater.inflate(R.menu.notifi_actions, menu);

            super.onCreateOptionsMenu(menu, inflater);
        }*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                LogUtil.d("点击了返回");
                myGrammerElementsList.clear();
                removeFragment();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {
           /* case R.id.imagbtn_action_clude:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);*/
            //intent.setType("*/*");
            //  intent.addCategory(Intent.CATEGORY_OPENABLE);
                /*try {
                    startActivityForResult(Intent.createChooser(intent, "请选择您要上传的教案文件"), 1);
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), "没有文件选择器", Toast.LENGTH_SHORT)
                            .show();
                }*/

            case R.id.imagbtn_action_clude:
                showChooseFileDialog();


        }

    }

    private void showChooseFileDialog() {
        chooseFileDialog = new BottomSheetDialog(myActivity, R.style
                .Material_App_BottomSheetDialog);
        View chooseFileView = LayoutInflater.from(myActivity).inflate(R.layout
                .bottomsheet_choosefile_grammar_dialog, null);
        chooseFileDialog.heightParam(ViewGroup.LayoutParams.MATCH_PARENT);
        tv_progresspercent_grammar_item = (TextView) chooseFileView.findViewById(R.id
                .tv_progresspercent_grammar_item);
        pv_progress_grammmar_item = (ProgressView) chooseFileView.findViewById(R.id.pv_progress_grammmar_item);
        etThemenameGrammarItem = (EditText) chooseFileView.findViewById(R.id.et_themename_grammar_item);
        Spinner radioGradecontainerGrammraItem = (Spinner) chooseFileView.findViewById(R.id
                .spinner_gradecontainer_grammra_item);
        RadioGroup radio_textbookcontainer_grammra_item = (RadioGroup) chooseFileView.findViewById(R.id
                .radio_textbookcontainer_grammra_item);
        radioSubjectcontainerGrammraItem = (Spinner) chooseFileView.findViewById(R.id
                .spinner_subjectcontainer_grammra_item);
        RadioButton btnFirstVolumeGrammarItem = (RadioButton) chooseFileView.findViewById(R.id
                .btn_first_volume_grammar_item);
        RadioButton btnDownVolumeGrammarItem = (RadioButton) chooseFileView.findViewById(R.id
                .btn_down_volume_grammar_item);
        Button btnChoosefileGrammarItem = (Button) chooseFileView.findViewById(R.id
                .btn_choosefile_grammar_item);
        tvChoosefileNameGrammarItem = (TextView) chooseFileView.findViewById(R.id
                .tv_choosefile_name_grammar_item);
        Button btnSavefileGrammarItem = (Button) chooseFileView.findViewById(R.id.btn_savefile_grammar_item);
        Button btnSubmmitfileGrammarItem = (Button) chooseFileView.findViewById(R.id
                .btn_submmitfile_grammar_item);
        Button btnCancelGrammarItem = (Button) chooseFileView.findViewById(R.id.btn_cancel_grammar_item);
        chooseFileDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                LogUtil.d("bottom消失");
                subjectType = null;
                fileName = null;
                grmmarfile = null;
                gradeId = null;
                subjectId = null;
                etThemenameGrammarItem = null;
                tvChoosefileNameGrammarItem.setText("");
                OkHttpUtils.getInstance().cancelTag(this);
                chooseFileDialog = null;
            }
        });
        radio_textbookcontainer_grammra_item.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {

                switch (id) {
                    case R.id.btn_first_volume_grammar_item:
                        subjectType = "0";
                        break;
                    case R.id.btn_down_volume_grammar_item:
                        subjectType = "1";
                        break;
                }
            }
        });
        btnChoosefileGrammarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                try {
                    startActivityForResult(Intent.createChooser(intent, "请选择您要上传的教案文件"), 1);
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), "没有文件选择器", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
        btnSavefileGrammarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etThemenameGrammarItem.getText().toString() == null || etThemenameGrammarItem
                        .getText().toString()
                        .equals("")) {
                    Toast.makeText(myActivity, "请填写课题题目", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (subjectType == null ||
                        fileName == null ||
                        grmmarfile == null ||
                        gradeId == null ||
                        subjectId == null ||
                        tvChoosefileNameGrammarItem.getText().equals("")) {
                    Toast.makeText(myActivity, "请填写完整", Toast.LENGTH_SHORT).show();
                } else {
                    uplodFile(fileName, "0", gradeId, subjectId, subjectType, grmmarfile);
                }
            }
        });

        btnSubmmitfileGrammarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etThemenameGrammarItem.getText() == null || etThemenameGrammarItem.getText().equals
                        ("")) {

                    Toast.makeText(myActivity, "请填写课题题目", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (subjectType == null ||

                        fileName == null ||
                        grmmarfile == null ||
                        gradeId == null ||
                        subjectId == null ||

                        tvChoosefileNameGrammarItem.getText().equals("")) {

                    Toast.makeText(myActivity, "您未选择教材或者文件", Toast.LENGTH_SHORT).show();

                } else {
                    uplodFile(fileName, "1", gradeId, subjectId, subjectType, grmmarfile);

                }


            }
        });
        btnCancelGrammarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chooseFileDialog.dismiss();

            }
        });
        LogUtil.d(CustomApplication.userInfor.getDutyList().size() + "班级个数");

        int gradeCount = CustomApplication.userInfor.getDutyList().size();
        String[] stringGrade = new String[gradeCount];

        for (int i = 0; i < gradeCount; i++
                ) {
            stringGrade[i] = CustomApplication.userInfor.getDutyList().get(i).getGradeName();
        }//显示所交班级
        radioGradecontainerGrammraItem.setAdapter(new ArrayAdapter<String>(myActivity, android.R.layout.simple_spinner_item, stringGrade));
        radioGradecontainerGrammraItem.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                LogUtil.d("onItemSelected第一此加载adapter就会执行");
                gradePosition = position;
                LogUtil.d(position + "");
                gradeId = CustomApplication.userInfor.getDutyList().get(gradePosition)
                        .getGradeId();
                int subjectCount = CustomApplication.userInfor
                        .getDutyList().get(gradePosition).getSubList().size();
                String[] subjectString = new String[subjectCount];
                for (int i = 0; i < subjectCount; i++
                        ) {
                    subjectString[i] = CustomApplication.userInfor.getDutyList().get
                            (gradePosition).getSubList().get(i).getSubName();
                }


                radioSubjectcontainerGrammraItem.setAdapter(new ArrayAdapter<String>(myActivity, android.R.layout.simple_spinner_item, subjectString));
                ///

                subjectId = CustomApplication.userInfor.getDutyList().get(gradePosition)
                        .getSubList().get(0).getSubjectId();//默认第一个
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {//
                LogUtil.d("onNothingSelected第一执行看");
            }


            //第三方radiobutton没单选效果


        });
        radioSubjectcontainerGrammraItem.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long
                    l) {
                subjectPosition = position;
                LogUtil.d(position + "科目");
                LogUtil.d(subjectPosition + "科目");
                subjectId = CustomApplication.userInfor.getDutyList().get(gradePosition)
                        .getSubList().get(subjectPosition).getSubjectId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        chooseFileDialog.contentView(chooseFileView).show();
    }

    public void uplodFile(String lessonName, String lessonType, String gradeId, String subjectId,
                          String subjectType, File file) {

        HttpParams httpParams = new HttpParams();
        httpParams.put("lessonId", "");
        httpParams.put("lessonName", etThemenameGrammarItem.getText().toString());
        httpParams.put("lessonType", lessonType);
        httpParams.put("userId", CustomApplication.userInfor.getUserId());
        httpParams.put("schoolId", CustomApplication.userInfor.getSchoolId());
        httpParams.put("gradeId", gradeId);
        httpParams.put("subjectId", subjectId);
        httpParams.put("subjectType", subjectType);
        OkHttpUtils.post(BuildConfig.URL + ServerInterfaceDefinition.OPT_UPLODEGRMMARFILE.getOpt
                ())
                .tag(this)
                .params(httpParams)
                .params(fileName
                        , file)
                .execute(new AbsCallback<ToSendCompleteBean>() {


                    @Override
                    public ToSendCompleteBean parseNetworkResponse(Response response) throws Exception {
                        LogUtil.d(response.body().toString());
                        return JSONObject.parseObject(response.body().string(), ToSendCompleteBean.class);

                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        super.upProgress(currentSize, totalSize, progress, networkSpeed);
                        LogUtil.d("速度" + networkSpeed + "进度" + progress);
                        pv_progress_grammmar_item.setProgress(progress * 100);
                        tv_progresspercent_grammar_item.setText(progress * 100 + "%");
                    }

                    @Override
                    public void onSuccess(ToSendCompleteBean toSendCompleteBean, Call call, Response response) {

                        LogUtil.d(response.body().toString());
                        if (toSendCompleteBean.code == 1000) {
                            Toast.makeText(myActivity, "上传成功", Toast.LENGTH_SHORT).show();
                            chooseFileDialog.dismiss();
                            swip_my_teacher_plan_online.setRefreshing(true);
                            MyGrammarLoad("1");//刷新界面

                        } else {
                            Toast.makeText(myActivity, toSendCompleteBean.message, Toast
                                    .LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);

                        LogUtil.d("上传参数" + request.toString() + "  " + request.getParams().toString());
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        LogUtil.d("发回信息" + response.body().toString());
                        Toast.makeText(myActivity, "上传出错", Toast.LENGTH_SHORT).show();

                        dismissProgressDialog();
                        call.cancel();
                    }
                });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == myActivity.RESULT_CANCELED)
            return;
        //得到文件地址
        Uri uri = data.getData();
        if (uri.getPath() == null || uri.getPath().equals("")) {
            Toast.makeText(myActivity, "未上传文件",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        String url;
        try {
            url = uri.getPath();
            LogUtil.d(url + "文件地址");
            fileName = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));

            grmmarfile = new File(url);
            if (!ToolFile.getFileExtension(grmmarfile).equals("doc") && !ToolFile.getFileExtension
                    (grmmarfile).equals("docx")) {
                ToolToast.showShortTimeMsg("您需要选择doc或者docx格式的文件");
                fileName = null;
                return;
            }
            if (grmmarfile.isFile() && grmmarfile.exists()) {
                tvChoosefileNameGrammarItem.setText(url);

            } else {
                Toast.makeText(myActivity, "未上传文件", Toast.LENGTH_SHORT).show();
                return;
            }
        } catch (Exception e) {
        }


    }


}
