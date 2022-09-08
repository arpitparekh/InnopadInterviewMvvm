package com.example.innopadinterviewmvvm.task_one

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class UserViewModel(application: Application) : AndroidViewModel(application) {

    var repo: UserRepo

    init {

        repo = UserRepo(application)

    }

    fun insertData(user : User){

        repo.insertData(user)
    }

    fun getUser(id : Int): LiveData<User> {
        return repo.getUserData(id)
    }

    fun verify(email : String,password : String) : User?{

        return repo.verify(email,password)

    }

    fun getId(email : String,password : String) : Int{

        return repo.getId(email,password)

    }

    fun getAllData() : LiveData<List<User>>{

        return repo.getAllData()
    }



}