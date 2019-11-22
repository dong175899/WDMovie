package com.bw.movie.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.fragment.frag.FuFrag;
import com.bw.movie.fragment.frag.HaiFrag;
import com.bw.movie.fragment.frag.TuiFrag;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import me.jessyan.autosize.AutoSizeConfig;

/**
 * 作者:dongyanjun
 * 时间：2019/11/12
 * 描述:WMovie
 * 功能：
 **/
public class MovieFrag extends BaseFragment {

    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected int getLayoutResId() {
        return R.layout.movie_layout;
    }

    @Override
    protected void initView(View view) {
        vp = view.findViewById(R.id.vp);
        tab = view.findViewById(R.id.tab);
    }

    @Override
    protected void initData() {
        AutoSizeConfig.getInstance().setCustomFragment(true);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new TuiFrag());
        fragments.add(new FuFrag());
        fragments.add(new HaiFrag());
        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return fragments.size();
            }

            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
        };
        vp.setAdapter(fragmentStatePagerAdapter);
        tab.setupWithViewPager(vp);

        tab.getTabAt(0).setText("推荐影院");
        tab.getTabAt(1).setText("附近影院");
        tab.getTabAt(2).setText("海淀区");
    }
}
