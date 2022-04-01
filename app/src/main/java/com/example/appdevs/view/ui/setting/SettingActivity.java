package com.example.appdevs.view.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.appdevs.R;
import com.example.appdevs.tools.SpUtils;
import com.example.appdevs.view.ui.MainActivity;

public class SettingActivity extends AppCompatActivity {

    TextView appTitle;
    CheckBox checkboxLogin;
    CheckBox checkboxNologin;
    RelativeLayout rlLogout;
    private ConstraintLayout clStOne;
    private ImageView ivStOne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        initData();
    }

    private void initData() {
        boolean bool = SpUtils.getInstance().getBoolean("loginloader");
        if (bool) {
            checkboxLogin.setChecked(true);
            checkboxNologin.setChecked(false);
        } else {
            checkboxNologin.setChecked(true);
            checkboxLogin.setChecked(false);
        }

        checkboxLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkboxNologin.setChecked(false);
                    SpUtils.getInstance().setValue("loginloader", true);
                } else {
                    checkboxNologin.setChecked(true);
                }
            }
        });

        checkboxNologin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkboxLogin.setChecked(false);
                    SpUtils.getInstance().setValue("loginloader", false);
                } else {
                    checkboxLogin.setChecked(true);
                }
            }
        });

        rlLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpUtils.getInstance().setValue("loginloader", true);
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.setClass(SettingActivity.this, MainActivity.class);
//                startMain.addCategory(Intent.CATEGORY_HOME);
//                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
                finish();
            }
        });
        ivStOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }




    private void initView() {

        appTitle = (TextView) findViewById(R.id.app_title);
        checkboxLogin = (CheckBox) findViewById(R.id.checkbox_login);
        checkboxNologin = (CheckBox) findViewById(R.id.checkbox_nologin);
        rlLogout = (RelativeLayout) findViewById(R.id.rl_logout);
        clStOne = (ConstraintLayout) findViewById(R.id.cl_st_one);
        ivStOne = (ImageView) findViewById(R.id.iv_st_one);
    }


}