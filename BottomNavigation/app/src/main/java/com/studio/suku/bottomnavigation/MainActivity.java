package com.studio.suku.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main, fragment, HomeFragment.class.getSimpleName())
                            .commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new DashboardFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main, fragment, DashboardFragment.class.getSimpleName())
                            .commit();
                    return true;
                case R.id.navigation_notifications:
                   fragment = new NotificationFragment();
                   getSupportFragmentManager().beginTransaction()
                           .replace(R.id.main, fragment, NotificationFragment.class.getSimpleName())
                           .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
