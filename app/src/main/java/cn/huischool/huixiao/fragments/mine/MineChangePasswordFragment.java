package cn.huischool.huixiao.fragments.mine;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.mine.changeinforacticitys.ChangeCountInforActivity;
import cn.huischool.huixiao.common.utils.ToolRegex;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/6/13.
 */
public class MineChangePasswordFragment extends BaseFragment {

    @BindView(R.id.btn_true_mine_chanpas)
    Button btn_true_mine_chanpas;
    @BindView(R.id.et_new_mine_changepass)
    EditText et_new_mine_changepass;
    @BindView(R.id.et_new2_mine_changepass)
    EditText et_new2_mine_changepass;
    @BindView(R.id.et_old_mine_changepass)
    EditText et_old_mine_changepass;
    @BindView(R.id.tv_title_clude)
    TextView tv_title_clude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbar_clude;
    private Unbinder unbinder;
    private ChangeCountInforActivity myActivity;


    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_mine_changepass, null);
        myActivity = (ChangeCountInforActivity) ct;
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_clude,true,"修改密码",-1,true);
        et_new2_mine_changepass.setInputType(EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
        et_new_mine_changepass.setInputType(EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
        et_old_mine_changepass.setInputType(EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
        setListener();
    }

    private void setListener() {
        btn_true_mine_chanpas.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                myActivity.finish();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_true_mine_chanpas:
                toChagePassword();
                break;


        }
    }

    private void toChagePassword() {

        String newPass = et_new_mine_changepass.getText().toString();
        String newPass2 = et_new2_mine_changepass.getText().toString();
        String oldPass = et_old_mine_changepass.getText().toString();
        if (TextUtils.isEmpty(newPass) || TextUtils.isEmpty(newPass2) || TextUtils.isEmpty(oldPass)) {

            Toast.makeText(myActivity, "输入不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (ToolRegex.checkBlankSpace(newPass) || ToolRegex.checkBlankSpace(newPass2) || ToolRegex
                .checkBlankSpace(oldPass)) {
            Toast.makeText(myActivity, "不能有空格", Toast.LENGTH_SHORT).show();
            return;
        }
        if (newPass.length() > 24 || newPass2.length() > 24) {

            Toast.makeText(myActivity, "长度不符合规定", Toast.LENGTH_SHORT).show();
            return;

        }
        if (!newPass.equals(newPass2)) {

            Toast.makeText(myActivity, "新密码输入前后不一致", Toast.LENGTH_SHORT).show();
            return;

        }
        DataAchieve.updatePassword(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {

            }
        }, CustomApplication.userInfor.getUserId(), oldPass, newPass);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
