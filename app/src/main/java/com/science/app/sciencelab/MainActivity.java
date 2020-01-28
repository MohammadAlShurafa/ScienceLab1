package com.science.app.sciencelab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle toggle;
    NavigationView nav;
    DrawerLayout drawer;
    Toolbar toolbar;
    FragmentManager fm;
    ShowDevicesFragment showDevicesFragment;
    Bundle bundle;
    Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale("ar".toLowerCase())); // API 17+ only.
        // Use conf.locale = new Locale(...) if targeting lower versions
        res.updateConfiguration(conf, dm);

        initViews();
        initItems();
        initClicks();

    }

    private void initClicks() {
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.mech){
                    toolbar.setTitle(menuItem.getTitle());
                    showDevicesFragment.refresh(1);
                }else if (id == R.id.elec){
                    toolbar.setTitle(menuItem.getTitle());
                    showDevicesFragment.refresh(2);
                }else if (id == R.id.static_elec){
                    toolbar.setTitle(menuItem.getTitle());
                    showDevicesFragment.refresh(3);
                }else if (id == R.id.magn){
                    toolbar.setTitle(menuItem.getTitle());
                    showDevicesFragment.refresh(4);
                }else if (id == R.id.temp){
                    toolbar.setTitle(menuItem.getTitle());
                    showDevicesFragment.refresh(5);
                }else if (id == R.id.light){
                    toolbar.setTitle(menuItem.getTitle());
                    showDevicesFragment.refresh(6);
                }else if (id == R.id.chem){
                    toolbar.setTitle(menuItem.getTitle());
                    showDevicesFragment.refresh(7);
                }else if (id == R.id.biol){
                    toolbar.setTitle(menuItem.getTitle());
                    showDevicesFragment.refresh(8);
                }else if (id == R.id.glass){
                    toolbar.setTitle(menuItem.getTitle());
                    showDevicesFragment.refresh(9);
                }else if (id == R.id.helper){
                    toolbar.setTitle(menuItem.getTitle());
                    showDevicesFragment.refresh(10);

                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void initItems() {

        drawer.addDrawerListener(toggle);
        setSupportActionBar(toolbar);


        toggle = new ActionBarDrawerToggle(MainActivity.this,drawer,toolbar,R.string.app_name,R.string.app_name);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("أجهزة ميكانيكية");
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        bundle = new Bundle();
        fm = getSupportFragmentManager();
        showDevicesFragment = new ShowDevicesFragment();
        showDevicesFragment.setArguments(bundle);
        bundle.putInt("num",1);
        getSupportFragmentManager().beginTransaction().remove(showDevicesFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.container,showDevicesFragment).commit();
        nav.setCheckedItem(0);


    }

    private void initViews() {
        nav = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar_main);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
            finishAffinity();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuCompat.setGroupDividerEnabled(menu, true);
        return super.onCreateOptionsMenu(menu);
    }
}
