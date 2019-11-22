package com.bw.movie.adapter.xQadapter;

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
import com.bw.movie.bean.XqPlBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/19
 * 描述:WMovie
 * 功能：
 **/
public class MyXqPlAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<XqPlBean.ResultBean> result;
    public MyXqPlAdapter(Context context, List<XqPlBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_xq_pl, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).yingping_name.setText(result.get(position).getCommentUserName());
            Uri parse = Uri.parse(result.get(position).getCommentHeadPic());
            ((ViewHolder1) holder).yingping_image.setImageURI(parse);
            ((ViewHolder1) holder).yingping_pinglun.setText(result.get(position).getCommentContent());
            //Date date = new Date(result.get(position).getCommentTime());
           /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ((ViewHolder1) holder).yingpingtime.setText(simpleDateFormat.format(date)+"");*/
            ((ViewHolder1) holder).yingping_dianzan.setText(result.get(position).getGreatNum());
        }
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final SimpleDraweeView yingping_image;
        private final TextView yingping_name;
        private final TextView yingpingtime;
        private final TextView yingping_pinglun;
        private final TextView yingping_dianzan;

        public ViewHolder1(View view) {
            super(view);
            yingping_image = view.findViewById(R.id.yingping_image);
            yingping_name = view.findViewById(R.id.yingping_name);
            yingpingtime = view.findViewById(R.id.yingpingtime);
            yingping_pinglun = view.findViewById(R.id.yingping_pinglun);
            yingping_dianzan = view.findViewById(R.id.yingping_dianzan);

        }
    }
}
