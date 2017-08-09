package com.nx.commonlibrary.Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nx.commonlibrary.R;

/**
 * Toast操作工具类
 */
public class MyToast extends Toast {

    private static Toast mToast;

    public MyToast(Context context) {
        super(context);
    }

    /**
     * 自定义的显示错误(红色底色)Toast
     *
     * @param context  上下文
     * @param text     内容
     * @param duration 显示时间长短
     * @param gravity  开始的位置
     * @param xOffset  X轴偏移量
     * @param yOffset  Y轴偏移量
     * @return
     */
    public static Toast makeText(Context context, CharSequence text,
                                 int duration, int gravity, int xOffset, int yOffset) {
        Toast result = new Toast(context);
        LayoutInflater inflate = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(
                R.layout.newtoast, null);
        TextView tv = (TextView) v.findViewById(R.id.text0);
        tv.setText(text);

        result.setView(v);
        int dip2px = DensityUtil.dip2px(context, 52);
        result.setGravity(gravity, xOffset, yOffset);
        result.setDuration(duration);
        result.show();
        return result;
    }

    /**
     * 带本地图片的Toast
     *
     * @param context  上下文
     * @param text     内容
     * @param duration 显示时间长短
     * @param resId    本地图片
     * @param gravity  开始的位置
     * @param xOffset  X轴偏移量
     * @param yOffset  Y轴偏移量
     */
    public static Toast ImageToast(Context context, CharSequence text,
                                   int duration, int resId, int gravity, int xOffset, int yOffset) {
        // 创建一个Toast提示消息
        Toast toast = Toast.makeText(context, text, duration);
        // 设置Toast提示消息在屏幕上的位置
        toast.setGravity(gravity, xOffset, yOffset);
        // 获取Toast提示消息里原有的View
        View toastView = toast.getView();
        // 创建一个ImageView
        ImageView img = new ImageView(context);
        img.setImageResource(resId);
        // 创建一个LineLayout容器
        LinearLayout ll = new LinearLayout(context);
        // 向LinearLayout中添加ImageView和Toast原有的View
        ll.addView(img);
        ll.addView(toastView);
        // 将LineLayout容器设置为toast的View
        toast.setView(ll);
        // 显示消息
        toast.show();
        return toast;
    }

    /**
     * 带网络图片的Toast
     *
     * @param context  上下文
     * @param text     内容
     * @param duration 时间长短
     * @param bm       Bitmap
     * @param gravity  开始的位置
     * @param xOffset  X轴偏移量
     * @param yOffset  Y轴偏移量
     */
    public static Toast ImageBitmapmakeText(Context context, CharSequence text,
                                            int duration, Bitmap bm, int gravity, int xOffset, int yOffset) {
        // 创建一个Toast提示消息
        Toast toast = Toast.makeText(context, text, duration);
        // 设置Toast提示消息在屏幕上的位置
        toast.setGravity(gravity, xOffset, yOffset);
        // 获取Toast提示消息里原有的View
        View toastView = toast.getView();
        // 创建一个ImageView
        ImageView img = new ImageView(context);
        img.setImageBitmap(bm);
        // 创建一个LineLayout容器
        LinearLayout ll = new LinearLayout(context);
        // 向LinearLayout中添加ImageView和Toast原有的View
        ll.addView(img);
        ll.addView(toastView);
        // 将LineLayout容器设置为toast的View
        toast.setView(ll);
        // 显示消息
        toast.show();
        return toast;
    }


    /**
     * 默认的Toast
     *
     * @param context
     * @param text
     * @param duration
     * @return
     */
    public static Toast DefaultmakeText(Context context, CharSequence text,
                                        int duration) {
        // 创建一个Toast提示消息
        Toast toast = Toast.makeText(context, text, duration);

        // 获取Toast提示消息里原有的View
        toast.show();
        return toast;
    }

    /**
     * 打印消息并且用Toast显示消息
     *
     * @param activity
     * @param message
     * @param logLevel 填d, w, e分别代表debug, warn, error; 默认是debug
     */
    public static final void toastMessage(final Activity activity, final String message, String logLevel) {
        if ("w".equals(logLevel)) {
            Log.w("sdkDemo", message);
        } else if ("e".equals(logLevel)) {
            Log.e("sdkDemo", message);
        } else {
            Log.d("sdkDemo", message);
        }
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mToast != null) {
                        mToast.cancel();
                        mToast = null;
                    }
                    mToast = Toast.makeText(activity, message, Toast.LENGTH_LONG);
                    mToast.show();
                }
            });
        } else {
            Log.e("sdkDemo", message);
        }

    }

    /**
     * 打印消息并且用Toast显示消息
     *
     * @param activity
     * @param message  填d, w, e分别代表debug, warn, error; 默认是debug
     */
    public static final void toastMessage(final Activity activity, final String message) {
        toastMessage(activity, message, null);
    }


}
