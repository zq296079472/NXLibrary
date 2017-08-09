package com.nx.commonlibrary.BasePresenter;

import android.content.Context;

import com.nx.commonlibrary.BaseView.IBaseView;

/**
 * Created by zhnagqiang on 15/4/7.
 */
public class BasePresenter {
    protected Context context = null;
    protected IBaseView view = null;

    public BasePresenter(IBaseView view) {
        this(null, view);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setView(IBaseView view) {
        this.view = view;
    }

    public BasePresenter(Context context, IBaseView view) {
        this.context = context;
        this.view = view;
    }
}
