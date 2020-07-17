package com.example.testapplication.network.retrofit;

import com.example.testapplication.list.User;
import com.example.testapplication.network.AppNetworkFetcher;
import com.example.testapplication.network.NetworkResponseCallback;
import com.example.testapplication.utility.AppConstants;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNetworkFetcher implements AppNetworkFetcher {

    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AppConstants.UI_FACES_API_URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    public void doGetRequest(String url, final NetworkResponseCallback responseCallback) {
        // https://square.github.io/retrofit/
        final UiFaceService service = retrofit.create(UiFaceService.class);
        final Call<ArrayList<User>> response = service.listFaces();
        response.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, @NotNull Response<ArrayList<User>> response) {
                responseCallback.onResponseSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                responseCallback.onResponseFailed(t);
            }
        });
    }
}
