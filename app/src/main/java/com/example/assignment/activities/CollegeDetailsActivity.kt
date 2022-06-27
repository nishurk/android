package com.example.assignment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.assignment.R
/**
 * Display details of college
 */
class CollegeDetailsActivity : AppCompatActivity() {
    lateinit var allCollegeDetails:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_college_details)
        allCollegeDetails=findViewById(R.id.txtCollegeDetails)
        allCollegeDetails.text=intent.getStringExtra("college")
    }
}