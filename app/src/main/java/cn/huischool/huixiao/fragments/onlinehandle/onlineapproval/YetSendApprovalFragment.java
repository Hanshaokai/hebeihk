package cn.huischool.huixiao.fragments.onlinehandle.onlineapproval;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.ApprovalActivity;
import cn.huischool.huixiao.adapters.onlinehandle.YetSendApprovalAdapter;
import cn.huischool.huixiao.bean.YetSendApprovalListBean;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.TooSnackbar;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.LoadeMoreRecyclerOnScrollListener;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.framework.BaseLazyLoadefragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/6/15.
 */
public class YetSendApprovalFragment extends BaseLazyLoadefragment {
    private ApprovalActivity myActivity;
    private SwipeRefreshLayout yetsend_approval_swip;
    private RecyclerView yetsend_approval_recycler;

    private LinearLayoutManager layoutManager;
    private List<YetSendApprovalListBean.ResultsBean> yetSendApprovalElementList = new
            ArrayList<YetSendApprovalListBean.ResultsBean>();
    private YetSendApprovalAdapter adapter;
    private CoordinatorLayout coor_yetsend_approval;
    private int currentPageofLoade = 1;
    private LoadeMoreRecyclerOnScrollListener loadeMore;

    @Override
    public View initView(LayoutInflater inflater) {

        view = inflater.inflate(R.layout.fragment_yetsend_approval, null, false);
        yetsend_approval_recycler = (RecyclerView) view.findViewById(R.id.yetsend_approval_recycler);
        yetsend_approval_swip = (SwipeRefreshLayout) view.findViewById(R.id.yetsend_approval_swip);
        coor_yetsend_approval = (CoordinatorLayout) view.findViewById(R.id.coor_yetsend_approval);
        myActivity = (ApprovalActivity) baseFragmentActivity;
        return view;
    }
    @Override
    public void initData(Bundle savedInstanceState) {
        setSwip();
        recycletsendSetAdpater();
        if (yetSendApprovalElementList.size() == 0) {
            showProgressDialog("正在加载...");
            yetSendLoad(currentPageofLoade + "");
        }
        setYetsendListener();
    }

    private void setYetsendListener() {
        loadeMore = new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                currentPageofLoade = currentPage;
                showProgressDialog("正在加载...");
                yetSendLoad(currentPage + "");
            }
        };
        yetsend_approval_recycler.addOnScrollListener(loadeMore);
        yetsend_approval_recycler.addOnItemTouchListener(new OnRecyclerItemClickListener
                (yetsend_approval_recycler,
                        yetsend_approval_recycler.getContext()) {//封装了为rescyler 封装了监听
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                addFragment(new OnLineYetSenApprovalDetailFragment().newInstance
                        (yetSendApprovalElementList.get(vh.getAdapterPosition()).getId()));
            }
            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });


    }

    private void yetSendLoad(final String page) {

        DataAchieve.getYetSendApprovalList(new DataAchieve.SuccessCallBack() {
                                               @Override
                                               public void handle(int code, Object object) {
                                                   {
                                                       if (code != 1000) {
                                                           dismissProgressDialog();
                                                           if (yetsend_approval_swip.isRefreshing()) {

                                                               yetsend_approval_swip.setRefreshing(false);
                                                           }
                                                           return;
                                                       } else {
                                                           List<YetSendApprovalListBean.ResultsBean> ments =
                                                                   ((YetSendApprovalListBean)
                                                                           object).getResults();
                                                           if (ments != null) {
                                                               if (page.equals("1")) {
                                                                   currentPageofLoade = 1;

                                                                   if (CollectionUtils.isListNull(ments)) {
                                                                       TooSnackbar.showMessage
                                                                               (coor_yetsend_approval, "没有数据啦");
                                                                   } else {

                                                                       loadeMore.setCurrentPage(++currentPageofLoade);

                                                                   }

                                                                   yetSendApprovalElementList.clear();
                                                                   yetSendApprovalElementList.addAll(ments
                                                                   );
                                                                   adapter.addList(yetSendApprovalElementList);
                                                               } else {
                                                                   if (CollectionUtils.isListNull(ments)) {
                                                                       TooSnackbar.showMessage
                                                                               (coor_yetsend_approval, "没有数据啦");
                                                                   } else {

                                                                       loadeMore.setCurrentPage(++currentPageofLoade);

                                                                   }

                                                                   yetSendApprovalElementList.addAll(ments
                                                                   );
                                                                   adapter.addList
                                                                           (yetSendApprovalElementList);
                                                               }
                                                               if (yetsend_approval_swip.isRefreshing()) {

                                                                   yetsend_approval_swip.setRefreshing(false);
                                                               }
                                                           }
                                                           dismissProgressDialog();
                                                           if (yetsend_approval_swip.isRefreshing()) {

                                                               yetsend_approval_swip.setRefreshing(false);
                                                           }
                                                       }
                                                   }
                                               }
                                           }, CustomApplication.userInfor.getUserId(), page, "12",
                "", "");
    }

    private void recycletsendSetAdpater() {
        layoutManager = new LinearLayoutManager(myActivity);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        yetsend_approval_recycler.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        //设置添加删除item时候的动画
        yetsend_approval_recycler.setItemAnimator(new DefaultItemAnimator());
        adapter = new YetSendApprovalAdapter(myActivity, yetSendApprovalElementList);
        // yetsend_notifi_recycler.addItemDecoration(new DividerItemDecoration(ct, layoutManager
        //         .getOrientation()));
        yetsend_approval_recycler.setAdapter(adapter);

    }


    private void setSwip() {
        yetsend_approval_swip.setSize(SwipeRefreshLayout.DEFAULT);
        yetsend_approval_swip.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        //  yetsend_approval_swip.setRefreshing(true);

        yetsend_approval_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                yetSendLoad(1 + "");
                loadeMore.setCurrentPage(1);

            }
        });
    }


    @Override
    protected void onClickEvent(View view) {

    }


}
