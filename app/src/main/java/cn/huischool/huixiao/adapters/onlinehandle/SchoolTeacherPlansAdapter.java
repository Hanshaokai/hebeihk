package cn.huischool.huixiao.adapters.onlinehandle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.SchoolShareLessonPlansBean;


/**
 * Created by ${han} on 2016/6/21.
 */
public class SchoolTeacherPlansAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist=new ArrayList<>();




    public SchoolTeacherPlansAdapter(Context ct, List o) {
        mlist = o;
        mContext = ct;
        mLayoutInflater = LayoutInflater.from(ct);

    }


    public void addList(List list) {

        mlist=list;

        notifyDataSetChanged();

    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentViewHolder(mLayoutInflater.inflate(R.layout
                .adapter_school_teacher_plans_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("tag", "==yetsendadapter position" + position);

        Log.d("tag", "mlist" + mlist.size());
        if (mlist != null) {

            List<SchoolShareLessonPlansBean.ResultsBean.ElementsBean> mlistyet = (List< SchoolShareLessonPlansBean.ResultsBean.ElementsBean>) mlist;





        }

    }


    @Override
    public int getItemCount() {


        return mlist != null ? mlist.size() : 0;
    }


    public class ContentViewHolder extends RecyclerView.ViewHolder {


        public ContentViewHolder(View itemView) {
            super(itemView);


        }


    }

}
