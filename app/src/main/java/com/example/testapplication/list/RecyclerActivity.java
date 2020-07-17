package com.example.testapplication.list;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.testapplication.R;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class RecyclerActivity extends FragmentActivity implements LifecycleOwner {


    /*
    * RecyclerView - Done
    * Activity
    * ViewModel
    * LiveData
    * */

    MainViewModel viewModel;
    RecyclerView recyclerView;



    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_xml);
        recyclerView = findViewById(R.id.rv_main);
        viewModel = ViewModelProviders.of(RecyclerActivity.this).get(MainViewModel.class);
        viewModel.getUserMutableLiveData().observe(RecyclerActivity.this, userListUpdateObserver);

    }


    Observer<ArrayList<User>> userListUpdateObserver = new Observer<ArrayList<User>>() {
        @Override
        public void onChanged(ArrayList<User> userArrayList) {
            recyclerViewAdapter = new RecyclerViewAdapter(RecyclerActivity.this,userArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
            recyclerView.setAdapter(recyclerViewAdapter);
        }
    };



}
