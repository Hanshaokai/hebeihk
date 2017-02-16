package cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview;

import android.util.SparseArray;

/**
 * Created by ${han} on 2016/10/11.
 */

public class AdapterItemUtil {
    private SparseArray<Object> typeSArr = new SparseArray<>();

    /**
     *  type item的类型
     *             SparseArray类似hashmap
     * @return 通过object类型的type来得到int类型的type
     */
    public AdapterItemUtil() {

        typeSArr.clear();
    }

    public int getIntType(Object type) {
        int index = typeSArr.indexOfValue(type);//遍历返回指引 string用==比较会返回-1
        if (index == -1) {
            index = typeSArr.size();
            // 如果没用这个type，就存入这个type
            typeSArr.put(index, type);
        }
        return index;
    }
}
