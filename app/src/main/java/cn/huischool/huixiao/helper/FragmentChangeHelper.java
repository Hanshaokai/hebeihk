package cn.huischool.huixiao.helper;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Fragment 跳转助手 管理Fragment 跳转相关内容及操作
 * 
 * @author han
 * 
 *         2016-4-19
 */
public class FragmentChangeHelper {
	private Fragment targetFragment;// 跳转目标
	private Bundle arges;// 携带的数据
	private String targetFragmentTag;// 目标fragment的标记
	// 根据tag删除回退栈中的fragment 删多个
	private String[] removeFragmentTag;

	private boolean clearAllBackStack;// 跳转前是否清空回退栈
	// 设置返回到回退栈中指定的tag 的fragment
	private String backToFragmentTag;

	/**
	 * 传入跳转目标Fragment
	 * 
	 * @param fragment
	 */
	public FragmentChangeHelper() {
	
	}
	public FragmentChangeHelper(Fragment ta) {
		this.targetFragment = ta;
	}

	public void setTargetFragment(Fragment targetFragment) {
		this.targetFragment = targetFragment;
	}

	/**
	 * 传入回退栈中目标frgament 的tag
	 * 
	 * @param backToFragment
	 */
	public FragmentChangeHelper(String backToFragment) {

		this.backToFragmentTag = backToFragment;

	}

	// 要传给目标的数据
	public void setArguments(Bundle args) {

		this.arges = args;

	}

	/**
	 * 将目标Fragment 添加到回退栈 同时为目标Fragment 设置tag 为目标设置的tag 这个Tag应该在每个fragment
	 * 中以类名作为常量定义
	 * 
	 * @param targetFragmentTag
	 */
	public void addToBackStack(String targetFragmentTag) {
		this.targetFragmentTag = targetFragmentTag;
	}

	/**
	 * 删除回退栈中指定tag 的fragment 可同时删除多个
	 * 
	 * @param removeFragmentTag
	 */
	public void removeFragmentFromBackStack(String... removeFragmentTag) {

		this.removeFragmentTag = removeFragmentTag;

	}

	/**
	 * 设置是否在跳转前清空回退栈
	 * 
	 * @param clearAllBackSatck
	 */
	public void clearAllBackStack(boolean clearAllBackSatck) {
		this.clearAllBackStack = clearAllBackSatck;
	}

	// 获取内容的方法
	public Bundle getArgs() {
		return arges;

	}

	public boolean isClearAllBackStack() {

		return clearAllBackStack;
	}

	public String getTargetFragmentTag() {

		return targetFragmentTag;

	}

	public String[] getRemoveFragmentTag() {

		return removeFragmentTag;

	}

	public Fragment getTargetFragment() {

		return targetFragment;

	}

	public String getBackToFragmentTag() {

		return backToFragmentTag;
	}
}
