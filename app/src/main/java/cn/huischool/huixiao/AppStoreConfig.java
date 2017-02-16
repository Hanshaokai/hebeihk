package cn.huischool.huixiao;

import android.os.Environment;

import java.io.File;

import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/8/8.
 */
public class AppStoreConfig {

    public static final String Tag = "huixiao";
    //	user_type 1-家长，2-教师 3-学校管理员
    /**
     * 程序创建的文件夹的根目录
     */
    public static final String BASE_FOLDER = Environment
            .getExternalStorageDirectory()
            + File.separator
            + Tag
            + File.separator;

    /**
     * 缓存的文件夹
     */
    public static final String BASE_CACHE = BASE_FOLDER + "cache"
            + File.separator;
    /**
     * 程序视频缓存的文件夹
     */
    public static final String BASE_VIDEO_CACHE = BASE_FOLDER + "cache"
            + File.separator + "VideoCache" + File.separator;
    /**
     * 程序图片缓存的文件夹
     */
    public static final String BASE_IMG_CACHE = BASE_FOLDER + "cache"
            + File.separator + "imageCache" + File.separator;
    /**
     * 程序下载文件的文件夹
     */
    public static final String BASE_DOWNLOAD_FOLDER = BASE_FOLDER + "download"
            + File.separator;
    /*下载的教案存储文件夹
    * */
    public static final String MYGRAMMAR_FOLDER = BASE_DOWNLOAD_FOLDER + "grammar" + File
            .separator + CustomApplication.userInfor.getName() + File.separator;
    /*下载的课件存储文件夹*/
    public static final String MYCOURSEWARE_FOLDER = BASE_DOWNLOAD_FOLDER + "courseware" + File
            .separator + CustomApplication.userInfor.getName() + File.separator;
    /**
     * 程序更新的apk包的文件夹
     */
    public static final String BASE_UPDATE_APK_FOLDER = BASE_FOLDER + "update"
            + File.separator;

}
