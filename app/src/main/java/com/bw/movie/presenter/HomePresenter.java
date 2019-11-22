package com.bw.movie.presenter;

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
import com.bw.movie.model.HomeModel;

import java.lang.ref.WeakReference;

/**
 * 作者:dongyanjun
 * 时间：2019/11/12
 * 描述:WMovie
 * 功能：
 **/
public class HomePresenter implements HomeContract.Ipresenter{

    private HomeModel homeModel;
    private WeakReference<HomeContract.Iview> iviewWeakReference;

    @Override
    public void attachView(HomeContract.Iview iview) {
        homeModel = new HomeModel();
        iviewWeakReference = new WeakReference<>(iview);
    }
    public HomeContract.Iview getView(){
        return iviewWeakReference.get();
    }

    @Override
    public void detachView() {
        if (iviewWeakReference!=null) {
            iviewWeakReference.clear();
            iviewWeakReference=null;
        }
    }

    @Override
    public void getLoginPresenter(String email, String pwd) {
        homeModel.getLoginDataModel(email, pwd, new HomeContract.Imodel.IModelLogCallback() {
            @Override
            public void onSuccess(LogBean data) {
                getView().onLoginSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                    getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getEmailPresenter(String email) {
        homeModel.getEmailDataModel(email, new HomeContract.Imodel.IModelEmailCallback() {
            @Override
            public void onSuccess(EmailBean data) {
                getView().onEmailSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getXzZwPresenter(String hallId) {
        homeModel.getXzZwModel(hallId, new HomeContract.Imodel.IModelZwCallback() {
            @Override
            public void onSuccess(XzZwBean data) {
                getView().onXzZwSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getPqPresenter(String movieId, String cinemaId) {
        homeModel.getPaiQiModel(movieId, cinemaId, new HomeContract.Imodel.IModelPqCallback() {
            @Override
            public void onSuccess(PaiQIBean data) {
                getView().onPqSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getBannerPresenter() {
        homeModel.getBannerModel(new HomeContract.Imodel.IModelBanCallback() {
            @Override
            public void onSuccess(BannerBean data) {
                getView().onBannerSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getToDayPresenter() {
        homeModel.getToDayModel(new HomeContract.Imodel.IModelDayCallback() {
            @Override
            public void onSuccess(ToDayBean data) {
                getView().onToDaytSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getHotPresenter(String page, String count) {
        homeModel.getHotModel(page, count, new HomeContract.Imodel.IModelHotCallback() {
            @Override
            public void onSuccess(HotBean data) {
                getView().onHotSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getMoviePresenter(String regionId) {
        homeModel.getMovieDataModel(regionId, new HomeContract.Imodel.IModelMoCallback() {
            @Override
            public void onSuccess(MovieBean data) {
                getView().onMovieSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getZhTopPresenter(String page, String count) {
        homeModel.getZhTopModel(page, count, new HomeContract.Imodel.IModelZhTopCallback() {
            @Override
            public void onSuccess(ZhTopBean data) {
                getView().onZhTopSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getJiTopPresenter(String userId, String sessionId, String page, String count) {
        homeModel.getJiTopModel(userId, sessionId, page, count, new HomeContract.Imodel.IModelJiCallback() {
            @Override
            public void onSuccess(JiTopBean data) {
                getView().onJiSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getTuiPresenter(String userId, String sessionId, String page, String count) {
        homeModel.getTuipModel(userId, sessionId, page, count, new HomeContract.Imodel.IModelTuiCallback() {
            @Override
            public void onSuccess(TuiBean data) {
                getView().onTuiSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getFuJiPresenter(String userId, String sessionId, String page, String count) {
        homeModel.getFuJiModel(userId, sessionId, page, count, new HomeContract.Imodel.IModelFuCallback() {
            @Override
            public void onSuccess(FuJiBean data) {
                getView().onFujiSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getXiangPresenter(String userId, String sessionId, String movieId) {
        homeModel.getXiangModel(userId, sessionId, movieId, new HomeContract.Imodel.IModelXiangCallback() {
            @Override
            public void onSuccess(XiangBean data) {
                getView().onXiangSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getRegisterPresenter(String nickName, String pwd, String email, String code) {
        homeModel.getRegisterDataModel(nickName, pwd, email, code, new HomeContract.Imodel.IModelRegCallback() {
            @Override
            public void onSuccess(RegBean data) {
                getView().onRegisterSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getAssetsPresenter() {
        homeModel.getAssetsModel(new HomeContract.Imodel.IModelAssCallback() {
            @Override
            public void onSuccess(AssetsBean data) {
                getView().onAssetsSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getXqPlPresenter(String userId, String sessionId, String movieId, String page, String count) {
        homeModel.getXqPlModel(userId, sessionId, movieId, page, count, new HomeContract.Imodel.IModelXqPlCallback() {
            @Override
            public void onSuccess(XqPlBean data) {
                getView().onXqPlSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getXzMoviePresenter(String movieId, String regionId, String page, String count) {
        homeModel.getXzMoVieModel(movieId, regionId, page, count, new HomeContract.Imodel.IModelXzCallback() {
            @Override
            public void onSuccess(XzMovieBean data) {
                getView().onXzMovieSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getTimePresenter(String movieId, String date, String page, String count) {
        homeModel.getTimeModel(movieId, date, page, count, new HomeContract.Imodel.IModelTimeCallback() {
            @Override
            public void onSuccess(XzTimeBena data) {
                getView().onTimeSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getPricePresenter(String movieId, String page, String count) {
        homeModel.getPriceModel(movieId, page, count, new HomeContract.Imodel.IModelPriceCallback() {
            @Override
            public void onSuccess(PriceMovieBean data) {
                getView().onPriceSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeError(e);
            }
        });
    }
}
