package com.nx.commonlibrary.BaseFragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nx.commonlibrary.BaseView.IBaseView;


/**
 * @类描述： Fragment，所有Fragment都需继承使用
 * @创建人：张强 boy
 * @创建时间： 17/8/4 23:59
 */
@SuppressLint("ValidFragment")
public abstract class BaseFragment extends Fragment implements IBaseView,View.OnClickListener {
    private static final String TAG = "BaseFragment";
    private View mContentView;
    private BaseFragmentDelegate mBaseFragmentDelegate;
    protected Activity mContext;

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(setContentLayout(), container, false);
        init();
        return mContentView;
    }

    @Override
    public void showToastMessage(final String message) {
        getmBaseActivityDelegate().showToastMessage(message);
    }

    /**
     * 初始化控件
     */
    public abstract void init();

    /**
     * onClick方法的封装，在此方法中处理点击
     *
     * @param view 被点击的View对象
     */
    public abstract void onClickEvent(View view);


    /**
     * 设置布局文件
     */
    public abstract Integer setContentLayout();

    @Override
    public void showLoadingDialog(String message) {
        getmBaseActivityDelegate().showLoadingDialog(message);
    }

    @Override
    public void cancelLoadingDialog() {
        getmBaseActivityDelegate().cancelLoadingDialog();
    }

    @Override
    public void onProgress(int bytesWritten, int totalSize) {
        getmBaseActivityDelegate().onProgress(bytesWritten,totalSize);
    }

    /**
     * 设置文字
     * @param viewId
     * @param text
     */
    public void setText(int viewId, String text) {
        getmBaseActivityDelegate().setText(mContentView,viewId,text);
    }


    /**
     * 设置onClick监听
     *
     * @param viewId
     * @param onClickListener
     */
    public void setOnClickListener(int viewId, View.OnClickListener onClickListener) {
        getmBaseActivityDelegate().setOnClickListener(mContentView,viewId,onClickListener);
    }


    /**
     * 设置控件显示隐藏
     *
     * @param viewId
     * @param visibility
     */
    public void setVisibility(int viewId, int visibility) {
        getmBaseActivityDelegate().setVisibility(mContentView,viewId,visibility);
    }

    /**
     * 控件显示隐藏反向操作
     *
     * @param viewId
     */
    public void toggleVisible(int viewId) {
        getmBaseActivityDelegate().toggleVisible(mContentView,viewId);
    }
    @Override
    public void onClick(View v) {
        onClickEvent(v);
    }

    /**
     * 设置MyTabDelegate对象单列，
     *
     * @return MyTabDelegate对象
     */
    public BaseFragmentDelegate getmBaseActivityDelegate() {
        if (mBaseFragmentDelegate == null) {
            mBaseFragmentDelegate = BaseFragmentDelegate.create(mContext, this);
        }
        return mBaseFragmentDelegate;
    }

}
