package com.bw.movie.adapter;

import android.content.Context;
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
import com.bw.movie.bean.JiTopBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/12
 * 描述:WMovie
 * 功能：
 **/
public class MyJiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<JiTopBean.ResultBean> result;
    public MyJiAdapter(Context context, List<JiTopBean.ResultBean> jiResult) {
        this.context=context;
        this.result=jiResult;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ji_item, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).tv_name.setText(result.get(position).getName());
            Date date = new Date(result.get(position).getReleaseTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd");
            ((ViewHolder1) holder).tv_data.setText(simpleDateFormat.format(date)+"上映");
            ((ViewHolder1) holder).tv_look.setText(result.get(position).getWantSeeNum());
            ((ViewHolder1) holder).img_bi.setImageURI(result.get(position).getImageUrl());
            ((ViewHolder1) holder).linear_two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String movieId = result.get(position).getMovieId();
                    onItemClickListener.onItemClick(movieId);
                }
            });
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
        private final SimpleDraweeView img_bi;
        private final TextView tv_name;
        private final TextView tv_data;
        private final TextView tv_look;
        private final LinearLayout linear_two;

        public ViewHolder1(View view) {
            super(view);
            img_bi = view.findViewById(R.id.img_bi);
            tv_name = view.findViewById(R.id.tv_name);
            tv_data = view.findViewById(R.id.tv_data);
            tv_look = view.findViewById(R.id.tv_look);
            linear_two = view.findViewById(R.id.linear_two);
        }
    }
}
