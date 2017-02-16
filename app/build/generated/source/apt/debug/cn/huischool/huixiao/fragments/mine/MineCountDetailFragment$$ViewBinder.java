// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.mine;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MineCountDetailFragment$$ViewBinder<T extends MineCountDetailFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131624096, "field 'appbar_clude'");
    target.appbar_clude = finder.castView(view, 2131624096, "field 'appbar_clude'");
    view = finder.findRequiredView(source, 2131624387, "field 'imagbtn_action_clude'");
    target.imagbtn_action_clude = finder.castView(view, 2131624387, "field 'imagbtn_action_clude'");
    view = finder.findRequiredView(source, 2131624097, "field 'toolbar_clude'");
    target.toolbar_clude = finder.castView(view, 2131624097, "field 'toolbar_clude'");
    view = finder.findRequiredView(source, 2131624098, "field 'tv_title_clude'");
    target.tv_title_clude = finder.castView(view, 2131624098, "field 'tv_title_clude'");
    view = finder.findRequiredView(source, 2131624533, "field 'tv_qq_mine'");
    target.tv_qq_mine = finder.castView(view, 2131624533, "field 'tv_qq_mine'");
    view = finder.findRequiredView(source, 2131624535, "field 'tv_job_mine'");
    target.tv_job_mine = finder.castView(view, 2131624535, "field 'tv_job_mine'");
    view = finder.findRequiredView(source, 2131624531, "field 'tv_mail_mine'");
    target.tv_mail_mine = finder.castView(view, 2131624531, "field 'tv_mail_mine'");
    view = finder.findRequiredView(source, 2131624527, "field 'tv_number_mine'");
    target.tv_number_mine = finder.castView(view, 2131624527, "field 'tv_number_mine'");
    view = finder.findRequiredView(source, 2131624539, "field 'tv_partjob_mine'");
    target.tv_partjob_mine = finder.castView(view, 2131624539, "field 'tv_partjob_mine'");
    view = finder.findRequiredView(source, 2131624525, "field 'tv_sex_mine'");
    target.tv_sex_mine = finder.castView(view, 2131624525, "field 'tv_sex_mine'");
    view = finder.findRequiredView(source, 2131624537, "field 'tv_sub_mine'");
    target.tv_sub_mine = finder.castView(view, 2131624537, "field 'tv_sub_mine'");
    view = finder.findRequiredView(source, 2131624529, "field 'tv_tel_mine'");
    target.tv_tel_mine = finder.castView(view, 2131624529, "field 'tv_tel_mine'");
    view = finder.findRequiredView(source, 2131624524, "field 'tv_realName_mine'");
    target.tv_realName_mine = finder.castView(view, 2131624524, "field 'tv_realName_mine'");
    view = finder.findRequiredView(source, 2131624540, "field 'btn_chaninfo_mine'");
    target.btn_chaninfo_mine = finder.castView(view, 2131624540, "field 'btn_chaninfo_mine'");
    view = finder.findRequiredView(source, 2131624541, "field 'btn_chanpas_mine'");
    target.btn_chanpas_mine = finder.castView(view, 2131624541, "field 'btn_chanpas_mine'");
    view = finder.findRequiredView(source, 2131624542, "field 'btn_quit_mine'");
    target.btn_quit_mine = finder.castView(view, 2131624542, "field 'btn_quit_mine'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends MineCountDetailFragment> implements Unbinder {
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
      target.appbar_clude = null;
      target.imagbtn_action_clude = null;
      target.toolbar_clude = null;
      target.tv_title_clude = null;
      target.tv_qq_mine = null;
      target.tv_job_mine = null;
      target.tv_mail_mine = null;
      target.tv_number_mine = null;
      target.tv_partjob_mine = null;
      target.tv_sex_mine = null;
      target.tv_sub_mine = null;
      target.tv_tel_mine = null;
      target.tv_realName_mine = null;
      target.btn_chaninfo_mine = null;
      target.btn_chanpas_mine = null;
      target.btn_quit_mine = null;
    }
  }
}
