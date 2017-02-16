// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.onlinehandle.onlinehandlelessonnotes;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class LessonNotesDetailFragment$$ViewBinder<T extends LessonNotesDetailFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131624618, "field 'tvLessonNotesDetailTeachername'");
    target.tvLessonNotesDetailTeachername = finder.castView(view, 2131624618, "field 'tvLessonNotesDetailTeachername'");
    view = finder.findRequiredView(source, 2131624619, "field 'tvLessonNotesDetailSubject'");
    target.tvLessonNotesDetailSubject = finder.castView(view, 2131624619, "field 'tvLessonNotesDetailSubject'");
    view = finder.findRequiredView(source, 2131624620, "field 'tvLessonNotesDetailLessonname'");
    target.tvLessonNotesDetailLessonname = finder.castView(view, 2131624620, "field 'tvLessonNotesDetailLessonname'");
    view = finder.findRequiredView(source, 2131624621, "field 'tvLessonNotesDetailLessontype'");
    target.tvLessonNotesDetailLessontype = finder.castView(view, 2131624621, "field 'tvLessonNotesDetailLessontype'");
    view = finder.findRequiredView(source, 2131624622, "field 'tvLessonNotesDetailLessonclass'");
    target.tvLessonNotesDetailLessonclass = finder.castView(view, 2131624622, "field 'tvLessonNotesDetailLessonclass'");
    view = finder.findRequiredView(source, 2131624623, "field 'tvLessonNotesDetailLessontime'");
    target.tvLessonNotesDetailLessontime = finder.castView(view, 2131624623, "field 'tvLessonNotesDetailLessontime'");
    view = finder.findRequiredView(source, 2131624624, "field 'tvLessonNotesDetailLessonrecord'");
    target.tvLessonNotesDetailLessonrecord = finder.castView(view, 2131624624, "field 'tvLessonNotesDetailLessonrecord'");
    view = finder.findRequiredView(source, 2131624625, "field 'tvLessonNotesDetailLessonanalysis'");
    target.tvLessonNotesDetailLessonanalysis = finder.castView(view, 2131624625, "field 'tvLessonNotesDetailLessonanalysis'");
    view = finder.findRequiredView(source, 2131624626, "field 'tvLessonNotesDetailCommittime'");
    target.tvLessonNotesDetailCommittime = finder.castView(view, 2131624626, "field 'tvLessonNotesDetailCommittime'");
    view = finder.findRequiredView(source, 2131624627, "field 'tvLessonNotesDetailBrowsecount'");
    target.tvLessonNotesDetailBrowsecount = finder.castView(view, 2131624627, "field 'tvLessonNotesDetailBrowsecount'");
    view = finder.findRequiredView(source, 2131624628, "field 'tvLesssonNotesDetailBrowsename'");
    target.tvLesssonNotesDetailBrowsename = finder.castView(view, 2131624628, "field 'tvLesssonNotesDetailBrowsename'");
    view = finder.findRequiredView(source, 2131624629, "field 'tvLessonNotesDetailCommentcount'");
    target.tvLessonNotesDetailCommentcount = finder.castView(view, 2131624629, "field 'tvLessonNotesDetailCommentcount'");
    view = finder.findRequiredView(source, 2131624630, "field 'tvLesssonNotesDetailCommentname'");
    target.tvLesssonNotesDetailCommentname = finder.castView(view, 2131624630, "field 'tvLesssonNotesDetailCommentname'");
    view = finder.findRequiredView(source, 2131624631, "field 'llLessonNotesDetailComentcontainer'");
    target.llLessonNotesDetailComentcontainer = finder.castView(view, 2131624631, "field 'llLessonNotesDetailComentcontainer'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends LessonNotesDetailFragment> implements Unbinder {
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
      target.tvLessonNotesDetailTeachername = null;
      target.tvLessonNotesDetailSubject = null;
      target.tvLessonNotesDetailLessonname = null;
      target.tvLessonNotesDetailLessontype = null;
      target.tvLessonNotesDetailLessonclass = null;
      target.tvLessonNotesDetailLessontime = null;
      target.tvLessonNotesDetailLessonrecord = null;
      target.tvLessonNotesDetailLessonanalysis = null;
      target.tvLessonNotesDetailCommittime = null;
      target.tvLessonNotesDetailBrowsecount = null;
      target.tvLesssonNotesDetailBrowsename = null;
      target.tvLessonNotesDetailCommentcount = null;
      target.tvLesssonNotesDetailCommentname = null;
      target.llLessonNotesDetailComentcontainer = null;
    }
  }
}
