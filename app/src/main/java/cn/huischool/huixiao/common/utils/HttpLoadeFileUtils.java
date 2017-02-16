package cn.huischool.huixiao.common.utils;

import android.widget.TextView;

import com.lzy.okhttpserver.download.DownloadInfo;
import com.lzy.okhttpserver.download.DownloadManager;
import com.lzy.okhttpserver.download.DownloadService;
import com.lzy.okhttpserver.listener.DownloadListener;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.request.GetRequest;

import java.io.File;

import cn.huischool.huixiao.AppStoreConfig;
import cn.huischool.huixiao.BuildConfig;
import cn.huischool.huixiao.framework.base.CustomApplication;
import cn.huischool.huixiao.framework.network.ServerInterfaceDefinition;

/**
 * Created by ${han} on 2016/9/18.
 */

public class HttpLoadeFileUtils {

    public static void downLoadFile(final TextView tvShowInfor, String keyOfFileId, final String
            fileName, String fileType, String targedPath) {
        tvShowInfor.setEnabled(false);
        if (DownloadService.getDownloadManager().getDownloadInfo(keyOfFileId) != null) {
            try {
                LogUtil.d("===" + keyOfFileId
                        + "keyOfFileId" + DownloadService.getDownloadManager().getDownloadInfo(keyOfFileId).getTaskKey());
                TooIntent.openWordFile(new File(DownloadService.getDownloadManager()
                        .getDownloadInfo(keyOfFileId).getTargetPath()));
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else {
            GetRequest request = OkHttpUtils.get(BuildConfig.URL + ServerInterfaceDefinition
                    .OPTDOWNLOADFILE.getOpt())
                    .params("schoolId", CustomApplication.userInfor.getSchoolId())
                    .params("filedir", fileType)
                    .params("fileId", keyOfFileId);
            if (!new File(targedPath).exists()) {
                new File(targedPath).mkdirs();
            }
            if (!new File(targedPath).exists()) {
                new File(targedPath).mkdirs();
            }
            DownloadService.getDownloadManager().setTargetFolder(targedPath);
            DownloadService.getDownloadManager().addTask(fileName, keyOfFileId, request,
                    new DownloadListener() {
                        @Override
                        public void onProgress(DownloadInfo downloadInfo) {
                            tvShowInfor.setText((Math.round(downloadInfo.getProgress() *
                                    10000) * 1.0f / 100) + "%");
                        }

                        @Override
                        public void onFinish(DownloadInfo downloadInfo) {
                            ToolToast.showShortTimeMsg(fileName + "下载完成");
                            tvShowInfor.setEnabled(true);
                            tvShowInfor.setText("打开");
                            LogUtil.d(downloadInfo.getTaskKey() + "===" + downloadInfo
                                    .getTargetPath());
                        }

                        @Override
                        public void onError(DownloadInfo downloadInfo, String errorMsg, Exception e) {
                            LogUtil.d(errorMsg.toString());
                            LogUtil.d(e.getMessage());
                            tvShowInfor.setEnabled(true);
                        }
                    });
           /* OkHttpUtils.get(BuildConfig.URL + ServerInterfaceDefinition
                    .OPTDOWNLOADFILE.getOpt())
                    .tag(keyOfFileId)
                    .params("schoolId", CustomApplication.userInfor.getSchoolId())
                    .params("filedir", "lesson")
                    .params("fileId", keyOfFileId)
                    .execute(new FileCallback(AppStoreConfig.MYGRAMMAR_FOLDER, result
                            .getFileName//这里设置文件名和文件路径
                            ()) {
                        @Override
                        public void onSuccess(File file, Call call, Response response) {
                            ToolToast.showShortTimeMsg(result.getFileName() + "下载完成");
                            tv_my_grammardetail_downloadfile.setEnabled(true);
                            tv_my_grammardetail_downloadfile.setText("打开");
                            LogUtil.d(file.getPath() + "===" + response.toString());
                        }
                        @Override
                        public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                            tv_my_grammardetail_downloadfile.setText((Math.round(progress * 10000) * 1.0f / 100) + "%");
                        }
                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            LogUtil.d(response.toString());
                            LogUtil.d(e.getMessage());
                            tv_my_grammardetail_downloadfile.setEnabled(true);
                        }
                    });*/


        }
    }


    public static void setDownLoade(TextView tvShowInfor, String keyOfFileId) {//展示详情 前显示 是否已下载成功
        // 已下载则显示打开 未下载 则可以点击下载
        DownloadInfo downloadInfo = DownloadService.getDownloadManager().getDownloadInfo(keyOfFileId);

        if (downloadInfo != null) {
            LogUtil.d("================================================");
            try {
                LogUtil.d(downloadInfo.getDownloadLength() + "");
                LogUtil.d(downloadInfo.getDownloadRequest().toString() + "");
                LogUtil.d(downloadInfo.getState() + "");
                LogUtil.d(downloadInfo.getRequest().toString() + "");
                LogUtil.d(downloadInfo.getFileName() + "");
                LogUtil.d(downloadInfo.getTargetPath() + "");
                LogUtil.d(downloadInfo.getProgress() + "");
                LogUtil.d(downloadInfo.getTaskKey() + "");
                LogUtil.d(downloadInfo.getUrl() + "");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //以文件id 作为标记
            if (downloadInfo.getState() == DownloadManager.FINISH) {
                tvShowInfor.setText("打开");
            } else {
                tvShowInfor.setText("已在下载队列");
                tvShowInfor.setEnabled(false);
            }
        } else {
            tvShowInfor.setText("下载");
        }

    }

}
