package cn.huischool.huixiao.common.widget.widgetofbindhompagefrga;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


import cn.huischool.huixiao.activitys.home.NewsDetailWebViewActivity;
import cn.huischool.huixiao.adapters.homepage.HomeViewPagerAdapter;
import cn.huischool.huixiao.bean.ChangeImageBean;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ImgchangeHome implements OnPageChangeListener {
    public Context ct;
    public LinearLayout llayout_dots_home;
    public static ViewPager vp_picshow_home;

    public HomeViewPagerAdapter adapterShow;
    public static int currentItem = 0;
    private boolean isLoop = true;
    public Thread thread;
    public int prePositn;// 用来记录前一个位置的变量
    public ChangeHandler changeHandler;
    private List<ImageView> list = new ArrayList<ImageView>();
    private List<ChangeImageBean.ResultsBean> result;
    private List<String> titleList = new ArrayList<>();
    private final TextView newsTitle;

    public static class ChangeHandler extends Handler {
        WeakReference<Context> mct;

        public ChangeHandler(Context ct) {
            mct = new WeakReference<Context>(ct);
        }

        public static void cancelThred() {

        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    currentItem = vp_picshow_home.getCurrentItem();
                    // 出现anr
                /*
                 * Log.d("tag", "==第" + currentItem + "张图片" ); if (currentItem
				 * == ivlist.size() - 1) { Log.d("tag", currentItem+"相等时" +
				 * (ivlist.size()-1));
				 * 
				 * vp_picshow_home.setAdapter(adapterShow);
				 * 
				 * } else if (currentItem < ivlist.size()-1) { Log.d("tag",
				 * currentItem+"小于" + (ivlist.size()-1)+"时");
				 * vp_picshow_home.setCurrentItem(currentItem + 1);
				 * 
				 * }
				 */
                    vp_picshow_home.setCurrentItem(currentItem + 1);// getCout 设成最大值

                    // 呈现无线循环效果
                    break;

            }
        }
    }

    public ImgchangeHome(Context ct, ViewPager viewPager,
                         LinearLayout linearLayout, TextView tv) {
        this.ct = ct;
        vp_picshow_home = viewPager;
        newsTitle = tv;
        this.llayout_dots_home = linearLayout;
        changeHandler = new ChangeHandler(ct);
        vp_picshow_home.addOnPageChangeListener(this);
        vp_picshow_home.setOnTouchListener(new View.OnTouchListener() {//父view识别up手势
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                LogUtil.d(motionEvent.getAction() + "touch");
                switch (motionEvent.getAction()) {

                    case MotionEvent.ACTION_UP:
                        isLoop = true;
                        break;


                }
                return false;
            }
        });
        try {
            loadImgData();
        } catch (NullPointerException e) {

        }
        // vp_picshow_home.setCurrentItem((ivlist.size()) * 100);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageSelected(int position) {

        try {
            View childAt = llayout_dots_home.getChildAt(position % list.size()); // 取模

            // 设置的数为无限大
            childAt.setBackgroundColor(Color.WHITE);
            llayout_dots_home.getChildAt(prePositn).setBackgroundColor(Color.LTGRAY);
            newsTitle.setText(titleList.get(position % list.size()));
            prePositn = position % list.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadImgData() {
        try {


            DataAchieve.checkImg(new DataAchieve.SuccessCallBack() {
                                     @Override
                                     public void handle(int code, Object object) {


                                         result = ((ChangeImageBean) object).getResults();
                                         if (result != null) {

                                             list = new ArrayList<ImageView>();
                                             list.clear();
                                             titleList.clear();
                                             int imagCount = result.size();
                                             LogUtil.d(imagCount + "");
                                             for (int i = 0; i < imagCount; i++) {
                                                 ImageView imageView = new ImageView(ct);
                                                 LoadBitmapUtils.LoadImagview(ct, result.get(i)
                                                                 .getMainImgUrl(),
                                                         imageView);
                                                 titleList.add(result.get(i).getTitle());
                                                 list.add(imageView);
                                                 LogUtil.d(i + "");
                                             }
                                             LogUtil.d("setDataPic(list);" + 1);
                                             setDataPic(list);
                                         }


                                     }


                                 }


                    , CustomApplication.userInfor.getSchoolId());
        } catch (NullPointerException e) {

        }


        //setDataPic(listpic);// 调用加载图片方法 放置viewpager 和 dots 后期美化
    }

    private List<ImageView> setDataPic(List<ImageView> list) {
        llayout_dots_home.removeAllViews();//防止重复添加view
        for (int i = 0; i < list.size(); i++) {
            View view = new View(ct);
            list.get(i).setTag(i);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
            params.setMargins(20, 0, 0, 0);
            view.setLayoutParams(params);

            view.setBackgroundColor(Color.LTGRAY);

            llayout_dots_home.addView(view);

            /**
             * content : <img src="http://www.huischool.cn/temporaryHtml/image/20160810/20160810112010_713.jpg" alt="" />
             * id : 57aa9d6c0cf26d8718dea2ec
             * title : 0810测试新闻
             * mainImgUrl : http://img-app-index.oss-cn-beijing.aliyuncs.com/chengxiangxiaoxue_test/57aa9d6c0cf26d8718dea2eb
             */
            list.get(i).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {// 转向图片详情页面 后期添加
                    Intent intent = new Intent(ct, NewsDetailWebViewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("content", result.get((Integer) v.getTag()).getContent());
                    bundle.putString("id", result.get((Integer) v.getTag()).getId());
                    bundle.putString("title", result.get((Integer) v.getTag()).getTitle());
                    bundle.putString("mainImgUrl", result.get((Integer) v.getTag()).getMainImgUrl());
                    intent.putExtras(bundle);
                    ct.startActivity(intent);
                }
            });

            list.get(i).setOnTouchListener(new View.OnTouchListener() {//
                //ziview点击时识别up和down,手势
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    LogUtil.d(motionEvent.getAction() + "listtouch");
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            isLoop = false;
                            break;
                        case MotionEvent.ACTION_UP:
                            isLoop = true;
                            break;
                    }
                    return false;
                }
            });
        }
        if (list.size() != 0) {
            adapterShow = new HomeViewPagerAdapter(list);
            vp_picshow_home.setAdapter(adapterShow);
        }
        if (llayout_dots_home.getChildCount() != 0) {
            llayout_dots_home.getChildAt(0).setBackgroundColor(Color.WHITE);
            newsTitle.setText(titleList.get(0));
            prePositn = 0;
        }
        if (list.size() > 1) {
            thread = new Thread() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    // 子线程不能操作主线程中的ui
                    while (true) {
                        if (isLoop) {

                            try {
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            changeHandler.sendEmptyMessage(0);
                            try {
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }


            };
            thread.start();

        }
        return list;
    }

    /*当Activity finish后 handler对象还是在Message中排队。 还是会处理消息
   在Activity onStop或者onDestroy的时候，取消掉该Handler对象的Message和Runnable。
    通过查看Handler的API，它有几个方法：removeCallbacks(Runnable r)和removeMessages(int what)等。*/
    public void setIsloop() {
        isLoop = false;
        changeHandler.removeCallbacksAndMessages(null);
    }

}
