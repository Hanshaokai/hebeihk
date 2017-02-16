package cn.huischool.huixiao.adapters.onlinehandle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.MyCourseWareBean;
import cn.huischool.huixiao.bean.MyLessonNotesBean;
import cn.huischool.huixiao.common.utils.ToolRegex;
import cn.huischool.huixiao.common.utils.ToolString;

/**
 * Created by ${han} on 2016/8/5.
 */
public class MyLeesonNotesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist;

    public MyLeesonNotesAdapter(Context ct, List o) {
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

        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.adapter_my_lessonnotes_item,
                null,
                false));/*parent不为null导致 分割线失效*/
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("tag", "==yetsendadapter position" + position);

        if (mlist != null) {
            List<MyLessonNotesBean.ResultsBean.ElementsBean> mlistacce = (List<MyLessonNotesBean
                    .ResultsBean.ElementsBean>) mlist;

            ((ContentViewHolder) holder).tv_my_lesson_notes_teachername_item.setText(mlistacce
                    .get(position).getLessonTeacher());
            ((ContentViewHolder) holder).tv_my_lesson_notes_lessonTitle_item.setText(mlistacce
                    .get(position).getLessonTitle());
            ((ContentViewHolder) holder).tv_my_lesson_notes_isSubmit_item.setText(mlistacce
                    .get(position).getSubmitStatus().equals("1") ? "已提交" : "未提交");

            StringBuffer infor = new StringBuffer();
            infor.append(mlistacce.get(position).getGradeName());
            infor.append(mlistacce.get(position).getClassName());
            infor.append(" ");
            infor.append(mlistacce.get(position).getSubjectName());

            ((ContentViewHolder) holder).tv_my_lesson_notes_lessonContent_item_item.setText(infor.toString());

            ((ContentViewHolder) holder).tv_my_lesson_notes_commentCount_item.setText("(" + mlistacce
                    .get(position).getMarkingAmount() + ")");
            ((ContentViewHolder) holder).tv_my_lesson_notes_browserCount_item.setText("(" + ToolRegex
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


        private final TextView tv_my_lesson_notes_commentCount_item;
        private final TextView tv_my_lesson_notes_lessonContent_item_item;
        private final TextView tv_my_lesson_notes_isSubmit_item;
        private final TextView tv_my_lesson_notes_browserCount_item;
        private final TextView tv_my_lesson_notes_lessonTitle_item;
        private final TextView tv_my_lesson_notes_teachername_item;

        public ContentViewHolder(View itemView) {
            super(itemView);
            tv_my_lesson_notes_commentCount_item = (TextView) itemView.findViewById(R.id
                    .tv_my_lesson_notes_commentcount_item);
            tv_my_lesson_notes_lessonContent_item_item = (TextView) itemView.findViewById(R.id
                    .tv_my_lesson_notes_lessoncontent_item);
            tv_my_lesson_notes_isSubmit_item = (TextView) itemView.findViewById(R.id
                    .tv_my_lesson_notes_issubmit_item);
            tv_my_lesson_notes_browserCount_item = (TextView) itemView.findViewById(R.id
                    .tv_my_lesson_notes_browsercount_item);
            tv_my_lesson_notes_lessonTitle_item = (TextView) itemView.findViewById(R.id
                    .tv_my_lesson_notes_lessontitle_item);
            tv_my_lesson_notes_teachername_item = (TextView) itemView.findViewById(R.id
                    .tv_my_lesson_notes_teachername_item);


        }
    }
}
