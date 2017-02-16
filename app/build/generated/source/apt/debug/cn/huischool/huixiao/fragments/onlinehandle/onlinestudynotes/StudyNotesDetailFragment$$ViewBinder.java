// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.onlinehandle.onlinestudynotes;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class StudyNotesDetailFragment$$ViewBinder<T extends StudyNotesDetailFragment> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131624678, "field 'tvStudyNotesDetailCreattime'");
    target.tvStudyNotesDetailCreattime = finder.castView(view, 2131624678, "field 'tvStudyNotesDetailCreattime'");
    view = finder.findRequiredView(source, 2131624679, "field 'tvStudyNotesDetailCreatplace'");
    target.tvStudyNotesDetailCreatplace = finder.castView(view, 2131624679, "field 'tvStudyNotesDetailCreatplace'");
    view = finder.findRequiredView(source, 2131624680, "field 'tvStudyNotesDetailTheme'");
    target.tvStudyNotesDetailTheme = finder.castView(view, 2131624680, "field 'tvStudyNotesDetailTheme'");
    view = finder.findRequiredView(source, 2131624681, "field 'tvStudyNotesDetailContentsource'");
    target.tvStudyNotesDetailContentsource = finder.castView(view, 2131624681, "field 'tvStudyNotesDetailContentsource'");
    view = finder.findRequiredView(source, 2131624682, "field 'tvStudyNotesDetailContent'");
    target.tvStudyNotesDetailContent = finder.castView(view, 2131624682, "field 'tvStudyNotesDetailContent'");
    view = finder.findRequiredView(source, 2131624683, "field 'tvStudyNotesDetailComprehensiveIncome'");
    target.tvStudyNotesDetailComprehensiveIncome = finder.castView(view, 2131624683, "field 'tvStudyNotesDetailComprehensiveIncome'");
    view = finder.findRequiredView(source, 2131624684, "field 'tvStudyNotesDetailCommittime'");
    target.tvStudyNotesDetailCommittime = finder.castView(view, 2131624684, "field 'tvStudyNotesDetailCommittime'");
    view = finder.findRequiredView(source, 2131624685, "field 'tvStudyDetailBrowsecount'");
    target.tvStudyDetailBrowsecount = finder.castView(view, 2131624685, "field 'tvStudyDetailBrowsecount'");
    view = finder.findRequiredView(source, 2131624686, "field 'tvStudyNotesDetailBrowsename'");
    target.tvStudyNotesDetailBrowsename = finder.castView(view, 2131624686, "field 'tvStudyNotesDetailBrowsename'");
    view = finder.findRequiredView(source, 2131624687, "field 'tvStudyNotesDetailCommentcount'");
    target.tvStudyNotesDetailCommentcount = finder.castView(view, 2131624687, "field 'tvStudyNotesDetailCommentcount'");
    view = finder.findRequiredView(source, 2131624688, "field 'tvStudyNotesDetailCommentname'");
    target.tvStudyNotesDetailCommentname = finder.castView(view, 2131624688, "field 'tvStudyNotesDetailCommentname'");
    view = finder.findRequiredView(source, 2131624689, "field 'llStudyNotesDetailComentcontainer'");
    target.llStudyNotesDetailComentcontainer = finder.castView(view, 2131624689, "field 'llStudyNotesDetailComentcontainer'");
    view = finder.findRequiredView(source, 2131624676, "field 'nestscrollStudyNotesDetail'");
    target.nestscrollStudyNotesDetail = finder.castView(view, 2131624676, "field 'nestscrollStudyNotesDetail'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends StudyNotesDetailFragment> implements Unbinder {
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
      target.tvStudyNotesDetailCreattime = null;
      target.tvStudyNotesDetailCreatplace = null;
      target.tvStudyNotesDetailTheme = null;
      target.tvStudyNotesDetailContentsource = null;
      target.tvStudyNotesDetailContent = null;
      target.tvStudyNotesDetailComprehensiveIncome = null;
      target.tvStudyNotesDetailCommittime = null;
      target.tvStudyDetailBrowsecount = null;
      target.tvStudyNotesDetailBrowsename = null;
      target.tvStudyNotesDetailCommentcount = null;
      target.tvStudyNotesDetailCommentname = null;
      target.llStudyNotesDetailComentcontainer = null;
      target.nestscrollStudyNotesDetail = null;
    }
  }
}
