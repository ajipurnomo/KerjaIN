package com.aji.kerjain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class landing extends AppCompatActivity {

    LinearLayout profil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        BottomNavigationView bottomNav = (findViewById(R.id.bottom_nav));
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new Home_fragment()).commit();


    }



    BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new Home_fragment();
                    break;
                case R.id.nav_cari:
                    selectedFragment= new Cari_fragment();
                    break;
                case R.id.nav_saya:
                    selectedFragment= new Saya_fragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,selectedFragment).commit();
            return  true;

        }
    };


}
