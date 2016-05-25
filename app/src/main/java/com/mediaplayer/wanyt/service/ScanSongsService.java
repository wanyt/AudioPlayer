package com.mediaplayer.wanyt.service;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v4.content.LocalBroadcastManager;

import com.mediaplayer.wanyt.constant.Constants;
import com.mediaplayer.wanyt.bean.SongInfo;

import java.util.ArrayList;

/**
 * Created on 2016/4/22 14:14
 *
 * author wanyt
 *
 * Description:使用service获取当前设备中的音乐
 *              在service中不能弹出toast
 */
public class ScanSongsService extends IntentService {

    //继承IntentService的service必须要有空参数的构造函数
    public ScanSongsService() {
        super("");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SongInfo songsContainer = new SongInfo();
        ArrayList<SongInfo> songs = getSongsFromDevice();

        if(songs != null){
            songsContainer.setSongs(songs);
            Intent getSongsIntent = new Intent(Constants.GET_SONGS);
            getSongsIntent.putExtra(Constants.SONG_INFO, songsContainer);
            LocalBroadcastManager.getInstance(this).sendBroadcast(getSongsIntent);
        }
    }

    /**
     * 获取cursor,并进行遍历
     * @return
     */
    public ArrayList<SongInfo> getSongsFromDevice(){

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, searchItem, null, null, null);

        ArrayList<SongInfo> songsList = new ArrayList<SongInfo>();
        SongInfo info;
        if(cursor != null){
            while(cursor.moveToNext()){
                info = new SongInfo();
                info =  getAndSetSongInfo(cursor, info);
                songsList.add(info);
                info = null;//优化内存
            }
            cursor.close();
        }
        return songsList;
    }

    private static String[] searchItem = new String[] {
            MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.DURATION,
            MediaStore.Audio.Media.ALBUM, MediaStore.Audio.Media.ALBUM_ID,
            MediaStore.Audio.Media._ID};

    /**
     * 获取并设置歌曲到list中
     * @param cursor
     * @param info
     * @return
     */
    public SongInfo getAndSetSongInfo(Cursor cursor, SongInfo info){
        String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
        String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
        long duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
        String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
        long albumId = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
        long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));

        info.duration = duration;
        info.album = album;
        info.aritst = artist;
        info.title = title;
        info.path = path;
        info.albumId = albumId;
        info.id = id;

        return info;
    }
}
