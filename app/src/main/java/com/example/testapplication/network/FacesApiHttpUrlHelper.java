package com.example.testapplication.network;

import androidx.annotation.WorkerThread;

import com.example.testapplication.list.User;
import com.example.testapplication.utility.AppConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * This class uses HttpURLConnection to get data from server.
 * We will fetch data from UiFaces Api.
 */
public class FacesApiHttpUrlHelper implements AppNetworkFetcher {

    @Override
    public void doGetRequest(final String urlString, final NetworkResponseCallback responseCallback) {
        // So we can only run network calls on background thread and not on main thread.
        // We could use AsyncTasks but they are deprecated so we are using Executors.
        new Thread(new Runnable() {
            @Override
            public void run() {
                startGetRequest(urlString, responseCallback);
            }
        }).start();
    }

    private void startGetRequest(String urlString, NetworkResponseCallback responseCallback) {
        try {
            // Try & get the string response from the api
            final String response = getStringResponseFromApi(urlString);
            // We got the response. We need to convert it to list of Users. This is a Json and we can
            // use a JSON parsing utility.
            final ArrayList<User> list = parseStringJsonToUsers(response);
            responseCallback.onResponseSuccess(list);
        } catch (Exception e) {
            // We got an exception. Let's catch it and tell the callback that we failed
            responseCallback.onResponseFailed(e);
        }
    }

    /**
     * This is the actual method that do the network call.
     *
     * @param urlString url to call
     */
    @WorkerThread
    private String getStringResponseFromApi(String urlString) throws Exception {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(urlString);
            // Opens a new connection to this URL. Does a network call
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty(AppConstants.UI_FACES_API_AUTH_HEADER, AppConstants.UI_FACES_API_KEY);
            // Gets a response code
            int code = urlConnection.getResponseCode();
            // We are happy with 200 else throw an error of invalid response.
            if (code != 200) {
                throw new IOException("Invalid response from server: " + code);
            }
            // Reading the data that we get from the opened connection
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String line;
            // We will be appending data in a StringBuilder and will return the String data we got.
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    /**
     * We will do json parsing here. Convert string into actual java objects.
     * @param response string response from api
     * @return a arraylist of User objects.
     */
    private ArrayList<User> parseStringJsonToUsers(String response) {
        // Create an object of gson. A Google json parsing library.
        final Gson gson = new Gson();
        // We need to convert the json to an array list so using this typeToken. Library stuff.
        final Type userTypeToken = new TypeToken<ArrayList<User>>() {
        }.getType();
        // Let's roll. Do the actual stuff.
        ArrayList<User> list = gson.fromJson(response, userTypeToken);
        return list;
    }

}
