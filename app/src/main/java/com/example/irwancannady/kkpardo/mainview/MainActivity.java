package com.example.irwancannady.kkpardo.mainview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.irwancannady.kkpardo.R;
import com.example.irwancannady.kkpardo.adapter.AdapterMain;
import com.example.irwancannady.kkpardo.databinding.ActivityMainBinding;
import com.example.irwancannady.kkpardo.model.EntityRequest;
import com.example.irwancannady.kkpardo.service.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private ServiceBuilder serviceBuilder;
    private List<EntityRequest> mEntityReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setView();
        getData();
//        postData();
        checkConnection();
    }

    private void checkConnection(){
    }

    private void setView(){
        mBinding.listItem.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mBinding.listItem.setLayoutManager(layoutManager);
    }

    private void getData(){
        serviceBuilder = new ServiceBuilder();
        serviceBuilder.getDataTimeFromAPI(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()){
                    mEntityReq = (List<EntityRequest>) response.body();
                    mBinding.listItem.setAdapter(new AdapterMain(mEntityReq, getApplicationContext()));
                }
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
