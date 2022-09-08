package com.example.innopadinterviewmvvm.task_one

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.innopadinterviewmvvm.databinding.ActivityLoginScreenBinding

class LoginScreenActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginScreenBinding
    lateinit var viewModel : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(UserViewModel::class.java)

        binding.btnLogin.setOnClickListener {

            if(binding.edtEmail.text.toString() == "" && binding.edtPassword.text.toString() == ""){

                Toast.makeText(this,"Empty Field",Toast.LENGTH_SHORT).show()

            }else{

                if(viewModel.verify(binding.edtEmail.text.toString(),binding.edtPassword.text.toString()) !=null){

                    val intent = Intent(this,ShowUserDataActivity::class.java)
                    intent.putExtra("id",viewModel.getId(binding.edtEmail.text.toString(),binding.edtPassword.text.toString()))
                    startActivity(intent)

                }

            }

        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this,AddUserDataActivity::class.java))
        }

    }
}