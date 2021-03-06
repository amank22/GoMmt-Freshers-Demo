package com.example.testapplication.network;

import com.example.testapplication.list.User;

import java.util.ArrayList;

public interface NetworkResponseCallback {

    void onResponseSuccess(ArrayList<User> users);
    void onResponseFailed(Throwable e);

}
