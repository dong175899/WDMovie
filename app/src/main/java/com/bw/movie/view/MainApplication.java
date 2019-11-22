package com.bw.movie.view;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 *@describe(描述)：MainApplication
 *@data（日期）: 2019/11/12
 *@time（时间）: 20:50
 *@author（作者）: 张恩
 **/

public class MainApplication extends Application {
    private static MainApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Fresco.initialize(this);
    }

    public static Context getInstance() {
        return sInstance;
    }
}
