package com.example.innopadinterviewmvvm.task_one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.innopadinterviewmvvm.databinding.ActivityShowUserDataBinding

class ShowUserDataActivity : AppCompatActivity() {
    lateinit var binding : ActivityShowUserDataBinding
    lateinit var viewModel : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowUserDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(UserViewModel::class.java)

        viewModel.getUser(intent.getIntExtra("id",0)).observe(this, Observer {

            binding.obj = it

        })

        viewModel.getAllData().observe(this, Observer {
            val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,it as ArrayList<String>)
            binding.listviewUsers.adapter = adapter

        })


    }
}