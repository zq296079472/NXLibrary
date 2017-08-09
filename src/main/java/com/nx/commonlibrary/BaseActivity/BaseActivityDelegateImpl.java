package com.nx.commonlibrary.BaseActivity;

import android.content.Context;

import com.nx.commonlibrary.BaseView.IBaseView;

/**
 * @类描述：BaseActivity创造者实例
 * @创建人：张强 boy
 * @创建时间： 17/8/4 23:59
 */
 abstract class BaseActivityDelegateImpl extends BaseActivityDelegate{

    public IBaseView view;
    public Context mcontext;

    BaseActivityDelegateImpl(Context context, IBaseView view) {
        this.mcontext = context;
        this.view = view;
    }
}
