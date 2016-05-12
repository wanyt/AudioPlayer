package com.mediaplayer.wanyt.manager;

import android.media.MediaPlayer;
import android.provider.MediaStore;

import java.io.IOException;

/**
 * Created on 2016/4/26 16:36
 * <p>
 * author wanyt
 * <p>
 * Description:播放音频的管理类
 */
public class PlayManager {
    private PlayManager() {
    }

    private static PlayManager manager;

    public static PlayManager getInstance(){
        if(manager == null) {
            manager = new PlayManager();
        }
        return manager;
    }

    private MediaPlayer player;

    public void tapFromUser(String path){
        if(player == null){
            player = new MediaPlayer();
        }

        try {
            player.reset();
            player.setDataSource(path);
            player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                player.start();
            }
        });

    }

}
