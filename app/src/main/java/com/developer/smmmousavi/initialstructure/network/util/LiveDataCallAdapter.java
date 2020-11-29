package com.developer.smmmousavi.initialstructure.network.util;

import com.developer.smmmousavi.initialstructure.network.response.ApiResponse;

import java.lang.reflect.Type;

import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataCallAdapter<R> implements CallAdapter<R, LiveData<ApiResponse<R>>> {

    private Type mResponseType;

    public LiveDataCallAdapter(Type responseType) {
        mResponseType = responseType;
    }

    @Override
    public Type responseType() {
        return mResponseType;
    }

    @Override
    public LiveData<ApiResponse<R>> adapt(Call<R> call) {

        return new LiveData<ApiResponse<R>>() {
            @Override
            protected void onActive() {
                super.onActive();
                final ApiResponse apiResponse = new ApiResponse();
                call.enqueue(new Callback<R>() {
                    @Override
                    public void onResponse(Call<R> call, Response<R> response) {
                        postValue(apiResponse.create(response));
                    }

                    @Override
                    public void onFailure(Call<R> call, Throwable t) {
                        postValue(apiResponse.create(t));

                    }
                });
            }
        };
    }
}
