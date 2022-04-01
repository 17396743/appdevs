package com.example.appdevs.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.appdevs.R;
import com.example.appdevs.bean.Bean;
import com.example.appdevs.view.ui.adapters.TitlesRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Collection;

public class FavoritesPreviewActivity extends AppCompatActivity {

    private ConstraintLayout clFpOne;
    private ImageView ivFpOne;
    private RecyclerView rvFpOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_preview);
        initView();
        initData();
    }

    private void initData() {
        //V_layout基础组件设置，设置V_layout必须要有。
        //初始化布局模块
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        rvFpOne.setLayoutManager(virtualLayoutManager);
        //初始化布局模块
        RecyclerView.RecycledViewPool   viewPool = new RecyclerView.RecycledViewPool();
        rvFpOne.setRecycledViewPool(viewPool);
        ////初始化最大值
        viewPool.setMaxRecycledViews(0, 10);
        //初始化适配器模块
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        //初始化列表绑定 （这个位置可有可无，只要设置好自己所做的布局，后面加上就可以了）
        rvFpOne.setAdapter(delegateAdapter);

        ArrayList<Bean> beans = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Bean bean = new Bean();
            bean.setId("数值：" + i);
            bean.setName("内容" + i);
            bean.setImg(R.drawable.p1);
            beans.add(bean);
        }

        TitlesRecyclerViewAdapter titlesRecyclerViewAdapter = new TitlesRecyclerViewAdapter(beans, this);
        delegateAdapter.addAdapter(titlesRecyclerViewAdapter);
        titlesRecyclerViewAdapter.notifyDataSetChanged();

        rvFpOne.setAdapter(delegateAdapter);

        ivFpOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        titlesRecyclerViewAdapter.setOnItemClickListener(new TitlesRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(FavoritesPreviewActivity.this, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(FavoritesPreviewActivity.this, DetailpageActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        clFpOne = (ConstraintLayout) findViewById(R.id.cl_fp_one);
        ivFpOne = (ImageView) findViewById(R.id.iv_fp_one);
        rvFpOne = (RecyclerView) findViewById(R.id.rv_fp_one);
    }
}