// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ContactsFragment$$ViewBinder<T extends ContactsFragment> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131624096, "field 'appbarClude'");
    target.appbarClude = finder.castView(view, 2131624096, "field 'appbarClude'");
    view = finder.findRequiredView(source, 2131624389, "field 'rbtContactsDivideBygrade'");
    target.rbtContactsDivideBygrade = finder.castView(view, 2131624389, "field 'rbtContactsDivideBygrade'");
    view = finder.findRequiredView(source, 2131624390, "field 'rbtContactsDivideBysubject'");
    target.rbtContactsDivideBysubject = finder.castView(view, 2131624390, "field 'rbtContactsDivideBysubject'");
    view = finder.findRequiredView(source, 2131624392, "field 'flContactsFragcontainer'");
    target.flContactsFragcontainer = finder.castView(view, 2131624392, "field 'flContactsFragcontainer'");
    view = finder.findRequiredView(source, 2131624388, "field 'rgpContactsDivideContainer'");
    target.rgpContactsDivideContainer = finder.castView(view, 2131624388, "field 'rgpContactsDivideContainer'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ContactsFragment> implements Unbinder {
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
      target.appbarClude = null;
      target.rbtContactsDivideBygrade = null;
      target.rbtContactsDivideBysubject = null;
      target.flContactsFragcontainer = null;
      target.rgpContactsDivideContainer = null;
    }
  }
}
