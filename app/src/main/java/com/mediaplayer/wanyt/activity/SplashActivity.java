package com.mediaplayer.wanyt.activity;

import android.app.LauncherActivity;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mediaplayer.wanyt.R;
import com.mediaplayer.wanyt.base.BaseActivity;
import com.mediaplayer.wanyt.utils.DensityUtil;
import com.mediaplayer.wanyt.utils.JumpUtil;

import jp.wasabeef.blurry.Blurry;

/**
 * Created on 2016/5/11 21:26
 * <p/>
 * author wanyt
 * <p/>
 * Description:闪屏界面
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected int inflateContent() {
        return R.layout.activity_splash;
    }

    private ImageView image;
    private RelativeLayout rlLoginRoot;
    private TextView tvMusic;

    @Override
    protected void initView() {
        image = get(R.id.iv_splash);
        rlLoginRoot = get(R.id.rl_splash_login_root);
        tvMusic = get(R.id.tv_splash_music);
        TextView tvLogin = get(R.id.tv_splash_login);

        tvMusic.setVisibility(View.GONE);
        rlLoginRoot.setVisibility(View.GONE);
        tvLogin.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Blurry.with(SplashActivity.this)
                        .radius(25)
                        .sampling(1)
                        .color(Color.TRANSPARENT)
                        .async()
                        .animate()
                        .capture(image)
                        .into(image);

            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvMusic.setVisibility(View.VISIBLE);
                rlLoginRoot.setVisibility(View.VISIBLE);
                animIn();
            }
        }, 2700);

    }

    public void animIn(){

        TranslateAnimation animation = new TranslateAnimation(0, 0,
                DensityUtil.getScreenHeight(this), 0);

        animation.setDuration(1000);
        animation.setFillAfter(true);

        TranslateAnimation animTxt = new TranslateAnimation(0, 0,
                -DensityUtil.getScreenHeight(this), 0);

        animTxt.setDuration(1000);
        animTxt.setFillAfter(true);


        tvMusic.setAnimation(animTxt);
        rlLoginRoot.setAnimation(animation);

    }

    @Override
    public void clickEvent(View v) {
        switch (v.getId()){
            case R.id.tv_splash_login:
                JumpUtil.toActivity(this, MainActivity.class);
                break;
        }
    }

}

