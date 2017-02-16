package cn.huischool.huixiao.fragments.onlinehandle.onlineresearchtable;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.rey.material.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.adapters.onlinehandle.CommitNUmberListAdapter;
import cn.huischool.huixiao.bean.CommitNumberListBean;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.DimenUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.TooSnackbar;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.DividerItemDecoration;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.LoadeMoreRecyclerOnScrollListener;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.common.widget.widgetofbindtagview.TagAdapter;
import cn.huischool.huixiao.common.widget.widgetofbindtagview.TagFlowLayout;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlemineteacherplan.OnlineHandleMineGrammarFragment;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlemycourseware.OnlineHandleMineCourseWareFragment;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/12/21.
 */
public class OnLineResearchTableFragment extends BaseFragment {
    @BindView(R.id.tv_title_clude)
    TextView tvTitleClude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtnActionClude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbarClude;
    @BindView(R.id.tagfl_fragment_research_table_subject)
    TagFlowLayout tagflFragmentResearchTableSubject;
    @BindView(R.id.tagfl_fragment_research_table_class)
    TagFlowLayout tagflFragmentResearchTableClass;
    @BindView(R.id.appbar_clude)
    AppBarLayout appbarClude;
    @BindView(R.id.rlv_fragment_research_table_itemcontainer)
    RecyclerView rlvFragmentResearchTableItemcontainer;
    @BindView(R.id.swip_fragment_research_table)
    SwipeRefreshLayout swipFragmentResearchTable;
    @BindView(R.id.cool_research_table_fragment)
    CoordinatorLayout coolResearchTableFragment;
    private Unbinder unbinder;
    private String subject = "全部";
    private String grade = "全部";
    private String[] subjectitems;
    private String[] classitems;
    private AppCompatActivity myActivity;
    private List commitNumberList = new ArrayList();
    private int totalPages;
    private LoadeMoreRecyclerOnScrollListener loadeMore;
    private LinearLayoutManager layoutManager;
    private CommitNUmberListAdapter adapter;
    private int currentPageOfLoad = 1;
    private PopupWindow popupWindow;
    private String checkedId;
    private String whose;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_online_research_table, null);
        unbinder = ButterKnife.bind(OnLineResearchTableFragment.this, view);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        initToolBar(toolbarClude, true, "教师教研", -1, true);
        subjectitems = myActivity.getResources().getStringArray(R.array.subjectitem);
        classitems = myActivity.getResources().getStringArray(R.array.classitem);
        setAdapter();
        setSwip();
        setListner();
        if (commitNumberList.size() == 0) {
            showProgressDialog("正在加载...");
            loadeCommitNumberList(currentPageOfLoad + "", subject, grade);
        }
    }

    private void setAdapter() {
        tagflFragmentResearchTableSubject.setAdapter(new TagAdapter(subjectitems) {
                                                         @Override
                                                         public View getView(ViewGroup parent, int position, Object o) {
                                                             int point = 0;
                                                             TextView tv = (TextView)
                                                                     myActivity.getLayoutInflater().inflate
                                                                             (R.layout.tag_item_tv,
                                                                                     parent, false);
                                                             tv.setText((String) o);
                                                             int lenth = subjectitems.length;
                                                             for (int i = 0; i < lenth;
                                                                  i++) {

                                                                 if (subject.equals
                                                                         (subjectitems[i])) {

                                                                     point = i;

                                                                 }

                                                             }
                                                             if (point == position)
                                                                 tv.setTextColor(Color.BLACK);
                                                             return tv;
                                                         }

                                                     }
        );
        tagflFragmentResearchTableSubject.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(ViewGroup parent, View view, int position) {

                int count = parent.getChildCount();
                for (int i = 0; i < count; i++) {
                    TextView t = (TextView) (parent.getChildAt(i).findViewById(R.id
                            .tv_tag_flexitem));
                    t.setTextColor(myActivity.getResources().getColor(R.color.gainsboro));
                }

                TextView t = (TextView) (parent.getChildAt(position).findViewById(R.id
                        .tv_tag_flexitem));
                t.setTextColor(Color.BLACK);
                subject = (String) t
                        .getText();
                showProgressDialog("正在加载...");
                loadeCommitNumberList("1", subject, grade);
                loadeMore.setCurrentPage(1);
            }
        });
        tagflFragmentResearchTableClass.setAdapter(new TagAdapter(classitems) {
            @Override
            public View getView(ViewGroup parent, int position, Object o) {
                int point = 0;
                TextView tv = (TextView) myActivity.getLayoutInflater().inflate
                        (R.layout.tag_item_tv,
                                parent, false);
                tv.setText((String) o);
                int lenth = classitems.length;
                for (int i = 0; i < lenth;
                     i++) {
                    if (grade.equals
                            (classitems[i])) {
                        point = i;
                    }
                }
                if (point == position)
                    tv.setTextColor(Color.BLACK);
                return tv;
            }
        });
      /*  tagfl_fragment_checkgrammar_class.setJustifyContent(FlexboxLayout
                .JUSTIFY_CONTENT_FLEX_START);*/

        tagflFragmentResearchTableClass.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(ViewGroup parent, View view, int position) {
                int count = parent.getChildCount();
                for (int i = 0; i < count; i++) {
                    TextView t = (TextView) (parent.getChildAt(i).findViewById(R.id
                            .tv_tag_flexitem));
                    t.setTextColor(myActivity.getResources().getColor(R.color.gainsboro));
                }
                TextView t = (TextView) (parent.getChildAt(position).findViewById(R.id
                        .tv_tag_flexitem));
                t.setTextColor(Color.BLACK);
                grade = (String) t
                        .getText();
                showProgressDialog("正在加载...");
                loadeCommitNumberList("1", subject, grade);
                loadeMore.setCurrentPage(1);
            }
        });
        layoutManager = new LinearLayoutManager(myActivity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlvFragmentResearchTableItemcontainer.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        rlvFragmentResearchTableItemcontainer.setItemAnimator(new DefaultItemAnimator());
        adapter = new CommitNUmberListAdapter(myActivity,
                commitNumberList);
        rlvFragmentResearchTableItemcontainer.addItemDecoration(new DividerItemDecoration(myActivity,
                layoutManager.getOrientation()));
        rlvFragmentResearchTableItemcontainer.setAdapter(adapter);

    }

    private void setSwip() {
        swipFragmentResearchTable.setSize(SwipeRefreshLayout.DEFAULT);
        swipFragmentResearchTable.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        swipFragmentResearchTable.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadeCommitNumberList(1 + "", subject, grade);
            }
        });


    }

    private void loadeCommitNumberList(final String page, String subject, String grade) {
        DataAchieve.getCommitNumberList(new DataAchieve.SuccessCallBack() {
                                            @Override
                                            public void handle(int code, Object object) {

                                                if (code != 1000) {
                                                    dismissProgressDialog();
                                                    if (swipFragmentResearchTable.isRefreshing()) {
                                                        swipFragmentResearchTable.setRefreshing(false);
                                                    }
                                                    return;
                                                } else {
                                                    List<CommitNumberListBean.ResultsBean.RowsBean>
                                                            elementsList =
                                                            ((CommitNumberListBean
                                                                    )
                                                                    object).getResults().getRows();

                                                    if (elementsList != null) {
                                                        if (page.equals("1")) {
                                                            totalPages = ((CommitNumberListBean) object).getResults().getTotal();
                                                            loadeMore.setCurrentPage(1);
                                                            currentPageOfLoad = 1;
                                                            if (CollectionUtils.isListNull
                                                                    (elementsList)) {
                                                                TooSnackbar.showMessage
                                                                        (coolResearchTableFragment, "没有可查阅的教案");
                                                            } else {
                                                                loadeMore.setCurrentPage
                                                                        (++currentPageOfLoad);
                                                            }
                                                            commitNumberList.clear();
                                                            commitNumberList.addAll
                                                                    (elementsList);
                                                            adapter.addList(commitNumberList);
                                                        } else {
                                                            loadeMore.setCurrentPage
                                                                    (++currentPageOfLoad);
                                                            commitNumberList.addAll
                                                                    (elementsList);
                                                            adapter.addList(commitNumberList);
                                                        }
                                                    }
                                                    dismissProgressDialog();
                                                    if (swipFragmentResearchTable.isRefreshing()) {
                                                        swipFragmentResearchTable.setRefreshing(false);
                                                    }
                                                }
                                            }


                                        }, page, "10", "", CustomApplication.userInfor.getUserId(),
                CustomApplication.userInfor.getSchoolId(), grade, subject);


    }

    private void setListner() {
        loadeMore = new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                currentPageOfLoad = currentPage;
                showProgressDialog("正在加载...");
                if (totalPages < currentPage) {
                    TooSnackbar.showMessage
                            (coolResearchTableFragment, "到底啦！");
                    return;
                }
                loadeCommitNumberList(currentPage + "", subject, grade);
            }
        };
        rlvFragmentResearchTableItemcontainer.addOnScrollListener(loadeMore);
        rlvFragmentResearchTableItemcontainer.addOnItemTouchListener(new OnRecyclerItemClickListener(rlvFragmentResearchTableItemcontainer,
                rlvFragmentResearchTableItemcontainer.getContext()) {//封装了为rescyler 封装了监听
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {

                if (popupWindow == null)
                    setPopWindow();
                whose = ((TextView) vh.itemView.findViewById(R.id.tv_item_name)).getText()
                        .toString();
                popupWindow.showAtLocation(coolResearchTableFragment, Gravity.CENTER, -1, -1);
                ((TextView) popupWindow.getContentView().findViewById(R.id.checked_name)).setText
                        ("查看" + whose + "的：");
                checkedId = ((List<CommitNumberListBean.ResultsBean.RowsBean>) commitNumberList)
                        .get(vh
                                .getAdapterPosition()).getId();
            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {
            }
        });
    }

    private void setPopWindow() {
        popupWindow = new PopupWindow(myActivity);
        View popView = myActivity.getLayoutInflater().inflate(R.layout.popupwindow_point_tosearch,
                null,
                false);
        TextView grammarPop = (TextView) popView.findViewById(R.id.tv_search_grammar_pop);
        TextView courserwarePop = (TextView) popView.findViewById(R.id.tv_search_courseware_pop);
        grammarPop.setOnClickListener(this);
        courserwarePop.setOnClickListener(this);
        popupWindow.setContentView(popView);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setHeight(DimenUtils.getDeviceHeight(myActivity) / 3);
        popupWindow.setWidth(DimenUtils.getDeviceWidth(myActivity) * 99 / 100);
        popupWindow.setFocusable(true);


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

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {

            case R.id.tv_search_grammar_pop:
                //1 提交的 0 未提交 空 全部
                addFragment(OnlineHandleMineGrammarFragment.newInstance("1", whose, checkedId));
                popupWindow.dismiss();
                break;
            case R.id.tv_search_courseware_pop:
                //1 提交的 0 未提交 空 全部
                addFragment(OnlineHandleMineCourseWareFragment.newInstance("1", whose, checkedId));
                popupWindow.dismiss();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
