package com.bw.movie.app;

import com.bw.movie.bean.AssetsBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.FuJiBean;
import com.bw.movie.bean.PaiQIBean;
import com.bw.movie.bean.PriceMovieBean;
import com.bw.movie.bean.ToDayBean;
import com.bw.movie.bean.TuiBean;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.JiTopBean;
import com.bw.movie.bean.LogBean;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.bean.RegBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.bean.XqPlBean;
import com.bw.movie.bean.XzMovieBean;
import com.bw.movie.bean.XzTimeBena;
import com.bw.movie.bean.XzZwBean;
import com.bw.movie.bean.ZhTopBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 作者:dongyanjun
 * 时间：2019/11/12
 * 描述:WMovie
 * 功能：
 **/
public interface ApiServer {
    @FormUrlEncoded
    @POST("movieApi/user/v2/sendOutEmailCode")
    Observable<EmailBean> EMAIL(@Field("email") String email);

    //注册
    @FormUrlEncoded
    @POST("movieApi/user/v2/register")
    Observable<RegBean> REG(@Field("nickName") String nickName, @Field("pwd") String pwd, @Field("email") String email, @Field("code") String code);

    //登录
    @FormUrlEncoded
    @POST("movieApi/user/v2/login")
    Observable<LogBean> LOGIN(@Field("email") String email, @Field("pwd") String pwd);

    @GET("movieApi/tool/v2/banner")
    Observable<BannerBean> getBanner();
    @GET("movieApi/movie/v2/findReleaseMovieList")
    Observable<HotBean> getHot(@Query("page")String page,@Query("count") String count);
    @GET("movieApi/movie/v2/findComingSoonMovieList")
    Observable<JiTopBean> getJiTop(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("page")String page, @Query("count") String count);

    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<ZhTopBean> getZhTop(@Query("page")String page, @Query("count") String count);
    @GET("movieApi/tool/v2/findRegionList")
    Observable<AssetsBean> getAss();
    @GET("movieApi/cinema/v2/findCinemaByRegion")
    Observable<MovieBean> getMovie(@Query("regionId")String regionId);

    @GET("movieApi/cinema/v1/findRecommendCinemas")
    Observable<TuiBean> getTui(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("page")String page, @Query("count") String count);
    @GET("movieApi/cinema/v1/findNearbyCinemas")
    Observable<FuJiBean> getFuJi(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("page")String page, @Query("count") String count);
    @GET("movieApi/movie/v2/findMoviesDetail")
    Observable<XiangBean> getXiang(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("movieId")String movieId);
    @GET("movieApi/movie/v2/findAllMovieComment")
    Observable<XqPlBean> getXqPl(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("movieId")String movieId,@Query("page")String page, @Query("count") String count);
    @GET("movieApi/movie/v2/findCinemasInfoByRegion")
    Observable<XzMovieBean> getXzMovie(@Query("movieId")String movieId, @Query("regionId") String regionId,@Query("page")String page, @Query("count") String count);
    @GET("movieApi/movie/v2/findSeatInfo")
    Observable<XzZwBean> getXzZw(@Query("hallId") String hallId);
    @GET("movieApi/movie/v2/findMovieSchedule")
    Observable<PaiQIBean> getPqData(@Query("movieId") String movieId,@Query("cinemaId") String cinemaId);
    @GET("movieApi/movie/v2/findCinemasInfoByDate")
    Observable<XzTimeBena> getTimeData(@Query("movieId") String movieId, @Query("date") String date,@Query("page")String page, @Query("count") String count);
    @GET("movieApi/tool/v2/findDateList")
    Observable<ToDayBean> getToDay();
    @GET("movieApi/movie/v2/findCinemasInfoByPrice")
    Observable<PriceMovieBean> getPriceData(@Query("movieId") String movieId,@Query("page")String page, @Query("count") String count);
}
