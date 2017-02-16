// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.adapters.onlinehandle;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class CommitNUmberListAdapter$ContentViewHolder$$ViewBinder<T extends CommitNUmberListAdapter.ContentViewHolder> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131624804, "field 'ivItemImg'");
    target.ivItemImg = finder.castView(view, 2131624804, "field 'ivItemImg'");
    view = finder.findRequiredView(source, 2131624805, "field 'tvItemName'");
    target.tvItemName = finder.castView(view, 2131624805, "field 'tvItemName'");
    view = finder.findRequiredView(source, 2131624806, "field 'tvGrammar'");
    target.tvGrammar = finder.castView(view, 2131624806, "field 'tvGrammar'");
    view = finder.findRequiredView(source, 2131624807, "field 'tvLessonlearned'");
    target.tvLessonlearned = finder.castView(view, 2131624807, "field 'tvLessonlearned'");
    view = finder.findRequiredView(source, 2131624808, "field 'tvMeetingrecord'");
    target.tvMeetingrecord = finder.castView(view, 2131624808, "field 'tvMeetingrecord'");
    view = finder.findRequiredView(source, 2131624809, "field 'tvCourseware'");
    target.tvCourseware = finder.castView(view, 2131624809, "field 'tvCourseware'");
    view = finder.findRequiredView(source, 2131624810, "field 'tvStudynotes'");
    target.tvStudynotes = finder.castView(view, 2131624810, "field 'tvStudynotes'");
    view = finder.findRequiredView(source, 2131624811, "field 'tvResearchactivityy'");
    target.tvResearchactivityy = finder.castView(view, 2131624811, "field 'tvResearchactivityy'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends CommitNUmberListAdapter.ContentViewHolder> implements Unbinder {
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
      target.ivItemImg = null;
      target.tvItemName = null;
      target.tvGrammar = null;
      target.tvLessonlearned = null;
      target.tvMeetingrecord = null;
      target.tvCourseware = null;
      target.tvStudynotes = null;
      target.tvResearchactivityy = null;
    }
  }
}
