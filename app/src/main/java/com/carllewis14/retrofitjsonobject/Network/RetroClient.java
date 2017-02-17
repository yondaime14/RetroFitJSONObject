package com.carllewis14.retrofitjsonobject.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by carllewis on 17/02/2017.
 */

public class RetroClient {

    /**
     * URL
     */

    private static String url = "http://pratikbutani.x10.mx/";

    /**
     * Retrofit instance - builds url l
     */

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static ApiService getApiService(){
        return getRetrofitInstance().create(ApiService.class);
    }

}
