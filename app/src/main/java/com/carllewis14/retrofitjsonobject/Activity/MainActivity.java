package com.carllewis14.retrofitjsonobject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.carllewis14.retrofitjsonobject.Adapter.Adapter;
import com.carllewis14.retrofitjsonobject.DataModel.Contact;
import com.carllewis14.retrofitjsonobject.DataModel.ContactList;
import com.carllewis14.retrofitjsonobject.Network.ApiService;
import com.carllewis14.retrofitjsonobject.Network.RetroClient;
import com.carllewis14.retrofitjsonobject.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    /**
     * Views go here
     */
    private ListView listView;
    private View parentView;
    private ArrayList<Contact> contactList;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * ArrayList for Binding Data from JSON to this list
         */

        contactList = new ArrayList<>();
        parentView = findViewById(R.id.activity_main);

        //Gets list and sets adapter
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Contact selectedContact = contactList.get(position);

                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
                intent.putExtra("imageView", contactList.get(position).getProfilePic());
                intent.putExtra("name", contactList.get(position).getName());
                intent.putExtra("email", contactList.get(position).getEmail());
                intent.putExtra("phone", contactList.get(position).getPhone().getMobile());

                startActivity(intent);

            }
        });



        //Potential on click listener goes here


        //creating Api interface
        ApiService apiService = RetroClient.getApiService();

        /**
         * Call to JSON
         */
        Call<ContactList> call = apiService.getJSON();

        /**
         * Enqueue callback for response
         */

        call.enqueue(new Callback<ContactList>() {
            @Override
            public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                if (response.isSuccessful()) {
                    /**
                     * On successful connection
                     */
                    contactList = response.body().getContacts();

                    //Binding list to adapter
                    adapter = new Adapter(MainActivity.this, contactList);
                    listView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ContactList> call, Throwable t) {

                Log.d("Error", t.getMessage());

            }
        });

    }

}
