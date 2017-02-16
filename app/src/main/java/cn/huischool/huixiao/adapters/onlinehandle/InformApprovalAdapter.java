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
import cn.huischool.huixiao.bean.ReceivApprovalBean;
import cn.huischool.huixiao.common.utils.LogUtil;

/**
 * Created by ${han} on 2016/8/23.
 */
public class InformApprovalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist;
    public String[] approvalType;

    public InformApprovalAdapter(Context ct, List o) {
        mlist = o;
        mContext = ct;
        mLayoutInflater = LayoutInflater.from(ct);
        approvalType = ct.getResources().getStringArray(R.array.approvalType);
    }


    public void addList(List list) {

        mlist = list;
        notifyDataSetChanged();

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.adapter_receive_approval_item,
                parent,
                false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("tag", "==yetsendadapter position" + position);

        if (mlist != null) {
            List<ReceivApprovalBean.ResultsBean> mlistacce = (List<ReceivApprovalBean.ResultsBean>) mlist;
            LogUtil.d("类型" + mlistacce.get(position).getApprovalType());
            ((ContentViewHolder) holder).receive_approval_sendname.setText(mlistacce.get
                    (position).getCreater());
            ((ContentViewHolder) holder).receive_approval_content.setText(mlistacce.get
                    (position).getContent());
            try {
                ((ContentViewHolder) holder).receive_approval_approvalType.setText
                        (approvalType[Integer.parseInt
                                (mlistacce.get(position).getApprovalType())]);
            } catch
                    (NumberFormatException e) {


            }

            if (mlistacce.get(position).getOpinion() == null) {
                ((ContentViewHolder) holder).receive_approval_status.setText("待审批");
            } else if
                    (mlistacce.get(position).getOpinion().equals("1")) {
                ((ContentViewHolder) holder).receive_approval_status.setText("同意");
            } else if (mlistacce.get(position).getOpinion().equals("0")) {

                ((ContentViewHolder) holder).receive_approval_status.setText("不同意");
            }


        }

    }


    @Override
    public int getItemCount() {


        return mlist != null ? mlist.size() : 0;
    }


    public class ContentViewHolder extends RecyclerView.ViewHolder {


        TextView receive_approval_sendname;

        TextView receive_approval_approvalType;


        TextView receive_approval_content;
        TextView receive_approval_status;

        public ContentViewHolder(View itemView) {
            super(itemView);

            receive_approval_sendname = (TextView) itemView.findViewById(R.id.receive_approval_sendname);
            receive_approval_approvalType = (TextView) itemView.findViewById(R.id.receive_approval_approvalType);

            receive_approval_content = (TextView) itemView.findViewById(R.id.receive_approval_content);
            receive_approval_status = (TextView) itemView.findViewById(R.id
                    .receive_approval_status);


        }
    }

}

