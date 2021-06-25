package com.example.jadwalshalat.data.remote;
import com.example.jadwalshalat.data.model.SholatDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface SholatService {

    @GET("v1/calendarByAddress?address=Jakarta,Indonesia&method=2&month=01&year=2020")
    Call<SholatDiscoverResponse> getSholatDiscover();


}


