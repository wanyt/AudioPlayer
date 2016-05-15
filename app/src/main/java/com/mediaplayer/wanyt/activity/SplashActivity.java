package com.mediaplayer.wanyt.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.mediaplayer.wanyt.R;

import jp.wasabeef.blurry.Blurry;

/**
 * Created on 2016/5/11 21:26
 * <p/>
 * author wanyt
 * <p/>
 * Description:
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final ImageView image = (ImageView) findViewById(R.id.iv_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Blurry.with(SplashActivity.this)
                        .radius(40)
                        .sampling(1)
                        .color(Color.TRANSPARENT)
                        .async()
                        .animate(3000000)
                        .capture(image)
                        .into(image);
            }
        }, 2000);
    }

}

