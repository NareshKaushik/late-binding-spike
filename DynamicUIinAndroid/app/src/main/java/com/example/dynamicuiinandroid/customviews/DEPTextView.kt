package com.example.dynamicuiinandroid.customviews.viewwithconstaints

import android.content.Context
import android.graphics.Color
import android.widget.TextView
import com.example.dynamicuiinandroid.customviews.model.LayoutItem


class DEPTextView(context: Context, layoutItem: LayoutItem) : TextView(context) {
    init {
        this.id = layoutItem.id!!.toInt()
        this.setTextColor(Color.parseColor(layoutItem.textColor))
        this.text = layoutItem.label
    }
}