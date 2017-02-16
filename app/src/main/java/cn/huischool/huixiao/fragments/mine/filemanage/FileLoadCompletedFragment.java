package cn.huischool.huixiao.fragments.mine.filemanage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.huischool.huixiao.AppStoreConfig;
import cn.huischool.huixiao.R;
import cn.huischool.huixiao.adapters.mine.TextFileOfDownLoadeAdapter;
import cn.huischool.huixiao.bean.loadeFileBean;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.TooIntent;
import cn.huischool.huixiao.common.utils.ToolDateTime;
import cn.huischool.huixiao.common.utils.ToolFile;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.DividerItemDecoration;
import cn.huischool.huixiao.common.widget.widgetofbindrecylcerview.OnRecyclerItemClickListener;
import cn.huischool.huixiao.framework.BaseFragment;

/**
 * Created by ${han} on 2016/9/6.
 */
public class FileLoadCompletedFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.rbtn_grmmar_item)
    RadioButton rbtnGrmmarItem;
    @BindView(R.id.rbtn_courseware_item)
    RadioButton rbtnCoursewareItem;
    @BindView(R.id.rg_item_container)
    RadioGroup rgItemContainer;
    @BindView(R.id.indicator)
    TextView indicator;
    @BindView(R.id.scroll_rgcontainer_downloadecomplete)
    HorizontalScrollView scrollRgcontainerDownloadecomplete;
    private RecyclerView rv_fileitem_container_downloadecomplete;
    private TextView tv_emptyview_downloadecomplete;
    private AppCompatActivity myActivity;
    private List<loadeFileBean> fileBeanList = new ArrayList<>();
    private TextFileOfDownLoadeAdapter adapter;
    private Unbinder unbinder;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;
        view = inflater.inflate(R.layout.fragment_file_loadcomplete, null, false);
        rv_fileitem_container_downloadecomplete = (RecyclerView) view.findViewById(R.id
                .rv_fileitem_container_downloadecomplete);
        tv_emptyview_downloadecomplete =
                (TextView) view.findViewById(R.id.tv_emptyview_downloadecomplete);
        tv_emptyview_downloadecomplete.setVisibility(View.GONE);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        recycletsendSetAdpater();
        rgItemContainer.setOnCheckedChangeListener(this);
        rgItemContainer.check(R.id.rbtn_grmmar_item);
        adapter = new TextFileOfDownLoadeAdapter(myActivity, fileBeanList);
        rv_fileitem_container_downloadecomplete.setAdapter(adapter);
    }


    @Override
    protected void onClickEvent(View view) {


    }

    private void recycletsendSetAdpater() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(myActivity);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_fileitem_container_downloadecomplete.setLayoutManager(layoutManager);//这里用线性显示 类似于listview
        rv_fileitem_container_downloadecomplete.setItemAnimator(new DefaultItemAnimator());
        adapter = new TextFileOfDownLoadeAdapter(myActivity, fileBeanList);
        rv_fileitem_container_downloadecomplete.addItemDecoration(new DividerItemDecoration(myActivity,
                layoutManager
                        .getOrientation()));
        rv_fileitem_container_downloadecomplete.setAdapter(adapter);
        rv_fileitem_container_downloadecomplete.addOnItemTouchListener(new OnRecyclerItemClickListener(rv_fileitem_container_downloadecomplete,
                rv_fileitem_container_downloadecomplete.getContext()) {//封装了为rescyler 封装了监听
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                File file = new File(fileBeanList.get(vh.getAdapterPosition()).getFilePath());
                if (ToolFile.getFileExtension(file).equals("ppt")) {
                    TooIntent.openPPtFile(file);
                } else if (ToolFile.getFileExtension(file).equals("doc")) {
                    TooIntent.openWordFile(file);
                }
            }

            @Override
            public void onLongClick(final RecyclerView.ViewHolder vh) {
                final AlertDialog.Builder alert = new AlertDialog
                        .Builder(myActivity);
                alert.setPositiveButton(myActivity.getResources().getText(R.string.is), new
                        DialogInterface
                                .OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if (ToolFile.deleteFile(fileBeanList.get(vh.getAdapterPosition()).getFilePath
                                        ())) {
                                    Toast.makeText(myActivity, myActivity.getResources().getText(R.string.delete_succeed), Toast
                                            .LENGTH_SHORT).show();
                                    //  adapter.notifyItemRemoved(vh.getAdapterPosition());出现重复item
                                    fileBeanList.remove(vh.getAdapterPosition());
                                    adapter.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(myActivity, myActivity.getResources().getText(R.string.delete_defeated), Toast
                                            .LENGTH_SHORT).show();
                                }
                            }
                        });
                alert.setMessage(myActivity.getResources().getText(R.string
                        .isOrNoToDeleteThisFile));
                alert.setNegativeButton(myActivity.getResources().getText(R.string.no), new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                alert.create().show();


            }
        });

    }

    public List<loadeFileBean> getGrmmarFileBeanList() {
        fileBeanList.clear();
        //得到教案课件 下载存储的文件
        File fileGrammar = new File(AppStoreConfig.MYGRAMMAR_FOLDER);
        //得到所有的文件
        if (!fileGrammar.exists()){
            fileGrammar.mkdirs();
        }
        File[] filesGrammarlist = fileGrammar.listFiles();
        if (filesGrammarlist != null) {
            int count1 = filesGrammarlist.length;
            for (int i = 0; i < count1; i++) {
                File file = filesGrammarlist[i];
                if (ToolFile.getFileExtension(file).equals("doc") || ToolFile.getFileExtension(file)
                        .equals("ppt")) {
                    loadeFileBean bean = new loadeFileBean();
                    bean.setFilePath(file.getPath());
                    bean.setFileName(file.getName());
                    bean.setFileSize(ToolFile.getFileAutoSize(file));
                    bean.setCreateTime(ToolDateTime.formatDateTime(file.lastModified()));
                    fileBeanList.add(bean);
                }
            }
        }

        return fileBeanList;
    }

    public List<loadeFileBean> getCourseWareFileBeanList() {
        fileBeanList.clear();
        File fileCourseWare = new File(AppStoreConfig.MYCOURSEWARE_FOLDER);
        if (!fileCourseWare.exists()){
            fileCourseWare.mkdirs();
        }
        File[] filesCourseWarelist = fileCourseWare.listFiles();
        if (filesCourseWarelist != null) {
            int count2 = filesCourseWarelist.length;
            for (int i = 0; i < count2; i++) {
                File file = filesCourseWarelist[i];
                if (ToolFile.getFileExtension(file).equals("doc") || ToolFile.getFileExtension(file)
                        .equals("ppt")) {
                    loadeFileBean bean = new loadeFileBean();
                    bean.setFilePath(file.getPath());
                    bean.setFileName(file.getName());
                    bean.setFileSize(ToolFile.getFileAutoSize(file));
                    bean.setCreateTime(ToolDateTime.formatDateTime(file.lastModified()));
                    fileBeanList.add(bean);
                }
            }
        }
        return fileBeanList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        // 选中的RadioButton播放动画
        ScaleAnimation sAnim = new ScaleAnimation(1, 1.1f, 1, 1.1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        sAnim.setDuration(2000);
        sAnim.setFillAfter(true);

        // 遍历所有的RadioButton
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            RadioButton radioBtn = (RadioButton) radioGroup.getChildAt(i);
            if (radioBtn.isChecked()) {
                radioBtn.startAnimation(sAnim);
            } else {
                radioBtn.clearAnimation();
            }
        }

        switch (checkedId) {
            case R.id.rbtn_grmmar_item:
                adapter.notifyDataSetChanged();
                android.widget.LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) indicator
                        .getLayoutParams();
                params.leftMargin = 0;
                indicator.setLayoutParams(params);
                tv_emptyview_downloadecomplete.setVisibility(View.INVISIBLE);
                getGrmmarFileBeanList();
                if (CollectionUtils.isListNull(fileBeanList)) {
                    tv_emptyview_downloadecomplete.setVisibility(View.VISIBLE);
                    tv_emptyview_downloadecomplete.setText("您还未下载教案");
                }

                break;

            case R.id.rbtn_courseware_item:
                android.widget.LinearLayout.LayoutParams params2 = (android.widget.LinearLayout
                        .LayoutParams) indicator
                        .getLayoutParams();
                params2.leftMargin = params2.width;
                LogUtil.d(params2.leftMargin+"距左边");
                indicator.setLayoutParams(params2);
                getCourseWareFileBeanList();
                tv_emptyview_downloadecomplete.setVisibility(View.INVISIBLE);
                if (CollectionUtils.isListNull(fileBeanList)) {
                    tv_emptyview_downloadecomplete.setVisibility(View.VISIBLE);
                    tv_emptyview_downloadecomplete.setText("您还未下载课件");
                }

                adapter.notifyDataSetChanged();

                break;
        }


    }


}
