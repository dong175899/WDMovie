package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
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
import com.bw.movie.fragment.XqFrag.Xfrag1;
import com.bw.movie.fragment.XqFrag.Xfrag2;
import com.bw.movie.fragment.XqFrag.Xfrag3;
import com.bw.movie.fragment.XqFrag.Xfrag4;
import com.bw.movie.presenter.HomePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiangActivity extends BaseActivity implements HomeContract.Iview {


    private static final String TAG = "XiangActivity";
    @BindView(R.id.xq_image)
    SimpleDraweeView xqImage;
    @BindView(R.id.xq_pf)
    TextView xqPf;
    @BindView(R.id.xq_pl)
    TextView xqPl;
    @BindView(R.id.one)
    RelativeLayout one;
    @BindView(R.id.xq_name)
    TextView xqName;
    @BindView(R.id.xq_lx)
    TextView xqLx;
    @BindView(R.id.x1_time)
    TextView x1Time;
    @BindView(R.id.xq_shijian)
    TextView xqShijian;
    @BindView(R.id.xq_tab)
    TabLayout xqTab;
    @BindView(R.id.xq_pager)
    ViewPager xqPager;
    @BindView(R.id.xq_goupiao)
    Button xqGoupiao;
    @BindView(R.id.tv_text_yp)
    Button tvTextYp;
    private HomePresenter homePresenter;
    private String userId = "13791";
    private String sessionId = "157356273084613791";

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_xiang;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        SharedPreferences sp = getSharedPreferences("dong", MODE_PRIVATE);
        String id = sp.getString("id", "");
        Log.d(TAG, "initView: " + id);
        homePresenter.getXiangPresenter(userId, sessionId, id);
        xqGoupiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(XiangActivity.this, ChooseActivity.class);
                startActivity(intent);
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
        String message = data.getMessage();
        Log.d(TAG, "onXiangSuccess: " + message);
        String imageUrl = data.getResult().getImageUrl();
        Uri parse = Uri.parse(imageUrl);
        xqImage.setImageURI(parse);
        xqPf.setText(data.getResult().getScore());
        xqPl.setText(data.getResult().getCommentNum() + "万条");
        xqName.setText(data.getResult().getName());
        Date date = new Date(data.getResult().getReleaseTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        xqShijian.setText(simpleDateFormat.format(date) + "上映");
        xqLx.setText(data.getResult().getMovieType());
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Xfrag1());
        fragments.add(new Xfrag2());
        fragments.add(new Xfrag3());
        fragments.add(new Xfrag4());
        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return fragments.size();
            }

            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
        };
        xqPager.setAdapter(fragmentStatePagerAdapter);
        xqTab.setupWithViewPager(xqPager);
        xqTab.getTabAt(0).setText("介绍");
        xqTab.getTabAt(1).setText("预告");
        xqTab.getTabAt(2).setText("剧照");
        xqTab.getTabAt(3).setText("影评");

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



    @OnClick(R.id.tv_text_yp)
    public void onViewClicked() {
        Intent intent = new Intent(XiangActivity.this, YingPingActivity.class);
        startActivity(intent);
    }
}
