package com.example.appdevs.view.ui.fragments.homepages;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.appdevs.R;
import com.example.appdevs.view.ui.adapters.TopRecyclerViewAdapter;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

public class FindFragment extends Fragment {
    private RecyclerView rvFdOne;
    public FindFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_find, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        //V_layout基础组件设置，设置V_layout必须要有。
        //初始化布局模块
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        rvFdOne.setLayoutManager(virtualLayoutManager);
        //初始化布局模块
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rvFdOne.setRecycledViewPool(viewPool);
        ////初始化最大值
        viewPool.setMaxRecycledViews(0, 10);
        //初始化适配器模块
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        //初始化列表绑定 （这个位置可有可无，只要设置好自己所做的布局，后面加上就可以了）
        rvFdOne.setAdapter(delegateAdapter);

        TopRecyclerViewAdapter topRecyclerViewAdapter = new TopRecyclerViewAdapter(getContext());
        delegateAdapter.addAdapter(topRecyclerViewAdapter);
        topRecyclerViewAdapter.notifyDataSetChanged();

        rvFdOne.setAdapter(delegateAdapter);
        topRecyclerViewAdapter.setOnPersonItemClickListener(new TopRecyclerViewAdapter.OnPersonItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(),"个人空间",Toast.LENGTH_SHORT).show();
            }
        });

        topRecyclerViewAdapter.setOnSearchItemClickListener(new TopRecyclerViewAdapter.OnSearchItemClickListener() {
            @Override
            public void onClick(int position) {
                SearchFragment searchFragment = SearchFragment.newInstance();
                searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
                        //这里处理逻辑
                        Toast.makeText(getContext(), keyword, Toast.LENGTH_SHORT).show();
                    }
                });
                searchFragment.showFragment(getChildFragmentManager(),SearchFragment.TAG);
            }
        });

    }

    private void initView(View inflate) {
        rvFdOne = (RecyclerView) inflate.findViewById(R.id.rv_fd_one);
    }
}