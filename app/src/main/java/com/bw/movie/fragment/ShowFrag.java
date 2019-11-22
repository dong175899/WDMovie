package com.bw.movie.fragment;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapter.HomeAdapter;
import com.bw.movie.adapter.MyHotAdapter;
import com.bw.movie.adapter.MyJiAdapter;
import com.bw.movie.adapter.MyZhTopAdapter;
import com.bw.movie.app.App;
import com.bw.movie.base.BaseFragment;
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
import com.bw.movie.presenter.HomePresenter;

import com.bw.movie.view.XiangActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;


import java.util.AbstractList;
import java.util.List;

import me.jessyan.autosize.AutoSizeConfig;


/**
 * 作者:dongyanjun
 * 时间：2019/11/12
 * 描述:WMovie
 * 功能：
 **/
public class ShowFrag extends BaseFragment implements HomeContract.Iview {

    private static final String TAG = "ShowFrag";

    private HomePresenter homePresenter;

    private String userId="13791";
    private String sessionId="157356273084613791";
    private XRecyclerView x_recycler;
    private List<HotBean.ResultBean> hotResult;
    private List<ZhTopBean.ResultBean> zhResult;
    private HomeAdapter homeAdapter;
    private List<BannerBean.ResultBean> banResult;
    private List<JiTopBean.ResultBean> jiResult;

    @Override
    protected int getLayoutResId() {
        return R.layout.show_layout;
    }

    @Override
    protected void initView(View view) {
        x_recycler = view.findViewById(R.id.x_recycler);
    }

    @Override
    protected void initData() {
        AutoSizeConfig.getInstance().setCustomFragment(true);
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        x_recycler.setLayoutManager(linearLayoutManager);
        homePresenter.getBannerPresenter();

        homePresenter.getHotPresenter("1","5");
        homePresenter.getJiTopPresenter(userId,sessionId,"1","5");
        homePresenter.getZhTopPresenter("1","5");
        x_recycler.setLoadingMoreEnabled(true);
        x_recycler.setPullRefreshEnabled(true);
        x_recycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                x_recycler.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                x_recycler.loadMoreComplete();
            }
        });

    }

    @Override
    public void onLoginSuccess(LogBean data) {

    }

    @Override
    public void onPriceSuccess(PriceMovieBean data) {

    }

    @Override
    public void onToDaytSuccess(ToDayBean data) {

    }

    @Override
    public void onTimeSuccess(XzTimeBena data) {

    }

    @Override
    public void onXzZwSuccess(XzZwBean data) {

    }

    @Override
    public void onPqSuccess(PaiQIBean data) {

    }

    @Override
    public void onXzMovieSuccess(XzMovieBean data) {

    }

    @Override
    public void onXqPlSuccess(XqPlBean data) {

    }

    @Override
    public void onXiangSuccess(XiangBean data) {

    }

    @Override
    public void onHotSuccess(HotBean data) {
        hotResult = data.getResult();
        homeAdapter = new HomeAdapter(getActivity(), hotResult,jiResult,zhResult,banResult);
        x_recycler.setAdapter(homeAdapter);

    }

    @Override
    public void onMovieSuccess(MovieBean data) {

    }

    @Override
    public void onZhTopSuccess(ZhTopBean data) {
        zhResult = data.getResult();
        homeAdapter = new HomeAdapter(getActivity(), hotResult,jiResult,zhResult,banResult);
        x_recycler.setAdapter(homeAdapter);

    }

    @Override
    public void onJiSuccess(JiTopBean data) {
        jiResult = data.getResult();
        homeAdapter = new HomeAdapter(getActivity(), hotResult,jiResult,zhResult,banResult);
        x_recycler.setAdapter(homeAdapter);
    }

    @Override
    public void onRegisterSuccess(RegBean data) {

    }

    @Override
    public void onBannerSuccess(BannerBean data) {
        banResult = data.getResult();
        homeAdapter = new HomeAdapter(getActivity(), hotResult,jiResult,zhResult,banResult);
        x_recycler.setAdapter(homeAdapter);
    }


    @Override
    public void onAssetsSuccess(AssetsBean data) {

    }

    @Override
    public void onEmailSuccess(EmailBean data) {

    }

    @Override
    public void onTuiSuccess(TuiBean data) {

    }

    @Override
    public void onFujiSuccess(FuJiBean data) {

    }

    @Override
    public void onHomeError(String e) {

    }
}
