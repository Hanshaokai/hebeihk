package cn.huischool.huixiao.adapters.mine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.loadeFileBean;

/**
 * Created by ${han} on 2016/9/7.
 */
public class TextFileOfDownLoadeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<?> mlist;

    public TextFileOfDownLoadeAdapter(Context ct, List o) {
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

        return new ContentViewHolder(mLayoutInflater.inflate(R.layout
                        .adapter_textfile_loadecomplete_item,
                null,
                false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        List<loadeFileBean> fileBeanList = (List<loadeFileBean>) mlist;

        ((ContentViewHolder) holder).tv_filecomplete_filecreatetime_item.setText(fileBeanList.get
                (position).getCreateTime());

        ((ContentViewHolder) holder).tv_filecomplete_filename_item.setText(fileBeanList.get
                (position).getFileName());

        ((ContentViewHolder) holder).tv_filecomplete_filesize_item.setText(fileBeanList.get
                (position).getFileSize());
    }


    @Override
    public int getItemCount() {


        return mlist != null ? mlist.size() : 0;
    }


    public class ContentViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_filecomplete_filename_item;
        private final TextView tv_filecomplete_filecreatetime_item;
        private final TextView tv_filecomplete_filesize_item;

        public ContentViewHolder(View itemView) {
            super(itemView);
            tv_filecomplete_filename_item = (TextView) itemView.findViewById(R.id.tv_filecomplete_filename_item);
            tv_filecomplete_filecreatetime_item = (TextView) itemView.findViewById(R.id.tv_filecomplete_filecreatetime_item);
            tv_filecomplete_filesize_item = (TextView) itemView.findViewById(R.id.tv_filecomplete_filesize_item);

        }
    }



}

