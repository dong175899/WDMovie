package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.AssetsBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.FuJiBean;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.JiTopBean;
import com.bw.movie.bean.LogBean;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.bean.PaiQIBean;
import com.bw.movie.bean.PriceMovieBean;
import com.bw.movie.bean.RegBean;
import com.bw.movie.bean.ToDayBean;
import com.bw.movie.bean.TuiBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.bean.XqPlBean;
import com.bw.movie.bean.XzMovieBean;
import com.bw.movie.bean.XzTimeBena;
import com.bw.movie.bean.XzZwBean;
import com.bw.movie.bean.ZhTopBean;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.presenter.HomePresenter;
import com.bw.movie.utils.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements HomeContract.Iview {


    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.text_reg)
    TextView textReg;
    @BindView(R.id.but_log)
    Button butLog;
    @BindView(R.id.but_wz)
    Button butWz;
    private HomePresenter homePresenter;
    private String userName="1758992398@qq.com";
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
    }

    @Override
    public void onLoginSuccess(LogBean data) {
        String message = data.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        if (message.equals("登陆成功")) {
            Intent intent = new Intent(MainActivity.this, ShowActivity.class);
            String nickName = data.getResult().getUserInfo().getNickName();
            String headPic = data.getResult().getUserInfo().getHeadPic();
            SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("name",nickName);
            edit.putString("pic",headPic);
            edit.commit();
            startActivity(intent);
        }
    }

    @Override
    public void onPriceSuccess(PriceMovieBean data) {

    }

    @Override
    public void onToDaytSuccess(ToDayBean data) {

    }

    @Override
    public void onTimeSuccess(XzTimeBena data) {

    }

    @Override
    public void onXzZwSuccess(XzZwBean data) {

    }

    @Override
    public void onPqSuccess(PaiQIBean data) {

    }

    @Override
    public void onXzMovieSuccess(XzMovieBean data) {

    }

    @Override
    public void onXqPlSuccess(XqPlBean data) {

    }

    @Override
    public void onXiangSuccess(XiangBean data) {

    }

    @Override
    public void onHotSuccess(HotBean data) {

    }

    @Override
    public void onMovieSuccess(MovieBean data) {

    }

    @Override
    public void onZhTopSuccess(ZhTopBean data) {

    }

    @Override
    public void onJiSuccess(JiTopBean data) {

    }

    @Override
    public void onRegisterSuccess(RegBean data) {

    }

    @Override
    public void onBannerSuccess(BannerBean data) {

    }

    @Override
    public void onAssetsSuccess(AssetsBean data) {

    }

    @Override
    public void onEmailSuccess(EmailBean data) {

    }

    @Override
    public void onTuiSuccess(TuiBean data) {

    }

    @Override
    public void onFujiSuccess(FuJiBean data) {

    }

    @Override
    public void onHomeError(String e) {

    }


    @OnClick({R.id.text_reg, R.id.but_log, R.id.but_wz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_reg:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.but_log:
                String email = editEmail.getText().toString().trim();
                String pwd = editPwd.getText().toString().trim();
                String encrypt = EncryptUtil.encrypt(pwd);
                if (TextUtils.isEmpty(email)||TextUtils.isEmpty(pwd)) {
                    Toast.makeText(this, "邮箱或密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    homePresenter.getLoginPresenter(userName,encrypt);
                }
                break;
            case R.id.but_wz:
                break;
        }
    }
}
