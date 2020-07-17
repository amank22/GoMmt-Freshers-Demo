package com.example.testapplication.list;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.testapplication.R;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends FragmentActivity implements LifecycleOwner {


    /*
    * RecyclerView - Done
    * Activity
    * ViewModel
    * LiveData
    * */

    MainViewModel viewModel;
    RecyclerView recyclerView;
    private ProgressBar progressBarCenter;


    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_xml);
        recyclerView = findViewById(R.id.rv_main);
        progressBarCenter = findViewById(R.id.progressBarCenter);
        viewModel = ViewModelProviders.of(RecyclerActivity.this).get(MainViewModel.class);
        viewModel.getUserMutableLiveData().observe(RecyclerActivity.this, userListUpdateObserver);

    }


    Observer<ArrayList<User>> userListUpdateObserver = new Observer<ArrayList<User>>() {
        @Override
        public void onChanged(ArrayList<User> userArrayList) {
            recyclerViewAdapter = new RecyclerViewAdapter(RecyclerActivity.this,userArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
            recyclerView.setAdapter(recyclerViewAdapter);
            progressBarCenter.setVisibility(View.GONE);
        }
    };



}
