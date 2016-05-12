package com.mediaplayer.wanyt.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created on 2016/4/22 17:40
 * <p/>
 * Description:歌曲信息
 */
public class SongInfo implements Serializable {

    public long duration;
    public String album;
    public String title;
    public String aritst;
    public String path;

    public ArrayList<SongInfo> songs = new ArrayList<SongInfo>();

    public ArrayList<SongInfo> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<SongInfo> songs) {
        this.songs = songs;
    }

}
