package com.nx.commonlibrary.BaseAdapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhnagqiang on 15/3/19.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected LayoutInflater inflater;
    protected Context context;
    protected List<T> datas;
    protected final int itemLayoutId;
    protected boolean busy = false;

    public CommonAdapter(Context context, List<T> datas, int itemLayoutId) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        this.datas = datas;
        this.itemLayoutId = itemLayoutId;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public boolean isBusy() {
        return busy;
    }

    public List<T> getData() {
        return this.datas;
    }

    @Override
    public int getCount() {
        if (this.datas == null) {
            return 0;
        }
        return datas.size();
    }

    @Override
    public T getItem(int position) {
        if (this.datas == null) {
            return null;
        }
        return datas.get(position);
    }

    public void removeData(int position) {
        if (this.datas == null) {
            return;
        } else if (this.datas.size() <= position) {
            return;
        }
        this.datas.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 清除数据
     */
    public void clearData() {
        if (this.datas != null) {
            this.datas.clear();
        }
        notifyDataSetChanged();
    }

    public T getlastData() {
        if (this.datas != null) {
            return this.datas.get(this.datas.size() - 1);
        }
        return null;
    }

    public void addData(T data) {
        if (this.datas == null) {
            this.datas = new ArrayList<T>();
        }
        this.datas.add(data);
        notifyDataSetChanged();
    }

    public void addToFirst(T data) {
        if (this.datas == null) {
            this.datas = new ArrayList<T>();
            this.datas.add(data);
        } else {
            this.datas.add(0, data);
        }
        notifyDataSetChanged();
    }


    public void addData(List<T> datas) {
        if (datas == null) {
            return;
        }
        if (this.datas == null) {
            this.datas = datas;
        } else {
            if (datas.size() > 20) {
                datas.remove(0);
            }
            this.datas.addAll(datas);
        }
        notifyDataSetChanged();
    }

    public void setData(List<T> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        try {
            convert(position, viewHolder, getItem(position));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return viewHolder.getConvertView();

    }

    public abstract void convert(int position, ViewHolder helper, T item);


    public ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {

        return ViewHolder.get(this.context, convertView, parent, this.itemLayoutId, position);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        if (observer != null) {
            super.unregisterDataSetObserver(observer);
        }
    }
}
