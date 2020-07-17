package com.example.testapplication;

import android.content.Context;

import android.util.AttributeSet;

import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;




public class CustomView extends RelativeLayout {

    public CustomView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        inflate(context, R.layout.activity_main, this);
    }





    }
