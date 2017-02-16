package cn.huischool.huixiao.adapters.onlinehandle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.CommitNumberListBean;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;

/**
 * Created by ${han} on 2017/1/9.
 */

public class CommitNUmberListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist;


    public CommitNUmberListAdapter(Context ct, List o) {
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

        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.item_research_table_number_presented,
                parent,
                false));
        //若 parent 设置为null 则 父viewparent不起作用
        /*
    如果root为null，attachToRoot将失去作用，设置任何值都没有意义。
    如果root不为null，attachToRoot设为true，则会给加载的布局文件的指定一个父布局，即root。
    如果root不为null，attachToRoot设为false，则会将布局文件最外层的所有layout属性进行设置，当该view被添加到父view当中时，这些layout属性会自动生效。
    在不设置attachToRoot参数的情况下，如果root不为null，attachToRoot参数默认为true。
*/
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        List<CommitNumberListBean.ResultsBean.RowsBean> mlistacce = (List<CommitNumberListBean.ResultsBean.RowsBean>) mlist;
        LoadBitmapUtils.LoadHeadImagview(mContext, mlistacce.get(position).getCreater_imgurl(), ((ContentViewHolder) holder).ivItemImg);
        ((ContentViewHolder) holder).tvItemName.setText(mlistacce.get(position).getRealName());
        ((ContentViewHolder) holder).tvCourseware.setText("课件：" + mlistacce.get(position)
                .getCourseware_count());
        ((ContentViewHolder) holder).tvGrammar.setText("教案：" + mlistacce.get(position).getLesson_count
                ());
        ((ContentViewHolder) holder).tvLessonlearned.setText("课程体会：" + mlistacce.get(position)
                .getMyLesson_count());
        ((ContentViewHolder) holder).tvMeetingrecord.setText("会议记录：" + mlistacce.get(position)
                .getMeetRecord_count());
        ((ContentViewHolder) holder).tvStudynotes.setText("学习笔记：" + mlistacce.get(position)
                .getStudyNotes_count());
        ((ContentViewHolder) holder).tvResearchactivityy.setText("教研活动：" + mlistacce.get(position)
                .getResearchActivity_count());
    }


    @Override
    public int getItemCount() {


        return mlist != null ? mlist.size() : 0;
    }


    public class ContentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item_img)
        ImageView ivItemImg;
        @BindView(R.id.tv_item_name)
        TextView tvItemName;
        @BindView(R.id.tv_grammar)
        TextView tvGrammar;
        @BindView(R.id.tv_lessonlearned)
        TextView tvLessonlearned;
        @BindView(R.id.tv_meetingrecord)
        TextView tvMeetingrecord;
        @BindView(R.id.tv_courseware)
        TextView tvCourseware;
        @BindView(R.id.tv_studynotes)
        TextView tvStudynotes;
        @BindView(R.id.tv_researchactivityy)
        TextView tvResearchactivityy;

        public ContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
