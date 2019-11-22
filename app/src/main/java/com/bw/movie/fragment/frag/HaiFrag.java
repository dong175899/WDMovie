package com.bw.movie.fragment.frag;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.MyAssetAdapter;
import com.bw.movie.adapter.MyMovieAdapter;
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

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/13
 * 描述:WMovie
 * 功能：
 **/
public class HaiFrag extends BaseFragment implements HomeContract.Iview {

    private RecyclerView recycler_asset;
    private RecyclerView recycler_movie;
    private HomePresenter homePresenter;

    @Override
    protected int getLayoutResId() {
        return R.layout.hai_layout;
    }

    @Override
    protected void initView(View view) {
        recycler_asset = view.findViewById(R.id.recycler_asset);
        recycler_movie = view.findViewById(R.id.recycler_movie);
    }

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        homePresenter.getAssetsPresenter();

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

    }

    @Override
    public void onMovieSuccess(MovieBean data){
        List<MovieBean.ResultBean> result = data.getResult();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recycler_movie.setLayoutManager(linearLayoutManager);
        MyMovieAdapter myMovieAdapter = new MyMovieAdapter(getActivity(),result);
        recycler_movie.setAdapter(myMovieAdapter);

    }

    @Override
    public void onZhTopSuccess(ZhTopBean data) {

    }

    @Override
    public void onJiSuccess(JiTopBean data) {

    }

    @Override
    public void onRegisterSuccess(RegBean data) {

    }

    @Override
    public void onBannerSuccess(BannerBean data) {

    }

    @Override
    public void onAssetsSuccess(AssetsBean data) {
        String message = data.getMessage();
        Log.d("AAA", "onAssetsSuccess: "+message);
        List<AssetsBean.ResultBean> result = data.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recycler_asset.setLayoutManager(linearLayoutManager);
        MyAssetAdapter myAssetAdapter = new MyAssetAdapter(getActivity(),result);
        recycler_asset.setAdapter(myAssetAdapter);
        myAssetAdapter.setOnItemClickListener(new MyAssetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String id,int position) {
                Log.d("SSS", "onItemClick: "+id);
                homePresenter.getMoviePresenter(id);
            }
        });
        myAssetAdapter.notifyDataSetChanged();
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
