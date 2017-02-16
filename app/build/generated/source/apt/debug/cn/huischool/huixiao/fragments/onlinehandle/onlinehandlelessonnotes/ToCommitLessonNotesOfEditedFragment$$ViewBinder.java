// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlelessonnotes;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ToCommitLessonNotesOfEditedFragment$$ViewBinder<T extends ToCommitLessonNotesOfEditedFragment> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131624453, "field 'etTocommitLessonNotesLessontime'");
    target.etTocommitLessonNotesLessontime = finder.castView(view, 2131624453, "field 'etTocommitLessonNotesLessontime'");
    view = finder.findRequiredView(source, 2131624454, "field 'etTocommitLessonNotesLessontimePart'");
    target.etTocommitLessonNotesLessontimePart = finder.castView(view, 2131624454, "field 'etTocommitLessonNotesLessontimePart'");
    view = finder.findRequiredView(source, 2131624455, "field 'etTocommitLessonNotesTeachername'");
    target.etTocommitLessonNotesTeachername = finder.castView(view, 2131624455, "field 'etTocommitLessonNotesTeachername'");
    view = finder.findRequiredView(source, 2131624456, "field 'etTocommitLessonNotesLessontype'");
    target.etTocommitLessonNotesLessontype = finder.castView(view, 2131624456, "field 'etTocommitLessonNotesLessontype'");
    view = finder.findRequiredView(source, 2131624457, "field 'spTocommitLessonNotesLessonname'");
    target.spTocommitLessonNotesLessonname = finder.castView(view, 2131624457, "field 'spTocommitLessonNotesLessonname'");
    view = finder.findRequiredView(source, 2131624459, "field 'spTocommitLessonNotesLessongrade'");
    target.spTocommitLessonNotesLessongrade = finder.castView(view, 2131624459, "field 'spTocommitLessonNotesLessongrade'");
    view = finder.findRequiredView(source, 2131624460, "field 'spTocommitLessonNotesLessonclass'");
    target.spTocommitLessonNotesLessonclass = finder.castView(view, 2131624460, "field 'spTocommitLessonNotesLessonclass'");
    view = finder.findRequiredView(source, 2131624461, "field 'spTocommitLessonNotesSubject'");
    target.spTocommitLessonNotesSubject = finder.castView(view, 2131624461, "field 'spTocommitLessonNotesSubject'");
    view = finder.findRequiredView(source, 2131624462, "field 'etTocommitLessonNotesLessonrecord'");
    target.etTocommitLessonNotesLessonrecord = finder.castView(view, 2131624462, "field 'etTocommitLessonNotesLessonrecord'");
    view = finder.findRequiredView(source, 2131624463, "field 'etTocommitLessonNotesLessonanalysis'");
    target.etTocommitLessonNotesLessonanalysis = finder.castView(view, 2131624463, "field 'etTocommitLessonNotesLessonanalysis'");
    view = finder.findRequiredView(source, 2131624452, "field 'nestscrollTocommitLessonNotesParent'");
    target.nestscrollTocommitLessonNotesParent = finder.castView(view, 2131624452, "field 'nestscrollTocommitLessonNotesParent'");
    view = finder.findRequiredView(source, 2131624458, "field 'btntocommitlessonnotesselectinfor'");
    target.btntocommitlessonnotesselectinfor = finder.castView(view, 2131624458, "field 'btntocommitlessonnotesselectinfor'");
    view = finder.findRequiredView(source, 2131624451, "field 'coor_lesson_notes'");
    target.coor_lesson_notes = finder.castView(view, 2131624451, "field 'coor_lesson_notes'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ToCommitLessonNotesOfEditedFragment> implements Unbinder {
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
      target.etTocommitLessonNotesLessontime = null;
      target.etTocommitLessonNotesLessontimePart = null;
      target.etTocommitLessonNotesTeachername = null;
      target.etTocommitLessonNotesLessontype = null;
      target.spTocommitLessonNotesLessonname = null;
      target.spTocommitLessonNotesLessongrade = null;
      target.spTocommitLessonNotesLessonclass = null;
      target.spTocommitLessonNotesSubject = null;
      target.etTocommitLessonNotesLessonrecord = null;
      target.etTocommitLessonNotesLessonanalysis = null;
      target.nestscrollTocommitLessonNotesParent = null;
      target.btntocommitlessonnotesselectinfor = null;
      target.coor_lesson_notes = null;
    }
  }
}
