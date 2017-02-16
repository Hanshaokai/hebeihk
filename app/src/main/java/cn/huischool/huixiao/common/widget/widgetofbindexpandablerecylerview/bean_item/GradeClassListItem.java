package cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview.bean_item;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.SchoolContactsListBean;
import cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview.AbstractExpandableAdapterItem;

/**
 * Created by ${han} on 2016/10/11.
 */

public class GradeClassListItem extends AbstractExpandableAdapterItem {
    private TextView gradeName;
    private ImageView mArrow;
    private SchoolContactsListBean.ResultsBean.GradeClsssListBean
            gradeClsssListBean;

    @Override
    public void onExpansionToggled(boolean expanded) {
        /*
        点击的一个图片旋转九十度动画
        * */
        float start, target;
        if (expanded) {
            start = 0f;
            target = 90f;
        } else {
            start = 90f;
            target = 0f;
        }

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mArrow, View.ROTATION, start, target);
        objectAnimator.setDuration(300);
        objectAnimator.start();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_school_contacts_dividedbygrade;
    }

    @Override
    public void onBindViews(View root) {
/*
control item expand and unexpand
* */
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doExpandOrUnexpand();

            }
        });
        gradeName = (TextView) root.findViewById(R.id.tv_name);
        mArrow = (ImageView) root.findViewById(R.id.iv_arrow);
    }

    @Override
    public void onSetViews() {
        mArrow.setImageResource(0);
        mArrow.setImageResource(R.mipmap.arrow_down);
    }

    @Override
    public void onUpdateViews(Object model, int position) {
        super.onUpdateViews(model, position);
        onExpansionToggled(getExpandableListItem().isExpanded());
        gradeClsssListBean = (SchoolContactsListBean.ResultsBean.GradeClsssListBean) model;
        gradeName.setText(gradeClsssListBean.getName());
    }
}
