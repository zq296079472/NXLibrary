package com.nx.commonlibrary.BaseActivity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.nx.commonlibrary.BaseView.IBaseView;
import com.nx.commonlibrary.Utils.ABAppUtil;
import com.nx.commonlibrary.Utils.MyToast;

/**
 * @类描述： BaseActivity创造者实例V1版本
 * @创建人：张强 boy
 * @创建时间： 17/8/4 23:59
 */
 class BaseActivityDelegateImplV1 extends BaseActivityDelegateImpl {
    private Activity mActivity;
    private static Dialog dialog = null;
    BaseActivityDelegateImplV1(Context context, IBaseView view) {
        super(context, view);
        mActivity = (Activity) context;
    }

    @Override
    public void onTouchEvent(MotionEvent event) {
        ABAppUtil.hideSoftInput(mActivity);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void back(View view) {
        mActivity.finish();
    }

    @Override
    public void setOnClickListener(int viewId, View.OnClickListener onClickListener) {
        View view = mActivity.findViewById(viewId);
        if (view == null) {
            Log.w(TAG, "没有找到这个控件:" + view);
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    @Override
    public void setText(int viewId, String text) {
        View view = mActivity.findViewById(viewId);
        if (view instanceof TextView) {
            ((TextView) view).setText(text);
        } else {
            Log.w(TAG, "不确定的类型");
        }
    }

    @Override
    public void setVisibility(int viewId, int visibility) {
        if (visibility != View.GONE && visibility != View.VISIBLE && visibility != View.INVISIBLE) {
            Log.w(TAG, "参数错误， visibility:" + visibility);
            return;
        }
        View view = mActivity.findViewById(viewId);
        if (view == null) {
            Log.w(TAG, "没有找到这个控件:" + view);
            return;
        }
        view.setVisibility(visibility);
    }

    @Override
    public void toggleVisible(int viewId) {
        View view = mActivity.findViewById(viewId);
        if (view == null) {
            Log.w(TAG, "没有找到这个控件:" + view);
            return;
        }
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.GONE);
            view.setFocusable(false);
        } else {
            view.setFocusable(true);
            view.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showToastMessage(String message) {
        MyToast.toastMessage(mActivity, message);
    }

    @Override
    public void showLoadingDialog(String message) {
        try {
            cancelLoadingDialog();
            if (TextUtils.isEmpty(message)) {
                message = "正在加载...";
            }
            dialog = ProgressDialog.show(mcontext, null, message, false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelLoadingDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

    @Override
    public void onProgress(int bytesWritten, int totalSize) {

    }
}
