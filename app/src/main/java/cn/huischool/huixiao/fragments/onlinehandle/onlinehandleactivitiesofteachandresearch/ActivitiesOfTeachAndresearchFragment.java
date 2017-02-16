package cn.huischool.huixiao.fragments.onlinehandle.onlinehandleactivitiesofteachandresearch;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.rey.material.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.adapters.onlinehandle.MyActivitiesOfTeachAndResearchAdapter;
import cn.huischool.huixiao.bean.MyActivitiesOfTeachAndResearchBean;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.TooSnackbar;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.DividerItemDecoration;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.LoadeMoreRecyclerOnScrollListener;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/8/17.
 */
public class ActivitiesOfTeachAndresearchFragment extends BaseFragment {
    private Toolbar toolbar_clude;
    private TextView tv_title_clude;
    private ImageButton imagbtn_action_clude;
    private RecyclerView rlv_fragment_activitiesofteachandresearch_itemcontainer;
    private SwipeRefreshLayout swip_fragment_activitiesofteachandresearch;
    private AppCompatActivity myActivity;
    private LinearLayoutManager layoutManager;
    private CoordinatorLayout cool_my_activitiesofteachandresearch_online;
    private List<MyActivitiesOfTeachAndResearchBean.ResultsBean.ElementsBean> myActivitiesOfTeachAndResearchElementsList = new
            ArrayList<>();
    private MyActivitiesOfTeachAndResearchAdapter adapter;
    private int currentPageOfLoad = 1;
    private LoadeMoreRecyclerOnScrollListener loademore;
    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_handle_activitiesofteachandresearch, null,
                false);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        imagbtn_action_clude = (ImageButton) view.findViewById(R.id.imagbtn_action_clude);
        rlv_fragment_activitiesofteachandresearch_itemcontainer = (RecyclerView) view.findViewById(R.id
                .rlv_fragment_activitiesofteachandresearch_itemcontainer);
        swip_fragment_activitiesofteachandresearch = (SwipeRefreshLayout) view.findViewById(R.id
                .swip_fragment_activitiesofteachandresearch);
        cool_my_activitiesofteachandresearch_online = (CoordinatorLayout) view.findViewById(R.id
                .cool_my_activitiesofteachandresearch_online);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        settoobar();
        setAdapter();
        setSwip();
        if (myActivitiesOfTeachAndResearchElementsList.size() == 0) {
            showProgressDialog("正在加载");
            MyActivitiesOfTeachAndResearchLoad(currentPageOfLoad + "");
        }
        setOnActivitiesOfTeachAndResearchListner();
    }
    private void settoobar() {
        setHasOptionsMenu(true);
        initToolBar(toolbar_clude, true,"我的教研活动",R.drawable.fab_add,true);
        imagbtn_action_clude.setOnClickListener(this);
    }
    private void setOnActivitiesOfTeachAndResearchListner() {
        loademore = new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                showProgressDialog("正在加载");
                currentPageOfLoad = currentPage;
                MyActivitiesOfTeachAndResearchLoad(currentPage + "");
            }
        };
        rlv_fragment_activitiesofteachandresearch_itemcontainer.addOnScrollListener(loademore);

        rlv_fragment_activitiesofteachandresearch_itemcontainer.addOnItemTouchListener(new OnRecyclerItemClickListener(rlv_fragment_activitiesofteachandresearch_itemcontainer,
                rlv_fragment_activitiesofteachandresearch_itemcontainer.getContext()) {//封装了为rescyler 封装了监听
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                if (myActivitiesOfTeachAndResearchElementsList.get(vh
                        .getAdapterPosition()).getSubmitStatus().equals("1")) {
                    addFragment(ActivitiesOfTeachAndResearchDetailFragment.newInstance(myActivitiesOfTeachAndResearchElementsList.get(vh
                            .getAdapterPosition()).getId()));
                } else if (myActivitiesOfTeachAndResearchElementsList.get(vh
                        .getAdapterPosition()).getSubmitStatus().equals("0")) {
                    addFragment(ToCommitActivityOfEditedFragment.newInstance(myActivitiesOfTeachAndResearchElementsList.get(vh
                            .getAdapterPosition()).getId()));
                }
                LogUtil.d("讲课记录id" + myActivitiesOfTeachAndResearchElementsList.get(vh
                        .getAdapterPosition()).getId());
            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {
            }
        });

    }

    private void setSwip() {
        swip_fragment_activitiesofteachandresearch.setSize(SwipeRefreshLayout.DEFAULT);
        swip_fragment_activitiesofteachandresearch.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        swip_fragment_activitiesofteachandresearch.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                MyActivitiesOfTeachAndResearchLoad(1 + "");

            }
        });
    }

    private void MyActivitiesOfTeachAndResearchLoad(final String page) {

        DataAchieve.toGetMyActivitiesOfTeachAndResearchList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                {
                    if (code != 1000) {
                        dismissProgressDialog();
                        return;

                    } else {
                        MyActivitiesOfTeachAndResearchBean.ResultsBean ments = (
                                (MyActivitiesOfTeachAndResearchBean
                                )
                                object).getResults();
                        if (ments != null) {
                            if (page.equals("1")) {
                                loademore.setCurrentPage(1);
                                currentPageOfLoad = 1;
                                if (CollectionUtils.isListNull(ments.getElements())) {

                                    TooSnackbar.showMessage(cool_my_activitiesofteachandresearch_online,
                                            "您还未创建教研活动");
                                } else {

                                    loademore.setCurrentPage(++currentPageOfLoad);

                                }
                                myActivitiesOfTeachAndResearchElementsList.clear();
                                myActivitiesOfTeachAndResearchElementsList.addAll(ments.getElements
                                        ());
                                adapter.addList(myActivitiesOfTeachAndResearchElementsList);
                            } else {
                                if (CollectionUtils.isListNull(ments.getElements())) {

                                    TooSnackbar.showMessage(cool_my_activitiesofteachandresearch_online,
                                            "没有更多教研活动啦");
                                } else {

                                    loademore.setCurrentPage(++currentPageOfLoad);

                                }
                                myActivitiesOfTeachAndResearchElementsList.addAll(ments.getElements
                                        ());
                                adapter.addList(myActivitiesOfTeachAndResearchElementsList);
                            }
                            if (swip_fragment_activitiesofteachandresearch.isRefreshing()) {

                                swip_fragment_activitiesofteachandresearch.setRefreshing(false);
                            }
                        }
                        dismissProgressDialog();
                        if (swip_fragment_activitiesofteachandresearch.isRefreshing()) {

                            swip_fragment_activitiesofteachandresearch.setRefreshing(false);
                        }
                    }
                }
            }
        }, page, "12", CustomApplication.userInfor.getUserId(), "");
    }

    private void setAdapter() {
        layoutManager = new LinearLayoutManager(myActivity);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlv_fragment_activitiesofteachandresearch_itemcontainer.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        rlv_fragment_activitiesofteachandresearch_itemcontainer.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyActivitiesOfTeachAndResearchAdapter(myActivity,
                myActivitiesOfTeachAndResearchElementsList);
        rlv_fragment_activitiesofteachandresearch_itemcontainer.addItemDecoration(new DividerItemDecoration(myActivity,
                layoutManager
                        .getOrientation()));

        rlv_fragment_activitiesofteachandresearch_itemcontainer.setAdapter(adapter);
    }


    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {

            case R.id.imagbtn_action_clude:

                addFragment(new ToCommitActivitiesOfTeachAndResearchFragment());
        }
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
}
