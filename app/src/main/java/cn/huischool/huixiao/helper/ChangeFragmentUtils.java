package cn.huischool.huixiao.helper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.FrameLayout;

import cn.huischool.huixiao.R;
import cn.huischool.huixiao.common.utils.LogUtil;

/**
 * Created by ${han} on 2016/5/18.
 */
public class ChangeFragmentUtils {
    public static void changeFragment(FragmentChangeHelper helper, FragmentManager
            fragmentManager, int id) {

        if (helper != null) {
            FragmentTransaction tran = fragmentManager.beginTransaction();

            Fragment targetFragment = helper.getTargetFragment();

            if (targetFragment != null) {

                //检查是否附带参数
                Bundle args = helper.getArgs();
                if (args != null) {
                    targetFragment.setArguments(args);
                }

                //检查是否添加到回退栈
                String targetFragmentTag = helper.getTargetFragmentTag();
                if (targetFragmentTag != null) {
                    tran.addToBackStack(targetFragmentTag);
                }

                //检查是否要删除回退栈里对应的Fragment
                String[] removeFragmentTag = helper.getRemoveFragmentTag();
                if (removeFragmentTag != null) {
                    for (String s : removeFragmentTag) {
                        tran.remove(fragmentManager.findFragmentByTag(s));
                    }
                }

                //检查是否清空回退栈
                if (helper.isClearAllBackStack()) {
                    fragmentManager.popBackStack(
                            null,
                            FragmentManager.POP_BACK_STACK_INCLUSIVE
                    );
                }

                tran.replace(id, targetFragment);


                tran.commit();

                Log.d("tag", "MainActivtiy提交了fragment");

            } else { //如果没有目标Fragment，代表需要返回到栈中的指定Fragment
                String backToFragmentTag = helper.getBackToFragmentTag();

                if (backToFragmentTag != null) {
                    LogUtil.d("返回到"+backToFragmentTag);
                    fragmentManager.popBackStackImmediate(
                            backToFragmentTag,
                            FragmentManager.POP_BACK_STACK_INCLUSIVE
                    );
                }
            }
        }
    }
}
