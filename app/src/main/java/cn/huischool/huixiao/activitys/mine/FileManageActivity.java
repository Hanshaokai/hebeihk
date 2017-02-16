package cn.huischool.huixiao.activitys.mine;

import android.os.Bundle;
import android.view.View;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.mine.FileManageFragment;
import cn.huischool.huixiao.framework.BaseActivity;
import cn.huischool.huixiao.framework.BaseFragment;

/**
 * Created by ${han} on 2016/9/6.
 */
public class FileManageActivity extends BaseActivity {
    @Override
    protected int getFragmentContentId() {
        return R.id.mine_filemanage_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_mine_filemanage_container);
    }

    @Override
    public void dealLogicBeforeInitView() {


    }

    @Override
    public void initView() {

    }

    @Override
    public void dealLogicAfterInitView() {
        addFragment(new FileManageFragment());
    }

    @Override
    public void onClickEvent(View view) {

    }
}
