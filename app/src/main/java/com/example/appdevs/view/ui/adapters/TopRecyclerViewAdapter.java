package com.example.appdevs.view.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.appdevs.R;
import com.example.appdevs.bean.Bean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.List;

/**
 * @创建时间 2022/3/29 18:00
 */
public class TopRecyclerViewAdapter extends DelegateAdapter.Adapter{


    private Context context;
    //接收数据
    public TopRecyclerViewAdapter( Context context) {
        this.context = context;
    }

    //适配器预设
    // 具体详情请看：
    //  https://blog.csdn.net/sw950729/article/details/67634747
    //
    //* 1：LinearLayoutHelper: 线性布局
    //* 2：GridLayoutHelper: Grid布局， 支持横向的colspan
    //* 3：FixLayoutHelper: 固定布局，始终在屏幕固定位置显示
    //* 4：ScrollFixLayoutHelper: 固定布局，但之后当页面滑动到该图片区域才显示, 可以用来做返回顶部或其他书签等
    //* 5：FloatLayoutHelper: 浮动布局，可以固定显示在屏幕上，但用户可以拖拽其位置
    //* 6：ColumnLayoutHelper: 栏格布局，都布局在一排，可以配置不同列之间的宽度比值
    //* 7：SingleLayoutHelper: 通栏布局，只会显示一个组件View
    //* 8：OnePlusNLayoutHelper: 一拖N布局，可以配置1-5个子元素
    //* 9：StickyLayoutHelper: stikcy布局， 可以配置吸顶或者吸底
    //* 10：StaggeredGridLayoutHelper: 瀑布流布局，可配置间隔高度/宽度

    //绑定布局适配器预设
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }
    //绑定布局id
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topitem, parent, false);
        return new TopRecyclerViewAdapter.HomeHolder(inflate);
    }
    //设置数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (holder instanceof TopRecyclerViewAdapter.HomeHolder) {


        }
    }


    //设置显示数量
    @Override
    public int getItemCount() {
        return 1;
    }
    //转换组件id
    class HomeHolder extends RecyclerView.ViewHolder {
        ImageView ivFhOne;
        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            ivFhOne = (ImageView) itemView.findViewById(R.id.iv_fh_one);
        }
    }
}
