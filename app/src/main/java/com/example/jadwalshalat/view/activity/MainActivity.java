package com.example.jadwalshalat.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.jadwalshalat.view.fragment.DBSholatFragment;
import com.example.jadwalshalat.R;
import com.example.jadwalshalat.view.fragment.FormFragment;
import com.example.jadwalshalat.view.fragment.SholatFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
private BottomNavigationView bottomNavigationView;
private Fragment selectedFragment=new SholatFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.activitymain_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(selectedFragment);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.menu_bottomnav_sholat:
                selectedFragment=new SholatFragment();
                loadFragment(selectedFragment);
                break;
            case R.id.menu_bottomnav_dbSholat:
                selectedFragment=new DBSholatFragment();
                loadFragment(selectedFragment);
                break;
            case R.id.menu_bottomnav_form:
                selectedFragment=new FormFragment();
                loadFragment(selectedFragment);
                break;
        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment!=null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_fragmentcontainer,selectedFragment)
                    .commit();
            return true;
        }
        return false;
    }
}
