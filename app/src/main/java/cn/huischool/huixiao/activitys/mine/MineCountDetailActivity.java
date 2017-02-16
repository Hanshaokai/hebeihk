package cn.huischool.huixiao.activitys.mine;

import android.os.Bundle;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.mine.MineCountDetailFragment;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/7/12.
 */
public class MineCountDetailActivity extends BaseActivity {
    @Override
    protected int getFragmentContentId() {


        return R.id.mine_count_detail_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {

        setContentView(R.layout.activity_mine_count_detail_container);
    }

    @Override
    public void dealLogicBeforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void dealLogicAfterInitView() {


        addFragment(new MineCountDetailFragment());

    }

    @Override
    public void onClickEvent(View view) {

    }
}
