package com.mediaplayer.wanyt.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created on 2016/4/22 17:40
 * <p/>
 * Description:歌曲信息
 */
public class SongInfo implements Serializable {

    public long duration;//歌曲长度
    public String album;//
    public String title;//歌曲名称
    public String aritst;//歌手
    public String path;//source
    public long albumId;
    public long id;

    public ArrayList<SongInfo> songs = new ArrayList<SongInfo>();

    public ArrayList<SongInfo> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<SongInfo> songs) {
        this.songs = songs;
    }

}
