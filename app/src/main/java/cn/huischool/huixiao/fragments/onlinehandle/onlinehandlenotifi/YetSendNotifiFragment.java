package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlenotifi;

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
import cn.huischool.huixiao.activitys.onlinehandle.NotifiActivity;
import cn.huischool.huixiao.adapters.onlinehandle.YetSendNotifiAdapter;
import cn.huischool.huixiao.bean.YetSendNotifiBean;

import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.TooSnackbar;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.LoadeMoreRecyclerOnScrollListener;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.framework.BaseLazyLoadefragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/5/18.
 */
public class YetSendNotifiFragment extends BaseLazyLoadefragment {

    private RecyclerView yetsend_notifi_recycler;
    private List<YetSendNotifiBean.ResultsBean.ElementsBean> yetSendNotiElementList = new
            ArrayList<YetSendNotifiBean.ResultsBean.ElementsBean>();
    private YetSendNotifiAdapter adapter;
    private SwipeRefreshLayout yetsend_notfi_swip;
    private NotifiActivity myActivity;
    private LinearLayoutManager layoutManager;
    private CoordinatorLayout coor_receive_notifi;
    private int currentPageOfload = 1;
    private LoadeMoreRecyclerOnScrollListener loadeMore;

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_notifi, null, false);
        yetsend_notifi_recycler = (RecyclerView) view.findViewById(R.id.yetsend_notifi_recycler);
        yetsend_notfi_swip = (SwipeRefreshLayout) view.findViewById(R.id.yetsend_notfi_swip);
        coor_receive_notifi = (CoordinatorLayout) view.findViewById(R.id.coor_receive_notifi);


        myActivity = (NotifiActivity) baseFragmentActivity;
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setSwip();
        recycletsendSetAdpater();
        if (yetSendNotiElementList.size() == 0) {
            showProgressDialog("正在加载...");
            yetSendLoad(currentPageOfload + "");
        }
        setYetsendListener();
    }

    private void setYetsendListener() {
        loadeMore =
                new LoadeMoreRecyclerOnScrollListener
                        (layoutManager) {

                    @Override
                    public void onLoadMore(int currentPage) {
                        currentPageOfload = currentPage;
                        showProgressDialog("正在加载...");
                        yetSendLoad("" + currentPage);
                    }
                };
        yetsend_notifi_recycler.addOnScrollListener(loadeMore);
        yetsend_notifi_recycler.addOnItemTouchListener(new OnRecyclerItemClickListener(yetsend_notifi_recycler,
                yetsend_notifi_recycler.getContext()) {//封装了为rescyler 封装了监听

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
              /*  *//**
                 * 弹窗式显示详情
                 *//*
                    NotifiDialogFragment notifiDialogFragment = new NotifiDialogFragment(
                            notifiElementsList.get(vh.getAdapterPosition()-1), ct);
                    FragmentTransaction transaction = getFragmentManager()
                            .beginTransaction();
                    transaction
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                    notifiDialogFragment.show(transaction, "notifiDialogFragment");
                */

                /*OnLineYetSendNotifiDetailFragment onLineYetSendNotifiDetailFragment = new
                        OnLineYetSendNotifiDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("yetSendInfor", yetSendNotiElementList.get(vh.getAdapterPosition()));
                onLineYetSendNotifiDetailFragment.setArguments(bundle);*/
                addFragment(new OnLineYetSendNotifiDetailFragment().newInstance
                        (yetSendNotiElementList.get(vh.getAdapterPosition()).getId()));

            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });

    }

    private void setSwip() {
        yetsend_notfi_swip.setSize(SwipeRefreshLayout.DEFAULT);
        yetsend_notfi_swip.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        // yetsend_notfi_swip.setRefreshing(true);

        yetsend_notfi_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                yetSendLoad(1 + "");

            }
        });

    }

    /*
    * swip_home.setSize(SwipeRefreshLayout.DEFAULT);
            swip_home.setColorSchemeColors(R.color.bg_blue_01,R.color.bg_orange,
                    R.color.bg_blue_01,R.color.bg_orange);
            swip_home.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    loadMsgData();
                    loadBoardData();
                }
            });*/
    private void yetSendLoad(final String page) {

        DataAchieve.yetSendNotfi(new DataAchieve.SuccessCallBack() {
                                     @Override
                                     public void handle(int code, Object object) {
                                         {
                                             if (code != 1000) {
                                                 return;
                                             } else {
                                                 YetSendNotifiBean.ResultsBean ments =
                                                         ((YetSendNotifiBean) object).getResults();
                                                 if (ments != null) {
                                                     if (page.equals("1")) {
                                                         loadeMore.setCurrentPage(1);
                                                         currentPageOfload = 1;
                                                         if (CollectionUtils.isListNull(ments
                                                                 .getElements())) {
                                                             TooSnackbar.showMessage
                                                                     (coor_receive_notifi, "没有数据啦");
                                                         } else {

                                                             loadeMore.setCurrentPage(++currentPageOfload);

                                                         }
                                                         yetSendNotiElementList.clear();
                                                         yetSendNotiElementList.addAll(ments.getElements());
                                                         adapter.addList(yetSendNotiElementList);
                                                     } else {
                                                         if (CollectionUtils.isListNull(ments
                                                                 .getElements())) {
                                                             TooSnackbar.showMessage
                                                                     (coor_receive_notifi, "没有数据啦");
                                                         } else {

                                                             loadeMore.setCurrentPage(++currentPageOfload);

                                                         }
                                                         yetSendNotiElementList.addAll(ments.getElements());
                                                         adapter.addList(yetSendNotiElementList);
                                                     }
                                                     if (yetsend_notfi_swip.isRefreshing()) {

                                                         yetsend_notfi_swip.setRefreshing(false);
                                                     }
                                                 }
                                                 dismissProgressDialog();
                                                 if (yetsend_notfi_swip.isRefreshing()) {

                                                     yetsend_notfi_swip.setRefreshing(false);
                                                 }
                                             }
                                         }
                                     }
                                 }, null, null, page,
                "8",
                CustomApplication.userInfor.getSchoolId(),
                CustomApplication.userInfor.getUserId(), "");
    }

    private void recycletsendSetAdpater() {
        layoutManager = new LinearLayoutManager(ct);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        yetsend_notifi_recycler.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        //设置添加删除item时候的动画
        yetsend_notifi_recycler.setItemAnimator(new DefaultItemAnimator());
        adapter = new YetSendNotifiAdapter(ct, yetSendNotiElementList);
        //  yetsend_notifi_recycler.addItemDecoration(new DividerItemDecoration(ct, layoutManager
        //         .getOrientation()));
        yetsend_notifi_recycler.setAdapter(adapter);
    }

    @Override
    protected void onClickEvent(View view) {

    }
}
