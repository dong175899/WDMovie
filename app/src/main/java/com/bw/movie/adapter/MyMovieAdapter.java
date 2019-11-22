package com.bw.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.MovieBean;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/13
 * 描述:WMovie
 * 功能：
 **/
public class MyMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<MovieBean.ResultBean> result;
    public MyMovieAdapter(FragmentActivity activity, List<MovieBean.ResultBean> result) {
        this.context=activity;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.assets_item, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).tv_assets.setText(result.get(position).getName());
        }
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView tv_assets;

        public ViewHolder1(View view) {
            super(view);
            tv_assets = view.findViewById(R.id.tv_assets);
        }
    }
}
