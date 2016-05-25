package com.mediaplayer.wanyt.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.mediaplayer.wanyt.R;
import com.mediaplayer.wanyt.app.SongsList;
import com.mediaplayer.wanyt.constant.Constants;
import com.mediaplayer.wanyt.bean.SongInfo;
import com.mediaplayer.wanyt.adapter.SongsListAdapter;
import com.mediaplayer.wanyt.manager.PlayManager;
import com.mediaplayer.wanyt.utils.LogUtil;

import java.util.ArrayList;

/**
 * Created on 2016/4/25 17:51
 *
 * author wanyt
 * <p/>
 * Description:主界面歌曲列表
 */
public class SongsListFragment extends ListFragment {

    private ArrayList<SongInfo> allSong;
    private SongsListAdapter songsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IntentFilter filter = new IntentFilter(Constants.GET_SONGS);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(receiver, filter);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        songsAdapter = new SongsListAdapter(getActivity(), R.layout.item_song_layout, allSong);
        setListAdapter(songsAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        PlayManager.getInstance().playAccordingPath(position);
        super.onListItemClick(l, v, position, id);
    }

    /**
     * 获取到扫描音乐完成的广播，获取所有音乐
     */
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            SongInfo info = (SongInfo) intent.getSerializableExtra(Constants.SONG_INFO);

            ArrayList<SongInfo> songs = info.getSongs();
            if(songs != null){
                //获取到了设备所有的音频资源
                allSong = songs;
                songsAdapter.setData(allSong);
                SongsList.getInstance().setNormalSongsList(allSong);
            }else{
                Toast.makeText(getActivity(),
                        "未发现音频文件", Toast.LENGTH_SHORT).show();
            }
        }
    };

}
