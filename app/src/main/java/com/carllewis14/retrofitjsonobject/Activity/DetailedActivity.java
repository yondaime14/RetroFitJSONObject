package com.carllewis14.retrofitjsonobject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.carllewis14.retrofitjsonobject.R;

public class DetailedActivity extends AppCompatActivity {

    //declared variables
    private ImageView imageView;
    private TextView tvName;
    private TextView tvEmail;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        //Retrieve Data from  Intent
        Intent i = getIntent();

        //Retrieve item position
        position = i.getExtras().getInt("position");

    }
}
