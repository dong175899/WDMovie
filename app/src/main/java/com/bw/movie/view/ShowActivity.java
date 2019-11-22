package com.bw.movie.view;


import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.fragment.MovieFrag;
import com.bw.movie.fragment.MyFrag;
import com.bw.movie.fragment.ShowFrag;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ShowActivity extends BaseActivity {


    @BindView(R.id.frag)
    FrameLayout frag;
    @BindView(R.id.text_dianying)
    TextView textDianying;
    @BindView(R.id.radio_dianying)
    RadioButton radioDianying;
    @BindView(R.id.text_yingyuan)
    TextView textYingyuan;
    @BindView(R.id.radio_yingyuan)
    RadioButton radioYingyuan;
    @BindView(R.id.text_wode)
    TextView textWode;
    @BindView(R.id.radio_wode)
    RadioButton radioWode;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    private ShowFrag showFrag;
    private MovieFrag movieFrag;
    private MyFrag myFrag;
    private FragmentManager supportFragmentManager;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_show;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        showFrag = new ShowFrag();
        movieFrag = new MovieFrag();
        myFrag = new MyFrag();
        supportFragmentManager = getSupportFragmentManager();
        textDianying.setVisibility(View.VISIBLE);
        textYingyuan.setVisibility(View.INVISIBLE);
        textWode.setVisibility(View.INVISIBLE);
        radioDianying.setChecked(true);
        radioYingyuan.setChecked(false);
        radioWode.setChecked(false);
        supportFragmentManager.beginTransaction()
                .add(R.id.frag,showFrag)
                .add(R.id.frag,movieFrag)
                .add(R.id.frag,myFrag)
                .show(showFrag)
                .hide(movieFrag)
                .hide(myFrag)
                .commit();
    }


    @OnClick({R.id.radio_dianying, R.id.radio_yingyuan, R.id.radio_wode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radio_dianying:
                textDianying.setVisibility(View.VISIBLE);
                textYingyuan.setVisibility(View.INVISIBLE);
                textWode.setVisibility(View.INVISIBLE);
                radioDianying.setChecked(true);
                radioYingyuan.setChecked(false);
                radioWode.setChecked(false);
                supportFragmentManager.beginTransaction()
                        .show(showFrag)
                        .hide(myFrag)
                        .hide(movieFrag)
                        .commit();
                break;
            case R.id.radio_yingyuan:
                textYingyuan.setVisibility(View.VISIBLE);
                textDianying.setVisibility(View.INVISIBLE);
                textWode.setVisibility(View.INVISIBLE);
                radioYingyuan.setChecked(true);
                radioDianying.setChecked(false);
                radioWode.setChecked(false);
                supportFragmentManager.beginTransaction()
                        .show(movieFrag)
                        .hide(myFrag)
                        .hide(showFrag)
                        .commit();
                break;
            case R.id.radio_wode:
                textWode.setVisibility(View.VISIBLE);
                textYingyuan.setVisibility(View.INVISIBLE);
                textDianying.setVisibility(View.INVISIBLE);
                radioWode.setChecked(true);
                radioYingyuan.setChecked(false);
                radioDianying.setChecked(false);
                supportFragmentManager.beginTransaction()
                        .show(myFrag)
                        .hide(movieFrag)
                        .hide(showFrag)
                        .commit();
                break;
        }
    }
}
