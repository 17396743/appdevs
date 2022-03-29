package com.example.appdevs.view.ui.fragments.homepages;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.appdevs.R;
import com.example.appdevs.view.ui.HomeActivity;
import com.example.appdevs.view.ui.MainActivity;

public class PersonalFragment extends Fragment {

    private ConstraintLayout clFpOne;
    private ImageView ivFpOne;
    private TextView tvFpOne;

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
        clFpOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        
    }

    private void initView(View inflate) {
        clFpOne = (ConstraintLayout) inflate.findViewById(R.id.cl_fp_one);
        ivFpOne = (ImageView) inflate.findViewById(R.id.iv_fp_one);
        tvFpOne = (TextView) inflate.findViewById(R.id.tv_fp_one);
    }
}