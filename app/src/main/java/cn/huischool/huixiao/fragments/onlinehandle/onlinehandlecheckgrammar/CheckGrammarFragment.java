package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlecheckgrammar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rey.material.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.onlinehandle.CheckGrammarActivity;
import cn.huischool.huixiao.adapters.onlinehandle.CheckGrammerAdapter;
import cn.huischool.huixiao.common.widget.widgetofbindtagview.TagAdapter;
import cn.huischool.huixiao.bean.CheckGrammarListBean;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.TooSnackbar;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.DividerItemDecoration;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.LoadeMoreRecyclerOnScrollListener;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.common.widget.widgetofbindtagview.TagFlowLayout;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlemineteacherplan.MineGrammarDetailFragment;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/7/26.
 */
public class CheckGrammarFragment extends BaseFragment {

    private TagFlowLayout tagfl_fragment_checkgrammar_subject;
    private TagFlowLayout tagfl_fragment_checkgrammar_class;
    private Toolbar toolbar_clude;
    private TextView tv_title_clude;
    private CheckGrammarActivity myActivity;
    private String[] subjectitems;
    private String[] classitems;
    private SwipeRefreshLayout swip_fragment_checkgrammar;
    private RecyclerView rlv_fragment_checkgrammar_itemcontainer;
    private List<CheckGrammarListBean.ResultsBean> checkGrammerElementsList = new ArrayList<>();
    private CheckGrammerAdapter adapter;
    private String subject = "全部";
    private String grade = "全部";
    private LinearLayoutManager layoutManager;
    private CoordinatorLayout cool_check_grammar_fragment;
    private int currentPageOfLoad = 1;
    private LoadeMoreRecyclerOnScrollListener loadeMore;
    int gainsboro;

    @Override
    public View initView(LayoutInflater inflater) {

        myActivity = (CheckGrammarActivity) baseFragmentActivity;
        gainsboro = myActivity.getResources().getColor(R.color.gainsboro);
        view = inflater.inflate(R.layout.fragment_online_checkgrammar, null, false);
        cool_check_grammar_fragment = (CoordinatorLayout) view.findViewById(R.id
                .cool_check_grammar_fragment);
        tagfl_fragment_checkgrammar_subject = (TagFlowLayout) view.findViewById(R.id
                .tagfl_fragment_checkgrammar_subject);
        tagfl_fragment_checkgrammar_class = (TagFlowLayout) view.findViewById(R.id
                .tagfl_fragment_checkgrammar_class);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        rlv_fragment_checkgrammar_itemcontainer = (RecyclerView) view.findViewById(R.id
                .rlv_fragment_checkgrammar_itemcontainer);
        swip_fragment_checkgrammar = (SwipeRefreshLayout) view.findViewById(R.id
                .swip_fragment_checkgrammar);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        initToolBar(toolbar_clude, true, "查阅教案", -1, true);
        subjectitems = myActivity.getResources().getStringArray(R.array.subjectitem);
        classitems = myActivity.getResources().getStringArray(R.array.classitem);
        setAdapter();
        setSwip();
        setListner();
        if (checkGrammerElementsList.size() == 0) {
            showProgressDialog("正在加载...");
            loadeGrammarList(currentPageOfLoad + "", subject, grade);
        }
    }

