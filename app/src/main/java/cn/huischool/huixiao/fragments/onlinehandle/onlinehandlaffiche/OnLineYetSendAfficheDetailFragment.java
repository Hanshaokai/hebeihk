package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlaffiche;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.common.widget.widgetofbindtagview.TagAdapter;
import cn.huischool.huixiao.bean.ReceivedAfficheDetailBean;
import cn.huischool.huixiao.common.fragment.PreviewFragment;
import cn.huischool.huixiao.common.utils.FrameworkUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.widget.widgetofbindtagview.TagFlowLayout;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.achieve.DataAchieve;

/**
 * Created by ${han} on 2016/6/6.
 */
public class OnLineYetSendAfficheDetailFragment extends BaseFragment {
    private TextView tv_AfficheDeatail_title;
    private TextView tv_AfficheDeatail_content;
    private TextView tv__AfficheDeatail_receiname;
    private TextView tv__AfficheDeatail_receitime;
    private TextView tv_AfficheDeatail_attach;
    private Toolbar toolbar_AfficheDeatail;
    private AppCompatActivity mActivity;
    private ReceivedAfficheDetailBean.ResultsBean elements;
    private View view;
    private NestedScrollView nestscroll_AfficheDeatail;

    private String[] personListOfHasNoteRead = null;
    private String[] phoneListOfHasNoteRead = null;
    private TagFlowLayout tag_AfficheDeatail_personofphone;
    private String id;

    @Override
    public View initView(LayoutInflater inflater) {
        mActivity = (AppCompatActivity) baseFragmentActivity;
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getString("id");

        }

        view = inflater.inflate(R.layout.fragment_online_affiche_detail, null, false);
        tv_AfficheDeatail_title = (TextView) view.findViewById(R.id.tv_AfficheDeatail_title);
        tv_AfficheDeatail_content = (TextView) view.findViewById(R.id.tv_AfficheDeatail_Content);
        tv_AfficheDeatail_attach = (TextView) view.findViewById(R.id.tv_AfficheDeatail_attach);
        tv__AfficheDeatail_receiname = (TextView) view.findViewById(R.id.tv__AfficheDeatail_receiname);
        tv__AfficheDeatail_receitime = (TextView) view.findViewById(R.id.tv__AfficheDeatail_receitime);
        toolbar_AfficheDeatail = (Toolbar) view.findViewById(R.id.toolbar_AfficheDeatail);
        nestscroll_AfficheDeatail = (NestedScrollView) view.findViewById(R.id
                .nestscroll_AfficheDeatail);
        tag_AfficheDeatail_personofphone =
                (TagFlowLayout) view.findViewById(R.id
                        .tag_AfficheDeatail_personofphone);
        nestscroll_AfficheDeatail.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);//不设置 导致不起作用

        initToolBar(toolbar_AfficheDeatail, true, "公告详情", -1,true);
        if (elements == null) {
            loadeAfficheDetailData();
        } else {
            showDetailData();
        }

    }

    private void loadeAfficheDetailData() {

        showProgressDialog("正在加载...");
        DataAchieve.ReceivedAfficheDetail(new DataAchieve.SuccessCallBack() {
            @Override
            public void handle(int code, Object object) {

                if (code != 1000) {
                    dismissProgressDialog();
                    return;
                }

                elements = ((ReceivedAfficheDetailBean) object).getResults();


                showDetailData();
                dismissProgressDialog();

            }
        }, id);


    }

    private void showDetailData() {

        if (elements.getAfficheFileName() != null && !TextUtils.isEmpty(elements
                .getAfficheFileName())) {
            tv_AfficheDeatail_attach.setText(elements.getAfficheFileName());
            tv_AfficheDeatail_attach.setTextColor(Color.BLUE);
            tv_AfficheDeatail_attach.setOnClickListener(this);
        } else {
            tv_AfficheDeatail_attach.setText("无附件");
            tv_AfficheDeatail_attach.setTextColor(Color.GRAY);
            //tv_AfficheDeatail_attach.setClickable(false);
        }
        tv_AfficheDeatail_content.setText(elements.getContent());
        tv_AfficheDeatail_title.setText(elements.getTitle());
        tv__AfficheDeatail_receiname.setText(elements.getSenderName());
        tv__AfficheDeatail_receitime.setText(elements.getCreateTime());
        int count = elements.getWeiduList().size();
        personListOfHasNoteRead = new String[count];
        phoneListOfHasNoteRead = new String[count];
        for (int i = 0; i < count; i++) {
            personListOfHasNoteRead[i] = elements.getWeiduList().get(i).getRealName();
            phoneListOfHasNoteRead[i] = elements.getWeiduList().get(i).getPhone();
        }


        setAdapter();

        nestscroll_AfficheDeatail.setVisibility(View.VISIBLE);
    }

    private void setAdapter() {


        tag_AfficheDeatail_personofphone.setAdapter(new TagAdapter(personListOfHasNoteRead) {
            @Override
            public View getView(ViewGroup parent, int position, Object o) {
                TextView tv = (TextView)
                        mActivity.getLayoutInflater().inflate
                                (R.layout.tag_item_tv,
                                        parent, false);
                LogUtil.d((String) o);
                tv.setText((String) o);
                tv.setTextColor(Color.GRAY);
                return tv;
            }

            @Override
            public void onUnSelect(ViewGroup parent, View view, int position) {
                super.onUnSelect(parent, view, position);
                view.setBackgroundColor(Color.GRAY);
            }

            @Override
            public void onSelect(ViewGroup parent, View view, int position) {
                super.onSelect(parent, view, position);
                view.setBackgroundColor(Color.GREEN);
                FrameworkUtils.callPersonToPhonePage(mActivity, phoneListOfHasNoteRead[position]);
            }
        });


    }

    public static BaseFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putSerializable("id", id);
        OnLineYetSendAfficheDetailFragment fragment = new OnLineYetSendAfficheDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.notifi_actions, menu);
        super.onCreateOptionsMenu(menu, inflater);
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


            case R.id.tv_AfficheDeatail_attach:

                addFragment(new PreviewFragment().newInstance("http://139.196.234" +
                        ".4:8080/dcsUserCenter/checkUrl.do?k=39696006&url=" + elements.getHtmlFileUrl()));


        }

    }
}
