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
import cn.huischool.huixiao.bean.AcceNotifiBean;
import cn.huischool.huixiao.bean.YetSendNotifiBean;


/**
 * Created by ${han} on 2016/5/18.
 */
public class YetSendNotifiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist = new ArrayList<>();
    private int count = 0;

    /* //item类型
     public static final int ITEM_TYPE_HEADER = 0;
     public static final int ITEM_TYPE_CONTENT = 1;
     public static final int ITEM_TYPE_BOTTOM = 2;
     private int mHeaderCount=1;//头部View个数
     private int mBottomCount=1;//底部View个数*/
    public YetSendNotifiAdapter(Context ct, List o) {
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

   /* @Override
    public int getItemViewType(int position) {
       *//* int dataItemCount=getContentItemCount();

        if (mHeaderCount != 0 && position < mHeaderCount) {
            //头部View
            return ITEM_TYPE_HEADER;
        } else {
            //内容View暂时不加底部视图

        }*//*
        return ITEM_TYPE_CONTENT;
    }
*/


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    /*    if (viewType ==ITEM_TYPE_HEADER) {
            return new HeaderViewHolder(mLayoutInflater.inflate(R.layout
                    .adapter_yetsend_header_item, parent, false));
        } else if (viewType == ITEM_TYPE_CONTENT) {
            return  new ContentViewHolder(mLayoutInflater.inflate(R.layout.adapter_yetsend_item, parent, false));
        }else if (viewType == ITEM_TYPE_BOTTOM) {
            return new BottomViewHolder(mLayoutInflater.inflate(R.layout.adapter_yetsend_item, parent, false));
        }
        return null;*/
        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.adapter_yetsend_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("tag", "==yetsendadapter position" + position);
      /*  if (holder instanceof HeaderViewHolder) {

        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).yetsendNotfiTitle.setText(mlist.get(position).getTitle
                    ());
            ((ContentViewHolder) holder).yetsendNotifiSendtiem.setText(mlist.get(position)
                    .getSendTime());
            ((ContentViewHolder) holder).yetsendNotifiReceipe.setText(mlist.get(position)
                    .getSendeeName());

        } else if (holder instanceof BottomViewHolder) {

        }*/

        Log.d("tag", "mlist" + mlist.size());
        if (mlist != null) {
            if (mlist.get(0) instanceof YetSendNotifiBean.ResultsBean.ElementsBean) {
                List<YetSendNotifiBean.ResultsBean.ElementsBean> mlistyet = (List<YetSendNotifiBean.ResultsBean.ElementsBean>) mlist;
                ((ContentViewHolder) holder).yetsendNotfiTitle.setText(mlistyet.get(position).getTitle
                        ());
                ((ContentViewHolder) holder).yetsendNotifiSendtiem.setText(mlistyet.get(position)
                        .getSendTime());
                ((ContentViewHolder) holder).yetsendNotifiReceipe.setText(mlistyet.get(position)
                        .getSendeeNames());
                ((ContentViewHolder) holder).yetsendnotificontent.setText(mlistyet.get(position)
                        .getContent());


            }
           /* if (mlist.get(0) instanceof AcceNotifiBean.Elements) {
                List<AcceNotifiBean.Elements> mlistacce = (List<AcceNotifiBean.Elements>) mlist;

                ((ContentViewHolder) holder).yetsendNotfiTitle.setText(mlistacce.get(position).getTitle
                        ());
                ((ContentViewHolder) holder).yetsendNotifiSendtiem.setText(mlistacce.get(position)
                        .getSendTime());
                ((ContentViewHolder) holder).yetsendNotifiReceipe.setText(mlistacce.get(position)
                        .getSendeeName());
                ((ContentViewHolder) holder).yetsendnotificontent.setText(mlistacce.get(position)
                        .getContent());


            }*/
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


        TextView yetsendNotfiTitle;

        TextView yetsendNotifiReceipe;

        TextView yetsendNotifiSendtiem;
        TextView yetsendnotificontent;

        public ContentViewHolder(View itemView) {
            super(itemView);

            yetsendNotfiTitle = (TextView) itemView.findViewById(R.id.yetsend_notfi_title);
            yetsendNotifiReceipe = (TextView) itemView.findViewById(R.id.yetsend_notifi_receipe);
            yetsendNotifiSendtiem = (TextView) itemView.findViewById(R.id.yetsend_notifi_sendtiem);
            yetsendnotificontent = (TextView) itemView.findViewById(R.id.yetsend_notifi_content);


        }
    }
}
