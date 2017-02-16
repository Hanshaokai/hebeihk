package cn.huischool.huixiao.fragments.onlinehandle.onlineapproval;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.ApprovalActivity;
import cn.huischool.huixiao.adapters.onlinehandle.ReceivApprovalAdapter;
import cn.huischool.huixiao.bean.ReceivApprovalBean;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.OpinionCallBackUtil;
import cn.huischool.huixiao.common.utils.TooSnackbar;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.LoadeMoreRecyclerOnScrollListener;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.framework.BaseLazyLoadefragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/6/15.
 */
public class ReceivApprovalFragment extends BaseLazyLoadefragment implements OpinionCallBackUtil.OpinionCllaBack {
    private ApprovalActivity myActivity;
    private RecyclerView receiv_approval_recycler;
    private SwipeRefreshLayout receiv_approval_swip;
    private LinearLayoutManager layoutManager;
    private ReceivApprovalAdapter adapter;
    private List<ReceivApprovalBean.ResultsBean> acceApprovalElementsList = new ArrayList<ReceivApprovalBean.ResultsBean>();
    private String backOpinion;
    private int backPosition;
    private CoordinatorLayout coor_yetsend_approval;
    private int currentPageOfLoad = 1;
    private LoadeMoreRecyclerOnScrollListener loadeMore;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = (ApprovalActivity) baseFragmentActivity;
        OpinionCallBackUtil.getIntence().add(this);
        view = inflater.inflate(R.layout.fragment_yetsend_approval, null, false);//通知 公告的 已发送
        // 已接受 共用布局
        receiv_approval_recycler = (RecyclerView) view.findViewById(R.id.yetsend_approval_recycler);
        receiv_approval_swip = (SwipeRefreshLayout) view.findViewById(R.id.yetsend_approval_swip);
        coor_yetsend_approval = (CoordinatorLayout) view.findViewById(R.id.coor_yetsend_approval);
        return view;
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        setSwip();
        recycletsendSetAdpater();
        if (acceApprovalElementsList.size() == 0) {
            showProgressDialog("正在加载...");
            receivLoad(currentPageOfLoad + "");
        }

        setYetsendListener();
    }
    private void setYetsendListener() {
        loadeMore = new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {


            @Override
            public void onLoadMore(int currentPage) {
                currentPageOfLoad = currentPage;
                showProgressDialog("正在加载...");
                receivLoad(currentPage + "");
            }
        };
        receiv_approval_recycler.addOnScrollListener(loadeMore);

        receiv_approval_recycler.addOnItemTouchListener(new OnRecyclerItemClickListener(receiv_approval_recycler,
                receiv_approval_recycler.getContext()) {//封装了为rescyler 封装了监听

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                Log.d("tag", vh.getAdapterPosition() + "==OnRescylerItemclikListener点击了");

                addFragment(new OnLineReceApprovalDetailFragment().newInstance(acceApprovalElementsList.get(vh
                        .getAdapterPosition()).getApprovalId()));
            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });

    }


    private void setSwip() {
        receiv_approval_swip.setSize(SwipeRefreshLayout.DEFAULT);
        receiv_approval_swip.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);

        receiv_approval_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                receivLoad(1 + "");

            }
        });

    }


    private void receivLoad(final String page) {

        DataAchieve.getReceivApprovalList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                {
                    if (code != 1000) {
                        dismissProgressDialog();
                        if (receiv_approval_swip.isRefreshing()) {

                            receiv_approval_swip.setRefreshing(false);
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
                                    TooSnackbar.showMessage(coor_yetsend_approval, "没有数据啦");
                                } else {

                                    loadeMore.setCurrentPage(++currentPageOfLoad);

                                }


                                acceApprovalElementsList.clear();
                                acceApprovalElementsList.addAll(ments);
                                adapter.addList(acceApprovalElementsList);
                            } else {
                                if (CollectionUtils.isListNull(ments))

                                {
                                    TooSnackbar.showMessage(coor_yetsend_approval, "没有数据啦");
                                } else {

                                    loadeMore.setCurrentPage(++currentPageOfLoad);

                                }
                                acceApprovalElementsList.addAll(ments);
                                adapter.addList(acceApprovalElementsList);
                            }
                            if (receiv_approval_swip.isRefreshing()) {

                                receiv_approval_swip.setRefreshing(false);
                            }
                        }
                        dismissProgressDialog();
                        if (receiv_approval_swip.isRefreshing()) {

                            receiv_approval_swip.setRefreshing(false);
                        }
                    }
                }
            }
        }, page, "12", CustomApplication.userInfor.getUserId(), "", "0");
    }


    private void recycletsendSetAdpater() {
        layoutManager = new LinearLayoutManager(ct);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        receiv_approval_recycler.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        receiv_approval_recycler.setItemAnimator(new DefaultItemAnimator());
        adapter = new ReceivApprovalAdapter(ct, acceApprovalElementsList);
        //  receiv_affiche_recycler.addItemDecoration(new DividerItemDecoration(ct, layoutManager
        //         .getOrientation()));

        receiv_approval_recycler.setAdapter(adapter);

    }


    @Override
    protected void onClickEvent(View view) {

    }

    @Override
    public void opinionBack(String op, int position, String comment, String approvalTime) {
        backOpinion = op;
        backPosition = position;


        acceApprovalElementsList.get(position).setOpinion(op);
        acceApprovalElementsList.get(position).getApprovalInfo().get(Integer.parseInt(acceApprovalElementsList.get
                (position).getApproversIdsNum()) - 1).setOpinion(op);
        acceApprovalElementsList.get(position).getApprovalInfo().get(Integer.parseInt(acceApprovalElementsList.get
                (position).getApproversIdsNum()) - 1).setComment(comment);
        acceApprovalElementsList.get(position).getApprovalInfo().get(Integer.parseInt(acceApprovalElementsList.get
                (position).getApproversIdsNum()) - 1).setApprovalTime(approvalTime);
        adapter.addList(acceApprovalElementsList);
    }
}
