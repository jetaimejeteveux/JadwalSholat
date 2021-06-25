package com.example.jadwalshalat.viewmodel;

import android.util.Log;

import com.example.jadwalshalat.data.model.DataResponse;
import com.example.jadwalshalat.data.model.SholatDiscoverResponse;
import com.example.jadwalshalat.data.remote.ApiMain;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SholatViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<DataResponse>> listDiscoverSholat = new MutableLiveData<>();

    public void setSholatDiscover() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }
        apiMain.getApiSholat().getSholatDiscover().enqueue(new Callback<SholatDiscoverResponse>() {
            @Override
            public void onResponse(Call<SholatDiscoverResponse> call, Response<SholatDiscoverResponse> response) {

                SholatDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getData() != null) {
                    ArrayList<DataResponse> timingsItems = responseDiscover.getData();
                    listDiscoverSholat.postValue(timingsItems);
                }
            }

            @Override
            public void onFailure(Call<SholatDiscoverResponse> call, Throwable t) {
                Log.e("SholatViewModel","onFailure, msg : " + t.getMessage());
            }
        });
    }

    public LiveData<ArrayList<DataResponse>> getSholatDiscover() {
        return listDiscoverSholat;
    }

}
