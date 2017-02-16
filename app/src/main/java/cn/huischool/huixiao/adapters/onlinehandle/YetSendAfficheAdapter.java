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
import cn.huischool.huixiao.bean.YetSendAfficheBean;
import cn.huischool.huixiao.bean.YetSendNotifiBean;

/**
 * Created by ${han} on 2016/6/6.
 */
public class YetSendAfficheAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist=new ArrayList<>();
    private int count=0;



    public YetSendAfficheAdapter(Context ct, List o) {
        mlist = o;
        mContext = ct;
        mLayoutInflater = LayoutInflater.from(ct);

    }


    public void addList(List list) {

        mlist=list;



        notifyDataSetChanged();

    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.adapter_yetsend_affich_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("tag", "==yetsendadapter position" + position);


        Log.d("tag", "mlist" + mlist.size());
        if (mlist != null) {
            if (mlist.get(0) instanceof YetSendAfficheBean.ResultsBean.ElementsBean) {
                List<YetSendAfficheBean.ResultsBean.ElementsBean> mlistyet = (List<YetSendAfficheBean.ResultsBean.ElementsBean>) mlist;
                ((ContentViewHolder) holder).yetsendAfficheTitle.setText(mlistyet.get(position).getTitle
                        ());
                ((ContentViewHolder) holder).yetsendAfficheSendtiem.setText(mlistyet.get(position)
                        .getCreateTime());
                ((ContentViewHolder) holder).yetsendAfficheReceipe.setText(mlistyet.get(position)
                        .getSender());
                ((ContentViewHolder) holder).yetsendAffichecontent.setText(mlistyet.get(position)
                        .getContent());


            }

        }

    }


    @Override
    public int getItemCount() {


        return mlist != null ? mlist.size() : 0;
    }


    public class ContentViewHolder extends RecyclerView.ViewHolder {


        TextView yetsendAfficheTitle;

        TextView yetsendAfficheReceipe;

        TextView yetsendAfficheSendtiem;
        TextView yetsendAffichecontent;

        public ContentViewHolder(View itemView) {
            super(itemView);

            yetsendAfficheTitle = (TextView) itemView.findViewById(R.id.yetsend_affiche_title);
            yetsendAfficheReceipe = (TextView) itemView.findViewById(R.id.yetsend_affiche_receipe);
            yetsendAfficheSendtiem = (TextView) itemView.findViewById(R.id
                    .yetsend_affiche_sendtiem);
            yetsendAffichecontent = (TextView) itemView.findViewById(R.id.yetsend_affiche_content);


        }
    }
}
