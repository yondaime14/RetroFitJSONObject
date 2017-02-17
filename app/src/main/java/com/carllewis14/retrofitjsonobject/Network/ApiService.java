package com.carllewis14.retrofitjsonobject.Network;

import com.carllewis14.retrofitjsonobject.DataModel.ContactList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Api Service class
 */

public interface ApiService {

    @GET("/json_data.json")
    Call<ContactList> getJSON();
}
