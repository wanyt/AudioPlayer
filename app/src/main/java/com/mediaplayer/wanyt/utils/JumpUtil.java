package com.mediaplayer.wanyt.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

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

    public static void toFragment(Context context, Class<? extends Fragment> clazz){
        Intent intent = new Intent(context, clazz);
//        context.start
    }

}
