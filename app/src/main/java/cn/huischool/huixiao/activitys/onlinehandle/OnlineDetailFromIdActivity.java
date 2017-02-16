package cn.huischool.huixiao.activitys.onlinehandle;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.fragments.onlinehandle.onlineapproval.OnLineInformApprovalDetailFragment;
import cn.huischool.huixiao.fragments.onlinehandle.onlineapproval.OnLineReceApprovalDetailFragment;
import cn.huischool.huixiao.fragments.onlinehandle.onlineapproval.OnLineYetSenApprovalDetailFragment;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlaffiche.OnLineAcceAfficheDetailFragment;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlemineteacherplan.MineGrammarDetailFragment;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlemycourseware.MineCourseWareDetailFragment;
import cn.huischool.huixiao.fragments.onlinehandle.onlinehandlenotifi.OnLineAcceNotifiDetailFragment;
import cn.huischool.huixiao.framework.BaseActivity;

/**
 * Created by ${han} on 2016/8/30.
 */
public class OnlineDetailFromIdActivity extends BaseActivity {
    private FrameLayout online_detail_container_above;
    private String noticeId;
    private String afficheId;
    private String approvalId;
    private String informApprovalId;
    private String yetSendApprovalId;
    private String grmmarYetApprovalId;
    private String courseWareYetApprovalId;

    @Override
    protected int getFragmentContentId() {
        return R.id.online_webview_container_above;
    }

    @Override
    public void setContentLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_webview_container);
    }

    @Override
    public void dealLogicBeforeInitView() {
        noticeId = getIntent().getStringExtra("noticeId");
        afficheId = getIntent().getStringExtra("afficheId");
        approvalId = getIntent().getStringExtra("approvalId");
        informApprovalId = getIntent().getStringExtra("informApprovalId");
        yetSendApprovalId = getIntent().getStringExtra("yetSendApprovalId");
        grmmarYetApprovalId = getIntent().getStringExtra("grmmarYetApprovalId");
        courseWareYetApprovalId = getIntent().getStringExtra("courseWareYetApprovalId");
    }

    @Override
    public void initView() {

        online_detail_container_above =
                (FrameLayout) findViewById(R.id
                        .online_webview_container_above);
    }

    @Override
    public void dealLogicAfterInitView() {

        if (noticeId != null) {//0

            addFragment(new OnLineAcceNotifiDetailFragment().newInstance(noticeId));
        }

        if (afficheId != null) {//1

            addFragment(new OnLineAcceAfficheDetailFragment().newInstance(afficheId));
        }
        if (approvalId != null) {//2

            addFragment(new OnLineReceApprovalDetailFragment().newInstance(approvalId));
        }
        if (informApprovalId != null) {//3

            addFragment(new OnLineInformApprovalDetailFragment().newInstance(informApprovalId));
        }

        if (yetSendApprovalId != null) {//4
            addFragment(new OnLineYetSenApprovalDetailFragment().newInstance(yetSendApprovalId));
        }

        if (grmmarYetApprovalId != null) {//5
            addFragment(new MineGrammarDetailFragment().newInstance(grmmarYetApprovalId));
        }
        if (courseWareYetApprovalId != null) {//6
            addFragment(new MineCourseWareDetailFragment().newInstance(courseWareYetApprovalId));
        }

    }

    @Override
    public void onClickEvent(View view) {

    }
}
