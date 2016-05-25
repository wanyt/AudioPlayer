package com.mediaplayer.wanyt.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mediaplayer.wanyt.R;
import com.mediaplayer.wanyt.base.BaseActivity;
import com.mediaplayer.wanyt.bean.SongInfo;
import com.mediaplayer.wanyt.manager.IPlayState;
import com.mediaplayer.wanyt.manager.PlayManager;
import com.mediaplayer.wanyt.service.ScanSongsService;
import com.mediaplayer.wanyt.utils.LogUtil;
import com.mediaplayer.wanyt.utils.SongPicUtil;
import com.meg7.widget.CustomShapeImageView;

import jp.wasabeef.blurry.Blurry;

/**
 * Created on 2016/4/25 17:51
 *
 * author wanyt
 * <p/>
 * Description:主界面
 */
public class MainActivity extends BaseActivity implements IPlayState {

    @Override
    protected int inflateContent() {
        return R.layout.activity_main;
    }

    private PlayManager playManager;
    private boolean isPlaying;
    private ImageButton ibPrevious, ibPlay, ibNext;
    private TextView tvSongname, tvSinger;
    private CustomShapeImageView ivSongIcon;

    @Override
    protected void initView() {
        playManager = PlayManager.getInstance();

        ibPrevious = get(R.id.ib_main_pic_previous);
        ibPlay = get(R.id.ib_main_pic_play);
        ibNext = get(R.id.ib_main_pic_next);
        tvSongname = get(R.id.tv_main_pic_songname);
        tvSinger = get(R.id.tv_main_pic_singer);
        ivSongIcon = get(R.id.iv_main_pic_music);

        ibPrevious.setOnClickListener(this);
        ibPlay.setOnClickListener(this);
        ibNext.setOnClickListener(this);
        playManager.setOnPlayStateChanged(this);
    }

    @Override
    protected void initData() {
        Intent intent = new Intent(this, ScanSongsService.class);
        startService(intent);
    }

    @Override
    public void clickEvent(View v) {
        switch (v.getId()){
            case R.id.ib_main_pic_previous:
                playManager.previous();
                break;
            case R.id.ib_main_pic_play:
                playOrPause();
                break;
            case R.id.ib_main_pic_next:
                playManager.next();
                break;
        }
    }

    private void playOrPause() {
        if(!isPlaying){
            playManager.start();
            ibPlay.setBackgroundResource(R.drawable.icon_pause);
        }else{
            playManager.pause();
            ibPlay.setBackgroundResource(R.drawable.icon_play);
        }
    }

    @Override
    public void onPlayStateChanged(boolean isPlaying, SongInfo song) {
        this.isPlaying = isPlaying;

        if(song != null){
            tvSongname.setText(song.title);
            tvSinger.setText(song.aritst);

            Bitmap pic = SongPicUtil.getArtwork(this, song.id, song.albumId, true, true);
            ivSongIcon.setImageBitmap(pic);
        }

        if(isPlaying){
            ibPlay.setBackgroundResource(R.drawable.icon_pause);
        }else{
            ibPlay.setBackgroundResource(R.drawable.icon_play);
        }
    }
}
