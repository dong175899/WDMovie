package com.bw.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import me.jessyan.autosize.internal.CancelAdapt;

public class CancelAdapteActivity extends AppCompatActivity implements CancelAdapt {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_adapte);
    }
}
