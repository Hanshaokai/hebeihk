package cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview.bean_item;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.SchoolContactsListBean;
import cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview.AbstractExpandableAdapterItem;
import cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview.ExpandableListItem;

/**
 * Created by ${han} on 2016/10/11.
 */

public class ClassTeacherListItem extends AbstractExpandableAdapterItem implements View.OnClickListener {
    private TextView mName;


    @Override
    public void onClick(View view) {
        /*
* control item expand and unepand
* */
        if (getExpandableListItem() != null && getExpandableListItem().getChildItemList() != null) {
            if (getExpandableListItem().isExpanded()) {
                collapseView();
            } else {
                expandView();
            }

        }
    }

    @Override
    public void onExpansionToggled(boolean expanded) {
        /*float start, target;
        if (expanded) {
            mExpand.setText("收起");
            start = 0f;
            target = 90f;
        } else {
            mExpand.setText("展开");
            target = 0f;
            start = 90f;
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mArrow, View.ROTATION, start, target);
        objectAnimator.setDuration(300);
        objectAnimator.start();*/

    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_school_contacts_dividedbyclass;
    }

    @Override
    public void onBindViews(View root) {
        mName = (TextView) root.findViewById(R.id.tv_name);


        root.setOnClickListener(this);
    }

    @Override
    public void onSetViews() {
    }

    @Override
    public void onUpdateViews(Object model, int position) {
        super.onUpdateViews(model, position);
        onSetViews();
        SchoolContactsListBean.ResultsBean.GradeClsssListBean.ClsssTeacherListBean
                clsssTeacherListBean = (SchoolContactsListBean.ResultsBean.GradeClsssListBean
                .ClsssTeacherListBean) model;
        mName.setText(clsssTeacherListBean.getName());
        ExpandableListItem expandableListItem = (ExpandableListItem) model;

        List<?> childItemList = expandableListItem.getChildItemList();
        if (childItemList != null && !childItemList.isEmpty()) {
            //  mArrow.setVisibility(View.VISIBLE);

        }


    }
}
