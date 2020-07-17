package com.example.testapplication.network;

import com.example.testapplication.list.User;

import java.util.ArrayList;

public interface AppNetworkFetcher {
    ArrayList<User> doGetRequest(String url, NetworkResponseCallback responseCallback);
}
