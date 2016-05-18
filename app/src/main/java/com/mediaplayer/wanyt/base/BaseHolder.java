package com.mediaplayer.wanyt.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created on 2016/5/18 21:52
 * <p/>
 * author wanyt
 * <p/>
 * Description:自定义的ViewHolder
 */
public class BaseHolder {

    private View convertView;
    private SparseArray<View> views;

    public BaseHolder(Context context, ViewGroup parent, int layoutId) {
        this.views = new SparseArray<View>();
        convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        convertView.setTag(this);
    }

    public static BaseHolder getHolder(
            Context context, View convertView,
            ViewGroup parent, int layoutId){

        if(convertView == null){
            return new BaseHolder(context, parent, layoutId);
        }else{
            return (BaseHolder) convertView.getTag();
        }

    }

    public <T extends View> T getView(int viewId){
        View view = views.get(viewId);
        if(view == null){
            view = convertView.findViewById(viewId);
            views.append(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView(){
        return convertView;
    }

}