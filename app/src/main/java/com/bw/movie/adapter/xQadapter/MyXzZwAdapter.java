package com.bw.movie.adapter.xQadapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.XzZwBean;
import com.bw.movie.view.XzZwActivity;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/21
 * 描述:WMovie
 * 功能：
 **/
public class MyXzZwAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<XzZwBean.ResultBean> result;
    public MyXzZwAdapter(Context context, List<XzZwBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.zuo_layout, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            String row = result.get(position).getRow();
            String seat = result.get(position).getSeat();
            String s = row + "-" + seat;
            SharedPreferences dong = context.getSharedPreferences("dong", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = dong.edit();
            edit.putString("s",s);
            edit.commit();
            int status = result.get(position).getStatus();
            if (status==1) {
                ((ViewHolder1) holder).zuo_che.setChecked(false);
            }else if (status==2){
                ((ViewHolder1) holder).zuo_che.setChecked(true);
                ((ViewHolder1) holder).zuo_che.setBackgroundColor(R.drawable.myy_shape);
            }
            ((ViewHolder1) holder).zuo_che.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (((ViewHolder1) holder).zuo_che.isChecked()) {
                        result.get(position).setStatus(3);
                        onItemClickListener.onItem(result.get(position).getRow()+"排"+result.get(position).getSeat()+"座");

                    }else {
                        result.get(position).setStatus(1);
                        onItemClickListener.onItem("取消选座");
                    }
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
        void onItem(String s);
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final CheckBox zuo_che;

        public ViewHolder1(View view) {
            super(view);
            zuo_che = view.findViewById(R.id.zuo_che);
        }
    }
}
