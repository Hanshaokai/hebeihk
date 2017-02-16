package cn.huischool.huixiao.adapters.onlinehandle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.MyCourseWareBean;
import cn.huischool.huixiao.bean.MyTeacherPlanBean;

/**
 * Created by ${han} on 2016/7/15.
 */
public class MyCourseWareAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist;


    public MyCourseWareAdapter(Context ct, List o) {
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

        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.adapter_my_courseware_item,
                null,
                false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("tag", "==yetsendadapter position" + position);

        if (mlist != null) {
            List<MyCourseWareBean.ResultsBean.ElementsBean> mlistacce = (List<MyCourseWareBean
                    .ResultsBean.ElementsBean>) mlist;
            ((ContentViewHolder) holder).tv_my_courseware_name_item.setText(mlistacce.get
                    (position).getCoursewareName());
            ((ContentViewHolder) holder).tv_my_courseware_version_item.setText(mlistacce.get
                    (position).getCoursewareDet());


            ((ContentViewHolder) holder).tv_my_courseware_issubmit.setText(mlistacce.get(position).getCoursewareType());


            if (Integer.parseInt(mlistacce.get(position).getMarkingAmount()) > 0) {

                ((ContentViewHolder) holder).tv_my_courseware_isapproval.setText("已批阅");
                SpannableString sp = new SpannableString("评论（" + mlistacce.get
                        (position).getMarkingAmount() + ")");
                ((ContentViewHolder) holder).tv_my_courseware_iscomment.setText(sp);

            } else if (Integer.parseInt(mlistacce.get(position).getMarkingAmount()) == 0) {

                ((ContentViewHolder) holder).tv_my_courseware_isapproval.setText("未批阅");
                ((ContentViewHolder) holder).tv_my_courseware_iscomment.setText("未评论");
            }

        }

    }

    @Override
    public int getItemCount() {


        return mlist != null ? mlist.size() : 0;
    }


    public class ContentViewHolder extends RecyclerView.ViewHolder {


        TextView tv_my_courseware_isapproval;
        TextView tv_my_courseware_issubmit;
        TextView tv_my_courseware_version_item;
        TextView tv_my_courseware_name_item;
        TextView tv_my_courseware_iscomment;

        public ContentViewHolder(View itemView) {
            super(itemView);

            tv_my_courseware_isapproval = (TextView) itemView.findViewById(R.id.tv_my_courseware_isapproval);

            tv_my_courseware_iscomment = (TextView) itemView.findViewById(R.id.tv_my_courseware_iscomment);

            tv_my_courseware_issubmit = (TextView) itemView.findViewById(R.id
                    .tv_my_courseware_issubmit);

            tv_my_courseware_version_item = (TextView) itemView.findViewById(R.id
                    .tv_my_courseware_version_item);


            tv_my_courseware_name_item = (TextView) itemView.findViewById(R.id
                    .tv_my_courseware_name_item);


        }
    }

}

