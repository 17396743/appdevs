package com.example.appdevs.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.appdevs.R;

public class NewFavoritesActivity extends AppCompatActivity {

    private ImageView ivNfOne;
    private TextView tvNfTwo;
    private TextView tvNfThree;
    private EditText etNfPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_favorites);
        initView();
        initData();
    }

    private void initData() {
        String name = etNfPhone.getText().toString();

        Integer integer = new Integer(R.drawable.file);

        ivNfOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tvNfThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name!="") {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", name);
                    bundle.putInt("imges", integer);
                    intent.putExtras(bundle);
                    setResult(2, intent);//返回值调用函数，其中2为resultCode，返回值的标志
                    finish();//传值结束
                }
            }
        });


    }

    private void initView() {
        ivNfOne = (ImageView) findViewById(R.id.iv_nf_one);
        tvNfTwo = (TextView) findViewById(R.id.tv_nf_two);
        tvNfThree = (TextView) findViewById(R.id.tv_nf_three);
        etNfPhone = (EditText) findViewById(R.id.et_nf_phone);
    }
}