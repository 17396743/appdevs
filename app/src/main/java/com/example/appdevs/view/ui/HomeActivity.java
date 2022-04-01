package com.example.appdevs.view.ui;

import android.os.Bundle;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.appdevs.R;
import com.example.appdevs.view.ui.fragments.homepages.FindFragment;
import com.example.appdevs.view.ui.fragments.homepages.HomePageFragment;
import com.example.appdevs.view.ui.fragments.homepages.PersonalFragment;



public class HomeActivity extends AppCompatActivity {


    HomePageFragment oneFragment;
    PersonalFragment twoFragment;
    RadioGroup rgMainOne;

    private FindFragment threeFragment;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initData();
    }

    private void initData() {
        replaceFragment(R.id.fl_one, oneFragment);
        rgMainOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_shouye_main_one:
                        replaceFragment(R.id.fl_one, oneFragment);
                        break;
                    case R.id.rb_person_main_two:
                        replaceFragment(R.id.fl_one, threeFragment);
                        break;
                    case R.id.rb_person_main_three:
                        replaceFragment(R.id.fl_one, twoFragment);
                        break;
                }
            }
        });

    }

    /**
     * 切换Fragment
     *
     * @param ID
     * @param fragment
     */
    private void replaceFragment(int ID, Fragment fragment) {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(ID, fragment);
        transaction.commitAllowingStateLoss();
    }

    private void initView() {
        rgMainOne = (RadioGroup) findViewById(R.id.rg_main_one);

        oneFragment = new HomePageFragment();
        twoFragment = new PersonalFragment();
        threeFragment = new FindFragment();


    }
}