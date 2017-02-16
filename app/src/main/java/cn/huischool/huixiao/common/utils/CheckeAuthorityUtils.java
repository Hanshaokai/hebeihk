package cn.huischool.huixiao.common.utils;

import java.util.List;

import cn.huischool.huixiao.bean.LoginBean;
import cn.huischool.huixiao.framework.base.CustomApplication;

/**
 * Created by ${han} on 2016/6/2.
 */
public class CheckeAuthorityUtils {

    public static Boolean isAuthority(String ss) {

        List<LoginBean.ResultsBean.PurviewsBean> list = CustomApplication.userInfor.getPurviews();
        int count = list.size();
        Boolean is = false;
        for (int i = 0; i < count; i++) {
            if (list.get(i).getId().equals(ss)) {
                is = true;
            }
        }


        return is;

    }


}
