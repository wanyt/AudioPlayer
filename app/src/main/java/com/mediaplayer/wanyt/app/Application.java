package com.mediaplayer.wanyt.app;

/**
 * Created on 2016/4/26 15:46
 * <p/>
 * author wanyt
 * <p/>
 * Description:
 */
public class Application extends android.app.Application{

    private Application() { }

    public static Application app;

    public static Application getInstance(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initGlobalComponents();
    }

    private void initGlobalComponents() {


    }
}
