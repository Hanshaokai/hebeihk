package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlemycourseware;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.lzy.okhttputils.OkHttpUtils;
import cn.huischool.huixiao.AppStoreConfig;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.WebviewActivity;
import cn.huischool.huixiao.bean.MyCourseWareDetailBean;
import cn.huischool.huixiao.common.utils.CheckeAuthorityUtils;
import cn.huischool.huixiao.common.utils.HttpLoadeFileUtils;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.ToolRegex;
import cn.huischool.huixiao.common.utils.ToolDateTime;
import cn.huischool.huixiao.common.widget.widgetofbindcircleImage.CircleImageView;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;
/**
 * Created by ${han} on 2016/7/15.
 */
public class MineCourseWareDetailFragment extends BaseFragment {
    private MyCourseWareDetailBean.ResultsBean result;
    private String courseWareId;
    private TextView tv_my_courseware_detail_creatime;
    private TextView tv_my_courseware_detail_planname;
    private TextView tv_my_courseware_detail_teachername;
    private TextView tv_my_courseware_detail_planversion;
    private TextView tv_my_courseware_detail_preview;
    private Toolbar toolbar_clude;
    private TextView tv_title_clude;
    private AppCompatActivity myActivity;
    private LinearLayout ll_my_courseware_detail_commentator;
    private LinearLayout ll_my_courseware_detail_commentDetail;
    private NestedScrollView nestscroll_my_courseware_detail_parent;
    private EditText et_my_courseware_detail_tocomment_words;
    private TextView tv_my_courseware_detail_tocomment;
    private LinearLayout ll_my_courseware_detail_tocomment;
    private TextView tv_my_courseware_detail_downloade;
    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        courseWareId = getArguments().getString("id");
        view = inflater.inflate(R.layout.fragment_online_my_coureseware_detail, null, false);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        nestscroll_my_courseware_detail_parent = (NestedScrollView) view.findViewById(R.id
                .nestscroll_my_courseware_detail_parent);
        nestscroll_my_courseware_detail_parent.setVisibility(View.GONE);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        tv_my_courseware_detail_creatime = (TextView) view.findViewById(R.id.tv_my_courseware_detail_creatime);
        tv_my_courseware_detail_planname = (TextView) view.findViewById(R.id.tv_my_courseware_detail_planname);
        tv_my_courseware_detail_teachername = (TextView) view.findViewById(R.id
                .tv_my_courseware_detail_teachername);
        tv_my_courseware_detail_planversion = (TextView) view.findViewById(R.id.tv_my_courseware_detail_planversion);
        tv_my_courseware_detail_preview = (TextView) view.findViewById(R.id
                .tv_my_courseware_detail_preview);
        ll_my_courseware_detail_commentator = (LinearLayout) view.findViewById(R.id
                .ll_my_courseware_detail_commentator);
        ll_my_courseware_detail_commentDetail = (LinearLayout) view.findViewById(R.id
                .ll_my_courseware_detail_commentDetail);
        et_my_courseware_detail_tocomment_words = (EditText) view.findViewById(R.id
                .et_my_courseware_detail_tocomment_words);
        tv_my_courseware_detail_tocomment = (TextView) view.findViewById(R.id
                .tv_my_courseware_detail_tocomment);
        ll_my_courseware_detail_tocomment = (LinearLayout) view.findViewById(R.id.ll_my_courseware_detail_tocomment);
        tv_my_courseware_detail_downloade = (TextView) view.findViewById(R.id.tv_my_courseware_detail_downloade);
        tv_my_courseware_detail_downloade.setOnClickListener(this);
        tv_my_courseware_detail_tocomment.setOnClickListener(this);
        return view;
    }

    public static MineCourseWareDetailFragment newInstance(String u) {
        Bundle args = new Bundle();
        args.putSerializable("id", u);
        MineCourseWareDetailFragment fragment = new MineCourseWareDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_clude, true, "课件详情", -1, true);
        if (result == null) {
            toLoadData();
        } else {
            showMyCourseWareDetailData();
        }
    }
    private void toLoadData() {
        showProgressDialog("正在加载");
        DataAchieve.togetMyCourseWareDetail(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                if (code != 1000) {
                    dismissProgressDialog();
                    return;
                } else {
                    result = ((MyCourseWareDetailBean) object).getResults();
                    if (result != null) {
                        showMyCourseWareDetailData();
                    }
                    dismissProgressDialog();
                }
            }
        }, courseWareId, CustomApplication.userInfor.getRealName(), CustomApplication.userInfor.getRemarkId());
    }
    private void showMyCourseWareDetailData() {
        tv_my_courseware_detail_creatime.setText(result.getCreateTime());
        tv_my_courseware_detail_planname.setText(result.getFileName());
        tv_my_courseware_detail_teachername.setText(result.getTeacherName());
        tv_my_courseware_detail_planversion.setText(result.getCoursewareDet());
        tv_my_courseware_detail_preview.setOnClickListener(this);
        int commentCount = result.getPiYueList().size();
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params1.setMargins(10, 10, 10, 10);
        TextView textView1 = new TextView(myActivity);
        textView1.setLayoutParams(params1);
        textView1.setText(ToolRegex.checkAcharApearTimesInAString(result.getBrowseNames(), ',')
                + "人查看过");
        ll_my_courseware_detail_commentator.removeAllViews();
        ll_my_courseware_detail_commentator.addView(textView1);
        TextView textView = new TextView(myActivity);
        textView.setLayoutParams(params1);
        textView.setText(result.getBrowseNames());
        ll_my_courseware_detail_commentator.addView(textView);
        TextView textView2 = new TextView(myActivity);
        textView2.setLayoutParams(params1);
        textView2.setText("评论(" + commentCount + ")");
        ll_my_courseware_detail_commentDetail.removeAllViews();
        ll_my_courseware_detail_commentDetail.addView(textView2);
        for (MyCourseWareDetailBean.ResultsBean.PiYueListBean item : result.getPiYueList()) {
            //生成布局 跟教案 共用 评论布局
            View view_comment = LayoutInflater.from(myActivity).inflate(R.layout
                    .item_my_grammar_comment_detail, null, false);

            CircleImageView iv_item_grammar_comentdetail_img = (CircleImageView) view_comment.findViewById(R.id
                    .iv_item_grammar_comentdetail_img);

            TextView tv_item_grammar_commentdetail_commentatorname = (TextView) view_comment.findViewById(R.id
                    .tv_item_grammar_commentdetail_commentatorname);


            TextView tv_item_grammar_commentdetail_creatime = (TextView) view_comment.findViewById(R.id
                    .tv_item_grammar_commentdetail_creatime);


            TextView tv_item_grammar_commentdetail_content = (TextView) view_comment.findViewById(R.id
                    .tv_item_grammar_commentdetail_content);

            LoadBitmapUtils.LoadHeadImagview(myActivity, item.getImgUrl(), iv_item_grammar_comentdetail_img);
            tv_item_grammar_commentdetail_commentatorname.setText(item.getReaderName());
            tv_item_grammar_commentdetail_creatime.setText(item.getReadTime());
            tv_item_grammar_commentdetail_content.setText(item.getComment());

            ll_my_courseware_detail_commentDetail.addView(view_comment);
        }

        nestscroll_my_courseware_detail_parent.setVisibility(View.VISIBLE);
        if (CheckeAuthorityUtils.isAuthority("B00007")) {
            ll_my_courseware_detail_tocomment.setVisibility(View.VISIBLE);
            for (MyCourseWareDetailBean.ResultsBean.PiYueListBean ob : result.getPiYueList()) {

                if (ob.getReaderId() != null && ob.getReaderId().equals(CustomApplication.userInfor.getUserId())) {
                    ll_my_courseware_detail_tocomment.setVisibility(View.GONE);
                }

            }
        }


        HttpLoadeFileUtils.setDownLoade(tv_my_courseware_detail_downloade, result.getFileId());

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


            case R.id.tv_my_courseware_detail_preview:
               /* addFragment(PreviewFragment.newInstance("http://139.196.234" +
                    ".4:8080/dcsUserCenter/checkUrl.do?k=39634332&url="+result.getHtmlFileUrl()));
*/
                Intent intent = new Intent(myActivity, WebviewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", "http://139.196.234" +
                        ".4:8080/dcsUserCenter/checkUrl.do?k=39634332&url=" + result.getHtmlFileUrl());
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.tv_my_courseware_detail_tocomment:

                toSendCommentWords();

                break;
            case R.id.tv_my_courseware_detail_downloade:
                HttpLoadeFileUtils.downLoadFile(tv_my_courseware_detail_downloade, result
                        .getFileId(), result.getFileName(), "courseware", AppStoreConfig
                        .MYCOURSEWARE_FOLDER);
        }
    }

    private void toSendCommentWords() {

        final String words = et_my_courseware_detail_tocomment_words.getText().toString();

        if (words.equals("")) {

            Toast.makeText(CustomApplication.customApplication, "输入不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        showProgressDialog("正在发送");
        DataAchieve.toCommentCurrentCourseWare(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {

                if (code != 1000) {
                    dismissProgressDialog();
                    return;
                }
                dismissProgressDialog();

                MyCourseWareDetailBean.ResultsBean.PiYueListBean commentorbean = new
                        MyCourseWareDetailBean.ResultsBean.PiYueListBean();
                commentorbean.setReaderName(CustomApplication.userInfor.getRealName());
                commentorbean.setComment(words);
                commentorbean.setImgUrl(CustomApplication.userInfor.getImgUrl());
                commentorbean.setReadTime(ToolDateTime.gainCurrentDate(ToolDateTime.DF_YYYY_MM_DD_HH_MM_SS));
                result.getPiYueList().add(commentorbean);
                showMyCourseWareDetailData();
                ll_my_courseware_detail_tocomment.setVisibility(View.GONE);
            }
        }, courseWareId, words, CustomApplication.userInfor.getUserId(), CustomApplication.userInfor
                .getSchoolId(), CustomApplication.userInfor.getRealName());


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        OkHttpUtils.getInstance().cancelTag(result.getFileId());
    }
}

