package com.example.appdevs.view.ui.fragments.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.appdevs.R;
import com.example.appdevs.tools.SearchWather;


public class LoginFragment extends Fragment {


    private CardView cvOne;
    private EditText etPhone;
    private ConstraintLayout clOne;
    private CheckBox cbOne;
    private TextView tvCbOne;
    private CardView rlFour;
    private Button btnTwo;
    private ConstraintLayout clFpTwo;
    private TextView tvFlOne;
    private TextView tvFlTwo;
    private View viewOne;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_login, container, false);

        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {

        String loginPhone = etPhone.getText().toString();

        etPhone.addTextChangedListener(new SearchWather(etPhone));

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbOne.isChecked()) {
                    Toast.makeText(getContext(), "短信验证码已发送，请注意查收！", Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fl_zero, new VerificationFragment()).show(new VerificationFragment()).commit();
                } else {
                    Toast.makeText(getContext(), "请勾选协议！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void initView(View inflate) {
        etPhone = (EditText) inflate.findViewById(R.id.et_phone);
        btnTwo = (Button) inflate.findViewById(R.id.btn_two);
        cbOne = (CheckBox) inflate.findViewById(R.id.cb_one);
        clFpTwo = (ConstraintLayout) inflate.findViewById(R.id.cl_fp_two);
        tvFlOne = (TextView) inflate.findViewById(R.id.tv_fl_one);
        tvFlTwo = (TextView) inflate.findViewById(R.id.tv_fl_two);
        viewOne = (View) inflate.findViewById(R.id.view_one);

    }
}