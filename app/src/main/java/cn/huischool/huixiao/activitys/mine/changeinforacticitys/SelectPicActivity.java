package cn.huischool.huixiao.activitys.mine.changeinforacticitys;

import android.os.Bundle;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.mine.SelectPicFragment;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/7/19.
 */
public class SelectPicActivity extends BaseActivity {
    @Override
    protected int getFragmentContentId() {
        return R.id.fl_mine_infor_change_img_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {

        setContentView(R.layout.activity_mine_infor_change_pic_container);

    }

    @Override
    public void dealLogicBeforeInitView() {
        addFragment(new SelectPicFragment());
    }

    @Override
    public void initView() {

    }

    @Override
    public void dealLogicAfterInitView() {

    }

    @Override
    public void onClickEvent(View view) {

    }
}
