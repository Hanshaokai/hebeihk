package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlemycourseware;

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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import com.rey.material.widget.ImageButton;
import com.rey.material.widget.ProgressView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.BuildConfig;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.MyCourseWareActivity;
import cn.huischool.huixiao.adapters.onlinehandle.MyCourseWareAdapter;
import cn.huischool.huixiao.bean.MyCourseWareBean;
import cn.huischool.huixiao.bean.RelatedGrammarListBean;
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
 * Created by ${han} on 2016/7/14.
 */
public class OnlineHandleMineCourseWareFragment extends BaseFragment {
    AppCompatActivity myActivity;
    private RecyclerView recycler_my_courseware_online;
    private SwipeRefreshLayout swip_my_courseware_online;
    private TextView tv_title_clude;
    private Toolbar toolbar_clude;
    private LinearLayoutManager layoutManager;
    private List<MyCourseWareBean.ResultsBean.ElementsBean> myCourseWareElementsList = new
            ArrayList<MyCourseWareBean.ResultsBean.ElementsBean>();
    private MyCourseWareAdapter adapter;
    private CoordinatorLayout cool_my_courseware_online;
    private LoadeMoreRecyclerOnScrollListener loadeMore;
    private int currentPageOfLoade;
    private ImageButton imagbtn_action_clude;
    private BottomSheetDialog chooseFileDialog;
    private TextView tvChoosefileNameCourseWareItem;
    private Spinner radioSubjectcontainerCourseWareItem;
    private EditText etThemenameCourseWareItem;

    private int gradePosition;
    private int subjectPosition;
    private String gradeId;
    private String subjectId;
    String subjectType;
    String lessonId;

    private String fileName;
    private File coursewarefile;
    private ProgressView pv_progress_courseware_item;
    private TextView tv_progresspercent_courseware_item;
    private Boolean isOrAdaterGrammar = false;
    private LinearLayout ly_adapter_grammarlist_item;
    private Spinner spinner_adapter_grammarlist_item;
    private List<RelatedGrammarListBean.ResultsBean> reatedGrammarList;
    private String[] grammarString;
    private String userId;
    //是否已批阅（0未批阅1已批阅“”全部）
    private String coursewareType = "";//根据 权限 查看 提交的 或全部

