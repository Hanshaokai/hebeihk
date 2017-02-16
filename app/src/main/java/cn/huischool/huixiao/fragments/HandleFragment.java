package cn.huischool.huixiao.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.home.MainActivity;
import cn.huischool.huixiao.activitys.onlinehandle.NotifiActivity;
import cn.huischool.huixiao.adapters.onlinehandle.RecyclerHandleAdapter;

import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.framework.BaseFragment;

/**
 * Created by ${han} on 2016/5/13.
 */
public class HandleFragment extends BaseFragment {
    // 未用到 此界面
    private RecyclerView recycler_handle;

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_table_handle, null, false);
        recycler_handle = (RecyclerView) view.findViewById(R.id.recycler_handle);//应用RecyclerView
        sethandleAdapter();


        return view;
    }

    private void sethandleAdapter() {
        // 丰富了功能
        //recycler_handle.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview
        recycler_handle.setLayoutManager(new GridLayoutManager(ct, 3));//这里用线性宫格显示 类似于grid view
        //        recycler_handle.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流
        recycler_handle.setAdapter(new RecyclerHandleAdapter(ct));

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        sethandleclickListener();

    }

    private void sethandleclickListener() {

        recycler_handle.addOnItemTouchListener(new OnRecyclerItemClickListener(recycler_handle,
                recycler_handle.getContext()) {//封装了为rescyler 封装了监听

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                Log.d("tag", "==OnRescylerItemclikListener点击了");
                switch (vh.getAdapterPosition()) {


                    case 1:
                        Intent intent = new Intent(ct, NotifiActivity.class);
                      /*  Bundle bundle = new Bundle();
                        bundle.putString("type", "3");
                        intent.putExtra("bundle", bundle);*/

                        startActivity(intent);
                        ((MainActivity) ct).finish();
                        break;

                }
            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {

            }
        });


    }

    @Override
    protected void onClickEvent(View view) {

    }
}
