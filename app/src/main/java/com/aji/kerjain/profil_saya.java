package com.aji.kerjain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class profil_saya extends AppCompatActivity implements View.OnClickListener {
    ImageView btn_kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_saya);

        btn_kembali = findViewById(R.id.btn_back);
        btn_kembali.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v == btn_kembali){
            onBackPressed();
        }
    }
}
