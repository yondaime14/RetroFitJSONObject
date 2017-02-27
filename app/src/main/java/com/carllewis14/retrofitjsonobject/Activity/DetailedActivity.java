package com.carllewis14.retrofitjsonobject.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.carllewis14.retrofitjsonobject.R;
import com.squareup.picasso.Picasso;

public class DetailedActivity extends AppCompatActivity {

    //declared variables
    TextView txtName, txtEmail, txtPhone;
    ImageView img;
    String name, email, phone, image;
    Context mContext;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        //Get Intent
        Intent i = getIntent();


        //items to receive intent
        name = i.getStringExtra("name");
        email = i.getStringExtra("email");
        phone = i.getStringExtra("phone");
        //image = i.getParcelableExtra("imageView");



        //Assign values to layout file items
        txtName = (TextView) findViewById(R.id.tvName);
        txtEmail = (TextView) findViewById(R.id.tvEmail);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        img = (ImageView) findViewById(R.id.profilPic);



        /**
         * Set parsed Text
         */

        txtName.setText(name);
        txtEmail.setText(email);
        txtPhone.setText(phone);
        Picasso.with(mContext).load(image = i.getParcelableExtra("imageView")).into(img);
















    }
}
