/**
 *
 */
package com.nx.commonlibrary.BaseToken;

import android.content.Context;

import com.nx.commonlibrary.BaseApplication.BaseApplication;


/**
 * @version 1.0ø
 * @类描述： 基础类BaseToken，所有Token都需继承使用
 * @项目名称：NX
 * @类名称： BaseToken
 * @包名称： com.nx.commonlibrary.BaseToken
 * @创建人：张强 boy
 * @创建时间： 17/8/4 23:59
 */
public class BaseToken {

    private static BaseToken instance;
    private static Context context;

    /**
     * 获取上下文信息
     *
     * @return 上下文
     */
    public static Context getContext() {
        if (BaseToken.context != null) {
            return BaseToken.context;
        }
        return BaseApplication.getContext();
    }

    public static void setContext(Context cont) {
        if (BaseToken.getContext() == null && cont != null) {
            BaseToken.context = cont;
        }
    }
}
