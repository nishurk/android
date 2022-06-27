package com.example.assignment.interfaces

import com.example.assignment.models.CollegeHome
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * get request from mocked api of colleges

 */

interface ApiInterface {

    @GET("colleges")
    fun getUser() : Call<CollegeHome>

    companion object {

        var BASE_URL = "https://62b409984f851f87f463549a.mockapi.io/v1/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}