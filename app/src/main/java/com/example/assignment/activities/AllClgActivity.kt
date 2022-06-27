package com.example.assignment.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment.R

/**
 * To Display all the colleges types list
 *
 * CollegesHomeScreen
 * CollegesListActivity
 */
class AllClgActivity : AppCompatActivity() {
    lateinit var listview:ListView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_clg)
        listview=findViewById(R.id.listview)
        val list= intent.getStringArrayListExtra("LIST")
        listview.adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,list!!)

    }
}

