package com.example.dynamicuiinandroid.customviews

import android.content.Context
import android.graphics.Color
import android.widget.TextView


class DEPTextView(context: Context, id: Int, label: String = "TextView", color: Int = Color.RED) :
    TextView(context) {


    init {
        this.id = id
        this.setTextColor(color)
        this.text = label

    }
}