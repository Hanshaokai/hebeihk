package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlaffiche;

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
import cn.huischool.huixiao.activitys.onlinehandle.AfficheActivity;
import cn.huischool.huixiao.adapters.onlinehandle.YetSendAfficheAdapter;
import cn.huischool.huixiao.bean.YetSendAfficheBean;
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
public class YetSendAfficheFragment extends BaseLazyLoadefragment {

    private AfficheActivity myActivity;
    private SwipeRefreshLayout yetsend_affiche_swip;
    private RecyclerView yetsend_affiche_recycler;
    private View view;
    private LinearLayoutManager layoutManager;
    private YetSendAfficheAdapter adapter;
    private List<YetSendAfficheBean.ResultsBean.ElementsBean> yetSendAfficheElementList = new
            ArrayList<YetSendAfficheBean.ResultsBean.ElementsBean>();
    private CoordinatorLayout coor_yetsend_affiche;
    private int currentPageOfLoad = 1;
    private LoadeMoreRecyclerOnScrollListener loadeMore;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_affiche, null, false);
        yetsend_affiche_recycler = (RecyclerView) view.findViewById(R.id.yetsend_affiche_recycler);
        yetsend_affiche_swip = (SwipeRefreshLayout) view.findViewById(R.id.yetsend_affiche_swip);
        coor_yetsend_affiche = (CoordinatorLayout) view.findViewById(R.id.coor_yetsend_affiche);
        myActivity = (AfficheActivity) baseFragmentActivity;
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setSwip();
        recycletsendSetAdpater();
        if (yetSendAfficheElementList.size() == 0) {
            showProgressDialog("正在加载...");
            yetSendLoad(currentPageOfLoad + "");
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
                yetSendLoad("" + currentPage);
            }
        };
        yetsend_affiche_recycler.addOnScrollListener(loadeMore);
        yetsend_affiche_recycler.addOnItemTouchListener(new OnRecyclerItemClickListener(yetsend_affiche_recycler,
                yetsend_affiche_recycler.getContext()) {//封装了为rescyler 封装了监听

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
                OnLineYetSendAfficheDetailFragment onLineYetSendAfficheDetailFragment = new
                        OnLineYetSendAfficheDetailFragment();



                addFragment(new OnLineYetSendAfficheDetailFragment().newInstance
                        (yetSendAfficheElementList.get(vh.getAdapterPosition()).getId()));

            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });

    }

    private void setSwip() {
        yetsend_affiche_swip.setSize(SwipeRefreshLayout.DEFAULT);
        yetsend_affiche_swip.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        //yetsend_affiche_swip.setRefreshing(true);

        yetsend_affiche_swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                yetSendLoad(1 + "");

            }
        });

    }

    private void yetSendLoad(final String page) {

        DataAchieve.YetSendaffiche(new DataAchieve.SuccessCallBack() {
                                       @Override
                                       public void handle(int code, Object object) {
                                           {
                                               if (code != 1000) {
                                                   dismissProgressDialog();
                                                   if (yetsend_affiche_swip.isRefreshing()) {

                                                       yetsend_affiche_swip.setRefreshing(false);
                                                   }
                                                   return;
                                               } else {

                                                   YetSendAfficheBean.ResultsBean ments =
                                                           ((YetSendAfficheBean) object).getResults();
                                                   if (ments != null) {
                                                       if (page.equals("1")) {
                                                           loadeMore.setCurrentPage(1);
                                                           currentPageOfLoad = 1;
                                                           if (CollectionUtils.isListNull(ments
                                                                   .getElements())) {
                                                               TooSnackbar.showMessage
                                                                       (coor_yetsend_affiche, "没有数据啦");
                                                           } else {

                                                               loadeMore.setCurrentPage(++currentPageOfLoad);

                                                           }
                                                           yetSendAfficheElementList.clear();
                                                           yetSendAfficheElementList.addAll(ments.getElements());
                                                           adapter.addList(yetSendAfficheElementList);
                                                       } else {
                                                           if (CollectionUtils.isListNull(ments
                                                                   .getElements())) {
                                                               TooSnackbar.showMessage(coor_yetsend_affiche, "没有数据啦");
                                                           } else {

                                                               loadeMore.setCurrentPage(++currentPageOfLoad);

                                                           }
                                                           yetSendAfficheElementList.addAll(ments.getElements());
                                                           adapter.addList(yetSendAfficheElementList);
                                                       }
                                                       if (yetsend_affiche_swip.isRefreshing()) {

                                                           yetsend_affiche_swip.setRefreshing(false);
                                                       }
                                                   }
                                                   dismissProgressDialog();
                                                   if (yetsend_affiche_swip.isRefreshing()) {

                                                       yetsend_affiche_swip.setRefreshing(false);
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
        yetsend_affiche_recycler.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        //设置添加删除item时候的动画
        yetsend_affiche_recycler.setItemAnimator(new DefaultItemAnimator());
        adapter = new YetSendAfficheAdapter(ct, yetSendAfficheElementList);
        //  yetsend_notifi_recycler.addItemDecoration(new DividerItemDecoration(ct, layoutManager
        //         .getOrientation()));
        yetsend_affiche_recycler.setAdapter(adapter);
    }

    @Override
    protected void onClickEvent(View view) {

    }
}
