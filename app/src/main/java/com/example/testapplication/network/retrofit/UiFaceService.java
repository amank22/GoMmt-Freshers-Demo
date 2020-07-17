package com.example.testapplication.network.retrofit;

import com.example.testapplication.list.User;
import com.example.testapplication.utility.AppConstants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface UiFaceService {

    @Headers({
            AppConstants.UI_FACES_API_AUTH_HEADER + ": " + AppConstants.UI_FACES_API_KEY,
    })
    @GET(AppConstants.UI_FACES_API_PATH)
    Call<ArrayList<User>> listFaces();

}
