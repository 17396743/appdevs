package com.example.appdevs.view.ui.fragments.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.appdevs.R;
import com.example.appdevs.tools.SearchWather;
import com.example.appdevs.view.ui.HomeActivity;
import com.example.appdevs.view.ui.MainActivity;

public class VerificationFragment extends Fragment {



    private View viewOne;
    private TextView tvOne;
    private CardView cvOne;
    private EditText etPhone;
    private CardView rlFour;
    private Button btnTwo;

    public VerificationFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_verification, container, false);

        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        etPhone.addTextChangedListener(new SearchWather(etPhone));

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    private void initView(View inflate) {
        viewOne = (View) inflate.findViewById(R.id.view_one);
        tvOne = (TextView) inflate.findViewById(R.id.tv_one);
        cvOne = (CardView) inflate.findViewById(R.id.cv_one);
        etPhone = (EditText) inflate.findViewById(R.id.et_phone);
        rlFour = (CardView) inflate.findViewById(R.id.rl_four);
        btnTwo = (Button) inflate.findViewById(R.id.btn_two);
    }
}