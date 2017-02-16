package cn.huischool.huixiao.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.pgyersdk.javabean.AppBean;
import com.pgyersdk.update.PgyUpdateManager;
import com.pgyersdk.update.UpdateManagerListener;

import java.lang.ref.WeakReference;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.home.MainActivity;
import cn.huischool.huixiao.activitys.onlinehandle.AfficheActivity;
import cn.huischool.huixiao.activitys.onlinehandle.NotifiActivity;
import cn.huischool.huixiao.adapters.homepage.HomeNotifiAdapter;
import cn.huischool.huixiao.adapters.homepage.HomeViewPagerAdapter;
import cn.huischool.huixiao.bean.AcceNotifiBean;
import cn.huischool.huixiao.bean.AcceNotifiBean.Elements;
import cn.huischool.huixiao.bean.AcceNotifiBean.Results;
import cn.huischool.huixiao.bean.AfficheschBean;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.widget.widgetofbindhompagefrga.ImgchangeHome;
import cn.huischool.huixiao.fragments.homepage.NotifiDialogFragment;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.achieve.DataAchieve.SuccessCallBack;
import cn.huischool.huixiao.framework.base.CustomApplication;

public class HomePageFragment extends BaseFragment {
    public ViewPager vp_picshow_home;
    public LinearLayout llayout_dots_home;
    public ListView lv_home_board;
    public ListView lv_home_notifi;
    public static List<Elements> notifiElementsList = null;
    public static List<cn.huischool.huixiao.bean.AfficheschBean.Elements> boardElementsList = null;
    public static HomeNotifiAdapter notifiAdapter;
    public static HomeNotifiAdapter boardAdapter;
    public ImgchangeHome imgchangeHome;
    public HomeViewPagerAdapter adapterShow;
    public SuccessCallBack boardHandler;
    public SuccessCallBack notifiHandler;
    private SwipeRefreshLayout swip_home;
    private MainActivity myActivity;
    private LayoutInflater inflater;
    private TextView tv_main_news_title;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = (MainActivity) baseFragmentActivity;
        this.inflater = inflater;
        View view = inflater.inflate(R.layout.fragment_homepage, null, false);
        vp_picshow_home = (ViewPager) view.findViewById(R.id.vp_picshow_home);
        llayout_dots_home = (LinearLayout) view
                .findViewById(R.id.llayout_dots_home);
        lv_home_notifi = (ListView) view.findViewById(R.id.lv_home_notifi);
        lv_home_board = (ListView) view.findViewById(R.id.lv_home_board);
        swip_home = (SwipeRefreshLayout) view.findViewById(R.id.swip_home);
        tv_main_news_title = (TextView) view.findViewById(R.id.tv_main_news_title);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        checkedNewVersion();

        homeSetAdapter();

        setListener();
        setSwipe();

