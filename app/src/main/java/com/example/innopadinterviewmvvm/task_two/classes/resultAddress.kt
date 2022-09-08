package com.example.innopadinterviewmvvm.task_two

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("Zip")
	val zip: String? = null,

	@field:SerializedName("AddressEmail")
	val addressEmail: String? = null,

	@field:SerializedName("Address")
	val address: String? = null,

	@field:SerializedName("State")
	val state: String? = null,

	@field:SerializedName("AddressContactno")
	val addressContactno: String? = null,

	@field:SerializedName("Address2")
	val address2: String? = null,

	@field:SerializedName("Country")
	val country: String? = null,

	@field:SerializedName("Latitude")
	val latitude: String? = null,

	@field:SerializedName("City")
	val city: String? = null,

	@field:SerializedName("userName")
	val userName: String? = null,

	@field:SerializedName("AddressId")
	val addressId: String? = null,

	@field:SerializedName("Longitude")
	val longitude: String? = null
)

data class ResultAddress(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)
