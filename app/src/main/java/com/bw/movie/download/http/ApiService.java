package com.bw.movie.download.http;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 *@describe(描述)：ApiService
 *@data（日期）: 2019/11/12
 *@time（时间）: 21:14
 *@author（作者）:dongyanjun
 **/

public interface ApiService {
    public static final String BASE_URL = "http://172.17.8.100/";
    @Streaming
    @GET
    Observable<ResponseBody> executeDownload(@Header("Range") String range, @Url() String url);

}


