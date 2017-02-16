package cn.huischool.huixiao.fragments.onlinehandle.onlineapproval;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.adapters.onlinehandle.InformApprovalAdapter;
import cn.huischool.huixiao.bean.ReceivApprovalBean;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.TooSnackbar;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.LoadeMoreRecyclerOnScrollListener;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.framework.BaseLazyLoadefragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/8/23.
 */
public class InformMeOfApprovalFragment extends BaseLazyLoadefragment {

    private AppCompatActivity myActivity;
    private RecyclerView inform_approval_recycler;
    private SwipeRefreshLayout inform_approval_swip;
    private CoordinatorLayout coor_inform_approval;
    private LinearLayoutManager layoutManager;
    private InformApprovalAdapter adapter;
    private int currentPageOfLoad = 1;
    private LoadeMoreRecyclerOnScrollListener loadeMore;
    private List<ReceivApprovalBean.ResultsBean> informApprovalElementsList = new ArrayList<ReceivApprovalBean
            .ResultsBean>();

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_inform_me_approval, null, false);
        inform_approval_recycler = (RecyclerView) view.findViewById(R.id.inform_approval_recycler);
        inform_approval_swip = (SwipeRefreshLayout) view.findViewById(R.id.inform_approval_swip);
        coor_inform_approval = (CoordinatorLayout) view.findViewById(R.id.coor_inform_approval);
        return view;

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setSwip();
        recycletsendSetAdpater();
        if (informApprovalElementsList.size() == 0) {
            showProgressDialog("正在加载...");
            informOfApprovalLoad(currentPageOfLoad + "");
        }

        informApprovalListener();
    }

    private void informApprovalListener() {

        loadeMore = new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {


            @Override
            public void onLoadMore(int currentPage) {
                currentPageOfLoad = currentPage;
                showProgressDialog("正在加载...");
                informOfApprovalLoad(currentPage + "");
            }
        };
        inform_approval_recycler.addOnScrollListener(loadeMore);

        inform_approval_recycler.addOnItemTouchListener(new OnRecyclerItemClickListener(inform_approval_recycler,
                inform_approval_recycler.getContext()) {//封装了为rescyler 封装了监听

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                Log.d("tag", vh.getAdapterPosition() + "==OnRescylerItemclikListener点击了");

                addFragment(new OnLineInformApprovalDetailFragment().newInstance
                        (informApprovalElementsList.get(vh.getAdapterPosition()).getApprovalId()));
            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });


    }

    private void informOfApprovalLoad(final String page) {
        LogUtil.d("加载第几页" + page);
        DataAchieve.getReceivApprovalList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                {
                    if (code != 1000) {
                        dismissProgressDialog();
                        if (inform_approval_swip.isRefreshing()) {

                            inform_approval_swip.setRefreshing(false);
                        }
                        return;
                    } else {
                        List<ReceivApprovalBean.ResultsBean> ments = ((ReceivApprovalBean
                                )
                                object).getResults();
                        if (ments != null) {
                            if (page.equals("1")) {
                                loadeMore.setCurrentPage(1);
                                currentPageOfLoad = 1;
                                if (CollectionUtils.isListNull(ments)) {
                                    TooSnackbar.showMessage(coor_inform_approval, "没有数据啦");
                                } else {

                                    loadeMore.setCurrentPage(++currentPageOfLoad);

                                }

                                informApprovalElementsList.clear();
                                informApprovalElementsList.addAll(ments);
                                adapter.addList(informApprovalElementsList);
                            } else {
                                if (CollectionUtils.isListNull(ments))

                                {
                                    TooSnackbar.showMessage(coor_inform_approval, "没有数据啦");
                                } else {

                                    loadeMore.setCurrentPage(++currentPageOfLoad);

                                }
                                informApprovalElementsList.addAll(ments);
                                adapter.addList(informApprovalElementsList);
                            }
                            if (inform_approval_swip.isRefreshing()) {

                                inform_approval_swip.setRefreshing(false);
                            }
                        }
                        dismissProgressDialog();
                        if (inform_approval_swip.isRefreshing()) {

                            inform_approval_swip.setRefreshing(false);
                        }
                    }
                }
            }
        }, page, "12", CustomApplication.userInfor.getUserId(), "", "1");
    }

    private void recycletsendSetAdpater() {
        layoutManager = new LinearLayoutManager(myActivity);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        inform_approval_recycler.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        inform_approval_recycler.setItemAnimator(new DefaultItemAnimator());
        adapter = new InformApprovalAdapter(myActivity, informApprovalElementsList);
        //  receiv_affiche_recycler.addItemDecoration(new DividerItemDecoration(ct, layoutManager
        //         .getOrientation()));

        inform_approval_recycler.setAdapter(adapter);

    }

    private void setSwip() {

        inform_approval_swip.setSize(SwipeRefreshLayout.DEFAULT);
        inform_approval_swip.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);

        inform_approval_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                informOfApprovalLoad(1 + "");
                LogUtil.d("刷新第一页");

            }
        });


    }

    @Override
    protected void onClickEvent(View view) {

    }

}
