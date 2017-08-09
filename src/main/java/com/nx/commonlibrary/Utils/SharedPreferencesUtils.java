package com.nx.commonlibrary.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * 文件操作工具类
 * @author zhnagqiang
 *         class SharedPreferences 全局数据存储
 */
public class SharedPreferencesUtils {

    private static final String TAG = "SharedPreferencesUtils --> ";

    private static SharedPreferences shard = null;

    /**
     * 设置String参数
     * @param context     Context
     * @param name  参数名称 key
     * @param param 参数值
     * @method 保存全局参数 String
     */
    public static void setParam(Context context, String name, String param) {
        if (shard == null)
            shard = PreferenceManager.getDefaultSharedPreferences(context);

        shard.edit().putString(name, param).commit();

        Log.d(TAG, "put param = " + name + " ,value = " + param);
    }

    /**
     * 设置长整形参数
     * @param context
     * @param name
     * @param param
     */
    public static void setlongParam(Context context, String name, long param) {
        if (shard == null)
            shard = PreferenceManager.getDefaultSharedPreferences(context);

        shard.edit().putLong(name, param).commit();

        Log.d(TAG, "put param = " + name + " ,value = " + param);
    }

    /**
     * 清除文件数据
     * @param context
     */
    public static void removeSharedData(Context context) {
        if (shard == null)
            shard = PreferenceManager.getDefaultSharedPreferences(context);

        Editor edit = shard.edit();
        edit.clear().commit();

    }

    /**
     * 设置版本号
     * @param context
     * @param strVersioncode 添加 Versioncode 值
     */
    public static void setVersioncode(Context context, String strVersioncode) {
        if (shard == null)
            shard = PreferenceManager.getDefaultSharedPreferences(context);

        shard.edit().putString("versioncode", strVersioncode).commit();

        Log.d(TAG, "put Versioncode = " + strVersioncode);
    }

    /**
     * 获取版本号
     * @param context
     * @return 返回 Versioncode 值
     */
    public static String getVersioncode(Context context) {
        String param = "";
        if (shard == null)
            shard = PreferenceManager.getDefaultSharedPreferences(context);
        param = shard.getString("versioncode", "6");
        Log.d(TAG, "get Versioncode = " + param);
        return param;
    }

    /**
     * 移除String参数
     * @param context    Context
     * @param name 参数名称 key
     * @method 移除全局参数 String
     */
    public static void removeParam(Context context, String name) {

        if (shard == null)
            shard = PreferenceManager.getDefaultSharedPreferences(context);

        shard.edit().remove(name).commit();

        Log.d(TAG, "remove param = " + name);
    }

    /**
     * 获取String参数
     * @param context        Context
     * @param name     参数名称 key
     * @param defparam 默认参数值
     * @method 获取全局参数 String
     */
    public static String getParam(Context context, String name, String defparam) {
        String param = "";

        if (shard == null)
            shard = PreferenceManager.getDefaultSharedPreferences(context);

        param = shard.getString(name, defparam);

        Log.d(TAG, "get param = " + name + " ,defparam = " + defparam);
        return param;
    }


    /**
     * 获取长整形参数
     * @param context        Context
     * @param name     参数名称 key
     * @param defparam 默认参数值
     * @method 获取全局参数 String
     */
    public static long getlongParam(Context context, String name, long defparam) {
        long param = 0;

        if (shard == null)
            shard = PreferenceManager.getDefaultSharedPreferences(context);

        param = shard.getLong(name, defparam);

        Log.d(TAG, "get param = " + name + " ,defparam = " + defparam);
        return param;
    }
}
