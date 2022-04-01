package com.example.appdevs.view.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdevs.R;

import java.util.ArrayList;

public class DetailpageActivity extends AppCompatActivity {

    private ImageView ivDpOne;
    private WebView wvDpOne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpage);
        initView();
        initData();
    }

    private void initData() {
        int id = getIntent().getIntExtra("id", 0);

        ArrayList<String> urls = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            urls.add("https://mp.weixin.qq.com/s?__biz=MzU0MjczMDkyMA==&mid=2247489058&idx=1&sn=24d8fc799007019685c2c34e94a0b59e&chksm=fb1769e5cc60e0f3eee6b787cac7d9a4a90d2f7973883e7cc1868137176eb4aaf4964f3011fe&token=191262423&lang=zh_CN#rd");
            urls.add("https://mp.weixin.qq.com/s/HbOOHpg9SzITv1R9g_kbnw");
            urls.add("https://www.wanandroid.com/blog/show/3293");
            urls.add("https://mp.weixin.qq.com/s/e-XwF30-CWgBwq7Nw_01UA");
        }

        ivDpOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        wvDpOne.loadUrl(urls.get(id));
        //设置可自由缩放网页
//        wvDpOne.getSettings().setSupportZoom(true);
//        wvDpOne.getSettings().setBuiltInZoomControls(true);
        // 如果页面中链接，如果希望点击链接继续在当前browser中响应，
        // 而不是新开Android的系统browser中响应该链接，必须覆盖webview的WebViewClient对象
        wvDpOne.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
    }

//    //go back
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // Check if the key event was the Back button and if there's history
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && wvDpOne.canGoBack()) {
//            wvDpOne.goBack();
//            return true;
//        }
//        //  return true;
//        // If it wasn't the Back key or there's no web page history, bubble up to the default
//        // system behavior (probably exit the activity)
//        return super.onKeyDown(keyCode, event);
//    }

    private void initView() {
        ivDpOne = (ImageView) findViewById(R.id.iv_dp_one);
        wvDpOne = (WebView) findViewById(R.id.wv_dp_one);
    }
}