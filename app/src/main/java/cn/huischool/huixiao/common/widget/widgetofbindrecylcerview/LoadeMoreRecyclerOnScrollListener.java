package cn.huischool.huixiao.common.widget.widgetofbindrecylcerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/6/5.
 */
public abstract class LoadeMoreRecyclerOnScrollListener extends RecyclerView.OnScrollListener {

    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = false;
    //list到达 最后一个item的时候 触发加载

    // The minimum amount of items to have below your current scroll position before loading more.
    int firstVisibleItem, visibleItemCount, totalItemCount;
    //默认第一页
    private int currentPage = 1;

    private LinearLayoutManager mLinearLayoutManager;
    private int lastVisibleItem;

    public LoadeMoreRecyclerOnScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    public void setCurrentPage(int t) {

        currentPage = t;

    }


    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 ==
                totalItemCount && totalItemCount != visibleItemCount) {
            //此处添加加载更多的代码，一般为取数据库或者加载网络等

            onLoadMore(currentPage);


        } else if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 ==
                totalItemCount && totalItemCount == visibleItemCount) {

            Toast.makeText(CustomApplication.customApplication, "没有更多数据", Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        //每次滑动的时候要更新最后一条可见的item的id
        //RecyclerView中的总的条目的数量(此处代表的是可见的和不可见的总数)

        lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
        totalItemCount = mLinearLayoutManager.getItemCount();
        visibleItemCount = mLinearLayoutManager.findLastVisibleItemPosition() - mLinearLayoutManager
                .findFirstVisibleItemPosition() + 1;

    }


    public abstract void onLoadMore(int currentPage);
}
