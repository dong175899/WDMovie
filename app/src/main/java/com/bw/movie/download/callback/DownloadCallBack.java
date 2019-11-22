package com.bw.movie.download.callback;

/**
 *@describe(描述)：DownloadCallBack
 *@data（日期）: 2019/11/12
 *@time（时间）: 21:14
 *@author（作者）:dongyanjun
 **/

public interface DownloadCallBack {

      void onProgress(int progress);

    void onCompleted();

    void onError(String msg);

}
