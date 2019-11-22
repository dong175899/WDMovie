package com.bw.movie.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.view.SelfActivity;
import com.bw.movie.view.SheActivity;
import com.bw.movie.base.BaseFragment;

import me.jessyan.autosize.AutoSizeConfig;

/**
 * 作者:dongyanjun
 * 时间：2019/11/12
 * 描述:WMovie
 * 功能：
 **/
public class MyFrag extends BaseFragment {

    private ImageView img_shezhi;
    private ImageView img_xiangqing;
    private ImageView img_tou;
    private TextView tv_userName;

    @Override
    protected int getLayoutResId() {
        return R.layout.self_layout;
    }

    @Override
    protected void initView(View view) {
        img_shezhi = view.findViewById(R.id.img_shezhi);
        img_xiangqing = view.findViewById(R.id.img_xiangqing);
        img_tou = view.findViewById(R.id.img_tou);
        tv_userName = view.findViewById(R.id.tv_userName);

    }

    @Override
    protected void initData() {
        AutoSizeConfig.getInstance().setCustomFragment(true);
        SharedPreferences movie = getActivity().getSharedPreferences("movie", Context.MODE_PRIVATE);
        String name = movie.getString("name", "");
        String pic = movie.getString("pic", "");
        tv_userName.setText(name);
        Glide.with(getActivity()).load(pic)
                .circleCrop()
                .into(img_tou);
        img_xiangqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SelfActivity.class);
                startActivity(intent);
            }
        });
        img_shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SheActivity.class);
                startActivity(intent);
            }
});
    }
}
