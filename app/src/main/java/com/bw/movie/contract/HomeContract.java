package com.bw.movie.contract;

import com.bw.movie.bean.AssetsBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.FuJiBean;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.JiTopBean;
import com.bw.movie.bean.LogBean;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.bean.PaiQIBean;
import com.bw.movie.bean.PriceMovieBean;
import com.bw.movie.bean.RegBean;
import com.bw.movie.bean.ToDayBean;
import com.bw.movie.bean.TuiBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.bean.XqPlBean;
import com.bw.movie.bean.XzMovieBean;
import com.bw.movie.bean.XzTimeBena;
import com.bw.movie.bean.XzZwBean;
import com.bw.movie.bean.ZhTopBean;

/**
 * 作者:dongyanjun
 * 时间：2019/11/12
 * 描述:WMovie
 * 功能：
 **/
public interface HomeContract {
    interface Iview{
        void onLoginSuccess(LogBean data);
        void onPriceSuccess(PriceMovieBean data);
        void onToDaytSuccess(ToDayBean data);
        void onTimeSuccess(XzTimeBena data);
        void onXzZwSuccess(XzZwBean data);
        void onPqSuccess(PaiQIBean data);
        void onXzMovieSuccess(XzMovieBean data);
        void onXqPlSuccess(XqPlBean data);
        void onXiangSuccess(XiangBean data);
        void onHotSuccess(HotBean data);
        void onMovieSuccess(MovieBean data);
        void onZhTopSuccess(ZhTopBean data);
        void onJiSuccess(JiTopBean data);
        void onRegisterSuccess(RegBean data);
        void onBannerSuccess(BannerBean data);
        void onAssetsSuccess(AssetsBean data);
        void onEmailSuccess(EmailBean data);
        void onTuiSuccess(TuiBean data);
        void onFujiSuccess(FuJiBean data);
        void onHomeError(String e);
    }
   interface Imodel{
       void getLoginDataModel(String email,String pwd, IModelLogCallback callback);
       void getMovieDataModel(String regionId, IModelMoCallback callback);
       void getXzZwModel(String hallId, IModelZwCallback callback);
       void getPaiQiModel(String movieId,String cinemaId, IModelPqCallback callback);
       void getBannerModel(IModelBanCallback callback);
       void getToDayModel(IModelDayCallback callback);
       void getAssetsModel(IModelAssCallback callback);
       void getHotModel(String page,String count,IModelHotCallback callback);
       void getZhTopModel(String page,String count,IModelZhTopCallback callback);
       void getJiTopModel(String userId,String sessionId,String page,String count,IModelJiCallback callback);
       void getTuipModel(String userId,String sessionId,String page,String count,IModelTuiCallback callback);
       void getXzMoVieModel(String movieId,String regionId,String page,String count,IModelXzCallback callback);
       void getTimeModel(String movieId,String date,String page,String count,IModelTimeCallback callback);
       void getPriceModel(String movieId,String page,String count,IModelPriceCallback callback);
       void getFuJiModel(String userId,String sessionId,String page,String count,IModelFuCallback callback);
       void getXiangModel(String userId,String sessionId,String movieId,IModelXiangCallback callback);
       void getXqPlModel(String userId,String sessionId,String movieId,String page,String count,IModelXqPlCallback callback);
       void getEmailDataModel(String email, IModelEmailCallback callback);
       void getRegisterDataModel(String nickName, String pwd, String email,String code,IModelRegCallback callback);

       interface IModelLogCallback {
           void onSuccess(LogBean data);

           void onFailure(String e);
       }

       interface IModelEmailCallback {
           void onSuccess(EmailBean data);

           void onFailure(String e);
       }

       interface IModelRegCallback {
           void onSuccess(RegBean data);

           void onFailure(String e);
       }

       interface IModelBanCallback {
           void onSuccess(BannerBean data);

           void onFailure(String e);
       }

       interface IModelHotCallback {
           void onSuccess(HotBean data);

           void onFailure(String e);
       }

       interface IModelJiCallback {
           void onSuccess(JiTopBean data);

           void onFailure(String e);
       }

       interface IModelZhTopCallback {
           void onSuccess(ZhTopBean data);

           void onFailure(String e);
       }

       interface IModelAssCallback {
           void onSuccess(AssetsBean data);

           void onFailure(String e);
       }

       interface IModelMoCallback {
           void onSuccess(MovieBean data);

           void onFailure(String e);
       }

       interface IModelTuiCallback {
           void onSuccess(TuiBean data);

           void onFailure(String e);
       }

       interface IModelFuCallback {
           void onSuccess(FuJiBean data);

           void onFailure(String e);
       }

       interface IModelXiangCallback {
           void onSuccess(XiangBean data);

           void onFailure(String e);
       }

       interface IModelXqPlCallback {
           void onSuccess(XqPlBean data);

           void onFailure(String e);
       }

       interface IModelXzCallback {
           void onSuccess(XzMovieBean data);

           void onFailure(String e);
       }

       interface IModelZwCallback {
           void onSuccess(XzZwBean data);

           void onFailure(String e);
       }

       interface IModelPqCallback {
           void onSuccess(PaiQIBean data);

           void onFailure(String e);
       }

       interface IModelTimeCallback {
           void onSuccess(XzTimeBena data);

           void onFailure(String e);
       }

       interface IModelDayCallback {
           void onSuccess(ToDayBean data);

           void onFailure(String e);
       }

       interface IModelPriceCallback {
           void onSuccess(PriceMovieBean data);

           void onFailure(String e);
       }
   }
    interface Ipresenter{
        void attachView(HomeContract.Iview iview);
        void detachView();
        void getLoginPresenter(String email,String pwd);
        void getEmailPresenter(String email);
        void getXzZwPresenter(String hallId);
        void getPqPresenter(String movieId,String cinemaId);
        void getBannerPresenter();
        void getToDayPresenter();
        void getHotPresenter(String page,String count);
        void getMoviePresenter(String regionId);
        void getZhTopPresenter(String page,String count);
        void getJiTopPresenter(String userId,String sessionId,String page,String count);
        void getTuiPresenter(String userId,String sessionId,String page,String count);
        void getFuJiPresenter(String userId,String sessionId,String page,String count);
        void getXiangPresenter(String userId,String sessionId,String movieId);
        void getRegisterPresenter(String nickName, String pwd, String email,String code);
        void getAssetsPresenter();
        void getXqPlPresenter(String userId,String sessionId,String movieId,String page,String count);
        void getXzMoviePresenter(String movieId,String regionId,String page,String count);
        void getTimePresenter(String movieId,String date,String page,String count);
        void getPricePresenter(String movieId,String page,String count);
    }
}
