package com.bw.movie.fragment.XqFrag;

import android.content.SharedPreferences;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.xQadapter.MyXqPlAdapter;
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
 * 时间：2019/11/18
 * 描述:WMovie
 * 功能：
 **/
public class Xfrag4 extends BaseFragment implements HomeContract.Iview {

    private RecyclerView xq_ry_yp;
    private HomePresenter homePresenter;
    private String userId = "13791";
    private String sessionId = "157356273084613791";
    @Override
    protected int getLayoutResId() {
        return R.layout.xqfrag4;
    }

    @Override
    protected void initView(View view) {
        xq_ry_yp = view.findViewById(R.id.xq_ry_yp);
    }

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        SharedPreferences sp = getActivity().getSharedPreferences("dong", getActivity().MODE_PRIVATE);
        String id = sp.getString("id", "");
        homePresenter.getXqPlPresenter(userId,sessionId,id,"1","5");
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
        List<XqPlBean.ResultBean> result = data.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        xq_ry_yp.setLayoutManager(linearLayoutManager);
        MyXqPlAdapter myXqPlAdapter = new MyXqPlAdapter(getActivity(),result);
        xq_ry_yp.setAdapter(myXqPlAdapter);
    }

    @Override
    public void onXiangSuccess(XiangBean data) {

    }

    @Override
    public void onHotSuccess(HotBean data) {

    }

    @Override
    public void onMovieSuccess(MovieBean data) {

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
