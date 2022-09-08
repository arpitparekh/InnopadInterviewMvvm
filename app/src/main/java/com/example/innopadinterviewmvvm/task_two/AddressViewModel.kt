package com.example.innopadinterviewmvvm.task_two

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddressViewModel(application: Application) : AndroidViewModel(application){

    var mutableMyLogLiveData: MutableLiveData<MyLog> = MutableLiveData()
    var mutableMyResultLiveData: MutableLiveData<ResultAddress> = MutableLiveData()
    var api : ApiInterface? =null

    init {
        api =ApiHelper.getApiInstance()
    }

    fun sendData(person : Person){

        val call = api?.sendData(person)

        call?.enqueue(object : Callback<MyLog>{
            override fun onResponse(call: Call<MyLog>, response: Response<MyLog>) {

                mutableMyLogLiveData.postValue(response.body())

            }

            override fun onFailure(call: Call<MyLog>, t: Throwable) {
                Log.i("sendDataError",t.message.toString())
            }

        })

    }
    fun getData(myRequest: MyRequest){

        val call = api?.getAddress(myRequest)

        call?.enqueue(object : Callback<ResultAddress>{
            override fun onResponse(call: Call<ResultAddress>, response: Response<ResultAddress>) {
                mutableMyResultLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<ResultAddress>, t: Throwable) {
                Log.i("sendDataError",t.message.toString())
            }


        })


    }

}