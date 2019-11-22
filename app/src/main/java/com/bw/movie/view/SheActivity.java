package com.bw.movie.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;

public class SheActivity extends BaseActivity {


    private ImageView img_upData;
    private ImageView img_back;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_she;
    }

    @Override
    protected void initView() {
        img_upData = findViewById(R.id.img_upData);
        img_back = findViewById(R.id.img_back);
    }

    @Override
    protected void initData() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SheActivity.this, ShowActivity.class);
                startActivity(intent);

            }
        });
        img_upData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SheActivity.this, UpdateActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
