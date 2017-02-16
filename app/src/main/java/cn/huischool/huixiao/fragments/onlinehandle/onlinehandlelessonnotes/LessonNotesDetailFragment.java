package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlelessonnotes;

import android.os.Bundle;
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
import cn.huischool.huixiao.bean.MyLesssonNotesDeatilBean;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.ToolRegex;
import cn.huischool.huixiao.common.utils.ToolString;
import cn.huischool.huixiao.common.widget.widgetofbindcircleImage.CircleImageView;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/8/9.
 */
public class LessonNotesDetailFragment extends BaseFragment {


    @BindView(R.id.tv_lesson_notes_detail_teachername)
    TextView tvLessonNotesDetailTeachername;
    @BindView(R.id.tv_lesson_notes_detail_subject)
    TextView tvLessonNotesDetailSubject;
    @BindView(R.id.tv_lesson_notes_detail_lessonname)
    TextView tvLessonNotesDetailLessonname;
    @BindView(R.id.tv_lesson_notes_detail_lessontype)
    TextView tvLessonNotesDetailLessontype;
    @BindView(R.id.tv_lesson_notes_detail_lessonclass)
    TextView tvLessonNotesDetailLessonclass;
    @BindView(R.id.tv_lesson_notes_detail_lessontime)
    TextView tvLessonNotesDetailLessontime;
    @BindView(R.id.tv_lesson_notes_detail_lessonrecord)
    TextView tvLessonNotesDetailLessonrecord;
    @BindView(R.id.tv_lesson_notes_detail_lessonanalysis)
    TextView tvLessonNotesDetailLessonanalysis;
    @BindView(R.id.tv_lesson_notes_detail_committime)
    TextView tvLessonNotesDetailCommittime;
    @BindView(R.id.tv_lesson_notes_detail_browsecount)
    TextView tvLessonNotesDetailBrowsecount;
    @BindView(R.id.tv_lessson_notes_detail_browsename)
    TextView tvLesssonNotesDetailBrowsename;
    @BindView(R.id.tv_lesson_notes_detail_commentcount)
    TextView tvLessonNotesDetailCommentcount;
    @BindView(R.id.tv_lessson_notes_detail_commentname)
    TextView tvLesssonNotesDetailCommentname;
    @BindView(R.id.ll_lesson_notes_detail_comentcontainer)
    LinearLayout llLessonNotesDetailComentcontainer;
    private String lessonNotesId;
    private Toolbar toolbar_clude;
    private ImageButton imagbtn_action_clude;
    private TextView tv_title_clude;
    private AppCompatActivity myActivity;
    private Unbinder unbinder;
    private MyLesssonNotesDeatilBean.ResultsBean result;
    private NestedScrollView nestscroll_lesson_notes_detail_parent;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        lessonNotesId = getArguments().getString("id");
        view = inflater.inflate(R.layout.fragment_online_lessonnotes_detail, null, false);
        unbinder = ButterKnife.bind(this, view);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        imagbtn_action_clude = (ImageButton) view.findViewById(R.id.imagbtn_action_clude);
        nestscroll_lesson_notes_detail_parent =
                (NestedScrollView) view.findViewById(R.id
                        .nestscroll_lesson_notes_detail_parent);
        nestscroll_lesson_notes_detail_parent.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        initToolBar(toolbar_clude, true, "听课记录详情",-1,true);
        toLoadeDetailData();
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

    private void showMyLessonNotesDetailData() {
        tvLessonNotesDetailTeachername.setText(result.getLessonTeacher());
        tvLessonNotesDetailLessonname.setText(result.getLessonTitle());
        tvLessonNotesDetailLessontype.setText(result.getLessonType());
        tvLessonNotesDetailSubject.setText(result.getSubjectName());
        tvLessonNotesDetailLessontime.setText(result.getMonth() + "月" + result.getDay() + "日第" + result
                .getNum() + "节");
        tvLessonNotesDetailLessonclass.setText(result.getGradeName() + result.getClassName());
        tvLessonNotesDetailLessonrecord.setText(result.getLessonContext());
        tvLessonNotesDetailLessonanalysis.setText(result.getLessonAdvice());
        tvLessonNotesDetailCommittime.setText(result.getCreateTime());
        tvLessonNotesDetailBrowsecount.setText("(" + ToolRegex.checkAcharApearTimesInAString(result
                .getBrowseNames(), ',') + ")");
        tvLesssonNotesDetailBrowsename.setText(result.getBrowseNames());
        int commentCount = result.getReadOverList().size();
        tvLessonNotesDetailCommentcount.setText("(" + commentCount + ")");
        StringBuffer stringBuffer = new StringBuffer();
        llLessonNotesDetailComentcontainer.removeAllViews();
        for (int i = 0; i < commentCount; i++) {
            stringBuffer.append(result.getReadOverList().get(i).getReaderName() + ",");
            View commentViewItem = myActivity.getLayoutInflater().inflate(R.layout
                    .item_lesson_notes_comment_detail, null, false);
            CircleImageView iv_item_lesson_notes_comentdetail_img = (CircleImageView) commentViewItem.findViewById(R.id
                    .iv_item_lesson_notes_comentdetail_img);
            TextView tv_item_lesson_notes_commentdetail_commentatorname = (TextView) commentViewItem.findViewById(R.id
                    .tv_item_lesson_notes_commentdetail_commentatorname);
            TextView tv_item_lesson_notes_commentdetail_creatime = (TextView) commentViewItem.findViewById(R.id
                    .tv_item_lesson_notes_commentdetail_creatime);
            TextView tv_item_lesson_notes_commentdetail_content = (TextView) commentViewItem.findViewById(R.id
                    .tv_item_lesson_notes_commentdetail_content);
            LoadBitmapUtils.LoadHeadImagview(baseFragmentActivity, result.getReadOverList()
                            .get(i).getImgUrl(),
                    iv_item_lesson_notes_comentdetail_img);
            tv_item_lesson_notes_commentdetail_commentatorname.setText(result.getReadOverList()
                    .get(i).getReaderName());
            tv_item_lesson_notes_commentdetail_creatime.setText(result.getReadOverList()
                    .get(i).getReadTime());
            tv_item_lesson_notes_commentdetail_content.setText(result.getReadOverList()
                    .get(i).getComment());
            tvLesssonNotesDetailCommentname.setText(stringBuffer.toString());
            llLessonNotesDetailComentcontainer.addView(commentViewItem);
        }
        nestscroll_lesson_notes_detail_parent.setVisibility(View.VISIBLE);
    }
    @Override
    protected void onClickEvent(View view) {
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
    public static BaseFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putSerializable("id", id);
        LessonNotesDetailFragment fragment = new LessonNotesDetailFragment();
        fragment.setArguments(args);
        return fragment;
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
