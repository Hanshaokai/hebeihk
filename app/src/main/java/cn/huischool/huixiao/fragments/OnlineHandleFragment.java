package cn.huischool.huixiao.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.home.MainActivity;
import cn.huischool.huixiao.activitys.onlinehandle.ActivitiesOfTeachAndresearchActivity;
import cn.huischool.huixiao.activitys.onlinehandle.AfficheActivity;
import cn.huischool.huixiao.activitys.onlinehandle.ApprovalActivity;
import cn.huischool.huixiao.activitys.onlinehandle.CheckCourseWareActivity;
import cn.huischool.huixiao.activitys.onlinehandle.CheckGrammarActivity;
import cn.huischool.huixiao.activitys.onlinehandle.LessonNotesActivity;
import cn.huischool.huixiao.activitys.onlinehandle.MeetingRecordActivity;
import cn.huischool.huixiao.activitys.onlinehandle.MyCourseWareActivity;
import cn.huischool.huixiao.activitys.onlinehandle.MyTeacherPlanActivity;
import cn.huischool.huixiao.activitys.onlinehandle.NotifiActivity;
import cn.huischool.huixiao.activitys.onlinehandle.ResearchTableActivity;
import cn.huischool.huixiao.activitys.onlinehandle.SchoolResourceActivity;
import cn.huischool.huixiao.activitys.onlinehandle.StudyNotesActivity;
import cn.huischool.huixiao.bean.CountOfScheduleBean;
import cn.huischool.huixiao.common.utils.CheckeAuthorityUtils;
import cn.huischool.huixiao.common.utils.ScheduleCountCallBackUtil;
import cn.huischool.huixiao.common.widget.widgetofbindbadgeview.BadgeView;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

