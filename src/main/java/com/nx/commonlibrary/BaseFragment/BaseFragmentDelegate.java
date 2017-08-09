package com.nx.commonlibrary.BaseFragment;

import android.content.Context;
import android.view.View;

import com.nx.commonlibrary.BaseView.IBaseView;

/**
 * @类描述： BaseFragment 创造者
 * @创建人：张强 boy
 * @创建时间： 17/8/4 23:59
 */
 abstract class BaseFragmentDelegate {
    public static final String TAG = "BaseFragmentDelegate";
    public static BaseFragmentDelegate create(Context context, IBaseView view) {
        return Mycreate(context, view);
    }

    /**
     * 创建一个MyTabDelegate对象，可向下继承，进行版本控制，之后版本都继承V1版本，进行重写
     *
     * @param context
     * @param view
     * @return
     */
    private static BaseFragmentDelegate Mycreate(Context context, IBaseView view) {
        return new BaseFragmentDelegateImplV1(context, view);
    }

    /**
     * TitleBar返回按钮操作
     *
     * @param view
     */
    public abstract void back(View view);

    /**
     * 设置onClick监听
     *
     * @param mContentView
     * @param viewId
     * @param onClickListener
     */
    public abstract void setOnClickListener(View mContentView, int viewId, View.OnClickListener onClickListener);

    /**
     * 设置文字
     *
     * @param mContentView
     * @param viewId
     * @param text
     */
    public abstract void setText(View mContentView, int viewId, String text);

    /**
     * 设置控件显示隐藏
     *
     * @param mContentView
     * @param viewId
     * @param visibility
     */
    public abstract void setVisibility(View mContentView, int viewId, int visibility);

    /**
     * 控件显示隐藏反向操作
     *
     * @param mContentView
     * @param viewId
     */
    public abstract void toggleVisible(View mContentView, int viewId);

    /**
     * 显示Toast
     *
     * @param message
     */
    public abstract void showToastMessage(final String message);

    /**
     * 显示Dialog
     *
     * @param message
     */
    public abstract void showLoadingDialog(String message);

    /**
     * 关闭Dialog
     */
    public abstract void cancelLoadingDialog();

    /**
     * Dialog进度
     *
     * @param bytesWritten
     * @param totalSize
     */
    public abstract void onProgress(int bytesWritten, int totalSize);
}
