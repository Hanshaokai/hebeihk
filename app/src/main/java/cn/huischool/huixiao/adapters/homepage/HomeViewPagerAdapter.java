package cn.huischool.huixiao.adapters.homepage;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class HomeViewPagerAdapter extends PagerAdapter {
	private List<ImageView> mList;

	public HomeViewPagerAdapter(List<ImageView> list) {
		this.mList = list;

	}

	@Override
	public int getCount() {
		if (mList.size() == 1) {// 一张图片时不用流动
			return mList.size();
		}
		return Integer.MAX_VALUE;// =========
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// 对viewPager页号 求模取出view列表要显示的向，position可能会出现负值
		position %= mList.size();
		if (position < 0) {
			position = mList.size() + position;
		}
		ImageView imageView = mList.get(position);
		imageView.setScaleType(ScaleType.FIT_XY);
		// 如果view已经在之前添加到了一个父组件则必须先remove 否则会抛出IllegalStateException
		ViewParent viewParent = imageView.getParent();
		if (viewParent != null) {
			ViewGroup parent = (ViewGroup) viewParent;
			parent.removeView(imageView);

		}
		container.addView(imageView);
		return imageView;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {

		// super.destroyItem(container, position, object);
	}

}
