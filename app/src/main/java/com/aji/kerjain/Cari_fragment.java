package com.aji.kerjain;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Cari_fragment extends Fragment implements View.OnClickListener {
    public Button btn_cari;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cari, container, false);
    }//onCreateView

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    btn_cari = view.findViewById(R.id.btn_mulaicari);
    btn_cari.setOnClickListener(this);
    }//on View Created


    @Override
    public void onClick(View v) {
        if(v==btn_cari){
            getContext().startActivity(new Intent(getContext(),Cari_kerja.class));
        }
    }

}

