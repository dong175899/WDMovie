package com.bw.movie.fragment.XqFrag;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.xQadapter.MyXiangDaoAdapter;
import com.bw.movie.adapter.xQadapter.MyXiangYanAdapter;
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

import butterknife.BindView;

/**
 * 作者:dongyanjun
 * 时间：2019/11/18
 * 描述:WMovie
 * 功能：
 **/
public class Xfrag1 extends BaseFragment implements HomeContract.Iview {
  ;
    private TextView js_jian,js_daoyan,js_yanyuan;
    private RecyclerView js_recydy,js_recyyy;
    private HomePresenter homePresenter;
    private String userId = "13791";
    private String sessionId = "157356273084613791";
    @Override
    protected int getLayoutResId() {
        return R.layout.xqfrag1;
    }

    @Override
    protected void initView(View view) {
        js_jian = view.findViewById(R.id.js_jian);
        js_daoyan = view.findViewById(R.id.js_daoyan);
        js_yanyuan = view.findViewById(R.id.js_yanyuan);
        js_recydy = view.findViewById(R.id.js_recydy);
        js_recyyy = view.findViewById(R.id.js_recyyy);
    }

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        SharedPreferences sp = getActivity().getSharedPreferences("dong", getActivity().MODE_PRIVATE);
        String id = sp.getString("id", "");
        Log.d("AAAAAA", "initView: " + id);
        homePresenter.getXiangPresenter(userId,sessionId,id);
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
       js_jian.setText(data.getResult().getSummary());

        List<XiangBean.ResultBean.MovieActorBean> movieActor = data.getResult().getMovieActor();
        List<XiangBean.ResultBean.MovieDirectorBean> movieDirector = data.getResult().getMovieDirector();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        js_recyyy.setLayoutManager(gridLayoutManager);
        MyXiangYanAdapter myXiangYanAdapter = new MyXiangYanAdapter(getActivity(),movieActor);
        js_recyyy.setAdapter(myXiangYanAdapter);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getActivity(), 4);
        js_recydy.setLayoutManager(gridLayoutManager1);
        MyXiangDaoAdapter myXiangDaoAdapter = new MyXiangDaoAdapter(getActivity(),movieDirector);
        js_recydy.setAdapter(myXiangDaoAdapter);

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
