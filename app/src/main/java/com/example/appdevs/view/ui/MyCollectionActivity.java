package com.example.appdevs.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.appdevs.R;
import com.example.appdevs.bean.Bean;
import com.example.appdevs.bean.CollectDataBean;
import com.example.appdevs.view.ui.adapters.DefaultCollectionRecyclerViewAdapter;

import java.util.ArrayList;

public class MyCollectionActivity extends AppCompatActivity {

    private ImageView ivMcOne;
    private ImageView ivMcTwo;
    private RecyclerView rvMcOne;
    DefaultCollectionRecyclerViewAdapter defaultCollectionRecyclerViewAdapter;
    ArrayList<CollectDataBean> collectDataBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        initView();
        initData();
    }

    private void initData() {
        ivMcOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ivMcTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //V_layout基础组件设置，设置V_layout必须要有。
        //初始化布局模块
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        rvMcOne.setLayoutManager(virtualLayoutManager);
        //初始化布局模块
        RecyclerView.RecycledViewPool   viewPool = new RecyclerView.RecycledViewPool();
        rvMcOne.setRecycledViewPool(viewPool);
        ////初始化最大值
        viewPool.setMaxRecycledViews(0, 10);
        //初始化适配器模块
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        //初始化列表绑定 （这个位置可有可无，只要设置好自己所做的布局，后面加上就可以了）
        rvMcOne.setAdapter(delegateAdapter);



        collectDataBeans = new ArrayList<>();
        collectDataBeans.add(new CollectDataBean(R.drawable.file,"默认收藏夹"));


        defaultCollectionRecyclerViewAdapter = new DefaultCollectionRecyclerViewAdapter(this,collectDataBeans);
        delegateAdapter.addAdapter(defaultCollectionRecyclerViewAdapter);
        defaultCollectionRecyclerViewAdapter.notifyDataSetChanged();


        defaultCollectionRecyclerViewAdapter.setOnItemClickListener(new DefaultCollectionRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
//                Toast.makeText(MyCollectionActivity.this,"点击收藏夹",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MyCollectionActivity.this,FavoritesPreviewActivity.class);
                startActivity(intent);

            }
        });


        rvMcOne.setAdapter(delegateAdapter);

        ivMcOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ivMcTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyCollectionActivity.this,NewFavoritesActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2){
            Bundle b = data.getExtras();
            String name = b.getString("name");
            int imges = b.getInt("imges");
            if (!name.equals("")){
                collectDataBeans.add(new CollectDataBean(imges,name));
                defaultCollectionRecyclerViewAdapter.notifyDataSetChanged();
            }
        }
    }

    private void initView() {
        ivMcOne = (ImageView) findViewById(R.id.iv_mc_one);
        ivMcTwo = (ImageView) findViewById(R.id.iv_mc_two);
        rvMcOne = (RecyclerView) findViewById(R.id.rv_mc_one);
    }
}