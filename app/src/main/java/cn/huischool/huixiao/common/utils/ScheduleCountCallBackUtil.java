package cn.huischool.huixiao.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${han} on 2016/8/29.
 */
public class ScheduleCountCallBackUtil {


    private static List<ScheduleCllaBack> scheduleCllaBackList;

    public static List<ScheduleCllaBack> getIntence() {
        if (scheduleCllaBackList == null) {
            scheduleCllaBackList = new ArrayList<ScheduleCllaBack>();/*定义 回调接口类 的集合 方便集中 回调*/
        }
        return scheduleCllaBackList;
    }


    public ScheduleCllaBack scheduleCllaBack;


    public interface ScheduleCllaBack {/*定义  点击 未办事项后回调*/


        public void scheduleBack();
    }


}