    private void setListner() {

        loadeMore = new LoadeMoreRecyclerOnScrollListener
                (layoutManager) {


            @Override
            public void onLoadMore(int currentPage) {
                currentPageOfLoad = currentPage;
                showProgressDialog("正在加载...");
                loadeGrammarList(currentPage + "", subject, grade);
            }
        };
        rlv_fragment_checkgrammar_itemcontainer.addOnScrollListener(loadeMore);

        rlv_fragment_checkgrammar_itemcontainer.addOnItemTouchListener(new OnRecyclerItemClickListener(rlv_fragment_checkgrammar_itemcontainer,
                rlv_fragment_checkgrammar_itemcontainer.getContext()) {//封装了为rescyler 封装了监听

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {


                addFragment(MineGrammarDetailFragment.newInstance(checkGrammerElementsList.get(vh
                        .getAdapterPosition()).getId()));


            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });
    }

    private void loadeGrammarList(final String page, final String subject, final String grade) {


        DataAchieve.togetCheckGrammarList(new DataAchieve.SuccessCallBack() {
                                              @Override
                                              public void handle(int code, Object object) {

                                                  if (code != 1000) {
                                                      dismissProgressDialog();
                                                      if (swip_fragment_checkgrammar.isRefreshing()) {
                                                          swip_fragment_checkgrammar.setRefreshing(false);
                                                      }

                                                      return;

                                                  } else {

                                                      List<CheckGrammarListBean.ResultsBean>
                                                              elementsList =
                                                              ((CheckGrammarListBean
                                                                      )
                                                                      object).getResults();
                                                      if (elementsList != null) {


                                                          if (page.equals("1")) {
                                                              loadeMore.setCurrentPage(1);
                                                              currentPageOfLoad = 1;
                                                              if (CollectionUtils.isListNull
                                                                      (elementsList)) {
                                                                  TooSnackbar.showMessage
                                                                          (cool_check_grammar_fragment, "没有可查阅的教案");

                                                              } else {

                                                                  loadeMore.setCurrentPage
                                                                          (++currentPageOfLoad);

                                                              }
                                                              checkGrammerElementsList.clear();
                                                              checkGrammerElementsList.addAll
                                                                      (elementsList);
                                                              adapter.addList(checkGrammerElementsList);
                                                          } else {


                                                              if (CollectionUtils.isListNull
                                                                      (elementsList)) {
                                                                  TooSnackbar.showMessage
                                                                          (cool_check_grammar_fragment, "没有更多的可查阅教案啦");

                                                              } else {

                                                                  loadeMore.setCurrentPage
                                                                          (++currentPageOfLoad);

                                                              }
                                                              LogUtil.d("前个数",
                                                                      checkGrammerElementsList
                                                                              .size());


                                                              checkGrammerElementsList.addAll
                                                                      (elementsList);
                                                              LogUtil.d("后个数",
                                                                      checkGrammerElementsList
                                                                              .size());
                                                              adapter.addList(checkGrammerElementsList);
                                                          }

                                                      }
                                                      dismissProgressDialog();
                                                      if (swip_fragment_checkgrammar.isRefreshing()) {

                                                          swip_fragment_checkgrammar.setRefreshing(false);
                                                      }


                                                  }


                                              }


                                          }, CustomApplication.userInfor.getRemarkId(),
                CustomApplication.userInfor.getSchoolId(), subject, grade, "", page,
                "12");

    }

    private void setSwip() {
        swip_fragment_checkgrammar.setSize(SwipeRefreshLayout.DEFAULT);
        swip_fragment_checkgrammar.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        swip_fragment_checkgrammar.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadeGrammarList(1 + "", subject, grade);


            }
        });
    }

    private void setAdapter() {


        tagfl_fragment_checkgrammar_subject.setAdapter(new TagAdapter(subjectitems) {
                                                           @Override
                                                           public View getView(ViewGroup parent, int position, Object o) {
                                                               int point = 0;
                                                               TextView tv = (TextView)
                                                                       myActivity.getLayoutInflater().inflate
                                                                               (R.layout.tag_item_tv,
                                                                                       parent, false);
                                                               LogUtil.d((String) o);
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
        tagfl_fragment_checkgrammar_subject.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(ViewGroup parent, View view, int position) {

                int count = parent.getChildCount();
                LogUtil.d("点击tag");
                for (int i = 0; i < count; i++) {
                    TextView t = (TextView) (parent.getChildAt(i).findViewById(R.id
                            .tv_tag_flexitem));
                    t.setTextColor(gainsboro);
                }

                TextView t = (TextView) (parent.getChildAt(position).findViewById(R.id
                        .tv_tag_flexitem));
                t.setTextColor(Color.BLACK);
                subject = (String) t
                        .getText();
                showProgressDialog("正在加载...");
                loadeGrammarList("1", subject, grade);
                loadeMore.setCurrentPage(1);
            }
        });
        tagfl_fragment_checkgrammar_class.setAdapter(new TagAdapter(classitems) {
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

        tagfl_fragment_checkgrammar_class.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(ViewGroup parent, View view, int position) {
                int count = parent.getChildCount();
                LogUtil.d(count + "点击tag");
                for (int i = 0; i < count; i++) {
                    TextView t = (TextView) (parent.getChildAt(i).findViewById(R.id
                            .tv_tag_flexitem));
                    t.setTextColor(gainsboro);
                }
                TextView t = (TextView) (parent.getChildAt(position).findViewById(R.id
                        .tv_tag_flexitem));
                t.setTextColor(Color.BLACK);
                grade = (String) t
                        .getText();
                showProgressDialog("正在加载...");
                loadeGrammarList("1", subject, grade);
                loadeMore.setCurrentPage(1);
            }
        });
        layoutManager = new LinearLayoutManager(myActivity);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlv_fragment_checkgrammar_itemcontainer.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        rlv_fragment_checkgrammar_itemcontainer.setItemAnimator(new DefaultItemAnimator());
        adapter = new CheckGrammerAdapter(myActivity, checkGrammerElementsList);
        rlv_fragment_checkgrammar_itemcontainer.addItemDecoration(new DividerItemDecoration(myActivity,
                layoutManager
                        .getOrientation()));

        rlv_fragment_checkgrammar_itemcontainer.setAdapter(adapter);

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

    }


}
