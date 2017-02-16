package cn.huischool.huixiao.fragments.homepage;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.home.WebViewHXActivity;
import cn.huischool.huixiao.bean.AcceNotifiBean;
import cn.huischool.huixiao.bean.AfficheschBean;

public class NotifiDialogFragment extends DialogFragment {
    Context context;
    Object object;

    public NotifiDialogFragment() {
    }


    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        object = getArguments().getSerializable("ElementsList");
        View diagView = LayoutInflater.from(getActivity()).inflate(R.layout.diag_item_homefragment,
                null, false);

        TextView title = (TextView) diagView.findViewById(R.id.title);
        TextView content = (TextView) diagView.findViewById(R.id.content);
        TextView noticeFileName = (TextView) diagView.findViewById(R.id.noticeFileName);
        TextView senderName = (TextView) diagView.findViewById(R.id.senderName);
        TextView sendTime = (TextView) diagView.findViewById(R.id.sendTime);
        TextView type_dialog = (TextView) diagView.findViewById(R.id.type_dialog);
        if (object != null && object instanceof AcceNotifiBean.Elements) {

	/*SpannableString sp1=new SpannableString("标题: "+((AcceNotifiBean.Elements)object).getTitle().toString());
    sp1.setSpan(new AbsoluteSizeSpan(40),0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	sp1.setSpan(new UnderlineSpan(),0,sp1.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);*/
            title.setText(((AcceNotifiBean.Elements) object).getTitle().toString());
            content.setText(((AcceNotifiBean.Elements) object).getContent().toString());
            noticeFileName.setText("附件名称：" + ((((AcceNotifiBean.Elements) object).getNoticeFileName().toString().equals("")) ? "无附件" : ((AcceNotifiBean.Elements) object).getNoticeFileName().toString()));

            if (!((AcceNotifiBean.Elements) object).getNoticeFileName().equals("")) {
                noticeFileName.setTextColor(Color.BLUE);
                noticeFileName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intentWebview = new Intent(getActivity(), WebViewHXActivity.class);
                        intentWebview.putExtra("url", ((AcceNotifiBean.Elements) object)
                                .getHtmlFileUrl());
                        startActivity(intentWebview);

                    }
                });
            }


            senderName.setText("发送者：" + ((AcceNotifiBean.Elements) object).getSenderName().toString
                    ());
            sendTime.setText(((AcceNotifiBean.Elements) object).getSendTime().toString());
            type_dialog.setText("通知信息");

        }
        if (object != null && object instanceof AfficheschBean.Elements) {

            title.setText(((AfficheschBean.Elements) object).getTitle().toString());
            content.setText(((AfficheschBean.Elements) object).getContent().toString());
            noticeFileName.setText("附件名称：" + ((((AfficheschBean.Elements) object).getAfficheFileName().toString().equals("")) ? "无附件" : ((AfficheschBean.Elements) object).getAfficheFileName().toString()));

            if (!((AfficheschBean.Elements) object).getAfficheFileName().equals("")) {
                noticeFileName.setTextColor(Color.BLUE);
                noticeFileName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intentWebview = new Intent(getActivity(), WebViewHXActivity.class);
                        intentWebview.putExtra("url", ((AfficheschBean.Elements) object)
                                .getHtmlFileUrl());
                        startActivity(intentWebview);
                    }
                });
            }

            senderName.setText("发送者：" + ((AfficheschBean.Elements) object).getSenderName()
                    .toString());
            sendTime.setText(((AfficheschBean.Elements) object).getSendTime().toString());

            type_dialog.setText("公告信息");
        }
        android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(getActivity()).setView
                (diagView)
                .create();
        alertDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);//不加 则shape不作用

        return alertDialog;
    }
}
