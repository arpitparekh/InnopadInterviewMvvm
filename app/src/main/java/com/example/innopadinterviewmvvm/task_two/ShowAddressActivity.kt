package com.example.innopadinterviewmvvm.task_two

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.innopadinterviewmvvm.databinding.ActivityShowAddressBinding

class ShowAddressActivity : AppCompatActivity() {
    lateinit var binding : ActivityShowAddressBinding
    lateinit var viewModel: AddressViewModel
    var addresses : ArrayList<DataItem?>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addresses = ArrayList()

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(
            AddressViewModel::class.java)

        binding.btnSearch.setOnClickListener {

            viewModel.getData(MyRequest(binding.edtId.text.toString()))

        }
        viewModel.mutableMyResultLiveData.observe(this, Observer {

            val address = it

            addresses = address.data as ArrayList<DataItem?>?

            if(addresses!=null){

                val adapter = ArrayAdapter<DataItem>(this,android.R.layout.simple_list_item_1,
                    addresses!!
                )

                binding.listViewAddress.adapter = adapter

            }
        })

        binding.addAddress.setOnClickListener {
            startActivity(Intent(this@ShowAddressActivity,AddAddressActivity::class.java))
        }
    }
}