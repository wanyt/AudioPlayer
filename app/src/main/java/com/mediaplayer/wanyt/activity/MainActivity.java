package com.mediaplayer.wanyt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mediaplayer.wanyt.R;
import com.mediaplayer.wanyt.service.ScanSongsService;

/**
 * Created on 2016/4/25 17:51
 *
 * author wanyt
 * <p/>
 * Description:主界面
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ScanSongsService.class);
        startService(intent);
    }

}
