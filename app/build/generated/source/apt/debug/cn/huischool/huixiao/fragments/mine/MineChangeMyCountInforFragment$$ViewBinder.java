// Generated code from Butter Knife. Do not modify!
package cn.huischool.huixiao.fragments.mine;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MineChangeMyCountInforFragment$$ViewBinder<T extends MineChangeMyCountInforFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131624097, "field 'toolbar_clude'");
    target.toolbar_clude = finder.castView(view, 2131624097, "field 'toolbar_clude'");
    view = finder.findRequiredView(source, 2131624098, "field 'tv_title_clude'");
    target.tv_title_clude = finder.castView(view, 2131624098, "field 'tv_title_clude'");
    view = finder.findRequiredView(source, 2131624515, "field 'et_infor_qq_'");
    target.et_infor_qq_ = finder.castView(view, 2131624515, "field 'et_infor_qq_'");
    view = finder.findRequiredView(source, 2131624511, "field 'et_infor_tel_'");
    target.et_infor_tel_ = finder.castView(view, 2131624511, "field 'et_infor_tel_'");
    view = finder.findRequiredView(source, 2131624513, "field 'et_infor_mail_'");
    target.et_infor_mail_ = finder.castView(view, 2131624513, "field 'et_infor_mail_'");
    view = finder.findRequiredView(source, 2131624516, "field 'btn_infor_ture_'");
    target.btn_infor_ture_ = finder.castView(view, 2131624516, "field 'btn_infor_ture_'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends MineChangeMyCountInforFragment> implements Unbinder {
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
      target.toolbar_clude = null;
      target.tv_title_clude = null;
      target.et_infor_qq_ = null;
      target.et_infor_tel_ = null;
      target.et_infor_mail_ = null;
      target.btn_infor_ture_ = null;
    }
  }
}
