package com.mediaplayer.wanyt.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mediaplayer.wanyt.R;
import com.mediaplayer.wanyt.bean.SongInfo;
import com.mediaplayer.wanyt.manager.PlayManager;
import com.mediaplayer.wanyt.utils.LogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created on 2016/4/25 17:55
 *
 * author wanyt
 * <p/>
 * Description:歌曲列表的适配器
 */
public class SongsListAdapter extends BaseAdapter {

    private ArrayList<SongInfo> songs = new ArrayList<SongInfo>();
    private Context context;

    public SongsListAdapter(Context context, ArrayList<SongInfo> songs) {
        this.context = context;
        this.songs = songs;
    }

    @Override
    public int getCount() {
        return songs == null ? 0 : songs.size();
    }

    @Override
    public Object getItem(int position) {
        return songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.item_song_layout, null);

            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        if(songs != null){
            SongInfo song = songs.get(position);
            holder.setData(song);
        }
        return convertView;
    }

    class ViewHolder{
        TextView tvSongName, tvDuration;

        public ViewHolder(View view) {
            tvSongName = (TextView) view.findViewById(R.id.item_song_name);
            tvDuration = (TextView) view.findViewById(R.id.item_song_duration);
        }

        public void setData(SongInfo song){
            tvSongName.setText(song.title);

            Date d = new Date(song.duration);
            SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
            tvDuration.setText(sdf.format(d));
        }
    }

    public void setData(ArrayList<SongInfo> songs){
        this.songs = songs;
        notifyDataSetChanged();
    }

}
