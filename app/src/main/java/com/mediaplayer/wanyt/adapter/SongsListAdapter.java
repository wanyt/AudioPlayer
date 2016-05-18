package com.mediaplayer.wanyt.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.mediaplayer.wanyt.R;
import com.mediaplayer.wanyt.base.BaseAdapter;
import com.mediaplayer.wanyt.base.BaseHolder;
import com.mediaplayer.wanyt.bean.SongInfo;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created on 2016/4/25 17:55
 * <p/>
 * author wanyt
 * <p/>
 * Description:歌曲列表的适配器
 */
public class SongsListAdapter extends BaseAdapter<SongInfo> {

    public SongsListAdapter(Context context, int layoutId, List<SongInfo> list) {
        super(context, layoutId, list);
    }

    @Override
    public void getView(int position, View convertView, BaseHolder holder, SongInfo item) {
        TextView tvId = holder.getView(R.id.item_song_id);
        TextView tvSongName = holder.getView(R.id.item_song_name);
        TextView tvSinger = holder.getView(R.id.item_song_singer);

        tvId.setText(""+(position+1)+".");
        tvSongName.setText(item.title);
        tvSinger.setText(item.aritst);

        Date d = new Date(item.duration);
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
    }

}
