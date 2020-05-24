package com.aji.kerjain;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Saya_fragment extends Fragment implements View.OnClickListener {
    public LinearLayout layout_saya, layout_lowongansaya, layout_tambahlowongan;
    public Button btn_out;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_saya, container, false);
    }//onCreateVIew

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layout_saya = view.findViewById(R.id.lay_profil_saya);
        layout_saya.setOnClickListener(this);

        layout_lowongansaya = view.findViewById(R.id.lay_lowongan_saya);
        layout_lowongansaya.setOnClickListener(this);

        layout_tambahlowongan = view.findViewById(R.id.lay_tambahLowongan);
        layout_tambahlowongan.setOnClickListener(this);

        btn_out = view.findViewById(R.id.btn_keluar);
        btn_out.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == layout_saya) {
            getContext().startActivity(new Intent(getContext(), profil_saya.class));
        } else if (v == layout_tambahlowongan)  {
                getContext().startActivity(new Intent(getContext(), tambah_lowongan.class));
        }else if(v == btn_out ){
                getContext().startActivity(new Intent(getContext(), ConfirLogout.class));
        }else if (v ==layout_lowongansaya){
            Toast.makeText(getContext(), "Maaf, Belum Berfungsi", Toast.LENGTH_LONG).show();
        }

    }//onCLick

}//end class

