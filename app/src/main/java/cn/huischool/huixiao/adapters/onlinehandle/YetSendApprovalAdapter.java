package cn.huischool.huixiao.adapters.onlinehandle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.YetSendAfficheBean;
import cn.huischool.huixiao.bean.YetSendApprovalListBean;

/**
 * Created by ${han} on 2016/6/15.
 */
public class YetSendApprovalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist = new ArrayList<>();
    private int count = 0;
    private String[] approvalType;
    private String[] approvalState;


    public YetSendApprovalAdapter(Context ct, List o) {
        mlist = o;
        mContext = ct;
        mLayoutInflater = LayoutInflater.from(ct);
        approvalType = ct.getResources().getStringArray(R.array.approvalType);
        approvalState = ct.getResources().getStringArray(R.array.approvalState);
    }


    public void addList(List list) {

        mlist = list;

        notifyDataSetChanged();

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.adapter_yetsend_approval_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("tag", "==yetsendadapter position" + position);

        Log.d("tag", "mlist" + mlist.size());
        if (mlist != null) {

            List<YetSendApprovalListBean.ResultsBean> mlistyet = (List<YetSendApprovalListBean
                    .ResultsBean>) mlist;

            try {
                ((ContentViewHolder) holder).yetsend_approval_type.setText(approvalType[Integer
                        .parseInt(mlistyet.get
                                (position).getApprovalType())]);

                ((ContentViewHolder) holder).yetsend_approval_state.setText(approvalState[Integer
                        .parseInt(mlistyet
                                .get(position)
                                .getApprovalStatus())]);

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            ((ContentViewHolder) holder).yetsendApprovalSendtiem.setText(mlistyet.get(position)
                    .getCreateTime());
            ((ContentViewHolder) holder).yetsend_approval_state.setText(approvalState[Integer
                    .parseInt(mlistyet
                            .get(position)
                            .getApprovalStatus())]);
            ((ContentViewHolder) holder).yetsendApprovalcontent.setText(mlistyet.get(position)
                    .getContent());


        }

    }


    @Override
    public int getItemCount() {


        return mlist != null ? mlist.size() : 0;
    }


    public class ContentViewHolder extends RecyclerView.ViewHolder {

        TextView yetsend_approval_type;
        TextView yetsend_approval_state;
        TextView yetsendApprovalSendtiem;
        TextView yetsendApprovalcontent;

        public ContentViewHolder(View itemView) {
            super(itemView);

            yetsend_approval_type = (TextView) itemView.findViewById(R.id.yetsend_approval_type);
            yetsend_approval_state = (TextView) itemView.findViewById(R.id
                    .yetsend_approval_state);
            yetsendApprovalSendtiem = (TextView) itemView.findViewById(R.id
                    .yetsend_approval_sendtiem);
            yetsendApprovalcontent = (TextView) itemView.findViewById(R.id
                    .yetsend_approval_content);


        }


    }

}