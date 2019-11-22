package com.bw.movie.adapter.xQadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.bean.XqPlBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * 作者:dongyanjun
 * 时间：2019/11/19
 * 描述:WMovie
 * 功能：
 **/
public class MyXqYgAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    XiangBean.ResultBean shortFilmList;
    public MyXqYgAdapter(Context context, XiangBean.ResultBean shortFilmList) {
        this.context=context;
        this.shortFilmList=shortFilmList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_xq_yg, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            Log.d("AAAA", "onBindViewHolder: "+shortFilmList.getShortFilmList().get(position).getVideoUrl());

            ((ViewHolder1) holder).video_play.setUp(shortFilmList.getShortFilmList().get(position).getVideoUrl(),JCVideoPlayer.SCREEN_LAYOUT_NORMAL,shortFilmList.getName());
            Glide.with(context).load(shortFilmList.getShortFilmList().get(position).getImageUrl()).into(((ViewHolder1) holder).video_play.thumbImageView);
        }
    }


    @Override
    public int getItemCount() {
        return shortFilmList.getShortFilmList().size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {


        private final JCVideoPlayerStandard video_play;

        public ViewHolder1(View view) {
            super(view);
            video_play = view.findViewById(R.id.video_play);

        }
    }
}
