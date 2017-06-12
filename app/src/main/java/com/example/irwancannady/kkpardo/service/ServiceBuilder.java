package com.example.irwancannady.kkpardo.service;

import com.example.irwancannady.kkpardo.util.ConstanKey;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Irwan Cannady on 5/21/17.
 */

public class ServiceBuilder {

    private ServiceAPI serviceAPI;

    public ServiceBuilder(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstanKey.BASE_URL)
                .client(confgureTimeOut())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serviceAPI = retrofit.create(ServiceAPI.class);
    }

    private OkHttpClient confgureTimeOut(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .build();

        return  okHttpClient;
    }

    public void getDataTimeFromAPI(Callback callback){
        serviceAPI.getDataTime().enqueue(callback);
    }

    public void postDataToAPI(String a, String b, Callback callback){
        serviceAPI.postToAPI(a, b).enqueue(callback);
    }
}
