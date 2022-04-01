package com.example.appdevs.view.ui.fragments.homepages;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.appdevs.R;
import com.example.appdevs.bean.Bean;
import com.example.appdevs.bean.MyListBean;
import com.example.appdevs.view.ui.DetailpageActivity;
import com.example.appdevs.view.ui.MyCollectionActivity;
import com.example.appdevs.view.ui.PersonalInformationActivity;
import com.example.appdevs.view.ui.adapters.MyListRecyclerViewAdapter;
import com.example.appdevs.view.ui.adapters.PersonalRecyclerViewAdapter;
import com.example.appdevs.view.ui.adapters.TitlesRecyclerViewAdapter;
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



        PersonalRecyclerViewAdapter personalRecyclerViewAdapter = new PersonalRecyclerViewAdapter(getContext());
        delegateAdapter.addAdapter(personalRecyclerViewAdapter);
        personalRecyclerViewAdapter.notifyDataSetChanged();


        ArrayList<MyListBean> myListBeans = new ArrayList<>();
        myListBeans.add(new MyListBean(R.drawable.ic_baseline_star_24, "我的收藏"));
        myListBeans.add(new MyListBean(R.drawable.ic_baseline_settings_24, "系统设置"));

        MyListRecyclerViewAdapter myListRecyclerViewAdapter = new MyListRecyclerViewAdapter(getContext(),myListBeans);
        delegateAdapter.addAdapter(myListRecyclerViewAdapter);
        myListRecyclerViewAdapter.notifyDataSetChanged();



        ArrayList<Class> classes = new ArrayList<>();
        classes.add(MyCollectionActivity.class);
        classes.add(SettingActivity.class);

        ArrayList<Intent> intents = new ArrayList<>();
        for (int i = 0; i < classes.size(); i++) {
            Intent intent = IntentList(classes.get(i));
            intents.add(intent);
        }

        myListRecyclerViewAdapter.setOnItemClickListener(new MyListRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = intents.get(position);
                getActivity().startActivity(intent);
            }
        });


        rvFpOne.setAdapter(delegateAdapter);


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


    }

    private Intent IntentList(Class classes) {
        Intent intent = new Intent();
        intent.setClass(getContext(),classes);
        return intent;
    }

    private void initView(View inflate) {
        rvFpOne = (RecyclerView) inflate.findViewById(R.id.rv_fp_one);

    }
}