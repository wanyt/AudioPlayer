package com.mediaplayer.wanyt.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mediaplayer.wanyt.R;
import com.mediaplayer.wanyt.base.BaseActivity;
import com.mediaplayer.wanyt.service.ScanSongsService;

import jp.wasabeef.blurry.Blurry;

/**
 * Created on 2016/4/25 17:51
 *
 * author wanyt
 * <p/>
 * Description:主界面
 */
public class MainActivity extends BaseActivity {

    @Override
    protected int inflateContent() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }


    @Override
    protected void initData() {
        Intent intent = new Intent(this, ScanSongsService.class);
        startService(intent);
    }

    @Override
    public void clickEvent(View v) {

    }

}
