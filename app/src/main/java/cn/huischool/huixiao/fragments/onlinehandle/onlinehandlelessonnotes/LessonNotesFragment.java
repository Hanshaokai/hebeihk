package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlelessonnotes;

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
import cn.huischool.huixiao.adapters.onlinehandle.MyLeesonNotesAdapter;
import cn.huischool.huixiao.bean.MyLessonNotesBean;
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
 * Created by ${han} on 2016/8/2.
 */


public class LessonNotesFragment extends BaseFragment {

    private Toolbar toolbar_clude;
    private TextView tv_title_clude;
    private ImageButton imagbtn_action_clude;
    private RecyclerView rlv_fragment_lessonnotes_itemcontainer;
    private SwipeRefreshLayout swip_fragment_lessonnotes;
    private AppCompatActivity myActivity;
    private LinearLayoutManager layoutManager;
    private CoordinatorLayout cool_my_lessonnotes_online;
    private List<MyLessonNotesBean.ResultsBean.ElementsBean> myLessonNotesElementsList = new
            ArrayList<>();
    private MyLeesonNotesAdapter adapter;
    private int currentPageOfLoad = 1;
    private LoadeMoreRecyclerOnScrollListener loademore;

    @Override

    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_handle_lessonnotes, null, false);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        imagbtn_action_clude = (ImageButton) view.findViewById(R.id.imagbtn_action_clude);
        rlv_fragment_lessonnotes_itemcontainer = (RecyclerView) view.findViewById(R.id
                .rlv_fragment_lessonnotes_itemcontainer);
        swip_fragment_lessonnotes = (SwipeRefreshLayout) view.findViewById(R.id
                .swip_fragment_lessonnotes);
        cool_my_lessonnotes_online = (CoordinatorLayout) view.findViewById(R.id
                .cool_my_lessonnotes_online);
        return view;
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        settoobar();
        setAdapter();
        setSwip();
        if (myLessonNotesElementsList.size() == 0) {
            showProgressDialog("正在加载");
            MyLessonNotesLoad(currentPageOfLoad + "");
        }
        setOnLessonNotesListner();

    }

    private void settoobar() {
        setHasOptionsMenu(true);
        initToolBar(toolbar_clude, true, "我的听课记录表",R.drawable.fab_add,true);

        imagbtn_action_clude.setOnClickListener(this);

    }

    private void setOnLessonNotesListner() {
        loademore = new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {


            @Override
            public void onLoadMore(int currentPage) {
                showProgressDialog("正在加载");
                currentPageOfLoad = currentPage;
                MyLessonNotesLoad(currentPage + "");
            }
        };
        rlv_fragment_lessonnotes_itemcontainer.addOnScrollListener(loademore);

        rlv_fragment_lessonnotes_itemcontainer.addOnItemTouchListener(new OnRecyclerItemClickListener(rlv_fragment_lessonnotes_itemcontainer,
                rlv_fragment_lessonnotes_itemcontainer.getContext()) {//封装了为rescyler 封装了监听

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                if (myLessonNotesElementsList.get(vh
                        .getAdapterPosition()).getSubmitStatus().equals("1")) {
                    addFragment(LessonNotesDetailFragment.newInstance(myLessonNotesElementsList.get(vh
                            .getAdapterPosition()).getId()));
                    LogUtil.d("讲课记录id" + myLessonNotesElementsList.get(vh
                            .getAdapterPosition()).getId());
                } else if (myLessonNotesElementsList.get(vh
                        .getAdapterPosition()).getSubmitStatus().equals("0")) {
                    addFragment(ToCommitLessonNotesOfEditedFragment.newInstance(myLessonNotesElementsList.get(vh
                            .getAdapterPosition()).getId()));
                }
            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });

    }

    private void setSwip() {
        swip_fragment_lessonnotes.setSize(SwipeRefreshLayout.DEFAULT);
        swip_fragment_lessonnotes.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        swip_fragment_lessonnotes.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                MyLessonNotesLoad(1 + "");

            }
        });
    }

    private void MyLessonNotesLoad(final String page) {

        DataAchieve.toGetMyLesssonNotesList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                {
                    if (code != 1000) {
                        dismissProgressDialog();
                        return;

                    } else {
                        MyLessonNotesBean.ResultsBean ments = ((MyLessonNotesBean
                                )
                                object).getResults();
                        if (ments != null) {
                            if (page.equals("1")) {
                                loademore.setCurrentPage(1);
                                currentPageOfLoad = 1;
                                if (CollectionUtils.isListNull(ments.getElements())) {

                                    TooSnackbar.showMessage(cool_my_lessonnotes_online,
                                            "您还未创建听课记录");
                                } else {

                                    loademore.setCurrentPage(++currentPageOfLoad);

                                }
                                myLessonNotesElementsList.clear();
                                myLessonNotesElementsList.addAll(ments.getElements
                                        ());
                                adapter.addList(myLessonNotesElementsList);
                            } else {
                                if (CollectionUtils.isListNull(ments.getElements())) {

                                    TooSnackbar.showMessage(cool_my_lessonnotes_online,
                                            "没有更多听课记录啦");
                                } else {

                                    loademore.setCurrentPage(++currentPageOfLoad);

                                }
                                myLessonNotesElementsList.addAll(ments.getElements
                                        ());
                                adapter.addList(myLessonNotesElementsList);
                            }
                            if (swip_fragment_lessonnotes.isRefreshing()) {

                                swip_fragment_lessonnotes.setRefreshing(false);
                            }
                        }
                        dismissProgressDialog();
                        if (swip_fragment_lessonnotes.isRefreshing()) {

                            swip_fragment_lessonnotes.setRefreshing(false);
                        }
                    }
                }
            }
        }, page, "12", CustomApplication.userInfor.getUserId(), "");
    }

    private void setAdapter() {
        layoutManager = new LinearLayoutManager(myActivity);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlv_fragment_lessonnotes_itemcontainer.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        rlv_fragment_lessonnotes_itemcontainer.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyLeesonNotesAdapter(myActivity,
                myLessonNotesElementsList);
        rlv_fragment_lessonnotes_itemcontainer.addItemDecoration(new DividerItemDecoration(myActivity,
                layoutManager
                        .getOrientation()));

        rlv_fragment_lessonnotes_itemcontainer.setAdapter(adapter);
    }


    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {

            case R.id.imagbtn_action_clude:

                addFragment(new ToCommitLessonNotesFragment());

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