        swip_home.setRefreshing(true);
        homeInit();
        loadMsgData();
        loadBoardData();


    }

    private void checkedNewVersion() {
        //检查更新
        PgyUpdateManager.register(myActivity, new UpdateManagerListener() {

            @Override
            public void onUpdateAvailable(final String result) {
                final AppBean appBean = getAppBeanFromString(result);
                new AlertDialog.Builder(myActivity).setTitle("更新").setMessage(appBean.getReleaseNote())
                        .setPositiveButton(
                                "确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        startDownloadTask(myActivity, appBean.getDownloadURL());
                                        LogUtil.d("更新版本" + appBean.getVersionName() + appBean.getReleaseNote());
                                    }
                                }).setNegativeButton("晚点再说", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LogUtil.d("取消更新");
                    }
                }).show();


            }

            @Override
            public void onNoUpdateAvailable() {
                LogUtil.d("无新版本");
            }

        });
    }

    private void setSwipe() {
       /* swip_home.setProgressBackgroundColor(R.color.bg_orange);*/

        swip_home.setSize(SwipeRefreshLayout.DEFAULT);
        swip_home.setColorSchemeResources(R.color.bg_blue_01, R.color.red,
                R.color.orange, R.color.bg_blue_01);
        // 调整进度条距离屏幕顶部的距离
        swip_home.setProgressViewOffset(false, 0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40,
                        getResources()
                                .getDisplayMetrics()));
        swip_home.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                homeInit();
                loadMsgData();
                loadBoardData();

            }
        });
    }

    private void homeSetAdapter() {

        notifiAdapter = new HomeNotifiAdapter(myActivity, notifiElementsList);


        View head_notifi = inflater.inflate(R.layout.item_notifi_head, null, false);

        /*LinearLayout.LayoutParams  tv1lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                ,LinearLayout.LayoutParams.MATCH_PARENT);*/
        TextView tv11 = new TextView(ct);
        tv11.setGravity(Gravity.END);
        tv11.setTextSize(20);
        tv11.setPadding(-1, 5, -1, 5);
        tv11.setText("更多");
        lv_home_notifi.addFooterView(tv11, null, true);
        lv_home_notifi.addHeaderView(head_notifi, null, false);// 在setAdapter 前加否则异常
        lv_home_notifi.setAdapter(notifiAdapter);

        boardAdapter = new HomeNotifiAdapter(ct, boardElementsList);
        View head_affiche = inflater.inflate(R.layout.item_affiche_head, null, false);

        TextView tv22 = new TextView(myActivity);
        tv22.setTextSize(20);
        tv22.setPadding(-1, 5, -1, 5);
        tv22.setGravity(Gravity.END);
        tv22.setText("更多");

        lv_home_board.addFooterView(tv22, null, true);
        lv_home_board.addHeaderView(head_affiche, null, false);// 在setAdapter 前加否则异常
        lv_home_board.setAdapter(boardAdapter);
    }

    private void homeInit() {
        boardHandler = new BoardHandler(this);
        notifiHandler = new NotifiHandler(this);
        imgchangeHome = new ImgchangeHome(myActivity, vp_picshow_home,
                llayout_dots_home,tv_main_news_title);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setListener() {
        lv_home_notifi.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {
                if (position == parent.getChildCount() - 1) {

                    Intent intent = new Intent(myActivity, NotifiActivity.class);
                    startActivity(intent);
                    //             myActivity.finish();

                    return;

                }
                NotifiDialogFragment notifiDialogFragment = new NotifiDialogFragment(
                );
/* 如果未读 标记已读*/
                if (notifiElementsList.get(position - 1).getHasRead().equals("0")) {
                    DataAchieve.toMarkReadOrNO(new SuccessCallBack() {
                        @Override
                        public void handle(int code, Object object) {
                            if (code == 1000) {
                                notifiElementsList.get(position - 1).setHasRead("1");

                            }
                        }
                    }, notifiElementsList.get(position - 1).getId(), "1");
                }
                ((TextView) (view.findViewById(R.id.tv_element))).setTextColor(Color.GRAY);

                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("ElementsList", notifiElementsList.get(position - 1));
                notifiDialogFragment.setArguments(bundle1);
                FragmentTransaction transaction = getFragmentManager()
                        .beginTransaction();
                transaction
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                notifiDialogFragment.show(transaction, "notifiDialogFragment");

            }
        });
        lv_home_board.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {
                if (position == parent.getChildCount() - 1) {

                    Intent intent = new Intent(myActivity, AfficheActivity.class);
                    startActivity(intent);
                    //  myActivity.finish();
                    return;

                }

                /* 如果未读 标记已读*/
                if (boardElementsList.get(position - 1).getHasRead().equals("0")) {
                    DataAchieve.toMarkReadOrNO(new SuccessCallBack() {
                        @Override
                        public void handle(int code, Object object) {
                            if (code == 1000) {
                                boardElementsList.get(position - 1).setHasRead("1");

                            }
                        }
                    }, boardElementsList.get(position - 1).getId(), "0");
                }
                ((TextView) (view.findViewById(R.id.tv_element))).setTextColor(Color.GRAY);


                NotifiDialogFragment notifiDialogFragment = new NotifiDialogFragment(
                );

                Bundle bundle = new Bundle();
                bundle.putSerializable("ElementsList", boardElementsList.get(position - 1));
                notifiDialogFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager()
                        .beginTransaction();
                transaction
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                notifiDialogFragment.show(transaction, "notifiDialogFragment");

            }
        });

    }

    private void loadBoardData() {

        DataAchieve.affiche(boardHandler, null, null, "1", "3",
                CustomApplication.userInfor.getSchoolId(),
                CustomApplication.userInfor.getUserId());

    }

    private void loadMsgData() {


        DataAchieve.acceNotifi(notifiHandler, null, null, "1", "3",
                CustomApplication.userInfor.getSchoolId(),
                CustomApplication.userInfor.getUserId(), null);
    }

    @Override
    protected void onClickEvent(View view) {
        // TODO Auto-generated method stub

    }

    public class BoardHandler implements SuccessCallBack {
        WeakReference<HomePageFragment> context;

        public BoardHandler(HomePageFragment hf) {
            this.context = new WeakReference<HomePageFragment>(hf);// 弱引用放置内存泄漏
        }

        @Override
        public void handle(int code, Object object) {

            if (code != 1000) {
                if (swip_home.isRefreshing()) {
                    swip_home.setRefreshing(false);
                }
                return;
            } else {
                cn.huischool.huixiao.bean.AfficheschBean.Results ments = ((AfficheschBean) object).getResults();
                if (ments != null) {
                    boardElementsList = ments.getElements();
                    Log.d("tag", "HomePageFragment==获得公告列表的条数");
                    boardAdapter.addAll(boardElementsList);

                    if (swip_home.isRefreshing()) {
                        swip_home.setRefreshing(false);
                    }


                }
            }


        }
    }

    public class NotifiHandler implements SuccessCallBack {
        WeakReference<HomePageFragment> contextReference;

        public NotifiHandler(HomePageFragment ct) {
            this.contextReference = new WeakReference<HomePageFragment>(ct);
        }

        @Override
        public void handle(int code, Object object) {


            if (code != 1000) {
                if (swip_home.isRefreshing()) {
                    swip_home.setRefreshing(false);
                }

                return;
            } else {
                Results ments = ((AcceNotifiBean) object).getResults();
                if (ments != null) {
                    Log.d("tag", "==" + ments.getElementsCount());
                    notifiElementsList = ments.getElements();
                    notifiAdapter.addAll(notifiElementsList);

                }
                if (swip_home.isRefreshing()) {
                    swip_home.setRefreshing(false);
                }
            }


        }
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        imgchangeHome.setIsloop();

        super.onDestroy();

    }
}
