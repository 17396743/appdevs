package com.example.appdevs.view.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.appdevs.R;
import com.example.appdevs.bean.MyListBean;

import java.util.ArrayList;

/**
 * @创建时间 2022/4/1 23:09
 */
public class MyListRecyclerViewAdapter extends DelegateAdapter.Adapter<MyListRecyclerViewAdapter.HomeHolder> {
    private Context context;
    private ArrayList<MyListBean> myListBeans;

    //接收数据
    public MyListRecyclerViewAdapter(Context context, ArrayList<MyListBean> myListBeans) {
        this.context = context;
        this.myListBeans = myListBeans;
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
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mylistitem, parent, false);
        return new MyListRecyclerViewAdapter.HomeHolder(inflate);
    }

    //设置数据
    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context).load(myListBeans.get(position).getImges()).into(holder.ivMlItemOne);
        holder.tvMlItemOne.setText(myListBeans.get(position).getName());
        holder.rlMlItemOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(position);
            }
        });
    }

    //第一步 定义接口
    public interface OnItemClickListener {
        void onClick(int position);
    }

    private MyListRecyclerViewAdapter.OnItemClickListener listener;

    //第二步， 写一个公共的方法
    public void setOnItemClickListener(MyListRecyclerViewAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    //设置显示数量
    @Override
    public int getItemCount() {
        return myListBeans.size();
    }

    //转换组件id
    class HomeHolder extends RecyclerView.ViewHolder {
        RelativeLayout rlMlItemOne;
        TextView tvMlItemOne;
        ImageView ivMlItemOne;
        ImageView ivMlItemTwo;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            rlMlItemOne = (RelativeLayout) itemView.findViewById(R.id.rl_ml_item_one);

            ivMlItemOne = (ImageView) itemView.findViewById(R.id.iv_ml_item_one);
            ivMlItemTwo = (ImageView) itemView.findViewById(R.id.iv_ml_item_two);

            tvMlItemOne = (TextView) itemView.findViewById(R.id.tv_ml_item_one);

        }
    }
}
