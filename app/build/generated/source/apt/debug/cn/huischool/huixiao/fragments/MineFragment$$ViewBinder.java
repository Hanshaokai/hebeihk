// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MineFragment$$ViewBinder<T extends MineFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131624096, "field 'appbar_clude'");
    target.appbar_clude = finder.castView(view, 2131624096, "field 'appbar_clude'");
    view = finder.findRequiredView(source, 2131624387, "field 'imagbtn_action_clude'");
    target.imagbtn_action_clude = finder.castView(view, 2131624387, "field 'imagbtn_action_clude'");
    view = finder.findRequiredView(source, 2131624097, "field 'toolbar_clude'");
    target.toolbar_clude = finder.castView(view, 2131624097, "field 'toolbar_clude'");
    view = finder.findRequiredView(source, 2131624098, "field 'tv_title_clude'");
    target.tv_title_clude = finder.castView(view, 2131624098, "field 'tv_title_clude'");
    view = finder.findRequiredView(source, 2131624521, "field 'llMineHomeSourceOfdownloade'");
    target.llMineHomeSourceOfdownloade = finder.castView(view, 2131624521, "field 'llMineHomeSourceOfdownloade'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends MineFragment> implements Unbinder {
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
      target.appbar_clude = null;
      target.imagbtn_action_clude = null;
      target.toolbar_clude = null;
      target.tv_title_clude = null;
      target.llMineHomeSourceOfdownloade = null;
    }
  }
}
