package cn.huischool.huixiao.fragments.onlinehandle.onlinehandleactivitiesofteachandresearch;

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
import cn.huischool.huixiao.bean.MyActivitiesOfTeachAndResearchDetailBean;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.ToolRegex;
import cn.huischool.huixiao.common.utils.ToolString;
import cn.huischool.huixiao.common.widget.widgetofbindcircleImage.CircleImageView;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/8/17.
 */
public class ActivitiesOfTeachAndResearchDetailFragment extends BaseFragment {

    @BindView(R.id.tv_title_clude)
    TextView tvTitleClude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtnActionClude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbarClude;
    @BindView(R.id.appbar_clude)
    AppBarLayout appbarClude;
    @BindView(R.id.tv_my_activitiesofteachandresearch_detail_activitiesofteachandresearchname)
    TextView tvMyActivitiesofteachandresearchDetailActivitiesofteachandresearchname;
    @BindView(R.id.tv_activitiesofteachandresearch_detail_group)
    TextView tvActivitiesofteachandresearchDetailGroup;
    @BindView(R.id.tv_activitiesofteachandresearch_detail_creattime)
    TextView tvActivitiesofteachandresearchDetailCreattime;
    @BindView(R.id.tv_activitiesofteachandresearch_detail_creatplace)
    TextView tvActivitiesofteachandresearchDetailCreatplace;
    @BindView(R.id.tv_activitiesofteachandresearch_detail_participants)
    TextView tvActivitiesofteachandresearchDetailParticipants;
    @BindView(R.id.tv_activitiesofteachandresearch_detail_central_issue)
    TextView tvActivitiesofteachandresearchDetailCentralIssue;
    @BindView(R.id.tv_activitiesofteachandresearch_detail_minutes)
    TextView tvActivitiesofteachandresearchDetailMinutes;
    @BindView(R.id.tv_activitiesofteachandresearch_detail_simplereview)
    TextView tvActivitiesofteachandresearchDetailSimplereview;
    @BindView(R.id.tv_activitiesofteachandresearch_detail_committime)
    TextView tvActivitiesofteachandresearchDetailCommittime;
    @BindView(R.id.tv_activitiesofteachandresearch_detail_browsecount)
    TextView tvActivitiesofteachandresearchDetailBrowsecount;
    @BindView(R.id.tv_activitiesofteachandresearch_detail_browsename)
    TextView tvActivitiesofteachandresearchDetailBrowsename;
    @BindView(R.id.tv_activitiesofteachandresearch_detail_commentcount)
    TextView tvActivitiesofteachandresearchDetailCommentcount;
    @BindView(R.id.tv_activitiesofteachandresearch_detail_commentname)
    TextView tvActivitiesofteachandresearchDetailCommentname;
    @BindView(R.id.ll_activitiesofteachandresearch_detail_comentcontainer)
    LinearLayout llActivitiesofteachandresearchDetailComentcontainer;
    @BindView(R.id.nestscroll_activitiesofteachandresearch_detail)
    NestedScrollView nestscrollActivitiesofteachandresearchDetail;
    private Unbinder unbinder;
    private String activitiesOfTeachAndResearchId;
    private AppCompatActivity myActivity;

