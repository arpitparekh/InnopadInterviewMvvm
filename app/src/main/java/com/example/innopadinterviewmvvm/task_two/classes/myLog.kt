package com.example.innopadinterviewmvvm.task_two

import com.google.gson.annotations.SerializedName

data class MyLog(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
)
