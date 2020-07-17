package com.example.testapplication.network;

import com.example.testapplication.list.User;

import java.util.ArrayList;

/**
 * This is the base interface for the network call.
 * We could make a generic class but for the simplicity we are returning direct user list.
 * We are using interface because we will be implementing this api in different ways. (Using android native class
 * and simplifying the process by using a library)
 */
public interface AppNetworkFetcher {

    /**
     * This fetches the users list from ui-faces api
     * @param url endpoint
     * @param responseCallback callback will be given back to calling method on completion
     */
    void doGetRequest(String url, NetworkResponseCallback responseCallback);
}
