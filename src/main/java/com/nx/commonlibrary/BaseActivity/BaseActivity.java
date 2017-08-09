package com.nx.commonlibrary.BaseActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.nx.commonlibrary.BaseView.IBaseView;


/**
 * @类描述： 基础类Activity，所有Activity都需继承使用
 * @创建人：张强 boy
 * @创建时间： 17/8/4 23:59
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView,View.OnClickListener {
    private BaseActivityDelegate mBaseActivityDelegate;
    public  static final String TAG = "BaseActivity";
    private static Dialog dialog = null;
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout();
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        getmBaseActivityDelegate().onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getmBaseActivityDelegate().onSaveInstanceState(outState);
    }

    /**
     * TitleBar返回按钮操作
     *
     * @param view
     */
    public void back(View view) {
        getmBaseActivityDelegate().back(view);
    }

    /**
     * 设置onClick监听
     *
     * @param viewId
     * @param onClickListener
     */
    public void setOnClickListener(int viewId, View.OnClickListener onClickListener) {
        getmBaseActivityDelegate().setOnClickListener(viewId,onClickListener);
    }

    /**
     * 设置文字
     * @param viewId
     * @param text
     */
    public void setText(int viewId, String text) {
        getmBaseActivityDelegate().setText(viewId,text);
    }

    /**
     * 设置控件显示隐藏
     *
     * @param viewId
     * @param visibility
     */
    public void setVisibility(int viewId, int visibility) {
        getmBaseActivityDelegate().setVisibility(viewId,visibility);
    }

    /**
     * 控件显示隐藏反向操作
     *
     * @param viewId
     */
    public void toggleVisible(int viewId) {
        getmBaseActivityDelegate().toggleVisible(viewId);
    }

    /**
     * 显示Toast
     *
     * @param message
     */
    @Override
    public void showToastMessage(final String message) {
        getmBaseActivityDelegate().showToastMessage(message);
    }

    /**
     * 显示Dialog
     *
     * @param message
     */
    @Override
    public void showLoadingDialog(String message) {
        getmBaseActivityDelegate().showLoadingDialog(message);
    }

    /**
     * 关闭Dialog
     */
    @Override
    public void cancelLoadingDialog() {
        getmBaseActivityDelegate().cancelLoadingDialog();
    }

    /**
     * Dialog进度
     *
     * @param bytesWritten
     * @param totalSize
     */
    @Override
    public void onProgress(int bytesWritten, int totalSize) {
        getmBaseActivityDelegate().onProgress(bytesWritten,totalSize);
    }

    @Override
    public void onClick(View v) {
        onClickEvent(v);
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
    public abstract void setContentLayout();

    /**
     * 设置MyTabDelegate对象单列，
     *
     * @return MyTabDelegate对象
     */
    public BaseActivityDelegate getmBaseActivityDelegate() {
        if (mBaseActivityDelegate == null) {
            mBaseActivityDelegate = BaseActivityDelegate.create(this, this);
        }
        return mBaseActivityDelegate;
    }

}
