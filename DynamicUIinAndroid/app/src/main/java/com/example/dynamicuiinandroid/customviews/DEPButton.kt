package com.example.dynamicuiinandroid.customviews

import android.content.Context
import android.graphics.Color
import android.widget.Button


class DEPButton(
    context: Context,
    id: Int,
    label: String = "Button",
    color: Int = Color.RED,
    background: Int = Color.WHITE
) : Button(context) {


    init {
        this.id = id
        this.setTextColor(color)
        this.setBackgroundColor(background)
        this.text = label
    }

}