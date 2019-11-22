package com.bw.movie.adapter.xQadapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.MyMovieAdapter;
import com.bw.movie.bean.XzMovieBean;
import com.bw.movie.view.ChooseActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/20
 * 描述:WMovie
 * 功能：
 **/
public class MyXzMoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<XzMovieBean.ResultBean> result;
    public MyXzMoAdapter(Context context, List<XzMovieBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.xz_item_layout, viewGroup, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder1) {
            ((ViewHolder1) viewHolder).tv_tui_name.setText(result.get(i).getName());
            ((ViewHolder1) viewHolder).tv_tui_aes.setText(result.get(i).getAddress());
            Uri parse = Uri.parse(result.get(i).getLogo());
            ((ViewHolder1) viewHolder).sim_tui.setImageURI(parse);
            ((ViewHolder1) viewHolder).xz_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String cinemaId = result.get(i).getCinemaId();
                    onItemClickListener.onItemClick(cinemaId);
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

        void onItemClick(String cinemaId);
    }
    private class ViewHolder1 extends RecyclerView.ViewHolder {
        private final SimpleDraweeView sim_tui;
        private final TextView tv_tui_aes;
        private final TextView tv_tui_name;
        private final TextView tv_tui_km;
        private final LinearLayout xz_linear;

        public ViewHolder1(View view) {
            super(view);
            sim_tui = view.findViewById(R.id.sim_tui);
            tv_tui_name = view.findViewById(R.id.tv_tui_name);
            tv_tui_aes = view.findViewById(R.id.tv_tui_aes);
            tv_tui_km = view.findViewById(R.id.tv_tui_km);
            xz_linear = view.findViewById(R.id.xz_linear);

        }
    }
}
