package com.carllewis14.retrofitjsonobject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.carllewis14.retrofitjsonobject.R;

public class DetailedActivity extends AppCompatActivity {

    //declared variables
    TextView txtName;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        Intent i = getIntent();

        name = i.getStringExtra("name");

        txtName = (TextView) findViewById(R.id.tvName);

        txtName.setText(name);















    }
}
