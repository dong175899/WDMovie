package com.bw.movie.download.util;

import android.os.Environment;

import com.bw.movie.view.MainApplication;



/**
 *@describe(描述)：Constant
 *@data（日期）: 2019/11/12
 *@time（时间）: 20:49
 *@author（作者）: 张恩
 **/

public class Constant {
    public final static String APP_ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + MainApplication.getInstance().getPackageName();
    public final static String DOWNLOAD_DIR = "/downlaod/";


}
