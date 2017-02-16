package cn.huischool.huixiao.fragments.mine;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.mine.MineFeedBackActivity;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.ToolDateTime;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/7/14.
 */
public class MineFeedBackFragment extends BaseFragment {

    private TextView tv_title_clude;
    private ImageView imagbtn_action_clude;
    private EditText et_mine_feedback_content;
    private Toolbar toolbar_clude;
    private AppCompatActivity myActivity;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity =  baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_mine_feedback, null, false);
        tv_title_clude = (TextView) view.findViewById(R.id.tv_title_clude);
        imagbtn_action_clude = (ImageView) view.findViewById(R.id.imagbtn_action_clude);
        toolbar_clude = (Toolbar) view.findViewById(R.id.toolbar_clude);
        et_mine_feedback_content = (EditText) view.findViewById(R.id.et_mine_feedback_content);

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_clude,true,"我的反馈",R.drawable.ic_done,true);
        imagbtn_action_clude.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                LogUtil.d("点击了返回");
                removeFragment();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onClickEvent(View view) {

        switch (view.getId()) {

            case R.id.imagbtn_action_clude:

                toSendFeedBack();
                break;

        }


    }

    private void toSendFeedBack() {

        String feedtime = ToolDateTime.formatDateTime(System.currentTimeMillis());
        String content = et_mine_feedback_content.getText().toString();

        if (TextUtils.isEmpty(content)) {
            Toast.makeText(getActivity(),"请描述您的问题或建议",Toast.LENGTH_SHORT).show();
            return;
        }
        showProgressDialog("正在提交");
        DataAchieve.toSubmitFeedback(new DataAchieve.SuccessCallBack() {
                                         @Override
                                         public void handle(int code, Object object) {
                                             if (code != 1000) {
                                                 dismissProgressDialog();
                                                 return;
                                             }
                                             Toast.makeText(getActivity(),"提交成功",Toast.LENGTH_SHORT).show();
                                             dismissProgressDialog();
                                         }
                                     }, CustomApplication.userInfor.getUserId(), CustomApplication.userInfor.getSchoolId(), "1",
                content, feedtime, CustomApplication.userInfor.getRealName());


    }


}
