package com.example.appdevs.view.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdevs.R;

public class DetailpageActivity extends AppCompatActivity {

    private TextView tvDpOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpage);
        initView();
        initData();
    }

    private void initData() {
        int id = getIntent().getIntExtra("id", 0);

        tvDpOne.setText("第" + id + "个详情页");
    }

    private void initView() {
        tvDpOne = (TextView) findViewById(R.id.tv_dp_one);
    }
}