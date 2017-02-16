// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.onlinehandle.onlineresearchtable;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class OnLineResearchTableFragment$$ViewBinder<T extends OnLineResearchTableFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131624098, "field 'tvTitleClude'");
    target.tvTitleClude = finder.castView(view, 2131624098, "field 'tvTitleClude'");
    view = finder.findRequiredView(source, 2131624387, "field 'imagbtnActionClude'");
    target.imagbtnActionClude = finder.castView(view, 2131624387, "field 'imagbtnActionClude'");
    view = finder.findRequiredView(source, 2131624097, "field 'toolbarClude'");
    target.toolbarClude = finder.castView(view, 2131624097, "field 'toolbarClude'");
    view = finder.findRequiredView(source, 2131624714, "field 'tagflFragmentResearchTableSubject'");
    target.tagflFragmentResearchTableSubject = finder.castView(view, 2131624714, "field 'tagflFragmentResearchTableSubject'");
    view = finder.findRequiredView(source, 2131624715, "field 'tagflFragmentResearchTableClass'");
    target.tagflFragmentResearchTableClass = finder.castView(view, 2131624715, "field 'tagflFragmentResearchTableClass'");
    view = finder.findRequiredView(source, 2131624096, "field 'appbarClude'");
    target.appbarClude = finder.castView(view, 2131624096, "field 'appbarClude'");
    view = finder.findRequiredView(source, 2131624717, "field 'rlvFragmentResearchTableItemcontainer'");
    target.rlvFragmentResearchTableItemcontainer = finder.castView(view, 2131624717, "field 'rlvFragmentResearchTableItemcontainer'");
    view = finder.findRequiredView(source, 2131624716, "field 'swipFragmentResearchTable'");
    target.swipFragmentResearchTable = finder.castView(view, 2131624716, "field 'swipFragmentResearchTable'");
    view = finder.findRequiredView(source, 2131624713, "field 'coolResearchTableFragment'");
    target.coolResearchTableFragment = finder.castView(view, 2131624713, "field 'coolResearchTableFragment'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends OnLineResearchTableFragment> implements Unbinder {
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
      target.tvTitleClude = null;
      target.imagbtnActionClude = null;
      target.toolbarClude = null;
      target.tagflFragmentResearchTableSubject = null;
      target.tagflFragmentResearchTableClass = null;
      target.appbarClude = null;
      target.rlvFragmentResearchTableItemcontainer = null;
      target.swipFragmentResearchTable = null;
      target.coolResearchTableFragment = null;
    }
  }
}
