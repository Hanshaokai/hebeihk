// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.onlinehandle.onlinestudynotes;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ToCommitStudyNotesFragment$$ViewBinder<T extends ToCommitStudyNotesFragment> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131624476, "field 'etStudyNotesTocommitCreattime'");
    target.etStudyNotesTocommitCreattime = finder.castView(view, 2131624476, "field 'etStudyNotesTocommitCreattime'");
    view = finder.findRequiredView(source, 2131624477, "field 'etStudyNotesTocommitCreatplace'");
    target.etStudyNotesTocommitCreatplace = finder.castView(view, 2131624477, "field 'etStudyNotesTocommitCreatplace'");
    view = finder.findRequiredView(source, 2131624478, "field 'etStudyNotesTocommitTheme'");
    target.etStudyNotesTocommitTheme = finder.castView(view, 2131624478, "field 'etStudyNotesTocommitTheme'");
    view = finder.findRequiredView(source, 2131624479, "field 'etStudyNotesTocommitContentsource'");
    target.etStudyNotesTocommitContentsource = finder.castView(view, 2131624479, "field 'etStudyNotesTocommitContentsource'");
    view = finder.findRequiredView(source, 2131624480, "field 'etStudyNotesTocommitContent'");
    target.etStudyNotesTocommitContent = finder.castView(view, 2131624480, "field 'etStudyNotesTocommitContent'");
    view = finder.findRequiredView(source, 2131624481, "field 'etStudyNotesTocommitComprehensiveIncome'");
    target.etStudyNotesTocommitComprehensiveIncome = finder.castView(view, 2131624481, "field 'etStudyNotesTocommitComprehensiveIncome'");
    view = finder.findRequiredView(source, 2131624475, "field 'nestscrollStudyNotesTocommit'");
    target.nestscrollStudyNotesTocommit = finder.castView(view, 2131624475, "field 'nestscrollStudyNotesTocommit'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ToCommitStudyNotesFragment> implements Unbinder {
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
      target.etStudyNotesTocommitCreattime = null;
      target.etStudyNotesTocommitCreatplace = null;
      target.etStudyNotesTocommitTheme = null;
      target.etStudyNotesTocommitContentsource = null;
      target.etStudyNotesTocommitContent = null;
      target.etStudyNotesTocommitComprehensiveIncome = null;
      target.nestscrollStudyNotesTocommit = null;
    }
  }
}
