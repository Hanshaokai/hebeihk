package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlemineteacherplan;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okhttputils.OkHttpUtils;

import cn.huischool.huixiao.AppStoreConfig;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.MyTeacherPlanDetailBean;
import cn.huischool.huixiao.common.fragment.PreviewFragment;
import cn.huischool.huixiao.common.utils.CheckeAuthorityUtils;
import cn.huischool.huixiao.common.utils.HttpLoadeFileUtils;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.ToolDateTime;
import cn.huischool.huixiao.common.utils.ToolRegex;
import cn.huischool.huixiao.common.widget.widgetofbindcircleImage.CircleImageView;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/7/13.
 */
public class MineGrammarDetailFragment extends BaseFragment {
    private MyTeacherPlanDetailBean.ResultsBean result;
    private String grammarId;
    private TextView tv_my_grammardetail_creatime;
    private TextView tv_grammardetail_planname;
    private TextView tv_my_grammardetail_teachername;
    private TextView tv_grammardetail_planversion;
    private TextView tv_my_grammardetail_preview;
    private Toolbar toolbar_clude;
    private TextView tv_title_clude;
    private LinearLayout ll_my_grammardetail_commentator;
    private LinearLayout ll_my_grammardetail_commentDetail;
    private NestedScrollView nestscroll_my_grammardetail_parent;
    private EditText et_my_grammardetail_tocomment_words;
    private TextView tv_my_grammardetail_tocomment;
    private LinearLayout ll_my_grammardetail_tocomment;
    private LinearLayout.LayoutParams params1;
    private AppCompatActivity myActivity;
    private TextView tv_my_grammardetail_downloadfile;
    //private DownloadManager downloadManager;


    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        // downloadManager = ;//全局管理下载
        grammarId = getArguments().getString("id");
        view = inflater.inflate(R.layout.fragment_online_mygrammar_detail, null, false);
        nestscroll_my_grammardetail_parent = (NestedScrollView) view.findViewById(R.id
                .nestscroll_my_grammardetail_parent);
        nestscroll_my_grammardetail_parent.setVisibility(View.GONE);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        tv_my_grammardetail_creatime = (TextView) view.findViewById(R.id.tv_my_grammardetail_creatime);
        tv_grammardetail_planname = (TextView) view.findViewById(R.id.tv_grammardetail_planname);
        tv_my_grammardetail_teachername = (TextView) view.findViewById(R.id
                .tv_my_grammardetail_teachername);
        tv_grammardetail_planversion = (TextView) view.findViewById(R.id.tv_grammardetail_planversion);
        ll_my_grammardetail_commentator = (LinearLayout) view.findViewById(R.id
                .ll_my_grammardetail_commentator);
        ll_my_grammardetail_commentDetail = (LinearLayout) view.findViewById(R.id
                .ll_my_grammardetail_commentDetail);
        tv_my_grammardetail_preview = (TextView) view.findViewById(R.id
                .tv_my_grammardetail_preview);
        et_my_grammardetail_tocomment_words = (EditText) view.findViewById(R.id
                .et_my_grammardetail_tocomment_words);
        //  et_my_grammardetail_tocomment_words.sets
        tv_my_grammardetail_tocomment = (TextView) view.findViewById(R.id
                .tv_my_grammardetail_tocomment);
        ll_my_grammardetail_tocomment = (LinearLayout) view.findViewById(R.id.ll_my_grammardetail_tocomment);
        tv_my_grammardetail_downloadfile = (TextView) view.findViewById(R.id.tv_my_grammardetail_downloadfile);
        tv_my_grammardetail_downloadfile.setOnClickListener(this);
        tv_my_grammardetail_tocomment.setOnClickListener(this);


