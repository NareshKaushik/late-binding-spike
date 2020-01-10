package com.example.dynamicuiinandroid.customviews.model

import com.google.gson.annotations.SerializedName


data class Response(

	@field:SerializedName("layout")
	val layout: List<LayoutItem?>? = null
)