package cn.huischool.huixiao.fragments.onlinehandle.onlinestudynotes;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rey.material.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.MyStudyNotesDetailBean;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.ToolRegex;
import cn.huischool.huixiao.common.utils.ToolString;
import cn.huischool.huixiao.common.widget.widgetofbindcircleImage.CircleImageView;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/8/12.
 */
public class StudyNotesDetailFragment extends BaseFragment {
    @BindView(R.id.tv_title_clude)
    TextView tvTitleClude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtnActionClude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbarClude;
    @BindView(R.id.appbar_clude)
    AppBarLayout appbarClude;

    @BindView(R.id.tv_study_notes_detail_creattime)
    TextView tvStudyNotesDetailCreattime;
    @BindView(R.id.tv_study_notes_detail_creatplace)
    TextView tvStudyNotesDetailCreatplace;
    @BindView(R.id.tv_study_notes_detail_theme)
    TextView tvStudyNotesDetailTheme;
    @BindView(R.id.tv_study_notes_detail_contentsource)
    TextView tvStudyNotesDetailContentsource;
    @BindView(R.id.tv_study_notes_detail_content)
    TextView tvStudyNotesDetailContent;
    @BindView(R.id.tv_study_notes_detail_comprehensive_income)
    TextView tvStudyNotesDetailComprehensiveIncome;
    @BindView(R.id.tv_study_notes_detail_committime)
    TextView tvStudyNotesDetailCommittime;
    @BindView(R.id.tv_study_detail_browsecount)
    TextView tvStudyDetailBrowsecount;
    @BindView(R.id.tv_study_notes_detail_browsename)
    TextView tvStudyNotesDetailBrowsename;
    @BindView(R.id.tv_study_notes_detail_commentcount)
    TextView tvStudyNotesDetailCommentcount;
    @BindView(R.id.tv_study_notes_detail_commentname)
    TextView tvStudyNotesDetailCommentname;
    @BindView(R.id.ll_study_notes_detail_comentcontainer)
    LinearLayout llStudyNotesDetailComentcontainer;
    @BindView(R.id.nestscroll_study_notes_detail)
    NestedScrollView nestscrollStudyNotesDetail;
    private Unbinder unbinder;
    private String studyRecordId;
    private AppCompatActivity myActivity;

    private MyStudyNotesDetailBean.ResultsBean result;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        studyRecordId = getArguments().getString("id");
        view = inflater.inflate(R.layout.fragment_online_my_studynotes_detail, null, false);
        unbinder = ButterKnife.bind(this, view);
        nestscrollStudyNotesDetail.setVisibility(View.GONE);

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        initToolBar(toolbarClude, true, "学习笔记详情",-1,true);
        setHasOptionsMenu(true);
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
                                                        result = ((MyStudyNotesDetailBean) object).getResults();
                                                        toShowStudyNotesDetailData();
                                                    }
                                                }


                                            }, studyRecordId, ToolString.getStringOfEncoder(CustomApplication.userInfor.getRealName()),
                CustomApplication
                        .userInfor
                        .getRemarkId());


    }

    private void toShowStudyNotesDetailData() {


        tvStudyNotesDetailCommittime.setText(result.getCreateTime());
        tvStudyNotesDetailContent.setText(result.getLearnNotes());
        tvStudyNotesDetailComprehensiveIncome.setText(result.getLearnLesson());
        tvStudyNotesDetailContentsource.setText(result.getStudySource());
        tvStudyNotesDetailCreatplace.setText(result.getStudyAddress());
        tvStudyNotesDetailCreattime.setText(result.getCreateTime());
        tvStudyNotesDetailTheme.setText(result.getStudyTitle());

        tvStudyDetailBrowsecount.setText("(" + ToolRegex.checkAcharApearTimesInAString(result
                .getBrowseNames(), ',') + ")");
        tvStudyNotesDetailBrowsename.setText(result.getBrowseNames());
        int commentCount = result.getReadOverList().size();
        tvStudyNotesDetailCommentcount.setText("(" + commentCount + ")");

        StringBuffer stringBuffer = new StringBuffer();


        llStudyNotesDetailComentcontainer.removeAllViews();
        for (int i = 0; i < commentCount; i++) {

            stringBuffer.append(result.getReadOverList().get(i).getReaderName() + ",");
            View commentViewItem = myActivity.getLayoutInflater().inflate(R.layout
                    .item_study_notes_comment_detail, null, false);

            CircleImageView iv_item_study_notes_comentdetail_img = (CircleImageView) commentViewItem.findViewById(R.id
                    .iv_item_study_notes_comentdetail_img);

            TextView tv_item_study_notes_commentdetail_commentatorname = (TextView) commentViewItem.findViewById(R.id
                    .tv_item_study_notes_commentdetail_commentatorname);


            TextView tv_item_study_notes_commentdetail_creatime = (TextView) commentViewItem.findViewById(R.id
                    .tv_item_study_notes_commentdetail_creatime);
            TextView tv_item_study_notes_commentdetail_content = (TextView) commentViewItem.findViewById(R.id
                    .tv_item_study_notes_commentdetail_content);
            LoadBitmapUtils.LoadHeadImagview(baseFragmentActivity, result.getReadOverList()
                            .get(i).getImgUrl(),
                    iv_item_study_notes_comentdetail_img);
            tv_item_study_notes_commentdetail_commentatorname.setText(result.getReadOverList()
                    .get(i).getReaderName());
            tv_item_study_notes_commentdetail_creatime.setText(result.getReadOverList()
                    .get(i).getReadTime());
            tv_item_study_notes_commentdetail_content.setText(result.getReadOverList()
                    .get(i).getComment());
            tvStudyNotesDetailCommentname.setText(stringBuffer.toString());
            llStudyNotesDetailComentcontainer.addView(commentViewItem);
        }

        nestscrollStudyNotesDetail.setVisibility(View.VISIBLE);


    }

    @Override
    protected void onClickEvent(View view) {

    }

    public static BaseFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putSerializable("id", id);
        StudyNotesDetailFragment fragment = new StudyNotesDetailFragment();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
