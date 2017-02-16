package cn.huischool.huixiao.adapters.homepage;


import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.R.layout;
import cn.huischool.huixiao.bean.AcceNotifiBean;
import cn.huischool.huixiao.bean.AfficheschBean;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeNotifiAdapter extends BaseAdapter {
    public List<?> mList;
    public Context ct;
    public LayoutInflater inflater;

    public HomeNotifiAdapter(Context context, List<?> mlist) {

        this.mList = mlist;
        this.ct = context;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        if (mList != null) {
            return mList.size();
        } else {
            return 0;

        }


    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater
                    .inflate(R.layout.element_listitem_notifi, null);
            holder.tv = (TextView) convertView.findViewById(R.id.tv_element);
            holder.iv = (ImageView) convertView.findViewById(R.id.iv_message_icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (mList.get(position) instanceof AcceNotifiBean.Elements) {
            holder.tv.setText(((AcceNotifiBean.Elements) mList.get(position)).getTitle().toString());

            if (((AcceNotifiBean.Elements) mList.get(position)).getHasRead().equals("1")) {

                holder.tv.setTextColor(Color.GRAY);
            } else {

                holder.tv.setTextColor(Color.BLACK);
            }

        }
        if (mList.get(position) instanceof AfficheschBean.Elements) {

            holder.tv.setText(((AfficheschBean.Elements) mList.get(position)).getTitle().toString());
            if (((AfficheschBean.Elements) mList.get(position)).getHasRead().equals("1")) {

                holder.tv.setTextColor(Color.GRAY);
            } else {

                holder.tv.setTextColor(Color.BLACK);
            }


        }


        return convertView;
    }

    public void addAll(List<?> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    class ViewHolder {
        public TextView tv;
        public ImageView iv;

    }

}
