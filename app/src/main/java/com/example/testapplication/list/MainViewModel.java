package com.example.testapplication.list;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.testapplication.network.AppNetworkFetcher;
import com.example.testapplication.network.FacesApiHttpUrlHelper;
import com.example.testapplication.network.NetworkResponseCallback;
import com.example.testapplication.network.retrofit.RetrofitNetworkFetcher;
import com.example.testapplication.utility.AppConstants;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private static final String TAG = "MainViewModel";
    MutableLiveData<ArrayList<User>> userLiveData;
    private boolean isUsingLibrary = true;
    private AppNetworkFetcher appNetworkFetcher;

    public MainViewModel() {
        userLiveData = new MutableLiveData<>();

        // Creating an object of AppNetworkFetcher. We can use either HttpUrlConnection or some library.
        if (isUsingLibrary) {
            appNetworkFetcher = new RetrofitNetworkFetcher();
        } else {
            appNetworkFetcher = new FacesApiHttpUrlHelper();
        }

        // call your Rest API in init method
        init();
    }

    public MutableLiveData<ArrayList<User>> getUserMutableLiveData() {
        return userLiveData;
    }

    public void init(){
        getData();
    }

    public void getData(){
        // We called out network request method here.
        final String url = AppConstants.UI_FACES_API_URL_BASE + AppConstants.UI_FACES_API_PATH;
        appNetworkFetcher.doGetRequest(url, new NetworkResponseCallback() {
            @Override
            public void onResponseSuccess(ArrayList<User> users) {
                userLiveData.postValue(users);
            }

            @Override
            public void onResponseFailed(Throwable e) {
                Log.d(TAG, "onResponseFailed() called with: e = [" + e + "]");
            }
        });
    }
}
