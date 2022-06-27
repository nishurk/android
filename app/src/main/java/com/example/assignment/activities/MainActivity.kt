package com.example.assignment.activities

import com.example.assignment.adapters.CollegeAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.interfaces.ApiInterface
import com.example.assignment.models.CollegeHome
import com.example.assignment.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    lateinit var allCollegeAdapter: CollegeAdapter
    lateinit var topCollegeAdapter: CollegeAdapter
    lateinit var worstCollegeAdapter: CollegeAdapter
    lateinit var allLinearLayoutManager:LinearLayoutManager
    lateinit var topLinearLayoutManager:LinearLayoutManager
    lateinit var worstLinearLayoutManager:LinearLayoutManager
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        worstLinearLayoutManager= LinearLayoutManager(this)
        binding.worstClg.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        topLinearLayoutManager= LinearLayoutManager(this)
        binding.topClg.layoutManager=topLinearLayoutManager

        allLinearLayoutManager= LinearLayoutManager(this)
        binding.allClg.layoutManager=allLinearLayoutManager
        binding.topClg.setHasFixedSize(true)
        binding.allClg.setHasFixedSize(true)
        binding.worstClg.setHasFixedSize(true)
        getData()
    }

    private fun getData() {
        val apiInterface = ApiInterface.create().getUser()

        apiInterface.enqueue(object : Callback<CollegeHome> {
            override fun onResponse(call: Call<CollegeHome>, response: Response<CollegeHome>) {

                if (response.body() != null) {
                    val data = response.body()?.data
                    val topColleges= data?.topColleges
                    val allColleges = data?.allColleges
                    val worstColleges = data?.worstCollege
                    Log.d(TAG,topColleges.toString() )
                    Log.d(TAG,allColleges.toString() )
                    Log.d(TAG,worstColleges.toString() )

                    allCollegeAdapter= allColleges?.let { CollegeAdapter(this@MainActivity,it) }!!
                    binding.allClg.adapter=allCollegeAdapter
                    topCollegeAdapter= topColleges?.let { CollegeAdapter(this@MainActivity,it) }!!
                    binding.topClg.adapter=topCollegeAdapter
                    worstCollegeAdapter= worstColleges?.let { CollegeAdapter(this@MainActivity,it) }!!
                    binding.worstClg.adapter=worstCollegeAdapter

                    binding.btnClgs.setOnClickListener{
                        val intent=Intent(applicationContext, AllClgActivity::class.java)
                        val arr : ArrayList<String> = ArrayList()
                        for(i in allColleges.indices){
                            arr.add(allColleges[i].name)
                        }
                        intent.putExtra("LIST",arr)
                        startActivity(intent)
                    }
//
                }
            }

            override fun onFailure(call: Call<CollegeHome>, t: Throwable) {
                Log.d("MainActivity", "onFailure" + t.message)
            }
        })
    }
}