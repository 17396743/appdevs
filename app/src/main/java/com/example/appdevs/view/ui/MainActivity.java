package com.example.appdevs.view.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdevs.R;
import com.example.appdevs.view.ui.fragments.login.LoginFragment;
import com.example.appdevs.view.ui.fragments.login.VerificationFragment;

public class MainActivity extends AppCompatActivity {


    LoginFragment loginFragment;
    VerificationFragment verificationFragment;


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
        getSupportFragmentManager().beginTransaction().add(R.id.fl_zero, new LoginFragment()).show(new LoginFragment()).commit();
    }
}