        return view;

    }

    public static MineGrammarDetailFragment newInstance(String u) {

        Bundle args = new Bundle();
        args.putSerializable("id", u);
        MineGrammarDetailFragment fragment = new MineGrammarDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void initData(Bundle savedInstanceState) {

        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_clude, true, "教案详情",-1,true);
        if (result == null) {
            toLoadData();
        } else {
            showGrammarDetailData();
        }


    }

    private void toLoadData() {

        showProgressDialog("正在加载");
        DataAchieve.togetMyTeacherPlanDetail(new DataAchieve.SuccessCallBack() {


            @Override
            public void handle(int code, Object object) {

                if (code != 1000) {
                    dismissProgressDialog();
                    return;
                } else {
                    result = ((MyTeacherPlanDetailBean) object).getResults();
                    if (result != null) {
                        showGrammarDetailData();
                    }
                    dismissProgressDialog();
                }
            }
        }, grammarId, CustomApplication.userInfor.getRealName(), CustomApplication.userInfor.getRemarkId());

    }

    private void showGrammarDetailData() {

        tv_my_grammardetail_creatime.setText(result.getCreateTime());
        tv_grammardetail_planname.setText(result.getFileName());
        tv_my_grammardetail_teachername.setText(result.getTeacherName());
        tv_grammardetail_planversion.setText(result.getLessonDet());
        tv_my_grammardetail_preview.setOnClickListener(this);
        int commentCount = result.getPiYueList().size();

        params1 = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params1.setMargins(10, 10, 10, 10);


        TextView textView1 = new TextView(baseFragmentActivity);
        textView1.setLayoutParams(params1);
        textView1.setText(ToolRegex.checkAcharApearTimesInAString(result.getBrowseNames(), ',') +
                "人查看过");
        ll_my_grammardetail_commentator.removeAllViews();
        ll_my_grammardetail_commentator.addView(textView1);
        TextView textView = new TextView(baseFragmentActivity);
        textView.setLayoutParams(params1);
        textView.setText(result.getBrowseNames());
        ll_my_grammardetail_commentator.addView(textView);
      /*  for (MyTeacherPlanDetailBean.ResultsBean.PiYueListBean item : result.getPiYueList()) {
            TextView textView = new TextView(baseFragmentActivity);
            textView.setLayoutParams(params1);
            textView.setText(item.getReaderName());
            ll_my_grammardetail_commentator.addView(textView);
        }*/

        TextView textView2 = new TextView(baseFragmentActivity);
        textView2.setLayoutParams(params1);
        textView2.setText("评论(" + commentCount + ")");
        ll_my_grammardetail_commentDetail.removeAllViews();
        ll_my_grammardetail_commentDetail.addView(textView2);


        for (MyTeacherPlanDetailBean.ResultsBean.PiYueListBean item : result.getPiYueList()) {
            View view_comment = LayoutInflater.from(baseFragmentActivity).inflate(R.layout
                    .item_my_grammar_comment_detail, null, false);
            CircleImageView iv_item_grammar_comentdetail_img = (CircleImageView) view_comment.findViewById(R.id
                    .iv_item_grammar_comentdetail_img);
            TextView tv_item_grammar_commentdetail_commentatorname = (TextView) view_comment.findViewById(R.id
                    .tv_item_grammar_commentdetail_commentatorname);
            TextView tv_item_grammar_commentdetail_creatime = (TextView) view_comment.findViewById(R.id
                    .tv_item_grammar_commentdetail_creatime);
            TextView tv_item_grammar_commentdetail_content = (TextView) view_comment.findViewById(R.id
                    .tv_item_grammar_commentdetail_content);
            LoadBitmapUtils.LoadHeadImagview(baseFragmentActivity, item.getImgUrl(), iv_item_grammar_comentdetail_img);
            tv_item_grammar_commentdetail_commentatorname.setText(item.getReaderName());
            tv_item_grammar_commentdetail_creatime.setText(item.getReadTime());
            tv_item_grammar_commentdetail_content.setText(item.getComment());
            ll_my_grammardetail_commentDetail.addView(view_comment);
        }


        nestscroll_my_grammardetail_parent.setVisibility(View.VISIBLE);


        if (CheckeAuthorityUtils.isAuthority("B00007")) {
            ll_my_grammardetail_tocomment.setVisibility(View.VISIBLE);
            for (MyTeacherPlanDetailBean.ResultsBean.PiYueListBean ob : result.getPiYueList()) {

                if (ob.getReaderId() != null && ob.getReaderId().equals(CustomApplication.userInfor
                        .getUserId())) {
                    ll_my_grammardetail_tocomment.setVisibility(View.GONE);
                }

            }
        }

        HttpLoadeFileUtils.setDownLoade(tv_my_grammardetail_downloadfile, result.getFileId());
        //展示详情 前显示 是否已下载成功 已下载则显示打开 未下载 则可以点击下载
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        OkHttpUtils.getInstance().cancelTag(result.getFileId());
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
            case R.id.tv_my_grammardetail_preview:
                //永中
                addFragment(PreviewFragment.newInstance("http://139.196.234.4:8080/dcsUserCenter/checkUrl.do?k=39681933&url="+result.getHtmlFileUrl()));
                break;
            case R.id.tv_my_grammardetail_tocomment:
                toSendCommentWords();
                break;
            case R.id.tv_my_grammardetail_downloadfile:
                HttpLoadeFileUtils.downLoadFile(tv_my_grammardetail_downloadfile, result
                        .getFileId(), result.getFileName(), "lesson", AppStoreConfig
                        .MYGRAMMAR_FOLDER);
        }
    }

    private void toSendCommentWords() {
        final String words = et_my_grammardetail_tocomment_words.getText().toString();
        if (words.equals("")) {
            Toast.makeText(CustomApplication.customApplication, "输入不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        showProgressDialog("正在发送");
        DataAchieve.toCommentCurrentGrammar(new DataAchieve.SuccessCallBack() {
                                                @Override
                                                public void handle(int code, Object object) {

                                                    if (code != 1000) {
                                                        dismissProgressDialog();
                                                        return;
                                                    }
                                                    dismissProgressDialog();

                                                    MyTeacherPlanDetailBean.ResultsBean.PiYueListBean commentorbean = new
                                                            MyTeacherPlanDetailBean.ResultsBean.PiYueListBean();
                                                    commentorbean.setReaderName(CustomApplication.userInfor.getRealName());
                                                    commentorbean.setComment(words);
                                                    commentorbean.setImgUrl(CustomApplication.userInfor.getImgUrl());
                                                    commentorbean.setReadTime(ToolDateTime.gainCurrentDate(ToolDateTime.DF_YYYY_MM_DD_HH_MM_SS));
                                                    result.getPiYueList().add(commentorbean);
                                                    showGrammarDetailData();

                                                    ll_my_grammardetail_tocomment.setVisibility(View.GONE);

                                                }


                                            }, grammarId, words, CustomApplication.userInfor.getUserId(), CustomApplication.userInfor
                        .getSchoolId(), CustomApplication.userInfor.getRealName()
        );
    }
}
