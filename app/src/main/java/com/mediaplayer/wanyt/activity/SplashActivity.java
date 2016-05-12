package com.mediaplayer.wanyt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.mediaplayer.wanyt.R;
import com.mediaplayer.wanyt.utils.JumpUtil;

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

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        JumpUtil.toActivity(SplashActivity.this, MainActivity.class);
                        finish();
                    }
                }, 3000);
    }
}

