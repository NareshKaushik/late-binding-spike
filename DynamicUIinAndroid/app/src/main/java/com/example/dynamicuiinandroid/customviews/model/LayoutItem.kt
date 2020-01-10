package com.example.dynamicuiinandroid.customviews.model


import com.google.gson.annotations.SerializedName


data class LayoutItem(

	@field:SerializedName("background")
	val background: String? = null,

	@field:SerializedName("width")
	val width: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("textColor")
	val textColor: String? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("height")
	val height: String? = null
)