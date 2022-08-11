package com.project.vvegan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.project.vvegan.ui.home.HomeFragment;
import com.project.vvegan.ui.mypage.LeafFragment;
import com.project.vvegan.ui.restore.RestoreFragment;
import com.project.vvegan.ui.scan.ScanFragment;

public class MainActivity extends AppCompatActivity {
    private LeafFragment leafFragment;
    private RestoreFragment restoreFragment;
    private ScanFragment scanFragment;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leafFragment = new LeafFragment();
        restoreFragment = new RestoreFragment();
        scanFragment = new ScanFragment();
        homeFragment = new HomeFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottomNavi);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.action_leaf:
                       getSupportFragmentManager().beginTransaction().replace(R.id.containers, leafFragment).commit();
                       return true;

                   case R.id.action_scan:
                       getSupportFragmentManager().beginTransaction().replace(R.id.containers, scanFragment).commit();
                       return true;

                   case R.id.action_restore:
                       getSupportFragmentManager().beginTransaction().replace(R.id.containers, restoreFragment).commit();
                       return true;
               }
                return false;
            }
        });
    }

}