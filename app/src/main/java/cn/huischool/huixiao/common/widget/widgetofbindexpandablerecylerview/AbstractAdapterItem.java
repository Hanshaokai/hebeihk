package cn.huischool.huixiao.common.widget.widgetofbindexpandablerecylerview;

import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * Created by ${han} on 2016/10/11.
 */

public abstract class AbstractAdapterItem<T extends Object> {

    /**
     * @return item`s layoutId
     */
    @LayoutRes
    public abstract int getLayoutResId();

    /**
     * init views
     *
     * @param root item root view
     */
    public abstract void onBindViews(final View root);

    /**
     * refresh view state
     */
    public abstract void onSetViews();

    /**
     * set data to view
     *
     * @param model    model
     * @param position item index
     */
    public abstract void onUpdateViews(T model, int position);

}

