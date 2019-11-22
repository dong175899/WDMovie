package com.bw.movie.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 作者:dongyanjun
 * 时间：2019/11/12
 * 描述:WMovie
 * 功能：
 **/
public class App extends Application {
    public static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext=this;
        Fresco.initialize(this);
    }
}