    //是否已提交（0未提交 1提交 "" 全部）
    public static OnlineHandleMineCourseWareFragment newInstance(String coursewareType, String whose,
                                                                 String userId) {

        Bundle args = new Bundle();
        args.putSerializable("coursewareType", coursewareType);
        args.putSerializable("whose", whose);
        args.putSerializable("userId", userId);
        OnlineHandleMineCourseWareFragment fragment = new OnlineHandleMineCourseWareFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View initView(LayoutInflater inflater) {


        view = inflater.inflate(R.layout.fragment_handle_courseware, null, false);
        myActivity = baseFragmentActivity;
        recycler_my_courseware_online = (RecyclerView) view.findViewById(R.id.recycler_my_courseware_online);
        swip_my_courseware_online = (SwipeRefreshLayout) view.findViewById(R.id.swip_my_courseware_online);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        imagbtn_action_clude = (ImageButton) view.findViewById(R.id.imagbtn_action_clude);
        cool_my_courseware_online = (CoordinatorLayout) view.findViewById(R.id
                .cool_my_courseware_online);
        return view;


    }

    @Override
    public void initData(Bundle savedInstanceState) {
        coursewareType = getArguments().getString("coursewareType", "");
        String who = getArguments().getString("whose", "");
        userId = getArguments().getString("userId");
        if (who.equals("")) {
            initToolBar(toolbar_clude, true, "我的课件", R.mipmap.fab_add, true);
        } else {
            initToolBar(toolbar_clude, true, who + "的课件", -1, false);
        }

        setHasOptionsMenu(true);//不设置 导致不起作用
        setSwip();
        recyclCoursewareSetAdpater();
        if (myCourseWareElementsList.size() == 0) {
            showProgressDialog("正在加载");
            MyCourseWareLoad("1");
        }
        setOnCourseWareClickLisner();
    }


    private void setSwip() {

        swip_my_courseware_online.setSize(SwipeRefreshLayout.DEFAULT);
        swip_my_courseware_online.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        swip_my_courseware_online.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                MyCourseWareLoad("1");

            }
        });

    }

    private void MyCourseWareLoad(final String page) {

        DataAchieve.togetMyCourseWareList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                Log.d("onlineMincourse", coursewareType);
                {
                    if (code != 1000) {
                        dismissProgressDialog();
                        return;

                    } else {
                        MyCourseWareBean.ResultsBean ments = ((MyCourseWareBean)
                                object).getResults();
                        if (ments != null) {
                            if (page.equals("1")) {
                                loadeMore.setCurrentPage(1);
                                currentPageOfLoade = 1;
                                if (CollectionUtils.isListNull(ments.getElements())) {

                                    TooSnackbar.showMessage(cool_my_courseware_online, "您还未上传课件");
                                } else {

                                    loadeMore.setCurrentPage(++currentPageOfLoade);

                                }
                                myCourseWareElementsList.clear();
                                myCourseWareElementsList.addAll(ments.getElements
                                        ());
                                adapter.addList(myCourseWareElementsList);
                                if (swip_my_courseware_online.isRefreshing()) {

                                    swip_my_courseware_online.setRefreshing(false);
                                }
                            } else {
                                if (CollectionUtils.isListNull(ments.getElements())) {

                                    TooSnackbar.showMessage(cool_my_courseware_online, "您没有更多的课件啦");
                                } else {

                                    loadeMore.setCurrentPage(++currentPageOfLoade);

                                }
                                myCourseWareElementsList.addAll(ments.getElements
                                        ());
                                adapter.addList(myCourseWareElementsList);
                            }
                            if (swip_my_courseware_online.isRefreshing()) {

                                swip_my_courseware_online.setRefreshing(false);
                            }
                        }
                        dismissProgressDialog();
                        if (swip_my_courseware_online.isRefreshing()) {

                            swip_my_courseware_online.setRefreshing(false);
                        }
                    }
                }
            }
        }, page, "12", userId, "", coursewareType, "");
    }


    private void setOnCourseWareClickLisner() {
        imagbtn_action_clude.setOnClickListener(this);
        loadeMore = new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                currentPageOfLoade =
                        currentPage;
                showProgressDialog("正在加载");
                MyCourseWareLoad(currentPage + "");

            }
        };
        recycler_my_courseware_online.addOnScrollListener(loadeMore);

        recycler_my_courseware_online.addOnItemTouchListener(new OnRecyclerItemClickListener(recycler_my_courseware_online,
                recycler_my_courseware_online.getContext()) {//封装了为rescyler 封装了监听

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {


                addFragment(MineCourseWareDetailFragment.newInstance(myCourseWareElementsList.get(vh
                        .getAdapterPosition()).getId()));
            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });


    }


    private void recyclCoursewareSetAdpater() {


        layoutManager = new LinearLayoutManager(ct);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_my_courseware_online.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        recycler_my_courseware_online.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyCourseWareAdapter(myActivity, myCourseWareElementsList);
        recycler_my_courseware_online.addItemDecoration(new DividerItemDecoration(ct, layoutManager
                .getOrientation()));

        recycler_my_courseware_online.setAdapter(adapter);


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
                removeFragment();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onClickEvent(View view) {

        switch (view.getId()) {
            case R.id.imagbtn_action_clude:

                showChooseFileDialog();


        }
    }

    private void showChooseFileDialog() {


        chooseFileDialog = new BottomSheetDialog(myActivity, R.style
                .Material_App_BottomSheetDialog);
        View chooseFileView = LayoutInflater.from(myActivity).inflate(R.layout
                .bottomsheet_choose_courseware_file_dialog, null);
        chooseFileDialog.heightParam(ViewGroup.LayoutParams.MATCH_PARENT);
        tv_progresspercent_courseware_item =
                (TextView) chooseFileView.findViewById(R.id
                        .tv_progresspercent_courseware_item);
        pv_progress_courseware_item = (ProgressView) chooseFileView.findViewById(R.id.pv_progress_courseware_item);
        etThemenameCourseWareItem = (EditText) chooseFileView.findViewById(R.id.et_themename_courseware_item);
        Spinner radioGradecontainerCourseWareItem = (Spinner) chooseFileView.findViewById(R.id
                .spinner_gradecontainer_courseware_item);
        RadioGroup radio_textbookcontainer_courseware_item = (RadioGroup) chooseFileView.findViewById(R.id
                .radio_textbookcontainer_courseware_item);
        radioSubjectcontainerCourseWareItem = (Spinner) chooseFileView.findViewById(R.id
                .spinner_subjectcontainer_courseware_item);
        RadioButton btnFirstVolumeCourseWareItem = (RadioButton) chooseFileView.findViewById(R.id
                .btn_first_volume_courseware_item);
        RadioButton btnDownVolumeCourseWareItem = (RadioButton) chooseFileView.findViewById(R.id
                .btn_down_volume_courseware_item);
        Button btnChoosefileCourseWareItem = (Button) chooseFileView.findViewById(R.id
                .btn_choosefile_courseware_item);
        tvChoosefileNameCourseWareItem = (TextView) chooseFileView.findViewById(R.id
                .tv_choosefile_name_courseware_item);
        Button btnSavefileCourseWareItem = (Button) chooseFileView.findViewById(R.id.btn_savefile_courseware_item);
        Button btnSubmmitfileCourseWareItem = (Button) chooseFileView.findViewById(R.id
                .btn_submmitfile_courseware_item);
        Button btnCancelCourseWareItem = (Button) chooseFileView.findViewById(R.id.btn_cancel_courseware_item);
        RadioGroup radio_adaptergrammar_courseware_item = (RadioGroup) chooseFileView.findViewById(R
                .id.radio_adaptergrammar_courseware_item);
        ly_adapter_grammarlist_item = (LinearLayout) chooseFileView.findViewById(R.id.ly_adapter_grammarlist_item);
        spinner_adapter_grammarlist_item = (Spinner) chooseFileView.findViewById(R.id
                .spinner_adapter_grammarlist_item);
        radio_adaptergrammar_courseware_item.check(R.id.btn_noadapter_courseware_item);
        radio_adaptergrammar_courseware_item.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {

                switch (id) {

                    case R.id.btn_adapter_courseware_item:
                        isOrAdaterGrammar = true;
                        loadeAdapterGrammarList();
                        ly_adapter_grammarlist_item.setVisibility(View.VISIBLE);

                        break;
                    case R.id.btn_noadapter_courseware_item:
                        isOrAdaterGrammar = false;
                        lessonId = "";
                        ly_adapter_grammarlist_item.setVisibility(View.GONE);
                        break;
                }

            }
        });
        chooseFileDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                LogUtil.d("bottom消失");
                subjectType = null;
                fileName = null;
                coursewarefile = null;
                gradeId = null;
                subjectId = null;

                tvChoosefileNameCourseWareItem.setText("");
                OkHttpUtils.getInstance().cancelTag(this);
                chooseFileDialog = null;

            }
        });
        radio_textbookcontainer_courseware_item.check(R.id.btn_first_volume_courseware_item);
        subjectType = "0";
        radio_textbookcontainer_courseware_item.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {

                switch (id) {

                    case R.id.btn_first_volume_courseware_item:
                        subjectType = "0";
                        loadeAdapterGrammarList();
                        break;
                    case R.id.btn_down_volume_courseware_item:
                        subjectType = "1";
                        loadeAdapterGrammarList();
                        break;
                }
            }
        });


        btnChoosefileCourseWareItem.setOnClickListener(new View.OnClickListener() {
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

        btnSavefileCourseWareItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etThemenameCourseWareItem.getText().toString() == null || etThemenameCourseWareItem
                        .getText().toString().equals
                                ("")) {

                    Toast.makeText(myActivity, "请填写课题题目", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (subjectType == null ||

                        fileName == null ||
                        coursewarefile == null ||
                        gradeId == null ||
                        subjectId == null ||

                        tvChoosefileNameCourseWareItem.getText().equals("")) {
                    Toast.makeText(myActivity, "请填写完整", Toast.LENGTH_SHORT).show();

                } else {
                    uplodFile("0");

                }


            }
        });

        btnSubmmitfileCourseWareItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etThemenameCourseWareItem.getText().toString() == null || etThemenameCourseWareItem
                        .getText().toString().equals
                                ("")) {

                    Toast.makeText(myActivity, "请填写课题题目", Toast.LENGTH_SHORT).show();
                    return;
                }
                LogUtil.d(etThemenameCourseWareItem.getText().toString());
                if (subjectType == null ||

                        fileName == null ||
                        coursewarefile == null ||
                        gradeId == null ||
                        subjectId == null ||

                        tvChoosefileNameCourseWareItem.getText().equals("")) {

                    Toast.makeText(myActivity, "您未选择教材或者文件", Toast.LENGTH_SHORT).show();

                } else {
                    uplodFile("1");
                }
            }
        });
        btnCancelCourseWareItem.setOnClickListener(new View.OnClickListener() {
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
        radioGradecontainerCourseWareItem.setAdapter(new ArrayAdapter<String>(myActivity, android.R.layout.simple_spinner_item, stringGrade));
        radioGradecontainerCourseWareItem.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
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


                radioSubjectcontainerCourseWareItem.setAdapter(new ArrayAdapter<String>(myActivity, android.R.layout.simple_spinner_item, subjectString));
                ///

               /* subjectId = CustomApplication.userInfor.getDutyList().get(gradePosition)
                        .getSubList().get(0).getSubjectId();//默认第一个*/

                loadeAdapterGrammarList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {//
            }


            //第三方radiobutton没单选效果


        });
        radioSubjectcontainerCourseWareItem.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long
                    l) {
                subjectPosition = position;
                LogUtil.d(position + "科目");
                LogUtil.d(subjectPosition + "科目");
                subjectId = CustomApplication.userInfor.getDutyList().get(gradePosition)
                        .getSubList().get(subjectPosition).getSubjectId();
                LogUtil.d("onItemSelected第一此加载adapter就会执行");
                loadeAdapterGrammarList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinner_adapter_grammarlist_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lessonId = reatedGrammarList.get(i).getLessonId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        chooseFileDialog.contentView(chooseFileView).show();
    }

    private void loadeAdapterGrammarList() {
        if (!isOrAdaterGrammar)
            return;
        DataAchieve.getRelatedGrammarList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                if (code != 1000)
                    return;
                reatedGrammarList = ((RelatedGrammarListBean) object).getResults();
                int grammarCount = reatedGrammarList.size();
                grammarString = new String[grammarCount];
                for (int i = 0; i < grammarCount; i++) {
                    grammarString[i] = reatedGrammarList.get(i).getLessonName();
                }
                spinner_adapter_grammarlist_item.setAdapter(new ArrayAdapter<String>(myActivity, android.R.layout.simple_spinner_item, grammarString));
            }
        }, CustomApplication.userInfor.getUserId(), gradeId, subjectId, subjectType);


    }


    public void uplodFile(String coursewareType) {

        HttpParams httpParams = new HttpParams();
        httpParams.put("lessonId", lessonId);
        httpParams.put("coursewareId", "");
        httpParams.put("coursewareName", etThemenameCourseWareItem.getText().toString());
        httpParams.put("coursewareType", coursewareType);
        httpParams.put("userId", CustomApplication.userInfor.getUserId());
        httpParams.put("schoolId", CustomApplication.userInfor.getSchoolId());
        httpParams.put("gradeId", gradeId);
        httpParams.put("subjectId", subjectId);
        httpParams.put("subjectType", subjectType);
        OkHttpUtils.post(BuildConfig.URL + ServerInterfaceDefinition.OPT_UPLODECOURSEWAREFILE.getOpt
                ())
                .tag(this)
                .params(httpParams)
                .params(fileName
                        , coursewarefile)
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
                        pv_progress_courseware_item.setProgress(progress * 100);
                        tv_progresspercent_courseware_item.setText(progress * 100 + "%");
                    }

                    @Override
                    public void onSuccess(ToSendCompleteBean toSendCompleteBean, Call call, Response response) {

                        LogUtil.d(response.body().toString());
                        if (toSendCompleteBean.code == 1000) {
                            Toast.makeText(myActivity, "上传成功", Toast.LENGTH_SHORT).show();
                            chooseFileDialog.dismiss();
                            swip_my_courseware_online.setRefreshing(true);
                            MyCourseWareLoad("1");//刷新界面

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

            coursewarefile = new File(url);
            if (!ToolFile.getFileExtension(coursewarefile).equals("ppt") && !ToolFile
                    .getFileExtension
                            (coursewarefile).equals("pptx")) {
                LogUtil.d(ToolFile.getFileExtension(coursewarefile));
                ToolToast.showShortTimeMsg("您需要选择ppt或者pptxx格式的文件");
                fileName = null;
                return;
            }
            if (coursewarefile.isFile() && coursewarefile.exists()) {
                tvChoosefileNameCourseWareItem.setText(url);

            } else {
                Toast.makeText(myActivity, "未上传文件", Toast.LENGTH_SHORT).show();
                return;
            }
        } catch (Exception e) {
        }


    }
}
