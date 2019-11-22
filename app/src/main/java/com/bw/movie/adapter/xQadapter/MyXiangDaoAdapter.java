package com.bw.movie.adapter.xQadapter;

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
import com.bw.movie.bean.XiangBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/18
 * 描述:WMovie
 * 功能：
 **/
public class MyXiangDaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<XiangBean.ResultBean.MovieDirectorBean> movieDirector;
    public MyXiangDaoAdapter(Context context, List<XiangBean.ResultBean.MovieDirectorBean> movieDirector) {
        this.context=context;
        this.movieDirector=movieDirector;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.yanyuan_layout, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).yanyuan_name.setText(movieDirector.get(position).getName());
            String photo = movieDirector.get(position).getPhoto();
            ((ViewHolder1) holder).yanyuan_image.setImageURI(photo);
        }
    }

    @Override
    public int getItemCount() {
        return movieDirector.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {
        private final SimpleDraweeView yanyuan_image;
        private final TextView yanyuan_name;

        public ViewHolder1(View view) {
            super(view);
            yanyuan_image = view.findViewById(R.id.yanyuan_image);
            yanyuan_name = view.findViewById(R.id.yanyuan_name);
        }
    }
}
