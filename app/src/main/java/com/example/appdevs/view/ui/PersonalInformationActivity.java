package com.example.appdevs.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.appdevs.R;
import com.example.appdevs.bean.Bean;
import com.example.appdevs.view.ui.adapters.PersonalInformationRecyclerViewAdapter;
import com.example.appdevs.view.ui.adapters.TitlesRecyclerViewAdapter;

import java.util.ArrayList;


public class PersonalInformationActivity extends AppCompatActivity {


    private RecyclerView rvApiOne;
    private ImageView ivApiOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        initView();
        initData();
    }

    private void initData() {
        //V_layout基础组件设置，设置V_layout必须要有。
        //初始化布局模块
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        rvApiOne.setLayoutManager(virtualLayoutManager);
        //初始化布局模块
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rvApiOne.setRecycledViewPool(viewPool);
        ////初始化最大值
        viewPool.setMaxRecycledViews(0, 10);
        //初始化适配器模块
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        //初始化列表绑定 （这个位置可有可无，只要设置好自己所做的布局，后面加上就可以了）
        rvApiOne.setAdapter(delegateAdapter);

        PersonalInformationRecyclerViewAdapter personalInformationRecyclerViewAdapter = new PersonalInformationRecyclerViewAdapter(this);
        delegateAdapter.addAdapter(personalInformationRecyclerViewAdapter);
        personalInformationRecyclerViewAdapter.notifyDataSetChanged();


        personalInformationRecyclerViewAdapter.setOnItemClickListener(new PersonalInformationRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent();
                intent.setClass(PersonalInformationActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<Bean> beans = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Bean bean = new Bean();
            bean.setId("数值：" + i);
            bean.setName("内容" + i);
            bean.setImg(R.drawable.p1);
            beans.add(bean);
        }
        TitlesRecyclerViewAdapter titlesRecyclerViewAdapter = new TitlesRecyclerViewAdapter(beans, this);
        delegateAdapter.addAdapter(titlesRecyclerViewAdapter);
        titlesRecyclerViewAdapter.notifyDataSetChanged();


        rvApiOne.setAdapter(delegateAdapter);

        ivApiOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


    private void initView() {
        rvApiOne = (RecyclerView) findViewById(R.id.rv_api_one);
        ivApiOne = (ImageView) findViewById(R.id.iv_api_one);
    }
}