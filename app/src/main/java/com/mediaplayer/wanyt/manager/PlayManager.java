package com.mediaplayer.wanyt.manager;

import android.media.MediaPlayer;
import android.provider.MediaStore;

import com.mediaplayer.wanyt.app.SongsList;
import com.mediaplayer.wanyt.bean.SongInfo;
import com.mediaplayer.wanyt.utils.SongPicUtil;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created on 2016/4/26 16:36
 * <p>
 * author wanyt
 * <p>
 * Description:播放音频的管理类
 */
public class PlayManager {

    private PlayManager() {}

    private static PlayManager manager;

    public static PlayManager getInstance(){
        if(manager == null) {
            manager = new PlayManager();
        }
        return manager;
    }

    private MediaPlayer player;

    private boolean isPlaying;
    private boolean isPaused;

    /**
     * 从暂停状态切换到播放状态
     */
    public void start(){
        if(isPaused && !isPlaying){
            player.start();
            playingNotPaused();
            playState.onPlayStateChanged(isPlaying, null);
        }
    }

    /**
     * 从播放状态切换到暂停状态
     */
    public void pause(){
        if(!isPaused && isPlaying){
            player.pause();
            pausedNotPlaying();
            playState.onPlayStateChanged(isPlaying, null);
        }
    }

    private int currentSongPosition;

    /**
     * 从源播放音乐
     * @param position
     */
    public void playAccordingPath(int position){
        if(player == null){
            player = new MediaPlayer();
        }
        play(position);
    }

    public void next(){
        currentSongPosition++;
        play(currentSongPosition);
    }

    public void previous(){
        currentSongPosition--;
        play(currentSongPosition);
    }

    private void play(final int position) {
        ArrayList<SongInfo> normalSongsList = SongsList.getInstance().getNormalSongsList();
        final SongInfo song = normalSongsList.get(position);
        try {
            player.reset();
            player.setDataSource(song.path);
            player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                player.start();
                currentSongPosition = position;
                playingNotPaused();
                playState.onPlayStateChanged(isPlaying, song);
            }
        });
    }

    private IPlayState playState;

    public void setOnPlayStateChanged(IPlayState playState){
        this.playState = playState;
    }

    /**
     * 正在播放，不是处于暂停状态
     */
    private void playingNotPaused(){
        isPlaying = true;
        isPaused = false;
    }

    /**
     *已经暂停，不是处于播放状态
     */
    private void pausedNotPlaying(){
        isPlaying = false;
        isPaused = true;
    }

}
