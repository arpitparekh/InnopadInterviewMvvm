package com.example.innopadinterviewmvvm.task_one

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isNotEmpty
import androidx.lifecycle.ViewModelProvider
import com.example.innopadinterviewmvvm.databinding.ActivityAddUserDataBinding
import java.time.Month
import java.time.Year
import java.util.*
import kotlin.collections.ArrayList

class AddUserDataActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddUserDataBinding
    lateinit var viewModel : UserViewModel
    var date : String? = null
    var gender : String? = null
    val genderList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        genderList .add("Male")
        genderList.add("Female")

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(UserViewModel::class.java)

        binding.btnDob.setOnClickListener {

            val datePickerDialog = DatePickerDialog(
                this,
                object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(
                        view: DatePicker?,
                        year: Int,
                        month: Int,
                        dayOfMonth: Int
                    ) {

                        binding.btnDob.text = "$dayOfMonth/${month + 1}/$year"
                        date = "$dayOfMonth/${month + 1}/$year"

                    }
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            )

            datePickerDialog.show()

        }

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,genderList)
        binding.spinnerGender.adapter = adapter

        gender =  binding.spinnerGender.selectedItem.toString()

        binding.spinnerGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                gender = genderList[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {


            }
        }

        binding.btnSubmit.setOnClickListener {


            if(binding.edtName.text.toString()!="" &&
                binding.edtSurName.text.toString()!="" &&
                binding.edtEmail.text.toString()!="" &&
                binding.edtPassword.text.toString()!="" &&
                binding.edtPassword.text.toString() == binding.edtConfirmPassword.text.toString()&&
                binding.edtConfirmPassword.text.toString()!="" &&
                binding.edtNumber.text.toString()!="" &&
                gender!=null &&
                date!=null){

                val name = binding.edtName.text.toString()
                val surName = binding.edtSurName.text.toString()
                val email = binding.edtEmail.text.toString()
                val password = binding.edtPassword.text.toString()
                val mobileNumber = binding.edtNumber.text.toString()

                val user = User(name,surName,email,password, date!!,mobileNumber, gender!!)

                viewModel.insertData(user)

                Toast.makeText(this,"Data Added SuccessFully",Toast.LENGTH_SHORT).show()

                startActivity(Intent(this,LoginScreenActivity::class.java))

            }else{

                Toast.makeText(this,"Some of the Fields are Empty",Toast.LENGTH_SHORT).show()
            }

        }




    }
}