package com.example.innopadinterviewmvvm.task_one

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(user : User)

    @Query("SELECT * FROM User where id=:id")
    fun show(id : Int) : LiveData<User>

    @Query("SELECT*FROM User WHERE email= :email and password= :password")
    fun verifyData(email: String?, password: String?): User?

    @Query("SELECT id FROM User WHERE email= :email and password= :password")
    fun getId(email: String?, password: String?): Int

    @Query("Select * from User")
    fun getAllUsers() : LiveData<List<User>>

}