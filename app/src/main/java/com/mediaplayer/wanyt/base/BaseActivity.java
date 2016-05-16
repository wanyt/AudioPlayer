package com.mediaplayer.wanyt.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created on 2016/5/16 9:55
 * <p/>
 * author wanyt
 * <p/>
 * Description:所有Activity的基类，每个Activity，都会继承这个类
 */
abstract public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inflateContent());

        initView();
        initData();
    }

    protected abstract int inflateContent();

    protected abstract void initView();

    protected abstract void initData();

    public abstract void clickEvent(View v);

    @Override
    public void onClick(View v) {
        clickEvent(v);
    }

    public <T extends View> T get(int id){
        return (T)super.findViewById(id);
    }
}
