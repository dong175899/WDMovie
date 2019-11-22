package com.bw.movie.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.HotBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/12
 * 描述:WMovie
 * 功能：
 **/
public class MyHotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<HotBean.ResultBean> result;
    public MyHotAdapter(Context context, List<HotBean.ResultBean> hotResult) {
        this.context=context;
        this.result=hotResult;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hot_item, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).tv_name.setText(result.get(position).getName());
            ((ViewHolder1) holder).tv_ping.setText(result.get(position).getScore());
            ((ViewHolder1) holder).linear_three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String movieId = result.get(position).getMovieId();
                    Log.d("HotMovieAAA", "onClick: "+movieId);
                    //onItemClickListener.onItemClick(movieId);
                    onItemClickListener.onItemClick(movieId);
                }
            });
            Uri uri = Uri.parse(result.get(position).getImageUrl());
            ((ViewHolder1) holder).img_bi.setImageURI(uri);


        }
    }


    @Override
    public int getItemCount() {
        return result.size();
    }
   OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(String id);
    }
    private class ViewHolder1 extends RecyclerView.ViewHolder {


        private final TextView tv_name;
        private final TextView tv_ping;
        private final SimpleDraweeView img_bi;
        private final LinearLayout linear_three;

        public ViewHolder1(View view) {
            super(view);
            img_bi = view.findViewById(R.id.img_bi);
            tv_name = view.findViewById(R.id.tv_name);
            tv_ping = view.findViewById(R.id.tv_ping);
            linear_three = view.findViewById(R.id.linear_three);
        }
    }
}
