package com.example.testapplication.utility;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AppConstants {

    public static final String UI_FACES_API_AUTH_HEADER = "X-API-KEY";
    public static final String UI_FACES_API_KEY = "CD214E65-C5D94EC9-97098EFD-2F066C0A";
    public static final String UI_FACES_API_URL = "https://uifaces.co/api?limit=20&emotion[]=happiness";

    public static final ExecutorService executor = Executors.newCachedThreadPool();

}
