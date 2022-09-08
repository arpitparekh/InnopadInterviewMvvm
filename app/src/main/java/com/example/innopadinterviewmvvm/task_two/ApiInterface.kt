package com.example.innopadinterviewmvvm.task_two

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {

    @POST("projects/restaurant/Webservices/GetAddress")
    @Headers("tokenvalue: FdkKMIfS")
    fun sendData(@Body person : Person) : Call<MyLog>

    @POST("projects/restaurant/Webservices/GetAddress")
    @Headers("tokenvalue: FdkKMIfS")
    fun getAddress(@Body myRequest: MyRequest) : Call<ResultAddress>
}