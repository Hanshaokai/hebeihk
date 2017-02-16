package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlecheckcourseware;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.CheckCourseWareActivity;
import cn.huischool.huixiao.adapters.onlinehandle.CheckCourseWareAdapter;
import cn.huischool.huixiao.common.widget.widgetofbindtagview.TagAdapter;
import cn.huischool.huixiao.bean.CheckCourseWareListBean;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.TooSnackbar;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.DividerItemDecoration;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.LoadeMoreRecyclerOnScrollListener;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.common.widget.widgetofbindtagview.TagFlowLayout;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlemycourseware.MineCourseWareDetailFragment;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/7/26.
 */
public class CheckCourseWareFragment extends BaseFragment {
    private TagFlowLayout tagfl_fragment_checkcourseware_subject;
    private TagFlowLayout tagfl_fragment_checkcourseware_class;
    private Toolbar toolbar_clude;
    private TextView tv_title_clude;
    private CheckCourseWareActivity myActivity;
    private String[] subjectitems;
    private String[] classitems;
    private SwipeRefreshLayout swip_fragment_checkcourseware;
    private RecyclerView rlv_fragment_checkcourseware_itemcontainer;
    private List<CheckCourseWareListBean.ResultsBean> checkCourseWareElementsList = new ArrayList<>();
    private CheckCourseWareAdapter adapter;
    private String subject = "全部";
    private String grade = "全部";
    private LinearLayoutManager layoutManager;
    private CoordinatorLayout cool_check_coureseware_fragment;
    private int currentPageOfload = 1;
    private LoadeMoreRecyclerOnScrollListener loademore;
    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = (CheckCourseWareActivity) baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_online_checkcourseware, null, false);
        cool_check_coureseware_fragment = (CoordinatorLayout) view.findViewById
                (R.id.cool_check_coureseware_fragment);
        tagfl_fragment_checkcourseware_subject = (TagFlowLayout) view.findViewById(R.id
                .tagfl_fragment_checkcourseware_subject);
        tagfl_fragment_checkcourseware_class = (TagFlowLayout) view.findViewById(R.id
                .tagfl_fragment_checkcourseware_class);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        rlv_fragment_checkcourseware_itemcontainer = (RecyclerView) view.findViewById(R.id
                .rlv_fragment_checkcourseware_itemcontainer);
        swip_fragment_checkcourseware = (SwipeRefreshLayout) view.findViewById(R.id
                .swip_fragment_checkcourseware);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        initToolBar(toolbar_clude,true,"查阅课件",-1,true);
        subjectitems = myActivity.getResources().getStringArray(R.array.subjectitem);
        classitems = myActivity.getResources().getStringArray(R.array.classitem);
        setAdapter();
        setSwip();
        setListner();
        if (checkCourseWareElementsList.size() == 0) {
            showProgressDialog("正在加载...");
            loadeCourseWareList(currentPageOfload + "", subject, grade);
        }
    }

    private void setListner() {

        loademore = new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {

            @Override
            public void onLoadMore(int currentPage) {
                currentPageOfload = currentPage;
                showProgressDialog("正在加载...");
                loadeCourseWareList(currentPage + "", subject, grade);
            }
        };
        rlv_fragment_checkcourseware_itemcontainer.addOnScrollListener(loademore);

        rlv_fragment_checkcourseware_itemcontainer.addOnItemTouchListener(new OnRecyclerItemClickListener(rlv_fragment_checkcourseware_itemcontainer,
                rlv_fragment_checkcourseware_itemcontainer.getContext()) {//封装了为rescyler 封装了监听

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {


                addFragment(MineCourseWareDetailFragment.newInstance(checkCourseWareElementsList.get(vh
                        .getAdapterPosition()).getId()));


            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });
    }

    private void loadeCourseWareList(final String page, final String subject, final String grade) {


        DataAchieve.togetCheckCourseWareList(new DataAchieve.SuccessCallBack() {
                                                 @Override
                                                 public void handle(int code, Object object) {

                                                     if (code != 1000) {
                                                         dismissProgressDialog();
                                                         if (swip_fragment_checkcourseware.isRefreshing()) {
                                                             swip_fragment_checkcourseware.setRefreshing(false);
                                                         }

                                                         return;

                                                     } else {

                                                         List<CheckCourseWareListBean.ResultsBean>
                                                                 elementsList =
                                                                 ((CheckCourseWareListBean
                                                                         )
                                                                         object).getResults();
                                                         if (elementsList != null) {
                                                             if (page.equals("1")) {
                                                                 loademore.setCurrentPage(1);
                                                                 currentPageOfload = 1;
                                                                 if (CollectionUtils.isListNull
                                                                         (elementsList)) {
                                                                     TooSnackbar.showMessage
                                                                             (cool_check_coureseware_fragment, "没有可查阅的课件");
                                                                /* if (elementsList.size() < 12) {//每页满足规定的条目后 才可以继续请求下一页 否则继续请求当前页
                                                                     loademore.setCurrentPage
                                                                             (Integer.parseInt(page));
                                                                 }*/
                                                                 } else {

                                                                     loademore.setCurrentPage(++currentPageOfload);

                                                                 }

                                                                 checkCourseWareElementsList.clear();
                                                                 checkCourseWareElementsList.addAll
                                                                         (elementsList);
                                                                 adapter.addList(checkCourseWareElementsList);
                                                             } else {

                                                                 if (CollectionUtils.isListNull
                                                                         (elementsList)) {
                                                                     TooSnackbar.showMessage
                                                                             (cool_check_coureseware_fragment, "没有更多的可查阅的课件啦");
                                                                 } else {

                                                                     loademore.setCurrentPage(++currentPageOfload);

                                                                 }
                                                                 checkCourseWareElementsList.addAll
                                                                         (elementsList);
                                                                 adapter.addList(checkCourseWareElementsList);
                                                             }
                                                             if (swip_fragment_checkcourseware.isRefreshing()) {

                                                                 swip_fragment_checkcourseware.setRefreshing(false);
                                                             }
                                                         }
                                                         dismissProgressDialog();
                                                         if (swip_fragment_checkcourseware.isRefreshing()) {

                                                             swip_fragment_checkcourseware.setRefreshing(false);
                                                         }


                                                     }


                                                 }


                                             }, CustomApplication.userInfor.getRemarkId(),
                CustomApplication.userInfor.getSchoolId(), subject, grade, "", page,
                "12");

    }

    private void setSwip() {
        swip_fragment_checkcourseware.setSize(SwipeRefreshLayout.DEFAULT);
        swip_fragment_checkcourseware.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        swip_fragment_checkcourseware.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadeCourseWareList(1 + "", subject, grade);

            }
        });
    }

    private void setAdapter() {


        tagfl_fragment_checkcourseware_subject.setAdapter(new TagAdapter(subjectitems) {
                                                              @Override
                                                              public View getView(ViewGroup parent, int position, Object o) {
                                                                  int point = 0;
                                                                  TextView tv = (TextView)
                                                                          myActivity.getLayoutInflater().inflate
                                                                                  (R.layout.tag_item_tv,
                                                                                          parent, false);
                                                                  LogUtil.d((String) o);
                                                                  tv.setText((String) o);
                                                                  int lenth = subjectitems.length;
                                                                  for (int i = 0; i < lenth;
                                                                       i++) {

                                                                      if (subject.equals
                                                                              (subjectitems[i])) {

                                                                          point = i;

                                                                      }

                                                                  }
                                                                  if (point == position)
                                                                      tv.setTextColor(Color.BLACK);
                                                                  return tv;
                                                              }

                                                          }
        );
        tagfl_fragment_checkcourseware_subject.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(ViewGroup parent, View view, int position) {

                int count = parent.getChildCount();
                LogUtil.d("点击tag");
                for (int i = 0; i < count; i++) {
                    TextView t = (TextView) (parent.getChildAt(i).findViewById(R.id
                            .tv_tag_flexitem));
                    t.setTextColor(Color.LTGRAY);
                }

                TextView t = (TextView) (parent.getChildAt(position).findViewById(R.id
                        .tv_tag_flexitem));
                t.setTextColor(Color.BLACK);
                subject = (String) t
                        .getText();
                showProgressDialog("正在加载...");
                loadeCourseWareList("1", subject, grade);
                loademore.setCurrentPage(1);
            }
        });
        tagfl_fragment_checkcourseware_class.setAdapter(new TagAdapter(classitems) {
            @Override
            public View getView(ViewGroup parent, int position, Object o) {
                int point = 0;
                TextView tv = (TextView) myActivity.getLayoutInflater().inflate
                        (R.layout.tag_item_tv,
                                parent, false);
                tv.setText((String) o);
                int lenth = classitems.length;
                for (int i = 0; i < lenth;
                     i++) {

                    if (grade.equals
                            (classitems[i])) {

                        point = i;

                    }

                }
                if (point == position)
                    tv.setTextColor(Color.BLACK);
                return tv;
            }


        });
      /*  tagfl_fragment_checkcourseware_class.setJustifyContent(FlexboxLayout
                .JUSTIFY_CONTENT_FLEX_START);*/

        tagfl_fragment_checkcourseware_class.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(ViewGroup parent, View view, int position) {
                int count = parent.getChildCount();
                LogUtil.d(count + "点击tag");
                for (int i = 0; i < count; i++) {
                    TextView t = (TextView) (parent.getChildAt(i).findViewById(R.id
                            .tv_tag_flexitem));
                    t.setTextColor(Color.LTGRAY
                    );
                }
                TextView t = (TextView) (parent.getChildAt(position).findViewById(R.id
                        .tv_tag_flexitem));
                t.setTextColor(Color.BLACK);
                grade = (String) t
                        .getText();
                showProgressDialog("正在加载...");
                loadeCourseWareList("1", subject, grade);
                loademore.setCurrentPage(1);
            }
        });
        layoutManager = new LinearLayoutManager(myActivity);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlv_fragment_checkcourseware_itemcontainer.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        rlv_fragment_checkcourseware_itemcontainer.setItemAnimator(new DefaultItemAnimator());
        adapter = new CheckCourseWareAdapter(myActivity, checkCourseWareElementsList);
        rlv_fragment_checkcourseware_itemcontainer.addItemDecoration(new DividerItemDecoration(myActivity,
                layoutManager
                        .getOrientation()));

        rlv_fragment_checkcourseware_itemcontainer.setAdapter(adapter);

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

    }


}
