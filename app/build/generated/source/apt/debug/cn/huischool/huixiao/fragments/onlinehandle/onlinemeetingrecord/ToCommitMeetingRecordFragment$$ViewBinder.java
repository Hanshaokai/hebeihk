// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.onlinehandle.onlinemeetingrecord;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ToCommitMeetingRecordFragment$$ViewBinder<T extends ToCommitMeetingRecordFragment> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131624466, "field 'etMyMeetingrecordTocommitMeetingrecordname'");
    target.etMyMeetingrecordTocommitMeetingrecordname = finder.castView(view, 2131624466, "field 'etMyMeetingrecordTocommitMeetingrecordname'");
    view = finder.findRequiredView(source, 2131624467, "field 'etMeetingrecordNotesTocommitCreattime'");
    target.etMeetingrecordNotesTocommitCreattime = finder.castView(view, 2131624467, "field 'etMeetingrecordNotesTocommitCreattime'");
    view = finder.findRequiredView(source, 2131624468, "field 'etMeetingrecordNotesTocommitCreatplace'");
    target.etMeetingrecordNotesTocommitCreatplace = finder.castView(view, 2131624468, "field 'etMeetingrecordNotesTocommitCreatplace'");
    view = finder.findRequiredView(source, 2131624469, "field 'etMeetingrecordNotesTocommitCompere'");
    target.etMeetingrecordNotesTocommitCompere = finder.castView(view, 2131624469, "field 'etMeetingrecordNotesTocommitCompere'");
    view = finder.findRequiredView(source, 2131624470, "field 'etMeetingrecordNotesTocommitKeynotespeaker'");
    target.etMeetingrecordNotesTocommitKeynotespeaker = finder.castView(view, 2131624470, "field 'etMeetingrecordNotesTocommitKeynotespeaker'");
    view = finder.findRequiredView(source, 2131624471, "field 'etMeetingrecordNotesTocommitSpokesman'");
    target.etMeetingrecordNotesTocommitSpokesman = finder.castView(view, 2131624471, "field 'etMeetingrecordNotesTocommitSpokesman'");
    view = finder.findRequiredView(source, 2131624472, "field 'etMeetingrecordNotesTocommitParticipants'");
    target.etMeetingrecordNotesTocommitParticipants = finder.castView(view, 2131624472, "field 'etMeetingrecordNotesTocommitParticipants'");
    view = finder.findRequiredView(source, 2131624473, "field 'etMeetingrecordNotesTocommitMeetingcontent'");
    target.etMeetingrecordNotesTocommitMeetingcontent = finder.castView(view, 2131624473, "field 'etMeetingrecordNotesTocommitMeetingcontent'");
    view = finder.findRequiredView(source, 2131624465, "field 'nestscrollMeetingrecordNotesTocommit'");
    target.nestscrollMeetingrecordNotesTocommit = finder.castView(view, 2131624465, "field 'nestscrollMeetingrecordNotesTocommit'");
    view = finder.findRequiredView(source, 2131624464, "field 'coor_commit_meetingrecord'");
    target.coor_commit_meetingrecord = finder.castView(view, 2131624464, "field 'coor_commit_meetingrecord'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ToCommitMeetingRecordFragment> implements Unbinder {
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
      target.etMyMeetingrecordTocommitMeetingrecordname = null;
      target.etMeetingrecordNotesTocommitCreattime = null;
      target.etMeetingrecordNotesTocommitCreatplace = null;
      target.etMeetingrecordNotesTocommitCompere = null;
      target.etMeetingrecordNotesTocommitKeynotespeaker = null;
      target.etMeetingrecordNotesTocommitSpokesman = null;
      target.etMeetingrecordNotesTocommitParticipants = null;
      target.etMeetingrecordNotesTocommitMeetingcontent = null;
      target.nestscrollMeetingrecordNotesTocommit = null;
      target.coor_commit_meetingrecord = null;
    }
  }
}
