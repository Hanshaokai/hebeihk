// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.onlinehandle.onlineapproval;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class OnLineInformApprovalDetailFragment$$ViewBinder<T extends OnLineInformApprovalDetailFragment> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131624605, "field 'tvInformapprovalDeatailSender'");
    target.tvInformapprovalDeatailSender = finder.castView(view, 2131624605, "field 'tvInformapprovalDeatailSender'");
    view = finder.findRequiredView(source, 2131624606, "field 'tvInformapprovalDeatailApprovalType'");
    target.tvInformapprovalDeatailApprovalType = finder.castView(view, 2131624606, "field 'tvInformapprovalDeatailApprovalType'");
    view = finder.findRequiredView(source, 2131624607, "field 'tvInformapprovalDeatailSendtime'");
    target.tvInformapprovalDeatailSendtime = finder.castView(view, 2131624607, "field 'tvInformapprovalDeatailSendtime'");
    view = finder.findRequiredView(source, 2131624608, "field 'tvInformapprovalDeatailContent'");
    target.tvInformapprovalDeatailContent = finder.castView(view, 2131624608, "field 'tvInformapprovalDeatailContent'");
    view = finder.findRequiredView(source, 2131624610, "field 'tvInformapprovalDeatailAttach'");
    target.tvInformapprovalDeatailAttach = finder.castView(view, 2131624610, "field 'tvInformapprovalDeatailAttach'");
    view = finder.findRequiredView(source, 2131624613, "field 'tvInformapprovalDetailWhoInform'");
    target.tvInformapprovalDetailWhoInform = finder.castView(view, 2131624613, "field 'tvInformapprovalDetailWhoInform'");
    view = finder.findRequiredView(source, 2131624616, "field 'llInformapprovalDetailCommentainer'");
    target.llInformapprovalDetailCommentainer = finder.castView(view, 2131624616, "field 'llInformapprovalDetailCommentainer'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends OnLineInformApprovalDetailFragment> implements Unbinder {
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
      target.tvInformapprovalDeatailSender = null;
      target.tvInformapprovalDeatailApprovalType = null;
      target.tvInformapprovalDeatailSendtime = null;
      target.tvInformapprovalDeatailContent = null;
      target.tvInformapprovalDeatailAttach = null;
      target.tvInformapprovalDetailWhoInform = null;
      target.llInformapprovalDetailCommentainer = null;
    }
  }
}
