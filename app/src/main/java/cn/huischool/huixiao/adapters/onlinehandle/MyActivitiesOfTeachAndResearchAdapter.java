package cn.huischool.huixiao.adapters.onlinehandle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.MyActivitiesOfTeachAndResearchBean;
import cn.huischool.huixiao.common.utils.ToolRegex;

/**
 * Created by ${han} on 2016/8/17.
 */
public class MyActivitiesOfTeachAndResearchAdapter extends RecyclerView.Adapter<RecyclerView
        .ViewHolder> {
    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist;

    public MyActivitiesOfTeachAndResearchAdapter(Context ct, List o) {
        mlist = o;
        mContext = ct;
        mLayoutInflater = LayoutInflater.from(ct);

    }

    public void addList(List list) {
        mlist = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.adapter_my_activitiesofteachandresearch_item,
                null,
                false));/*parent不为null导致 分割线失效*/
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("tag", "==yetsendadapter position" + position);

        if (mlist != null) {
            List<MyActivitiesOfTeachAndResearchBean.ResultsBean.ElementsBean> mlistacce = (List<MyActivitiesOfTeachAndResearchBean
                    .ResultsBean.ElementsBean>) mlist;
            ((ContentViewHolder) holder).tv_my_activitiesofteachandresearch_isSubmit_item.setText(mlistacce
                    .get(position).getSubmitStatus().equals("1") ? "已提交" : "未提交");
            ((ContentViewHolder) holder).tv_my_activitiesofteachandresearch_theme_item.setText(mlistacce
                    .get(position).getCenterTitle());
            ((ContentViewHolder) holder).tv_my_activitiesofteachandresearch_commentCount_item.setText("(" + mlistacce
                    .get(position).getMarkingAmount() + ")");
            ((ContentViewHolder) holder).tv_my_activitiesofteachandresearch_browserCount_item.setText("(" + ToolRegex
                    .checkAcharApearTimesInAString((String)mlistacce
                            .get(position).getBrowseNames(), ',') + ")"
            );

        }

    }

    @Override
    public int getItemCount() {
        return mlist != null ? mlist.size() : 0;
    }


    public class ContentViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_my_activitiesofteachandresearch_commentCount_item;
        private final TextView tv_my_activitiesofteachandresearch_theme_item;
        private final TextView tv_my_activitiesofteachandresearch_isSubmit_item;
        private final TextView tv_my_activitiesofteachandresearch_browserCount_item;

        public ContentViewHolder(View itemView) {
            super(itemView);
            tv_my_activitiesofteachandresearch_commentCount_item = (TextView) itemView.findViewById(R.id
                    .tv_my_activitiesofteachandresearch_commentcount_item);
            tv_my_activitiesofteachandresearch_theme_item = (TextView) itemView.findViewById(R.id
                    .tv_my_activitiesofteachandresearch_theme_item);
            tv_my_activitiesofteachandresearch_isSubmit_item = (TextView) itemView.findViewById(R.id
                    .tv_my_activitiesofteachandresearch_issubmit_item);
            tv_my_activitiesofteachandresearch_browserCount_item = (TextView) itemView.findViewById(R.id
                    .tv_my_activitiesofteachandresearch_browsercount_item);


        }
    }
}
