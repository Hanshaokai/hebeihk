package cn.huischool.huixiao.adapters.onlinehandle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.CheckCourseWareListBean;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.widget.widgetofbindcircleImage.CircleImageView;

/**
 * Created by ${han} on 2016/7/26.
 */
public class CheckCourseWareAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist;


    public CheckCourseWareAdapter(Context ct, List o) {
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

        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.adapter_check_courseware_item,
                null,
                false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mlist != null) {
            List<CheckCourseWareListBean.ResultsBean> mlistacce = (List<CheckCourseWareListBean.ResultsBean>) mlist;
            ((ContentViewHolder) holder).tv_checkcourseware_coursewarename.setText(mlistacce.get
                    (position).getCoursewareName());
            ((ContentViewHolder) holder).tv_checkcourseware_creater_name.setText(mlistacce.get
                    (position).getCreater_name());


            ((ContentViewHolder) holder).tv_checkcourseware_coursewareversions.setText(mlistacce.get
                    (position).getCoursewareDet());

            LoadBitmapUtils.LoadHeadImagview(mContext, mlistacce.get(position).getCreater_imgurl(), ((ContentViewHolder) holder).civ_checkcourseware_creater_headimg);

            if (Integer.parseInt(mlistacce.get(position).getMarkingAmount()) > 0) {

                ((ContentViewHolder) holder).tv_checkcourseware_ischeck.setText("已批阅");
                SpannableString sp = new SpannableString("评论（" + mlistacce.get
                        (position).getMarkingAmount() + ")");
                ((ContentViewHolder) holder).tv_checkcourseware_commentcount.setText(sp);

            } else if (Integer.parseInt(mlistacce.get(position).getMarkingAmount()) == 0) {

                ((ContentViewHolder) holder).tv_checkcourseware_ischeck.setText("未批阅");
                ((ContentViewHolder) holder).tv_checkcourseware_commentcount.setText("未评论");
            }


        }


    }


    @Override
    public int getItemCount() {


        return mlist != null ? mlist.size() : 0;
    }


    public class ContentViewHolder extends RecyclerView.ViewHolder {
        CircleImageView civ_checkcourseware_creater_headimg;
        TextView tv_checkcourseware_commentcount;
        TextView tv_checkcourseware_creater_name;
        TextView tv_checkcourseware_ischeck;
        TextView tv_checkcourseware_coursewareversions;
        TextView tv_checkcourseware_coursewarename;

        public ContentViewHolder(View itemView) {
            super(itemView);


            civ_checkcourseware_creater_headimg = (CircleImageView) itemView.findViewById(R.id
                    .civ_checkcourseware_creater_headimg);
            tv_checkcourseware_commentcount = (TextView) itemView.findViewById(R.id
                    .tv_checkcourseware_commentcount);

            tv_checkcourseware_creater_name = (TextView) itemView.findViewById(R.id
                    .tv_checkcourseware_creater_name);

            tv_checkcourseware_ischeck = (TextView) itemView.findViewById(R.id
                    .tv_checkcourseware_ischeck);

            tv_checkcourseware_coursewareversions = (TextView) itemView.findViewById(R.id
                    .tv_checkcourseware_coursewareversions);

            tv_checkcourseware_coursewarename = (TextView) itemView.findViewById(R.id
                    .tv_checkcourseware_coursewarename);

        }
    }

}


