package com.mediaplayer.wanyt.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.mediaplayer.wanyt.app.Application;

/**
 * Created on 2016/4/27 17:15
 * <p/>
 * author wanyt
 * <p/>
 * Description:
 */
public class DensityUtil {

    public static int dip2px(Context context, int dip){
        float density = context.getResources().getDisplayMetrics().density;
        return (int)(dip*density+0.5);
    }

    public static int getScreenHeight(Context context){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.heightPixels;
    }

    public static int getScreenWidth(Context context){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }

}
