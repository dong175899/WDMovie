package com.bw.movie.view;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bw.movie.R;
import com.bw.movie.download.service.DownloadIntentService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateActivity extends AppCompatActivity {
    private static final int DOWNLOADAPK_ID = 10;
    @BindView(R.id.bt_click)
    Button btClick;
    @BindView(R.id.img_back)
    ImageView imgBack;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ButterKnife.bind(this);
        /*btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateActivity.this,SheActivity.class);
                startActivity(intent);
            }
        });*/
    }

    /* @OnClick(R.id.bt_click)
     public void onViewClicked() {
         Toast.makeText(this, "开始下载", Toast.LENGTH_SHORT).show();
         if (isServiceRunning(DownloadIntentService.class.getName())) {
             Toast.makeText(UpdateActivity.this, "正在下载", Toast.LENGTH_SHORT).show();
             return;
         }
         String downloadUrl = "/media/movie.apk";
         intent = new Intent(UpdateActivity.this, DownloadIntentService.class);
         Bundle bundle = new Bundle();
         bundle.putString("download_url", downloadUrl);
         bundle.putInt("download_id", DOWNLOADAPK_ID);
         bundle.putString("download_file", downloadUrl.substring(downloadUrl.lastIndexOf('/') + 1));
         intent.putExtras(bundle);
         startService(intent);
     }*/
    public void stopFinishSer() {

    }

    /**
     * 用来判断服务是否运行.
     *
     * @param className 判断的服务名字
     * @return true 在运行 false 不在运行
     */
    private boolean isServiceRunning(String className) {

        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) this
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager
                .getRunningServices(Integer.MAX_VALUE);
        if (!(serviceList.size() > 0)) {
            return false;
        }
        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }

    @OnClick({R.id.img_back, R.id.bt_click})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                Intent intent = new Intent(UpdateActivity.this,SheActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_click:
                Toast.makeText(this, "开始下载", Toast.LENGTH_SHORT).show();
                if (isServiceRunning(DownloadIntentService.class.getName())) {
                    Toast.makeText(UpdateActivity.this, "正在下载", Toast.LENGTH_SHORT).show();
                    return;
                }
                String downloadUrl = "/media/movie.apk";
                intent = new Intent(UpdateActivity.this, DownloadIntentService.class);
                Bundle bundle = new Bundle();
                bundle.putString("download_url", downloadUrl);
                bundle.putInt("download_id", DOWNLOADAPK_ID);
                bundle.putString("download_file", downloadUrl.substring(downloadUrl.lastIndexOf('/') + 1));
                intent.putExtras(bundle);
                startService(intent);
                break;
        }
    }
}
