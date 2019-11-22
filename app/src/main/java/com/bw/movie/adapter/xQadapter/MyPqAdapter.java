package com.bw.movie.adapter.xQadapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.PaiQIBean;
import com.bw.movie.view.XzZwActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/21
 * 描述:WMovie
 * 功能：
 **/
public class MyPqAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<PaiQIBean.ResultBean> result;
    public MyPqAdapter(Context context, List<PaiQIBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.zw_pq_layout, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).pq_name.setText(result.get(position).getScreeningHall());
            ((ViewHolder1) holder).pq_time_start.setText(result.get(position).getBeginTime());
            ((ViewHolder1) holder).pq_time_stop.setText(result.get(position).getEndTime());
            ((ViewHolder1) holder).linear_pq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String fare = result.get(position).getFare();
                    SharedPreferences dong = context.getSharedPreferences("dong", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = dong.edit();
                    edit.putString("fare",fare);
                    edit.commit();
                    String hallId = result.get(position).getHallId();
                    onItemClickListener.onItemClick(hallId);
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

        private final TextView pq_name;
        private final TextView pq_time_start,pq_time_stop;
        private final LinearLayout linear_pq;

        public ViewHolder1(View view) {
            super(view);
            pq_name = view.findViewById(R.id.pq_name);
            pq_time_start = view.findViewById(R.id.pq_time_start);
            pq_time_stop = view.findViewById(R.id.pq_time_stop);
            linear_pq = view.findViewById(R.id.linear_pq);
        }
    }
}
