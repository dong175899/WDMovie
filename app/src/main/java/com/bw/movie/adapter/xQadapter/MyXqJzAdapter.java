package com.bw.movie.adapter.xQadapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/19
 * 描述:WMovie
 * 功能：
 **/
public class MyXqJzAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<String> posterList;
    public MyXqJzAdapter(Context context, List<String> posterList) {
        this.context=context;
        this.posterList=posterList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_xq_jz, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            Uri parse = Uri.parse(posterList.get(position));
            ((ViewHolder1) holder).xq_sim_jz.setImageURI(parse);
        }
    }


    @Override
    public int getItemCount() {
        return posterList.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final SimpleDraweeView xq_sim_jz;

        public ViewHolder1(View view) {
            super(view);
            xq_sim_jz = view.findViewById(R.id.xq_sim_jz);

        }
    }
}
