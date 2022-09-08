package com.example.innopadinterviewmvvm.task_one

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
public abstract class UserDatabase : RoomDatabase() {

    abstract fun getDao() : UserDao

    companion object{

        var userDatabase : UserDatabase? = null

        fun getDatabase(context : Context) : UserDatabase?{

            if(userDatabase==null){

                userDatabase = Room.databaseBuilder(context,UserDatabase::class.java,"UserDatabase")
                    .allowMainThreadQueries()
                    .build()

                return userDatabase

            }

            return userDatabase

        }

    }

}