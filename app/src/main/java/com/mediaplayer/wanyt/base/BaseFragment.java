package com.mediaplayer.wanyt.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created on 2016/5/22 15:44
 * <p/>
 * author wanyt
 * <p/>
 * Description:
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(inflateContent(), null);

        initView();

        initData();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public abstract int inflateContent() ;

    protected abstract void initView();

    protected abstract void initData();


    @Override
    public void onClick(View v) {
        clickEvent(v);
    }

    protected abstract void clickEvent(View v);

    public <T extends View> T get(int id){
        return (T)rootView.findViewById(id);
    }
}
