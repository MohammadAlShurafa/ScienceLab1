package com.science.app.sciencelab;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class DetailesActivity extends AppCompatActivity {
    private ImageView iv_item;
    private TextView tv_name, tv_details;
    Item item;
    Intent intent;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailes);

        initViews();
        initItems();
        initClicks();

    }



    private void initClicks() {

    }

    private void initItems() {
        intent = getIntent();
        if (intent != null && intent.hasExtra("id")){

            int id = intent.getIntExtra("id", 0);

            if (id != 0) {
                item = new MyDbHelper(DetailesActivity.this).getItemById(id);
                iv_item.setImageResource(item.getImageId());
                tv_name.setText(item.getName());
                tv_details.setText(item.getDetails());

            }

        }


    }

    private void initViews() {
        iv_item = findViewById(R.id.iv_item);
        tv_name = findViewById(R.id.tv_title);
        tv_details = findViewById(R.id.tv_details);
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
    }
}
