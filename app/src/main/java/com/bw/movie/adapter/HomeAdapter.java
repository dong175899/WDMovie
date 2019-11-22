package com.bw.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.JiTopBean;
import com.bw.movie.bean.ZhTopBean;
import com.bw.movie.view.XiangActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;

import java.util.AbstractList;
import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/11/14
 * 描述:WMovie
 * 功能：
 **/
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<HotBean.ResultBean> hotResult;
    List<JiTopBean.ResultBean> jiResult;
    List<ZhTopBean.ResultBean> zhResult;
    List<BannerBean.ResultBean> banResult;
    public HomeAdapter(Context context, List<HotBean.ResultBean> hotResult, List<JiTopBean.ResultBean> jiResult, List<ZhTopBean.ResultBean> zhResult, List<BannerBean.ResultBean> banResult) {
        this.context=context;
        this.hotResult=hotResult;
        this.jiResult=jiResult;
        this.zhResult=zhResult;
        this.banResult=banResult;
    }
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }else if (position==1){
            return 1;
        }else if (position==2){
            return 2;
        }else if (position==3){
            return 3;
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false);
            return new MyBannerHolder(view);
        }else if (viewType==1){
            View view = LayoutInflater.from(context).inflate(R.layout.item_zh, parent, false);
            return new MyZhHolder(view);

        }else if (viewType==2){
            View view = LayoutInflater.from(context).inflate(R.layout.item_ji, parent, false);
            return new MyJiHolder(view);
        }else if (viewType==3){
            View view = LayoutInflater.from(context).inflate(R.layout.item_hot, parent, false);
            return new MyHotHolder(view);
        }
        return null;

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                if (holder instanceof MyBannerHolder) {
                    ((MyBannerHolder) holder).x_banner.setBannerData(R.layout.sim_layout, new AbstractList<SimpleBannerInfo>() {
                        @Override
                        public SimpleBannerInfo get(int i) {
                            return null;
                        }

                        @Override
                        public int size() {
                            return banResult.size();
                        }
                    });
                    ((MyBannerHolder) holder).x_banner.loadImage(new XBanner.XBannerAdapter() {
                        @Override
                        public void loadBanner(XBanner banner, Object model, View view, int position) {
                            SimpleDraweeView sim = view.findViewById(R.id.simp);
                            DraweeController controller = Fresco.newDraweeControllerBuilder()
                                    .setUri(banResult.get(position).getImageUrl())
                                    .setAutoPlayAnimations(true)
                                    .build();
                            sim.setController(controller);
                        }
                    });
                }
                break;
            case 1:
                if (holder instanceof MyZhHolder) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    ((MyZhHolder) holder).recycler_zhTop.setLayoutManager(linearLayoutManager);
                    MyZhTopAdapter myZhTopAdapter = new MyZhTopAdapter(context, zhResult);
                    ((MyZhHolder) holder).recycler_zhTop.setAdapter(myZhTopAdapter);
                    myZhTopAdapter.setOnItemClickListener(new MyZhTopAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(String id) {
                            SharedPreferences sp = context.getSharedPreferences("dong", Context.MODE_PRIVATE);
                            SharedPreferences.Editor edit = sp.edit();
                            edit.putString("id",id);
                            edit.commit();
                            Intent intent = new Intent(context, XiangActivity.class);
                            context.startActivity(intent);
                        }
                    });
                }
                break;
            case 2:
                if (holder instanceof MyJiHolder) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    ((MyJiHolder) holder).recycler_jiTop.setLayoutManager(linearLayoutManager);
                    MyJiAdapter myJiAdapter = new MyJiAdapter(context, jiResult);
                    ((MyJiHolder) holder).recycler_jiTop.setAdapter(myJiAdapter);
                    myJiAdapter.setOnItemClickListener(new MyJiAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(String id) {
                            SharedPreferences sp = context.getSharedPreferences("dong", Context.MODE_PRIVATE);
                            SharedPreferences.Editor edit = sp.edit();
                            edit.putString("id",id);
                            edit.commit();
                            Intent intent = new Intent(context, XiangActivity.class);
                            context.startActivity(intent);
                        }
                    });
                }
                break;
            case 3:
                if (holder instanceof MyHotHolder) {
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3);
                    ((MyHotHolder) holder).recycler_hot.setLayoutManager(gridLayoutManager);
                    MyHotAdapter myHotAdapter = new MyHotAdapter(context, hotResult);
                    ((MyHotHolder) holder).recycler_hot.setAdapter(myHotAdapter);
                    myHotAdapter.setOnItemClickListener(new MyHotAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(String id) {
                            Log.d("Home", "onItemClick: "+id);
                            SharedPreferences sp = context.getSharedPreferences("dong", Context.MODE_PRIVATE);
                            SharedPreferences.Editor edit = sp.edit();
                            edit.putString("id",id);
                            edit.commit();
                            Intent intent = new Intent(context, XiangActivity.class);
                            context.startActivity(intent);
                        }
                    });
                }
                break;
        }

    }


    @Override
    public int getItemCount() {
        return 4;
    }
   /* OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClickHot(String id);
    }*/
    private class MyBannerHolder extends RecyclerView.ViewHolder {

        private final XBanner x_banner;

        public MyBannerHolder(View view) {
            super(view);
            x_banner = view.findViewById(R.id.x_banner);
        }
    }

    private class MyHotHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recycler_hot;
        private final LinearLayout linear_hot;

        public MyHotHolder(View view) {
            super(view);
            recycler_hot = view.findViewById(R.id.recycler_hot);
            linear_hot = view.findViewById(R.id.linear_hot);
        }
    }

    private class MyJiHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recycler_jiTop;

        public MyJiHolder(View view) {
            super(view);
            recycler_jiTop = view.findViewById(R.id.recycler_jiTop);
        }
    }

    private class MyZhHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recycler_zhTop;

        public MyZhHolder(View view) {
            super(view);
            recycler_zhTop = view.findViewById(R.id.recycler_ZhTop);
        }
    }
}
