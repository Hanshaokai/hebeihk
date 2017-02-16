package cn.huischool.huixiao.fragments.mine;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.mine.changeinforacticitys.ChangeCountInforActivity;
import cn.huischool.huixiao.bean.MyCountInforBean;
import cn.huischool.huixiao.common.utils.ToolRegex;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/6/12.
 */

public class MineChangeMyCountInforFragment extends BaseFragment {
    @BindView(R.id.toolbar_clude)
    Toolbar toolbar_clude;
    @BindView(R.id.tv_title_clude)
    TextView tv_title_clude;
    /*  @BindView(R.id.et_infor_partjob_)
      EditText et_infor_partjob_;
      @BindView(R.id.et_infor_position_)
      EditText et_infor_position_;

      @BindView(R.id.et_infor_sex_)
      EditText et_infor_sex_;*/
    @BindView(R.id.et_infor_qq_)
    EditText et_infor_qq_;
    @BindView(R.id.et_infor_tel_)
    EditText et_infor_tel_;
    @BindView(R.id.et_infor_mail_)
    EditText et_infor_mail_;
    @BindView(R.id.btn_infor_ture_)
    Button btn_infor_ture_;
    private Unbinder unbinder;
    private ChangeCountInforActivity myActivity;
    private MyCountInforBean.ResultsBean result = null;

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_mine_countinfor, null);
        myActivity = (ChangeCountInforActivity) ct;
        Bundle bundle = getArguments();
        result = (MyCountInforBean.ResultsBean) bundle.getSerializable("ResultsBean");
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_clude,true,"修改资料",-1,true);
        toolbar_clude.setTitle("");
        showData();
        setListener();
    }

    private void showData() {

        if (result != null) {


           /* et_infor_position_.setText(result.getPosition());
            et_infor_partjob_.setText((String) result.getDuty());
            et_infor_sex_.setText(result.getGender());*/


            et_infor_qq_.setText(result.getQq());
            et_infor_tel_.setText(result.getPhone());
            et_infor_tel_.setSelection(result.getPhone().length());
            et_infor_mail_.setText(result.getEmail());


        }


    }

    private void setListener() {
        btn_infor_ture_.setOnClickListener(this);
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
            case R.id.btn_infor_ture_:

                changeComplete();
                break;


        }
    }

    private void changeComplete() {
       /* String position = et_infor_position_.getText().toString();
        String sex = et_infor_sex_.getText().toString();
        String partjob = et_infor_partjob_.getText().toString();*/
        String mail = et_infor_mail_.getText().toString();

        String qq = et_infor_qq_.getText().toString();

        String tel = et_infor_tel_.getText().toString();

        if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(qq) || TextUtils.isEmpty(tel)
                ) {
            Toast.makeText(myActivity, "输入不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!ToolRegex.checkEmail(mail) || !ToolRegex.checkMobile(tel)) {
            Toast.makeText(myActivity, "邮箱或手机号格式不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        DataAchieve.updateMyCountInfor(new DataAchieve.SuccessCallBack() {
                                           @Override
                                           public void handle(int code, Object object) {
                                           }
                                       }, CustomApplication.userInfor.getUserId(), CustomApplication.userInfor.getRealName(),
                tel, qq, mail);


    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
