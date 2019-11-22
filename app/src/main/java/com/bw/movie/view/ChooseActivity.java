package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapter.MyAssetAdapter;
import com.bw.movie.adapter.MyDayAdapter;
import com.bw.movie.adapter.xQadapter.MyPriceMoVieAdapter;
import com.bw.movie.adapter.xQadapter.MyXzMoAdapter;
import com.bw.movie.adapter.xQadapter.MyXzTimeAdapter;
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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ChooseActivity extends BaseActivity implements HomeContract.Iview {


    @BindView(R.id.xz_video_play)
    JCVideoPlayerStandard xzVideoPlay;
    @BindView(R.id.xz_tv_name)
    TextView xzTvName;
    @BindView(R.id.xz_tv_time)
    TextView xzTvTime;
    @BindView(R.id.xz_tv_pf)
    TextView xzTvPf;
    @BindView(R.id.xz_tv_dy)
    TextView xzTvDy;
    @BindView(R.id.xz_tv_address)
    TextView xzTvAddress;
    @BindView(R.id.xz_tv_day)
    TextView xzTvDay;
    @BindView(R.id.xz_tv_price)
    TextView xzTvPrice;
    @BindView(R.id.xz_recycler_address)
    RecyclerView xzRecyclerAddress;
    @BindView(R.id.xz_recycler)
    RecyclerView xzRecycler;
    @BindView(R.id.xz_recycler_toDay)
    RecyclerView xzRecyclerToDay;

    private HomePresenter homePresenter;
    private String userId = "13791";
    private String sessionId = "157356273084613791";
    private String id1;
    private SharedPreferences sp;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_choose;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        xzTvPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePresenter.getPricePresenter(id1,"1","5");
            }
        });
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        homePresenter.getAssetsPresenter();
        sp = getSharedPreferences("dong", MODE_PRIVATE);
        id1 = sp.getString("id", "");
        homePresenter.getXiangPresenter(userId, sessionId, id1);
        homePresenter.getToDayPresenter();
    }

    @Override
    public void onLoginSuccess(LogBean data) {

    }

    @Override
    public void onPriceSuccess(PriceMovieBean data) {
        List<PriceMovieBean.ResultBean> result = data.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xzRecyclerAddress.setLayoutManager(linearLayoutManager);
        MyPriceMoVieAdapter myPriceMoVieAdapter = new MyPriceMoVieAdapter(this,result);
        xzRecyclerAddress.setAdapter(myPriceMoVieAdapter);
        myPriceMoVieAdapter.setOnItemClickListener(new MyPriceMoVieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String cinemaId) {
                EventBus.getDefault().postSticky(cinemaId);
                Intent intent = new Intent(ChooseActivity.this, XzZwActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onToDaytSuccess(ToDayBean data) {
        List<String> result = data.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xzRecyclerToDay.setLayoutManager(linearLayoutManager);
        MyDayAdapter myDayAdapter = new MyDayAdapter(this, result);
        xzRecyclerToDay.setAdapter(myDayAdapter);
        xzTvDay.setText("今天" + data.getResult().get(0));
        xzTvDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xzRecyclerToDay.setVisibility(View.VISIBLE);
            }
        });
        myDayAdapter.setOnItemClickListener(new MyDayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String id, int position) {
                xzTvDay.setText(data.getResult().get(position));
                Log.d("ToDayClick", "onItemClick: " + id);
                homePresenter.getTimePresenter(id1, id, "1", "7");
                xzRecyclerToDay.setVisibility(View.INVISIBLE);
            }
        });
        myDayAdapter.notifyDataSetChanged();

    }

    @Override
    public void onTimeSuccess(XzTimeBena data) {
        String message = data.getMessage();
        Log.d("DOK", "onXzMovieSuccess: " + message);
        List<XzTimeBena.ResultBean> result = data.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xzRecyclerAddress.setLayoutManager(linearLayoutManager);
        MyXzTimeAdapter myXzMoAdapter = new MyXzTimeAdapter(this, result);
        xzRecyclerAddress.setAdapter(myXzMoAdapter);
        myXzMoAdapter.setOnItemClickListener(new MyXzTimeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String cinemaId) {
                EventBus.getDefault().postSticky(cinemaId);
                Intent intent = new Intent(ChooseActivity.this, XzZwActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onXzZwSuccess(XzZwBean data) {

    }

    @Override
    public void onPqSuccess(PaiQIBean data) {

    }

    @Override
    public void onXzMovieSuccess(XzMovieBean data) {
        String message = data.getMessage();
        Log.d("DOK", "onXzMovieSuccess: " + message);
        List<XzMovieBean.ResultBean> result = data.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xzRecyclerAddress.setLayoutManager(linearLayoutManager);
        MyXzMoAdapter myXzMoAdapter = new MyXzMoAdapter(this, result);
        xzRecyclerAddress.setAdapter(myXzMoAdapter);
        myXzMoAdapter.setOnItemClickListener(new MyXzMoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String cinemaId) {
                EventBus.getDefault().postSticky(cinemaId);
                Intent intent = new Intent(ChooseActivity.this, XzZwActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onXqPlSuccess(XqPlBean data) {

    }

    @Override
    public void onXiangSuccess(XiangBean data) {
        String name = data.getResult().getName();
        String score = data.getResult().getScore();
        String name1 = data.getResult().getMovieDirector().get(0).getName();
        String duration = data.getResult().getDuration();
        String imageUrl = data.getResult().getShortFilmList().get(0).getImageUrl();
        String videoUrl = data.getResult().getShortFilmList().get(0).getVideoUrl();
        xzTvName.setText(name);
        xzTvTime.setText(duration + "分钟");
        xzTvPf.setText(score + "评分");
        xzTvDy.setText(name1);
        xzVideoPlay.setUp(videoUrl, JCVideoPlayer.SCREEN_LAYOUT_NORMAL, name);
        Glide.with(this).load(imageUrl).into(xzVideoPlay.thumbImageView);
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
        List<AssetsBean.ResultBean> result = data.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xzRecycler.setLayoutManager(linearLayoutManager);
        MyAssetAdapter myAssetAdapter = new MyAssetAdapter(this, result);
        xzRecycler.setAdapter(myAssetAdapter);
        xzTvAddress.setText(data.getResult().get(0).getRegionName());
        myAssetAdapter.setOnItemClickListener(new MyAssetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String id, int position) {
                Log.d("SSS", "onItemClick: " + id);
                xzTvAddress.setText(data.getResult().get(position).getRegionName());
                Log.d("MoVieId", "initData: " + id);
                homePresenter.getXzMoviePresenter(id1, id, "1", "5");
                xzRecycler.setVisibility(View.INVISIBLE);
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


    @OnClick(R.id.xz_tv_address)
    public void onViewClicked() {
        xzTvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            xzRecycler.setVisibility(View.VISIBLE);
            }
        });
    }



}
