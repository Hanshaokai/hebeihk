package cn.huischool.huixiao.fragments.onlinehandle.schoolresource;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.SchoolResourceActivity;
import cn.huischool.huixiao.adapters.onlinehandle.SchoolTeacherPlansAdapter;
import cn.huischool.huixiao.bean.SchoolShareLessonPlansBean;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.LoadeMoreRecyclerOnScrollListener;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/6/21.
 */
public class SchoolTeacherPlansFragment extends BaseFragment {

    private RecyclerView teacherPlans_schoolResources_recycler;
    private SwipeRefreshLayout teacherPlans_schoolResources_swip;
    private SchoolResourceActivity myActivity;
    private List<SchoolShareLessonPlansBean.ResultsBean.ElementsBean> lessonPlansElementList = new
            ArrayList<SchoolShareLessonPlansBean.ResultsBean.ElementsBean>();
    private SchoolTeacherPlansAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = (SchoolResourceActivity) baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_online_teacher_plans_fragment, null, false);
        teacherPlans_schoolResources_recycler = (RecyclerView) view.findViewById(R.id
                .teacherPlans_SchoolResources_recycler);
        teacherPlans_schoolResources_swip = (SwipeRefreshLayout) view.findViewById(R.id.teacherPlans_SchoolResources_swip);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setSwip();
        recycletsendSetAdpater();
        if (lessonPlansElementList.size() == 0) {
            schoolPlansLoad("1");
        }
        teacherPlansListener();


    }

    private void teacherPlansListener() {
        teacherPlans_schoolResources_recycler.addOnScrollListener(new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                schoolPlansLoad("" + currentPage);
            }
        });
        teacherPlans_schoolResources_recycler.addOnItemTouchListener(new OnRecyclerItemClickListener
                (teacherPlans_schoolResources_recycler,
                        teacherPlans_schoolResources_recycler.getContext()) {//封装了为rescyler 封装了监听

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {


            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });


    }

    private void schoolPlansLoad(final String page) {
        showProgressDialog("正在加载...");
        DataAchieve.togetSChoolShareLessonPlansList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                if (code != 1000) {
                    return;
                }

                SchoolShareLessonPlansBean.ResultsBean ments = ((SchoolShareLessonPlansBean
                        ) object).getResults();
                if (ments != null) {
                    if (page.equals("1")) {
                        lessonPlansElementList.clear();
                        lessonPlansElementList.addAll(ments
                                .getElements());
                        adapter.addList(lessonPlansElementList);
                    } else {
                        lessonPlansElementList.addAll(ments
                                .getElements());
                        adapter.addList
                                (lessonPlansElementList);
                    }

                }

                dismissProgressDialog();
                if (teacherPlans_schoolResources_swip.isRefreshing()) {

                    teacherPlans_schoolResources_swip.setRefreshing(false);
                }

            }
        }, page, "8", CustomApplication.userInfor.getSchoolId());


    }


    private void recycletsendSetAdpater() {
        layoutManager = new LinearLayoutManager(myActivity);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        teacherPlans_schoolResources_recycler.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        //设置添加删除item时候的动画
        teacherPlans_schoolResources_recycler.setItemAnimator(new DefaultItemAnimator());
        adapter = new SchoolTeacherPlansAdapter(myActivity,
                lessonPlansElementList);
        // teacherPlans_schoolResources_recycler.addItemDecoration(new DividerItemDecoration(ct, layoutManager
        //         .getOrientation()));
        teacherPlans_schoolResources_recycler.setAdapter(adapter);


    }


    private void setSwip() {

        teacherPlans_schoolResources_swip.setSize(SwipeRefreshLayout.DEFAULT);
        /*teacherPlans_schoolResources_swip.setColorSchemeColors(R.color.bg_blue_01, R.color.bg_orange,
                R.color.bg_blue_01, R.color.bg_orange);*/
        // yetsend_notfi_swip.setRefreshing(true);

        teacherPlans_schoolResources_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                schoolPlansLoad("1");
            }
        });
    }


    @Override
    protected void onClickEvent(View view) {


    }
}
