package cn.huischool.huixiao.common.utils;

import java.util.Collection;

/**
 * Created by ${han} on 2016/6/23.
 */
public class CollectionUtils {
    /**
     * 判断集合是否为空
     *
     * @param collection
     * @return
     */
    public static boolean isListNull(Collection collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
