package com.nx.commonlibrary.BaseFragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nx.commonlibrary.BaseView.IBaseView;

/**
 * @类描述： BaseFragment 创造者实例V1版本
 * @创建人：张强 boy
 * @创建时间： 17/8/4 23:59
 */
 class BaseFragmentDelegateImplV1 extends BaseFragmentDelegateImpl {
    private Activity mActivity;
    private ProgressDialog mProgressDialog = null;
    private Toast mToast = null;
    BaseFragmentDelegateImplV1(Context context, IBaseView view) {
        super(context, view);
        mActivity = (Activity) context;
    }

    @Override
    public void back(View view) {
        mActivity.finish();
    }

    @Override
    public void setOnClickListener(View mContentView, int viewId, View.OnClickListener onClickListener) {
        View view = mContentView.findViewById(viewId);
        if (view == null) {
            Log.w(TAG, "没有找到这个控件:" + view);
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    @Override
    public void setText(View mContentView, int viewId, String text) {
        View view = mContentView.findViewById(viewId);
        if (view instanceof TextView) {
            ((TextView) view).setText(text);
        } else {
            Log.w(TAG, "不确定的类型");
        }
    }

    @Override
    public void setVisibility(View mContentView, int viewId, int visibility) {
        if (visibility != View.GONE && visibility != View.VISIBLE && visibility != View.INVISIBLE) {
            Log.w(TAG, "参数错误， visibility:" + visibility);
            return;
        }
        View view = mContentView.findViewById(viewId);
        if (view == null) {
            Log.w(TAG, "没有找到这个控件:" + view);
            return;
        }
        view.setVisibility(visibility);
    }

    @Override
    public void toggleVisible(View mContentView, int viewId) {
        View view = mContentView.findViewById(viewId);
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
    public void showToastMessage(final String message) {
        if (mActivity == null) {
            return;
        }
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mToast != null) {
                    mToast.cancel();
                    mToast = null;
                }
                mToast = Toast.makeText(mActivity, message, Toast.LENGTH_SHORT);
                mToast.show();
            }
        });
    }

    @Override
    public void showLoadingDialog(String message) {
        try {
            cancelLoadingDialog();
            if (TextUtils.isEmpty(message)) {
                message = "正在加载...";
            }
            mProgressDialog = ProgressDialog.show(mcontext, null, message, false, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelLoadingDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    public void onProgress(int bytesWritten, int totalSize) {

    }
}
