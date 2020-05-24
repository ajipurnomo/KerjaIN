package com.aji.kerjain;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfirLogout extends AppCompatActivity {
    Button yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confir_logout);

        findViewById(R.id.btn_outYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirLogout.this, MainActivity.class);
                startActivity(intent);
            }
        }); //on click BTN DAFTAR

        findViewById(R.id.btn_outNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        }); //on click BTN DAFTAR


    }



}
