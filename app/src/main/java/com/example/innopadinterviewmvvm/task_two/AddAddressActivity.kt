package com.example.innopadinterviewmvvm.task_two

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.innopadinterviewmvvm.databinding.ActivityAddAddressBinding
import com.example.innopadinterviewmvvm.task_one.UserViewModel

class AddAddressActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddAddressBinding
    lateinit var viewModel: AddressViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(
            AddressViewModel::class.java)

        binding.btnSubmit.setOnClickListener {

            val name = binding.edtName.text.toString()
            val number = binding.edtPhoneNumber.toString()
            val address1 = binding.edtAddress.text.toString()
            val address2 = binding.edtAddress2.text.toString()
            val state = binding.edtState.text.toString()
            val zip = binding.edtZip.text.toString()
            val city = binding.edtCity.text.toString()
            val country = binding.edtCountry.text.toString()
            val mail = binding.edtMail.text.toString()
            val id = binding.edtCustomerId.text.toString()


            viewModel.sendData(Person(zip,Integer.parseInt(id),city,country,address1,address2,mail,name,state,number))




        }


    }
}