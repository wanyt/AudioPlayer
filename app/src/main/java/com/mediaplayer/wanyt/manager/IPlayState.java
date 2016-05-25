package com.mediaplayer.wanyt.manager;

import com.mediaplayer.wanyt.bean.SongInfo;

/**
 * Created on 2016/5/24 15:00
 * <p>
 * author wanyt
 * <p>
 * Description:
 */
public interface IPlayState {

    public void onPlayStateChanged(boolean isPlaying, SongInfo song);

}
