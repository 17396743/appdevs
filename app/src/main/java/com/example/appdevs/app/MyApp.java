package com.example.appdevs.app;

import android.app.Application;



/**
 * @创建时间 2022/3/30 16:48
 */
public class MyApp extends Application {
    public static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initRes();
    }

    /**
     * 初始化资源
     */
    private void initRes(){

    }
}
