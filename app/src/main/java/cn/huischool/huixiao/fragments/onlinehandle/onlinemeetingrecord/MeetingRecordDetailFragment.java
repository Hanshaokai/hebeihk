package cn.huischool.huixiao.fragments.onlinehandle.onlinemeetingrecord;

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
import cn.huischool.huixiao.bean.MyMeetingRecordNotesDetailBean;
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
public class MeetingRecordDetailFragment extends BaseFragment {

    @BindView(R.id.tv_title_clude)
    TextView tvTitleClude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtnActionClude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbarClude;
    @BindView(R.id.appbar_clude)
    AppBarLayout appbarClude;
    @BindView(R.id.tv_my_meetingrecord_detail_meetingrecordname)
    TextView tvMyMeetingrecordDetailMeetingrecordname;
    @BindView(R.id.tv_meetingrecord_notes_detail_creattime)
    TextView tvMeetingrecordNotesDetailCreattime;
    @BindView(R.id.tv_meetingrecord_notes_detail_creatplace)
    TextView tvMeetingrecordNotesDetailCreatplace;
    @BindView(R.id.tv_meetingrecord_notes_detail_compere)
    TextView tvMeetingrecordNotesDetailCompere;
    @BindView(R.id.tv_meetingrecord_notes_detail_keynotespeaker)
    TextView tvMeetingrecordNotesDetailKeynotespeaker;
    @BindView(R.id.tv_meetingrecord_notes_detail_spokesman)
    TextView tvMeetingrecordNotesDetailSpokesman;
    @BindView(R.id.tv_meetingrecord_notes_detail_participants)
    TextView tvMeetingrecordNotesDetailParticipants;
    @BindView(R.id.tv_meetingrecord_notes_detail_meetingcontent)
    TextView tvMeetingrecordNotesDetailMeetingcontent;
    @BindView(R.id.nestscroll_meetingrecord_notes_detail)
    NestedScrollView nestscrollMeetingrecordNotesDetail;
    @BindView(R.id.tv_meetingrecord_notes_detail_committime)
    TextView tvMeetingrecordNotesDetailCommittime;
    @BindView(R.id.tv_meetingrecord_detail_browsecount)
    TextView tvMeetingrecordDetailBrowsecount;
    @BindView(R.id.tv_meetingrecord_notes_detail_browsename)
    TextView tvMeetingRecordNotesDetailBrowsename;
    @BindView(R.id.tv_meetingrecord_notes_detail_commentcount)
    TextView tvMeetingRecordNotesDetailCommentcount;
    @BindView(R.id.tv_meetingrecord_notes_detail_commentname)
    TextView tvMeetingRecordNotesDetailCommentname;
    @BindView(R.id.ll_meetingrecord_notes_detail_comentcontainer)
    LinearLayout llMeetingRecordNotesDetailComentcontainer;
    private Unbinder unbinder;
    private String meetingRecordId;
    private AppCompatActivity myActivity;

    MyMeetingRecordNotesDetailBean.ResultsBean result = null;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        meetingRecordId = getArguments().getString("id");
        view = inflater.inflate(R.layout.fragment_online_my_meetingrecord_detail, null, false);
        unbinder = ButterKnife.bind(this, view);
        nestscrollMeetingrecordNotesDetail.setVisibility(View.GONE);

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {


        initToolBar(toolbarClude, true, "会议记录详情",-1,true);
        setHasOptionsMenu(true);
        toLoadeMeetRecordDetailData();
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
                                                                result = (
                                                                        (MyMeetingRecordNotesDetailBean) object).getResults();
                                                                toShowRecordNotesDetailData();
                                                            }
                                                        }


                                                    }, meetingRecordId, ToolString.getStringOfEncoder(CustomApplication.userInfor.getRealName()),
                CustomApplication
                        .userInfor
                        .getRemarkId());


    }

    private void toShowRecordNotesDetailData() {
        tvMeetingrecordNotesDetailCommittime.setText(result.getCreateTime());
        tvMyMeetingrecordDetailMeetingrecordname.setText(result.getMeetTitle());
        tvMeetingrecordNotesDetailCompere.setText(result.getMeetHost());
        tvMeetingrecordNotesDetailCreatplace.setText(result.getMeetAddress());
        tvMeetingrecordNotesDetailCreattime.setText(result.getMeetTime());
        tvMeetingrecordNotesDetailKeynotespeaker.setText(result.getSpokesMan());
        tvMeetingrecordNotesDetailParticipants.setText(result.getAllPerson());
        tvMeetingrecordNotesDetailMeetingcontent.setText(result.getMeetContext());
        tvMeetingrecordDetailBrowsecount.setText("(" + ToolRegex.checkAcharApearTimesInAString(result
                .getBrowseNames(), ',') + ")");
        tvMeetingRecordNotesDetailBrowsename.setText(result.getBrowseNames());
        int commentCount = result.getReadOverList().size();
        tvMeetingRecordNotesDetailCommentcount.setText("(" + commentCount + ")");

        StringBuffer stringBuffer = new StringBuffer();


        llMeetingRecordNotesDetailComentcontainer.removeAllViews();
        for (int i = 0; i < commentCount; i++) {

            stringBuffer.append(result.getReadOverList().get(i).getReaderName() + ",");
            View commentViewItem = myActivity.getLayoutInflater().inflate(R.layout
                    .item_meetingrecord_notes_comment_detail, null, false);

            CircleImageView iv_item_meetingrecord_notes_comentdetail_img = (CircleImageView) commentViewItem.findViewById(R.id
                    .iv_item_meetingrecord_notes_comentdetail_img);

            TextView tv_item_meetingrecord_notes_commentdetail_commentatorname = (TextView) commentViewItem.findViewById(R.id
                    .tv_item_meetingrecord_notes_commentdetail_commentatorname);


            TextView tv_item_meetingrecord_notes_commentdetail_creatime = (TextView) commentViewItem.findViewById(R.id
                    .tv_item_meetingrecord_notes_commentdetail_creatime);
            TextView tv_item_meetingrecord_notes_commentdetail_content = (TextView) commentViewItem.findViewById(R.id
                    .tv_item_meetingrecord_notes_commentdetail_content);
            LoadBitmapUtils.LoadHeadImagview(baseFragmentActivity, result.getReadOverList()
                            .get(i).getImgUrl(),
                    iv_item_meetingrecord_notes_comentdetail_img);
            tv_item_meetingrecord_notes_commentdetail_commentatorname.setText(result.getReadOverList()
                    .get(i).getReaderName());
            tv_item_meetingrecord_notes_commentdetail_creatime.setText(result.getReadOverList()
                    .get(i).getReadTime());
            tv_item_meetingrecord_notes_commentdetail_content.setText(result.getReadOverList()
                    .get(i).getComment());
            tvMeetingRecordNotesDetailCommentname.setText(stringBuffer.toString());
            llMeetingRecordNotesDetailComentcontainer.addView(commentViewItem);
        }

        nestscrollMeetingrecordNotesDetail.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onClickEvent(View view) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public static MeetingRecordDetailFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putSerializable("id", id);
        MeetingRecordDetailFragment fragment = new MeetingRecordDetailFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
