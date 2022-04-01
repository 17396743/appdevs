package com.example.appdevs.view.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdevs.R;
import com.example.appdevs.app.MyApp;
import com.example.appdevs.tools.SpUtils;
import com.example.appdevs.view.ui.fragments.login.LoginFragment;
import com.example.appdevs.view.ui.fragments.login.VerificationFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        boolean bool = SpUtils.getInstance().getBoolean("loginloader");
        if (bool){
            getSupportFragmentManager().beginTransaction().add(R.id.fl_zero, new LoginFragment()).show(new LoginFragment()).commit();
        }else {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}