// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.contactsfragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class PersonDetailOfContactsFragment$$ViewBinder<T extends PersonDetailOfContactsFragment> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131624840, "field 'ivHeadimgPersonDetailContacts'");
    target.ivHeadimgPersonDetailContacts = finder.castView(view, 2131624840, "field 'ivHeadimgPersonDetailContacts'");
    view = finder.findRequiredView(source, 2131624841, "field 'tvRealnamePersonDetailContacts'");
    target.tvRealnamePersonDetailContacts = finder.castView(view, 2131624841, "field 'tvRealnamePersonDetailContacts'");
    view = finder.findRequiredView(source, 2131624842, "field 'tvTelPersonDetailContacts'");
    target.tvTelPersonDetailContacts = finder.castView(view, 2131624842, "field 'tvTelPersonDetailContacts'");
    view = finder.findRequiredView(source, 2131624843, "field 'tvDutyTxt'");
    target.tvDutyTxt = finder.castView(view, 2131624843, "field 'tvDutyTxt'");
    view = finder.findRequiredView(source, 2131624844, "field 'tvDutyPersonDetailContacts'");
    target.tvDutyPersonDetailContacts = finder.castView(view, 2131624844, "field 'tvDutyPersonDetailContacts'");
    view = finder.findRequiredView(source, 2131624845, "field 'tvLine1'");
    target.tvLine1 = finder.castView(view, 2131624845, "field 'tvLine1'");
    view = finder.findRequiredView(source, 2131624846, "field 'tvEmailPersonDetailContacts'");
    target.tvEmailPersonDetailContacts = finder.castView(view, 2131624846, "field 'tvEmailPersonDetailContacts'");
    view = finder.findRequiredView(source, 2131624847, "field 'tvEmailTxt'");
    target.tvEmailTxt = finder.castView(view, 2131624847, "field 'tvEmailTxt'");
    view = finder.findRequiredView(source, 2131624848, "field 'btnTotelPersonDetailContacts'");
    target.btnTotelPersonDetailContacts = finder.castView(view, 2131624848, "field 'btnTotelPersonDetailContacts'");
    view = finder.findRequiredView(source, 2131624849, "field 'btnShortMessagePersonDetailContacts'");
    target.btnShortMessagePersonDetailContacts = finder.castView(view, 2131624849, "field 'btnShortMessagePersonDetailContacts'");
    view = finder.findRequiredView(source, 2131624850, "field 'btnSendMessagePersonDetailContacts'");
    target.btnSendMessagePersonDetailContacts = finder.castView(view, 2131624850, "field 'btnSendMessagePersonDetailContacts'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends PersonDetailOfContactsFragment> implements Unbinder {
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
      target.ivHeadimgPersonDetailContacts = null;
      target.tvRealnamePersonDetailContacts = null;
      target.tvTelPersonDetailContacts = null;
      target.tvDutyTxt = null;
      target.tvDutyPersonDetailContacts = null;
      target.tvLine1 = null;
      target.tvEmailPersonDetailContacts = null;
      target.tvEmailTxt = null;
      target.btnTotelPersonDetailContacts = null;
      target.btnShortMessagePersonDetailContacts = null;
      target.btnSendMessagePersonDetailContacts = null;
    }
  }
}
