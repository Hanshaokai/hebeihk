package cn.huischool.huixiao.adapters.onlinehandle;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.widget.CheckedImageView;
import com.rey.material.widget.TextView;

import cn.huischool.huixiao.R;
/*
public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private String[] mTitles;

    public NormalRecyclerViewAdapter(Context context) {
        mTitles = context.getResources().getStringArray(R.array.titles);
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.mTextView.setText(mTitles[position]);
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.text_view)
        TextView mTextView;

        NormalTextViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
    }
}*/
/**
 * Created by ${han} on 2016/5/17.
 */
public class RecyclerHandleAdapter extends RecyclerView.Adapter<RecyclerHandleAdapter
        .iconViewHolder> {
    private  LayoutInflater mLayoutInflater;
    private  Context mContext;
    private String[] mTitles;
    private int[] icon={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};;
    public RecyclerHandleAdapter(Context ct) {

        mTitles = ct.getResources().getStringArray(R.array.iconhandle);
        mContext=ct;
        mLayoutInflater = LayoutInflater.from(ct);
    }


    @Override
    public iconViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
   return new iconViewHolder(mLayoutInflater.inflate(R.layout.icon_handle, parent, false));
    }

    @Override
    public void onBindViewHolder(iconViewHolder holder, int position) {
holder.icon_text_handle.setText(mTitles[position]);
holder.icon_view_handle.setImageResource(icon[position]);
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }
    public static class iconViewHolder extends RecyclerView.ViewHolder{



        private final TextView icon_text_handle;
        private final CheckedImageView icon_view_handle;

        public iconViewHolder(View itemView) {
            super(itemView);
            icon_text_handle = (TextView) itemView.findViewById(R.id.icon_text_handle);
            icon_view_handle = (CheckedImageView) itemView.findViewById(R.id.icon_view_handle);
        }
    }
    public static class SpaceItemDecoration extends  RecyclerView.ItemDecoration{

        private int space;
        public SpaceItemDecoration(int space){

            this.space=space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            if (parent.getChildAdapterPosition(view)!=0){


               outRect.top=space;
            }
        }
    }
}
