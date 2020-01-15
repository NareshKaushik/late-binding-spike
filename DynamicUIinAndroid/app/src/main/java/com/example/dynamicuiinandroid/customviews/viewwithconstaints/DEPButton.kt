package com.example.dynamicuiinandroid.customviews.viewwithconstaints

import android.content.Context
import android.graphics.Color
import android.widget.Button
import com.example.dynamicuiinandroid.customviews.model.LayoutItem


class DEPButton(context: Context, layoutItem: LayoutItem, background: Int = Color.WHITE) :
    Button(context) {


    init {
        this.id = layoutItem.id!!.toInt()
        this.setTextColor(Color.parseColor(layoutItem.textColor))
        this.setBackgroundColor(background)
        this.text = layoutItem.label

    }

}