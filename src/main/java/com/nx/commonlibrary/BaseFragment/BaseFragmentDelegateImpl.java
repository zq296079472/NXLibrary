package com.nx.commonlibrary.BaseFragment;

import android.content.Context;

import com.nx.commonlibrary.BaseView.IBaseView;

/**
 * @类描述： BaseFragment 创造者实例
 * @创建人：张强 boy
 * @创建时间： 17/8/4 23:59
 */
 abstract class BaseFragmentDelegateImpl extends BaseFragmentDelegate{

    public IBaseView view;
    public Context mcontext;

    BaseFragmentDelegateImpl(Context context, IBaseView view) {
        this.mcontext = context;
        this.view = view;
    }
}
