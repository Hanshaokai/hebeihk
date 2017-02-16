package cn.huischool.huixiao.fragments.onlinehandle.onlinestudynotes;

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
import cn.huischool.huixiao.adapters.onlinehandle.MyStudyNotesAdapter;
import cn.huischool.huixiao.bean.MyStudyNotesBean;
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
 * Created by ${han} on 2016/8/12.
 */
public class StudyNotesFragment extends BaseFragment {

    private Toolbar toolbar_clude;
    private TextView tv_title_clude;
    private ImageButton imagbtn_action_clude;
    private RecyclerView rlv_fragment_studynotes_itemcontainer;
    private SwipeRefreshLayout swip_fragment_studynotes;
    private AppCompatActivity myActivity;
    private LinearLayoutManager layoutManager;
    private CoordinatorLayout cool_my_studynotes_online;
    private List<MyStudyNotesBean.ResultsBean.ElementsBean> myStudyNotesElementsList = new
            ArrayList<>();
    private MyStudyNotesAdapter adapter;
    private int currentPageOfLoad = 1;
    private LoadeMoreRecyclerOnScrollListener loademore;

    @Override
    public View initView(LayoutInflater inflater) {

        myActivity = baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_handle_studynotes, null, false);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        imagbtn_action_clude = (ImageButton) view.findViewById(R.id.imagbtn_action_clude);
        rlv_fragment_studynotes_itemcontainer = (RecyclerView) view.findViewById(R.id
                .rlv_fragment_studynotes_itemcontainer);
        swip_fragment_studynotes = (SwipeRefreshLayout) view.findViewById(R.id
                .swip_fragment_studynotes);
        cool_my_studynotes_online = (CoordinatorLayout) view.findViewById(R.id
                .cool_my_studynotes_online);
        return view;


    }

    @Override
    public void initData(Bundle savedInstanceState) {
        settoobar();
        setAdapter();
        setSwip();
        if (myStudyNotesElementsList.size() == 0) {
            showProgressDialog("正在加载");
            MyStudyNotesLoad(currentPageOfLoad + "");
        }
        setOnStudyNotesListner();


    }

    private void settoobar() {
        setHasOptionsMenu(true);
        initToolBar(toolbar_clude, true, "我的学习笔记",R.drawable.fab_add,true);

        imagbtn_action_clude.setOnClickListener(this);

    }

    private void setOnStudyNotesListner() {
        loademore = new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {


            @Override
            public void onLoadMore(int currentPage) {
                currentPageOfLoad = currentPage;
                showProgressDialog("正在加载");
                MyStudyNotesLoad(currentPage + "");
            }
        };
        rlv_fragment_studynotes_itemcontainer.addOnScrollListener(loademore);

        rlv_fragment_studynotes_itemcontainer.addOnItemTouchListener(new OnRecyclerItemClickListener(rlv_fragment_studynotes_itemcontainer,
                rlv_fragment_studynotes_itemcontainer.getContext()) {//封装了为rescyler 封装了监听

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {

                if (myStudyNotesElementsList.get(vh
                        .getAdapterPosition()).getSubmitStatus().equals("1")) {
                    addFragment(StudyNotesDetailFragment.newInstance(myStudyNotesElementsList.get(vh
                            .getAdapterPosition()).getId()));
                    LogUtil.d("讲课记录id" + myStudyNotesElementsList.get(vh
                            .getAdapterPosition()).getId());
                } else if (myStudyNotesElementsList.get(vh
                        .getAdapterPosition()).getSubmitStatus().equals("0")){
                    addFragment(ToCommitStudyNotesOfEditedFragment.newInstance(myStudyNotesElementsList.get(vh
                            .getAdapterPosition()).getId()));
                }
            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });

    }

    private void setSwip() {
        swip_fragment_studynotes.setSize(SwipeRefreshLayout.DEFAULT);
        swip_fragment_studynotes.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        swip_fragment_studynotes.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                MyStudyNotesLoad(1 + "");

            }
        });
    }

    private void MyStudyNotesLoad(final String page) {

        DataAchieve.toGetMyStudyNotesList(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {
                {
                    if (code != 1000) {
                        dismissProgressDialog();
                        return;

                    } else {
                        MyStudyNotesBean.ResultsBean ments = ((MyStudyNotesBean
                                )
                                object).getResults();
                        if (ments != null) {
                            if (page.equals("1")) {
                                loademore.setCurrentPage(1);
                                currentPageOfLoad = 1;
                                if (CollectionUtils.isListNull(ments.getElements())) {

                                    TooSnackbar.showMessage(cool_my_studynotes_online,
                                            "您还未创建学习笔记");
                                } else {

                                    loademore.setCurrentPage(++currentPageOfLoad);

                                }
                                myStudyNotesElementsList.clear();
                                myStudyNotesElementsList.addAll(ments.getElements
                                        ());
                                adapter.addList(myStudyNotesElementsList);
                            } else {
                                if (CollectionUtils.isListNull(ments.getElements())) {

                                    TooSnackbar.showMessage(cool_my_studynotes_online,
                                            "没有更多学习笔记啦");
                                } else {

                                    loademore.setCurrentPage(++currentPageOfLoad);

                                }
                                myStudyNotesElementsList.addAll(ments.getElements
                                        ());
                                adapter.addList(myStudyNotesElementsList);
                            }
                            if (swip_fragment_studynotes.isRefreshing()) {

                                swip_fragment_studynotes.setRefreshing(false);
                            }
                        }
                        dismissProgressDialog();
                        if (swip_fragment_studynotes.isRefreshing()) {

                            swip_fragment_studynotes.setRefreshing(false);
                        }
                    }
                }
            }
        }, page, "12", CustomApplication.userInfor.getUserId(), "");
    }

    private void setAdapter() {
        layoutManager = new LinearLayoutManager(myActivity);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlv_fragment_studynotes_itemcontainer.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        rlv_fragment_studynotes_itemcontainer.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyStudyNotesAdapter(myActivity,
                myStudyNotesElementsList);
        rlv_fragment_studynotes_itemcontainer.addItemDecoration(new DividerItemDecoration(myActivity,
                layoutManager
                        .getOrientation()));

        rlv_fragment_studynotes_itemcontainer.setAdapter(adapter);
    }


    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {

            case R.id.imagbtn_action_clude:

                addFragment(new ToCommitStudyNotesFragment());

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
