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
import com.example.appdevs.view.ui.DetailpageActivity;
import com.example.appdevs.view.ui.PersonalInformationActivity;
import com.example.appdevs.view.ui.adapters.BannerRecyclerViewAdapter;
import com.example.appdevs.view.ui.adapters.TitlesRecyclerViewAdapter;
import com.example.appdevs.view.ui.adapters.TopRecyclerViewAdapter;
import com.example.searchbox.SearchFragment;
import com.example.searchbox.custom.IOnSearchClickListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class HomePageFragment extends Fragment {

    public RecyclerView rvOne;
    private SmartRefreshLayout srlSfhiOne;


    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_homepage, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        ArrayList<Bean> beans = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Bean bean = new Bean();
            bean.setId("数值：" + i);
            bean.setName("内容" + i);
            bean.setImg(R.drawable.p1);
            beans.add(bean);
        }


        //V_layout基础组件设置，设置V_layout必须要有。
        //初始化布局模块
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        rvOne.setLayoutManager(virtualLayoutManager);
        //初始化布局模块
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rvOne.setRecycledViewPool(viewPool);
        ////初始化最大值
        viewPool.setMaxRecycledViews(0, 10);
        //初始化适配器模块
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        //初始化列表绑定 （这个位置可有可无，只要设置好自己所做的布局，后面加上就可以了）
        rvOne.setAdapter(delegateAdapter);

        TopRecyclerViewAdapter topRecyclerViewAdapter = new TopRecyclerViewAdapter(getContext(), "首页");
        delegateAdapter.addAdapter(topRecyclerViewAdapter);
        topRecyclerViewAdapter.notifyDataSetChanged();

        BannerRecyclerViewAdapter bannerRecyclerViewAdapter = new BannerRecyclerViewAdapter(beans, getContext());
        delegateAdapter.addAdapter(bannerRecyclerViewAdapter);
        bannerRecyclerViewAdapter.notifyDataSetChanged();

        TitlesRecyclerViewAdapter titlesRecyclerViewAdapter = new TitlesRecyclerViewAdapter(beans, getContext());
        delegateAdapter.addAdapter(titlesRecyclerViewAdapter);
        titlesRecyclerViewAdapter.notifyDataSetChanged();

        rvOne.setAdapter(delegateAdapter);

        topRecyclerViewAdapter.setOnPersonItemClickListener(new TopRecyclerViewAdapter.OnPersonItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(),"个人空间",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), PersonalInformationActivity.class);
                startActivity(intent);
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


        srlSfhiOne.setOnRefreshListener(new OnRefreshListener() { //下拉刷新
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });

        srlSfhiOne.setOnLoadMoreListener(new OnLoadMoreListener() { //上拉加载更多
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });

    }

    private void initView(View inflate) {
        rvOne = (RecyclerView) inflate.findViewById(R.id.rv_one);
        srlSfhiOne = (SmartRefreshLayout) inflate.findViewById(R.id.srl_sfhi_one);
    }
}