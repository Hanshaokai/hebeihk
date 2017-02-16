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
import cn.huischool.huixiao.bean.CheckGrammarListBean;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.widget.widgetofbindcircleImage.CircleImageView;

/**
 * Created by ${han} on 2016/7/26.
 */
public class CheckGrammerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist;


    public CheckGrammerAdapter(Context ct, List o) {
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

        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.adapter_check_grammar_item,
                null,
                false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mlist != null) {
            List<CheckGrammarListBean.ResultsBean> mlistacce = (List<CheckGrammarListBean.ResultsBean>) mlist;
            ((ContentViewHolder) holder).tv_checkgrammar_grammarname.setText(mlistacce.get
                    (position).getLessonName());
            ((ContentViewHolder) holder).tv_checkgrammar_creater_name.setText(mlistacce.get
                    (position).getCreater_name());


            ((ContentViewHolder) holder).tv_checkgrammar_grammarversions.setText(mlistacce.get
                    (position).getLessonDet());

            LoadBitmapUtils.LoadHeadImagview(mContext, mlistacce.get(position).getCreater_imgurl(), ((ContentViewHolder) holder).civ_checkgrammar_creater_headimg);

            if (Integer.parseInt(mlistacce.get(position).getMarkingAmount()) > 0) {

                ((ContentViewHolder) holder).tv_checkgrammar_ischeck.setText("已批阅");
                SpannableString sp = new SpannableString("评论（" + mlistacce.get
                        (position).getMarkingAmount() + ")");
                ((ContentViewHolder) holder).tv_checkgrammar_commentcount.setText(sp);

            } else if (Integer.parseInt(mlistacce.get(position).getMarkingAmount()) == 0) {

                ((ContentViewHolder) holder).tv_checkgrammar_ischeck.setText("未批阅");
                ((ContentViewHolder) holder).tv_checkgrammar_commentcount.setText("未评论");
            }


        }


    }


    @Override
    public int getItemCount() {


        return mlist != null ? mlist.size() : 0;
    }


    public class ContentViewHolder extends RecyclerView.ViewHolder {
        CircleImageView civ_checkgrammar_creater_headimg;
        TextView tv_checkgrammar_commentcount;
        TextView tv_checkgrammar_creater_name;
        TextView tv_checkgrammar_ischeck;
        TextView tv_checkgrammar_grammarversions;
        TextView tv_checkgrammar_grammarname;

        public ContentViewHolder(View itemView) {
            super(itemView);


            civ_checkgrammar_creater_headimg = (CircleImageView) itemView.findViewById(R.id
                    .civ_checkgrammar_creater_headimg);
            tv_checkgrammar_commentcount = (TextView) itemView.findViewById(R.id
                    .tv_checkgrammar_commentcount);

            tv_checkgrammar_creater_name = (TextView) itemView.findViewById(R.id
                    .tv_checkgrammar_creater_name);

            tv_checkgrammar_ischeck = (TextView) itemView.findViewById(R.id
                    .tv_checkgrammar_ischeck);

            tv_checkgrammar_grammarversions = (TextView) itemView.findViewById(R.id
                    .tv_checkgrammar_grammarversions);

            tv_checkgrammar_grammarname = (TextView) itemView.findViewById(R.id
                    .tv_checkgrammar_grammarname);

        }
    }

}


