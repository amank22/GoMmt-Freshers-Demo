package com.example.testapplication.list;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.testapplication.network.AppNetworkFetcher;
import com.example.testapplication.network.FacesApiHttpUrlHelper;
import com.example.testapplication.network.NetworkResponseCallback;
import com.example.testapplication.network.retrofit.RetrofitNetworkFetcher;
import com.example.testapplication.utility.AppConstants;

import java.util.ArrayList;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "MainViewModel";
    MutableLiveData<ArrayList<User>> userLiveData;
    private boolean isUsingLibrary = false;
    private AppNetworkFetcher appNetworkFetcher;

    public MainViewModel(@NonNull Application application) {
        super(application);
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
        if (!isInternetConnected()) {
            userLiveData.postValue(null);
            Log.d(TAG, "Internet is not connected");
            return;
        }
        // We called out network request method here.
        final String url = AppConstants.UI_FACES_API_URL_BASE + AppConstants.UI_FACES_API_PATH;
        appNetworkFetcher.doGetRequest(url, new NetworkResponseCallback() {
            @Override
            public void onResponseSuccess(ArrayList<User> users) {
                userLiveData.postValue(users);
            }

            @Override
            public void onResponseFailed(Throwable e) {
                userLiveData.postValue(null);
                Log.d(TAG, "onResponseFailed() called with: e = [" + e + "]");
            }
        });
    }

    boolean isInternetConnected() {
        final ConnectivityManager conMgr = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            // notify user you are online
            return true;
        } else {
            // notify user you are not online
            return false;
        }
    }
}
