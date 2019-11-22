package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapter.xQadapter.MyPqAdapter;
import com.bw.movie.adapter.xQadapter.MyXzZwAdapter;
import com.bw.movie.base.BaseActivity;
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

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class XzZwActivity extends BaseActivity implements HomeContract.Iview {


    private static final String TAG = "XzZwActivity";
    @BindView(R.id.zw_back)
    ImageView zwBack;
    @BindView(R.id.zw_til)
    TextView zwTil;
    @BindView(R.id.zw_JC)
    JCVideoPlayerStandard zwJC;
    @BindView(R.id.zw_xuan)
    RecyclerView zwXuan;
    @BindView(R.id.zw_ying)
    TextView zwYing;
    @BindView(R.id.zw_recycler_ying)
    RecyclerView zwRecyclerYing;
    @BindView(R.id.zw_price)
    TextView zwPrice;
    private HomePresenter homePresenter;
    private String userId = "13791";
    private String sessionId = "157356273084613791";
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_xz_zw;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        SharedPreferences dong = getSharedPreferences("dong", MODE_PRIVATE);
        String id1 = dong.getString("id", "");
        homePresenter.getXiangPresenter(userId, sessionId, id1);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onMessage(String id) {
        SharedPreferences dong = getSharedPreferences("dong", MODE_PRIVATE);
        String id1 = dong.getString("id", "");
        Log.d(TAG, "onMessage: "+id1);
        Log.d("EventBusCs", "onMessage: " + id);
        homePresenter.getPqPresenter(id1, id);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
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
        String message = data.getMessage();
        Log.d(TAG, "onXzZwSuccess: "+message);
        List<XzZwBean.ResultBean> result = data.getResult();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 6);
        zwXuan.setLayoutManager(gridLayoutManager);
        MyXzZwAdapter myXzZwAdapter = new MyXzZwAdapter(this,result);
        zwXuan.setAdapter(myXzZwAdapter);
        myXzZwAdapter.setOnItemClickListener(new MyXzZwAdapter.OnItemClickListener() {
            @Override
            public void onItem(String s) {
                //获取单个的电影票
                SharedPreferences dong = getSharedPreferences("dong", MODE_PRIVATE);
                String fare = dong.getString("fare", "");
                Log.d(TAG, "onItem: "+fare);
                Toast.makeText(XzZwActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
        myXzZwAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPqSuccess(PaiQIBean data) {
        String message = data.getMessage();
        Log.d(TAG, "onXzZwSuccess: " + message);
        List<PaiQIBean.ResultBean> result = data.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        zwRecyclerYing.setLayoutManager(linearLayoutManager);
        MyPqAdapter myPqAdapter = new MyPqAdapter(this, result);
        zwRecyclerYing.setAdapter(myPqAdapter);
        myPqAdapter.notifyDataSetChanged();
        myPqAdapter.setOnItemClickListener(new MyPqAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String id) {
                homePresenter.getXzZwPresenter(id);
            }
        });

    }

    @Override
    public void onXzMovieSuccess(XzMovieBean data) {

    }

    @Override
    public void onXqPlSuccess(XqPlBean data) {

    }

    @Override
    public void onXiangSuccess(XiangBean data) {
        String videoUrl = data.getResult().getShortFilmList().get(0).getVideoUrl();
        String imageUrl = data.getResult().getShortFilmList().get(0).getImageUrl();
        String name = data.getResult().getName();
        zwTil.setText(name);

        zwJC.setUp(videoUrl, JCVideoPlayer.SCREEN_LAYOUT_NORMAL, name);
        Glide.with(this).load(imageUrl).into(zwJC.thumbImageView);
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


    @OnClick({R.id.zw_back, R.id.zw_price})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zw_back:
                Intent intent = new Intent(XzZwActivity.this, ChooseActivity.class);
                startActivity(intent);
                break;
            case R.id.zw_price:
                break;
        }
    }
}
