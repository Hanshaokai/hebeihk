package cn.huischool.huixiao.activitys.mine.changeinforacticitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.bean.MyCountInforBean;
import cn.huischool.huixiao.fragments.mine.MineChangePasswordFragment;
import cn.huischool.huixiao.fragments.mine.MineChangeMyCountInforFragment;
import cn.huischool.huixiao.framework.BaseActivity;
import cn.huischool.huixiao.helper.ChangeFragmentUtils;
import cn.huischool.huixiao.helper.FragmentChangeHelper;

/**
 * Created by ${han} on 2016/6/12.
 */
public class ChangeCountInforActivity extends BaseActivity {
    private FrameLayout mine_changeinfor_container_above;
    private String type = "0";
    private MyCountInforBean.ResultsBean result = null;

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_mine_changeinfor_container);

    }

    @Override
    public void dealLogicBeforeInitView() {

        Intent intent = getIntent();
        type = intent.getStringExtra("changetype");

        if (type.equals("infor")) {
            result = (MyCountInforBean.ResultsBean) intent.getExtras().getSerializable("ResultsBean");
        }

    }

    @Override
    public void initView() {
        mine_changeinfor_container_above = (FrameLayout) findViewById(R.id.mine_changeinfor_container_above);
    }

    @Override
    public void dealLogicAfterInitView() {
        if (type.equals("infor")) {
            FragmentChangeHelper helper = new FragmentChangeHelper(new MineChangeMyCountInforFragment());
            helper.clearAllBackStack(true);
            Bundle bundle = new Bundle();
            bundle.putSerializable("ResultsBean", result);
            helper.setArguments(bundle);
            ChangeFragmentUtils.changeFragment(helper, getSupportFragmentManager(), R.id
                    .mine_changeinfor_container_above);
        }
        if (type.equals("password")){

           FragmentChangeHelper helper = new FragmentChangeHelper(new MineChangePasswordFragment());
            helper.clearAllBackStack(true);

            ChangeFragmentUtils.changeFragment(helper, getSupportFragmentManager(), R.id
                    .mine_changeinfor_container_above);


        }
    }

    @Override
    public void onClickEvent(View view) {

    }
}
