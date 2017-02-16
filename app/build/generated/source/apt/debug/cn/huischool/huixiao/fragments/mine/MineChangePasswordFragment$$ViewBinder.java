// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.mine;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MineChangePasswordFragment$$ViewBinder<T extends MineChangePasswordFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131624504, "field 'btn_true_mine_chanpas'");
    target.btn_true_mine_chanpas = finder.castView(view, 2131624504, "field 'btn_true_mine_chanpas'");
    view = finder.findRequiredView(source, 2131624501, "field 'et_new_mine_changepass'");
    target.et_new_mine_changepass = finder.castView(view, 2131624501, "field 'et_new_mine_changepass'");
    view = finder.findRequiredView(source, 2131624503, "field 'et_new2_mine_changepass'");
    target.et_new2_mine_changepass = finder.castView(view, 2131624503, "field 'et_new2_mine_changepass'");
    view = finder.findRequiredView(source, 2131624499, "field 'et_old_mine_changepass'");
    target.et_old_mine_changepass = finder.castView(view, 2131624499, "field 'et_old_mine_changepass'");
    view = finder.findRequiredView(source, 2131624098, "field 'tv_title_clude'");
    target.tv_title_clude = finder.castView(view, 2131624098, "field 'tv_title_clude'");
    view = finder.findRequiredView(source, 2131624097, "field 'toolbar_clude'");
    target.toolbar_clude = finder.castView(view, 2131624097, "field 'toolbar_clude'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends MineChangePasswordFragment> implements Unbinder {
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
      target.btn_true_mine_chanpas = null;
      target.et_new_mine_changepass = null;
      target.et_new2_mine_changepass = null;
      target.et_old_mine_changepass = null;
      target.tv_title_clude = null;
      target.toolbar_clude = null;
    }
  }
}
