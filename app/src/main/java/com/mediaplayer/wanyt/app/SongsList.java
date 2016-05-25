package com.mediaplayer.wanyt.app;

import com.mediaplayer.wanyt.bean.SongInfo;
import com.mediaplayer.wanyt.utils.LogUtil;

import java.util.ArrayList;

/**
 * Created on 2016/5/24 13:28
 * <p>
 * author wanyt
 * <p>
 * Description:
 */
public class SongsList {

    private SongsList() {}

    private static SongsList instance;

    public static SongsList getInstance(){
        if(instance == null){
            instance = new SongsList();
        }
        return instance;
    }

    private ArrayList<SongInfo> normalSongsList;

    public ArrayList<SongInfo> getNormalSongsList() {
        return this.normalSongsList;
    }

    public void setNormalSongsList(ArrayList<SongInfo> normalSongsList) {
        this.normalSongsList = normalSongsList;
    }

}
