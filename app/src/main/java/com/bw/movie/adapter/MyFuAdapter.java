package com.bw.movie.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.FuJiBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/14
 * 描述:WMovie
 * 功能：
 **/
public class MyFuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<FuJiBean.ResultBean> result;
    public MyFuAdapter(Context context, List<FuJiBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tui, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).tv_tui_name.setText(result.get(position).getName());
            ((ViewHolder1) holder).tv_tui_aes.setText(result.get(position).getAddress());
            ((ViewHolder1) holder).tv_tui_km.setText(result.get(position).getCommentTotal()+"km");
            Uri parse = Uri.parse(result.get(position).getLogo());
            ((ViewHolder1) holder).sim_tui.setImageURI(parse);
        }
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {
        private final SimpleDraweeView sim_tui;
        private final TextView tv_tui_aes;
        private final TextView tv_tui_name;
        private final TextView tv_tui_km;

        public ViewHolder1(View view) {
            super(view);
            sim_tui = view.findViewById(R.id.sim_tui);
            tv_tui_name = view.findViewById(R.id.tv_tui_name);
            tv_tui_aes = view.findViewById(R.id.tv_tui_aes);
            tv_tui_km = view.findViewById(R.id.tv_tui_km);

        }
    }
}
