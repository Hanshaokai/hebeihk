package cn.huischool.huixiao.adapters.onlinehandle;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.AcceNotifiBean;


/**
 * Created by ${han} on 2016/5/18.
 */
public class ReceivNotifiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist;

    /* //item类型
     public static final int ITEM_TYPE_HEADER = 0;
     public static final int ITEM_TYPE_CONTENT = 1;
     public static final int ITEM_TYPE_BOTTOM = 2;
     private int mHeaderCount=1;//头部View个数
     private int mBottomCount=1;//底部View个数*/
    public ReceivNotifiAdapter(Context ct, List o) {
        mlist = o;
        mContext = ct;
        mLayoutInflater = LayoutInflater.from(ct);

    }

    /* //内容长度
     public int getContentItemCount(){
         return mlist != null ? mlist.size() : 0;
     }
     //判断当前item是否是HeadView
     public boolean isHeaderView(int position) {
         return mHeaderCount != 0 && position < mHeaderCount;
     }
     //判断当前item是否是FooterView
     public boolean isBottomView(int position) {
         return mBottomCount != 0 && position >= (mHeaderCount + getContentItemCount());
     }*/
    public void addList(List list) {
        mlist = list;
        notifyDataSetChanged();

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.adapter_receive_notifi_item,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("tag", "==yetsendadapter position" + position);


        if (mlist != null) {


            if (mlist.get(0) instanceof AcceNotifiBean.Elements) {
                List<AcceNotifiBean.Elements> mlistacce = (List<AcceNotifiBean.Elements>) mlist;
                if (mlistacce.get(position).getHasRead().equals("1")) {
                    ((ContentViewHolder) holder).receiveNotfiTitle.setTextColor(Color.GRAY);
                } else {
                    ((ContentViewHolder) holder).receiveNotfiTitle.setTextColor(Color.BLACK);
                }
                ((ContentViewHolder) holder).receiveNotfiTitle.setText(mlistacce.get(position).getTitle
                        ());
                ((ContentViewHolder) holder).receiveNotifiSendtiem.setText(mlistacce.get(position)
                        .getSendTime());
                ((ContentViewHolder) holder).receiveNotifiReceipe.setText(mlistacce.get(position)
                        .getSenderName());
                ((ContentViewHolder) holder).receiveNotificontent.setText(mlistacce.get(position)
                        .getContent());


            }
        }

    }


    @Override
    public int getItemCount() {


        return mlist != null ? mlist.size() : 0;
    }
   /* //头部 ViewHolder
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
    //底部 ViewHolder
    public static class BottomViewHolder extends RecyclerView.ViewHolder {

        public BottomViewHolder(View itemView) {
            super(itemView);
        }
    }*/


    public class ContentViewHolder extends RecyclerView.ViewHolder {


        TextView receiveNotfiTitle;

        TextView receiveNotifiReceipe;

        TextView receiveNotifiSendtiem;
        TextView receiveNotificontent;

        public ContentViewHolder(View itemView) {
            super(itemView);

            receiveNotfiTitle = (TextView) itemView.findViewById(R.id.receive_notfi_title);
            receiveNotifiReceipe = (TextView) itemView.findViewById(R.id.receive_notifi_receipe);
            receiveNotifiSendtiem = (TextView) itemView.findViewById(R.id.receive_notifi_sendtiem);
            receiveNotificontent = (TextView) itemView.findViewById(R.id.receive_notifi_content);


        }
    }
}
