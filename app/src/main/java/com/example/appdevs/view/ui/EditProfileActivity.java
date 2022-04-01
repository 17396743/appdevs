package com.example.appdevs.view.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.appdevs.R;

public class EditProfileActivity extends AppCompatActivity {

    private ConstraintLayout clEpOne;
    private ImageView ivEpOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        initView();
        initData();
    }

    private void initData() {
        ivEpOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        clEpOne = (ConstraintLayout) findViewById(R.id.cl_ep_one);
        ivEpOne = (ImageView) findViewById(R.id.iv_ep_one);
    }
}