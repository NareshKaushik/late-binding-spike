package com.example.dynamicuiinandroid.customviews

import android.content.Context
import android.graphics.Color
import android.widget.EditText


class DEPEditText(context: Context, id: Int, label: String = "", color: Int = Color.RED) :
    EditText(context) {


    init {
        this.id = id
        this.setTextColor(color)
        this.hint = label
    }

}