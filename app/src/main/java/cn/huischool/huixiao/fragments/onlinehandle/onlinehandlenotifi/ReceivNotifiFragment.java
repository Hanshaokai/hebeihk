package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlenotifi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.NotifiActivity;
import cn.huischool.huixiao.adapters.onlinehandle.ReceivNotifiAdapter;
import cn.huischool.huixiao.bean.AcceNotifiBean;
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
public class ReceivNotifiFragment extends BaseLazyLoadefragment {

    private RecyclerView receiv_notifi_recycler;
    private List<AcceNotifiBean.Elements> acceNotiElementsList = new ArrayList<AcceNotifiBean.Elements>();
    private ReceivNotifiAdapter adapter;
    private SwipeRefreshLayout receiv_notfi_swip;
    private NotifiActivity myActivity;
    private LinearLayoutManager layoutManager;
    private CoordinatorLayout coor_receive_notifi;
    private int currentPageOfLoad = 1;
    private LoadeMoreRecyclerOnScrollListener loadeMore;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = (NotifiActivity) baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_notifi, null, false);
        receiv_notifi_recycler = (RecyclerView) view.findViewById(R.id.yetsend_notifi_recycler);
        receiv_notfi_swip = (SwipeRefreshLayout) view.findViewById(R.id.yetsend_notfi_swip);
        coor_receive_notifi = (CoordinatorLayout) view.findViewById(R.id.coor_receive_notifi);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setSwip();
        recycletsendSetAdpater();
        if (acceNotiElementsList.size() == 0) {
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
                showProgressDialog("正在加载...");
                currentPageOfLoad = currentPage;
                receivLoad(currentPage + "");
            }
        };
        receiv_notifi_recycler.addOnScrollListener(loadeMore);

        receiv_notifi_recycler.addOnItemTouchListener(new OnRecyclerItemClickListener(receiv_notifi_recycler,
                receiv_notifi_recycler.getContext()) {//封装了为rescyler 封装了监听

            @Override
            public void onItemClick(final RecyclerView.ViewHolder vh) {
                Log.d("tag", "==OnRescylerItemclikListener点击了");
                if (acceNotiElementsList.get(vh.getAdapterPosition()).getHasRead().equals("0")) {
                    DataAchieve.toMarkReadOrNO(new DataAchieve.SuccessCallBack() {
                        @Override
                        public void handle(int code, Object object) {
                            if (code == 1000) {
                                acceNotiElementsList.get(vh.getAdapterPosition()).setHasRead("1");
                            }
                        }
                    }, acceNotiElementsList.get(vh.getAdapterPosition()).getId(), "1");
                }


                ((TextView) vh.itemView.findViewById(R.id.receive_notfi_title)).setTextColor
                        (Color.GRAY);

                addFragment(new OnLineAcceNotifiDetailFragment().newInstance(acceNotiElementsList.get(vh
                        .getAdapterPosition()).getNoticeId()));

            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });

    }

    private void setSwip() {
        receiv_notfi_swip.setSize(SwipeRefreshLayout.DEFAULT);
        receiv_notfi_swip.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        // receiv_notfi_swip.setRefreshing(true);
        receiv_notfi_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                receivLoad(1 + "");

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
    private void receivLoad(final String page) {

        DataAchieve.acceNotifi(new DataAchieve.SuccessCallBack() {
                                   @Override
                                   public void handle(int code, Object object) {
                                       {
                                           if (code != 1000) {
                                               return;
                                           } else {
                                               AcceNotifiBean.Results ments = ((AcceNotifiBean)

                                                       object).getResults();
                                               if (ments != null) {
                                                   if (page.equals("1")) {
                                                       loadeMore.setCurrentPage(1);
                                                       currentPageOfLoad = 1;
                                                       if (CollectionUtils.isListNull(ments
                                                               .getElements())) {
                                                           TooSnackbar.showMessage
                                                                   (coor_receive_notifi, "没有数据啦");
                                                       } else {

                                                           loadeMore.setCurrentPage(++currentPageOfLoad);

                                                       }
                                                       acceNotiElementsList.clear();
                                                       acceNotiElementsList.addAll(ments.getElements
                                                               ());
                                                       adapter.addList(acceNotiElementsList);
                                                   } else {
                                                       if (CollectionUtils.isListNull(ments
                                                               .getElements())) {
                                                           TooSnackbar.showMessage
                                                                   (coor_receive_notifi, "没有数据啦");
                                                       } else {

                                                           loadeMore.setCurrentPage
                                                                   (++currentPageOfLoad);

                                                       }
                                                       acceNotiElementsList.addAll(ments.getElements
                                                               ());
                                                       adapter.addList(acceNotiElementsList);
                                                   }


                                                   if (receiv_notfi_swip.isRefreshing()) {

                                                       receiv_notfi_swip.setRefreshing(false);
                                                   }
                                               }
                                               dismissProgressDialog();
                                               if (receiv_notfi_swip.isRefreshing()) {

                                                   receiv_notfi_swip.setRefreshing(false);
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
        receiv_notifi_recycler.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        receiv_notifi_recycler.setItemAnimator(new DefaultItemAnimator());
        adapter = new ReceivNotifiAdapter(ct, acceNotiElementsList);
        //  yetsend_notifi_recycler.addItemDecoration(new DividerItemDecoration(ct, layoutManager
        //         .getOrientation()));

        receiv_notifi_recycler.setAdapter(adapter);
    }

    @Override
    protected void onClickEvent(View view) {

    }
}
