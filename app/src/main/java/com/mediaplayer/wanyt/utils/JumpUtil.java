package com.mediaplayer.wanyt.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created on 2016/5/11 21:48
 * <p/>
 * author wanyt
 * <p/>
 * Description: 界面跳转工具类
 */
public class JumpUtil {

    public static void toActivity(Context context, Class<? extends Activity> clazz){
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

}
