// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.mine.filemanage;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class FileLoadCompletedFragment$$ViewBinder<T extends FileLoadCompletedFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131624395, "field 'rbtnGrmmarItem'");
    target.rbtnGrmmarItem = finder.castView(view, 2131624395, "field 'rbtnGrmmarItem'");
    view = finder.findRequiredView(source, 2131624396, "field 'rbtnCoursewareItem'");
    target.rbtnCoursewareItem = finder.castView(view, 2131624396, "field 'rbtnCoursewareItem'");
    view = finder.findRequiredView(source, 2131624394, "field 'rgItemContainer'");
    target.rgItemContainer = finder.castView(view, 2131624394, "field 'rgItemContainer'");
    view = finder.findRequiredView(source, 2131624397, "field 'indicator'");
    target.indicator = finder.castView(view, 2131624397, "field 'indicator'");
    view = finder.findRequiredView(source, 2131624393, "field 'scrollRgcontainerDownloadecomplete'");
    target.scrollRgcontainerDownloadecomplete = finder.castView(view, 2131624393, "field 'scrollRgcontainerDownloadecomplete'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends FileLoadCompletedFragment> implements Unbinder {
    private T target;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.rbtnGrmmarItem = null;
      target.rbtnCoursewareItem = null;
      target.rgItemContainer = null;
      target.indicator = null;
      target.scrollRgcontainerDownloadecomplete = null;
    }
  }
}
