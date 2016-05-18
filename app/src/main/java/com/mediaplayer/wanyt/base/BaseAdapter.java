package com.mediaplayer.wanyt.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created on 2016/5/18 22:07
 * <p/>
 * author wanyt
 * <p/>
 * Description:
 */
public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {

    private Context context;
    private int layoutId;
    private List<T> list;

    public BaseAdapter(Context context, int layoutId, List<T> list) {
        this.context = context;
        this.layoutId = layoutId;
        this.list = list;
    }

    public void setData(List<T> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder holder = getViewHolder(convertView, parent);
        getView(position, holder.getConvertView(), holder, getItem(position));
        return holder.getConvertView();
    }

    /**
     *
     * 子类需要实现的方法
     * @param position
     * @param convertView
     * @param holder
     * @param item
     */
    public abstract void getView(int position, View convertView, BaseHolder holder, T item);

    private BaseHolder getViewHolder(View convertView, ViewGroup parent) {
        return BaseHolder.getHolder(context, convertView, parent, layoutId);
    }
}
