package com.example.innopadinterviewmvvm.task_two

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelper {

    companion object{

        var api : ApiInterface? = null

        fun getApiInstance() : ApiInterface?{

            if(api==null){

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://innopadsolutions.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                return retrofit.create(ApiInterface::class.java)

            }

            return api


        }

    }

}