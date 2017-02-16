package cn.huischool.huixiao.common.widget.widgetofbindrecylcerview;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;



/**
 * Created by ${han} on 2016/5/17.
 */
public abstract class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private RecyclerView recyclerView;
private GestureDetectorCompat mGestureDetector;
    public OnRecyclerItemClickListener(RecyclerView recyclerView,Context ct){

        this.recyclerView= recyclerView;
        mGestureDetector=new GestureDetectorCompat(ct,new
                ItemTouchHelperGestureListener());
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetector.onTouchEvent(e);

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetector.onTouchEvent(e);
        Log.d("tag","==e2");
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public abstract void onItemClick(RecyclerView.ViewHolder vh);
public abstract void onLongClick(RecyclerView.ViewHolder vh);

    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View child =recyclerView.findChildViewUnder(e.getX(),e.getY());
            if (child!=null){
                RecyclerView.ViewHolder vh=recyclerView.getChildViewHolder(child);
               Log.d("tag","==点击了recycler");
                onItemClick(vh);
            }
            return  true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            View child =recyclerView.findChildViewUnder(e.getX(),e.getY());
            if (child!=null){
                RecyclerView.ViewHolder vh=recyclerView.getChildViewHolder(child);
                onLongClick(vh);

            }
        }
    }
}
