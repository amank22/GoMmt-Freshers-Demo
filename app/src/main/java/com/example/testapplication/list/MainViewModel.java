package com.example.testapplication.list;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    MutableLiveData<ArrayList<User>> userLiveData;

    public MainViewModel() {
        userLiveData = new MutableLiveData<>();
        // call your Rest API in init method
        init();
    }

    public MutableLiveData<ArrayList<User>> getUserMutableLiveData() {
        return userLiveData;
    }

    public void init(){
        ArrayList<User>  userArrayList = getData();
        userLiveData.setValue(userArrayList);
    }

    public ArrayList<User> getData(){

        User user = new User();
        user.setTitle("Darknight");
        user.setDescription("Best rating movie");

        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(user);
        userArrayList.add(user);
        userArrayList.add(user);
        userArrayList.add(user);
        userArrayList.add(user);
        userArrayList.add(user);

        return userArrayList;
    }
}
