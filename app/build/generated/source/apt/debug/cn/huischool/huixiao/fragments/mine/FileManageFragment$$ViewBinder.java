// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.mine;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class FileManageFragment$$ViewBinder<T extends FileManageFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131624098, "field 'tv_title_clude'");
    target.tv_title_clude = finder.castView(view, 2131624098, "field 'tv_title_clude'");
    view = finder.findRequiredView(source, 2131624402, "field 'toolbarFileManage'");
    target.toolbarFileManage = finder.castView(view, 2131624402, "field 'toolbarFileManage'");
    view = finder.findRequiredView(source, 2131624403, "field 'tabFileManage'");
    target.tabFileManage = finder.castView(view, 2131624403, "field 'tabFileManage'");
    view = finder.findRequiredView(source, 2131624401, "field 'appbarFileManage'");
    target.appbarFileManage = finder.castView(view, 2131624401, "field 'appbarFileManage'");
    view = finder.findRequiredView(source, 2131624404, "field 'vpagerFileManage'");
    target.vpagerFileManage = finder.castView(view, 2131624404, "field 'vpagerFileManage'");
    view = finder.findRequiredView(source, 2131624400, "field 'coorFileManage'");
    target.coorFileManage = finder.castView(view, 2131624400, "field 'coorFileManage'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends FileManageFragment> implements Unbinder {
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
      target.tv_title_clude = null;
      target.toolbarFileManage = null;
      target.tabFileManage = null;
      target.appbarFileManage = null;
      target.vpagerFileManage = null;
      target.coorFileManage = null;
    }
  }
}
