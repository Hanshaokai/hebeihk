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
import cn.huischool.huixiao.bean.MyStudyNotesBean;
import cn.huischool.huixiao.common.utils.ToolRegex;

/**
 * Created by ${han} on 2016/8/12.
 */
public class MyStudyNotesAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist;

    public MyStudyNotesAdapter(Context ct, List o) {
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
        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.adapter_my_studynotes_item,
                null,
                false));/*parent不为null导致 分割线失效*/
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("tag", "==yetsendadapter position" + position);

        if (mlist != null) {
            List<MyStudyNotesBean.ResultsBean.ElementsBean> mlistacce = (List<MyStudyNotesBean
                    .ResultsBean.ElementsBean>) mlist;
            ((ContentViewHolder) holder).tv_my_study_notes_isSubmit_item.setText(mlistacce
                    .get(position).getSubmitStatus().equals("1") ? "已提交" : "未提交");
            ((ContentViewHolder) holder).tv_my_study_notes_studytheme_item.setText(mlistacce
                    .get(position).getStudyTitle());
            ((ContentViewHolder) holder).tv_my_study_notes_commentCount_item.setText("(" + mlistacce
                    .get(position).getMarkingAmount() + ")");
         ((ContentViewHolder) holder).tv_my_study_notes_browserCount_item.setText("(" + ToolRegex
                    .checkAcharApearTimesInAString(mlistacce
                            .get(position).getBrowseNames(), ',') + ")"
            );

        }

    }

    @Override
    public int getItemCount() {
        return mlist != null ? mlist.size() : 0;
    }


    public class ContentViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_my_study_notes_commentCount_item;
        private final TextView tv_my_study_notes_studytheme_item;
        private final TextView tv_my_study_notes_isSubmit_item;
        private final TextView tv_my_study_notes_browserCount_item;

        public ContentViewHolder(View itemView) {
            super(itemView);
            tv_my_study_notes_commentCount_item = (TextView) itemView.findViewById(R.id
                    .tv_my_study_notes_commentcount_item);
            tv_my_study_notes_studytheme_item = (TextView) itemView.findViewById(R.id
                    .tv_my_study_notes_studytheme_item);
            tv_my_study_notes_isSubmit_item = (TextView) itemView.findViewById(R.id
                    .tv_my_study_notes_issubmit_item);
            tv_my_study_notes_browserCount_item = (TextView) itemView.findViewById(R.id
                    .tv_my_study_notes_browsercount_item);



        }
    }
}
