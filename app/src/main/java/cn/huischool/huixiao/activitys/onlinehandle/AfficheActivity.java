package cn.huischool.huixiao.activitys.onlinehandle;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlaffiche.OnlineHandleAfficheFragment;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/6/6.
 */
public class AfficheActivity extends BaseActivity {

    private FrameLayout online_affiche_container_above;

    @Override
    protected int getFragmentContentId() {
        return R.id.online_affiche_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_affiche_container);
    }

    @Override
    public void dealLogicBeforeInitView() {

    }

    @Override
    public void initView() {
        online_affiche_container_above = (FrameLayout) findViewById(R.id
                .online_affiche_container_above);
    }

    @Override
    public void dealLogicAfterInitView() {
        /*FragmentChangeHelper helper = new FragmentChangeHelper(new OnlineHandleAfficheFragment());
        helper.clearAllBackStack(true);

        ChangeFragmentUtils.changeFragment(helper, getSupportFragmentManager(), R.id.online_affiche_container_above);*/
        addFragment(new OnlineHandleAfficheFragment());
    }

    @Override
    public void onClickEvent(View view) {

    }
}
