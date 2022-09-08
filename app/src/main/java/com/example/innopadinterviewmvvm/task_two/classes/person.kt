package com.example.innopadinterviewmvvm.task_two

import com.google.gson.annotations.SerializedName

data class Person(

	@field:SerializedName("ZIP")
	val zIP: String? = null,

	@field:SerializedName("CUSTOMERID")
	val cUSTOMERID: Int? = null,

	@field:SerializedName("CITY")
	val cITY: String? = null,

	@field:SerializedName("COUNTRY")
	val cOUNTRY: String? = null,

	@field:SerializedName("ADDRESS")
	val aDDRESS: String? = null,

	@field:SerializedName("Address2")
	val address2: String? = null,

	@field:SerializedName("ADDRESSEMAIL")
	val aDDRESSEMAIL: String? = null,

	@field:SerializedName("USERNAME")
	val uSERNAME: String? = null,

	@field:SerializedName("STATE")
	val sTATE: String? = null,

	@field:SerializedName("ADDRESSPHONENUMBER")
	val aDDRESSPHONENUMBER: String? = null
)
