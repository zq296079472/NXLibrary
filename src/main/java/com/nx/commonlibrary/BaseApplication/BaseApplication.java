package com.nx.commonlibrary.BaseApplication;

import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * @version 1.0ø
 * @类描述： 基础类Application，所有Application都需继承使用
 * @项目名称：NX
 * @类名称： BaseApplication
 * @包名称： com.nx.commonlibrary.BaseApplication
 * @创建人：张强 boy
 * @创建时间： 17/8/4 23:59
 */
public class BaseApplication extends LitePalApplication {
    private static Context context = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
