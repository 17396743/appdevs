package com.example.appdevs.view.ui;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.appdevs.R;
import com.example.appdevs.view.ui.adapters.ViewPagerAdapter;
import com.example.appdevs.view.ui.fragments.homepages.FindFragment;
import com.example.appdevs.view.ui.fragments.homepages.HomePageFragment;
import com.example.appdevs.view.ui.fragments.homepages.PersonalFragment;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {


    HomePageFragment oneFragment;
    PersonalFragment twoFragment;

    RadioGroup rgMainOne;

    ViewPager vpMainOne;
    private FindFragment threeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initData();
    }

    private void initData() {

        rgMainOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_shouye_main_one:
                        vpMainOne.setCurrentItem(0,false);
                        break;
                    case R.id.rb_person_main_two:
                        vpMainOne.setCurrentItem(1,false);
                        break;
                    case R.id.rb_person_main_three:
                        vpMainOne.setCurrentItem(2,false);
                        break;
                }
            }
        });

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(oneFragment);
        fragments.add(threeFragment);
        fragments.add(twoFragment);


        vpMainOne.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));


        vpMainOne.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rgMainOne.check(rgMainOne.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView() {

        rgMainOne = (RadioGroup) findViewById(R.id.rg_main_one);
        vpMainOne = (ViewPager) findViewById(R.id.vp_main_one);

        oneFragment = new HomePageFragment();
        twoFragment = new PersonalFragment();
        threeFragment = new FindFragment();


    }
}