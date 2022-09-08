package com.example.innopadinterviewmvvm.task_one

import android.content.Context
import androidx.lifecycle.LiveData
import java.util.concurrent.Executors

class UserRepo(context: Context) {

    var userDatabase: UserDatabase? = null

    val executor = Executors.newSingleThreadExecutor()

    init {

        userDatabase =  UserDatabase.getDatabase(context)

    }

    fun insertData(user : User){

        executor.execute(Runnable {
            userDatabase!!.getDao().insertData(user)
        })

    }

    fun getUserData(id : Int) :LiveData<User>{

        return userDatabase!!.getDao().show(id)
    }

    fun verify(email : String,password : String) : User?{

        return userDatabase!!.getDao().verifyData(email,password)

    }

    fun getId(email : String,password : String) : Int{

        return userDatabase!!.getDao().getId(email,password)

    }

    fun getAllData() : LiveData<List<User>>{

        return userDatabase!!.getDao().getAllUsers()
    }


}