package com.richardflor.richardsymbian.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    /** MÉTODO DE ACESSO AO CLIENT **/
    public static Retrofit getClient(String url){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if(retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }

        return retrofit;

    }

}