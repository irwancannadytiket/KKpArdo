package com.example.irwancannady.kkpardo.service;

import com.example.irwancannady.kkpardo.model.EntityRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Irwan Cannady on 5/21/17.
 */

public interface ServiceAPI {

    public final String END_POINT = "questions" ;

    @GET(END_POINT)
    Call<List<EntityRequest>> getDataTime();

    @POST()
    Call<EntityRequest> postToAPI(@Query("") String a,
                                  @Query("") String b);
}
