package com.bw.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.AssetsBean;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/13
 * 描述:WMovie
 * 功能：
 **/
public class MyAssetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<AssetsBean.ResultBean> result;
    public MyAssetAdapter(FragmentActivity activity, List<AssetsBean.ResultBean> result) {
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
            ((ViewHolder1) holder).tv_assets.setText(result.get(position).getRegionName());
            ((ViewHolder1) holder).linear1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String regionId = result.get(position).getRegionId();
                    onItemClickListener.onItemClick(regionId,position);
                }
            });
            /*((ViewHolder1) holder).linear1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String  regionId = result.get(position).getRegionId();
                    onItemClickListener.onItemClick(regionId,);
                }
            });*/
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
        void onItemClick(String id,int position);
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView tv_assets;
        private final LinearLayout linear1;

        public ViewHolder1(View view) {
            super(view);
            tv_assets = view.findViewById(R.id.tv_assets);
            linear1 = view.findViewById(R.id.linear1);
        }
    }
}
