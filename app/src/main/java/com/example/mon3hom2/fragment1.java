package com.example.mon3hom2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment1 extends Fragment {
    TextView txtResult;
    Button buttonPlus;
    Button buttonMinus;
    int clicks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initview();
        plusresult();

    }

    private void plusresult() {
        buttonPlus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (clicks == 20){
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new SecondFragment()).addToBackStack(null).commit();
                }
                txtResult.setText(toString().valueOf(clicks));
                clicks++;
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResult.setText(toString().valueOf(clicks));
                clicks--;
            }
        });
    }


    private void initview() {
        txtResult = requireActivity().findViewById(R.id.tx_result);
        buttonMinus = requireActivity().findViewById(R.id.btn_minus);
        buttonPlus = requireActivity().findViewById(R.id.btn_plus);
    }


}