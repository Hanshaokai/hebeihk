package cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview.bean_item;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.SchoolContactsListBean;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview.AbstractExpandableAdapterItem;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/10/14.
 */

public class TeacherByLeaderItem extends AbstractExpandableAdapterItem implements View.OnClickListener {
    private TextView mName;
    private ImageView iv_hedaimg;

    @Override
    public int getLayoutResId() {
        return R.layout.item_school_contacts_teacher;
    }

    @Override
    public void onBindViews(View root) {
        root.setOnClickListener(this);
        mName = (TextView) root.findViewById(R.id.tv_name);
        iv_hedaimg = (ImageView) root.findViewById(R.id.iv_hedaimg);
    }

    @Override
    public void onSetViews() {

    }

    @Override
    public void onUpdateViews(Object model, int position) {
        super.onUpdateViews(model, position);
        if (model instanceof SchoolContactsListBean.ResultsBean.LeaderListBean
                .TeacherListBean) {
            SchoolContactsListBean.ResultsBean.LeaderListBean
                    .TeacherListBean teacherListBean = (SchoolContactsListBean.ResultsBean.LeaderListBean
                    .TeacherListBean) model;
            mName.setText(teacherListBean.getRealName());
            LoadBitmapUtils.LoadContactHeadImagview(CustomApplication.customApplication, teacherListBean
                    .getImgUrl(), iv_hedaimg);
        }
    }

    @Override
    public void onExpansionToggled(boolean expanded) {

    }

    @Override
    public void onClick(View view) {
        if (getExpandableListItem() != null && getExpandableListItem().getChildItemList() != null) {
            if (getExpandableListItem().isExpanded()) {
                collapseView();
            } else {
                expandView();
            }

        }
    }
}

