package com.mediaplayer.wanyt.utils;

import android.content.Context;

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

}