    private MyActivitiesOfTeachAndResearchDetailBean.ResultsBean result;
    private NestedScrollView nestscrollActivitiesOfTeachAndResearchDetail;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        activitiesOfTeachAndResearchId = getArguments().getString("id");
        view = inflater.inflate(R.layout.fragment_online_my_activitiesofteachandresearch_detail, null, false);
        nestscrollActivitiesOfTeachAndResearchDetail = (NestedScrollView) view.findViewById(R.id
                .nestscroll_activitiesofteachandresearch_detail);
        unbinder = ButterKnife.bind(this, view);
        nestscrollActivitiesOfTeachAndResearchDetail.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        initToolBar(toolbarClude, true, "教研活动详情",-1,true);
        setHasOptionsMenu(true);
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
                                                                          result =
                                                                                  ((MyActivitiesOfTeachAndResearchDetailBean) object).getResults();
                                                                          toShowActivitiesOfTeachAndResearchIdDetailData();
                                                                      }
                                                                  }


                                                              }, activitiesOfTeachAndResearchId, ToolString.getStringOfEncoder(CustomApplication
                        .userInfor.getRealName()),
                CustomApplication
                        .userInfor.getRemarkId());

    }

    private void toShowActivitiesOfTeachAndResearchIdDetailData() {

        tvActivitiesofteachandresearchDetailGroup.setText(result.getRgroup());
        tvActivitiesofteachandresearchDetailCreatplace.setText(result.getAddress());
        tvActivitiesofteachandresearchDetailMinutes.setText(result.getActivityContent());
        tvActivitiesofteachandresearchDetailCommittime.setText(result.getCreateTime());
        tvActivitiesofteachandresearchDetailCreattime.setText(result.getRtime());
        tvActivitiesofteachandresearchDetailSimplereview.setText(result.getSimpleReview());
        tvActivitiesofteachandresearchDetailParticipants.setText(result.getAllPerson());
        tvActivitiesofteachandresearchDetailGroup.setText(result.getRgroup());
        tvActivitiesofteachandresearchDetailCentralIssue.setText(result.getCenterTitle());

        tvActivitiesofteachandresearchDetailBrowsecount.setText("(" + ToolRegex.checkAcharApearTimesInAString(result
                .getBrowseNames(), ',') + ")");
        tvActivitiesofteachandresearchDetailBrowsename.setText(result.getBrowseNames());
        int commentCount = result.getReadOverList().size();
        tvActivitiesofteachandresearchDetailCommentcount.setText("(" + commentCount + ")");
        StringBuffer stringBuffer = new StringBuffer();
        llActivitiesofteachandresearchDetailComentcontainer.removeAllViews();


        for (int i = 0; i < commentCount; i++) {

            stringBuffer.append(result.getReadOverList().get(i).getReaderName() + ",");
            View commentViewItem = myActivity.getLayoutInflater().inflate(R.layout
                    .item_activitiesofteachandresearch_comment_detail, null, false);
            CircleImageView iv_item_activitiesofteachandresearch_comentdetail_img = (CircleImageView) commentViewItem.findViewById(R.id
                    .iv_item_activitiesofteachandresearch_comentdetail_img);
            TextView tv_item_activitiesofteachandresearch_commentdetail_commentatorname = (TextView) commentViewItem.findViewById(R.id
                    .tv_item_activitiesofteachandresearch_commentdetail_commentatorname);
            TextView tv_item_activitiesofteachandresearch_commentdetail_creatime = (TextView) commentViewItem.findViewById(R.id
                    .tv_item_activitiesofteachandresearch_commentdetail_creatime);
            TextView tv_item_activitiesofteachandresearch_commentdetail_content = (TextView) commentViewItem.findViewById(R.id
                    .tv_item_activitiesofteachandresearch_commentdetail_content);
            LoadBitmapUtils.LoadHeadImagview(baseFragmentActivity, result.getReadOverList()
                            .get(i).getImgUrl(),
                    iv_item_activitiesofteachandresearch_comentdetail_img);
            tv_item_activitiesofteachandresearch_commentdetail_commentatorname.setText(result.getReadOverList()
                    .get(i).getReaderName());
            tv_item_activitiesofteachandresearch_commentdetail_creatime.setText(result.getReadOverList()
                    .get(i).getReadTime());
            tv_item_activitiesofteachandresearch_commentdetail_content.setText(result.getReadOverList()
                    .get(i).getComment());
            tvActivitiesofteachandresearchDetailCommentname.setText(stringBuffer.toString());
            llActivitiesofteachandresearchDetailComentcontainer.addView(commentViewItem);
        }
        nestscrollActivitiesofteachandresearchDetail.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onClickEvent(View view) {


    }

    public static BaseFragment newInstance(String id) {

        Bundle args = new Bundle();
        args.putSerializable("id", id);
        ActivitiesOfTeachAndResearchDetailFragment fragment = new ActivitiesOfTeachAndResearchDetailFragment();
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
