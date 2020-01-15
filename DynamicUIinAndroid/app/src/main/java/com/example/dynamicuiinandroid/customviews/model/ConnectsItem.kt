package com.example.dynamicuiinandroid.customviews.model


import com.google.gson.annotations.SerializedName

data class ConnectsItem(

    @field:SerializedName("endSide")
    val endSide: String? = null,

    @field:SerializedName("endId")
    val endId: String? = null,

    @field:SerializedName("startId")
    val startId: String? = null,

    @field:SerializedName("startSide")
    val startSide: String? = null,
    @field:SerializedName("margin")
    val margin: String? = null
)