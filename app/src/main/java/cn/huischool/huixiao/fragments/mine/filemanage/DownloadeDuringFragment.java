package cn.huischool.huixiao.fragments.mine.filemanage;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okhttpserver.download.DownloadInfo;
import com.lzy.okhttpserver.download.DownloadManager;
import com.lzy.okhttpserver.download.DownloadService;
import com.lzy.okhttpserver.listener.DownloadListener;
import com.lzy.okhttpserver.task.ExecutorWithListener;

import java.io.File;
import java.util.List;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.common.utils.CollectionUtils;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.common.utils.TooIntent;
import cn.huischool.huixiao.common.utils.ToolFile;
import cn.huischool.huixiao.framework.BaseFragment;

/**
 * Created by ${han} on 2016/9/6.
 */
public class DownloadeDuringFragment extends BaseFragment implements ExecutorWithListener
        .OnAllTaskEndListener {

    private AppCompatActivity myActivity;
    private List<DownloadInfo> allTask;
    private DownloadManager downloadManager;
    private ListView lv_loadefile_during;
    private MyAdapter adapter;
    private TextView tv_loade_during_stopall;
    private TextView tv_loade_during_startall;
    private TextView tv_loade_during_removeall;
    private TextView tv_emptyview_loadefile_during;

    @Override
    public View initView(LayoutInflater inflater) {
        myActivity = baseFragmentActivity;

        view = inflater.inflate(R.layout.fragment_loadedfile_during, null, false);
        lv_loadefile_during = (ListView) view.findViewById(R.id.lv_loadefile_during);
        tv_loade_during_stopall = (TextView) view.findViewById(R.id.tv_loade_during_stopall);
        tv_loade_during_startall = (TextView) view.findViewById(R.id.tv_loade_during_startall);
        tv_loade_during_removeall = (TextView) view.findViewById(R.id.tv_loade_during_removeall);
        tv_emptyview_loadefile_during = (TextView) view.findViewById(R.id.tv_emptyview_loadefile_during);

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if (DownloadService.isServiceRunning(myActivity)) {
            downloadManager = DownloadService.getDownloadManager();
            allTask = downloadManager.getAllTask();
            LogUtil.d("任务数量：" + allTask.size());
            if (CollectionUtils.isListNull(allTask)) {
                tv_emptyview_loadefile_during.setVisibility(View.VISIBLE);
            }
            downloadManager.getThreadPool().getExecutor().addOnAllTaskEndListener(this);
            adapter = new MyAdapter();
            lv_loadefile_during.setAdapter(adapter);
            tv_loade_during_stopall.setOnClickListener(this);
            tv_loade_during_startall.setOnClickListener(this);
            tv_loade_during_removeall.setOnClickListener(this);
        } else {
            allTask = DownloadService.getDownloadManager().getAllTask();
            LogUtil.d("任务数量：" + allTask.size());
            if (CollectionUtils.isListNull(allTask)) {
                tv_emptyview_loadefile_during.setVisibility(View.VISIBLE);
            }


        }
    }

    @Override
    protected void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.tv_loade_during_removeall:
                downloadManager.removeAllTask();
                allTask.clear();
                adapter.notifyDataSetChanged();  //移除的时候需要调用
                break;
            case R.id.tv_loade_during_stopall:
                downloadManager.pauseAllTask();
                break;
           /* case R.id.stopAll:
                downloadManager.stopAllTask();
                break;*/
            case R.id.tv_loade_during_startall:
                downloadManager.startAllTask();
                break;
        }

    }

    public class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return allTask == null ? 0 : allTask.size();
        }

        @Override
        public DownloadInfo getItem(int i) {
            return allTask.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int position, View convertview, ViewGroup viewGroup) {

            final DownloadInfo downloadInfo = getItem(position);
            ViewHolder holder;
            if (convertview == null) {
                convertview = view.inflate(myActivity, R.layout.adapter_loadefile_during_item, null);
                holder = new ViewHolder(convertview);
                convertview.setTag(holder);
            } else {
                holder = (ViewHolder) convertview.getTag();
            }
            holder.refresh(downloadInfo);
            //这里放非进度更新
            holder.tv_during_filename_item.setText(downloadInfo.getFileName());
            holder.tv_during_downlode_item.setOnClickListener(holder);
            holder.tv_during_remove_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    downloadManager.removeTask(downloadInfo.getTaskKey());
                    allTask.remove(downloadInfo);
                    adapter.notifyDataSetChanged();

                }
            });

            DownloadListener downloadListener = new MyDownloadListener();
            downloadListener.setUserTag(holder);
            downloadInfo.setListener(downloadListener);
            return convertview;
        }
    }

    private class ViewHolder implements View.OnClickListener {
        private DownloadInfo downloadInfo;
        private final TextView tv_during_complete_percent_item;
        private final TextView tv_during_filename_item;
        private final TextView tv_during_filesize_item;
        private final TextView tv_during_downlode_item;
        private final TextView tv_during_filestate_item;
        private final TextView tv_during_remove_item;

        public ViewHolder(View convertview) {
            tv_during_complete_percent_item = (TextView) convertview.findViewById(R.id
                    .tv_during_complete_percent_item);
            tv_during_filename_item = (TextView) convertview.findViewById(R.id
                    .tv_during_filename_item);
            tv_during_filesize_item = (TextView) convertview.findViewById(R.id
                    .tv_during_filesize_item);

            tv_during_filestate_item = (TextView) convertview.findViewById(R.id.tv_during_filestate_item);
            tv_during_downlode_item = (TextView) convertview.findViewById(R.id.tv_during_downlode_item);
            tv_during_remove_item = (TextView) convertview.findViewById(R.id.tv_during_remove_item);
        }

        public void refresh(DownloadInfo downloadInfo) {
            this.downloadInfo = downloadInfo;
            refresh();
        }

        //实时的更新进度ui 图片的加载不放这里

        private void refresh() {

            String downloadLength = Formatter.formatFileSize(myActivity, downloadInfo.getDownloadLength());
            String totalLength = Formatter.formatFileSize(myActivity, downloadInfo.getTotalLength());
            tv_during_filesize_item.setText(downloadLength + "/" + totalLength);

            if (downloadInfo.getState() == DownloadManager.NONE) {
                //停止暂停 服务对服务来说
                tv_during_filestate_item.setText("停止");
                tv_during_downlode_item.setText("下载");
            } else if (downloadInfo.getState() == DownloadManager.PAUSE) {
                tv_during_filestate_item.setText("暂停中");
                tv_during_downlode_item.setText("继续");
            } else if (downloadInfo.getState() == DownloadManager.ERROR) {
                tv_during_filestate_item.setText("下载出错");
                tv_during_downlode_item.setText("出错");

            } else if (downloadInfo.getState() == DownloadManager.WAITING) {
                tv_during_filestate_item.setText("等待中");
                tv_during_downlode_item.setText("等待");

            } else if (downloadInfo.getState() == DownloadManager.FINISH) {
                tv_during_filestate_item.setText("下载完成");
                tv_during_downlode_item.setText("打开");
            } else if (downloadInfo.getState() == DownloadManager.DOWNLOADING) {
                String networkSpeed = Formatter.formatFileSize(myActivity, downloadInfo.getNetworkSpeed());
                tv_during_filestate_item.setText(networkSpeed + "/s");
                tv_during_downlode_item.setText("暂停");
            }


            tv_during_complete_percent_item.setText((Math.round(downloadInfo.getProgress() * 10000) * 1.0f / 100) + "%");

        }

        @Override
        public void onClick(View view) {

            if (view.getId() == tv_during_downlode_item.getId()) {
                switch (downloadInfo.getState()) {
                    case DownloadManager.PAUSE:
                    case DownloadManager.NONE:
                    case DownloadManager.ERROR:
                        downloadManager.addTask(downloadInfo.getFileName(),
                                downloadInfo.getTaskKey(), downloadInfo
                                        .getRequest(),
                                downloadInfo.getListener());
                        break;
                    case DownloadManager.DOWNLOADING:
                        //下载的状态下 点击了 继续
                        downloadManager.pauseTask(downloadInfo.getTaskKey());
                        break;
                    case DownloadManager.FINISH:
                        //这里添加 打开文件的步骤
                        File file = new File(downloadInfo.getTargetPath());

                        if (ToolFile.getFileExtension(file).equals("ppt")) {
                            TooIntent.openPPtFile(file);
                        } else if (ToolFile.getFileExtension(file).equals("doc")) {
                            TooIntent.openWordFile(file);
                        }
                        break;
                }
                refresh();
            } else if (view.getId() == tv_during_remove_item.getId()) {

            }
        }


    }

    @Override
    public void onAllTaskEnd() {

        for (DownloadInfo downloadInfo : allTask) {
            if (downloadInfo.getState() != DownloadManager.FINISH) {
                Toast.makeText(myActivity, "部分下载未完成", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Toast.makeText(myActivity, "所有下载任务完成", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //记得移除，否者会回调多次
        if (DownloadService.isServiceRunning(myActivity))
            try {
                downloadManager.getThreadPool().getExecutor().removeOnAllTaskEndListener(this);
            } catch (NullPointerException e) {
            }
    }


    private class MyDownloadListener extends DownloadListener {

        @Override
        public void onProgress(DownloadInfo downloadInfo) {
            if (getUserTag() == null)
                return;
            ViewHolder holder = (ViewHolder) getUserTag();
            //接受回调
            holder.refresh();  //这里不能使用传递进来的 DownloadInfo，否者会出现条目错乱的问题
        }

        @Override
        public void onFinish(DownloadInfo downloadInfo) {
            Toast.makeText(myActivity, "下载完成:" + downloadInfo.getTargetPath(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(DownloadInfo downloadInfo, String errorMsg, Exception e) {
            if (errorMsg != null)
                Toast.makeText(myActivity, errorMsg, Toast.LENGTH_SHORT).show();
        }
    }


}
