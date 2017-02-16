package cn.huischool.huixiao.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rey.material.widget.ImageButton;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.activitys.home.MainActivity;
import cn.huischool.huixiao.activitys.mine.FileManageActivity;
import cn.huischool.huixiao.activitys.mine.MineCountDetailActivity;
import cn.huischool.huixiao.activitys.mine.MineFeedBackActivity;
import cn.huischool.huixiao.activitys.mine.MineSettingActivity;
import cn.huischool.huixiao.activitys.mine.changeinforacticitys.SelectPicActivity;
import cn.huischool.huixiao.common.utils.LoadBitmapUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.BaseFragment;
import cn.huischool.huixiao.framework.base.CustomApplication;


public class MineFragment extends BaseFragment {

    @BindView(R.id.appbar_clude)
    AppBarLayout appbar_clude;
    @BindView(R.id.imagbtn_action_clude)
    ImageButton imagbtn_action_clude;
    @BindView(R.id.toolbar_clude)
    Toolbar toolbar_clude;
    @BindView(R.id.tv_title_clude)
    TextView tv_title_clude;
    @BindView(R.id.ll_mine_home_source_ofdownloade)
    TextView llMineHomeSourceOfdownloade;
    private Unbinder unbinder;
    private MainActivity myActivity;
    private TextView tv_mine_home_nickname;
    private TextView ll_mine_home_feedmsg, ll_mine_home_count, ll_mine_home_setting;
    private ImageView iv_mine_home_headimg;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = (MainActivity) baseFragmentActivity;
        View view = inflater.inflate(R.layout.fragment_mine_home, null, false);
        unbinder = ButterKnife.bind(MineFragment.this, view);
        iv_mine_home_headimg = (ImageView) view.findViewById(R.id.iv_mine_home_headimg);
        tv_mine_home_nickname = (TextView) view.findViewById(R.id.tv_mine_home_nickname);
        ll_mine_home_feedmsg = (TextView) view.findViewById(R.id.ll_mine_home_feedmsg);
        ll_mine_home_count = (TextView) view.findViewById(R.id.ll_mine_home_count);
        ll_mine_home_setting = (TextView) view.findViewById(R.id.ll_mine_home_setting);
        return view;

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        setHasOptionsMenu(true);//不设置 导致不起作用
        initToolBar(toolbar_clude, false, "我的",-1,true);
        setMineLisenter();
        showMineData();
    }

    private void showMineData() {

        tv_mine_home_nickname.setText(CustomApplication.userInfor.getName());
        LoadBitmapUtils.LoadHeadImagview(myActivity, CustomApplication.userInfor.getImgUrl(), iv_mine_home_headimg);

    }


    private void setMineLisenter() {
        ll_mine_home_feedmsg.setOnClickListener(this);
        ll_mine_home_count.setOnClickListener(this);
        ll_mine_home_setting.setOnClickListener(this);
        iv_mine_home_headimg.setOnClickListener(this);
        llMineHomeSourceOfdownloade.setOnClickListener(this);

    }


    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {

            case R.id.ll_mine_home_feedmsg:


                Intent intent_feed = new Intent(myActivity, MineFeedBackActivity.class);
                startActivity(intent_feed);
                break;

            case R.id.ll_mine_home_count:

                Intent intent_home_count = new Intent(myActivity, MineCountDetailActivity.class);
                startActivity(intent_home_count);

                break;
            case R.id.ll_mine_home_setting:

                Intent intent_home_setting = new Intent(myActivity, MineSettingActivity.class);
                startActivity(intent_home_setting);

                break;

            case R.id.iv_mine_home_headimg:
                Intent intent_home_headimg = new Intent(myActivity, SelectPicActivity.class);
                startActivityForResult(intent_home_headimg, 1);
                break;
            case R.id.ll_mine_home_source_ofdownloade:

                Intent intent_home_file = new Intent(myActivity, FileManageActivity.class);
                startActivity(intent_home_file);


        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        LogUtil.d(resultCode + "返回了数据");
        if (resultCode != myActivity.RESULT_OK) {
            return;
        }
        if (requestCode == 1) {
            byte[] bytes = data.getByteArrayExtra("imgBytes");
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            iv_mine_home_headimg.setImageBitmap(bitmap);
            // String name = data.getStringExtra(Constants.IMGNAME);
            String path = data.getStringExtra("imgpath");
            LogUtil.d("获得头像路径" + path);
            if (TextUtils.isEmpty(path)) {
                File avaterFile = new File(path);


                // headImg_civ.setBackground(new BitmapDrawable(bitmap));

                // 写回调 让我的名片头像也变
                // uploadImg(path);
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
