package com.bw.movie.model;

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
import com.bw.movie.contract.HomeContract;
import com.bw.movie.utils.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * 作者:dongyanjun
 * 时间：2019/11/12
 * 描述:WMovie
 * 功能：
 **/
public class HomeModel implements HomeContract.Imodel{

    private Observable<LogBean> login;
    private Observer<LogBean> observer;
    private Observable<EmailBean> email1;
    private Observer<EmailBean> observer1;
    private Observable<RegBean> reg;
    private Observer<RegBean> observer2;
    private Observable<BannerBean> banner;
    private Observable<HotBean> hot;
    private Observable<ZhTopBean> zhTop;
    private Observable<MovieBean> movie;

    @Override
    public void getLoginDataModel(String email, String pwd, IModelLogCallback callback) {
        login = RetrofitUtil.getApiServer().LOGIN(email, pwd);
        observer = new Observer<LogBean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(LogBean logBean) {
                callback.onSuccess(logBean);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onFailure(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getMovieDataModel(String regionId, IModelMoCallback callback) {
        movie = RetrofitUtil.getApiServer().getMovie(regionId);
        Observer<MovieBean> observer = new Observer<MovieBean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(MovieBean movieBean) {
                callback.onSuccess(movieBean);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onFailure(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        movie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getXzZwModel(String hallId, IModelZwCallback callback) {
        Observable<XzZwBean> xzZw = RetrofitUtil.getApiServer().getXzZw(hallId);
        Observer<XzZwBean> observer = new Observer<XzZwBean>() {

            @Override
            public void onSubscribe(Disposable d) {

            }


            @Override
            public void onNext(XzZwBean xzZwBean) {
                callback.onSuccess(xzZwBean);
            }


            @Override
            public void onError(Throwable e) {
                callback.onFailure(e.getMessage());
            }


            @Override
            public void onComplete() {

            }
        };
        xzZw.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getPaiQiModel(String movieId, String cinemaId, IModelPqCallback callback) {
        Observable<PaiQIBean> pqData = RetrofitUtil.getApiServer().getPqData(movieId, cinemaId);
        Observer<PaiQIBean> observer = new Observer<PaiQIBean>() {

            @Override
            public void onSubscribe(Disposable d) {

            }


            @Override
            public void onNext(PaiQIBean paiQIBean) {
                callback.onSuccess(paiQIBean);
            }


            @Override
            public void onError(Throwable e) {
                callback.onFailure(e.getMessage());
            }


            @Override
            public void onComplete() {

            }
        };
        pqData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getBannerModel(IModelBanCallback callback) {
        banner = RetrofitUtil.getApiServer().getBanner();
        Observer<BannerBean> observer = new Observer<BannerBean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(BannerBean bannerBean) {
                callback.onSuccess(bannerBean);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onFailure(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        banner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getToDayModel(IModelDayCallback callback) {
        Observable<ToDayBean> toDay = RetrofitUtil.getApiServer().getToDay();
        Observer<ToDayBean> observer = new Observer<ToDayBean>() {

            @Override
            public void onSubscribe(Disposable d) {

            }


            @Override
            public void onNext(ToDayBean toDayBean) {
                    callback.onSuccess(toDayBean);
            }


            @Override
            public void onError(Throwable e) {
                callback.onFailure(e.getMessage());
            }


            @Override
            public void onComplete() {

            }
        };
        toDay.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getAssetsModel(IModelAssCallback callback) {
        Observable<AssetsBean> ass = RetrofitUtil.getApiServer().getAss();
        Observer<AssetsBean> observer = new Observer<AssetsBean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(AssetsBean assetsBean) {
                callback.onSuccess(assetsBean);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onFailure(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        ass.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getHotModel(String page, String count, IModelHotCallback callback) {
        hot = RetrofitUtil.getApiServer().getHot(page, count);
        Observer<HotBean> observer = new Observer<HotBean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(HotBean hotBean) {
                callback.onSuccess(hotBean);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onFailure(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        hot.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getZhTopModel(String page, String count, IModelZhTopCallback callback) {
        Observable<ZhTopBean> zhTop = RetrofitUtil.getApiServer().getZhTop(page, count);
        Observer<ZhTopBean> observer = new Observer<ZhTopBean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(ZhTopBean zhTopBean) {
                callback.onSuccess(zhTopBean);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onFailure(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        zhTop.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    @Override
    public void getJiTopModel(String userId, String sessionId, String page, String count, IModelJiCallback callback) {
        Observable<JiTopBean> jiTop = RetrofitUtil.getApiServer().getJiTop(userId, sessionId, page, count);
        Observer<JiTopBean> observer = new Observer<JiTopBean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(JiTopBean jiTopBean) {
                callback.onSuccess(jiTopBean);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onFailure(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        jiTop.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getTuipModel(String userId, String sessionId, String page, String count, IModelTuiCallback callback) {
        Observable<TuiBean> tui = RetrofitUtil.getApiServer().getTui(userId, sessionId, page, count);
        Observer<TuiBean> observer = new Observer<TuiBean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(TuiBean tuiBean) {
                callback.onSuccess(tuiBean);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onFailure(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        tui.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getXzMoVieModel(String movieId, String regionId, String page, String count, IModelXzCallback callback) {
        Observable<XzMovieBean> xzMovie = RetrofitUtil.getApiServer().getXzMovie(movieId, regionId, page, count);
        Observer<XzMovieBean> observer = new Observer<XzMovieBean>() {

            @Override
            public void onSubscribe(Disposable d) {

            }


            @Override
            public void onNext(XzMovieBean xzMovieBean) {
                callback.onSuccess(xzMovieBean);
            }


            @Override
            public void onError(Throwable e) {
                callback.onFailure(e.getMessage());
            }


            @Override
            public void onComplete() {

            }
        };
        xzMovie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getTimeModel(String movieId, String date, String page, String count, IModelTimeCallback callback) {
        Observable<XzTimeBena> timeData = RetrofitUtil.getApiServer().getTimeData(movieId, date, page, count);
        Observer<XzTimeBena> observer = new Observer<XzTimeBena>() {

            @Override
            public void onSubscribe(Disposable d) {

            }


            @Override
            public void onNext(XzTimeBena xzTimeBena) {
                    callback.onSuccess(xzTimeBena);
            }

            @Override
            public void onError(Throwable e) {
                    callback.onFailure(e.getMessage());
            }


            @Override
            public void onComplete() {

            }
        };
        timeData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getPriceModel(String movieId, String page, String count, IModelPriceCallback callback) {
        Observable<PriceMovieBean> priceData = RetrofitUtil.getApiServer().getPriceData(movieId, page, count);
        Observer<PriceMovieBean> observer = new Observer<PriceMovieBean>() {

            @Override
            public void onSubscribe(Disposable d) {

            }


            @Override
            public void onNext(PriceMovieBean priceMovieBean) {
                callback.onSuccess(priceMovieBean);
            }


            @Override
            public void onError(Throwable e) {
                callback.onFailure(e.getMessage());
            }


            @Override
            public void onComplete() {

            }
        };
        priceData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getFuJiModel(String userId, String sessionId, String page, String count, IModelFuCallback callback) {
        Observable<FuJiBean> fuJi = RetrofitUtil.getApiServer().getFuJi(userId, sessionId, page, count);
        Observer<FuJiBean> observer = new Observer<FuJiBean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(FuJiBean fuJiBean) {
                callback.onSuccess(fuJiBean);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onFailure(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        fuJi.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getXiangModel(String userId, String sessionId, String movieId, IModelXiangCallback callback) {
        Observable<XiangBean> xiang = RetrofitUtil.getApiServer().getXiang(userId, sessionId, movieId);
        Observer<XiangBean> observer = new Observer<XiangBean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(XiangBean xiangBean) {
                callback.onSuccess(xiangBean);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onFailure(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        xiang.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getXqPlModel(String userId, String sessionId, String movieId, String page, String count, IModelXqPlCallback callback) {
        Observable<XqPlBean> xqPl = RetrofitUtil.getApiServer().getXqPl(userId, sessionId, movieId, page, count);
        Observer<XqPlBean> observer = new Observer<XqPlBean>() {

            @Override
            public void onSubscribe(Disposable d) {

            }


            @Override
            public void onNext(XqPlBean xqPlBean) {
                callback.onSuccess(xqPlBean);
            }


            @Override
            public void onError(Throwable e) {
                callback.onFailure(e.getMessage());
            }


            @Override
            public void onComplete() {

            }
        };
        xqPl.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getEmailDataModel(String email, IModelEmailCallback callback) {
        email1 = RetrofitUtil.getApiServer().EMAIL(email);
        observer1 = new Observer<EmailBean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(EmailBean emailBean) {
                callback.onSuccess(emailBean);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onFailure(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        email1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer1);
    }

    @Override
    public void getRegisterDataModel(String nickName, String pwd, String email, String code, IModelRegCallback callback) {
        reg = RetrofitUtil.getApiServer().REG(nickName, pwd, email, code);
        observer2 = new Observer<RegBean>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(RegBean regBean) {
                callback.onSuccess(regBean);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onFailure(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        reg.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer2);
    }
}
