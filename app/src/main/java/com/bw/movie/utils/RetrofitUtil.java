package com.bw.movie.utils;

import com.bw.movie.app.Api;
import com.bw.movie.app.ApiServer;
import com.bw.movie.app.App;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者:dongyanjun
 * 时间：2019/11/12
 * 描述:WMovie
 * 功能：
 **/
public class RetrofitUtil {
    private static ApiServer apiServer;
    private RetrofitUtil(){}
    public static ApiServer getApiServer(){
        if (apiServer == null) {
            synchronized (RetrofitUtil.class){
                if (apiServer == null) {
                    apiServer=new RetrofitUtil().getRetrofit();
                }
            }
        }
        return apiServer;
    }

    private ApiServer getRetrofit() {
        ApiServer apiServer = initRetrofit(initOKHttp()).create(ApiServer.class);
        return apiServer;
    }
    public Retrofit initRetrofit(OkHttpClient client){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
    public OkHttpClient initOKHttp(){
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(Api.DEFI_TIME, TimeUnit.SECONDS)
                .connectTimeout(Api.DEFI_TIME, TimeUnit.SECONDS)
                .writeTimeout(Api.DEFI_TIME, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        return httpClient;
    }
}
