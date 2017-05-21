package com.example.irwancannady.kkpardo.mainview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.irwancannady.kkpardo.R;
import com.example.irwancannady.kkpardo.service.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ServiceBuilder serviceBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setView(){

    }

    private void getData(){
        serviceBuilder = new ServiceBuilder();
        serviceBuilder.getDataTimeFromAPI(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }

    private void postData(){
        serviceBuilder = new ServiceBuilder();
        serviceBuilder.postDataToAPI("", "", new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}