public class OnlineHandleFragment extends BaseFragment implements ScheduleCountCallBackUtil.ScheduleCllaBack {
    /* private AppBarLayout online_appbar;
     private ViewPager online_container;
     private FloatingActionButton online_fab;
     private TabLayout online_tabs;*/
    private Toolbar online_toolbar;
    private RadioButton rbt_notifi_item_handle_fragment;
    private RadioButton rbt_affiche_item_handle_fragment;
    private RadioButton rbt_approval_item_handle_fragment;
    private MainActivity mainActivity;
    private RadioButton rbt_schoolresource_item_handle_frgament;
    private RadioButton rbt_platformresource_item_handle_fragment;
    private RadioButton rbt_minePlan_item_handle_fragment;
    private RadioButton rbt_courseware_item_handle_fragment;
    private RadioButton rbt_checkPlan_item_handle_fragment;
    private RadioButton rbt_checkCourseWare_item_handle_fragment;
    private RadioButton rbt_lessonnotes_item_handle_fragment;
    private RadioButton rbt_studynotes_item_handle_fragment;
    private RadioButton rbt_meetingrecord_item_handle_fragment;
    private RadioButton rbt_activitiesofteachingandresearch_item_handle_fragment;
    private int afficheCount;//待办事项数量
    private int noticeCount;
    private int approvalCount;
    private BadgeView afficheCountView;
    private BadgeView approvalCountView;
    private BadgeView noticeCountView;
    private SwipeRefreshLayout swip_online_fragment;
    private RadioButton rbt_activitiesof_reserch_table_item_handle_fragment;

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_onlinehandle, null, false);
       /* online_appbar = (AppBarLayout) view.findViewById(R.id.online_appbar);*/
      /*  online_container = (ViewPager) view.findViewById(R.id.online_container);
        online_fab = (FloatingActionButton) view.findViewById(R.id.online_fab);*/
        online_toolbar = (Toolbar) view.findViewById(R.id.online_toolbar);

       /* online_tabs = (TabLayout) view.findViewById(R.id.online_tabs);*/
        swip_online_fragment =
                (SwipeRefreshLayout) view.findViewById(R.id.swip_online_fragment);
        rbt_notifi_item_handle_fragment = (RadioButton) view.findViewById(R.id
                .rbt_notifi_item_handle_fragment);//通知
        rbt_affiche_item_handle_fragment = (RadioButton) view.findViewById(R.id
                .rbt_affiche_item_handle_fragment);//公告
        rbt_approval_item_handle_fragment = (RadioButton) view.findViewById(R.id
                .rbt_approval_item_handle_fragment);//审批


        rbt_schoolresource_item_handle_frgament = (RadioButton) view.findViewById(R.id
                .rbt_schoolresource_item_handle_frgament);//学校资源

        rbt_platformresource_item_handle_fragment = (RadioButton) view.findViewById(R.id
                .rbt_platformresource_item_handle_fragment);//平台资源
        rbt_courseware_item_handle_fragment = (RadioButton) view.findViewById(R.id
                .rbt_courseware_item_handle_fragment);//课件

        rbt_checkCourseWare_item_handle_fragment = (RadioButton) view.findViewById(R.id
                .rbt_checkCourseWare_item_handle_fragment);//查案课件
        rbt_minePlan_item_handle_fragment = (RadioButton) view.findViewById(R.id
                .rbt_minePlan_item_handle_fragment);//教案

        rbt_checkPlan_item_handle_fragment = (RadioButton) view.findViewById(R.id
                .rbt_checkPlan_item_handle_fragment);//查阅教案
        rbt_activitiesof_reserch_table_item_handle_fragment = (RadioButton) view.findViewById(R.id
                .rbt_activitiesof_reserch_table_item_handle_fragment);//教研表


        rbt_lessonnotes_item_handle_fragment = (RadioButton) view.findViewById(R.id
                .rbt_lessonnotes_item_handle_fragment);


        rbt_studynotes_item_handle_fragment =
                (RadioButton) view.findViewById(R.id
                        .rbt_studynotes_item_handle_fragment);
        rbt_meetingrecord_item_handle_fragment = (RadioButton) view.findViewById(R.id
                .rbt_meetingrecord_item_handle_fragment);
        rbt_activitiesofteachingandresearch_item_handle_fragment = (RadioButton) view.findViewById(R.id
                .rbt_activitiesofteachingandresearch_item_handle_fragment);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        ScheduleCountCallBackUtil.getIntence().add(this);//加入回调待办事项数量
        setOnClicListener();
        onliInitTbar();
        setSwip();


        if (CheckeAuthorityUtils.isAuthority("B00007")) {//遍历权限查找所属权限

            rbt_checkCourseWare_item_handle_fragment.setVisibility(View.VISIBLE);
            rbt_checkPlan_item_handle_fragment.setVisibility  (View.VISIBLE);
        }

    /*    if (online_container != null) {
            setupViewPager(online_container);
        }、
        online_tabs.setupWithViewPager  (online_container);
*/
    }

    private void setBadeCount() {

        if (afficheCountView == null) {
            afficheCountView = new BadgeView(mainActivity);
            afficheCountView.setTargetView(rbt_affiche_item_handle_fragment);
            afficheCountView.setBadgeMargin(-1, -1, 32, -1);
        }
        afficheCountView.setBadgeCount(afficheCount);


        if (approvalCountView == null) {
            approvalCountView = new BadgeView(mainActivity);
            approvalCountView.setTargetView(rbt_approval_item_handle_fragment);
            approvalCountView.setBadgeMargin(-1, -1, 32, -1);
        }
        approvalCountView.setBadgeCount(approvalCount);


        if (noticeCountView == null) {
            noticeCountView = new BadgeView(mainActivity);
            noticeCountView.setTargetView(rbt_notifi_item_handle_fragment);
            noticeCountView.setBadgeMargin(-1, -1, 32, -1);
        }
        noticeCountView.setBadgeCount(noticeCount);

    }

    private void loadeBageCount() {
        DataAchieve.getCountOfSchedule(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {

                if (code == 1000) {
                    if (object != null) {

                        CountOfScheduleBean.ResultsBean result = ((CountOfScheduleBean
                                ) object).getResults();
                        afficheCount = result.getAfficheCount();
                        approvalCount = result.getApprovalCount();
                        noticeCount = result.getNoticeCount();
                        Log.d("tag", afficheCount + "shenpi" + approvalCount + "tongzhi" + noticeCount);
                        setBadeCount();
                        swip_online_fragment.setRefreshing(false);

                    }

                } else {
                    swip_online_fragment.setRefreshing(false);
                }

            }
        }, CustomApplication.userInfor.getUserId());


    }

    private void setOnClicListener() {
        rbt_notifi_item_handle_fragment.setOnClickListener(this);
        rbt_affiche_item_handle_fragment.setOnClickListener(this);
        rbt_approval_item_handle_fragment.setOnClickListener(this);

        rbt_minePlan_item_handle_fragment.setOnClickListener(this);
        rbt_courseware_item_handle_fragment.setOnClickListener(this);
        rbt_checkCourseWare_item_handle_fragment.setOnClickListener(this);
        rbt_checkPlan_item_handle_fragment.setOnClickListener(this);


        rbt_lessonnotes_item_handle_fragment.setOnClickListener(this);
        rbt_studynotes_item_handle_fragment.setOnClickListener(this);
        rbt_meetingrecord_item_handle_fragment.setOnClickListener(this);
        rbt_activitiesofteachingandresearch_item_handle_fragment.setOnClickListener(this);
        rbt_activitiesof_reserch_table_item_handle_fragment.setOnClickListener(this);

    }

    private void onliInitTbar() {
        mainActivity = (MainActivity) ct;
        online_toolbar.setTitle("");


    }

    /*  private void setupViewPager(ViewPager viewPager) {
          OnlineViewpagerAdapter adapter = new OnlineViewpagerAdapter(getChildFragmentManager());
          adapter.addFragment(new HandleFragment(), "办公");
          adapter.addFragment(new HandleFragment(), "备课");
          online_container.setOffscreenPageLimit(2);
          online_container.setAdapter(adapter);
      }
  */
    private void setSwip() {
        swip_online_fragment.setSize(SwipeRefreshLayout.DEFAULT);
        swip_online_fragment.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);

        swip_online_fragment.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadeBageCount();

            }
        });

    }

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {

            case R.id.rbt_notifi_item_handle_fragment:
                Intent intent = new Intent(ct, NotifiActivity.class);
                startActivity(intent);
                break;


            case R.id.rbt_affiche_item_handle_fragment:
                Intent intent2 = new Intent(ct, AfficheActivity.class);
                startActivity(intent2);

                break;


            case R.id.rbt_approval_item_handle_fragment:
                Intent intent3 = new Intent(ct, ApprovalActivity.class);
                startActivity(intent3);
                break;


            case R.id.rbt_minePlan_item_handle_fragment:

                Intent intentPlan = new Intent(ct, MyTeacherPlanActivity.class);
                startActivity(intentPlan);
                break;


            case R.id.rbt_checkPlan_item_handle_fragment:

                Intent intentcheckPlan = new Intent(ct, CheckGrammarActivity.class);
                startActivity(intentcheckPlan);
                break;


            case R.id.rbt_courseware_item_handle_fragment:

                Intent intentWare = new Intent(ct, MyCourseWareActivity.class);
                startActivity(intentWare);
                break;

            case R.id.rbt_checkCourseWare_item_handle_fragment:

                Intent intentCheckWare = new Intent(ct, CheckCourseWareActivity.class);
                startActivity(intentCheckWare);
                break;

            case R.id.rbt_schoolresource_item_handle_frgament:
                Intent intent_schoolResource = new Intent(ct, SchoolResourceActivity.class);
                startActivity(intent_schoolResource);
                break;
            case R.id.rbt_lessonnotes_item_handle_fragment:
                Intent intent_lessonnotes = new Intent(ct, LessonNotesActivity.class);
                startActivity(intent_lessonnotes);
                break;
            case R.id.rbt_studynotes_item_handle_fragment:
                Intent intent_studynotes = new Intent(ct, StudyNotesActivity.class);
                startActivity(intent_studynotes);
                break;
            case R.id.rbt_meetingrecord_item_handle_fragment:
                Intent intent_meetingrecord = new Intent(ct, MeetingRecordActivity.class);
                startActivity(intent_meetingrecord);
                break;
            case R.id.rbt_activitiesofteachingandresearch_item_handle_fragment:
                Intent intent_teareseactivities = new Intent(ct, ActivitiesOfTeachAndresearchActivity
                        .class);
                startActivity(intent_teareseactivities);
                break;
            case R.id.rbt_activitiesof_reserch_table_item_handle_fragment:
                Intent intent_research_table = new Intent(ct, ResearchTableActivity.class);
                startActivity(intent_research_table);
                break;
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        loadeBageCount();//每次可见 刷新待办数量
    }

    @Override
    public void scheduleBack() {
        // loadeBageCount();//暂未用
    }
}
