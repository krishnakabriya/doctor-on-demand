package com.example.hospitalapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hospitalapplication.databinding.ActivityHomePageBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home_page extends AppCompatActivity {

    BottomNavigationView bnview;
    ActivityHomePageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomePageBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        bnview=findViewById(R.id.bottomnavi);

        bnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.nav_home)
                {
                    loadFrag(new HomeFragment(),true);
                }
                else if(id==R.id.nav_search)
                {
                    loadFrag(new SearchFragment(),false);
                }
                else if(id==R.id.nav_appointment)
                {
                    loadFrag(new AppointmentFragment(),false);
                }
//                else if(id==R.id.nav_logout)
//                {
//                    loadFrag(new ProfileFragment(),false);
//                }
                return true;
            }
        });

        bnview.setSelectedItemId(R.id.nav_home);
    }

    public void loadFrag(Fragment fragment, boolean flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag)
            ft.add(R.id.frame1,fragment);
        else
            ft.replace(R.id.frame1,fragment);
        ft.commit();
    }
}