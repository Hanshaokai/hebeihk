package cn.huischool.huixiao.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${han} on 2016/6/23.
 */
public class OpinionCallBackUtil {


    private static List<OpinionCllaBack> opinionCllaBackList;

    public static List<OpinionCllaBack> getIntence() {
        if (opinionCllaBackList == null) {
            opinionCllaBackList = new ArrayList<OpinionCllaBack>();/*定义 回调接口类 的集合 方便集中 回调*/
        }
        return opinionCllaBackList;
    }


    public OpinionCllaBack opinionCllaBack;


    public interface OpinionCllaBack {/*定义  审批后的回调  回调  评语  时间  同意否  list位置*/


        public void opinionBack(String op, int position, String comment, String approvalTime);
    }

   /* public OpinionCllaBack getOpinionCllaBack() {
        return opinionCllaBack;
    }

    public void setOpinionCllaBack(
            OpinionCllaBack opinionCllaBack) {
        this.opinionCllaBack = opinionCllaBack;
    }*/


}
