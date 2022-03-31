package com.example.appdevs.view.ui.fragments.homepages;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.appdevs.R;
import com.example.appdevs.bean.Bean;
import com.example.appdevs.view.ui.DetailpageActivity;
import com.example.appdevs.view.ui.MainActivity;
import com.example.appdevs.view.ui.PersonalInformationActivity;
import com.example.appdevs.view.ui.adapters.PersonalInformationRecyclerViewAdapter;
import com.example.appdevs.view.ui.adapters.PersonalRecyclerViewAdapter;
import com.example.appdevs.view.ui.adapters.TitlesRecyclerViewAdapter;
import com.example.appdevs.view.ui.adapters.TopRecyclerViewAdapter;
import com.example.appdevs.view.ui.adapters.TopSettingRecyclerViewAdapter;
import com.example.appdevs.view.ui.setting.SettingActivity;

import java.util.ArrayList;

public class PersonalFragment extends Fragment {


    private RecyclerView rvFpOne;

    public PersonalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_personal, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        //V_layout基础组件设置，设置V_layout必须要有。
        //初始化布局模块
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        rvFpOne.setLayoutManager(virtualLayoutManager);
        //初始化布局模块
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rvFpOne.setRecycledViewPool(viewPool);
        ////初始化最大值
        viewPool.setMaxRecycledViews(0, 10);
        //初始化适配器模块
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        //初始化列表绑定 （这个位置可有可无，只要设置好自己所做的布局，后面加上就可以了）
        rvFpOne.setAdapter(delegateAdapter);

        TopSettingRecyclerViewAdapter topSettingRecyclerViewAdapter = new TopSettingRecyclerViewAdapter(getContext());
        delegateAdapter.addAdapter(topSettingRecyclerViewAdapter);
        topSettingRecyclerViewAdapter.notifyDataSetChanged();


        PersonalRecyclerViewAdapter personalRecyclerViewAdapter = new PersonalRecyclerViewAdapter(getContext());
        delegateAdapter.addAdapter(personalRecyclerViewAdapter);
        personalRecyclerViewAdapter.notifyDataSetChanged();


        ArrayList<Bean> beans = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Bean bean = new Bean();
            bean.setId("数值：" + i);
            bean.setName("内容" + i);
            bean.setImg(R.drawable.p1);
            beans.add(bean);
        }
        TitlesRecyclerViewAdapter titlesRecyclerViewAdapter = new TitlesRecyclerViewAdapter(beans,getContext());
        delegateAdapter.addAdapter(titlesRecyclerViewAdapter);
        titlesRecyclerViewAdapter.notifyDataSetChanged();

        rvFpOne.setAdapter(delegateAdapter);


        topSettingRecyclerViewAdapter.setOnItemClickListener(new TopSettingRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                // 设置跳转
                Intent intent = new Intent();
                intent.setClass(getContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

        personalRecyclerViewAdapter.setOnItemClickListener(new PersonalRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                // 个人信息跳转(未做)
//                Intent intent = new Intent(getActivity(), MainActivity.class);
//                startActivity(intent);
                //跳转至登录页面

                Intent intent = new Intent(getContext(), PersonalInformationActivity.class);
                startActivity(intent);
            }
        });

        titlesRecyclerViewAdapter.setOnItemClickListener(new TitlesRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(), "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(getContext(), DetailpageActivity.class);
                intent.putExtra("id", position);
                getActivity().startActivity(intent);
            }
        });
    }

    private void initView(View inflate) {
        rvFpOne = (RecyclerView) inflate.findViewById(R.id.rv_fp_one);

    }
}