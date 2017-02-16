package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlaffiche;

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
import cn.huischool.huixiao.activitys.onlinehandle.AfficheActivity;
import cn.huischool.huixiao.adapters.onlinehandle.ReceivAfficheAdapter;
import cn.huischool.huixiao.bean.AfficheschBean;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.TooSnackbar;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.LoadeMoreRecyclerOnScrollListener;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.framework.BaseLazyLoadefragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/6/6.
 */
public class ReceivAfficheFragment extends BaseLazyLoadefragment {

    private AfficheActivity myActivity;
    private RecyclerView receiv_affiche_recycler;
    private SwipeRefreshLayout receiv_affiche_swip;
    private LinearLayoutManager layoutManager;
    private ReceivAfficheAdapter adapter;
    private List<AfficheschBean.Elements> acceAffiElementsList = new ArrayList<AfficheschBean.Elements>();
    private CoordinatorLayout coor_yetsend_affiche;
    private int currentPageOfload = 1;
    private LoadeMoreRecyclerOnScrollListener loadeMore;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = (AfficheActivity) baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_affiche, null, false);//通知 公告的 已发送
        // 已接受 共用布局
        receiv_affiche_recycler = (RecyclerView) view.findViewById(R.id.yetsend_affiche_recycler);
        receiv_affiche_swip = (SwipeRefreshLayout) view.findViewById(R.id.yetsend_affiche_swip);
        coor_yetsend_affiche = (CoordinatorLayout) view.findViewById(R.id.coor_yetsend_affiche);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setSwip();
        recycletsendSetAdpater();
        if (acceAffiElementsList.size() == 0) {
            showProgressDialog("正在加载...");
            receivLoad(currentPageOfload + "");
        }
        setYetsendListener();
    }

    private void setYetsendListener() {
        loadeMore = new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                showProgressDialog("正在加载...");
                currentPageOfload = currentPage;
                receivLoad(currentPage + "");
            }
        };
        receiv_affiche_recycler.addOnScrollListener(loadeMore);
        receiv_affiche_recycler.addOnItemTouchListener(new OnRecyclerItemClickListener(receiv_affiche_recycler,
                receiv_affiche_recycler.getContext()) {//封装了为rescyler 封装了监听
            @Override
            public void onItemClick(final RecyclerView.ViewHolder vh) {
                Log.d("tag", "==OnRescylerItemclikListener点击了");
                if (acceAffiElementsList.get(vh.getAdapterPosition()).getHasRead().equals("0")) {
                    DataAchieve.toMarkReadOrNO(new DataAchieve.SuccessCallBack() {
                        @Override
                        public void handle(int code, Object object) {
                            if (code == 1000) {

                                acceAffiElementsList.get(vh.getAdapterPosition()).setHasRead("1");
                            }
                        }
                    }, acceAffiElementsList.get(vh.getAdapterPosition()).getId(), "0");
                }
                ((TextView) vh.itemView.findViewById(R.id.yetsend_affiche_title)).setTextColor
                        (Color.GRAY);

                addFragment(new OnLineAcceAfficheDetailFragment().newInstance(acceAffiElementsList
                        .get(vh.getAdapterPosition()).getAfficheId()));

            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });

    }

    private void setSwip() {
        receiv_affiche_swip.setSize(SwipeRefreshLayout.DEFAULT);
        receiv_affiche_swip.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);

        receiv_affiche_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                receivLoad(1 + "");

            }
        });

    }

    private void receivLoad(final String page) {

        DataAchieve.affiche(new DataAchieve.SuccessCallBack() {
                                @Override
                                public void handle(int code, Object object) {
                                    {
                                        if (code != 1000) {
                                            dismissProgressDialog();
                                            if (receiv_affiche_swip.isRefreshing()) {
                                                receiv_affiche_swip.setRefreshing(false);
                                            }
                                            return;
                                        } else {
                                            AfficheschBean.Results ments = ((AfficheschBean)
                                                    object).getResults();

                                            if (ments != null) {
                                                if (page.equals("1")) {
                                                    loadeMore.setCurrentPage(1);
                                                    currentPageOfload = 1;
                                                    if (CollectionUtils.isListNull(ments
                                                            .getElements())) {
                                                        TooSnackbar.showMessage
                                                                (coor_yetsend_affiche, "没有数据啦");
                                                    } else {

                                                        loadeMore.setCurrentPage(++currentPageOfload);

                                                    }
                                                    acceAffiElementsList.clear();
                                                    acceAffiElementsList.addAll(ments.getElements
                                                            ());
                                                    adapter.addList(acceAffiElementsList);
                                                } else {
                                                    if (CollectionUtils.isListNull(ments
                                                            .getElements())) {
                                                        TooSnackbar.showMessage
                                                                (coor_yetsend_affiche, "没有数据啦");
                                                    } else {

                                                        loadeMore.setCurrentPage(++currentPageOfload);

                                                    }
                                                    acceAffiElementsList.addAll(ments.getElements
                                                            ());
                                                    adapter.addList(acceAffiElementsList);
                                                }
                                                if (receiv_affiche_swip.isRefreshing()) {

                                                    receiv_affiche_swip.setRefreshing(false);
                                                }
                                            }
                                            dismissProgressDialog();
                                            if (receiv_affiche_swip.isRefreshing()) {

                                                receiv_affiche_swip.setRefreshing(false);
                                            }
                                        }
                                    }
                                }
                            }, null, null, page,
                "8",
                CustomApplication.userInfor.getSchoolId(),
                CustomApplication.userInfor.getUserId());
    }

    private void recycletsendSetAdpater() {
        layoutManager = new LinearLayoutManager(myActivity);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        receiv_affiche_recycler.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        receiv_affiche_recycler.setItemAnimator(new DefaultItemAnimator());
        adapter = new ReceivAfficheAdapter(myActivity, acceAffiElementsList);
        //  receiv_affiche_recycler.addItemDecoration(new DividerItemDecoration(ct, layoutManager
        //         .getOrientation()));

        receiv_affiche_recycler.setAdapter(adapter);
    }

    @Override
    protected void onClickEvent(View view) {

    }
}
