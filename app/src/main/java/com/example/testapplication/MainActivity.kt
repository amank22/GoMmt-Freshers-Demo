package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {


/*
    1. View Group, View
    2. Declare / use view in xml files
    3. Refer a view  in Java/kotlin code
    4. Layout Params/properties for Views
    1. https://developer.android.com/guide/topics/ui/declaring-layout
    5. List vIew / Recycler View
    1.  https://developer.android.com/guide/topics/ui/layout/recyclerview
    6. Layout and resources for different OS and devices

    Life Cycle of view
    onMeasure
    onLayout
    onDraw

    */


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        this.findViewById<TextView>(R.id.firstTextView).setText("Updated text");


         /*
         * find LinearLayout
         * Iterate your list
         * Create TextView Object // set value to text view
         * add text view as child of Linear layout
         * */




    }




    }







